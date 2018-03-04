package com.epam.topic7.task3;

import com.epam.topic7.LogFactory;
import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 5/3/2016.
 */
/* OPTIONAL
* Приложение Матрешка
* Дан интерфейс Containable, который описывает поведение объектов - контейнеров.
* Дана заготовка класса матрешка, который хранит вложенную матрешку.
* У матрешки есть размер. При размере > 1 матрешка содержит другую матрешку, при размере = 1 матрешка содержит в себе Черную жемчужину!
* Матрешка и черная жемчужина имплементирует интерфейс Containable
* У матрешки есть цена. Цена каждой вложенной матрешки - на 10% меньше, чем "старшей". Цена жемчужины - в 10 раз больше,
* чем матрешки, в которой она непосредственно содержится
* Необходимо:
* 1. Реализовать классы метрешки и черной жемчужины.
* 2. Вывести в лог процесс распаковки матрешки (пример вывода указан)
* 3. Вывести в лог стоимость набора матрешек (например, из 8-ми)
* */
public class Main {
    private static Logger logger = LogFactory.getLogger(Matryoshka.class.getName());

    public static void main(String[] args) {
        Containable matryoshka = new Matryoshka(8, 100 /*somePrice*/); // randomColor перенс в класс Matryoshka как метод
        logger.info(matryoshka.unpack("Unpack: \n"));
        logger.info("Cost: " + matryoshka.getCost());
    }
}
