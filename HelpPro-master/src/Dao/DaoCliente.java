/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Cliente.Cliente;
import Pessoa.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author root
 */
public class DaoCliente {
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
    
    public boolean adicionar(Cliente cliente){
        try{
            DaoPessoa np = new DaoPessoa();
            int erro = 0;
            if(np.estaConectado()){
                if(np.adicionar(cliente.getPessoa())){
                    try{
                        String query = "select id from pessoa where cpf like '"+cliente.getPessoa().getCPF()+"'";
                        this.resultSet = this.statement.executeQuery(query);
                        while(this.resultSet.next()){                            
                            query = "insert into clientes(nvl_exp,num_total,id_pessoa) values('"+cliente.getNvl_exp()+"','"+cliente.getChamados_num()+"','"+this.resultSet.getInt("id")+"')";
                            this.statement.executeUpdate(query);
                            return true;
                        }
                        erro = 1;
                    }catch(Exception e){
                        System.out.println("Erro: "+e.getMessage());
                        erro = 1;
                    }
                }
                if(erro == 1){
                    np.remover(cliente.getPessoa());
                    return false;
                }
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
    
    public Cliente getCliente(int id){
        try{
            Cliente cliente = null;
            String query = "select * from clientes where id_pessoa like '"+id+"'";
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()){
                cliente = new Cliente();
                cliente.setChamados_num(this.resultSet.getInt("num_total"));
                cliente.setNvl_exp(this.resultSet.getInt("nvl_exp"));
            }
            return cliente;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage(),"ERRO EM LOCALIZAR CLIENTE", 3);
            return null;
        }
    }
    
    public boolean removerCliente(Cliente cliente){
        try{
            DaoPessoa dp = new DaoPessoa();
            if(dp.estaConectado()){
                if(dp.remover(cliente.getPessoa())){
                    String query = "delete from clientes where id_pessoa like '"+dp.getId(cliente.getPessoa().getCPF())+"'";
                    this.statement.executeUpdate(query);
                    return true;
                }
            }
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage(),"ERRO EM REMOVER CLIENTE", 3);
            return false;
        }
    }
    
    public boolean setNumChamados(Cliente cliente){
        try{
            String query = "update clientes set num_total = '"+cliente.getChamados_num()+"'";
            int boleano = this.statement.executeUpdate(query);
            if(boleano > 0){
                return true;
            }
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"UPDATE NUMERO DE CHAMADOS", 3);
            return false;
        }
    }
    
    public int getIdCliente(int id){
        try{
                String query = "select id from clientes where id_pessoa like '"+id+"'";
                //JOptionPane.showMessageDialog(null,query,"sql",3);
                this.resultSet = this.statement.executeQuery(query);
                //JOptionPane.showMessageDialog(null,query,"sql2",3);
                while(this.resultSet.next()){
                    return this.resultSet.getInt("id");
                }           
            return 0;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage(),"ERRO EM LOCALIZAR ID CLIENTE", 3);
            return 0;
        }
    }
    
    public boolean editar(Cliente cliente,int id_cliente,int id_pessoa){
        try{
            String sql = "update clientes set nvl_exp = '"+cliente.getNvl_exp()+"' where id = '"+id_cliente+"';";
            //JOptionPane.showMessageDialog(null,sql,"sql",3);
            //System.out.println("\n"+sql);
            this.statement.executeUpdate(sql);
            sql = "UPDATE `pessoa` SET `nome`='"+cliente.getPessoa().getNome()+"',`cpf`='"+cliente.getPessoa().getCPF()+"',`sexo`='"+cliente.getPessoa().getSexo()+"',`dt_nasc`= '"+cliente.getPessoa().getDt_nasc()+"' WHERE id = "+id_pessoa;
            //JOptionPane.showMessageDialog(null,sql,"sql",3);
            //System.out.println("\n"+sql);
            this.statement.executeUpdate(sql);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage(),"ERRO", 3);
            return false;
        }
    }
}
