package property;

import entity.bool.BoolFunction;
import entity.bool.BoolResult;

/**
 * Created by linsixin on 2017/11/30.
 * 平衡性
 */
public class Balance {

    public static int weightOf(BoolFunction bool){
        return bool.weight();
    }

    public static boolean isBalance(BoolFunction bool){
        long total = 1 << bool.getVarLength();
        int weight = bool.weight();
        System.out.println("total = " + total);
        System.out.println("weight = " + weight);
        return  weight == total / 2;
    }

}
