package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        FileInputStream fis = null;

        try {
            fis = new FileInputStream("jokes.txt");

            Scanner fileScanner = new Scanner(fis);

            String currentLine;

            while (fileScanner.hasNextLine()) {
                currentLine = fileScanner.nextLine();
                System.out.println(currentLine);
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("There was an issue with the file.");
            System.out.println(e.getMessage());
        }




    }
}