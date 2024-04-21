package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //find Fibonacci number - O(n)
        //get Fibonacci number - O(1)
        int iterative = findFibonacciNumberIterative(6);
        System.out.println("Iterative: " + iterative);

        // find Fibonacci number - O(2^n)
        int recursive = findFibonacciNumberRecursive(6);
        System.out.println("Recursive : " + recursive);


        //find Fibonacci number - O(n)
        //get Fibonacci number - O(1)
        int dynProgramming = findFibonacciNumberDP(6);
        System.out.println("DP: " + dynProgramming);
    }

    private static int findFibonacciNumberIterative(int n) {
        List<Integer> fibNumbers = new ArrayList<>();
        fibNumbers.add(1);
        fibNumbers.add(1);

        for (int i = 2; i < n; i++) {
            fibNumbers.add(fibNumbers.get(i - 1) + fibNumbers.get(i - 2));
        }

        return fibNumbers.get(n - 1);
    }

    private static int findFibonacciNumberRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return findFibonacciNumberRecursive(n - 1) + findFibonacciNumberRecursive(n - 2);
    }

    private static int findFibonacciNumberDP(int n) {
        Map<Integer, Integer> savedFibonacci = new HashMap<>();

        if (n <= 1) {
            return n;
        }

        if (savedFibonacci.containsKey(n)) {
            return savedFibonacci.get(n);
        }

        int fibNumber = findFibonacciNumberDP(n - 1) + findFibonacciNumberDP(n - 2);
        savedFibonacci.put(n, fibNumber);
        return fibNumber;
    }
}