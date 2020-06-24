/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Analista.Analista;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 201612030327
 */
public class DaoAnalista {
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
                    JOptionPane.showMessageDialog(null,"SEM CONEXAO","ALERTA", 3);
			return false;
		}
	}
    
    public boolean adicionar(Analista analista){
        try{
            DaoPessoa daoP = new DaoPessoa();
            if(daoP.estaConectado()){
                if(!daoP.cpfCadastrado(analista.getPessoa().getCPF())){
                    if(daoP.adicionar(analista.getPessoa())){
                        try{
                            String query = "select id from pessoa where cpf like '"+analista.getPessoa().getCPF()+"';";
                            this.resultSet = this.statement.executeQuery(query);
                            while(this.resultSet.next()){
                                query = "insert into analistas(id_pessoa,anos_svc,avaliacao) values('"+this.resultSet.getString("id")+"','"+analista.getAnos_svc()+"','"+analista.getAvaliacao()+"');";
                                this.statement.executeUpdate(query);
                                return true;
                            }
                        }catch(Exception erro){
                            JOptionPane.showMessageDialog(null, "Erro: "+erro.getMessage(), "FALHA AO ADICIONAR", 3);
                        }
                        daoP.remover(analista.getPessoa());
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar a pessoa!", "FALHA AO ADICIONAR", 3);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "CPF ja cadastrado!", "FALHA AO ADICIONAR", 3);
                }
            }
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage(), "FALHA AO ADICIONAR", 3);
            return false;
        }
    }
    
    public Analista getAnalista(int id){
        try{
            Analista analista = null;
            String query = "select * from analistas where id_pessoa like '"+id+"'";
            //JOptionPane.showMessageDialog(null,query);
            this.resultSet = this.statement.executeQuery(query);
            //JOptionPane.showMessageDialog(null,query);
            while(this.resultSet.next()){
                analista = new Analista();
                analista.setAnos_svc(this.resultSet.getInt("anos_svc"));
                analista.setAvaliacao(this.resultSet.getInt("avaliacao"));
            }
            
            return analista;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage(),"ERRO EM LOCALIZAR ANALISTA", 3);
            return null;
        }
    }
    
    public boolean removerAnalista(Analista analista){
        try{
            DaoPessoa dp = new DaoPessoa();
            if(dp.estaConectado()){
                if(dp.remover(analista.getPessoa())){
                    String query = "delete from analistas where id_pessoa like '"+dp.getId(analista.getPessoa().getCPF())+"'";
                    this.statement.executeUpdate(query);
                    return true;
                }
            }
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e,"ERRO EM REMOVER ANALISTA", 3);
            return false;
        }
    }
    
    public int getID(Analista analista){
        try{
            DaoPessoa dp = new DaoPessoa();
            if(dp.estaConectado()){
                String query = "select id from analistas where id_pessoa like '"+dp.getId(analista.getPessoa().getCPF())+"'";
                this.resultSet = this.statement.executeQuery(query);
                if(this.resultSet.next()){
                    return this.resultSet.getInt("id");
                }
            }    
             return 0;
        }catch(Exception e){
            return 0;
        }
    }
    
    public boolean avaliar(int id, int avaliacao){
        try{
           // System.out.println("\nEntrou: ");
            String sql = "select avaliacao from analistas where id like '"+id+"'";      
            //System.out.println("\nSQL1: "+sql);
            this.resultSet = this.statement.executeQuery(sql);
            while(this.resultSet.next()){
                int nova_avaliacao = (this.resultSet.getInt("avaliacao")+avaliacao)/2;
                //System.out.println("\nAvaliacao: "+nova_avaliacao);
                sql = "update analistas set avaliacao = '"+nova_avaliacao+"' where id = "+id;
                //System.out.println("\nSQL2: "+sql);
                this.statement.executeUpdate(sql);
                return true;
            }
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"FALHA AO ATUALIZAR AVALIAÇÃO", 3);
            return false;
        }
    }
}
