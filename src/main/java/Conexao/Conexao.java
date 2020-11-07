/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import View.LoginView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    private final static String DRIVER = "oracle.jdbc.OracleDriver";
    private final static String BANCO = "jdbc:oracle:thin:@localhost:1521:XE";
    private final static String USUARIO = "trab";
    private final static String SENHA = "123";
    LoginView login = new LoginView();

    private static Connection conexao;

    public Conexao() {
        try {            
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Classe de Conexao do Banco. \n" + ex.getMessage());
            conexao = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco.\n" + ex.getMessage());
            conexao = null;
        }
    }

    public static Connection getConexao() {
        return conexao;
    }

    public void desconectar() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao fechar conexao.\n" + ex.getMessage());
        }
    }
}