/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Enum.UsuarioEnum;

/**
 *
 * @author Carlos Zetti
 */
public class Usuario {
    
   private UsuarioEnum tipoUsuario; 
   private String nomeUsuario;
   private String usuario;
   private String senha1;
   private String senha2;

    public Usuario() {
    }

    public Usuario(UsuarioEnum tipoUsuario, String nomeUsuario, String usuario, String senha1, String senha2) {
        this.tipoUsuario = tipoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.usuario = usuario;
        this.senha1 = senha1;
        this.senha2 = senha2;
    }

    public Usuario(UsuarioEnum tipoUsuario, String nomeUsuario, String usuario, String senha1) {
        this.tipoUsuario = tipoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.usuario = usuario;
        this.senha1 = senha1;
    }

    public Usuario(String usuario, String senha1) {
        this.usuario = usuario;
        this.senha1 = senha1;
    }
    
    
   

    public UsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nome) {
        this.nomeUsuario = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha) {
        this.senha1 = senha;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }
   
    
    
}
