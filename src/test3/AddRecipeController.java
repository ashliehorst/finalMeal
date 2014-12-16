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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
    
    
   
    @FXML
    private ListView<Recipe> listView;
    
    
    public AddRecipeController(){
        data = FXCollections.observableArrayList();
        listView = new ListView<>();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayToListView();
    }    
   
    
    public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;       
	}
    
    @FXML
    public void addRecipeButton(ActionEvent even){
        
        Recipe selectedRec = listView.getSelectionModel().getSelectedItem();
        Schedule.getInstance().getRotateList().add(selectedRec);
        
        okClicked = true;
        dialogStage.close();
    }
    
    public void setRecipe(Recipe recipe) {

    }
    
    public boolean isOkClicked() {
		return okClicked;
	}
    
    @FXML
    public void populateListView (ActionEvent event)
    {
       displayToListView();
    }
    
    @FXML
	private void handleOk() {
            
		//if (isInputValid()) {
                    //recipe.setTitle(recipeTitle.getText());
                    //System.out.println(recipe.getTitle());
//                    Ingredient ing = new Ingredient();
//                    ing.setName(ingredientTitle.getText());
//                    ing.setNumber(Double.parseDouble(quantity.getText()));
//                    recipe.getIngredientList().add(ing);
//                    recipe.setDirections(directions.getText());
//                    recipe.setIngredientList(sch.getTempList());
//                    sch.getRecipeList().add(recipe);	
//		}
	}
    
        /*
        * DISPLAY TO LIST VIEW
        */
    public final void displayToListView(){
         
         data.clear(); // clear items from listview
         
         for (Recipe recipe : Schedule.getInstance().getRecipeList()){
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
