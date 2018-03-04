package com.epam.topic4.task1;

import com.epam.topic4.LogFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Timofey_Ryuzhov on 4/4/2016.
 */
/* Реализовать класс, который генерирует список персонажей из ваших любимых фильмов с перемешанными именами и фамилиями. Вывести список на экран.
Реализовать метод, который обходит список по кругу и вычеркивает каждого второго участника и выводит его на экран,
В общем напоминает игру на вылет, элементы списка встают в круг и каждый второй выбывает. Продолжается до тех пор, пока не останется 1.
Печатаем по очереди вылетевших и в конце последнего
 */

public class HeroList {
    protected static LogFactory logFactory = new LogFactory("com.epam.topic4.task1.HeroList");
    protected static Logger logger = logFactory.getLogger();

    private final String[] firstNames = {"Тонни", "Луи", "Оби-Ван", "Нейтон", "Кот", "Иван", "Евгений"};
    private final String[] secondNames = {"Сопрано", "Андерсон", "Кеноби", "Альгрен", "Матроскин", "Тимофеев", "Трошкин"};

    private ArrayList<String> heroList;

    public void setHeroList(ArrayList<String> heroList) {
        this.heroList = heroList;
    }

    public String generateList() {
        ArrayList<String> firstNamesList = new ArrayList<String>();
        ArrayList<String> secondNamesList = new ArrayList<String>();

        Collections.addAll(firstNamesList, firstNames);
        Collections.addAll(secondNamesList, secondNames);

        Collections.shuffle(firstNamesList);
        Collections.shuffle(secondNamesList);

        heroList = new ArrayList<String>();

        for (int i = 0; i < (int) (firstNamesList.size() + secondNamesList.size()) / 2; i++) {
            heroList.add(firstNamesList.get(i) + " " + secondNamesList.get(i));
        }

        return heroList.toString();
    }

    public String everySecondExcluded() {
        int i = 0;

        while (heroList.size() > 1) {
            Iterator<String> iterator = heroList.iterator();
            String str;

            while (iterator.hasNext()) {
                str = iterator.next();

                if (i == 1) {
                    logger.info("Process...: Из списка вычеркнут <<" + str + ">>");
                    iterator.remove();
                    iterator.next();
                    i = 0;
                } else i = 1;

                if (iterator.hasNext()) {
                    str = iterator.next();
                    logger.info("Process...: Из списка вычеркнут <<" + str + ">>");
                    iterator.remove();
                    i = 0;
                }
            }
        }

        return heroList.toString();
    }
}