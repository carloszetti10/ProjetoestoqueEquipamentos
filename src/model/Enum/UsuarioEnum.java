/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Enum;

/**
 *
 * @author Carlos Zetti
 */
public enum UsuarioEnum {
    ADMINISTRADOR("Usuario Administrativo"),
    USUARIO("Usuario");
    
    private final String descricao;


    UsuarioEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    
    public static UsuarioEnum fromDescricao(String descricao) {
        for (UsuarioEnum tipo : values()) {
            if (tipo.descricao.equals(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }

}
