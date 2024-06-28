package controller;

import controller.help.HelpLogin;
import controller.help.HelpUsuario;
import dao.Conexao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Enum.UsuarioEnum;
import model.Mensagem.Mensagem;


public class LoginViewController implements Initializable {
    private HelpLogin help;
    private CadastroUsuarioViewController usuario;

    public LoginViewController() {
    }

    
    private UsuarioEnum tipo;

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField compoSenha;

    @FXML
    void exit(ActionEvent event) {
       Conexao.fecharPrograma();
    }
    
    @FXML
    public void fazerLogin(ActionEvent event) throws Exception {
        
        help.verificarUsuario(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        help = new HelpLogin(this);
    }
    
   
    public TextField getCampoUsuario() {
        return campoUsuario;
    }

    public void setCampoUsuario(TextField campoUsuario) {
        this.campoUsuario = campoUsuario;
    }

    public PasswordField getCompoSenha() {
        return compoSenha;
    }

    public void setCompoSenha(PasswordField compoSenha) {
        this.compoSenha = compoSenha;
    }  

    public HelpLogin getHelp() {
        return help;
    }

    public UsuarioEnum getTipo() {
        return tipo;
    }

   
    
    
}
