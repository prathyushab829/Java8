package org.example;

import org.example.bean.Employee;
import org.example.interfce.Interface1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        funtionalInterfaceMethod();
        streamAPI();
        lambdaExpressions();
    }

    // Functional Interface using lambda expression
    public static void funtionalInterfaceMethod(){
        Interface1 i1 = (s) -> System.out.println("Interface1 "+s);
        i1.method1("abc");
    }

    //Stream API
    public static void streamAPI(){
        // Stream API
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<100; i++) myList.add(i);
        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();
        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();
        //using lambda with Stream API, filter example
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
        //using lambda in forEach
        highNums.forEach(p -> System.out.println("High Nums parallel="+p));
        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));
    }

    // lambda methods
    public static void lambdaExpressions(){
        List<String> certs = new ArrayList<>(Arrays.asList("scrum","PMP"));
        Employee e1 = new Employee("1","Geeth",certs);
        Employee e2 = new Employee("2","Prath",certs);
        Employee e3 = new Employee("3","Kavitha",certs);
        List<Employee> employees = new ArrayList<>(Arrays.asList(e1,e2,e3));

        // Predicate
        List<Employee> filteredList = employees.stream().filter(e ->e.getId().equals("1")).collect(Collectors.toList());
        filteredList.stream().forEach(e->{
            System.out.println(e);
        });
        List<Employee> validIds = employees
                .stream()
                // Method usage in lambda
                .filter(Employee::hasValidId)
                .collect(Collectors.toList());

        validIds.stream().forEach(e->{
            System.out.println(e);
        });

        // List to map
        Map<String, Employee> map1 = employees.stream().collect(Collectors.toMap(Employee::getName,
                Function.identity()));
        map1.entrySet().stream().forEach(e->{
            System.out.println(e);
        });

        //Handling duplicates
        Map<String, Employee> map2 = employees.stream().collect(Collectors.toMap(Employee::getName,
                Function.identity() , (first, second) -> second));
        map2.entrySet().stream().forEach(e->{
            System.out.println(e);
        });

        //List to map by count
        Map<String, Long> map3 = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getId, Collectors.counting()));
        map3.entrySet().stream().forEach(e->{
            System.out.println(e);
        });

    }
}