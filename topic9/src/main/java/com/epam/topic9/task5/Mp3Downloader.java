package com.epam.topic9.task5;

import com.epam.topic7.LogFactory;
import com.epam.topic8.task3.Song;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Timofey_Ryuzhov on 6/8/2016.
 */
public class Mp3Downloader {
    private static Logger logger = LogFactory.getLogger(Mp3Downloader.class.getName());

    private enum MethodSave {ExecutorService, Semaphore, Unknown}

    private String searchString;
    private int songsNumber;
    private String directoryPath;
    private int threadCount;
    private MethodSave methodSave;

    private class SaveSongCallable implements Callable<String> {
        private String songName;
        private String fileName;
        private String songUrl;

        public SaveSongCallable(Song song) {
            this.songName = song.getName();
            this.fileName = song.getFileName();
            this.songUrl = song.getUrl();
        }

        @Override
        public String call() throws Exception {
            logger.info("Start download: " + songName);

            try {
                URL url = new URL(songUrl);
                try (InputStream in = url.openStream();
                     OutputStream out = new BufferedOutputStream(new FileOutputStream(directoryPath + fileName))) {
                    for (int b; (b = in.read()) != -1; ) {
                        out.write(b);
                    }
                    return "Song <<" + songName + ">> - downloaded";
                }
            } catch (IOException e) {
                return "IOException - " + e.getMessage();
            }
        }
    }

    private class SaveSongRunnable implements Runnable {
        private String songName;
        private String fileName;
        private String songUrl;

        private Semaphore semaphore;

        public SaveSongRunnable(Song song, Semaphore semaphore) {
            this.songName = song.getName();
            this.fileName = song.getFileName();
            this.songUrl = song.getUrl();
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                logger.info("Start download: " + songName);
                semaphore.acquire();
                URL url = new URL(songUrl);
                try (InputStream in = url.openStream();
                     OutputStream out = new BufferedOutputStream(new FileOutputStream(directoryPath + fileName))) {
                    for (int b; (b = in.read()) != -1; ) {
                        out.write(b);
                    }
                    logger.info("Song <<" + songName + ">> - downloaded");
                    return;
                }
            } catch (IOException e) {
                logger.info("IOException - " + e.getMessage());
            } catch (InterruptedException e) {
                logger.info("InterruptedException - " + e.getMessage());

            } finally {
                semaphore.release();
            }
        }
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public void setSongsNumber(int songsNumber) {
        this.songsNumber = songsNumber;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public void setMethodSave(int methodSave) {
        this.methodSave = methodSave == 1 ? MethodSave.ExecutorService : methodSave == 2 ? MethodSave.Semaphore : MethodSave.Unknown;
    }

    private void downloadExecutorService(Map<String, Song> songs) throws InterruptedException {
        logger.info("Songs download. Process start!");

        List<Future<String>> futureList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (HashMap.Entry<String, Song> entry : songs.entrySet()) {
            SaveSongCallable saveSong = new SaveSongCallable(entry.getValue());

            Future<String> f = executorService.submit(saveSong);
            futureList.add(f);
        }
        executorService.shutdown();

        logger.info("Executor service - shutdown.");
        Thread.sleep(300);

        for (Future<String> f : futureList)
            try {
                logger.info(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

    }

    private void downloadSemaphore(Map<String, Song> songs) throws InterruptedException {
        logger.info("Songs download. Process start!");

        Semaphore semaphore = new Semaphore(threadCount);
        for (HashMap.Entry<String, Song> entry : songs.entrySet()) {
            Thread thread = new Thread(new SaveSongRunnable(entry.getValue(), semaphore));
            thread.start();
        }

        logger.info("All thread run");
    }

    public void download() {
        logger.info("Download on method " + methodSave + " (" + methodSave + ")");

        try {
            Document doc = Jsoup
                    .connect("http://mp3.cc/search/a/" + searchString + "/")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36")
                    .timeout(5000)
                    .get();
            Elements metaElements = doc.select(".track");
            Map<String, Song> songs = new HashMap<>();

            if (songsNumber > metaElements.size()) songsNumber = metaElements.size();

            logger.info("Create song list for download:");
            for (Element metaElement : metaElements) {
                String attr = metaElement.attr("data-mp3");

                String songName = attr.replaceFirst(".*/(\\w+)", "$1");
                String songFileName = songName;
                int i = 0;
                while (songs.containsKey(songFileName))
                    songFileName = songName + "(" + ++i + ")";

                Song song = new Song(attr, songName, songFileName);

                songs.put(song.getFileName(), song);
                logger.info("Song <<" + songName + ">> " + (i == 0 ? "" : "(" + i + ")") + " save in download List.");

                if (songs.size() >= songsNumber) break;
            }

            if (methodSave == MethodSave.ExecutorService) downloadExecutorService(songs);
            else if (methodSave == MethodSave.Semaphore) downloadSemaphore(songs);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
