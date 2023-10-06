package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(4, 5, 10, 8, 13, 26, 9, 3, 6);

        filterEvenNumbers(numbers);
        multiplyNumbers(numbers);
        sortNumbers(numbers);
        sumNumbers(numbers);
        printAndAddNumbersToList(numbers);
    }

    public static void filterEvenNumbers(List<Integer> numbers) {
        List<Integer> filteredNumbers = numbers.stream().filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(filteredNumbers);
    }

    public static void multiplyNumbers(List<Integer> numbers) {
        List<Integer> multipliedNumbers = numbers.stream().map(number -> number * 2)
                .collect(Collectors.toList());
        System.out.println(multipliedNumbers);
    }

    public static void sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream().sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }

    public static void sumNumbers(List<Integer> numbers) {
        int sum = numbers.stream().parallel().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }
    public static void printAndAddNumbersToList(List<Integer> numbers) {
        List<Integer> newNumbers = numbers.stream()
                .peek(number -> System.out.println(number))
                .map(number -> number)
                .collect(Collectors.toList());
    }

}
