package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int iterative = findFibonacciNumberIterative(6);
        System.out.println("Iterative O(n): " + iterative);

        int recursive = findFibonacciNumberRecursive(6);
        System.out.println("Recursive O(n): " + recursive);

        int dynProgramming = findFibonacciNumberDP(6);
        System.out.println("DP O(n): " + dynProgramming);
    }

    private static int findFibonacciNumberIterative(int n){
        int[] fibNumbers = new int[n];
        fibNumbers[0] = 1;
        fibNumbers[1] = 1;

        for (int i = 2; i < n; i++) {
            fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
        }
        return fibNumbers[n - 1];
    }

    private static int findFibonacciNumberRecursive(int n){
        if (n <= 1) {
            return n;
        }
        return findFibonacciNumberRecursive(n - 1) + findFibonacciNumberRecursive(n - 2);
    }

    private static int findFibonacciNumberDP(int n){
        Map<Integer, Integer> savedFibonacci = new HashMap<>();

        if (n <= 1){
            return n;
        }

        if (savedFibonacci.containsKey(n)){
            return savedFibonacci.get(n);
        }

        int fibNumber = findFibonacciNumberDP(n - 1) + findFibonacciNumberDP(n - 2);
        savedFibonacci.put(n, fibNumber);
        return fibNumber;
    }
}