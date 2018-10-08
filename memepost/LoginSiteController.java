
package memepost;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import memepost.dataConnector.controller.UserDAO;
import memepost.dataConnector.model.User;


public class LoginSiteController implements Initializable,SceneChanger {
    @FXML
    private Button enterButton;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    
    private  Media soundtrack;
    private  MediaPlayer soundtrackPlayer;
    
    @FXML
    private void backButtonPressed(MouseEvent e){
        playClickSound();
        changeScene(MemePost.mainSite);
    }
    @FXML
    private void loginToApp(MouseEvent e) throws SQLException, ClassNotFoundException{
        playClickSound();
        String login = loginField.getText();
        String pass = passwordField.getText();
        User us = UserDAO.loginToSystem(login, pass);
        if(us != null) showAlert("logged in !!!!!",AlertType.INFORMATION);
        else showAlert("Sorry, cant log in, incorrect informations!!!",AlertType.WARNING);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
