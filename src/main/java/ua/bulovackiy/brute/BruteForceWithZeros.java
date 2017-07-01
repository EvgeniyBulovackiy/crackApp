package ua.bulovackiy.brute;

import ua.bulovackiy.connection.TestPhp;

/**
 * Class for bust values with zeros.
 *
 * @author Evgeniy Bulovackiy
 * @version 1.0
 */

public class BruteForceWithZeros implements Runnable{

    private char[] numbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static private int count = 0;
    private TestPhp testPhp = new TestPhp();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is starting.");
        bust();
        System.out.println(Thread.currentThread().getName() + " is finished.");

        new Thread(new BruteForceWithZeros()).start();
    }

    private void bust() {
        int step = 20;
        int min = count * step;
        int max = ++count * step;

        for (Character c1 : numbers) {
            String result = c1.toString();

            if (Integer.parseInt(result) >= (min)
                    && Integer.parseInt(result) <= (max)) {
                testPhp.post(result);
            }

            for (Character c2 : numbers) {
                String result2 = result + c2;

                if (Integer.parseInt(result2) >= (min)
                        && Integer.parseInt(result2) <= (max)) {
                    testPhp.post(result2);
                }

                for (Character c3 : numbers) {
                    String result3 = result2 + c3;

                    if (Integer.parseInt(result3) >= (min)
                            && Integer.parseInt(result3) <= (max)) {
                        testPhp.post(result3);
                    }

                    for (Character c4 : numbers) {
                        String result4 = result3 + c4;

                        if (Integer.parseInt(result4) >= (min)
                                && Integer.parseInt(result4) <= (max)) {
                            testPhp.post(result4);
                        }

                        for (Character c5 : numbers) {
                            String result5 = result4 + c5;

                            if (Integer.parseInt(result5) >= (min)
                                    && Integer.parseInt(result5) <= (max)) {
                                testPhp.post(result5);
                            }

                            for (Character c6 : numbers) {
                                String result6 = result5 + c5;

                                if (Integer.parseInt(result6) >= (min)
                                        && Integer.parseInt(result6) <= (max)) {
                                    testPhp.post(result6);
                                }

                                for (Character c7 : numbers) {
                                    String result7 = result6 + c5;

                                    if (Integer.parseInt(result7) >= (min)
                                            && Integer.parseInt(result7) <= (max)) {
                                        testPhp.post(result7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

