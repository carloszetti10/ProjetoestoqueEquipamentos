/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.help;

import controller.CadastroUsuarioViewController;
import controller.LoginViewController;
import dao.UsuarioDao;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import model.Enum.UsuarioEnum;
import model.Mensagem.Mensagem;
import model.Usuario;

/**
 *
 * @author Carlos Zetti
 */
public class HelpUsuario {
    private CadastroUsuarioViewController controller;
    HelpLogin login = new HelpLogin();

    public HelpUsuario(CadastroUsuarioViewController controller) {
        this.controller = controller;
    }

    public HelpUsuario() {
    }
    

    public void abrirMenu(ActionEvent event) {
        
        login.abrirMenu(event); 
    }

    public void cadastrarUsuario() throws SQLException {

        Usuario usuario = pegarDadosView();
        if(verificarCampoVazio()){
                if(usuario.getSenha1().equals(usuario.getSenha2())){
              
                 
                if(verificarUsuarioAdm()){
                    cadastrarNoBanco(usuario);
                }else{
                    Mensagem.mostrarDialogoErro("", "", "Você não tem permissão para cadastrar usuários! ");
                    limparDadosSenha();
                }
                
            } else{
                Mensagem.mostrarDialogoErro("", "", "As senhas não condiz!");
                limparDadosSenha();
            }
        }else{
            Mensagem.mostrarDialogoAviso("", "", "Todos os campos devem ser preenchidos!");
        }
    }
    
    public Usuario pegarDadosView(){
        
        UsuarioEnum tipo = controller.getTipoUsuario().getValue();
        String nome = controller.getNomeUsuario().getText();
        String usuario = controller.getUsuario().getText();
        String senha1 = controller.getSenha1().getText();
        String senha2 = controller.getSenha2().getText();
      
     
        return new Usuario(tipo,nome,usuario,senha1, senha2);
    }
    
    public void limparDadosCampos(){
        controller.getTipoUsuario().setValue(null);
        controller.getNomeUsuario().setText("");
        controller.getUsuario().setText("");
        controller.getSenha1().setText("");
        controller.getSenha2().setText("");
    }
    
    public void limparDadosSenha(){
        controller.getSenha1().setText("");
        controller.getSenha2().setText("");
    }
    
    public boolean verificarCampoVazio(){
        UsuarioEnum tipo = controller.getTipoUsuario().getValue();
        String nome = controller.getNomeUsuario().getText();
        String usuario = controller.getUsuario().getText();
        String senha1 = controller.getSenha1().getText();
        String senha2 = controller.getSenha2().getText();
      
        boolean tipoVal = tipo != null; // Adicione mais verificações específicas se necessário
        boolean nomeVal = nome != null && !nome.trim().isEmpty();
        boolean usuarioVal = usuario != null && !usuario.trim().isEmpty();
        boolean senha1Val = senha1 != null && !senha1.trim().isEmpty();
        boolean senha2Val = senha2 != null && !senha2.trim().isEmpty(); 
        
        return tipoVal && nomeVal && usuarioVal && senha1Val && senha2Val;
    }
        
    
    public void cadastrarNoBanco(Usuario usuario) throws SQLException{
          UsuarioDao dao = new UsuarioDao();
          dao.inserirUsuario(usuario);
                //limpar campos
          limparDadosCampos();
    }
    
    public boolean verificarUsuarioAdm() {
        boolean adm = false;
        if(login.getTipo().equals(UsuarioEnum.ADMINISTRADOR)){
            adm = true;   
        }
        return adm;
    }
}   

