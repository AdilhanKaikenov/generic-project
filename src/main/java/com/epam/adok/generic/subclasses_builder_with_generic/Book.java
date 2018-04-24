package com.epam.adok.generic.subclasses_builder_with_generic;

import java.util.List;

public class Book extends Media {

    private int pagesNumber;
    private List<String> authors;

    protected Book(BookInit<?> bookInit) {
        super(bookInit);
        this.pagesNumber = bookInit.pagesNumber;
        this.authors = bookInit.authors;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public List<String> getAuthors() {
        return authors;
    }

    protected static abstract class BookInit<T extends BookInit<T>> extends Media.MediaInit<Book, T> {

        private int pagesNumber;
        private List<String> authors;

        public T pagesNumber(int pagesNumber) {
            this.pagesNumber = pagesNumber;
            return self();
        }

        public T authors(List<String> authors) {
            this.authors = authors;
            return self();
        }

        @Override
        public Book build() {
            return new Book(this);
        }
    }

    public static class Builder extends BookInit<Builder> {
        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - " + "Book {" +
                "pagesNumber = " + pagesNumber +
                ", authors = " + authors +
                '}';
    }
}
