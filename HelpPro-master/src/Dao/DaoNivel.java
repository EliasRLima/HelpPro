/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 201612030327
 */
public class DaoNivel {
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
    
    public String getNome(int id){
        try{
            String sql = "select nome from nivel where id = "+id;
            this.resultSet = this.statement.executeQuery(sql);
            while(this.resultSet.next()){
                return this.resultSet.getString("nome");
            }
            return null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(), "Erro", 3);
            return null;
        }
    }
}
