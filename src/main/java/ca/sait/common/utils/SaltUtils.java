package ca.sait.common.utils;

import java.util.Random;

/**
 * Generate salt to make the password more secure.
 * @author Bin Zhang
 * @create 2020-06-22 9:43 PM
 */
public class SaltUtils {
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYabcdefghijklmnopqrstuvwxy0123456789!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(SaltUtils.getSalt(4));
    }
}
