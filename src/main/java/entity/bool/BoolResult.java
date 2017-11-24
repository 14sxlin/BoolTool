package entity.bool;

import java.util.ArrayList;

/**
 * Created by linsixin on 2017/11/22.
 * This class represent the ability to get the result of
 * a bool function
 */
public interface BoolResult {

    /**
     * get the result of bool function
     * @param x 2 radix form of input
     * @return 0 or 1 of the input of the function
     */
    int resultOf(int[] x);

    /**
     * get the result of bool function
     * @param x 2 radix form of input,true means 1 ,false means 0
     * @return 0 or 1 of the input of the function
     */
    int resultOf(boolean[] x);

    /**
     * get the result of bool function
     * @param x 10 radix form of input
     *          For example , input x = (1,0) also means 2
     * @return 0 or 1 of the input of the function
     */
    int resultOf(long x);

    /**
     * get the result of bool function
     * @param x 10 radix form of input
     *          For example , input x = (1,0) also means 2
     * @return 0 or 1 of the input of the function
     */
    int resultOf(int x);

    /**
     * change int[] to boolean[] , 1 -> true , 0 -> false
     * if integer is neither 1 nor 0, then throw IllegalArgumentException
     * @param x 0 1 array
     * @return boolean array
     */
    default boolean[] intArray2booleanArray(int[] x){
        boolean []input = new boolean[x.length];
        for(int i=0; i< x.length; i++){
            if(i == 0){
                input[i] = false;
            }else if(i == 1){
                input[i] = true;
            }else{
                throw new IllegalArgumentException("input should only contains 0 or 1, illegal : " + i );
            }
        }
        return input;
    }

    /**
     * change int to  boolean[], using int's binary form
     * 0 -> false, 1-> true
     * @param x the integer
     * @param varLength the length of boolean
     * @return boolean array
     */
    default boolean[] int2booleanArray(int x,int varLength){
        String binary = Integer.toBinaryString(x);
        int binLength = binary.length();
        System.out.println("binlen = "+ binLength);
        if(binLength > varLength)
            throw new IllegalArgumentException("number is too long to put into boolean["+ varLength +"]");
        boolean [] input = new boolean[varLength];
        int count = input.length - 1;
        for(int i=binLength - 1; i>=0; i--){
            input[count--] = binary.charAt(i) == '1';
        }
        return input;
    }

    /**
     * change long to boolean[]
     * @param x long
     * @param varLength length of boolean[]
     * @return boolean[]
     */
    default boolean[] long2booleanArray(long x,int varLength){
        String binary = Long.toBinaryString(x);
        int binLength = binary.length();
        if(binLength > varLength)
            throw new IllegalArgumentException("number["+x+"] is too long to put into boolean["+ varLength +"]");
        boolean [] input = new boolean[varLength];
        for(int i=binLength - 1; i>=0; i--){
            input[i] = binary.charAt(i) == '1';
        }
        return input;
    }
}
