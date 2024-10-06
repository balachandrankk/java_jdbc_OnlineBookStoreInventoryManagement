package com.Collection;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bookshop inventory = new bookshop();
        user currentUser = new user();
        int choice;
        System.out.println("Welcome to Online BookStore Inventory Management");
        while (true) {
            boolean loggedIn = false;
            boolean isAdmin = false;
            while (!loggedIn) {
                System.out.println("\nLogin Details");
                System.out.println("Enter Username:");
                currentUser.setName(scanner.nextLine());
                System.out.println("Enter Password:");
                currentUser.setPass(scanner.nextLine());

                if (currentUser.getName().equals("admin") && currentUser.getPass().equals("admin")) {
                    loggedIn = true;
                    isAdmin = true;
                    System.out.println("Successfully logged in as Admin.");
                } else if (currentUser.getName().equals("user") && currentUser.getPass().equals("user")) {
                    loggedIn = true;
                    System.out.println("Successfully logged in as User.");
                } else {
                    System.out.println("Invalid login. Please try again.");
                }
            }

            if (isAdmin) {
                do {
                    System.out.println("\nAdmin Options");
                    System.out.println("1. Add");
                    System.out.println("2. Remove");
                    System.out.println("3. Update");
                    System.out.println("4. Search");
                    System.out.println("5. Show");
                    System.out.println("6. Log out");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            inventory.add();
                            break;
                        case 2:
                            System.out.println("Enter ID of the book to remove:");
                            int removeId = scanner.nextInt();
                            inventory.remove(removeId);
                            break;
                        case 3:
                            System.out.println("Enter ID of the book to update:");
                            int updateId = scanner.nextInt();
                            inventory.update(updateId);
                            break;
                        case 4:
                            System.out.println("Enter ID of the book to search:");
                            int searchId = scanner.nextInt();
                            inventory.search(searchId);
                            break;
                        case 5:
                            inventory.show();
                            break;
                        case 6:
                            System.out.println("Logged out Successfully.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } while (choice != 6);

            } else {
                do {
                    System.out.println("\nUser Options:");
                    System.out.println("1. Show");
                    System.out.println("2. Search");
                    System.out.println("3. Buy");
                    System.out.println("4. Log out");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            inventory.show();
                            break;
                        case 2:
                            System.out.println("Enter ID of the book to search:");
                            int searchId = scanner.nextInt();
                            inventory.search(searchId);
                            break;
                        case 3:
                        	System.out.println("Enter ID to Buy:");
                        	int buyID=scanner.nextInt();
                        	inventory.buy(buyID);
                        	break;
                        case 4:
                            System.out.println("Logged out Successfully.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } while (choice != 4);
            }
        }
    }
}
