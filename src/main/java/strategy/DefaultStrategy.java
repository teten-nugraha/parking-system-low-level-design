package strategy;

/**
 * Package: strategy
 * <p>
 * User: TetenNugraha
 * Date: 7/27/2021
 * Time: 9:02 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class DefaultStrategy implements ParkingCostStrategy {
    @Override
    public int getCost(int parkHours) {
        if (parkHours < 2) {
            return 10;
        }
        return (parkHours  - 2) * 10 + 10;
    }
}
