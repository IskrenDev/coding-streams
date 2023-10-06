package org.example;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(4, 5, 10, 8, 13, 26, 9, 3, 6);

        filterEvenNumbers(numbers);
        multiplyNumbers(numbers);
        sortNumbers(numbers);
        sumNumbers(numbers);
        printAndAddNumbersToList(numbers);

        try (Stream<String> lines = Files.lines(Paths.get("students.csv"))) {
            List<String> studentsFromStream = lines.skip(1)
                    .filter(line -> line != null).toList();
            System.out.println(studentsFromStream);
        } catch (IOException e) {
            System.out.println("Can't find the file");
        }
    }

    public static void filterEvenNumbers(List<Integer> numbers) {
        List<Integer> filteredNumbers = numbers.stream().filter(number -> number % 2 == 0)
                .collect(toList());
        System.out.println(filteredNumbers);
    }

    public static void multiplyNumbers(List<Integer> numbers) {
        List<Integer> multipliedNumbers = numbers.stream().map(number -> number * 2)
                .collect(toList());
        System.out.println(multipliedNumbers);
    }

    public static void sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream().sorted()
                .collect(toList());
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
