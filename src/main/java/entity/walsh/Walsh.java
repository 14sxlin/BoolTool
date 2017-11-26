package entity.walsh;

import entity.bool.BoolResult;
import entity.bool.TransformUtilsKt;

/**
 * Created by linsixin on 2017/11/24.
 */
public abstract class Walsh {

    /**
     * 能够求得bool函数值的函数
     */
    protected BoolResult boolFun;

    /**
     * 布尔函数输入变量的个数
     */
    protected int varLength;


    public Walsh(BoolResult boolFun,int varLength){
        this.boolFun = boolFun;
        this.varLength = varLength;
    }

    /**
     * 计算 walsh 谱的值
     * @param w walsh谱的输入
     */
    public double resultOf(int w){
        return rawResultOf(w) / Math.pow(2.0,varLength);
    };

    /**
     * walsh 谱的值, 不乘上 1/(2^n)
     */
    public abstract int rawResultOf(int w);

    /**
     * (-1)^pow
     */
    protected final int _1power(int pow) {
        if(pow % 2 == 0)
            return 1;
        else return -1;
    }

    /**
     * 对应输入x 布尔函数的输出值
     */
    protected int f(int x){
        return boolFun.resultOf(x);
    }

    /**
     * 计算 w 和 x 的内积
     * @param w 向量转换成10进制的数
     * @param x 向量转换成10进制的数
     */
    protected int vectorMultiply(int w, int x){
        int[] wArray = TransformUtilsKt.int2IntArray(w,varLength);
        int[] xArray = TransformUtilsKt.int2IntArray(x,varLength);
        return vectorMultiply(wArray,xArray);
    }

    /**
     * 计算 w 和 x 的内积
     * @param wArray w 向量
     * @param xArray x 向量
     */
    protected int vectorMultiply(int[] wArray, int[] xArray){
        int result = 0;
        for(int i = 0; i<wArray.length ; i++){
            result += wArray[i] * xArray[i];
        }
        result %= 2;
        return result;
    }



}
