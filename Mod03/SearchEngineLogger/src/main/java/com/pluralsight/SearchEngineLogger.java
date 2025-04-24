package com.pluralsight;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    private static final String LOG_FILE = "logs.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Log the app launch
        logAction("launch");

        while (true) {
            System.out.print("Enter a search term (X to exit): ");
            String term = scanner.nextLine().trim();

            if (term.equalsIgnoreCase("X")) {
                logAction("exit");
                System.out.println("Goodbye!");
                break;
            } else {
                logAction("search : " + term);
                System.out.println("You searched for: " + term);
            }
        }

        scanner.close();
    }

    private static void logAction(String action) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String timestamp = LocalDateTime.now().format(FORMATTER);
            writer.write(timestamp + " " + action + "\n");
        } catch (IOException e) {
            System.out.println("Failed to write to log file.");
        }
    }
}
