package org.bbelovic.devel.testing;

public class BitOperations {

    public static String toBinaryString(int i) {
        return Integer.toBinaryString(i);
    }
    
    public static void bitwiseOr(int flags, int mask) {
        flags |= mask;
        System.out.println(toBinaryString(flags));
    }
    
    public static void bitwiseAnd(int flags, int mask) {
        flags &= mask;
        System.out.println(toBinaryString(flags));
    }
    
    public static void bitwiseXor(int flags, int mask) {
        flags ^= mask;
        System.out.println(toBinaryString(flags));
    }
    
    public static void bitwiseNot(int flags) {
        System.out.println(toBinaryString(~flags));
    }

    public static void main(String[] args) {
        byte mask = 3;
        byte flags = 0;
        flags |= mask;
        System.out.println(toBinaryString(flags));
        
        System.out.println("Flags turned on: " + ((flags & mask) == mask));
        
        flags &= ~mask;
        
        System.out.println(toBinaryString(flags));
    }
}
