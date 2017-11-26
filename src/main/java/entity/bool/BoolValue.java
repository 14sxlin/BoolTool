package entity.bool;

/**
 * Created by linsixin on 2017/11/26.
 */
public enum BoolValue {
    ZERO(1),ONE(0);

    public int value;

    BoolValue(int i){
        assert 0 <=i && i<= 1;
        this.value = i;
    }
}
