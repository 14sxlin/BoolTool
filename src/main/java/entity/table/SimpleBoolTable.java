package entity.table;

import entity.bool.BoolFunction;
import entity.bool.BoolVector;
/**
 * Created by linsixin on 2017/11/24.
 * 布尔函数的真值表形式,最多能容纳31个输入变元
 * 具有缓存功能,能够缓存其他的布尔函数的值和重量
 */
public class SimpleBoolTable extends BoolFunction {

    /**
     * values[i] 表示 i 的二进制 输入 对于的函数输出
     * 比如说 8 的 二进制 是 1000 , 则 values[8] = f(1000)
     */
    private int[] values;

    private int weight = -1;

    private BoolFunction boolFunction;

    public SimpleBoolTable(int[] values){
        if(values == null || values.length == 0)
            throw new IllegalArgumentException("values should not be null or empty");
        this.values = values;
    }

    /**
     * 通过这种方式的初始化,一开始不会计算出所有的值,而是每次计算都会缓存
     */
    public SimpleBoolTable(BoolFunction boolFunction){
        int len = boolFunction.getVarLength();
        if(len > 31 || len <=0 )
            throw new IllegalArgumentException("len should be in [1,31]");

        values = new int[maxInput()];
        for(int i=0;i<maxInput();i++)
            values[i] = -1;

        this.boolFunction = boolFunction;

    }

    /**
     * 首先检查有没有被计算过,如果没有的话,就计算并保存,然后返回对应的值.
     */
    @Override
    public int resultOf(BoolVector vector) {
        int index = vector.intValue();
        if(values[index] == -1)
            values[index] = boolFunction.resultOf(vector);
        return values[index];
    }

    @Override
    public int weight() {
        if(weight != -1)
            return weight;
        if(values == null || values.length == 0)
            throw new IllegalArgumentException("values should not be null or empty");
        int count = 0;
        if(boolFunction != null){
            int varLength = boolFunction.getVarLength();
            for(int i=0; i<= maxInput(); i++){
                if(values[i] == -1)
                    if(resultOf(BoolVector.createBoolVector(i,varLength)) == 1)
                        count++;
                else if(values[i] == 1)
                    count++;
            }

        }else{
            for(int v : values){
                if(v == 1)
                    count ++;
            }
        }
        weight = count;
        return count;
    }
}
