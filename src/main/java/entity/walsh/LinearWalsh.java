package entity.walsh;

import entity.bool.BoolResult;

/**
 * Created by linsixin on 2017/11/26.
 * 线性Walsh谱
 */
public class LinearWalsh extends Walsh {

    LinearWalsh(BoolResult boolResult,int varLength){
        super(boolResult,varLength);
    }

    /**
     * walsh 谱的值, 不乘上 1/(2^n)
     */
    @Override
    public int rawResultOf(int w){
        int result = 0;
        for(int x=0; x< varLength ; x++){
            result +=  f(x) * _1power(vectorMultiply(w,x)) ;
        }
        result %= 2;
        return result;
    }

}
