package ua.bulovackiy;

import ua.bulovackiy.brute.BruteForceWithZeros;

/**
 * Main class
 *
 * @author Evgeniy Bulovackiy
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++){
            new Thread(new BruteForceWithZeros()).start();
        }

    }
}
