package com.epam.topic6.task1;

/**
 * Created by Timofey_Ryuzhov on 4/19/2016.
 */
/* 1. Объявите deprecatedMethod() в DeprecatedClass, как "устаревший"
*  2. Подавите предупреждение об "устаревшем методе в main
*  3. Выполните Compile "Main.java" и убедитесь, что warning не выводится
* */
// REQUIRED TASK
public class Main {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        DeprecatedClass deprecated = new DeprecatedClass();

        deprecated.deprecatedMethod();
        deprecated.notDeprecatedMethod();
    }

}
