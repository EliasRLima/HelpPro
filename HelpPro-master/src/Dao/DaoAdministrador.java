/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import administrador.Administrador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 201612030327
 */
public class DaoAdministrador {
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
    
    public boolean insertAdmin(Administrador admin){
        try{
            DaoPessoa dp = new DaoPessoa();
            if(dp.estaConectado()){
                if(dp.adicionar(admin.getPessoa())){
                    String select = "select id from pessoa where CPF like '"+admin.getPessoa().getCPF()+"'";
                    this.resultSet = this.statement.executeQuery(select);
                    while(this.resultSet.next()){
                        String id = this.resultSet.getString("id");
                        String query = "insert into administradores (id_pessoa,nivel_hierarquia) values('"+id+"','"+admin.getNivel_hierarquia()+"')";
                        try{
                            this.statement.executeUpdate(query);
                            return true;
                        }catch(Exception e){
                            dp.remover(admin.getPessoa());
                            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage(),"ERRO EM DAOADMIN", 3);
                            return false;
                        }
                    }
                    dp.remover(admin.getPessoa());
                    return false;
                    
                }
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
    
    public Administrador getAdmin(int id){
        try{
            Administrador admin = null;
            String query = "select * from administradores where id_pessoa like '"+id+"'";
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()){
                admin = new Administrador();
                admin.setNivel_hierarquia(this.resultSet.getInt("nivel_hierarquia"));
            }
            return admin;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: "+e.getMessage(),"ERRO EM LOCALIZAR ADMINISTRADOR", 3);
            return null;
        }
    }
    
    public boolean removerAdmin(Administrador admin){
        try{
            DaoPessoa dp = new DaoPessoa();
            if(dp.estaConectado()){
                if(dp.remover(admin.getPessoa())){
                    String query = "delete from administradores where id_pessoa like '"+dp.getId(admin.getPessoa().getCPF())+"'";
                    this.statement.executeQuery(query);
                    return true;
                }
            }
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"ERRO EM REMOVER ADMINISTRADOR", 3);
            return false;
        }
    }
}
