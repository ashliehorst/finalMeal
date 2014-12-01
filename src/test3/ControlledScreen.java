
package test3;


public interface ControlledScreen {
    
    //This method will allow the injection of the Parent ScreenPane
    // which will help with the transition of screens
    public void setScreenParent(ScreensController screenPage);
}
