package com.andyron.rabbitmq.one;

/**
 * @author andyron
 **/
public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = -1;
        byte c = -1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b >> 2));
        System.out.println(Integer.toBinaryString(b >>> 2));
        System.out.println();
    }
}
