package com.example.demo.util;

/**
 * 简单的工具类，用于 Gerrit 测试。
 */
public final class StringUtils {

    private StringUtils() {
        // 工具类不允许实例化
    }

    /**
     * 反转字符串。
     *
     * @param input 待反转的字符串
     * @return 反转后的字符串，null 输入返回 null
     */
    public static String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * 判断字符串是否为回文。
     *
     * @param input 待判断的字符串
     * @return 如果是回文返回 true，否则返回 false
     */
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String reversed = reverse(input);
        return input.equals(reversed);
    }

    /**
     * 统计字符串中某个字符出现的次数。
     *
     * @param input 待统计的字符串
     * @param ch    目标字符
     * @return 字符出现的次数
     */
    public static int countChar(String input, char ch) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    /**
     * 将字符串的首字母转为大写。
     *
     * @param input 待处理的字符串
     * @return 首字母大写后的字符串
     */
    public static String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
