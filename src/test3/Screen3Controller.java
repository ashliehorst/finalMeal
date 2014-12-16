
package test3;

import MealPlanner.FileManager;
import MealPlanner.Ingredient;
import MealPlanner.Property;
import MealPlanner.Recipe;
import MealPlanner.Schedule;
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
       // Schedule sch = Schedule.getInstance();
        
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        displayToListView();
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
    
     public boolean createRec(ActionEvent even){
        try {
            
         
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MakeRecipe.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Recipe");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        
        // Set the controller and passing an object to the controller
        MakeRecipeController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        //controller.setRecipe(recipe);
        
            
        
        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
        
        displayToListView();
        
        return controller.isOkClicked();

        } catch (Exception ex){
        ex.printStackTrace();
        return false;
        }
}
     @FXML
     public void removeRec(ActionEvent event){
         int index = listView.getSelectionModel().getSelectedIndex();
         Schedule.getInstance().getRecipeList().remove(index);
        
        displayToListView();
     }
     
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
