package model;

import exception.InvalidVehicleNumber;
import exception.NoEmptySlotAvailable;
import strategy.ParkingCostStrategy;

/**
 * Package: model
 * <p>
 * User: TetenNugraha
 * Date: 7/26/2021
 * Time: 3:47 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingFloor {

    boolean createParkingSLot(int numberOfSlots);

    boolean parkVehicle(Vehicle vehicle) throws NoEmptySlotAvailable;

    int unPark(String vehicleNumber, int numberOfHours, ParkingCostStrategy parkingCostStrategy) throws InvalidVehicleNumber;
}

