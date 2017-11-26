package entity.bool;

/**
 * Created by linsixin on 2017/11/22.
 * This class represent a bool function,
 * providing the method of a bool function
 */
public interface BoolFunction extends BoolResult {

    boolean isAffine();

    boolean isLinear();

}
