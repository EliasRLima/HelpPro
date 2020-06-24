/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pessoa.Pessoa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class DaoLogin {
    private Connection conexao = DaoConectar.conectar();
    private Statement statement = null;
    private ResultSet resultSet = null;
   
    
    public boolean estaConectado(){
		if(this.conexao != null){
			try{
                            this.statement = this.conexao.createStatement();
                            return true;
                        }catch(Exception e){
                            System.out.println("Erro:"+e);
                            return false;
                        }
		}
		else{
			return false;
		}
	}
    public boolean verificaSenha(Pessoa pessoa,String senha){
        try{
            String query = "select senha from pessoa where CPF like '"+pessoa.getCPF()+"' and senha like '"+senha+"';";
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()){
                return true;
            }
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"ERRO EM VERIFICAR SENHA", 3);
            return false;
        }
    }
    public boolean alterarSenha(Pessoa pessoa,String senha){
        try{
           String query = "update pessoa set senha = '"+senha+"' where CPF like '"+pessoa.getCPF()+"'";
           this.statement.executeUpdate(query);
           return true; 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"ERRO EM ATUALIZAR SENHA", 3);
            return false;
        }
        
    }
    
    public int getPapel(Pessoa pessoa){
        try{
            String query = "select tipo_papel from pessoa where CPF like '"+pessoa.getCPF()+"';";
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()){
                return this.resultSet.getInt("tipo_papel");
            }
            return 0;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"ERRO BUSCAR PAPEL", 3);
            return 0;
        }
    }
}
