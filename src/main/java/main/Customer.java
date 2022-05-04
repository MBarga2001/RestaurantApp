package main;

import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    static final String DB_URL = "jdbc:mysql://localhost/restaurant";
    static final String USER = "root";
    static final String PASS = "admin";

    public Customer() {
        username = "";
        firstName = "";
        lastName = "";
        email = "";
        phone = "";
        password = "";
    }

    public Customer(String username, String firstName, String lastName, String email, String phone, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            System.out.println("Inserting records into Customer table...");
            String sql = "Insert INTO `customers` (username, first_name, last_name, email, phone, password) VALUES ('" + this.username + "', '" + this.firstName + "', '"  + this.lastName + "', '" + this.email + "', '" + this.phone + "', '" + this.password + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(String email) {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
