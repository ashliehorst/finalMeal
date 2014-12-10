package test3;

import javafx.fxml.FXML;
import javafx.scene.control.Dialogs;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import ch.makery.address.model.Person;
//import ch.makery.address.util.CalendarUtil;

/**
 * Dialog to edit details of a person.
 * 
 * @author 
 */
public class PersonEditDialogController {

	@FXML
	private TextField recipeTitleField;
	@FXML
	private TextField ingredient;
	@FXML
	private TextField measurment;
	@FXML
	private TextField quantity;
	@FXML
	private TextField cityField;
	@FXML
	private TextField birthdayField;
	
	
	private Stage dialogStage;
	private Person person;
	private boolean okClicked = false;
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Sets the stage of this dialog.
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	/**
	 * Sets the person to be edited in the dialog.
	 * 
	 * @param person
	 */
	public void setPerson(Person person) {
		this.person = person;
		
		recipeTitleField.setText(person.getFirstName());
		ingredient.setText(person.getLastName());
		measurment.setText(person.getStreet());
		quantity.setText(Integer.toString(person.getPostalCode()));
		cityField.setText(person.getCity());
		birthdayField.setText(CalendarUtil.format(person.getBirthday()));
		birthdayField.setPromptText("yyyy-mm-dd");
	}
	
	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}
	
	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			person.setFirstName(recipeTitleField.getText());
			person.setLastName(ingredient.getText());
			person.setStreet(measurment.getText());
			person.setPostalCode(Integer.parseInt(quantity.getText()));
			person.setCity(cityField.getText());
			person.setBirthday(CalendarUtil.parse(birthdayField.getText()));
			
			okClicked = true;
			dialogStage.close();
		}
	}
	
	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (recipeTitleField.getText() == null || recipeTitleField.getText().length() == 0) {
			errorMessage += "No valid first name!\n"; 
		}
		if (ingredient.getText() == null || ingredient.getText().length() == 0) {
			errorMessage += "No valid last name!\n"; 
		}
		if (measurment.getText() == null || measurment.getText().length() == 0) {
			errorMessage += "No valid street!\n"; 
		}
		
		if (quantity.getText() == null || quantity.getText().length() == 0) {
			errorMessage += "No valid postal code!\n"; 
		} else {
			// try to parse the postal code into an int
			try {
				Integer.parseInt(quantity.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid postal code (must be an integer)!\n"; 
			}
		}
		
		if (cityField.getText() == null || cityField.getText().length() == 0) {
			errorMessage += "No valid city!\n"; 
		}
		
		if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
			errorMessage += "No valid birthday!\n";
		} else {
			if (!CalendarUtil.validString(birthdayField.getText())) {
				errorMessage += "No valid birthday. Use the format yyyy-mm-dd!\n";
			}
		}
		
		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message
			Dialogs.showErrorDialog(dialogStage, errorMessage,
					"Please correct invalid fields", "Invalid Fields");
			return false;
		}
	}

    /*void setPerson(Screen2Controller.Person person1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
