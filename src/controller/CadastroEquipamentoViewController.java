/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import controller.help.HelpCadastroEquipamento;
import dao.EquipamentoDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Enum.EstadoEnum;
import model.Enum.TipoEquipamentoEnum;
import model.Equipamento;
import model.Mensagem.Mensagem;

/**
 * FXML Controller class
 *
 * @author carlos
 */
public class CadastroEquipamentoViewController implements Initializable {

    private HelpCadastroEquipamento help;
    
    @FXML private TextField destino;

    @FXML private ComboBox<EstadoEnum> comboEstado;

    @FXML private ComboBox<TipoEquipamentoEnum> comboTiposEquipamentos;

    @FXML private TextField jTextresponsavel;

    @FXML private TextField jTextnotaFiscal;

    @FXML private TextField jTextpatrimonio;

    @FXML void cadastrarEquipamento(ActionEvent event) throws SQLException {
        help.cadastrarEquipamentos(event); 
    }

    @FXML void voltarParaMenu(ActionEvent event) throws Exception {
        help.voltarMenu(event);
    }
    
    @FXML void fecharTelaCadastro(ActionEvent event) {
        boolean sair = Mensagem.mostrarDialogoOpcao("", "", "DESEJA FECHAR O SISTEMA?");
        Mensagem.simOuNao(sair);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboTiposEquipamentos.getItems().addAll(TipoEquipamentoEnum.values());
        comboEstado.getItems().addAll(EstadoEnum.values());
        help = new HelpCadastroEquipamento(this);
    } 

    public TextField getDestino() {
        return destino;
    }

    public void setDestino(TextField destino) {
        this.destino = destino;
    }

    public ComboBox<EstadoEnum> getComboEstado() {
        return comboEstado;
    }

    public void setComboEstado(ComboBox<EstadoEnum> comboEstado) {
        this.comboEstado = comboEstado;
    }

    public ComboBox<TipoEquipamentoEnum> getComboTiposEquipamentos() {
        return comboTiposEquipamentos;
    }

    public void setComboTiposEquipamentos(ComboBox<TipoEquipamentoEnum> comboTiposEquipamentos) {
        this.comboTiposEquipamentos = comboTiposEquipamentos;
    }

    public TextField getjTextresponsavel() {
        return jTextresponsavel;
    }

    public void setjTextresponsavel(TextField jTextresponsavel) {
        this.jTextresponsavel = jTextresponsavel;
    }

    public TextField getjTextnotaFiscal() {
        return jTextnotaFiscal;
    }

    public void setjTextnotaFiscal(TextField jTextnotaFiscal) {
        this.jTextnotaFiscal = jTextnotaFiscal;
    }

    public TextField getjTextpatrimonio() {
        return jTextpatrimonio;
    }

    public void setjTextpatrimonio(TextField jTextpatrimonio) {
        this.jTextpatrimonio = jTextpatrimonio;
    }

    public HelpCadastroEquipamento getHelp() {
        return help;
    }

    public void setHelp(HelpCadastroEquipamento help) {
        this.help = help;
    }
    
    
    
}
