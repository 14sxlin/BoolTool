package entity.walsh;

import entity.bool.BoolResult;
import entity.bool.BoolVector;

/**
 * Created by linsixin on 2017/11/26.
 * 循环Walsh谱
 */
public class LoopWalsh extends Walsh{

    LoopWalsh(BoolResult boolFun,int varLength){
        super(boolFun,varLength);
    }

    @Override
    public int rawResultOf(BoolVector w) {
        int result = 0;
        for(int i=0; i < varLength ; i++){
            BoolVector x = BoolVector.createBoolVector(i,w.getLength());
            result +=  _1power(f(x) + w.multiply(x)) ;
        }
        result %= 2;
        return result;
    }
}
