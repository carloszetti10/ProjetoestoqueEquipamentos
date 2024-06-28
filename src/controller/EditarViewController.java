/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import controller.help.HelpEditar;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Enum.EstadoEnum;
import model.Enum.TipoEquipamentoEnum;
import model.Equipamento;
import model.Mensagem.Mensagem;

/**
 * FXML Controller class
 *
 * @author carlos
 */
public class EditarViewController implements Initializable {
    
    private HelpEditar helpEditar;
    
    @FXML private TextField TextDestino;

    @FXML private TextField TextNotaFiscal;

    @FXML private TextField TextPatrimonio;

    @FXML private TextField TextResponsavel;
    
    @FXML private ComboBox<EstadoEnum> comboEstado;

    @FXML private TextField textTipoEquipamento;
    
    //Tabela
    @FXML private TableColumn<Equipamento, String> colDestino;

    @FXML private TableColumn<Equipamento, TipoEquipamentoEnum> colEquipamento;

    @FXML private TableColumn<Equipamento, EstadoEnum> colEstado;

    @FXML private TableColumn<Equipamento, String> colNotaFiscal;

    @FXML private TableColumn<Equipamento, String> colPatrimonio;

    @FXML private TableColumn<Equipamento, String> colResponsavel;
    
    @FXML private TableView<Equipamento> tabelaEditar;
    
    @FXML private ComboBox<TipoEquipamentoEnum> comboPesquisa;
    
    @FXML private TextField pesquisarPat;
    
    @FXML void tbEquipamentosClick(MouseEvent event) {
        helpEditar.selecionarEquipamentoClick();
    }
 
    @FXML void voltarMenu(ActionEvent event) {
        helpEditar.voltarMenu(event);

    }
    
    @FXML void EditarEquipamento(ActionEvent event) throws SQLException {
        helpEditar.editar(event);
        helpEditar.prencherTabelaEditar();
    }
    
    @FXML void fecharTelaEditar(ActionEvent event) {
        boolean sair = Mensagem.mostrarDialogoOpcao("", "", "DESEJA FECHAR O SISTEMA?");
        Mensagem.simOuNao(sair);
    }
    
    @FXML void pesquisaEquipamento(ActionEvent event) {
        helpEditar.pesquisaEquipamento(event);
        helpEditar.limparCampoPesqPat();
     }
    
   // @FXML void pesquisarPorPat(ActionEvent event) {
     //   helpEditar.pesquisarPorPat(event);
      //  helpEditar.limparCampoPesqEqui();
   // }
    
    @FXML
    void pesquisarPorPat(KeyEvent event) {
        helpEditar.pesquisarPorPat(event);
        helpEditar.limparCampoPesqEqui();

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //iniciar o cobobox de estado
        comboEstado.getItems().addAll(EstadoEnum.values());
        comboPesquisa.getItems().addAll(TipoEquipamentoEnum.values());
        //inicializar o ajudante 
        helpEditar = new HelpEditar(this);
        helpEditar.configurarTabelaEditar();
        helpEditar.prencherTabelaEditar();
    } 
    
    
    
    
    //get e set da Tabela
    public TableColumn<Equipamento, String> getColDestino() {
        return colDestino;
    }

    public void setColDestino(TableColumn<Equipamento, String> colDestino) {
        this.colDestino = colDestino;
    }

    public TableColumn<Equipamento, TipoEquipamentoEnum> getColEquipamento() {
        return colEquipamento;
    }

    public void setColEquipamento(TableColumn<Equipamento, TipoEquipamentoEnum> colEquipamento) {
        this.colEquipamento = colEquipamento;
    }

    public TableColumn<Equipamento, EstadoEnum> getColEstado() {
        return colEstado;
    }

    public void setColEstado(TableColumn<Equipamento, EstadoEnum> colEstado) {
        this.colEstado = colEstado;
    }

    public TableColumn<Equipamento, String> getColNotaFiscal() {
        return colNotaFiscal;
    }

    public void setColNotaFiscal(TableColumn<Equipamento, String> colNotaFiscal) {
        this.colNotaFiscal = colNotaFiscal;
    }

    public TableColumn<Equipamento, String> getColPatrimonio() {
        return colPatrimonio;
    }

    public void setColPatrimonio(TableColumn<Equipamento, String> colPatrimonio) {
        this.colPatrimonio = colPatrimonio;
    }

    public TableColumn<Equipamento, String> getColResponsavel() {
        return colResponsavel;
    }

    public void setColResponsavel(TableColumn<Equipamento, String> colResponsavel) {
        this.colResponsavel = colResponsavel;
    }

    public TableView<Equipamento> getTabelaEditar() {
        return tabelaEditar;
    }

    public void setTabelaEditar(TableView<Equipamento> tabelaEditar) {
        this.tabelaEditar = tabelaEditar;
    }
    
    
    //get e set dos campos de entrada

    public TextField getTextDestino() {
        return TextDestino;
    }

    public void setTextDestino(TextField TextDestino) {
        this.TextDestino = TextDestino;
    }

    public TextField getTextNotaFiscal() {
        return TextNotaFiscal;
    }

    public void setTextNotaFiscal(TextField TextNotaFiscal) {
        this.TextNotaFiscal = TextNotaFiscal;
    }

    public TextField getTextPatrimonio() {
        return TextPatrimonio;
    }

    public void setTextPatrimonio(TextField TextPatrimonio) {
        this.TextPatrimonio = TextPatrimonio;
    }

    public TextField getTextResponsavel() {
        return TextResponsavel;
    }

    public void setTextResponsavel(TextField TextResponsavel) {
        this.TextResponsavel = TextResponsavel;
    }

    public ComboBox<EstadoEnum> getComboEstado() {
        return comboEstado;
    }

    public void setComboEstado(ComboBox<EstadoEnum> comboEstado) {
        this.comboEstado = comboEstado;
    }

    public TextField getTextTipoEquipamento() {
        return textTipoEquipamento;
    }

    public void setTextTipoEquipamento(TextField textTipoEquipamento) {
        this.textTipoEquipamento = textTipoEquipamento;
    }  

    public ComboBox<TipoEquipamentoEnum> getComboPesquisa() {
        return comboPesquisa;
    }

    public void setComboPesquisa(ComboBox<TipoEquipamentoEnum> comboPesquisa) {
        this.comboPesquisa = comboPesquisa;
    }

    public TextField getPesquisarPat() {
        return pesquisarPat;
    }

    public void setPesquisarPat(TextField pesquisarPat) {
        this.pesquisarPat = pesquisarPat;
    }
    
    
    
    
}
