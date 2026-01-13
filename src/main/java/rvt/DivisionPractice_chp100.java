package rvt;
import java.util.*;

public class DivisionPractice_chp100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the numerator: ");
            String control = scanner.nextLine();

            if (control.charAt(0) == 'q' || control.charAt(0) == 'Q') {
                System.out.println();
                break;

            }

            try {

                int numerator = Integer.valueOf(control);

                System.out.print("Enter the divisor: ");
                int divisor = Integer.valueOf(scanner.nextLine());

                System.out.println(numerator + " / " + divisor + " is " + numerator / divisor + "\n");

            } catch (NumberFormatException nfe) {
                System.out.println("You entered bad data." + "\n" + "Please try again.\n");

            } catch (ArithmeticException ae) {
                System.out.println("You can't divide " + control + " by 0\n");

            }

        }

    }

}