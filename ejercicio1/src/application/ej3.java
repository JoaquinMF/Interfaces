package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ej3 extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			GridPane panel = new GridPane();
			
			Button b7=new Button("7");
			Button b8=new Button("8");
			Button b9=new Button("9");
			Button b4=new Button("4");
			Button b5=new Button("5");
			Button b6=new Button("6");
			Button bLlamar=new Button("Llamar");
			Button b1=new Button("1");
			Button b2=new Button("2");
			Button b3=new Button("3");
			Button bColgar=new Button("Colgar");
			Button b0=new Button("0");
			
			panel.add(b7,0,0);
			panel.add(b8,1,0);
			panel.add(b9,2,0);
			panel.add(b4,0,1);
			panel.add(b5,1,1);
			panel.add(b6,2,1);
			panel.add(bLlamar,3,1);
			panel.add(b1,0,2);
			panel.add(b2,1,2);
			panel.add(b3,2,2);
			panel.add(bColgar,3,2);
			panel.add(b0,1,3);
			
			Scene scene = new Scene(panel,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}