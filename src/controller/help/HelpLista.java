/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.help;

import com.jfoenix.controls.JFXTextField;
import controller.ListaEquipamentosViewController;
import dao.Conexao;
import dao.EquipamentoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Enum.EstadoEnum;
import model.Enum.TipoEquipamentoEnum;
import model.Equipamento;

/**
 *
 * @author carlos
 */
public class HelpLista {
    private ListaEquipamentosViewController controller;

    public HelpLista(ListaEquipamentosViewController controller) {
        this.controller = controller;
    }

    public void voltarMenu(ActionEvent event) {
        HelpLogin login = new HelpLogin();
        login.abrirMenu(event);
    }

    public void configurarTabela() {
       
         // Configura as colunas da tabela
        controller.getColTipoEquipamento().setCellValueFactory(new PropertyValueFactory<Equipamento,TipoEquipamentoEnum>("tipoEquipamento")); 
        controller.getColNotaFiscal().setCellValueFactory(new PropertyValueFactory<Equipamento, String>("notaFiscal"));
        controller.getColPatrimonio().setCellValueFactory(new PropertyValueFactory<Equipamento, String>("patrimonio"));
        controller.getColDestino().setCellValueFactory(new PropertyValueFactory<Equipamento, String>("destino"));
        controller.getColEstado().setCellValueFactory(new PropertyValueFactory<Equipamento, EstadoEnum>("estado"));
        controller.getColResponsavel().setCellValueFactory(new PropertyValueFactory<Equipamento, String>("responsavel")); 
    }

    public void preencherTabela() {
         
        // Obtém a lista de computadores do BancoDao e cria uma ObservableList
        ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList(Equipamento.todosEquipamento());
        
        // Configura a tabela para exibir a lista de equipamentos 
        controller.getTabela().setItems(equipamentos);
    
    }  
    
    public void preencherComputador(){
        // Obtém a lista de computadores do BancoDao e cria uma ObservableList
        ObservableList<Equipamento> computadores = FXCollections.observableArrayList(Equipamento.listaComputadores());
         // Configura a tabela para exibir a lista de computadores
        controller.getTabela().setItems(computadores);
    }
    
    public void preecherMonitor(){
         ObservableList<Equipamento> monitores = FXCollections.observableArrayList(Equipamento.listarMonitores());
         
         controller.getTabela().setItems(monitores);
    }
    
    public void preencherNotebook(){
         ObservableList<Equipamento> notebooks = FXCollections.observableArrayList(Equipamento.listaNotbook());
         
         controller.getTabela().setItems(notebooks);
    }
    
    public void preencherNobreak(){
        ObservableList<Equipamento> nobreaks = FXCollections.observableArrayList(Equipamento.listaNobreak());
        
        controller.getTabela().setItems(nobreaks);
    }
    
     public void pesquisaEquipamento(ActionEvent event) {
        TipoEquipamentoEnum tipoEqui = controller.getComboTipoEqui().getValue();
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

    public void pesquisarPatimonio() {
        String patrimonio = controller.getPatrimonio().getText();
        EquipamentoDAO dao = new EquipamentoDAO();
        try {
            ArrayList<Equipamento> equipamentoPesquisado = dao.pesquisarPatrimonio(patrimonio);
            ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList(equipamentoPesquisado);
            controller.getTabela().setItems(equipamentos);
            
        } catch (SQLException ex) {
            Logger.getLogger(HelpLista.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
  
    }

    
}
