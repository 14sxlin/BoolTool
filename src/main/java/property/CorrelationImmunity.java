package property;

import entity.bool.BoolVector;
import entity.bool.VectorToolKt;
import entity.walsh.LoopWalsh;

/**
 * Created by linsixin on 2017/11/29.
 * 相关免疫性,使用的是循环Walsh谱的定义
 */
public class CorrelationImmunity {

    /**
     * 求出布尔函数的阶,m阶布尔函数对于重量为m的所有向量输入
     * 其循环Walsh谱的值均为0
     * @param walsh bool函数的循环Walsh谱表示
     * @return -1 表示没有阶
     */
    public static int rankOf(LoopWalsh walsh){
        int varLen = walsh.varLength;
        if(varLen >= 20){
            System.out.println("目前20个变量长度已经需要很长的时间的了");
            System.out.println("后面还是应该使用多线程来做");
        }
        int rank = -1;
        for(int weight=1; weight<=varLen; weight++){
            boolean allResultZero = true;
            for(BoolVector v: VectorToolKt.setOfVectors(varLen,weight)){
                if(walsh.resultOf(v) != 0){
                    allResultZero = false;
                    break;
                }
            }
            if(allResultZero){
                rank = weight;
            }else break;
        }
        return rank;
    }
}
