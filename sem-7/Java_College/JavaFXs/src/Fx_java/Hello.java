package Fx_java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Hello extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Create a label with the text "Hello, World!"
		Label label = new Label("Hello, World!");

		// Create a layout pane (StackPane in this case) and add the label to it
		StackPane root = new StackPane();
		root.getChildren().add(label);

		// Create the scene with the layout pane
		Scene scene = new Scene(root, 300, 200);

		// Set the stage title and scene
		primaryStage.setTitle("Simple JavaFX Example");
		primaryStage.setScene(scene);

		// Show the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		// Launch the JavaFX application
		launch(args);
	}
}
