/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test3;

import MealPlanner.Ingredient;
import MealPlanner.Recipe;
import MealPlanner.Schedule;
import MealPlanner.ShoppingList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author salvador_afane
 */
public class Screen5Controller implements Initializable, ControlledScreen {

    ScreensController myController;
    private ObservableList<Ingredient> ingData;
    
    ShoppingList shoppingList = ShoppingList.getInstance();
    Schedule s = Schedule.getInstance();
    
    @FXML
    private ListView<Ingredient> listView;
    
    @FXML
    private TextArea commonList;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commonList.setText("Enter common items here...");
        ingData = FXCollections.observableArrayList();
        displayToListView();
    }    
    
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void goToScreen1(ActionEvent event){
       myController.setScreen(ScreensFramework.screen1ID);
    }
    
    @FXML
    private void goToScreen2(ActionEvent event){
       myController.setScreen(ScreensFramework.screen2ID);
    }
    
    @FXML
    private void goToScreen3(ActionEvent event){
       myController.setScreen(ScreensFramework.screen3ID);
    }
    
    @FXML
    private void goToScreen4(ActionEvent event){
       myController.setScreen(ScreensFramework.screen4ID);
    }
        
     public final void refresh(){
          displayToListView();
     }
   
    public void displayToListView(){
         
        ingData.clear(); // clear items from listview
         
        s.rotateRecipes();
        s.makeWeekIngredient();       
        shoppingList.searchIngredientList(s);
        
        // Ingredient list after the merge
        for (Ingredient ing1 : shoppingList.getShoppingList()) {
            ingData.add(ing1);
        } 
         
        listView.setItems(ingData);
        listView.setCellFactory(new Callback<ListView<Ingredient>, ListCell<Ingredient>>() {
                    
            @Override
            public ListCell<Ingredient> call(ListView<Ingredient> param){
                ListCell<Ingredient> cell = new ListCell<Ingredient>(){
                    @Override
                    public void updateItem(Ingredient ing1, boolean empty) {
                        super.updateItem(ing1, empty);
                        if (ing1 != null){
                            setText(ing1.getName() + " " + ing1.getNumber() + " " + ing1.getType());                                     
                        }
                    }
                };   
                return cell;                   
            };
        });
     } 
}
