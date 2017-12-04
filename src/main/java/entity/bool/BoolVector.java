package entity.bool;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by linsixin on 2017/11/26.
 */
public class BoolVector {

    private BoolValue[] boolValues;
    private int intValue = -1;

    public static BoolVector createBoolVector(int length,Set<Integer> oneIndices){
        if(oneIndices.isEmpty()) return createZeroBoolVector(length);
        BoolValue values[] = new BoolValue[length];
        for(int i=0; i<values.length; i++){
            if(oneIndices.contains(i))
                values[i] = BoolValue.ONE;
            else values[i] = BoolValue.ZERO;
        }
        return new BoolVector(values);
    }

    public static BoolVector createZeroBoolVector(int length){
        if(length < 1)
            throw new IllegalArgumentException("variable should not be null or empty");

        BoolValue values[] = new BoolValue[length];
        for(int i=0; i<values.length; i++){
            values[i] = BoolValue.ZERO;
        }
        return new BoolVector(values);
    }

    public static BoolVector createBoolVector(int[] ints){
        if(ints == null || ints.length < 1)
            throw new IllegalArgumentException("variable should not be null or empty");

        BoolValue values[] = new BoolValue[ints.length];
        for(int i=0; i<values.length; i++){
            if(ints[i] == 1){
                values[i] = BoolValue.ONE;
            }else if(ints[i] == 0){
                values[i] = BoolValue.ZERO;
            }else throw new IllegalArgumentException("ints should be 1 or 0, ill: "+ints[i]);
        }
        return new BoolVector(values);
    }

    public static BoolVector createBoolVector(int num,int varLength){
        int[] ints = TransformUtilsKt.int2IntArray(num,varLength);
        BoolValue values[] = new BoolValue[ints.length];
        for(int i=0; i<values.length; i++){
            if(ints[i] == 1){
                values[i] = BoolValue.ONE;
            }else if(ints[i] == 0){
                values[i] = BoolValue.ZERO;
            }else throw new IllegalArgumentException("ints should be 1 or 0 ,illegal :" + i );
        }
        return new BoolVector(values,num);
    }

    public static BoolVector createBoolVector(boolean[] bools){
        BoolValue values[] = new BoolValue[bools.length];
        for(int i=0; i<values.length; i++){
            if(bools[i]){
                values[i] = BoolValue.ONE;
            }else{
                values[i] = BoolValue.ZERO;
            }
        }

        return new BoolVector(values);
    }

    public static BoolVector createBoolVector(String binaryInteger,int varLength){
        return createBoolVector(Integer.parseInt(binaryInteger,2),varLength);
    }


    private BoolVector(BoolValue[] boolValues){
        this.boolValues = boolValues;
    };

    private BoolVector(BoolValue[] boolValues,int intValue){
        this.boolValues = boolValues;
        this.intValue = intValue;
    };

    public int getLength(){
        return boolValues.length;
    }

    public int intAt(int i){
        return boolValues[i].toInt;
    }

    public boolean boolAt(int i){
        return boolValues[i].toBool;
    }

    public int intValue(){
        if(intValue != -1)
            return intValue;
        else return TransformUtilsKt.intArray2int(asIntArray());
    }

    private int[] asIntArray(){
        int[] result = new int[boolValues.length];
        for(int i=0;i<boolValues.length; i++){
            result[i] = boolValues[i].toInt;
        }
        return result;
    }

    /**
     * 布尔函数的内积
     * 参考 现代密码学中的布尔函数 p5 walsh谱的定义
     */
    public int multiply(BoolVector other){
        assert getLength() == other.getLength();
        int result = 0;
        for(int i = 0; i< boolValues.length; i++){
            int temp = intAt(i);
            if(temp == 0) continue;
            result += temp * other.intAt(i);
        }
        return result % 2;
    }

    /**
     * 布尔函数的加法,对应的位相加 % 2
     */
    public BoolVector boolAdd(BoolVector other){
        if(other.boolValues.length != boolValues.length)
            throw new IllegalArgumentException("bool vector should have same length");
        BoolValue[] newBoolValues = new BoolValue[boolValues.length];
        for(int i=0;i<boolValues.length; i++){
            newBoolValues[i] = boolValues[i].add(other.boolValues[i]);
        }
        return new BoolVector(newBoolValues);
    }

    /**
     * 向量的重量, 也就是1的数量, wt(vector)
     */
    public int weight(){
        int count = 0;
        for(BoolValue v : boolValues)
            if(v == BoolValue.ONE)
                count++;
        return count;
    }


    public String toBinaryString(){
        StringBuilder sb = new StringBuilder();
        for(BoolValue bv:boolValues){
            sb.append(bv.toInt);
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "BoolVector{" +
                "boolValues=" + Arrays.toString(boolValues) +
                ", intValue=" + intValue +
                '}';
    }
}
