package entity.walsh;

import entity.bool.BoolFunction;
import entity.bool.BoolResult;
import entity.bool.BoolVector;

/**
 * Created by linsixin on 2017/11/26.
 * 循环Walsh谱
 */
public class LoopWalsh extends Walsh {

    public LoopWalsh(BoolFunction boolFun, int varLength){
        super(boolFun,varLength);
    }

    @Override
    public int resultOf(BoolVector w) {
        int result = 0;
        for(int i=0; i <= maxInput(); i++){
            BoolVector x = BoolVector.createBoolVector(i,w.getLength());
            result +=  _1power(f(x) + w.multiply(x)) ;
        }
        return result;
    }
}
