/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import controller.help.HelpLogin;
import controller.help.HelpUsuario;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Enum.UsuarioEnum;
import model.Mensagem.Mensagem;

/**
 * FXML Controller class
 *
 * @author Carlos Zetti
 */
public class CadastroUsuarioViewController implements Initializable {
 
   
    private HelpUsuario helpUsuario;
    private LoginViewController login;

   

    public CadastroUsuarioViewController(LoginViewController login) {
        this.login = login;
    }

    public CadastroUsuarioViewController() {
    }
    
    
    
    
    
    @FXML private TextField nomeUsuario;

    @FXML private PasswordField senha1;

    @FXML private PasswordField senha2;

    @FXML private ComboBox<UsuarioEnum> tipoUsuario;

    @FXML private TextField usuario;
    

    
    

    @FXML void cadastrarUsuario(ActionEvent event) throws SQLException {
        helpUsuario.cadastrarUsuario();
    }

    @FXML void fecharSistema(ActionEvent event) {
        boolean sair = Mensagem.mostrarDialogoOpcao("", "", "DESEJA FECHAR O SISTEMA?");
        Mensagem.simOuNao(sair);
    }

    @FXML void voltarParaMenu(ActionEvent event) {
        helpUsuario.abrirMenu(event);
    }

     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //iniciar o ajudante 
        helpUsuario = new HelpUsuario(this);
        tipoUsuario.getItems().addAll(UsuarioEnum.values());
    }   

    public TextField getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(TextField nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public PasswordField getSenha1() {
        return senha1;
    }

    public void setSenha1(PasswordField senha1) {
        this.senha1 = senha1;
    }

    public PasswordField getSenha2() {
        return senha2;
    }

    public void setSenha2(PasswordField senha2) {
        this.senha2 = senha2;
    }
    
    public ComboBox<UsuarioEnum> getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(ComboBox<UsuarioEnum> tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

   
    public TextField getUsuario() {
        return usuario;
    }

    public void setUsuario(TextField usuario) {
        this.usuario = usuario;
    }
    
    
    
}
