package entity.walsh;

import entity.bool.BoolResult;
import entity.bool.BoolVector;
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
        if(varLength <= 0)
            throw new IllegalArgumentException("varLength should > 0");
        if(varLength > 31)
            throw new IllegalArgumentException("varLength should <= 31");
        this.boolFun = boolFun;
        this.varLength = varLength;

    }

    /**
     * 计算 walsh 谱的值
     * @param w walsh谱的输入
     */
    public double resultOf(BoolVector w){
        return rawResultOf(w) / Math.pow(2.0,varLength);
    };

    /**
     * walsh 谱的值, 不乘上 1/(2^n)
     */
    public abstract int rawResultOf(BoolVector w);

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
    protected int f(BoolVector x){
        return boolFun.resultOf(x);
    }

    protected int maxInput(){
        long max = (long)((1 << varLength) - 1);
        if(max > Integer.MAX_VALUE)
            throw new IllegalArgumentException("var length too large");
        return (int)max;
    }
}
