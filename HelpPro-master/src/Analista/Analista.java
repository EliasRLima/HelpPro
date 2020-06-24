/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Analista;

import Pessoa.Pessoa;

/**
 *
 * @author 201612030327
 */
public class Analista {
    private Pessoa pessoa;
    private int anos_svc = 0;
    private int avaliacao = 100;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getAnos_svc() {
        return anos_svc;
    }

    public void setAnos_svc(int anos_svc) {
        this.anos_svc = anos_svc;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    
}
