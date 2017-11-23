package entity.multinomial;

/**
 * Created by linsixin on 2017/11/23.
 */
public abstract class Term {

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
}
