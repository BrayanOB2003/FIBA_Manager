package ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.*;

public class FibaController {
	
	 	@FXML
	    private BorderPane contentPane;
	 
	 	@FXML
	    private BorderPane basePane;

	    @FXML
	    private Pane searchPane;
	    
	    @FXML
	    private ChoiceBox<String> criteriaBox;
	    
	    @FXML
	    private TextField finalValueTextField;

	    @FXML
	    private TextField initialValueTextField;
	    
	    private final ObservableList<Player> dataList = FXCollections.observableArrayList();

		private FIBAManager mainClass;
	    
	    public void initialize() throws IOException {
	    	
	    }
	    
    public FibaController() {
    	mainClass = new FIBAManager();
    }
	    
    public void loadsearchPage() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchPage.fxml"));
		
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);
		
		criteriaBox.getItems().addAll("Points","Rebounds","Assists","Robberies","Blocks","Age");
		criteriaBox.setValue("Points");
    }
    
    @FXML
    public void searchPlayers(ActionEvent event) throws IOException {
    		
    		Double initialValue = Double.parseDouble(initialValueTextField.getText());
    		Double finalValue = Double.parseDouble(finalValueTextField.getText());
    		
    		if(criteriaBox.getSelectionModel().isEmpty())
    			JOptionPane.showMessageDialog(null, "Select a valid criterion", "Invalid", JOptionPane.PLAIN_MESSAGE, null);
    		else if(!(initialValue<=finalValue))
    			JOptionPane.showMessageDialog(null, "Invalid initial or final value", "Invalid range", JOptionPane.PLAIN_MESSAGE, null);
    		else {
    			long time = System.currentTimeMillis();
    			dataList.clear();
    			ArrayList<String> data = new ArrayList<>();
    			try {
    				switch (criteriaBox.getSelectionModel().getSelectedItem()) {
    				
    				case "Rebounds":
    					data = mainClass.searchByRange(FIBAManager.RBS, initialValue, finalValue);
    					break;
    				case "Assists":
    					data = mainClass.searchByRange(FIBAManager.ASSIS, initialValue, finalValue);
    					break;
    				case "Bloks":
    					data = mainClass.searchByRange(FIBAManager.BLK, initialValue, finalValue);
    					break;
    				case "Points":
    					data = mainClass.searchByRange(FIBAManager.PTS, initialValue, finalValue);
    					break;
    				case "Robberies":
    					data = mainClass.searchByRange(FIBAManager.ROBB, initialValue, finalValue);
    					break;

    				}

    				time = System.currentTimeMillis() - time;
    				
    				if(data.isEmpty()) {
    					JOptionPane.showMessageDialog(null, "No results found", "No results", JOptionPane.PLAIN_MESSAGE, null);
    				}
    				
    				for(int i = 0; i<data.size(); i++) {
    			
    					Player player = new Player(data.get(i).split(",")[2], data.get(i).split(",")[3], data.get(i).split(",")[1],
    							data.get(i).split(",")[12], data.get(i).split(",")[10], data.get(i).split(",")[15],data.get(i).split(",")[7],data.get(i).split(",")[9]);
    	                dataList.add(player);
    					
    				}	
    				
    				criteriaBox.getSelectionModel().clearSelection();
    				initialValueTextField.clear();
    				finalValueTextField.clear();
    				loadResultScreen(time);
    				
    			} catch (NumberFormatException e) {
    				JOptionPane.showMessageDialog(null, "Input a valid value", "Invalid Value", JOptionPane.PLAIN_MESSAGE, null);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}

    		}
    		
    		
    	}
    
    public void loadResultScreen(long time) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resultsPage.fxml"));
		
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);
		
		idName.setCellValueFactory(new PropertyValueFactory<>("name"));
        idAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        idTeam.setCellValueFactory(new PropertyValueFactory<>("team"));
        idPoints.setCellValueFactory(new PropertyValueFactory<>("trueShooting"));
        idRebounds.setCellValueFactory(new PropertyValueFactory<>("totalRebounds"));
        idAssists.setCellValueFactory(new PropertyValueFactory<>("freeThrow"));
        idSteals.setCellValueFactory(new PropertyValueFactory<>("offensiveRebounds"));
        idBlocks.setCellValueFactory(new PropertyValueFactory<>("blocks"));
 
        tablePlayers.setItems(dataList);
        
        timelabel.setText(timelabel.getText() + " " + time +" ms");
    }
    
    @FXML
    public void addFile(ActionEvent event) throws IOException {

    	FileChooser fileChooser = new FileChooser();
    	
    	File file = fileChooser.showOpenDialog(searchPane.getScene().getWindow());
		mainClass.readFiles(file);
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
    private Label timelabel;
    
    @FXML
    public void returnSearch(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchPage.fxml"));
		
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);

    }


}
