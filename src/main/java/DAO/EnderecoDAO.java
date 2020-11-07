/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.EnderecoModel;

public class EnderecoDAO {
    private Connection conexao = null;
    
    public EnderecoDAO() throws SQLException{
        this.conexao = Conexao.getConexao();
    }
    
    public ArrayList<EnderecoModel> consultar(String condicao) throws SQLException {
        ArrayList<EnderecoModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT ENDERECO_LOGRADOURO, ENDERECO_NUMERO , ENDERECO_CEP, ENDEROCO_CIDADE, ENDERECO_ESTADO FROM (ENDERECO INNER JOIN ENDERECO_CLIENTE ON ENDERECO.ENDERECO_ID = ENDERECO_CLIENTE.ENDERECO_ID) INNER JOIN CLIENTE ON CLIENTE.CLI_ID = ENDERECO_CLIENTE.CLI_ID;";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();
        while (rs.next()) {
            EnderecoModel objusu = new EnderecoModel();
            objusu.setENDERECO_LOGRADOURO(rs.getString("ENDERECO_LOGRADOURO"));
            objusu.setENDERECO_NUMERO(rs.getDouble("ENDERECO_NUMERO"));
            objusu.setENDERECO_CEP(rs.getString("ENDERECO_CEP"));
            objusu.setENDEROCO_CIDADE(rs.getString("ENDEROCO_CIDADE"));
            objusu.setENDERECO_ESTADO(rs.getString("ENDERECO_ESTADO"));
            lista.add(objusu);
        }
        rs.close();
        stm.close();
        return lista;
}
    
}
