package com.epam.topic8.task3;

/**
 * Created by Timofey_Ryuzhov on 5/19/2016.
 */
// OPTIONAL
/* Приложение Mp3Downloader
* Есть сайт mp3.cc
* На вход программы подается:
   * поисковый запрос
   * количество мелодий для скачивания (но не более, чем выводится на первой странице)
   * директория сохранения файлов
* Приложение скачивает и сохраняет на диск все мелодии со страницы, которую выдает поисковый запрос
* Tip: старайтесь реализовать принцип Single Responsibility
* Можно использовать библиотеку Jsoup, добавленную в build.gradle
* (Optional) Add unit-test to test different app components (e.g. links selector)
* (Optional) Add multi-threading implementing Runnable interface
* Programming TIPS

 Document doc = null;
       try {
           doc = Jsoup.connect("http://mp3.cc/search/a/SCORPIONS/")
                   .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36")
                   .timeout(5000)
                   .get();
  .......
 Elements metaElements = doc.select(".track");
 for (Element metaElement : metaElements) {
           String attr = metaElement.attr("data-mp3");
           Song song = new Song();*/
//         song.setFileName(attr.replaceFirst(".*/(\\w+)","$1"));
/*         song.setUrl(attr);  // now you have the URL for  direct downloading
           songs.add(song);
        }

* */

public class Main {
    public static void main(String[] args) {
        Downloader myCoolDownloader = new Downloader();
        myCoolDownloader.setDirectoryPath("C:/Music/Scorpions/");
        myCoolDownloader.setSongsNumber(20);
        myCoolDownloader.setSearchString("IFK");
        myCoolDownloader.download();
    }
}
