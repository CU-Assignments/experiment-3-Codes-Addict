import java.util.Scanner;

public class squareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        try {
            double number = sc.nextDouble();
            if (number < 0) {
                throw new IllegalArgumentException("negative number.");
            }
            double result = Math.sqrt(number);
            System.out.println("Square root = " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } finally {
            sc.close();
        }
    }
}
