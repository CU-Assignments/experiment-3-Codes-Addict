import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
public class ATM {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin != CORRECT_PIN) {
                throw new InvalidPinException("Error: Invalid PIN.");
            }

            System.out.print("Withdraw Amount: ");
            double withdrawAmount = sc.nextDouble();

            if (withdrawAmount > balance) {
                throw new InsufficientBalanceException("Insufficient balance");
            }
            balance -= withdrawAmount;
            System.out.println("Withdrawal successful, Remaining Balance: " + balance);

        } catch (InvalidPinException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } finally {
            System.out.println("Current Balance: " + balance);
            sc.close();
        }
    }
}
