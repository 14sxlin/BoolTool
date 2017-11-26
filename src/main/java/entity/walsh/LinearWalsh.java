package entity.walsh;

import entity.bool.BoolResult;
import entity.bool.BoolVector;

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
    public int rawResultOf(BoolVector w){
        int result = 0;
        for(int i=0; i< varLength ; i++){
            BoolVector x = BoolVector.createBoolVector(i,w.getLength());
            result +=  f(x) * _1power(w.multiply(x)) ;
        }
        result %= 2;
        return result;
    }

}
