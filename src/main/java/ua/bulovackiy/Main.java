package ua.bulovackiy;

import ua.bulovackiy.process.ThreadProcess;

/**
 * Main class
 *
 * @author Evgeniy Bulovackiy
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {

        for(int i = 0; i < 20; i++){
            Thread t = new Thread(new ThreadProcess());
            t.start();
        }
    }
}
