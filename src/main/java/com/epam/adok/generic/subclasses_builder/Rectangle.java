package com.epam.adok.generic.subclasses_builder;

public class Rectangle extends Shape {
    private final double height;

    public static class Builder extends Shape.Builder {
        private double height;

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        @Override
        public Rectangle build() {
            return new Rectangle(this);
        }
    }

    protected Rectangle(Builder builder) {
        super(builder);
        this.height = builder.height;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + "Rectangle {" +
                "height = " + height +
                '}';
    }
}