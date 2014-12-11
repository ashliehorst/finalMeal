
package test3;

import MealPlanner.Ingredient;
import MealPlanner.Recipe;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author  Salvador E. Afane, Ashlie Horst, Paul O'Neil
 */
public class Screen3Controller implements Initializable, ControlledScreen {

    ScreensController myController;
        private Stage primaryStage;
        private ObservableList<Recipe> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    
    @FXML
    private ListView<Recipe> listView;
    

    //Home Screen
    @FXML
    private void goToScreen1(ActionEvent event){
       myController.setScreen(ScreensFramework.screen1ID);
    }
    
    //Recipi List
    @FXML
    private void goToScreen2(ActionEvent event){
       myController.setScreen(ScreensFramework.screen2ID);
    }
    
    // Schedule 
    @FXML
    private void goToScreen4(ActionEvent event){
       myController.setScreen(ScreensFramework.screen4ID);
    }
    
    // Shooping list  
    @FXML
    private void goToScreen5(ActionEvent event){
       myController.setScreen(ScreensFramework.screen5ID);
    }
    
     public boolean button1(ActionEvent even){
        try {
            
        data = FXCollections.observableArrayList(); 
        
        Recipe recipe = new Recipe();
        Recipe recipe2 = new Recipe();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Recipe");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
//        List<Ingredient> ingList = new ArrayList<>();
//        Ingredient ing1 = new Ingredient();
//        ing1.setName("Tomato Sauce");
//        ing1.setNumber(2.20);
//        ing1.setType("lbs");
//        ingList.add(ing1);
//        
//        recipe.setTitle("Spaghetti");
//        recipe.setIngredientList(ingList);
//        recipe.setDirections("Here are the directions");
//        data.add(recipe);
//        
//        Ingredient ing2 = new Ingredient();
//        ing2.setName("Tomato Sauce");
//        ing2.setNumber(2.20);
//        ing2.setType("lbs");
//        ingList.add(ing2);
//        
//        recipe2.setTitle("Chicken");
//        recipe2.setIngredientList(ingList);
//        recipe2.setDirections("Here are the directions");
//        data.add(recipe2);
        
        // Set the controller and passing an object to the controller
        PersonEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setRecipe(recipe);
        
        //ObservableList<Recipe> data = FXCollections.observableArrayList();
        
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
        
            
        
        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
        
        return controller.isOkClicked();

        } catch (Exception ex){
        ex.printStackTrace();
        return false;
        }
}
     
}
