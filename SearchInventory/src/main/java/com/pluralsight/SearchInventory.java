package com.pluralsight;
import java.io.*;
import java.util.*;

public class SearchInventory {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventoryFromFile("inventory.csv");

        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- Lookup a product by its ID");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");
            System.out.print("Enter command: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    inventory.sort(Comparator.comparing(Product::getName));
                    for (Product p : inventory) {
                        System.out.println(p);
                    }
                    break;
                case "2":
                    System.out.print("Enter product ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Product found = inventory.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
                    System.out.println(found != null ? found : "Product not found.");
                    break;
                case "3":
                    System.out.print("Enter min price: ");
                    double min = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter max price: ");
                    double max = Double.parseDouble(scanner.nextLine());
                    inventory.stream()
                            .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                            .forEach(System.out::println);
                    break;
                case "4":
                    System.out.print("Enter new product ID: ");
                    int newId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    inventory.add(new Product(newId, name, price));
                    System.out.println("Product added.");
                    break;
                case "5":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static ArrayList<Product> getInventoryFromFile(String fileName) {
        ArrayList<Product> inventory = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            // Default fallback if file doesn't exist
            inventory.add(new Product(4567, "10' 2x4 (grade B)", 9.99));
            inventory.add(new Product(1234, "Hammer", 19.49));
            inventory.add(new Product(2345, "Box of nails", 9.29));
            System.out.println("CSV not found. Using hardcoded data.");
            return inventory;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    inventory.add(new Product(id, name, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return inventory;
    }
}

