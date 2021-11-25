package task2.cars;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> allNumbers = populateWithNumbers();                       //+
        Map<String, List<Integer>> mapEvenOdd = getEvenOdd(allNumbers);         //-
        List<Integer> evenNumbers = getEvenNumbers(allNumbers);                 //+
        boolean isAllEven = isAllEven(evenNumbers);                             //+
        int sum = getSum(allNumbers);                                           //+
        int sumOdd = getOddSum(evenNumbers);                                    //  ready
//      int sumOdd2 = getOddSum(allNumbers);                                    // ?exceptiogenerateAndPrint();                                                     // ready
//      printRange();                                                           //+
//      printChangePrint(new int[]{1, 2, 3, 4, 5});                             //+


        List<Car> cars = populateWithCars();                                    //  ready
//      changeName(cars);                                                       //+
//      Map<String, List<String>> mapByClassName = mapByClassName(cars);        //
//      printUnique(cars);                                                      //+
//      sortAndPrint(cars);                                                     //+
    }

    private static void printChangePrint(int[] ints) {
        //made stream of array. Print its values. Multiply each value by 3. Print number before
        // and after modification (example, 1 3 2 6 ....). It must be one stream

        Arrays.stream(ints)
                .peek(System.out::print)
                .map(x -> (x * 3))
                .forEach(x -> System.out.format(" %s ", x));
    }

    private static void printUnique(List<Car> cars) {
        //print names only unique cars

        cars.stream()
                .map(Car::getName)
                .distinct()
                .forEach(System.out::println);
    }

    private static void sortAndPrint(List<Car> cars) {
        //sort cars by class name in reverse order. Print sorted data.

        cars.stream()
                .sorted(Comparator.comparing(a -> a.getClass().getSimpleName()).reversed())
                .forEach(a -> System.out.println(a.getName() + " - " + a.getClass().getSimpleName()));
    }

    private static void printRange() {
        // create stream (use range) from 0 to 5. Print range from 0 to iterated value. Example
        // 0,0,1,0,1,2....

        IntStream
                .rangeClosed(0, 5)
                .flatMap(x -> IntStream.rangeClosed(0, x))
                .forEach(x -> System.out.print(x + " "));
    }

    private static void generateAndPrint() {
        //generate stream of word "java" 10 times and print it

        Stream.generate(() -> "java ")
                .limit(10)
                .forEach(System.out::print);
    }


    private static int getOddSum(List<Integer> numbers) {
        // return sum of odd numbers. If no odd numbers are present throw NoSuchElementException

        return
                numbers.stream()
                        .filter(x -> (x % 2 == 1))
                        .mapToInt(Integer::intValue)
                        .sum();
    }

    private static Map<String, List<String>> mapByClassName(List<Car> cars) {
        // return Map<String, List<String>> where key class name and value = list of appropriate
        // cars

//        cars.stream()
//                .collect(Collectors.groupingBy(Car::getClass),
//                Collectors.mapping()
        return Collections.emptyMap();
    }

    private static void changeName(List<Car> cars) {
        //change name of each car by adding name of class ("first Bulldozer", "second Tractor"...)

        cars.stream()
                .map(x -> x.getName() + " " + x.getClass().getSimpleName())
                .forEach(System.out::println);
    }

    private static List<Car> populateWithCars() {
        Car first = new Bulldozer("first");
        Car second = new Tractor("second");
        Car third = new Truck("third");
        Car fourth = new Bulldozer("fourth");
        Car fifth = new Tractor("fifth");
        Car sixth = new Tractor("fifth");

        //return collection of cars

        return Stream
                .of(first, second, third, fourth, fifth, sixth)
                .collect(Collectors.toList());
    }

    private static int getSum(List<Integer> evenNumbers) {
        // return sum of all numbers

        return evenNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean isAllEven(List<Integer> evenNumbers) {
        //check is all numbers are even.

        return evenNumbers.stream().allMatch(x -> x % 2 == 0);
    }

    private static List<Integer> getEvenNumbers(List<Integer> allNumbers) {
        //return only even numbers

        return allNumbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
    }

    private static Map<String, List<Integer>> getEvenOdd(List<Integer> numbers) {
        //return Map<String, List<Integer>, where key word "even" and "odd" and value is a list
        // with either odd or even numbers

        Map<String, List<Integer>> evenOddNumbersMap = new HashMap<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer number : numbers
        ) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }
        evenOddNumbersMap.put("even", evenNumbers);
        evenOddNumbersMap.put("odd", oddNumbers);
        return evenOddNumbersMap;
    }

    private static List<Integer> populateWithNumbers() {
        //return list with numbers where numbers have step five. For example, 0,5,10,15,...)
        // Limit numbers to 1000 inclusive.

        return IntStream
                .iterate(0, x -> x <= 1000, x -> x + 5)
                .boxed()
                .collect(Collectors.toList());
    }
}