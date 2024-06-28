/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos Zetti
 */
public class Conexao {
     public Connection getConexao() throws SQLException {
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoPc", "postgres", "postgres");
        return conexao; 
    }
     
    public static void fecharPrograma(){
        System.exit(0);
    }
   
}
