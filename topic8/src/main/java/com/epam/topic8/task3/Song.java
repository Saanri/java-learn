package com.epam.topic8.task3;

/**
 * Created by Timofey_Ryuzhov on 5/19/2016.
 */
public class Song {

    private String url;
    private String name;
    private String fileName;

    public Song(String url, String name, String fileName) {
        setUrl(url);
        setName(name);
        setFileName(fileName);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
