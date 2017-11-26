package entity.multinomial;

import entity.bool.BoolResult;
import entity.bool.BoolVector;

/**
 * Created by linsixin on 2017/11/23.
 * GF(2) 多项式的 项
 */
public abstract class Term implements BoolResult{

    /**
     * 变量是否在此项中
     * 比如 长度为2的elems = [true,true] 表示 x0x1
     *     长度为3的elems = [true,false,true] 表示 x0x2
     */
    protected boolean[] elems;


    Term(){}

    Term(boolean []elems){
        this.elems = elems;
        elemsCheck();
    }

    void elemsCheck(){
        if(elems == null || elems.length < 1)
            throw new IllegalArgumentException("variable should not be null or empty");
        for(boolean e:elems){
            if(e) return;
        }
        throw new IllegalArgumentException("There should be a least one variable");
    }

    /**
     * @return 布尔函数的输入变量的个数
     */
    public int getVarLen(){
        return elems.length;
    }


    @Override
    public int resultOf(BoolVector x) {
        if(x.getLength() != elems.length)
            throw new IllegalArgumentException("x.length should equal to var length");
        for(int i=0; i< elems.length; i++){
            if (elems[i] && !x.boolAt(i)) { // 某一位存在 但是 输入中该位是0,该项为0
                return 0;
            }
        }
        return 1;
    }
}
