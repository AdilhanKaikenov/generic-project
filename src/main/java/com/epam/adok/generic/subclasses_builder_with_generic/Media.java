package com.epam.adok.generic.subclasses_builder_with_generic;

public abstract class Media {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    protected static abstract class MediaInit<E extends Media, T extends MediaInit<E, T>> {

        private String name;
        private double price;

        protected abstract T self();

        public T name(String name) {
            this.name = name;
            return this.self();
        }

        public T price(double price) {
            this.price = price;
            return this.self();
        }

        public abstract E build();
    }

    protected Media(MediaInit<?,?> mediaInit) {
        this.name = mediaInit.name;
        this.price = mediaInit.price;
    }

    @Override
    public String toString() {
        return "Media {" +
                "name = '" + name + '\'' +
                ", price = " + price +
                '}';
    }
}
