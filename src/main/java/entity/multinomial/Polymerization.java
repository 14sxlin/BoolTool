package entity.multinomial;

import entity.bool.BoolResult;
import entity.bool.BoolVector;

import java.util.HashSet;

/**
 * Created by linsixin on 2017/11/24.
 * 代表了 GF(2) -> GF(2) 的多项式
 */
public abstract class Polymerization<T extends Term> implements BoolResult{

    /**
     * 多项式输入变量的长度
     * 如果多项式只有常数项1 , 那么变量的数目无法确定
     * 此时varLength 为 { @See OneTerm } 的 varLength 也就是 -1
     */
    protected int varLength;

    protected HashSet<T> terms;

    protected void checkAndInitVarLength(){
        int length = -1;
        for(Term term:terms){
            if(length == -1)
                length = term.getVarLen();
            else{
                if(length != term.getVarLen())
                    throw new IllegalArgumentException("terms should have same variable length");
            }
        }
        this.varLength = length;
    }


    @Override
    public int resultOf(BoolVector x) {
        if(varLength == -1) // only OneTerm,no matter what input , result is 1
            return 1;
        int result = 0;
        for(Term term:terms){
            result += term.resultOf(x);
            result %= 2;
        }
        return result;
    }
}
