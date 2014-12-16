

package test3;

import MealPlanner.FileManager;
import MealPlanner.Ingredient;
import MealPlanner.Property;
import MealPlanner.Recipe;
import MealPlanner.Schedule;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.util.Callback;




/**
 * FXML Controller class
 *
 * @author Salvador E. Afane, Ahslie Horst, Paul O'Neil
 */
public class Screen1Controller implements Initializable, ControlledScreen {

    ScreensController myController;
    
    @FXML
    public TextArea textarea;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Property prop = new Property();
        String file = prop.getFile();
        Schedule s = Schedule.getInstance();
        FileManager fm = new FileManager();
        fm.readXmlFile(s, file);
        //displayToTextArea();
        /*
        Recipe recipe = new Recipe();
        recipe.setTitle("Pizza");
        recipe.setDirections("Bake for 45 min at 475 Degrees.");
        Ingredient newIng = new Ingredient();
        Ingredient newIng2 = new Ingredient();
        newIng.setName("Cheese");
        newIng.setNumber(1);
        newIng.setType("cup");
        newIng2.setName("Sauce");
        newIng2.setNumber(2);
        newIng2.setType("pounds");
        recipe.getIngredientList().add(newIng);
        recipe.getIngredientList().add(newIng2);
        Schedule.getInstance().getRotateList().add(recipe);
        */
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
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
    
     @FXML
    private void goToScreen5(ActionEvent event){
       myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private Label label2;
    
    public void button1(ActionEvent event){
       // label1.setText("something");
        //tab1.
        label2.setText("Well something should change");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }
    
    public void button2(ActionEvent event){
        TextInputDialog dialog = new TextInputDialog("walter");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter your name:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
         System.out.println("Your name: " + result.get());
        }
        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> System.out.println("Your name: " + name));
    }
    
    /**
    * Display rotation list to listview
    */
    public final void displayToTextArea(){
        
        Schedule s = Schedule.getInstance();
        
        String ingList = "Ingredients: \n";
        Recipe todaysMeal = s.iterateThruSchedule();
        for (Ingredient ing : todaysMeal.getIngredientList()){
            ingList += Double.toString(ing.getNumber()) + " " + ing.getType() + " " + ing.getName() + "\n";
        }
        
        textarea.setText(todaysMeal.getTitle() + "\n\n\n" + ingList + "\n\n" + "Directions: \n" + todaysMeal.getDirections());
         
     }
    
}
