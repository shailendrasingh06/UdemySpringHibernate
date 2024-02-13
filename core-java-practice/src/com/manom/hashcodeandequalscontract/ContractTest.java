package com.manom.hashcodeandequalscontract;

import java.util.HashMap;
import java.util.Map;

public class ContractTest {
    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();
        Student s1 = new Student(1, "Manom");
        Student s2 = new Student(1, "Manom");

        map.put(s1, "Manom");
        map.put(s2, "Manom");

        for(Map.Entry<Student, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " : " + entry.hashCode());
        }
    }
}
