package com.Collection;
import java.sql.*;
import java.util.*;

public class bookshop {
    private List<bookdetails> bookShops;

    public bookshop() {
        bookShops = new ArrayList<>();
    }
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Book ID, Name, Author, Price:");
        int id = scanner.nextInt();
        String name = scanner.next() + scanner.nextLine();
        String author = scanner.next() + scanner.nextLine();
        double price = scanner.nextDouble();
        scanner.nextLine();

        bookdetails shop = new bookdetails(id, name, author, price);
        dbutil db = new dbutil();
        Connection con;
        Statement stmt;
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            String query = "INSERT INTO bookdetails (ID, Name, Author, Price) VALUES (" + id + ", '" + name + "', '" + author + "', " + price + ")";
            stmt.executeUpdate(query);
            System.out.println("Book successfully added to the database!!");
        } catch (Exception e) {
            System.out.println("Error while adding book: " + e.getMessage());
        }
    }

    public void remove(int id) {
        dbutil db = new dbutil();
        Connection con;
        Statement stmt;
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            int count = stmt.executeUpdate("DELETE FROM bookdetails WHERE ID = " + id);
            if (count > 0) {
                System.out.println("Successfully removed book from the database!!");
            } else {
                System.out.println("Book with ID " + id + " not found in the database.");
            }
        } catch (Exception e) {
            System.out.println("Error while removing book: " + e.getMessage());
        }
    }

    public void buy(int id) {
        dbutil db = new dbutil();
        Connection con;
        Statement stmt;
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            int count = stmt.executeUpdate("DELETE FROM bookdetails WHERE ID = " + id);
            if (count > 0) {
                System.out.println("Successfully bought the book!!");
            } else {
                System.out.println("Book with ID " + id + " not found in the database.");
            }
        } catch (Exception e) {
            System.out.println("Error while buying book: " + e.getMessage());
        }
    }

    public void update(int id) {
        Scanner scanner = new Scanner(System.in);
        dbutil db = new dbutil();
        Connection con;
        Statement stmt;
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            System.out.println("Enter new Name, Author and Price:");
            String name = scanner.nextLine();
            String author = scanner.nextLine();
            double price = scanner.nextDouble();
            scanner.nextLine();

            String query = "UPDATE bookdetails SET Name = '" + name + "', Author = '" + author + "', Price = " + price + " WHERE ID = " + id;
            int count = stmt.executeUpdate(query);

            if (count > 0) {
                System.out.println("Book successfully updated in the database!!");
            } else {
                System.out.println("Book with ID " + id + " not found in the database.");
            }
        } catch (Exception e) {
            System.out.println("Error while updating book: " + e.getMessage());
        }
    }

    public void search(int id) {
        dbutil db = new dbutil();
        Connection con;
        Statement stmt;
        ResultSet rs;
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM bookdetails WHERE ID = " + id);
            if (rs.next()) {
                System.out.println("Book ID: " + rs.getInt("ID"));
                System.out.println("Book Name: " + rs.getString("Name"));
                System.out.println("Author Name: " + rs.getString("Author"));
                System.out.println("Book Price: $" + rs.getDouble("Price"));
            } else {
                System.out.println("Book with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.out.println("Error while searching book: " + e.getMessage());
        }
    }

    public void show() {
        dbutil db = new dbutil();
        Connection con;
        Statement stmt;
        ResultSet rs;
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM bookdetails");

            if (!rs.isBeforeFirst()) {
                System.out.println("No Books available in the database.");
                return;
            }

            System.out.println("Book details:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + ", Name: " + rs.getString("Name") + ", Author: " + rs.getString("Author") + ", Price: $" + rs.getDouble("Price"));
            }
        } catch (Exception e) {
            System.out.println("Error while fetching book details: " + e.getMessage());
        }
    }
}
