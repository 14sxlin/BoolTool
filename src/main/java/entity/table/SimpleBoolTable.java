package entity.table;

import entity.bool.BoolResult;
import entity.bool.BoolVector;

import static entity.bool.TransformUtilsKt.booleanArray2int;
import static entity.bool.TransformUtilsKt.intArray2int;
/**
 * Created by linsixin on 2017/11/24.
 * 布尔函数的真值表形式,最多能容纳32个输入变元
 */
public class SimpleBoolTable implements BoolResult{

    /**
     * values[i] 表示 i 的二进制 输入 对于的函数输出
     * 比如说 8 的 二进制 是 1000 , 则 values[8] = f(1000)
     */
    private int[] values;

    public SimpleBoolTable(int[] values){
        this.values = values;
    }

    @Override
    public int resultOf(BoolVector vector) {
        return values[vector.intValue()];
    }
}
