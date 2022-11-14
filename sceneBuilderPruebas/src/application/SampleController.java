package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {
	
	@FXML
	private TextField textField1;
	
	@FXML
	private Button button1;
	
	@FXML
	private Label label1;
	
	@FXML
	private Label label2;
	
	
	@FXML
	public void mostrarMensaje(ActionEvent event) {
		
		label2.setText(textField1.getText());
		
		
		
	}
	
	
}
