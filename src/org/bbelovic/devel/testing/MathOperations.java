package org.bbelovic.devel.testing;


/**
 * 
 *
 */
public class MathOperations {

    private MathOperations() {
        // private constructor, since this is going to be utility class
    }
    
    public static Integer stringToInteger(final String integerString) {
        int sum = 0;
        int length = integerString.length();
        int start = 0;
        boolean negative = false;
        if (integerString.charAt(0) == '-') {
            start = 1;
            negative = true;
        }
        for (int i = start; i < length; i++) {
            sum *= 10;
            sum += (integerString.charAt(i) - '0');
        }
        return (negative) ? Integer.valueOf(-sum) : Integer.valueOf(sum);
    }
    
    public static String integerToString(Integer input) {
        int size = (input < 0) ? getSize(-input) + 1 : getSize(input);
        
        boolean negative = false;
        if (input < 0) {
            input = -input;
            negative = true;
        }
        
        char [] buf = new char [size];
        while (true) {
            buf [--size] = digitTable [input % 10];
            input /= 10;
            if (input == 0) break;
        }
        if (negative) buf [--size] = '-';
        return String.valueOf(buf);
    }
    
    private static final int [] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 99999999, Integer.MAX_VALUE};
    private static final char [] digitTable = {'0', '1', '2', '3', '4', '5', '6', '7','8', '9'};
    
    private static int getSize(int x) {
        for (int i = 0; ; i++) {
            if (x <= sizeTable[i])
                return i+1;
        }
        
    }
}
