package com.epam.adok.generic.super_vs_extends;

import java.util.ArrayList;
import java.util.List;

class Fruit {
    @Override
    public String toString() {
        return "I am a Fruit !!";
    }

    public String fruitMethod() {
        return "fruitMethod()";
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "I am an Apple !!";
    }

    public String appleMethod() {
        return "appleMethod()";
    }
}

class AsianApple extends Apple {
    @Override
    public String toString() {
        return "I am an AsianApple !!";
    }

    public String asianAppleMethod() {
        return "asianAppleMethod()";
    }
}

public class GenericsExamples_pecs {
    public static void main(String[] args) {

        /**
         Case 1: You want to go through the collection and do things with each item.
         Then the list is a producer, so you should use a Collection<? extends Thing>.

         The reasoning is that a Collection<? extends Thing> could hold any subtype of Thing, and thus each element will
         behave as a Thing when you perform your operation. (You actually cannot add anything to a Collection<? extends Thing>,
         because you cannot know at runtime which specific subtype of Thing the collection holds.)
         */

        //List of apples
        List<Apple> apples1 = new ArrayList<>();
        apples1.add(new Apple());

        //We can assign a list of apples to a basket of fruits;
        //because apple is subtype of fruit
        List<? extends Fruit> basketExtends = apples1;

        //Here we know that in basket there is nothing but fruit only
        for (Fruit fruit : basketExtends) {
            System.out.println(fruit);
        }

//        basketExtends.add(new Apple()); //Compile time error
//        basketExtends.add(new Fruit()); //Compile time error

// -------------------------------------------------------------------------------

        /**
         Case 2: You want to add things to the collection.
         Then the list is a consumer, so you should use a Collection<? super Thing>.

         The reasoning here is that unlike Collection<? extends Thing>, Collection<? super Thing> can always hold a Thing
         no matter what the actual parameterized type is. Here you don't care what is already in the list as long as
         it will allow a Thing to be added; this is what ? super Thing guarantees
         */

        //List of apples
        List<Apple> apples2 = new ArrayList<>();
        apples2.add(new Apple());

        //We can assign a list of apples to a basket of apples
        List<? super Apple> basketSuper = apples2;

        basketSuper.add(new Apple());      //Successful
        basketSuper.add(new AsianApple()); //Successful
//        basketSuper.add(new Fruit());      //Compile time error

    }
}
