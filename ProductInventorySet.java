package Java_6;
import java.util.HashSet;
import java.util.Scanner;
public class ProductInventorySet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<String> products = new HashSet<>();
        int numberOfProducts;
        String productName;
        String searchProduct;
        String inventoryClassification;
        System.out.println("Enter the number of products:");
        numberOfProducts = input.nextInt();
        input.nextLine();
        if (numberOfProducts <= 0) {
            System.out.println("Invalid number of products.");
        } else {
            for (int i = 1; i <= numberOfProducts; i++) {
                System.out.println("Enter product name " + i + ":");
                productName = input.nextLine();

                if (!products.add(productName)) {
                    System.out.println("Product already exists. Duplicate entries are not allowed.");
                }
            }
            System.out.println("Enter a product name to search:");
            searchProduct = input.nextLine();
            if (products.contains(searchProduct)) {
                System.out.println("Product found in inventory.");
            } else {
                System.out.println("Product not found in inventory.");
            }
            if (products.size() < 5) {
                inventoryClassification = "Small Inventory";
            } else if (products.size() >= 5 && products.size() <= 10) {
                inventoryClassification = "Medium Inventory";
            } else {
                inventoryClassification = "Large Inventory";
            }
            System.out.println("\n Inventory Report ");
            System.out.println("Total Products Entered: " + numberOfProducts);
            System.out.println("Total Unique Products: " + products.size());
            System.out.println("All Products in Inventory: " + products);
            System.out.println("Inventory Classification: " + inventoryClassification);
        }
        input.close();
    }
}
