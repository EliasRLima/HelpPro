/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import Pessoa.*;
/**
 *
 * @author root
 */
public class Cliente {
    private Pessoa pessoa;
    private int nvl_exp;
    private int chamados_num;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getNvl_exp() {
        return nvl_exp;
    }

    public void setNvl_exp(int nvl_exp) {
        this.nvl_exp = nvl_exp;
    }


    public int getChamados_num() {
        return chamados_num;
    }

    public void setChamados_num(int chamados_num) {
        this.chamados_num = chamados_num;
    }
    
    
}
