package main;

import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Address {
    private String street;
    private String city;
    private String state;
    private int postalCode;
    private String country;

    static final String DB_URL = "jdbc:mysql://localhost/restaurant";
    static final String USER = "root";
    static final String PASS = "admin";

    public Address() {
        street = "";
        city = "";
        state = "";
        postalCode = 0;
        country = "";
    }

    public Address(String street, String city, String state, int postalCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            System.out.println("Inserting records into Address table...");
            String sql = "Insert INTO `address` (street, city, state, postal_code, country) VALUES ('" + this.street + "', '" + this.city + "', '" + this.state + "', " + this.postalCode + ", '" + this.country + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
