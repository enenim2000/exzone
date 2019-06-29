package com.exzone.util;

import java.util.Date;

public class RandomUtil {
    // function to generate a random string of length n
    public static String getAlphaNumeric(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public static String getSessionId() {
        return "SID" + DateUtil.formatDateTime(new Date())
                .replace(":", "")
                .replace("-", "")
                .replace(" ", "") + RandomUtil.getAlphaNumeric(20).toUpperCase();
    }
}
