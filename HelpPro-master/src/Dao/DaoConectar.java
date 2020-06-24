/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 201612030327
 */
public class DaoConectar {
    
        public static Connection conectar(){
		String servidor = "jdbc:mysql://127.0.0.1:3306/helpbd";
		try{
                        Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(servidor, "root", "");
			return conexao;
		}
                catch(Exception e){
			System.out.println("Erro em conectar: " +e.getMessage());
                        return null;
		}
                 
	}
}
