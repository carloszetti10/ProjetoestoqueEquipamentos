/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;


import com.jfoenix.controls.JFXTextField;
import controller.help.HelpEditar;
import controller.help.HelpLista;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

import model.Enum.EstadoEnum;
import model.Enum.TipoEquipamentoEnum;
import model.Equipamento;
import model.Mensagem.Mensagem;


/**
 * FXML Controller class
 *
 * @author carlos
 */
public class ListaEquipamentosViewController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    private HelpLista help;
    
    @FXML private TableColumn<Equipamento, String> colDestino;

    @FXML private TableColumn<Equipamento, EstadoEnum> colEstado;

    @FXML private TableColumn<Equipamento, String> colNotaFiscal;

    @FXML private TableColumn<Equipamento, String> colPatrimonio;

    @FXML private TableColumn<Equipamento, String> colResponsavel;
    
    @FXML private ComboBox<TipoEquipamentoEnum> listarEquipamento;

    @FXML private TableView<Equipamento> tabela;

    @FXML private TableColumn<Equipamento, TipoEquipamentoEnum> colTipoEquipamento;
    
    @FXML private JFXTextField Patrimonio;
    
    @FXML private ComboBox<TipoEquipamentoEnum> comboTipoEqui;
    
    @FXML
    void fecharLista(ActionEvent event) {
        boolean sair = Mensagem.mostrarDialogoOpcao("Fechar Sistema", "DESEJA FECHAR O SISTEMA?", "");
        Mensagem.simOuNao(sair);
       
    }
    
    @FXML void pesquisarPatrimonio(KeyEvent event) {
        help.pesquisarPatimonio();
        //Patrimonio.clear(); // APAGAR TEXTO DO TEXTFIELDE PATRIMONIO
    }

    @FXML void selectTodos(ActionEvent event) {
        help.preencherTabela();

    }

    @FXML void voltarMenu(ActionEvent event) {
        help.voltarMenu(event);
        
    }
    private EditarViewController hepEditar;
    @FXML void pesquisaEquipamento(ActionEvent event) {
        help.pesquisaEquipamento(event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        // inicializar meu ajudante
        help = new HelpLista(this);
        help.configurarTabela();
        help.preencherTabela();
       
        comboTipoEqui.getItems().addAll(TipoEquipamentoEnum.values());
    }
   
   
    public HelpLista getHelp() {
        return help;
    }

    public TableColumn<Equipamento, String> getColDestino() {
        return colDestino;
    }

    public TableColumn<Equipamento, EstadoEnum> getColEstado() {
        return colEstado;
    }

    public TableColumn<Equipamento, String> getColNotaFiscal() {
        return colNotaFiscal;
    }

    public TableColumn<Equipamento, String> getColPatrimonio() {
        return colPatrimonio;
    }

    public TableColumn<Equipamento, String> getColResponsavel() {
        return colResponsavel;
    }

    public TableView<Equipamento> getTabela() {
        return tabela;
    }

    public TableColumn<Equipamento, TipoEquipamentoEnum> getColTipoEquipamento() {
        return colTipoEquipamento;
    }

    public JFXTextField getPatrimonio() {
        return Patrimonio;
    }

    public void setPatrimonio(JFXTextField Patrimonio) {
        this.Patrimonio = Patrimonio;
    }

    public ComboBox<TipoEquipamentoEnum> getListarEquipamento() {
        return listarEquipamento;
    }

    public ComboBox<TipoEquipamentoEnum> getComboTipoEqui() {
        return comboTipoEqui;
    }

    public void setComboTipoEqui(ComboBox<TipoEquipamentoEnum> comboTipoEqui) {
        this.comboTipoEqui = comboTipoEqui;
    }

    
    
    
     
}
