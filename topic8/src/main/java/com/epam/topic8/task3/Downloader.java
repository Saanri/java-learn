package com.epam.topic8.task3;

import com.epam.topic7.LogFactory;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Timofey_Ryuzhov on 5/23/2016.
 */
public class Downloader {
    private static Logger logger = LogFactory.getLogger(Downloader.class.getName());

    private String searchString;
    private int songsNumber;
    private String directoryPath;

    private class SaveSong extends Thread {
        private String songName;
        private String songUrl;

        public SaveSong(Song song) {
            this.songName = song.getFileName();
            this.songUrl = song.getUrl();
        }

        @Override
        public void run() {
            try {
                URL url = new URL(songUrl);
                try (InputStream in = url.openStream();
                     OutputStream out = new BufferedOutputStream(new FileOutputStream(directoryPath + songName))) {
                    for (int b; (b = in.read()) != -1; ) {
                        out.write(b);
                    }
                    logger.info("Song downloaded - <<" + songName + ">>");
                }
            } catch (IOException e) {
                logger.info(e.getMessage());
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

    public void download() {
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

            logger.info("Songs download. Process start!");
            for (HashMap.Entry<String, Song> entry : songs.entrySet()) {
                logger.info("Start download: " + entry.getValue().getName());
                SaveSong saveSong = new SaveSong(entry.getValue());
                saveSong.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

