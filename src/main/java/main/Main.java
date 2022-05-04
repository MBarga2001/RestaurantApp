package main;

import java.lang.String;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Sign Up");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // username
        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        // first name
        Label firstNameLabel = new Label("FIrst Name:");
        GridPane.setConstraints(firstNameLabel, 0, 1);

        TextField firstNameInput = new TextField();
        GridPane.setConstraints(firstNameInput, 1, 1);

        // last name
        Label lastNameLabel = new Label("Last Name:");
        GridPane.setConstraints(lastNameLabel, 0, 2);

        TextField lastNameInput = new TextField();
        GridPane.setConstraints(lastNameInput, 1, 2);

        // email
        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 3);

        TextField emailInput = new TextField();
        GridPane.setConstraints(emailInput, 1, 3);

        // phone
        Label phoneLabel = new Label("Phone Number:");
        GridPane.setConstraints(phoneLabel, 0, 4);

        TextField phoneInput = new TextField();
        GridPane.setConstraints(phoneInput, 1, 4);

        // street
        Label streetLabel = new Label("Street:");
        GridPane.setConstraints(streetLabel, 0, 5);

        TextField streetInput = new TextField();
        GridPane.setConstraints(streetInput, 1, 5);

        // city
        Label cityLabel = new Label("City:");
        GridPane.setConstraints(cityLabel, 0, 6);

        TextField cityInput = new TextField();
        GridPane.setConstraints(cityInput, 1, 6);

        // state
        Label stateLabel = new Label("State:");
        GridPane.setConstraints(stateLabel, 0, 7);

        TextField stateInput = new TextField();
        GridPane.setConstraints(stateInput, 1, 7);

        // postal code
        Label postalCodeLabel = new Label("Postal Code:");
        GridPane.setConstraints(postalCodeLabel, 0, 8);

        TextField postalCodeInput = new TextField();
        GridPane.setConstraints(postalCodeInput, 1, 8);

        // country
        Label countryLabel = new Label("Country:");
        GridPane.setConstraints(countryLabel, 0, 9);

        TextField countryInput = new TextField();
        GridPane.setConstraints(countryInput, 1, 9);

        // password
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 10);

        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 10);

        // confirm button
        Button confirmButton = new Button("Sign Up");
        confirmButton.setOnAction(e -> {
            addressInfo(streetInput, cityInput, stateInput, postalCodeInput, countryInput);
            customerInfo(usernameInput, firstNameInput, lastNameInput, emailInput, phoneInput, passInput);
        });
        GridPane.setConstraints(confirmButton, 1, 11);

        grid.getChildren().addAll(usernameLabel, usernameInput, firstNameLabel, firstNameInput, lastNameLabel, lastNameInput, emailLabel, emailInput, phoneLabel, phoneInput, passLabel);
        grid.getChildren().addAll(streetLabel, streetInput, cityLabel, cityInput, stateLabel, stateInput, postalCodeLabel, postalCodeInput, countryLabel, countryInput, passInput, confirmButton);

        Scene scene = new Scene(grid, 1000, 1000);
        window.setScene(scene);
        window.show();
    }

    public void customerInfo(TextField usernameInput, TextField firstNameInput, TextField lastNameInput, TextField emailInput, TextField phoneInput, TextField passInput) {
        String username = usernameInput.getText();
        String firstName = firstNameInput.getText();
        String lastName = lastNameInput.getText();
        String email = emailInput.getText();
        String phone = phoneInput.getText();
        String password = passInput.getText();
        Customer newCustomer = new Customer(username, firstName, lastName, email, phone, password);
    }

    public void addressInfo(TextField streetInput, TextField cityInput, TextField stateInput, TextField postalCodeInput, TextField countryInput) {
        String street = streetInput.getText();
        String city = cityInput.getText();
        String state = stateInput.getText();
        int postalCode = Integer.parseInt(postalCodeInput.getText());
        String country = countryInput.getText();
        Address newAddress = new Address(street, city, state, postalCode, country);
    }
}
