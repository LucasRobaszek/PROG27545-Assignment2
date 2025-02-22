package ca.sheridan.robaszel.assignment2.utilities;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random rand = new Random();
    //Generates 9-digit ID for Password Record
    public long generateID() { return rand.nextLong(100000000,999999999); }
}
