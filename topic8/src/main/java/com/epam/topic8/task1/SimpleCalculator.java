package com.epam.topic8.task1;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Timofey_Ryuzhov on 5/23/2016.
 */
public class SimpleCalculator {

    public static String calculate(String expression) {
        String expr = expression.replaceAll(" ", "").replaceAll("/", ":");

        Matcher matcher = Pattern.compile("^[-]?[0-9]+([.]?[0-9]+)?").matcher(expr);
        String strA = matcher.find() ? matcher.group() : "";
        if (!strA.isEmpty()) {
            BigDecimal a = new BigDecimal(strA);

            if (strA.length() == expr.length()) return "Output: " + a;

            matcher = Pattern.compile("[-]?[0-9]+([.]?[0-9]+)?$").matcher(expr);
            String strB = matcher.find() ? matcher.group() : "";
            if (!strB.isEmpty()) {
                BigDecimal b = new BigDecimal(strB);

                int beginIndex = strA.length();
                int endIndex = expr.length() - strB.length();

                String matOperation;
                if (beginIndex == endIndex) matOperation = "+";
                else matOperation = expr.substring(beginIndex, endIndex);

                if ("+ - * :".contains(matOperation)) {
                    if (matOperation.equals(":") && b.compareTo(BigDecimal.valueOf(0)) == 0) return "Divide by zero!";
                    else return "Output: " + calculate(a, b, matOperation);
                }
            }
        }

        return "incorrect expression";
    }

    private static BigDecimal calculate(BigDecimal a, BigDecimal b, String matOperation) {
        if (matOperation.equals("+"))
            return a.add(b);

        if (matOperation.equals("-"))
            return a.add(b.multiply(BigDecimal.valueOf(-1)));

        if (matOperation.equals("*"))
            return a.multiply(b);

        if (matOperation.equals("/") || matOperation.equals(":") && b.compareTo(BigDecimal.valueOf(0)) == 0)
            return null;

        if (matOperation.equals("/") || matOperation.equals(":"))
            return a.divide(b, 4, BigDecimal.ROUND_HALF_UP);

        return null;
    }
}
