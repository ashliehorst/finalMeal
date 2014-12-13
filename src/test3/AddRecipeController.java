/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test3;

import MealPlanner.Recipe;
import MealPlanner.Schedule;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private AddRecipeController controller;
    private ListView<Recipe> listView;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
   
    public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;       
	}
    
    public void addRecipeButton(ActionEvent even){
        
        okClicked = true;
        dialogStage.close();
    }
    
    public void setRecipe(Recipe recipe) {

    }
    
    public boolean isOkClicked() {
		return okClicked;
	}
    
    public final void displayToListView(){
         data = FXCollections.observableArrayList();
         
         data.clear(); // clear items from listview
         
         for (Recipe recipe : Schedule.getInstance().getRotateList()){
             data.add(recipe);
         }
         
        listView.setItems(data);
        listView.setCellFactory(new Callback<ListView<Recipe>, ListCell<Recipe>>() {
                    
                    @Override
                    public ListCell<Recipe> call(ListView<Recipe> param){
                    ListCell<Recipe> cell = new ListCell<Recipe>(){
                        @Override
                        public void updateItem(Recipe recipe, boolean empty) {
                            super.updateItem(recipe, empty);
                            if (recipe != null){
                                    setText(recipe.getTitle());                                     
                            }
                        }
                    };   
                        return cell;
                    
                    };

                });
     }
    
}
