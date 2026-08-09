package Java_6;
import java.util.HashMap;
import java.util.Scanner;
public class ProductPriceCatalog {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, Double> products = new HashMap<>();
        int numberOfProducts;
        String productName;
        String searchProduct;
        String updateChoice;
        double productPrice;
        double newPrice;
        String inventoryClassification;
        System.out.println("Enter the number of products:");
        numberOfProducts = input.nextInt();
        input.nextLine();
        if (numberOfProducts <= 0) {
            System.out.println("Invalid number of products.");
        } else {
            for (int i = 1; i <= numberOfProducts; i++) {
                System.out.println("Enter Product Name " + i + ":");
                productName = input.nextLine();
                if (products.containsKey(productName)) {
                    System.out.println("Product already exists. Record not added.");
                } else {
                    System.out.println("Enter Product Price:");
                    productPrice = input.nextDouble();
                    input.nextLine();
                    products.put(productName, productPrice);
                }
            }
            System.out.println("Enter a product name to search:");
            searchProduct = input.nextLine();
            if (products.containsKey(searchProduct)) {
                System.out.println("Current Price: " + products.get(searchProduct));
                System.out.println("Do you want to update the price? (Y/N)");
                updateChoice = input.nextLine();
                if (updateChoice.equalsIgnoreCase("Y")) {
                    System.out.println("Enter the new price:");
                    newPrice = input.nextDouble();
                    products.replace(searchProduct, newPrice);
                    System.out.println("Price updated successfully.");
                }
            } else {
                System.out.println("Product not found.");
            }
            if (products.size() < 5) {
                inventoryClassification = "Small Inventory";
            } else if (products.size() >= 5 && products.size() <= 10) {
                inventoryClassification = "Medium Inventory";
            } else {
                inventoryClassification = "Large Inventory";
            }
            System.out.println("\n Product Catalog Report ");
            System.out.println("Total Products Entered: " + numberOfProducts);
            System.out.println("Total Unique Products: " + products.size());
            System.out.println("Product Names and Prices:");
            for (String product : products.keySet()) {
                System.out.println(product + " : " + products.get(product));
            }
            System.out.println("Inventory Classification: " + inventoryClassification);
        }
        input.close();
    }
}
