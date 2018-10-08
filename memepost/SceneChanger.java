package memepost;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public interface SceneChanger {
    default public void changeScene(final String name){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(name));
            Scene scene = new Scene(root);
            MemePost.myStage.setScene(scene);
            MemePost.myStage.show();
        } catch (IOException ex) {
            Logger.getLogger(SceneChanger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    default public void playClickSound(){
        try{
            Media clickSound = new Media(getClass().getResource("Music/click.mp3").toString());
            MediaPlayer clickSoundPlayer = new MediaPlayer(clickSound);
            clickSoundPlayer.play();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    default public void showAlert(final String info, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle("GameSystem alert");
        alert.setHeaderText(null);
        alert.setContentText(info);
        alert.showAndWait();
    }
}
