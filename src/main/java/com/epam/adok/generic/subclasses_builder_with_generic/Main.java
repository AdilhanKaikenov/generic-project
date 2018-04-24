package com.epam.adok.generic.subclasses_builder_with_generic;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Book book = new Book.Builder()
                .name("Book")
                .price(2.5)
                .pagesNumber(300)
                .authors(
                        Arrays.asList("Author1", "Author2", "Author3")
                )
                .build();

        System.out.println(book);

        MusicAlbum musicAlbum = new MusicAlbum.Builder()
                .name("Music Album")
                .price(4.5)
                .duration(400)
                .author("Author1")
                .build();

        System.out.println(musicAlbum);
    }
}
