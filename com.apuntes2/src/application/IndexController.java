package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class IndexController {
	
	
	@FXML
	private TextField txtTitulo;
	
	@FXML
	private ChoiceBox chbEditorial;
	
	@FXML
	private TextField txtAutor;
	
	@FXML
	private TextField txtPaginas;
	
	
	public ObservableList<String> listaEditoriales=FXCollections.observableArrayList("Planeta","Altaya","Kadokawa","Penguin Libros");
	
	@FXML
	private void initialize() {
		
		chbEditorial.setItems(listaEditoriales);
		
	}
	
	
	
}
