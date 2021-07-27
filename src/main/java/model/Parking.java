package model;

import exception.InvalidVehicleNumber;
import exception.NoEmptySlotAvailable;
import strategy.ParkingCostStrategy;
import validator.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Package: model
 * <p>
 * User: TetenNugraha
 * Date: 7/27/2021
 * Time: 9:03 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class Parking implements ParkingFloor {

    private static Parking parkingLot;
    private final int floorNumber;
    private final List<Slot> slots;

    public Parking(int floorNumber) {
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();
    }

    public static Parking getParkingFloor(int floorNumber) {
        if (parkingLot == null)
            parkingLot = new Parking(floorNumber);
        return parkingLot;
    }

    public static void clearAll() {
        parkingLot = null;
    }

    private Slot getNextEmptySlotOnFloor() throws NoEmptySlotAvailable {
        for (Slot slot : slots) {
            if (!slot.isEmpty()) {
                return slot;
            }
        }
        throw new NoEmptySlotAvailable("For floorNumber " + floorNumber + " No Empty Slot available");
    }

    @Override
    public boolean createParkingSLot(int numberOfSlots) {
        if (inputValidator(InputValidator.isValidSlotNumber(numberOfSlots)) || slots.size() > 0)
            return false;

        for (int i = 1; i <= numberOfSlots; i++) {
            slots.add(new Slot(UUID.randomUUID().toString(), i));
        }
        System.out.printf("Created a parking lot with %s slots %n", numberOfSlots);
        return true;
    }

    private boolean inputValidator(boolean validSlotNumber) {
        if (!validSlotNumber) {
            return true;
        }
        return false;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) throws NoEmptySlotAvailable {
        Slot nextEmptySlotOnFloor = getNextEmptySlotOnFloor();
        nextEmptySlotOnFloor.placeVehicle(vehicle);
        System.out.printf("Allocated slot number: %d \n", nextEmptySlotOnFloor.getSlotNumber());
        return true;
    }

    @Override
    public int unPark(String vehicleNumber, int numberOfHours, ParkingCostStrategy parkingCostStrategy) throws InvalidVehicleNumber {
        int costByHours=0;
        try{
            Slot slot = getSlotByVehicleNumber(vehicleNumber);
            slot.removeVehicle();
            costByHours = getCostByHours(numberOfHours, parkingCostStrategy);
            System.out.println("Registration number " + vehicleNumber + " with slot number " + slot.getSlotNumber() +
                    " is free with Charge " + costByHours);
        }catch (InvalidVehicleNumber invalidVehicleNumber) {
            System.out.println(invalidVehicleNumber.getMessage());
            throw invalidVehicleNumber;
        }
        return costByHours;
    }

    private int getCostByHours(int numberOfHours, ParkingCostStrategy parkingCostStrategy) {
        return parkingCostStrategy.getCost(numberOfHours);
    }

    private Slot getSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumber {
        for(Slot slot: slots) {
            Vehicle vehicle = slot.getParkVehicle();
            if(vehicle != null && vehicle.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                return slot;
            }
        }
        throw new InvalidVehicleNumber("Registration number "+ vehicleNumber+ " not found");
    }

    public void printStatus() {
        System.out.println("Slot No.  Registration No");
        slots.forEach(slot -> {
            if (!slots.isEmpty()) {
                Vehicle parkVehicle = slot.getParkVehicle();
                if (parkVehicle != null)
                    System.out.printf("   %d       %s\n", slot.getSlotNumber(), parkVehicle.getVehicleNumber());
            }
        });
    }
}
