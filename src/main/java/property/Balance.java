package property;

import entity.bool.BoolFunction;

/**
 * Created by linsixin on 2017/11/30.
 * 平衡性
 */
public class Balance {
    public static int weightOf(BoolFunction bool){
        return bool.weight();
    }

    public static boolean isBalance(BoolFunction bool){
        return bool.weight() == bool.maxInput() / 2;
    }
}
