import java.util.Scanner;
import java.util.Random;

public class FamousQuotes {
    public static void main(String[] args) {
        String[] quotes = {
                "The only limit to our realization of tomorrow is our doubts of today.",
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "Life is what happens when you're busy making other plans.",
                "Do not go where the path may lead, go instead where there is no path and leave a trail.",
                "In the end, we will remember not the words of our enemies, but the silence of our friends.",
                "The purpose of our lives is to be happy.",
                "Be yourself; everyone else is already taken.",
                "You miss 100% of the shots you don’t take.",
                "Whether you think you can or you think you can’t, you’re right.",
                "The best way to predict your future is to create it."
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nPick a number between 1 and 10 to see a quote, or type 0 for a random quote:");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline from buffer

                if (choice == 0) {
                    int randomIndex = random.nextInt(quotes.length);
                    System.out.println("Random Quote: " + quotes[randomIndex]);
                } else if (choice >= 1 && choice <= 10) {
                    System.out.println("Your quote: " + quotes[choice - 1]);
                } else {
                    System.out.println("That number is out of range. Please choose between 1 and 10 or 0 for random.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the bad input
            }

            System.out.print("Would you like to see another quote? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("yes") && !again.equals("y")) {
                keepGoing = false;
                System.out.println("Goodbye!");
            }
        }
    }
}
