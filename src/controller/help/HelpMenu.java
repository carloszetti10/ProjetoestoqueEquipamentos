/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.help;

import classesTelas.LoginTelas;
import controller.MenuViewController;
import java.io.IOException;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author carlos
 */
public class HelpMenu {
    private Stage stage;
    private MenuViewController controller;
    
    public HelpMenu(MenuViewController controller) {
        this.controller = controller;
    }

    public HelpMenu() {
    }
    

  public void organizarMenu() {
    // Posicionar o slider em 0 (visível) inicialmente
    controller.getSlider().setTranslateX(0);
    // Definir Menu como invisível e MenuBack como visível inicialmente
    controller.getMenu().setVisible(false);
    controller.getMenuBack().setVisible(true);

    controller.getMenuBack().setOnMouseClicked(event -> {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(controller.getSlider());

        slide.setToX(-176);
        slide.play();

        slide.setOnFinished((e) -> {
            // Atualizar a posição do slider
            controller.getSlider().setTranslateX(-176);
            // Tornar Menu visível e MenuBack invisível após a animação
            controller.getMenu().setVisible(true);
            controller.getMenuBack().setVisible(false);
        });
    });

    controller.getMenu().setOnMouseClicked(event -> {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(controller.getSlider());

        slide.setToX(0);
        slide.play();

        slide.setOnFinished((e) -> {
            // Atualizar a posição do slider
            controller.getSlider().setTranslateX(0);
            // Tornar Menu invisível e MenuBack visível após a animação
            controller.getMenu().setVisible(false);
            controller.getMenuBack().setVisible(true);
        });
    });
}

    public void abrirLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/LoginFXML.fxml"));
            Scene scene = new Scene(loader.load());
            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cadastroEquipamento(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CadastroFXML.fxml"));
            Scene scene = new Scene(loader.load());
            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listaEquipamento(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ListaEquipamentosFXML.fxml"));
            Scene scene = new Scene(loader.load());
            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
             stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editarEquipamentos(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/EditarFXML.fxml"));
            Scene scene = new Scene(loader.load());
            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarUsuarios(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CadastroUsuarioFXML.fxml"));
            Scene scene = new Scene(loader.load());
            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
    
}
