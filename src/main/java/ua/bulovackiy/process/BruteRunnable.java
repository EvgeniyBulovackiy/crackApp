package ua.bulovackiy.process;

import ua.bulovackiy.brute.BruteForce;

/**
 * Class that run {@link BruteForce} in thread.
 *
 * @author Evgeniy Bulovackiy
 * @version 1.0
 */
public class BruteRunnable implements Runnable{

    BruteForce bruteForce = new BruteForce();
    private String start = "0";
    private String end = "0";

    @Override
    public void run() {
        bruteForce.bust(start, end, "");
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
