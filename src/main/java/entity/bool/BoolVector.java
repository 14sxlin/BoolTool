package entity.bool;

import java.util.Set;

/**
 * Created by linsixin on 2017/11/26.
 */
public class BoolVector {

    private BoolValue[] boolValues;

    public static BoolVector createBoolVector(int length,Set<Integer> oneIndices){
        BoolValue values[] = new BoolValue[length];
        for(int i=0; i<values.length; i++){
            if(oneIndices.contains(i))
                values[i] = BoolValue.ONE;
            else values[i] = BoolValue.ZERO;
        }
        return new BoolVector(values);
    }

    public static BoolVector createBoolVector(int length){
        BoolValue values[] = new BoolValue[length];
        for(int i=0; i<values.length; i++){
            values[i] = BoolValue.ZERO;
        }
        return new BoolVector(values);
    }

    public static BoolVector createBoolVector(int[] ints){
        BoolValue values[] = new BoolValue[ints.length];
        for(int i=0; i<values.length; i++){
            if(ints[i] == 1){
                values[i] = BoolValue.ONE;
            }else{
                values[i] = BoolValue.ZERO;
            }
        }
        return new BoolVector(values);
    }

    public static BoolVector createBoolVector(int num,int varLength){
        return createBoolVector(TransformUtilsKt.int2IntArray(num,varLength));
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



    private BoolVector(BoolValue[] boolValues){
        this.boolValues = boolValues;
    };

    public int getLength(){
        return boolValues.length;
    }

    public int numberAt(int i){
        return boolValues[i].value;
    }

    public int multiply(BoolVector boolVector){
        assert getLength() == boolVector.getLength();
        int result = 0;
        for(int i = 0; i< boolValues.length; i++){
            result += numberAt(i) * boolVector.numberAt(i);
        }
        return result % 2;
    }
}
