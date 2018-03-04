package com.epam.topic2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Timofey_Ryuzhov on 3/20/2016.
 */
// Convert the given number into a roman numeral
// http://www.mathsisfun.com/roman-numerals.html
public class Task8Roman extends AbstractTask {

    //  Only change code below this line
    private String convert(int number) {
        String res = "";

        Map<Integer, String> romanNumMap = new HashMap<Integer, String>();
        romanNumMap.put(1, "I");
        romanNumMap.put(2, "II");
        romanNumMap.put(3, "III");
        romanNumMap.put(4, "IV");
        romanNumMap.put(5, "V");
        romanNumMap.put(6, "VI");
        romanNumMap.put(7, "VII");
        romanNumMap.put(8, "VIII");
        romanNumMap.put(9, "IX");
        romanNumMap.put(10, "X");
        romanNumMap.put(20, "XX");
        romanNumMap.put(30, "XXX");
        romanNumMap.put(40, "XL");
        romanNumMap.put(50, "L");
        romanNumMap.put(60, "LX");
        romanNumMap.put(70, "LXX");
        romanNumMap.put(80, "LXXX");
        romanNumMap.put(90, "XC");
        romanNumMap.put(100, "C");
        romanNumMap.put(200, "CC");
        romanNumMap.put(300, "CCC");
        romanNumMap.put(400, "CD");
        romanNumMap.put(500, "D");
        romanNumMap.put(600, "DC");
        romanNumMap.put(700, "DCC");
        romanNumMap.put(800, "DCCC");
        romanNumMap.put(900, "CM");
        romanNumMap.put(1000, "M");
        romanNumMap.put(2000, "MM");
        romanNumMap.put(3000, "MMM");

        int n = 0;

        for (int i = number; i >= 0; i--) {
            String romanNumStr = romanNumMap.get(i);

            if (romanNumStr != null) {
                res += romanNumStr;
                n += i;
                i = number - n + 1;
            }
        }

        return res;
    }
    // Only change code above this line

    public static void main(String[] args) {
        Task8Roman ex = new Task8Roman();
        logger.info("convert(2)    || " + ex.convert(2));   //equals "II"
        logger.info("convert(4)    || " + ex.convert(4));   //equals "IV"
        logger.info("convert(12)   || " + ex.convert(12));   //equals "XII"
        logger.info("convert(29)   || " + ex.convert(29));   //equals ?
        logger.info("convert(44)   || " + ex.convert(44));   //equals "XLIV"
        logger.info("convert(68)   || " + ex.convert(68));   //equals ?
        logger.info("convert(83)   || " + ex.convert(83));   //equals "LXXXIII"
        logger.info("convert(501)  || " + ex.convert(501));   //equals "DI"
        logger.info("convert(649)  || " + ex.convert(649));   //equals ?
        logger.info("convert(798)  || " + ex.convert(798));   //equals ?
        logger.info("convert(1006) || " + ex.convert(1006));   //equals "MVI"
        logger.info("convert(2014) || " + ex.convert(2014));   //equals ?
        logger.info("convert(3999) || " + ex.convert(3999));   //equals "MMMCMXCIX"
    }
}
