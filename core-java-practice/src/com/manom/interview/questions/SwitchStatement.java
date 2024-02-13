package com.manom.interview.questions;

public class SwitchStatement {
    public static void main(String... args) {
        final char ch = 'A';
        final char eg = (char)65;
        System.out.print(eg);
        switch (ch) {
            case 65: System.out.println("case 65");break;
            case 66: System.out.print("case 66");break;
        }
    }
}
