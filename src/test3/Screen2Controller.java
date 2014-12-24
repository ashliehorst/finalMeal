package test3;

import MealPlanner.Recipe;
import MealPlanner.Schedule;
import MealPlanner.ShoppingList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Salvador E. Afane, Ashlie Horst, Paul O'Neil
 */
public class Screen2Controller implements Initializable , ControlledScreen {

    private Stage primaryStage;
    ScreensController myController;
    private ObservableList<Recipe> data;
    private AddRecipeController arc;
        
    ShoppingList sl = ShoppingList.getInstance(); 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         data = FXCollections.observableArrayList();
         displayToListView();
    }
    
    @FXML
    private ListView<Recipe> listView;
    
    /**
     * Set the parent for the screen
     * @param screenParent 
     */
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void goToScreen1(ActionEvent event){
       myController.setScreen(ScreensFramework.screen1ID);
    }
    
    @FXML
    private void goToScreen3(ActionEvent event){
       myController.setScreen(ScreensFramework.screen3ID);
    }
    
    @FXML
    private void goToScreen4(ActionEvent event){
       myController.setScreen(ScreensFramework.screen4ID);
    }
    
    @FXML
    private void goToScreen5(ActionEvent event){
       myController.setScreen(ScreensFramework.screen5ID);
    }
    
    @FXML
    public boolean button1(ActionEvent event){
        try {
            
            data = FXCollections.observableArrayList();
            
        Recipe recipe = new Recipe();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddRecipe.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add Recipe");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
            
        // Set the controller and passing an object to the controller
        AddRecipeController controller = loader.getController();
        controller.setDialogStage(dialogStage);
             
        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
        Schedule.getInstance().rotateRecipes();
        displayToListView();
              
        return controller.isOkClicked();
        
        } catch (Exception ex){
        ex.printStackTrace();
        return false;
        }       
    }
    
    @FXML
    private Label label1;
    /**
     * Remove an item from the rotate list
     * @param event 
     */
    public void remove(ActionEvent event){
        
        if (Schedule.getInstance().getRotateList().size() != 1) {
            int index = listView.getSelectionModel().getSelectedIndex();
            Schedule.getInstance().getRotateList().remove(index);
            Schedule.getInstance().rotateRecipes();
            displayToListView();
        }
        else
        {
            //http://code.makery.ch/blog/javafx-dialogs-official/
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You must have at least one recipe in the rotate list");
            //alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
        }
    }

    /**
     * Display rotation list to listview
     */
    public final void displayToListView(){
         
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
