package command;

import exception.InvalidVehicleNumber;
import exception.NoEmptySlotAvailable;
import model.Parking;
import model.Vehicle;
import strategy.DefaultStrategy;

/**
 * Package: command
 * <p>
 * User: TetenNugraha
 * Date: 7/27/2021
 * Time: 9:26 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public enum  CommandImpl implements Command {

    create_parking_lot {
        @Override
        public void executeCommand(String[] commands) {
            floor.createParkingSLot(Integer.parseInt(commands[1]));
        }
    },
    park {
        @Override
        public void executeCommand(String[] commands) {
            try{
                floor.parkVehicle(new Vehicle(commands[1]));
            }catch (NoEmptySlotAvailable noEmptySlotAvailable){
                System.out.println("Sorry, parking lot is full");
            }
        }
    },
    leave {
        @Override
        public void executeCommand(String[] commands) {
            try{
                floor.unPark(commands[1], Integer.parseInt(commands[2]), new DefaultStrategy());
            }catch (InvalidVehicleNumber e) {
                System.out.println(e.getMessage());
            }
        }
    },
    status {
        @Override
        public void executeCommand(String[] commands) {
            floor.printStatus();
        }
    },
    exit {
        @Override
        public void executeCommand(String[] commands) {
            System.out.println("Thank you ....");
            System.exit(1);
        }
    };

    Parking floor = Parking.getParkingFloor(1);
}
