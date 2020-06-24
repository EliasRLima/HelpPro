/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Pessoa.Pessoa;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class DaoPessoa {
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
                        JOptionPane.showMessageDialog(null,"SEM CONEXAO","ERRO", 3);
			return false;
		}
	}
    

    public boolean adicionar(Pessoa pessoa) {
        try{
            
            String query = "INSERT INTO pessoa (nome,dt_nasc,cpf,sexo,senha,tipo_papel)values('"+pessoa.getNome()+"','"+pessoa.getDt_nasc()+"','"+pessoa.getCPF()+"','"+pessoa.getSexo()+"','"+pessoa.getSenha()+"','"+pessoa.getTipo_papel()+"')";
            //System.out.println("Query:"+query);
            this.statement.executeUpdate(query);
            return true;
	}catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
            return false;
        }

    }
    
    public Pessoa getPessoa(String cpf){
        try{
            Pessoa pessoa = null;
           String query = "select * from pessoa where CPF like '"+cpf+"'";
           this.resultSet = this.statement.executeQuery(query);
           while(this.resultSet.next()){
               pessoa = new Pessoa(this.resultSet.getString("nome"),this.resultSet.getString("cpf"));
               pessoa.setDt_nasc(this.resultSet.getString("dt_nasc"));
               pessoa.setSexo(this.resultSet.getInt("sexo"));
               pessoa.setTipo_papel(this.resultSet.getInt("tipo_papel"));
           }
           return pessoa;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage(),"ERRO EM LOCALIZAR PESSOA", 3);
            return null;
        }
    }
    
    public int getId(String cpf){
        try{
            int id = 0;
           String query = "select id from pessoa where CPF like '"+cpf+"'";
           this.resultSet = this.statement.executeQuery(query);
           while(this.resultSet.next()){
               id = this.resultSet.getInt("id");
           }
           return id;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage(),"ERRO EM LOCALIZAR ID", 3);
            return 0;
        }
    }
    
    public boolean remover(Pessoa pessoa){
        try{
            String query = "delete from pessoa where CPF like '"+pessoa.getCPF()+"'";
            //System.out.println("Query: "+query);
            this.statement.executeUpdate(query);
            query = "select nome from pessoa where CPF like '"+pessoa.getCPF()+"'";
            this.resultSet = this.statement.executeQuery(query);
            if(this.resultSet.next()){
                return false;
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean editar(Pessoa pessoa,int id){
        try{
            String query = "UPDATE pessoa set nome = '"+pessoa.getNome()+"', cpf = '"+pessoa.getCPF()+"', sexo = '"+pessoa.getSexo()+"', dt_nasc = '"+pessoa.getDt_nasc()+"' where id like '"+id+"'";
            //System.out.println("Query: "+query);
            this.statement.executeUpdate(query);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro em editar: "+e.getMessage(), "ERRO", 3);
            return false;
        }
    }
    
    public boolean cpfCadastrado(String CPF){
        try{
            String query = "select * from pessoa where CPF like '"+CPF+"'";
            this.resultSet = this.statement.executeQuery(query);
            if(this.resultSet.next()){
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro em verificar CFP: "+e.getMessage(), "ERRO", 3);
            return false;
        }
    }
}
