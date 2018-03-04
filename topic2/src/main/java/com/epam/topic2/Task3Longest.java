package com.epam.topic2;

/**
 * Created by Timofey_Ryuzhov on 3/19/2016.
 */
//Return the length of the longest word in the provided sentence.
public class Task3Longest extends AbstractTask {

    //  Tips: String.split()
    //  Only change code below this line
    public int findLongestWord(String str) {
        int res = 0;

        String[] words = str.split(" ");

        for (String s : words)
            res = s.length() > res ? s.length() : res;

        return res;
    }

    // Only change code above this line

    public static void main(String[] args) {
        Task3Longest ex = new Task3Longest();
        String str = "The quick brown fox jumped over the lazy dog";
        logger.info("findLongestWord(\"The quick brown fox jumped over the lazy dog\")                 || "
                + ex.findLongestWord(str)); //equals 6
        str = "What is the average airspeed velocity of an unladen swallow";
        logger.info("findLongestWord(\"What is the average airspeed velocity of an unladen swallow\")  || "
                + ex.findLongestWord(str)); //equals 8
        str = "What if we try a super-long word such as otorhinolaryngology";
        logger.info("findLongestWord(\"What if we try a super-long word such as otorhinolaryngology\") || "
                + ex.findLongestWord(str)); //equals ?
    }
}
