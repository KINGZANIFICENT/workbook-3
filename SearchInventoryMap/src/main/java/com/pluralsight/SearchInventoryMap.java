package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SearchInventoryMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> inventory = loadInventory();

        String again;
        do {
            System.out.print("Enter the product name to search: ");
            String searchName = scanner.nextLine();
            // ignores key sensitivity 
            Product product = null;
            for (String key : inventory.keySet()) {
                if (key.equalsIgnoreCase(searchName)) {
                    product = inventory.get(key);
                    break;
                }
            }

            if (product != null) {
                System.out.println("Product found: " + product);
            } else {
                System.out.println("Product not found.");
            }
            System.out.print("Do you want to search again? (yes/no): ");
            again = scanner.nextLine().toLowerCase();
        } while (again.equals("yes"));

        System.out.println("Thank you for using the Inventory Search.");
    }

    private static Map<String, Product> loadInventory() {
        Map<String, Product> inventory = new HashMap<>();
        File file = new File("inventory.csv");

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    inventory.put(name, new Product(id, name, price));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }

        return inventory;
    }
}

