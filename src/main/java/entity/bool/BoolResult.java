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
    byte resultOf(byte[] x);

    /**
     * get the result of bool function
     * @param x 2 radix form of input
     * @return 0 or 1 of the input of the function
     */
    byte resultOf(ArrayList<Byte> x);

    /**
     * get the result of bool function
     * @param x 10 radix form of input
     *          For example , input x = (1,0) also means 2
     * @return 0 or 1 of the input of the function
     */
    byte resultOf(long x);
}
