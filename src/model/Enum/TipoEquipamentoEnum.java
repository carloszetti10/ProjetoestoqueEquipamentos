/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Enum;

/**
 *
 * @author Carlos Zetti
 */
public enum TipoEquipamentoEnum {
    Computador("Computador"),
    Monitor("Monitor"),
    Nobreak("Nobreak"),
    Notebook("Notebook");

    private final String descricao;

    TipoEquipamentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    // Método para obter o enum a partir da descrição
    public static TipoEquipamentoEnum fromDescricao(String descricao) {
        for (TipoEquipamentoEnum tipo : values()) {
            if (tipo.descricao.equals(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }

    
}
