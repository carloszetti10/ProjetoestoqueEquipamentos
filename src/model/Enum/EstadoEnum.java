/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Enum;

import static model.Enum.TipoEquipamentoEnum.values;

/**
 *
 * @author Carlos Zetti
 */
public enum EstadoEnum {
    NOVO("Novo"),
    SEMINOVO("Seminovo"),
    ANTIGO("Antigo");
    
     private final String descricao;

    private EstadoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
     
    public static EstadoEnum fromDescricao(String descricao) {
        for (EstadoEnum tipo : values()) {
            if (tipo.descricao.equals(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }
}
