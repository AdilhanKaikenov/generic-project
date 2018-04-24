package com.epam.adok.generic.subclasses_builder;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Rectangle.Builder().height(10).opacity(2).build();

//        Shape shape = new Rectangle.Builder().opacity(2).height(10).build(); --> compiler error

        System.out.println(shape);

    }
}
