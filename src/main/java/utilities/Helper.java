package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Helper {

    public static String generateRandomString(int length){
        return "";
    }

    public static String genRandomCharacter(int length, int capitalInclude) {

        int limit = 26;
        if (capitalInclude > 0) {
            limit = 52;
        }
        String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = genRandomNumber(limit);
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    public static String genRandomCharacter(int length) {
        return genRandomCharacter(length, 0);
    }

    public static int genRandomNumber(int length) {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(length);
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }

    }

    public static int genRandomNumber(int min, int max) {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(max - min + 1) + min;
        return randomInt;
    }

    public static String genRandomDigit(int length) {
        String CHAR_LIST = "0123456789";
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = genRandomNumber(0, 9);
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    public static String genRandomName(String firstChar) {
        return firstChar + genRandomCharacter(10);
    }

    public static String genRandomName() {
        return genRandomName("A");
    }

    public static String genRandomPhone() {
        return "0" + genRandomDigit(9);
    }

    public static String getCurrentDate(String format) {

        Date dt = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(dt);

    }

    /**
     * Get the method name for a depth in call stack. <br />
     * Utility function
     *
     * @param depth depth in the call stack (0 means current method, 1 means call method, ...)
     * @return method name
     */
    private static String getMethodName(final int depth) {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[2 + depth].getMethodName();
    }

    public static void print(String x) {
        System.out.println("(" + getCurrentDate("d/M H:m:s:SSS") + ")<" + getMethodName(1) + "> " + x);
    }


}
