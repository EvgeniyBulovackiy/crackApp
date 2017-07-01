package ua.bulovackiy.brute;

import ua.bulovackiy.connection.TestPhp;

/**
 * Class for bust values without zeros.
 *
 * @author Evgeniy Bulovackiy
 * @version 2.0
 */

public class BruteForce implements Runnable {

    private static int counter = 0;
    private final int step = 20;
    private TestPhp testPhp = new TestPhp();
    private volatile boolean flag = true;


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is starting.");
        bust();
        System.out.println(Thread.currentThread().getName() + " is finished.");

        new Thread(new BruteForce()).start();
    }

    private void bust() {
        int checkNumber = counter * step;
        int nonStaticCounter = ++counter;

        while (flag) {
            testPhp.post(((Integer) checkNumber).toString());
            checkNumber++;

            if (checkNumber == (nonStaticCounter * step)) {
                flag = false;
            }
        }
    }
}
