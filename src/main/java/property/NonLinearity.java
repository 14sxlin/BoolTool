package property;

import entity.bool.BoolVector;
import entity.walsh.LoopWalsh;
import entity.walsh.Walsh;

/**
 * Created by linsixin on 2017/11/27.
 * 非线性度
 */
public class NonLinearity {

    public static int maxOfWalsh(Walsh walsh){
        int max = 0;
        int varLength = walsh.varLength;
        for(int i=0; i<= (1 << varLength) - 1 ; i++){
            int temp = Math.abs(walsh.resultOf(BoolVector.createBoolVector(i,varLength)));
            if( temp > max){
                max = temp;
            }
        }
        return max;
    }

    /**
     * 求出循环Walsh谱的非线性度
     * @param walsh 循环Walsh谱
     * @return 非线性度
     */
    public static double of(LoopWalsh walsh){
        int varLength = walsh.varLength;
        return (int)Math.pow(2,varLength-1) - maxOfWalsh(walsh)*1.0/2;
    }
}
