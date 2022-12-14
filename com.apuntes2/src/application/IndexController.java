package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class IndexController {
	
	
	@FXML
	private TextField txtTitulo;
	
	@FXML
	private ChoiceBox chbEditorial;
	
	@FXML
	private TextField txtAutor;
	
	@FXML
	private TextField txtPaginas;
	
	@FXML
	private TableView <Libro> tableLibros;
	
	@FXML
	private TableColumn <Libro, String> columTitulo;
	
	@FXML
	private TableColumn <Libro, String> columEditorial;
	
	@FXML
	private TableColumn <Libro, String> columAutor;
	
	@FXML
	private TableColumn <Libro, Integer> columPaginas;
	
	@FXML
	private Button btnAnadir;
	@FXML
	private Button btnBorrar;
	
	private ObservableList<Libro> listaLibros=FXCollections.observableArrayList(new Libro("La Biblia","Planeta","Jesus",500));
	public ObservableList<String> listaEditoriales=FXCollections.observableArrayList("Planeta","Altaya","Kadokawa","Penguin Libros");
	
	
	@FXML
	private void initialize() {
		
		chbEditorial.setItems(listaEditoriales);
		
		columTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		columEditorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
		columAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		columPaginas.setCellValueFactory(new PropertyValueFactory<>("paginas"));
		
		ObservableList listaLibrosDB=getLibrosDB();
		
		tableLibros.setItems(listaLibrosDB);
		
	}
	
	private ObservableList<Libro> getLibrosDB () {
		ObservableList<Libro> listaLibrosDB = FXCollections.observableArrayList();
		DatabaseConnection dbConnection = new DatabaseConnection();
		Connection connection = dbConnection.getConnection();
		String query = "select * from libros";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Libro libro = new Libro(
						rs.getString("titulo"),
						rs.getString("editorial"),
						rs.getString("autor"),
						rs.getInt("paginas")
					);
				listaLibrosDB.add(libro);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaLibrosDB;
	}
	
	
	@FXML
    public void anadirLibro(ActionEvent event) {
		
		if(txtTitulo.getText().isEmpty()||chbEditorial.getSelectionModel().isEmpty()||txtAutor.getText().isEmpty()||txtPaginas.getText().isEmpty()) {
			
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Informacion incompleta");
			alerta.setHeaderText("Falta informacion del libro");
			alerta.setContentText("Por favor, complete los campos del formulario");
			alerta.showAndWait();
			
		}
		
		if (esNumero(txtPaginas.getText())) {
			Libro l = new  Libro(
	                txtTitulo.getText(),
	                chbEditorial.getValue().toString(),
	                txtAutor.getText(),
	                Integer.parseInt(txtPaginas.getText())
	        );

	        listaLibros.add(l);
	        
	        txtTitulo.clear();
	        chbEditorial.getSelectionModel().clearSelection();
	        txtAutor.clear();
	        txtPaginas.clear();
	        
	    }else {
	    	
	    	Alert alerta = new Alert(AlertType.ERROR);
	    	alerta.setTitle("Error al insertar");
	    	alerta.setHeaderText("No se ha introducido un numero en las paginas ");
	    	alerta.setContentText("Por favor, introduzca un numero en las paginas");
	    	alerta.showAndWait();
	    	
	    }
			
			
	}
	
	@FXML
	public void borrarLibro(ActionEvent event) {
		
		
		int indiceSeleccionado=tableLibros.getSelectionModel().getSelectedIndex();
		tableLibros.getItems().remove(indiceSeleccionado);
		
		System.out.println("Indice a borrar: "+indiceSeleccionado);
		
		
		if(indiceSeleccionado<=1) {
			
			Alert alerta=new Alert(AlertType.ERROR);
			alerta.setTitle("Error al borrar ");
			alerta.setHeaderText("No se ha seleccionado ningun libro a borrar ");
			alerta.setContentText("Por favor, seleccione un libro para borrar ");
			alerta.showAndWait();
			
		}else {
			tableLibros.getItems().remove(indiceSeleccionado);
			tableLibros.getSelectionModel().clearSelection();
			
		}
		
	}
		
	public boolean esNumero(String s)	{
		try {
			Integer.parseInt(s);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
		
		
	}
	
}