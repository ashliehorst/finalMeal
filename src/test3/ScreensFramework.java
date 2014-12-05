

package test3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * 
 * @author  Salvador E. Afane, Ashlie Horst, Paul O'Neil
 */
public class ScreensFramework extends Application {
    
    public static String screen1ID = "main";
    public static String screen1File = "Screen1.fxml";
  
    public static String screen2ID = "screen2";
    public static String screen2File = "Screen2.fxml";
    
    public static String screen3ID = "screen3";
    public static String screen3File = "Screen3.fxml";
    
    public static String screen4ID = "screen4";
    public static String screen4File = "Screen4.fxml";
    
    public static String screen5ID = "screen5";
    public static String screen5File = "Screen5.fxml";
    
    
    private Stage primaryStage;

    
    @Override
    public void start(Stage primaryStage) {
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
        mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
        mainContainer.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
        mainContainer.loadScreen(ScreensFramework.screen4ID, ScreensFramework.screen4File);
        mainContainer.loadScreen(ScreensFramework.screen5ID, ScreensFramework.screen5File);

        
        mainContainer.setScreen(ScreensFramework.screen1ID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(ScreensFramework.class.getResource("css.css").toExternalForm());

        primaryStage.setTitle("Ultimate Recipe");

        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public boolean showPersonEditDialog(Person person) {
		try {
			// Load the fxml file and create a new stage for the popup
			FXMLLoader loader = new FXMLLoader(ScreensFramework.class.getResource("view/PersonEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			// Set the person into the controller
			PersonEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPerson(person);
			
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();
			
			return controller.isOkClicked();
			
		} catch (IOException e) {
			// Exception gets thrown if the fxml file could not be loaded
			e.printStackTrace();
			return false;
		}
	}
    
    public static void main(String[] args) {
        launch(args);
    }
}
