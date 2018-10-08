
package memepost;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import memepost.dataConnector.controller.UserDAO;
import memepost.dataConnector.model.User;


public class RegisterSiteController implements Initializable,SceneChanger{
    @FXML
    private TextField loginField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField rePasswordField;
    
    private void clearFields(){
        loginField.setText("");
        emailField.setText("");
        passwordField.setText("");
        rePasswordField.setText("");
    }
    
    @FXML
    private void goBackButton(MouseEvent e){
        playClickSound();
        changeScene(MemePost.mainSite);
    }
    
    @FXML
    private void setRegisterButton(MouseEvent e) throws SQLException, ClassNotFoundException{
        playClickSound();
        if(passwordField.getText().isEmpty() || loginField.getText().isEmpty() 
                || emailField.getText().isEmpty() || rePasswordField.getText().isEmpty()){
            showAlert("SOME DATA IS MISSING!",AlertType.ERROR);
            return;
        }
        else if(passwordField.getText().equals(rePasswordField.getText()) == false){
            showAlert("YOU ENTERED 2 DIFFERENT PASSWORDS!",AlertType.ERROR);
            return;
        }
        
        boolean result = UserDAO.registerUser(loginField.getText(), passwordField.getText(),emailField.getText());
        if(result){
            showAlert("you created new account !",AlertType.CONFIRMATION);
            changeScene(MemePost.mainSite);
        }
        else{
            showAlert("Sorry, we cant create account with your data!",AlertType.ERROR);
            clearFields();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
