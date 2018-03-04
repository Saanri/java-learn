package com.epam.topic9.task5;

/**
 * Created by Timofey_Ryuzhov on 6/8/2016.
 */
/*OPTIONAL.
* Доработать приложение Mp3Downloader из topic8.
* Добавить многопоточную загрузку с ограничением одновременного количества работающих потоков
* а) С помощью ExecutorService
* б) с помощью Семафора
* */
public class Main {

    public static void main(String[] args) {
        Mp3Downloader myCoolDownloader = new Mp3Downloader();

        //
        myCoolDownloader.setDirectoryPath("C:/Music/Scorpions/");
        myCoolDownloader.setSongsNumber(10);
        myCoolDownloader.setSearchString("Scorpions");
        myCoolDownloader.setThreadCount(3);
        myCoolDownloader.setMethodSave(1);
        myCoolDownloader.download();

        //
        myCoolDownloader.setDirectoryPath("C:/Music/ILVT/");
        myCoolDownloader.setSongsNumber(10);
        myCoolDownloader.setSearchString("ILVT");
        myCoolDownloader.setThreadCount(3);
        myCoolDownloader.setMethodSave(2);
        myCoolDownloader.download();

    }
}
