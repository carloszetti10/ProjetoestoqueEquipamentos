/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classesTelas;

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
public class CadastroAdm extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader cadastro = new FXMLLoader(getClass().getResource("/gui/CadastroAdmFXML.fxml"));
        Parent parentCadastro = cadastro.load();
        stage.initStyle(StageStyle.UNDECORATED);
        Scene sceneCadastro = new Scene(parentCadastro);
        stage.setScene(sceneCadastro);
        stage.centerOnScreen();
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);  
    }
    
}
