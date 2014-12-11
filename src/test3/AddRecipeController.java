/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test3;

import MealPlanner.Recipe;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author salvador_afane
 */
public class AddRecipeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage dialogStage;
    boolean okClicked = false;
    private ObservableList<Recipe> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   
    public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
    
    public void setRecipe(Recipe recipe) {

    }
    
    public boolean isOkClicked() {
		return okClicked;
	}
}
