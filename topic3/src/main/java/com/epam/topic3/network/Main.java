package com.epam.topic3.network;

import java.util.ArrayList;

/**
 * Created by Timofey_Ryuzhov on 3/28/2016.
 */
public class Main {
    public static void main(String[] args) {
        Message message1 = new Message("Иван", "Петр", "Петр, Привет!");
        Message message2 = new Message("Иван", "Петр", "Смотри что я нашел!!!");

        GifImage.logInfoClass();
        JpegImage.logInfoClass();
        Video.logInfoClass();
        Audio.logInfoClass();

        GifImage gifImage1 = new GifImage("Cool_Image");
        JpegImage jpegImage1 = new JpegImage("Cool_Image");
        Video video1 = new Video("Cool_Video.AVI","Cool video");
        Audio audio1 = new Audio("Cool_Audio.mp3","Cool group","Cool song");

        gifImage1.preview();
        jpegImage1.preview();
        video1.playMediaFile();
        audio1.playMediaFile();
        //gifImage1.delete();
        //jpegImage1.delete();

        Message message3 = new Message("Петр", "Иван", "И правда круто! Загружу все себе.");
        gifImage1.download();
        jpegImage1.download();
        video1.downloadMediaFile();
        audio1.downloadMediaFile();

        ArrayList<Object> objectsFromPost = new ArrayList<Object>();
        objectsFromPost.add(gifImage1);
        objectsFromPost.add(jpegImage1);
        objectsFromPost.add(video1);
        objectsFromPost.add(audio1);

        Post post1 = new Post("Петр"
                , "Классный контент!"
                , "Ребята, всем привет!\n  Хочу поделится с вами этим классным контентом!!\n  Смотрим, комментируем!"
                , objectsFromPost
        );

        post1.addComment("Василий","Спасибо!");
        post1.addComment("Николай","Норм.");
        post1.addComment("Иван","Могу загрузить еще!");
        post1.addComment("Сергей","Загружай!");

        post1.addObject(new GifImage("New_Cool_Image"));
        post1.addObject(new JpegImage("New_Cool_Image"));
        post1.addObject(new Video("New_Cool_Video.AVI","New Cool video"));
        post1.addObject(new Audio("New_Cool_Audio.mp3","New Cool group","New Cool song"));

        post1.addComment("Иван","загрузил...");
        post1.addComment("Сергей","Круть!");


        //Message message4 = new Message("Иван", "Петр", "Вот еще крутое видео, и песня к нему :)");

        //post1.addObject();


    }
}
