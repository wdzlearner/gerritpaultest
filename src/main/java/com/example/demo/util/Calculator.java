package com.example.demo.util;

/**
 * 简单的计算器工具类，用于 Gerrit 测试。
 */
public final class Calculator {

    private Calculator() {
        // 工具类不允许实例化
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return (double) a / b;
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("阶乘参数不能为负数");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
