package com.epam.adok.generic.subclasses_builder_with_generic;

public class MusicAlbum extends Media {

    private int duration;
    private String author;

    protected MusicAlbum(MusicAlbumInit<?> mediaInit) {
        super(mediaInit);
        this.duration = mediaInit.duration;
        this.author = mediaInit.author;
    }

    public int getDuration() {
        return duration;
    }

    public String getAuthor() {
        return author;
    }

    protected static abstract class MusicAlbumInit<T extends MusicAlbumInit<T>> extends Media.MediaInit<MusicAlbum, T> {

        private int duration;
        private String author;

        public T duration(int duration) {
            this.duration = duration;
            return this.self();
        }

        public T author(String author) {
            this.author = author;
            return this.self();
        }

        @Override
        public MusicAlbum build() {
            return new MusicAlbum(this);
        }
    }

    public static class Builder extends MusicAlbumInit<Builder> {
        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - " +
                "MusicAlbum {" +
                "duration = " + duration +
                ", author = '" + author + '\'' +
                '}';
    }
}
