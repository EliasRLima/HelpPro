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
 * @author root
 */
public class DaoSobre {
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
    
    public String getSobre(){
        try{
            String query = "select descricao from sobre order by id desc limit 1";
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()){
                String sobre = this.resultSet.getString("descricao");
                return sobre;
            }
            return "";
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage(),"FALHA AO LOCALIZAR SOBRE", 3);
            return "";
        }
    }
    
    public boolean setSobre(String sobre,int autor){
        try{
            String query = "insert into sobre(descricao,autor_id) values('"+sobre+"','"+autor+"');";
            this.statement.executeUpdate(query);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage(),"FALHA AO ATUALIZAR SOBRE", autor);
            return false;
        }
    }
}
