package Java_6;
import java.util.Scanner;
import java.util.TreeSet;
public class CityDirectorySet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TreeSet<String> cities = new TreeSet<>();
        int numberOfCities;
        String cityName;
        String searchCity;
        String directoryClassification;
        System.out.println("Enter the number of cities:");
        numberOfCities = input.nextInt();
        input.nextLine();
        if (numberOfCities <= 0) {
            System.out.println("Invalid number of cities.");
        } else {
            for (int i = 1; i <= numberOfCities; i++) {
                System.out.println("Enter city name " + i + ":");
                cityName = input.nextLine();
                if (!cities.add(cityName)) {
                    System.out.println("City already exists. Duplicate entries are not allowed.");
                }
            }
            System.out.println("Enter a city name to search:");
            searchCity = input.nextLine();
            if (cities.contains(searchCity)) {
                System.out.println("City found in the directory.");
            } else {
                System.out.println("City not found in the directory.");
            }
            if (cities.size() < 5) {
                directoryClassification = "Small Directory";
            } else if (cities.size() >= 5 && cities.size() <= 10) {
                directoryClassification = "Medium Directory";
            } else {
                directoryClassification = "Large Directory";
            }
            System.out.println("\n City Directory Report ");
            System.out.println("Total Cities Entered: " + numberOfCities);
            System.out.println("Total Unique Cities: " + cities.size());
            System.out.println("All Cities in Alphabetical Order: " + cities);
            System.out.println("Directory Classification: " + directoryClassification);
        }
        input.close();
    }
}
