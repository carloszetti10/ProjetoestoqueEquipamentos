/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import controller.help.HelpMenu;
import dao.Conexao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Mensagem.Mensagem;

/**
 * FXML Controller class
 *
 * @author Carlos Zetti
 */
public class MenuViewController implements Initializable {
    @FXML
    private Label Menu;

    @FXML
    private Label MenuBack;

    @FXML
    private AnchorPane slider;
    
    private HelpMenu help;
    
     @FXML
    void cadastrarEquipamentos(ActionEvent event) {
        help.cadastroEquipamento(event);
    }
    
    @FXML
    void listaEquipamentos(ActionEvent event) {
        help.listaEquipamento(event);

    }
    
    @FXML
    void editarEquipamentos(ActionEvent event) {
        help.editarEquipamentos(event);

    }
    
    @FXML
    void sair(ActionEvent event) {
        boolean sair = Mensagem.mostrarDialogoOpcao("", "Deseja sair?", "");
        if (sair){
            help.abrirLogin(event);
        }    
    }
    
    @FXML void fecharMenu(ActionEvent event) {
        boolean fechar = Mensagem.mostrarDialogoOpcao("Fechar Sistema", "DESEJA FECHAR O SISTEMA", "");
        if (fechar){
           Conexao.fecharPrograma();  
        }
    }
    
    @FXML void cadastrarUsuarios(ActionEvent event) {
        help.cadastrarUsuarios(event);

    }
    

    /**
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        help = new HelpMenu(this);
        help.organizarMenu();
        
    }

    public Label getMenu() {
        return Menu;
    }

    public Label getMenuBack() {
        return MenuBack;
    }

    public AnchorPane getSlider() {
        return slider;
    }

    
}
