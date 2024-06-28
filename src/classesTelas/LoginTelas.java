/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package classesTelas;

import controller.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Carlos Zetti
 */
public class LoginTelas extends Application {
    
    private LoginViewController controller;
    private static Scene sceneLogin;
    private static Stage stage;
    private double xOffset = 0;
    private double  yOffset = 0;

  
    
    @Override
    public void start(Stage stage) throws Exception {
       
        FXMLLoader login = new FXMLLoader(getClass().getResource("/gui/LoginFXML.fxml"));
        Parent parentLogin = login.load();
        stage.initStyle(StageStyle.UNDECORATED);
        sceneLogin = new Scene(parentLogin);
        stage.setScene(sceneLogin);
        stage.centerOnScreen();
       
        // Eventos de mouse para mover a janela
            parentLogin.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            
            parentLogin.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });
            stage.show();
            
        } 
    
     public static Stage getPrimaryStage() {
        return stage;
    }
    public static void main(String[] args) {
        launch(args);  
    }
    
    
    
    
    
    
}
