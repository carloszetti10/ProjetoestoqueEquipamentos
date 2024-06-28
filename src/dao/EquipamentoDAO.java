/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.CadastroEquipamentoViewController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Enum.EstadoEnum;
import model.Enum.TipoEquipamentoEnum;
import model.Equipamento;
import model.Mensagem.Mensagem;

/**
 *
 * @author Carlos Zetti
 */
public class EquipamentoDAO {
   
   public void insert(Equipamento equipamento) throws SQLException {
    // Obtém a conexão do banco de dados
    try (Connection conexao = new Conexao().getConexao();
         // Prepara a instrução SQL para inserção
         PreparedStatement pstmt = conexao.prepareStatement(
            "INSERT INTO Equipamentos (tipoEquipamento, notaFiscal, patrimonio, destino, responsavel, estado) VALUES (?, ?, ?, ?, ?, ?)"
         )) {
        // Define os parâmetros da instrução SQL
        pstmt.setString(1, equipamento.getTipoEquipamento().getDescricao());
        pstmt.setString(2, equipamento.getNotaFiscal());
        pstmt.setString(3, equipamento.getPatrimonio());
        pstmt.setString(4, equipamento.getDestino());
        pstmt.setString(5, equipamento.getResponsavel());
        pstmt.setString(6, equipamento.getEstado().getDescricao());
        
        // Executa a instrução SQL
         pstmt.executeUpdate();
         Mensagem.mostrarDialogoInformacao("", "", "Equipamento Cadastrado!");
        } catch (SQLException e) {
            // Trata possíveis exceções de SQL
           Mensagem.mostrarDialogoErro("", "", "Erro, não foi póssivel conectar com o banco para cadastro! ");
            System.out.println(e.getMessage());
        } 
    }
   
   public ArrayList listarTodos() throws SQLException {
        ObservableList<Equipamento> listaEquipamentos = FXCollections.observableArrayList();
        ArrayList<Equipamento> equipamentosArrayList = new ArrayList<>(listaEquipamentos);
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement pstmt = conexao.prepareStatement("SELECT * FROM Equipamentos");
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                TipoEquipamentoEnum tipoEquipamento = TipoEquipamentoEnum.fromDescricao(rs.getString("tipoEquipamento"));
                String notaFiscal = rs.getString("notaFiscal");
                String patrimonio = rs.getString("patrimonio");
                String destino = rs.getString("destino");
                String responsavel = rs.getString("responsavel");
                EstadoEnum estado = EstadoEnum.fromDescricao(rs.getString("estado"));

                Equipamento equipamento = new Equipamento(tipoEquipamento, notaFiscal, patrimonio, destino, responsavel, estado);
                equipamentosArrayList.add(equipamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar equipamentos: " + e.getMessage());
        }
        return equipamentosArrayList;  
   }
    /**
     *
     * @param tipo
     * @return
     * @throws SQLException
     */
    public ArrayList<Equipamento> listarPorTipo (TipoEquipamentoEnum tipo) throws SQLException {
        ObservableList<Equipamento> listaEquipamentos = FXCollections.observableArrayList();
        ArrayList<Equipamento> equipamentos = new ArrayList<>(listaEquipamentos);
        String sql = "SELECT * FROM Equipamentos WHERE tipoEquipamento = ?";

        try (Connection conexao = new Conexao().getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, tipo.name());

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    TipoEquipamentoEnum tipoEquipamento = TipoEquipamentoEnum.fromDescricao(rs.getString("tipoEquipamento"));
                    String notaFiscal = rs.getString("notaFiscal");
                    String patrimonio = rs.getString("patrimonio");
                    String destino = rs.getString("destino");
                    String responsavel = rs.getString("responsavel");
                    EstadoEnum estado = EstadoEnum.fromDescricao(rs.getString("estado"));

                    Equipamento equipamento = new Equipamento(tipoEquipamento, notaFiscal, patrimonio, destino, responsavel, estado);
                    equipamentos.add(equipamento);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar equipamentos: " + e.getMessage());
            throw e; // Relança a exceção para tratamento em outro lugar, se necessário
        }

        return equipamentos;
    }
    
   public ArrayList<Equipamento> pesquisarPatrimonio(String patrimonioDado) throws SQLException {
        ObservableList<Equipamento> listaEquipamentos = FXCollections.observableArrayList();
        ArrayList<Equipamento> equipamentosArrayList = new ArrayList<>(listaEquipamentos);
        String sql = "SELECT * FROM Equipamentos WHERE patrimonio like ?";
        try (Connection conexao = new Conexao().getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, patrimonioDado+"%");
            try (ResultSet rs = pstmt.executeQuery()) {
                 while (rs.next()) {
                    TipoEquipamentoEnum tipoEquipamento = TipoEquipamentoEnum.fromDescricao(rs.getString("tipoEquipamento"));
                    String notaFiscal = rs.getString("notaFiscal");
                    String patrimonio = rs.getString("patrimonio");
                    String destino = rs.getString("destino");
                    String responsavel = rs.getString("responsavel");
                    EstadoEnum estado = EstadoEnum.fromDescricao(rs.getString("estado"));
                    Equipamento equipamento = new Equipamento(tipoEquipamento, notaFiscal, patrimonio, destino, responsavel, estado);
                    equipamentosArrayList.add(equipamento);
                }  
            }
        } catch (SQLException e) {
            Mensagem.mostrarDialogoErro("", "", "Erro ao Pesquisar!");
            System.out.println("Erro ao pesquisar equipamento por patrimônio: " + e.getMessage());
            throw e; // Relança a exceção para tratamento em outro lugar, se necessário
        }
        return equipamentosArrayList;
    }

    public void editar(Equipamento equipamento) throws SQLException {
       String sql = "update Equipamentos set responsavel = ?, estado = ?, destino = ? where patrimonio = ? ";
       
        try (Connection conexao = new Conexao().getConexao();
        PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, equipamento.getResponsavel()); 
            pstmt.setString(2, equipamento.getEstado().getDescricao());     
            pstmt.setString(3, equipamento.getDestino());    
            pstmt.setString(4, equipamento.getPatrimonio());
            pstmt.execute();
            Mensagem.mostrarDialogoInformacao("", "", "EQUIPAMENTO EDITADO COM SUCESSO!");
            
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        Mensagem.mostrarDialogoErro("ERRO", "MENSAGEM DE ERRO ", "NÃO FOI POSSIVEL EDITAR O EQUIPAMENTO");
    }
    }

    public boolean verificarSeExiste(Equipamento equipamentoEditar) throws SQLException {
       ArrayList<Equipamento> listaDeTodos = listarTodos();
       boolean existe = false;
       for(Equipamento equipamento : listaDeTodos){
           
           if ((equipamento.getDestino().equals(equipamentoEditar.getDestino())) && (equipamento.getResponsavel().equals(equipamentoEditar.getResponsavel())) && (equipamento.getEstado().equals(equipamentoEditar.getEstado()))){
               existe = true;
               break;
           } 
       }
       return existe;
    }

    public boolean verificarExistePorPat(Equipamento equipamentoEditar) throws SQLException{
        ArrayList<Equipamento> listaDeTodos = listarTodos();
        boolean existe = false;
         for(Equipamento equipamento : listaDeTodos){
            if (equipamentoEditar.getPatrimonio().equals(equipamento.getPatrimonio())){
                existe = true;
                break;
            }
        }
        return existe;
    }
}
