package ua.bulovackiy.brute;

import ua.bulovackiy.connection.TestPhp;

import java.util.concurrent.Semaphore;

/**
 * Class for bust values.
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

            String result = testPhp.post(((Integer) checkNumber).toString());
            if (result.equals("405 Not Allowed nginx/1.12.0")){
                checkNumber--;
            }
            System.out.println(result + " with " + checkNumber);

            if (!result.equals("WRONG =(") && !result.equals("405 Not Allowed nginx/1.12.0")) {
                System.out.println(result);
                System.exit(0);
            }

            if (checkNumber == (nonStaticCounter * step)) {
                flag = false;
            }
        }
    }
}
