import java.util.Scanner;

public class TripCostAnalyzer_Starter {
    public static void main(String[] args) {

        // Named constant: minimum allowed MPG to avoid division by zero / unrealistic inputs
        final double MIN_MPG = 1.0;

        Scanner keyboard = new Scanner(System.in);

        /*
         * Data type choices:
         * - double for distance/mpg/price because they can include decimals (e.g., 12.5 miles, 27.8 mpg, $3.49).
         * - int for passengers because it should be a whole number count.
         */
        System.out.print("Enter distance in miles: ");
        double distance = keyboard.nextDouble();

        System.out.print("Enter vehicle fuel efficiency (miles per gallon): ");
        double mpg = keyboard.nextDouble();

        System.out.print("Enter price per gallon: ");
        double pricePerGallon = keyboard.nextDouble();

        System.out.print("Enter number of passengers: ");
        int passengers = keyboard.nextInt();

        // Validate inputs using if/else (basic control flow)
        if (distance <= 0) {
            System.out.println("Error: distance must be greater than 0.");
            return;
        } else if (mpg < MIN_MPG) {
            System.out.println("Error: mpg must be at least " + MIN_MPG + ".");
            return;
        } else if (pricePerGallon < 0) {
            System.out.println("Error: price per gallon cannot be negative.");
            return;
        }

        /*
         * Calculations:
         * - gallonsNeeded uses / because we are dividing total miles by miles-per-gallon.
         * - totalFuelCost uses * because cost = gallons * price.
         * - costPerMile uses / because we spread total cost across distance.
         */
        double gallonsNeeded = distance / mpg;
        double totalFuelCost = gallonsNeeded * pricePerGallon;
        double costPerMile = totalFuelCost / distance;

        System.out.println("\n--- Trip Cost & Fuel Analyzer ---");
        System.out.printf("Distance: %.2f miles%n", distance);
        System.out.printf("Fuel Efficiency: %.2f mpg%n", mpg);
        System.out.printf("Price per Gallon: $%.2f%n", pricePerGallon);
        System.out.printf("Gallons Needed: %.2f gallons%n", gallonsNeeded);
        System.out.printf("Total Fuel Cost: $%.2f%n", totalFuelCost);
        System.out.printf("Cost per Mile: $%.2f%n", costPerMile);

        // Only calculate cost per passenger if passengers > 0 (requirement)
        if (passengers > 0) {
            double costPerPassenger = totalFuelCost / passengers;
            System.out.printf("Passengers: %d%n", passengers);
            System.out.printf("Cost per Passenger: $%.2f%n", costPerPassenger);
        } else {
            System.out.println("Passengers: 0 (skipped cost-per-passenger calculation)");
        }

        keyboard.close();
    }
}
