/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.help;

import controller.CadastroEquipamentoViewController;
import dao.EquipamentoDAO;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import model.Enum.EstadoEnum;
import model.Enum.TipoEquipamentoEnum;
import model.Equipamento;
import model.Mensagem.Mensagem;

/**
 *
 * @author carlos
 */
public class HelpCadastroEquipamento {
    private CadastroEquipamentoViewController controller;

    public HelpCadastroEquipamento(CadastroEquipamentoViewController controller) {
        this.controller = controller;
    }
   
    public void voltarMenu(ActionEvent event) throws Exception {
        HelpLogin login = new HelpLogin();
        login.abrirMenu(event); 
    }

    public void cadastrarEquipamentos(ActionEvent event) {
        try{
           
            EquipamentoDAO dao = new EquipamentoDAO();
            //pegar campos da view
            Equipamento equipamentoView = pegarDadosView();
            if(verificarCamposObrigatorios()){
                boolean existe = dao.verificarExistePorPat(equipamentoView);
 
                if (existe){
                    Mensagem.mostrarDialogoAviso("","","Equipamento com o patrimonio" + equipamentoView.getPatrimonio() + " Ja cadastrado!");
                }else {
                    dao.insert(equipamentoView); 
                    limparCampos();
                }
            } else {
                Mensagem.mostrarDialogoAviso("", "", "E preciso preencher os campos obrigatorio!");
            } 
        } catch(SQLException e){
            Mensagem.mostrarDialogoErro("", "", "Não foi possivel cadastrar!");
        }

    }
    
    public void limparCampos(){
        controller.getDestino().setText("");
        controller.getjTextresponsavel().setText("");
        controller.getjTextnotaFiscal().setText("");
        controller.getjTextpatrimonio().setText("");
        controller.getComboEstado().setValue(null);
        controller.getComboTiposEquipamentos().setValue(null);
    }
    
    private boolean verificarCamposObrigatorios() {
        
        EstadoEnum estado = controller.getComboEstado().getValue();
        TipoEquipamentoEnum tipoEquipamento = controller.getComboTiposEquipamentos().getValue();
        String notaFiscal = controller.getjTextnotaFiscal().getText();
        String patrimonio = controller.getjTextpatrimonio().getText();
        
        boolean TipoEquipamentoValid = tipoEquipamento != null;
        boolean NotaFiscalValid = notaFiscal != null && !notaFiscal.trim().isEmpty();
        boolean PatrimonioValid = patrimonio != null && !patrimonio.trim().isEmpty();
        boolean EstadoValid = estado != null;

        return EstadoValid && TipoEquipamentoValid && NotaFiscalValid && PatrimonioValid;
    }
    
    public Equipamento pegarDadosView(){
        String destino = controller.getDestino().getText();
        EstadoEnum estado = controller.getComboEstado().getValue();
        TipoEquipamentoEnum tipoEquipamento = controller.getComboTiposEquipamentos().getValue();
        String responsavel = controller.getjTextresponsavel().getText();
        String notaFiscal = controller.getjTextnotaFiscal().getText();
        String patrimonio = controller.getjTextpatrimonio().getText();
        
        return new Equipamento(tipoEquipamento, notaFiscal, patrimonio, destino, responsavel, estado);
    }
    
    
}
