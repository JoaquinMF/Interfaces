package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ejercicio2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			StackPane panel=new StackPane();
			
			Rectangle r1=new Rectangle(400,400,Color.DARKGREEN);
			Rectangle r2=new Rectangle(280,280,Color.GREEN);
			Rectangle r3=new Rectangle (100,100,Color.LIGHTGREEN);
			
			panel.getChildren().addAll(r1,r2,r3);
			
			Scene scene = new Scene(panel,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private StackPane StackPane(StackPane panel, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
