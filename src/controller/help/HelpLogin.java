/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.help;


import controller.CadastroUsuarioViewController;
import controller.LoginViewController;
import dao.UsuarioDao;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Enum.UsuarioEnum;
import model.Mensagem.Mensagem;
import model.Usuario;


/**
 *
 * @author carlos
 */
public class HelpLogin {
    private static UsuarioEnum tipo;
    private LoginViewController controller;
    
    
    private Stage stage; 

    public HelpLogin(LoginViewController controller) {
        this.controller = controller;
    }
    
    public HelpLogin() {
    }


    public void abrirMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MenuFXML.fxml"));
            Scene scene = new Scene(loader.load());
            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
             e.printStackTrace();
        }
    }

    public void verificarUsuario(ActionEvent event) {
        //pegar dados da view 
        String usuarioDado = controller.getCampoUsuario().getText();
        String senhaDada = controller.getCompoSenha().getText(); 
        //verivicar se tem no banco
        UsuarioDao dao = new UsuarioDao();
        ArrayList<Usuario> usuarios = dao.selectUsuario();
        // se sim, abrir o menu
        boolean correto = false;
        for(Usuario usuarioBanco : usuarios){
            if(usuarioDado.equals(usuarioBanco.getUsuario()) && senhaDada.equals(usuarioBanco.getSenha1())){
                correto = true;
                tipo = usuarioBanco.getTipoUsuario();
                break;
            }    
        }
        if(correto){
            abrirMenu(event);
        } else{
             Mensagem.mostrarDialogoErro("", "", "Usuario inválido!");
        } 
    }
   
    public UsuarioEnum getTipo() {
        return tipo;
    }
  
}
