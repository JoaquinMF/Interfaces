package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Button boton = new Button ("Click aquí");
			boton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("Ke paza bro");
					
				}
			});
			
			Label lbl=new Label("Ke aze vieo");
			
			/*StackPane panel = new StackPane();
			panel.setAlignment(lbl,Pos.TOP_CENTER);
			panel.setAlignment(boton,Pos.CENTER);
			panel.getChildren().addAll(lbl,boton);*/
			
			Button boton1=new Button("Boton 1");
			Button boton2=new Button("Boton 2");
			Button boton3=new Button("Boton 3");
			Button boton4=new Button("Boton 4");
			
			GridPane panel=new GridPane();
			
			panel.add(boton1, 0, 0);
			panel.add(boton2, 1, 0);
			panel.add(boton3, 0, 1);
			panel.add(boton4, 1, 1);
			
			panel.setVgap(15);
			panel.setHgap(15);
			panel.setPadding(new Insets(15));
			
			/*BorderPane panel=new BorderPane();
			
			panel.setCenter(boton1);
			panel.setTop(boton2);
			panel.setRight(boton3);
			
			VBox panelVertical=new VBox(15);
			
			panelVertical.setPadding(new Insets(15));
			panelVertical.getChildren().addAll(boton1,boton2,boton3);
			
			panel.setRight(panelVertical);*/
			
			/*VBox panel = new VBox(15);
			panel.setPadding(new Insets(15));
			panel.getChildren().addAll(boton1,boton2,boton3);*/
			
			
			//panel.getChildren().add(boton);
			
			Scene scene = new Scene(panel,400,300);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Introduccion a JavaFX");
			
			//primaryStage.getIcons().add(new Image("/application...."));
			
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
