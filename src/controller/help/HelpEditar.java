/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.help;

import controller.EditarViewController;
import dao.EquipamentoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.Enum.EstadoEnum;
import model.Enum.TipoEquipamentoEnum;
import model.Equipamento;
import model.Mensagem.Mensagem;

/**
 *
 * @author carlos
 */
public class HelpEditar {
    private EditarViewController controller;

    public HelpEditar(EditarViewController controller) {
        this.controller = controller;
    }

    public void voltarMenu(ActionEvent event) {
        HelpLogin login = new HelpLogin();
        login.abrirMenu(event); 
        
    }

    public void configurarTabelaEditar() {
         // Configura as colunas da tabela
        controller.getColEquipamento().setCellValueFactory(new PropertyValueFactory<Equipamento,TipoEquipamentoEnum>("tipoEquipamento"));
        controller.getColNotaFiscal().setCellValueFactory(new PropertyValueFactory<Equipamento, String>("notaFiscal"));
        controller.getColPatrimonio().setCellValueFactory(new PropertyValueFactory<Equipamento, String>("patrimonio"));
        controller.getColDestino().setCellValueFactory(new PropertyValueFactory<Equipamento, String>("destino"));
        controller.getColEstado().setCellValueFactory(new PropertyValueFactory<Equipamento, EstadoEnum>("estado"));
        controller.getColResponsavel().setCellValueFactory(new PropertyValueFactory<Equipamento, String>("responsavel")); 
    }

    public void prencherTabelaEditar() {
        // Obtém a lista de computadores do BancoDao e cria uma ObservableList
        ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList(Equipamento.todosEquipamento());
        
        // Configura a tabela para exibir a lista de equipamentos 
        controller.getTabelaEditar().setItems(equipamentos);
    }

    public void selecionarEquipamentoClick() {
        int i = controller.getTabelaEditar().getSelectionModel().getSelectedIndex();
        
        Equipamento equipamento = (Equipamento)controller.getTabelaEditar().getItems().get(i);
        
        controller.getTextTipoEquipamento().setText(equipamento.getTipoEquipamento().getDescricao());
        controller.getTextNotaFiscal().setText(equipamento.getNotaFiscal());
        controller.getTextPatrimonio().setText(equipamento.getPatrimonio());
        controller.getTextDestino().setText(equipamento.getDestino());
        controller.getTextResponsavel().setText(equipamento.getResponsavel());
        controller.getComboEstado().setValue(equipamento.getEstado());
    }

    public void editar(ActionEvent event) throws SQLException {
        //pegar equipamento da view 
        String tipo = controller.getTextTipoEquipamento().getText();
        TipoEquipamentoEnum equipamento = TipoEquipamentoEnum.valueOf(tipo);
        String nota = controller.getTextNotaFiscal().getText();
        String destinoEditar = controller.getTextDestino().getText();
        String responsavelEditar = controller.getTextResponsavel().getText();
        EstadoEnum estadoEditar = controller.getComboEstado().getValue();
        String patrimonioEditar = controller.getTextPatrimonio().getText();
       
        Equipamento equipamentoEditar = new Equipamento(equipamento, nota, patrimonioEditar,destinoEditar, responsavelEditar,estadoEditar);
        EquipamentoDAO dao = new EquipamentoDAO();     
        
        boolean existe = dao.verificarSeExiste(equipamentoEditar);
        if (existe) {
            Mensagem.mostrarDialogoAviso("", "", "Altere os campos de entrada para Editar!");
        } else {
            dao.editar(equipamentoEditar);
        }
        
    }
        
    public boolean verificarCampoVazio() {
        String destino = controller.getTextDestino().getText();
        String responsavel = controller.getTextResponsavel().getText();
    
        boolean destinoVal = destino != null && !destino.trim().isEmpty();
        boolean responsavelVal = responsavel != null && !responsavel.trim().isEmpty();
    
        return destinoVal || responsavelVal;
    }
    
    
     public void preencherComputador(){
        // Obtém a lista de computadores do BancoDao e cria uma ObservableList
        ObservableList<Equipamento> computadores = FXCollections.observableArrayList(Equipamento.listaComputadores());
         // Configura a tabela para exibir a lista de computadores
        controller.getTabelaEditar().setItems(computadores);
    }
    
    public void preecherMonitor(){
         ObservableList<Equipamento> monitores = FXCollections.observableArrayList(Equipamento.listarMonitores());
         
         controller.getTabelaEditar().setItems(monitores);
    }
    
    public void preencherNotebook(){
         ObservableList<Equipamento> notebooks = FXCollections.observableArrayList(Equipamento.listaNotbook());
         
         controller.getTabelaEditar().setItems(notebooks);
    }
    
    public void preencherNobreak(){
        ObservableList<Equipamento> nobreaks = FXCollections.observableArrayList(Equipamento.listaNobreak());
        
        controller.getTabelaEditar().setItems(nobreaks);  
    }
    
    public void preencherPatrimonio(){
        
    }

    public void pesquisaEquipamento(ActionEvent event) {
        TipoEquipamentoEnum tipoEqui = controller.getComboPesquisa().getValue();
        switch (tipoEqui){
            case Computador:
                preencherComputador();
                break;
            case Notebook:
                preencherNotebook();
                break;
            case Nobreak:
                preencherNobreak();
                break;
            case Monitor:
                preecherMonitor();
                break;  
        }
    }

    public void pesquisarPorPat(KeyEvent event) {
        String patrimonio = controller.getPesquisarPat().getText();
        EquipamentoDAO dao = new EquipamentoDAO();
        try {
            ArrayList<Equipamento> equipamentoPesquisado = dao.pesquisarPatrimonio(patrimonio);
            ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList(equipamentoPesquisado);
            controller.getTabelaEditar().setItems(equipamentos);
            
        } catch (SQLException ex) {
            Logger.getLogger(HelpLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparCampoPesqEqui() {
        controller.getComboPesquisa().setValue(null);
    }

    public void limparCampoPesqPat() {
        controller.getPesquisarPat().setText("");
    }
}
