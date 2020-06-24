/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Analista.Analista;
import Chamados.Chamado;
import Cliente.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 201612030327
 */
public class DaoChamado {
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
    
    public boolean newChamado(Chamado chamado){
        try{
            java.util.Date d = new Date();
            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
            String query = "insert into chamados(titulo,descricao,data_inicio,id_clientes,id_categoria,situacao) values('"+chamado.getTitulo()+"','"+chamado.getDescricao()+"','"+dStr+"','"+chamado.getCliente()+"','"+chamado.getCategoria()+"','"+1+"')";
            //JOptionPane.showMessageDialog(null,query,"SQL",3);
            this.statement.executeUpdate(query);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"ERRO EM CADASTRAR CHAMADO",3);
        }
        return false;
    }
    
    public boolean setChamado(Chamado chamado,int id){
        try{
            java.util.Date d = new Date();
            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
            String query = "update chamados set titulo = '"+chamado.getTitulo()+"', descricao = '"+chamado.getDescricao()+"', id_categoria = "+chamado.getCategoria()+" where id = "+id;
            //JOptionPane.showMessageDialog(null,query,"SQL",3);
            this.statement.executeUpdate(query);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"ERRO EM EDITAR CHAMADO",3);
        }
        return false;
    }
    
    public int getId(Chamado chamado){
        try{
            int id = 0;
            String query = "select id from chamados where titulo like '"+chamado.getTitulo()+"' and descricao like '"+chamado.getDescricao()+"' and id_clientes like '"+chamado.getCliente()+"' limit 1";
            //JOptionPane.showMessageDialog(null,query,"SQL",3);
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()){
                id = this.resultSet.getInt("id");
            }
            return id;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"FALHA AO LOCALIZAR ID",3);
            return 0;
        }
    }
    
    public ArrayList<Chamado> meusChamados(int id,int abertos,String titulo){
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        Chamado chamado;
        DaoCliente dc = new DaoCliente();
        if(dc.estaConectado()){
            try{           
                String query = "select * from chamados where id_clientes like '"+id+"' and titulo like '%"+titulo+"%'";
                if(abertos==1){
                   query = "select * from chamados where situacao like '1' and id_clientes like '"+id+"' and titulo like '%"+titulo+"%'";
                }
                else if(abertos==2){
                   query = "select * from chamados where situacao like '2' and id_clientes like '"+id+"' and titulo like '%"+titulo+"%'";
                }else if(abertos==3){
                    query = "select * from chamados where situacao like '3' and id_clientes like '"+id+"'";
                    //JOptionPane.showMessageDialog(null,query,"SQL",3);
                }
                this.resultSet = this.statement.executeQuery(query);
                while(this.resultSet.next()){
                    chamado = new Chamado();
                    chamado.setTitulo(this.resultSet.getString("titulo"));
                    chamado.setDescricao(this.resultSet.getString("descricao"));
                    chamado.setData_inicio(this.resultSet.getString("data_inicio"));
                    chamado.setData_termino(this.resultSet.getString("data_termino"));
                    chamado.setCliente(this.resultSet.getInt("id_clientes"));
                    chamado.setAnalista(this.resultSet.getInt("id_analista"));
                    chamado.setSituacao(this.resultSet.getInt("situacao"));
                    chamado.setCategoria(this.resultSet.getInt("id_categoria"));
                    chamado.setAvaliacao(this.resultSet.getInt("avaliacao"));
                    chamado.setSolucao(this.resultSet.getString("solucao"));
                    chamados.add(chamado);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro: "+e,"FALHA AO BUSCAR CHAMADOS",1);
                chamados = null;
            }
        }
        
        return chamados;
    }
    
    public ArrayList<Chamado> buscarChamados(String titulo){
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        Chamado chamado;
            try{           
                String query = "select * from chamados where titulo like '%"+titulo+"%'";
                this.resultSet = this.statement.executeQuery(query);
                while(this.resultSet.next()){
                    chamado = new Chamado();
                    chamado.setTitulo(this.resultSet.getString("titulo"));
                    chamado.setDescricao(this.resultSet.getString("descricao"));
                    chamado.setData_inicio(this.resultSet.getString("data_inicio"));
                    chamado.setData_termino(this.resultSet.getString("data_termino"));
                    chamado.setCliente(this.resultSet.getInt("id_clientes"));
                    chamado.setAnalista(this.resultSet.getInt("id_analista"));
                    chamado.setSituacao(this.resultSet.getInt("situacao"));
                    chamado.setCategoria(this.resultSet.getInt("id_categoria"));
                    chamado.setAvaliacao(this.resultSet.getInt("avaliacao"));
                    chamado.setSolucao(this.resultSet.getString("solucao"));
                    chamados.add(chamado);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro: "+e,"FALHA AO BUSCAR CHAMADOS",1);
                chamados = null;
            }
        
        
        return chamados;
    }
    
    public ArrayList<Chamado> buscarNovosChamados(int categoria){
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        Chamado chamado;
            try{           
                String query = "select * from chamados where id_categoria like '"+categoria+"' and id_analista = 0 order by data_inicio asc";
                this.resultSet = this.statement.executeQuery(query);
                while(this.resultSet.next()){
                    chamado = new Chamado();
                    chamado.setTitulo(this.resultSet.getString("titulo"));
                    chamado.setDescricao(this.resultSet.getString("descricao"));
                    chamado.setData_inicio(this.resultSet.getString("data_inicio"));
                    chamado.setData_termino(this.resultSet.getString("data_termino"));
                    chamado.setCliente(this.resultSet.getInt("id_clientes"));
                    chamado.setAnalista(this.resultSet.getInt("id_analista"));
                    chamado.setSituacao(this.resultSet.getInt("situacao"));
                    chamado.setCategoria(this.resultSet.getInt("id_categoria"));
                    chamado.setAvaliacao(this.resultSet.getInt("avaliacao"));
                    chamado.setSolucao(this.resultSet.getString("solucao"));
                    chamados.add(chamado);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro: "+e,"FALHA AO BUSCAR CHAMADOS",1);
                chamados = null;
            }
        
        
        return chamados;
    }
    
    public ArrayList<Chamado> chamadosAnalista(String categoria,int id_analista){
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        Chamado chamado;
            try{           
                String query = "select * from chamados where id_categoria like '"+categoria+"' and id_analista = "+id_analista+" order by data_inicio asc";
                this.resultSet = this.statement.executeQuery(query);
                while(this.resultSet.next()){
                    chamado = new Chamado();
                    chamado.setTitulo(this.resultSet.getString("titulo"));
                    chamado.setDescricao(this.resultSet.getString("descricao"));
                    chamado.setData_inicio(this.resultSet.getString("data_inicio"));
                    chamado.setData_termino(this.resultSet.getString("data_termino"));
                    chamado.setCliente(this.resultSet.getInt("id_clientes"));
                    chamado.setAnalista(this.resultSet.getInt("id_analista"));
                    chamado.setSituacao(this.resultSet.getInt("situacao"));
                    chamado.setCategoria(this.resultSet.getInt("id_categoria"));
                    chamado.setAvaliacao(this.resultSet.getInt("avaliacao"));
                    chamado.setSolucao(this.resultSet.getString("solucao"));
                    chamados.add(chamado);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro: "+e,"FALHA AO BUSCAR CHAMADOS",1);
                chamados = null;
            }
        
        
        return chamados;
    }
    
    public ArrayList<Chamado> getAtualizados(int categoria,int id_analista){
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        Chamado chamado;
            try{           
                String query = "select * from chamados where id_categoria like '"+categoria+"' and id_analista = "+id_analista+" and situacao = 4 order by data_inicio asc";
                this.resultSet = this.statement.executeQuery(query);
                while(this.resultSet.next()){
                    chamado = new Chamado();
                    chamado.setTitulo(this.resultSet.getString("titulo"));
                    chamado.setDescricao(this.resultSet.getString("descricao"));
                    chamado.setData_inicio(this.resultSet.getString("data_inicio"));
                    chamado.setData_termino(this.resultSet.getString("data_termino"));
                    chamado.setCliente(this.resultSet.getInt("id_clientes"));
                    chamado.setAnalista(this.resultSet.getInt("id_analista"));
                    chamado.setSituacao(this.resultSet.getInt("situacao"));
                    chamado.setCategoria(this.resultSet.getInt("id_categoria"));
                    chamado.setAvaliacao(this.resultSet.getInt("avaliacao"));
                    chamado.setSolucao(this.resultSet.getString("solucao"));
                    chamado.setSituacao(4);
                    chamados.add(chamado);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro: "+e,"FALHA AO BUSCAR CHAMADOS",1);
                chamados = null;
            }
        
        
        return chamados;
    }
    
    public boolean receberChamado(Chamado chamado,Analista analista){
        try{
            int id_chamado = getId(chamado);
            int id_analista = 0;
            DaoAnalista dA = new DaoAnalista();
            if(dA.estaConectado()){
                id_analista = dA.getID(analista);
                String query = "update chamados set id_analista = "+id_analista+" where id like '"+id_chamado+"'";
                this.statement.executeUpdate(query);
                return true;
            }
       
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"FALHA AO RECEBER CHAMADO", 3);
        }
        return false;
    }
    
    public String getNomeCliente(Chamado chamado){
        try{
            String query = "select nome from pessoa where id in (select id_pessoa from clientes where id like '"+chamado.getCliente()+"')";
            this.resultSet = this.statement.executeQuery(query);
            if(this.resultSet.next()){
                query = this.resultSet.getString("nome");
                return query;
            }
            return null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"FALHA AO LOCALIZAR NOME CLIENTE", 3);
            return null;
        }
    }
    
    public String getNomeAnalista(Chamado chamado){
        try{
            String query = "select nome from pessoa where id in (select id_pessoa from analistas where id like '"+chamado.getAnalista()+"')";
            this.resultSet = this.statement.executeQuery(query);
            if(this.resultSet.next()){
                query = this.resultSet.getString("nome");
                return query;
            }
            return null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"FALHA AO LOCALIZAR NOME ANALISTA", 3);
            return null;
        }
    }
    
    public String getNomeCategoria(Chamado chamado){
        try{
            String query = "select nome from categoria where id like '"+chamado.getCategoria()+"'";
            this.resultSet = this.statement.executeQuery(query);
            if(this.resultSet.next()){
                query = this.resultSet.getString("nome");
                return query;
            }
            return null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"FALHA AO LOCALIZAR NOME CATEGORIA", 3);
            return null;
        }
    }
    
    public String getNomeSituacao(Chamado chamado){
        try{
            String query = "select nome from situacao where id like '"+chamado.getSituacao()+"'";
            //JOptionPane.showMessageDialog(null,query,"SQL",3);
            this.resultSet = this.statement.executeQuery(query);
            if(this.resultSet.next()){
                query = this.resultSet.getString("nome");
                return query;
            }
            return null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"FALHA AO LOCALIZAR NOME SITUAÇÃO", 3);
            return null;
        }
    }
    
    public boolean setSolucao(String solucao,String nome,int situacao,int id){
        try{
            String sql = "select solucao from chamados where id = "+id;
            //JOptionPane.showMessageDialog(null,sql,"SQL",3);
            this.resultSet = this.statement.executeQuery(sql);
            while(this.resultSet.next()){
                java.util.Date d = new Date();
                String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
                if(this.resultSet.getString("solucao") != null){
                    solucao = this.resultSet.getString("solucao")+"\n\n<"+nome+" "+dStr+">"+"\n"+solucao;
                }
                else{
                    solucao = "<"+nome+"  "+dStr+">"+"\n"+solucao;
                }
                String query = "update chamados set solucao = '"+solucao+"',situacao = "+situacao+" where id = "+id;
                //JOptionPane.showMessageDialog(null,query,"SQL",3);
                this.statement.executeUpdate(query);
                return true;
            }
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"ERRO EM EDITAR CHAMADO",3);
        }
        return false;
    }
    
    public boolean finalizaChamado(int avaliacao,Chamado chamado){
        try{

                java.util.Date d = new Date();
                String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
                String query = "update chamados set avaliacao = '"+avaliacao+"' ,data_termino = '"+dStr+"' ,situacao = '2' where id = "+getId(chamado);
                //JOptionPane.showMessageDialog(null,query,"SQL",3);
                this.statement.executeUpdate(query);
                return true;

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"ERRO EM FINALIZAR CHAMADO",3);
        }
        return false;
    }
}
