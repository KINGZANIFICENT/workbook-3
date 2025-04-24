package com.pluralsight;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // Ask user for the file name
        System.out.print("Enter the name of a story (e.g., goldilocks.txt): ");
        String fileName = inputScanner.nextLine();

        // Attempt to open and read the file
        try {
            File storyFile = new File(fileName);
            Scanner fileScanner = new Scanner(storyFile);

            int lineNumber = 1;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(lineNumber + ". " + line);
                lineNumber++;
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("the file \"" + fileName + "\" was not found.");
        }

        inputScanner.close();
    }
}
