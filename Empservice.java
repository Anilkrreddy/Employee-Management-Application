package com.empmanagement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Empservice {
    private static final String URL = "jdbc:postgresql://localhost:5432/empdata?user=postgres&password=123";
    private Connection conn;

    // Constructor to initialize the database connection
    public Empservice() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL);
            System.out.println("Connected to PostgreSQL successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the ID of the employee:");
        int id = s.nextInt();
        System.out.println("Enter the name of the employee:");
        String name = s.next();
        System.out.println("Enter the age of the employee:");
        int age = s.nextInt();

        String query = "INSERT INTO employees (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fetchAll() {
        String query = "SELECT * FROM employees";
        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the ID of the employee to update:");
        int id = s.nextInt();
        System.out.println("Enter the new name of the employee:");
        String name = s.next();
        System.out.println("Enter the new age of the employee:");
        int age = s.nextInt();

        String query = "UPDATE employees SET name = ?, age = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Employee updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the ID of the employee to delete:");
        int id = s.nextInt();

        String query = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Employee deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
