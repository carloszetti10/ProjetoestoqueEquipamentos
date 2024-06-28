/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Enum.UsuarioEnum;
import model.Mensagem.Mensagem;
import model.Usuario;

/**
 *
 * @author Carlos Zetti
 */
public class UsuarioDao {
    public void inserirUsuario(Usuario usuario) throws SQLException{
        String sql = "insert into Usuarios(tipoUsuario, nomeUsuario, usuario, senha) values(?,?,?,?);";
        try(Connection conexao = new Conexao().getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(sql)){
            
            pstmt.setString(1, usuario.getTipoUsuario().getDescricao());
            pstmt.setString(2, usuario.getNomeUsuario());
            pstmt.setString(3, usuario.getUsuario());
            pstmt.setString(4, usuario.getSenha1());
            pstmt.executeUpdate(); 
            Mensagem.mostrarDialogoInformacao("", "", "Usuario Cadastrado!");
        } catch(SQLException e){
            Mensagem.mostrarDialogoErro("", "", "Erro, não foi póssivel conectar com o banco para cadastro! ");
            System.out.println(e.getMessage());
        }
            
       
    }
    
    public ArrayList selectUsuario(){
        String sql = "select * from Usuarios;";
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try(Connection conexao = new Conexao().getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
               while (rs.next()) {
            
               
                UsuarioEnum tipo = UsuarioEnum.fromDescricao(rs.getString("tipoUsuario"));
                String nome = rs.getString("nomeUsuario");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");

               Usuario usuario1 = new Usuario(tipo,nome,usuario,senha);
               usuarios.add(usuario1);
            }
        } catch (SQLException e) {
            Mensagem.mostrarDialogoErro("", "", "Não foi possível recuperar os usuários do banco de dados.");
            System.out.println(e.getMessage());
        }
            return usuarios;
            
    }
}
