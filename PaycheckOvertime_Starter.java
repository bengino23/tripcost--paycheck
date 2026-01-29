import java.util.Scanner;

public class PaycheckOvertime_Starter {
    public static void main(String[] args) {

        // Named constants (requirements)
        final double OVERTIME_THRESHOLD = 40.0;
        final double OVERTIME_MULTIPLIER = 1.5;

        Scanner keyboard = new Scanner(System.in);

        /*
         * Data type choices:
         * - String for name (text).
         * - double for hours and rate because they may include decimals (e.g., 38.5 hours, $17.25/hr).
         * - int for retirement percent because it's typically entered as a whole number (e.g., 5 for 5%).
         * - char for Y/N choice.
         */
        System.out.print("Employee name: ");
        String name = keyboard.nextLine();

        System.out.print("Hours worked: ");
        double hoursWorked = keyboard.nextDouble();

        System.out.print("Hourly rate: ");
        double hourlyRate = keyboard.nextDouble();

        System.out.print("Retirement contribution percent (0-100): ");
        int percent = keyboard.nextInt();

        System.out.print("Print detailed pay stub? (Y/N): ");
        char detailChoice = keyboard.next().charAt(0);

        // Validation using if/else
        if (hoursWorked < 0) {
            System.out.println("Error: hours worked cannot be negative.");
            return;
        } else if (hourlyRate < 0) {
            System.out.println("Error: hourly rate cannot be negative.");
            return;
        } else if (percent < 0 || percent > 100) {
            System.out.println("Error: retirement percent must be between 0 and 100.");
            return;
        }

        /*
         * Regular hours are capped at 40; overtime is anything above 40.
         * - min and max logic demonstrated using if/else instead of Math.min/Math.max (basic control flow).
         */
        double regularHours;
        double overtimeHours;

        if (hoursWorked > OVERTIME_THRESHOLD) {
            regularHours = OVERTIME_THRESHOLD;
            overtimeHours = hoursWorked - OVERTIME_THRESHOLD;
        } else {
            regularHours = hoursWorked;
            overtimeHours = 0.0;
        }

        // Arithmetic (+, -, *, /) and constant multiplier (1.5) for overtime pay
        double grossPay = (regularHours * hourlyRate) + (overtimeHours * hourlyRate * OVERTIME_MULTIPLIER);

        // Type conversion: percent / 100.0 forces floating-point math (not integer division)
        double retirementRate = percent / 100.0;
        double retirementDeduction = grossPay * retirementRate;

        double netPay = grossPay - retirementDeduction;

        // Use a boolean (primitive) to drive detailed output
        boolean detailed = (detailChoice == 'Y' || detailChoice == 'y');

        System.out.println("\n--- Paycheck & Overtime Calculator ---");

        if (detailed) {
            System.out.printf("Employee: %s%n", name);
            System.out.printf("Hours Worked: %.2f%n", hoursWorked);
            System.out.printf("Regular Hours: %.2f%n", regularHours);
            System.out.printf("Overtime Hours: %.2f%n", overtimeHours);
            System.out.printf("Hourly Rate: $%.2f%n", hourlyRate);
            System.out.printf("Overtime Multiplier: %.2f%n", OVERTIME_MULTIPLIER);
        } else {
            System.out.printf("Employee: %s%n", name);
        }

        System.out.printf("Gross Pay: $%.2f%n", grossPay);
        System.out.printf("Retirement (%d%%): -$%.2f%n", percent, retirementDeduction);
        System.out.printf("Net Pay: $%.2f%n", netPay);

        keyboard.close();
    }
}
