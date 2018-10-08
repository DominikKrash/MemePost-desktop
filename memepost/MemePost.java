/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memepost;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import memepost.dataConnector.util.DBUtil;


public class MemePost extends Application {
    //data for mysql
    public static String serverURL = "jdbc:mysql://localhost:3306/memepost";
    public static String serverAdmin = "admin";
    public static String serverPassword = "paSSword09";
    //window properties
    public static Stage myStage;
    public static Scene scene;
    //sceny do wczytywania
    public final static String mainSite = "MainSite.fxml";
    public final static String loginSite = "LoginSite.fxml";
    public final static String registerSite = "RegisterSite.fxml";
    
    
    @Override
    public void start(Stage stage) throws Exception {
        myStage = stage;
        stage.setTitle("Meme Post");
        Parent root = FXMLLoader.load(getClass().getResource(mainSite));
        scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
