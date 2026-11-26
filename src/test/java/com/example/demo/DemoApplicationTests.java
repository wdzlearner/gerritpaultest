package com.example.demo;

import com.example.demo.util.Calculator;
import com.example.demo.util.StringUtils;

/**
 * 简单的自测入口，不依赖任何外部框架。
 */
public class DemoApplicationTests {

    public static void main(String[] args) {
        System.out.println("reverse(abcd) = " + StringUtils.reverse("abcd"));
        System.out.println("isPalindrome(aba) = " + StringUtils.isPalindrome("aba"));
        System.out.println("capitalize(hello) = " + StringUtils.capitalize("hello"));
        System.out.println("add(2,3) = " + Calculator.add(2, 3));
        System.out.println("factorial(5) = " + Calculator.factorial(5));
        System.out.println("isPrime(17) = " + Calculator.isPrime(17));
    }
}

