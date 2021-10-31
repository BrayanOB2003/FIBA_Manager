package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Player;

public class FibaController {
	
		private final ObservableList<Player> dataList = FXCollections.observableArrayList();

	 	@FXML
	    private BorderPane contentPane;
	 
	 	@FXML
	    private BorderPane basePane;

	    @FXML
	    private Pane searchPane;

	    @FXML
	    private TextField valueBox;

	    @FXML
	    private ChoiceBox<String> criteriaBox;

	    @FXML
	    private ChoiceBox<String> comparisonBox;
	    
    public void initialize() throws IOException {
    	
    }
    
    public void loadsearchPage() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchPage.fxml"));
		
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);
		
		criteriaBox.getItems().addAll("Points","Rebounds","Assists","Robberies","Blocks","Age");
		criteriaBox.setValue("Points");
		comparisonBox.getItems().addAll("=",">","<");
		comparisonBox.setValue("=");
    }
    
    @FXML
    public void searchPlayers(ActionEvent event) throws IOException {
    	
    	if(valueBox.getText().equals("") || valueBox.getText().equals(null) ) {
    		//Se hace validación de que haya un valor
    		sendAlert("Problema de datos", "Por favor introduzca un valor a buscar dentro de la base de datos");
    	}else {
    		
    		//Luego de que se realice la búsqueda, carga segunda pantalla 
    		
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resultsPage.fxml"));
    		
    		fxmlLoader.setController(this);
    		Parent root = fxmlLoader.load();
    		basePane.getChildren().clear();
    		basePane.setCenter(root);
    		
    		idName.setCellValueFactory(new PropertyValueFactory<>("name"));
    		idLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            idAge.setCellValueFactory(new PropertyValueFactory<>("age"));
            idTeam.setCellValueFactory(new PropertyValueFactory<>("team"));
            idPoints.setCellValueFactory(new PropertyValueFactory<>("pointsPerGame"));
            idRebounds.setCellValueFactory(new PropertyValueFactory<>("reboundsPerGame"));
            idAssists.setCellValueFactory(new PropertyValueFactory<>("assistsPerGame"));
            idSteals.setCellValueFactory(new PropertyValueFactory<>("robberiesPerGame"));
            idBlocks.setCellValueFactory(new PropertyValueFactory<>("blocksPerGame"));
     
            tablePlayers.setItems(dataList);
    	}
    		
    } 

 
    
    public void warningAlert(String title, String text) {
		
    	Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
    	
	}
    
    public void sendAlert(String title, String text) {
		
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
    	
	}
    
    
    //----------------- results page -------------------------
    
    @FXML
    private Pane resultsPane;

    @FXML
    private TableView<Player> tablePlayers;

    @FXML
    private TableColumn<Player, String> idName;

    @FXML
    private TableColumn<Player, String> idLastName;

    @FXML
    private TableColumn<Player, String> idAge;

    @FXML
    private TableColumn<Player, String> idTeam;

    @FXML
    private TableColumn<Player, String> idPoints;

    @FXML
    private TableColumn<Player, String> idRebounds;

    @FXML
    private TableColumn<Player, String> idAssists;

    @FXML
    private TableColumn<Player, String> idSteals;

    @FXML
    private TableColumn<Player, String> idBlocks;

    @FXML
    public void returnSearch(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchPage.fxml"));
		
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);

    }


}
