package entity.bool;

/**
 * Created by linsixin on 2017/11/26.
 */
public enum BoolValue {
    ZERO(0),ONE(1);

    public int toInt;
    public boolean toBool = false;

    BoolValue(int i){
        assert 0 <=i && i<= 1;
        toInt = i;
        toBool = i == 1;
    }
}
