package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class InicioSesionController {
	
	@FXML
	private ImageView img1;
	
	@FXML
	private Label label1;
	
	@FXML
	private Label label2;
	
	@FXML 
	private Label label3;
	
	@FXML
	private Label label4;
	
	@FXML
	private TextField txt1;
	
	@FXML
	private PasswordField pass1;
	
	@FXML
	private Button button1;
	
	@FXML
	public void loginUsuario(ActionEvent event) {
		
		
		label4.setText("Bienvenido: "+txt1.getText());
		txt1.setText(null);
		pass1.setText(null);
		
		
	}
	
	
}
