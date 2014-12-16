/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test3;

import MealPlanner.Schedule;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author  Salvador E. Afane, Ashlie Horst, Paul O'Neil
 */
public class Screen4Controller implements Initializable, ControlledScreen {

    ScreensController myController;
    
    @FXML
    private Label sun;
    @FXML
    private Label mon;
    @FXML
    private Label tue;
    @FXML
    private Label wed;
    @FXML
    private Label thr;
    @FXML
    private Label fri;
    @FXML
    private Label sat;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        mon.setText("Something");
        
        /*
        sun.setText(Schedule.getInstance().getRotateList().get(0).getTitle());
        mon.setText(Schedule.getInstance().getRotateList().get(1).getTitle());
        tue.setText(Schedule.getInstance().getRotateList().get(2).getTitle());
        wed.setText(Schedule.getInstance().getRotateList().get(3).getTitle());
        thr.setText(Schedule.getInstance().getRotateList().get(4).getTitle());
        fri.setText(Schedule.getInstance().getRotateList().get(5).getTitle());
        sat.setText(Schedule.getInstance().getRotateList().get(6).getTitle());
        */
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
    
    @FXML
    private void goToScreen5(ActionEvent event){
       myController.setScreen(ScreensFramework.screen5ID);
    }
}
