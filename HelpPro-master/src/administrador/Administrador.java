/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package administrador;

import Pessoa.Pessoa;

/**
 *
 * @author 201612030327
 */
public class Administrador {
    private Pessoa pessoa;
    private int nivel_hierarquia;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getNivel_hierarquia() {
        return nivel_hierarquia;
    }

    public void setNivel_hierarquia(int nivel_hierarquia) {
        this.nivel_hierarquia = nivel_hierarquia;
    }
    
}
