
package test3;

import MealPlanner.Recipe;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author  Salvador E. Afane, Ashlie Horst, Paul O'Neil
 */
public class Screen3Controller implements Initializable, ControlledScreen {

    ScreensController myController;
        private Stage primaryStage;

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
        Recipe recipe = new Recipe();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Recipe");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        // Set the controller and passing an object to the controller
        PersonEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPerson(recipe);
        
        
        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
        
        return controller.isOkClicked();

        } catch (Exception ex){
        ex.printStackTrace();
        return false;
        }
}
     
}
