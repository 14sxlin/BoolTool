package entity.walsh;

import entity.bool.BoolResult;

/**
 * Created by linsixin on 2017/11/26.
 * 循环Walsh谱
 */
public class LoopWalsh extends Walsh{

    LoopWalsh(BoolResult boolFun,int varLength){
        super(boolFun,varLength);
    }

    @Override
    public int rawResultOf(int w) {
        int result = 0;
        for(int x=0; x< varLength ; x++){
            result +=  _1power(f(x) + vectorMultiply(w,x)) ;
        }
        result %= 2;
        return result;
    }

}
