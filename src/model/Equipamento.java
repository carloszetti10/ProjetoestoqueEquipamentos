package model;

import controller.ListaEquipamentosViewController;
import dao.EquipamentoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import model.Enum.EstadoEnum;
import model.Enum.TipoEquipamentoEnum;


public class Equipamento {
    private final ObjectProperty<TipoEquipamentoEnum> tipoEquipamento = new SimpleObjectProperty<>();
    private StringProperty notaFiscal;
    private StringProperty patrimonio;
    private StringProperty destino;
    private StringProperty responsavel;
    private final ObjectProperty<EstadoEnum> estado = new SimpleObjectProperty<>();

    public Equipamento(TipoEquipamentoEnum tipoEquipamento, String notaFiscal, String patrimonio, String destino, String responsavel, EstadoEnum estado) {
        this.tipoEquipamento.set(tipoEquipamento);
        this.notaFiscal = new SimpleStringProperty(notaFiscal);
        this.patrimonio = new SimpleStringProperty(patrimonio);
        this.destino = new SimpleStringProperty(destino);
        this.responsavel = new SimpleStringProperty(responsavel);
        this.estado.set(estado);
    }
    
     public Equipamento(TipoEquipamentoEnum tipoEquipamento, String notaFiscal, String patrimonio, EstadoEnum estado) {
        this.tipoEquipamento.set(tipoEquipamento);
        this.notaFiscal = new SimpleStringProperty(notaFiscal);
        this.patrimonio = new SimpleStringProperty(patrimonio);
        this.estado.set(estado);
    }
    

    

    public Equipamento() {
    }
    
    

    public StringProperty notaFiscalProperty() {
        return notaFiscal;
    }

    public StringProperty patrimonioProperty() {
        return patrimonio;
    }

    public StringProperty destinoProperty() {
        return destino;
    }

    public StringProperty responsavelProperty() {
        return responsavel;
    }

    public ObjectProperty<EstadoEnum> estadoProperty() {
        return estado;
    }

    public String getNotaFiscal() {
        return notaFiscal.get();
    }

    public String getPatrimonio() {
        return patrimonio.get();
    }

    public String getDestino() {
        return destino.get();
    }

    public String getResponsavel() {
        return responsavel.get();
    }

    public EstadoEnum getEstado() {
        return estado.get();
    }

     public TipoEquipamentoEnum getTipoEquipamento() {
        return tipoEquipamento.get();
    }

    public void setTipoEquipamento(TipoEquipamentoEnum tipoEquipamento) {
        this.tipoEquipamento.set(tipoEquipamento);
    }

    public ObjectProperty<TipoEquipamentoEnum> tipoEquipamentoProperty() {
        return tipoEquipamento;
    }

   

   
     public static ArrayList<Equipamento> todosEquipamento() {
        EquipamentoDAO dao = new EquipamentoDAO();
        ArrayList<Equipamento> listaEquipamentos = null;
        try {
            listaEquipamentos = dao.listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentosViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  listaEquipamentos;
    }
     
     
    public static ArrayList<Equipamento> listaComputadores(){
        EquipamentoDAO dao = new EquipamentoDAO();
        ArrayList<Equipamento> listaComputadores = null;
        
        try {
            listaComputadores = (ArrayList<Equipamento>) dao.listarPorTipo(TipoEquipamentoEnum.fromDescricao("Computador"));
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentosViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaComputadores;
       
    }
    
    public static ArrayList<Equipamento> listarMonitores(){
        EquipamentoDAO dao = new EquipamentoDAO();
        ArrayList<Equipamento> listaMonitores = null;
        
         try {
            listaMonitores = (ArrayList<Equipamento>) dao.listarPorTipo(TipoEquipamentoEnum.fromDescricao("Monitor"));
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentosViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMonitores;
    }
    
    public static ArrayList<Equipamento> listaNotbook(){
        EquipamentoDAO dao = new EquipamentoDAO();
        ArrayList<Equipamento> notebooks = null;
        
        try {
            notebooks = (ArrayList<Equipamento>) dao.listarPorTipo(TipoEquipamentoEnum.fromDescricao("Notebook"));
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentosViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return notebooks;
    }
    
    public static ArrayList<Equipamento> listaNobreak(){
        EquipamentoDAO dao = new EquipamentoDAO();
        ArrayList<Equipamento> nobreaks = null;
        
        try {
           nobreaks = (ArrayList<Equipamento>) dao.listarPorTipo(TipoEquipamentoEnum.fromDescricao("Nobreak"));
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentosViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nobreaks;
    }
    
    

    
    
    
}
