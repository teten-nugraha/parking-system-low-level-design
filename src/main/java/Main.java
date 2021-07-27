import command.Command;
import command.CommandImpl;
import validator.InputValidator;

import java.util.Scanner;

/**
 * Package: PACKAGE_NAME
 * <p>
 * User: TetenNugraha
 * Date: 7/26/2021
 * Time: 3:19 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        printCommands();
        readCommandAndExecute();
    }

    private static void readCommandAndExecute() {
        String inputLine;
        Scanner scanner = new Scanner(System.in);
        do {
            inputLine = scanner.nextLine();
            if(InputValidator.isValidInput(inputLine)) {
                String[]input = inputLine.split(" ");
                Command cmd;
                try{
                    cmd = CommandImpl.valueOf(input[0]);
                    cmd.executeCommand(input);
                }catch (Exception e) {
                    System.out.println("Please provide valid command ....");
                }
            }
        }while(!inputLine.equalsIgnoreCase("exit"));
    }

    private static void printCommands() {
        System.out.println("***************************************************************************************");
        System.out.println("**********************  WELCOME TO PARKING SYSTEM APPLICATION  ************************");
        System.out.println("***************************************************************************************");
        System.out.println("*******************************  SAMPLE INPUT COMMANDS  *******************************");
        System.out.println("1. create_parking_lot {capacity}");
        System.out.println("2. park {car_number}");
        System.out.println("3. leave {VehicleNUmber} {hours}");
        System.out.println("4. status");
    }
}
