package com.epam.adok.generic.subclasses_builder;

public class Shape {
    private final double opacity;

    public static class Builder {
        private double opacity;

        public Builder opacity(double opacity) {
            this.opacity = opacity;
            return this;
        }

        public Shape build() {
            return new Shape(this);
        }
    }

    protected Shape(Builder builder) {
        this.opacity = builder.opacity;
    }

    @Override
    public String toString() {
        return "Shape {" +
                "opacity = " + opacity +
                '}';
    }
}
