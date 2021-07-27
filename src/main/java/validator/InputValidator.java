package validator;

/**
 * Package: validator
 * <p>
 * User: TetenNugraha
 * Date: 7/26/2021
 * Time: 3:22 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class InputValidator {
    public static boolean isValidInput(String input) {
        if(input.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isValidSlotNumber(int number) {
        if(number <= 0) {
            return false;
        }
        return true;
    }
}
