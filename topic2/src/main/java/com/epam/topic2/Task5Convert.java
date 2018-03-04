package com.epam.topic2;

/**
 * Created by Timofey_Ryuzhov on 3/19/2016.
 */
//Convert the characters &, <, >, " (double quote), and ' (apostrophe),
// in a string to their corresponding HTML entities.
//https://dev.w3.org/html5/html-author/charref
public class Task5Convert extends AbstractTask {

    //  Only change code below this line
    public String convert(String str) {
        String result = str;
        result = result.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;");
        return result;
    }
    // Only change code above this line

    public static void main(String[] args) {
        Task5Convert ex = new Task5Convert();
        String str = "Dolce & Gabbana";
        logger.info("convert(\"Dolce & Gabbana\")            || " + ex.convert(str)); // equals "Dolce &​amp; Gabbana"
        str = "Hamburgers < Pizza < Tacos";
        logger.info("convert(\"Hamburgers < Pizza < Tacos\") || " + ex.convert(str)); // equals "Hamburgers &​lt; Pizza &​lt; Tacos"
        str = "Shindler's List";
        logger.info("convert(\"Shindler's List\")            || " + ex.convert(str)); // equals "Shindler&​apos;s List"
        str = "<>";
        logger.info("convert(\"<>\")                         || " + ex.convert(str)); // equals &​lt;&​gt;
    }
}
