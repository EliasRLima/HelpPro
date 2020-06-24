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
public class DaoCategoria {
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
    
    public int getId(String nome){
        int id = 0;
            try{
                String query = "select id from categoria where nome like '"+nome+"'";
                this.resultSet = this.statement.executeQuery(query);
                while(this.resultSet.next()){
                    id = this.resultSet.getInt("id");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro: "+e,"FALHA AO BUSCAR ID", 3);
            }
            
        return id;
    }
}
