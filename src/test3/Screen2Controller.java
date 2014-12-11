

package test3;

import MealPlanner.Recipe;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Salvador E. Afane, Ashlie Horst, Paul O'Neil
 */
public class Screen2Controller implements Initializable , ControlledScreen {

    private Stage primaryStage;
    ScreensController myController;   
    
    MealManager meal = MealManager.getInstance();
    
    
  //  Person person = new Person();

    //@FXML
    //private ListView<Person> table;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
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
    

    public boolean button1(ActionEvent even){
        try {
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
        controller.setPerson(recipe);
        
        
        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
        
        return controller.isOkClicked();

        } catch (Exception ex){
        ex.printStackTrace();
        return false;
        }
       // label1.setText("something");
        //tab1.
//        label2.setText("Well something should change");
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText("Add Recipe");
//        alert.setContentText("I have a great message for you!");
//        alert.showAndWait();
        // Create the custom dialog.
        
    }
    
    @FXML
    private Label label1;
    public void button2(ActionEvent event){
        TextInputDialog dialog = new TextInputDialog("walter");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter your name:");

        label1.setText("Change!!!");
        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
         System.out.println("Your name: " + result.get());
        }
        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> System.out.println("Your name: " + name));
    }
}
