package com.jimtough.java.datatypes;

import java.util.Arrays;

public class DummyClass {

    public String isWhatever(boolean whatever) {
        return whatever ? "Yeah, whatever." : "No way!";
    }

    public void printPrimitiveIntArray(int[] numbersArray) {
        System.out.println("Output from Java class: " + Arrays.toString(numbersArray));
    }

}
