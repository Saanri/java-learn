package com.epam.topic8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Timofey_Ryuzhov on 5/23/2016.
 */
/* REQUIRED
Приложение Simple Calculator
 * Программа ожидает от пользователя ввода простейшего арифметического выражения из натуральных чисел (optional: любых чисел)
   и нуля (сложение, вычитание, умножение, деление) и по Enter выводит результат на экран
 * При вводе допускаются пробелы
Примеры:
Input: 342   +    345
Output: 687
Input: 34  -34
Output: 0
Input:     2 * 2
Output:4
Input: 2/0 (или 2:0)
Error: Dividing by zero
Input: 100/8 (или 100:8)
Output: 12.5
Input: wake up Neo
Error: Not a number
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите простейшее арифметическое выражение из натуральных чисел:");
        System.out.println(SimpleCalculator.calculate(bufferedReader.readLine()));
    }
}
