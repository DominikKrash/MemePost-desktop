/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memepost;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

/**
 *
 * @author Dominik
 */
public class MainSiteController implements Initializable,SceneChanger {
    
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    
    //chowamy tym przyciski
    private boolean isVisible = false;
    //efekty dzwiekowe
    
    private  Media soundtrack;;
    private  static MediaPlayer soundtrackPlayer;
    


    //chowamy i odrkywamy przyciski
    @FXML
    private void homeButtonPressed(MouseEvent e){
        playClickSound();
        if(isVisible) {
            isVisible = false;
            loginButton.visibleProperty().set(false);
            registerButton.visibleProperty().set(false);
        }
        
        else {
            isVisible = true;
            loginButton.visibleProperty().set(true);
            registerButton.visibleProperty().set(true);
        }
    }
    
    @FXML
    private void loginButtonPressed(MouseEvent e){
           playClickSound();
           changeScene(MemePost.loginSite);
    }
    
    @FXML
    private void registerButtonPressed(MouseEvent e){
           playClickSound();
           changeScene(MemePost.registerSite);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
        soundtrack = new Media(getClass().getResource("Music/sound.mp3").toString());
        if(soundtrackPlayer ==null){
        soundtrackPlayer = new MediaPlayer(soundtrack);
        }
        if(soundtrackPlayer.getStatus().equals(Status.PLAYING)){
            soundtrackPlayer.stop();
        }
        soundtrackPlayer.play();
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Cant find audio Files");
        }
  
        
    }    
    
}
