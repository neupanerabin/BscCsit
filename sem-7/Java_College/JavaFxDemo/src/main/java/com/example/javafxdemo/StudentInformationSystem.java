package com.example.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;

public class StudentInformationSystem extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Information System");

        // Login Page
        GridPane loginGrid = new GridPane();
        loginGrid.setPadding(new Insets(10, 10, 10, 10));
        loginGrid.setVgap(8);
        loginGrid.setHgap(10);

        // Username Label
        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        // Username Input
        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        // Password Label
        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        // Password Input
        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);

        // Login Button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> {
            // Authenticate user here (e.g., check credentials against database)
            // If authenticated, show student information page
            primaryStage.setScene(createStudentInfoScene());
        });

        loginGrid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);

        Scene loginScene = new Scene(loginGrid, 300, 200);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    // Method to create the student information display page
    private Scene createStudentInfoScene() {
        GridPane studentInfoGrid = new GridPane();
        studentInfoGrid.setPadding(new Insets(10, 10, 10, 10));
        studentInfoGrid.setVgap(8);
        studentInfoGrid.setHgap(10);

        // Placeholder student information display
        Label studentLabel = new Label("Student Information");
        GridPane.setConstraints(studentLabel, 0, 0);

        // Display student information fetched from the database
        try {
            final String DRIVER = "com.mysql.cj.jdbc.Driver";
            final String DBNAME = "JavaCollege";
            final String HOST = "localhost";
            final String DBUSER = "root";
            final String DBPASS = "Neupane@11";
            final int PORT = 3306;
            final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;

            Class.forName(DRIVER);
            try (Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS)) {
                String sql = "SELECT username FROM student_profile";
                try (PreparedStatement statement = conn.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {
                    int row = 1;
                    while (resultSet.next()) {
                        String data = resultSet.getString("username");
                        Label usernameLabel = new Label(data);
                        GridPane.setConstraints(usernameLabel, 0, row++);
                        studentInfoGrid.getChildren().add(usernameLabel);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("An error occurred while accessing the database.");
            alert.showAndWait();
        }

        studentInfoGrid.getChildren().add(studentLabel);

        return new Scene(studentInfoGrid, 400, 300);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
