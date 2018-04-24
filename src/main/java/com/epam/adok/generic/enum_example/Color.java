package com.epam.adok.generic.enum_example;

public enum Color {
    RED(1),
    GREEN(2);

    private int number;

    Color(final int num) {
        this.number = num;
    }

    public int getNumber() {
        return number;
    }

/** The compiler translates it into the following class:

    public final class Color extends Enum<Color>{

        public static Color[] values(){
            return (Color[])$VALUES.clone();
        }

        public static Color valueOf(String name){
            return (Color)Enum.valueOf(com/epam/adok/generic/Color, name);
        }

        private Color(String s, int i, int num){
            super(s, i);
            number = num;
        }

        public int getNumber(){
            return number;
        }

        public static final Color RED;
        public static final Color GREEN;
        private int number;
        private static final Color $VALUES[];

        static{
            RED = new Color("RED", 0, 1);
            GREEN = new Color("GREEN", 1, 2);
            $VALUES = (new Color[] {RED, GREEN});
        }
    }
*/
}
