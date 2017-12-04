package entity.walsh;

import entity.bool.BoolFunction;
import entity.bool.BoolVector;

/**
 * Created by linsixin on 2017/11/24.
 */
public abstract class Walsh extends BoolFunction {

    /**
     * 能够求得bool函数值的函数
     */
    public BoolFunction boolFun;

    /**
     * 布尔函数输入变量的个数
     */
    public int varLength;


    public Walsh(BoolFunction boolFun,int varLength){
        super(varLength);
        if(varLength <= 0)
            throw new IllegalArgumentException("varLength should > 0");
        if(varLength > 31)
            throw new IllegalArgumentException("varLength should <= 31");
        this.boolFun = boolFun;
        this.varLength = varLength;

    }

    /**
     * 计算 walsh 谱的值, 实现的时候需要乘上 1/(2^n)
     * @param w walsh谱的输入
     */
    public double walshResult(BoolVector w){
        return resultOf(w) / Math.pow(2.0,varLength);
    };

    /**
     * walsh 谱的值, 不乘上 1/(2^n)
     */
    public abstract int resultOf(BoolVector w);

    /**
     * (-1)^pow
     */
    public final int _1power(int pow) {
        if(pow % 2 == 0)
            return 1;
        else return -1;
    }

    /**
     * 对应输入x 布尔函数的输出值
     */
    public int f(BoolVector x){
        return boolFun.resultOf(x);
    }

    /**
     * walsh谱的重量为其对应的布尔函数的重量
     */
    @Override
    public int weight() {
        return boolFun.weight();
    }

}
