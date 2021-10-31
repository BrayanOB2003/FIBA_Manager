package ui;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FibaController {
	
	 @FXML
	    private BorderPane contentPane;

	    @FXML
	    private Pane searchPane;

	    @FXML
	    private TextField valueBox;

	    @FXML
	    private ChoiceBox<String> criteriaBox;

	    @FXML
	    private ChoiceBox<String> comparisonBox;
	    
    public void initialize() {
    	criteriaBox.getItems().addAll("Points","Rebounds","Assists","Robberies","Blocks","Age");
		criteriaBox.setValue("Points");
		comparisonBox.getItems().addAll("=",">","<");
		comparisonBox.setValue("=");
    }


}
