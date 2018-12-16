package com.java8Interface;

public class InterfaceStaticTest {

    public static void main(String[] args) {

        System.out.println(InterfaceStatic.test());
        System.out.println(InterfaceStaticImpl.test());
        System.out.println(InterfaceStatic.test2());
//        System.out.println(InterfaceStaticImpl.test2());    //compilation error
    }
}
