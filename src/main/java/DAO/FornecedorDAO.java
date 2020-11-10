package DAO;
import Conexao.Conexao;
import Model.EnderecoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.FornecedorModel;

public class FornecedorDAO {
    private Connection conexao = null;
    
    public FornecedorDAO() throws SQLException{
        this.conexao = Conexao.getConexao();
    }
    public void adicionar(FornecedorModel fornecedor) throws SQLException {
        String sql2 = "INSERT INTO ENDERECO_FORNECEDOR (FOR_ID,ENDERECO_ID)"
            + "VALUES (?, ?)";
        String sql3 = "INSERT INTO ENDERECO (ENDERECO_ID, ENDERECO_LOGRADOURO, ENDERECO_NUMERO , ENDERECO_CEP, ENDEROCO_CIDADE, ENDERECO_ESTADO)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
        String sql = "INSERT INTO FORNECEDOR (FOR_ID, FOR_NOME, FOR_RAZAO, FOR_CNPJ, FOR_EMAIL, FOR_DDD, FOR_NUMERO)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, fornecedor.getFOR_ID());
            stm.setString(2, fornecedor.getFOR_NOME());
            stm.setString(3, fornecedor.getFOR_RAZAO());
            stm.setString(4, fornecedor.getFOR_CNPJ());
            stm.setString(5, fornecedor.getFOR_EMAIL());
            stm.setInt(6, fornecedor.getFOR_DDD());
            stm.setInt(7, fornecedor.getFOR_NUMERO());
            PreparedStatement stm2 = conexao.prepareStatement(sql2);
            stm2.setInt(2, fornecedor.getEndereco().getENDERECO_ID());
            stm2.setInt(1, fornecedor.getFOR_ID());
            PreparedStatement stm3 = conexao.prepareStatement(sql3);
            stm3.setInt(1, fornecedor.getEndereco().getENDERECO_ID());
            stm3.setString(2, fornecedor.getEndereco().getENDERECO_LOGRADOURO());
            stm3.setDouble(3, fornecedor.getEndereco().getENDERECO_NUMERO());
            stm3.setString(4, fornecedor.getEndereco().getENDERECO_CEP());
            stm3.setString(5, fornecedor.getEndereco().getENDEROCO_CIDADE());
            stm3.setString(6, fornecedor.getEndereco().getENDERECO_ESTADO());
            stm.execute();
            stm3.execute();
            stm2.execute();
                    
    }
    public void alterar(FornecedorModel fornecedor) throws SQLException {
        String sql = "UPDATE FORNECEDOR SET FOR_NOME = ?, FOR_RAZAO = ?, FOR_CNPJ = ?, "
                + "FOR_EMAIL = ?, FOR_DDD = ?, FOR_NUMERO =? WHERE FOR_ID = ?";
        String sql2 = "UPDATE ENDERECO SET ENDERECO_LOGRADOURO = ? , ENDERECO_NUMERO = ?, ENDERECO_CEP = ?, ENDEROCO_CIDADE = ?, ENDERECO_ESTADO = ? WHERE ENDERECO_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, fornecedor.getFOR_NOME());
        stm.setString(2, fornecedor.getFOR_RAZAO());
        stm.setString(3, fornecedor.getFOR_CNPJ());
        stm.setString(4, fornecedor.getFOR_EMAIL());
        stm.setInt(5, fornecedor.getFOR_DDD());
        stm.setInt(6, fornecedor.getFOR_NUMERO());
        stm.setInt(7, fornecedor.getFOR_ID());
        PreparedStatement stm2 = conexao.prepareStatement(sql2); 
            stm2.setString(1, fornecedor.getEndereco().getENDERECO_LOGRADOURO());
            stm2.setDouble(2, fornecedor.getEndereco().getENDERECO_NUMERO());
            stm2.setString(3, fornecedor.getEndereco().getENDERECO_CEP());
            stm2.setString(4, fornecedor.getEndereco().getENDEROCO_CIDADE());
            stm2.setString(5, fornecedor.getEndereco().getENDERECO_ESTADO());
            stm2.setInt(6, fornecedor.getEndereco().getENDERECO_ID());
        
        stm.execute();
        stm.close();
        stm2.execute();
        stm2.close();
    }
    public void excluir(FornecedorModel fornecedor) throws SQLException {
        String sql = "DELETE FROM ENDERECO_FORNECEDOR WHERE FOR_ID = ?";
        String sql2 = "DELETE FROM FORNECEDOR WHERE FOR_ID = ?";
        String sql3 = "DELETE FROM ENDERECO WHERE ENDERECO_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, fornecedor.getFOR_ID());
        stm.execute();
        stm.close();
        PreparedStatement stm2 = conexao.prepareStatement(sql2);
        stm2.setInt(1, fornecedor.getFOR_ID());
        stm2.execute();
        stm2.close();
        PreparedStatement stm3 = conexao.prepareStatement(sql3);
        stm3.setInt(1, fornecedor.getEndereco().getENDERECO_ID());
        stm3.execute();
        stm3.close();
    }
    public ArrayList<FornecedorModel> consultar(String condicao) throws SQLException {
        ArrayList<FornecedorModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT ENDERECO.ENDERECO_ID, ENDERECO.ENDERECO_LOGRADOURO, ENDERECO.ENDERECO_NUMERO , ENDERECO.ENDERECO_CEP, ENDERECO.ENDEROCO_CIDADE, ENDERECO.ENDERECO_ESTADO, FORNECEDOR.FOR_ID ,FORNECEDOR.FOR_NOME,FORNECEDOR.FOR_RAZAO ,FORNECEDOR.FOR_CNPJ ,FORNECEDOR.FOR_EMAIL ,FORNECEDOR.FOR_DDD ,FORNECEDOR.FOR_NUMERO FROM ENDERECO, FORNECEDOR, ENDERECO_FORNECEDOR WHERE FORNECEDOR.FOR_ID = ENDERECO_FORNECEDOR.FOR_ID AND ENDERECO_FORNECEDOR.ENDERECO_ID = ENDERECO.ENDERECO_ID";
        if (!condicao.equals("")) {
            sql += " AND " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();
        while (rs.next()) {
            
            FornecedorModel fornecedor = new FornecedorModel();
            EnderecoModel endereco = new EnderecoModel();
            fornecedor.setFOR_ID(rs.getInt("FOR_ID"));
            fornecedor.setFOR_NOME(rs.getString("FOR_NOME"));
            fornecedor.setFOR_RAZAO(rs.getString("FOR_RAZAO"));
            fornecedor.setFOR_CNPJ(rs.getString("FOR_CNPJ"));
            fornecedor.setFOR_EMAIL(rs.getString("FOR_EMAIL"));
            fornecedor.setFOR_DDD(rs.getInt("FOR_DDD"));
            fornecedor.setFOR_NUMERO(rs.getInt("FOR_NUMERO"));
            endereco.setENDERECO_ID(rs.getInt("ENDERECO_ID"));
            endereco.setENDERECO_LOGRADOURO(rs.getString("ENDERECO_LOGRADOURO"));
            endereco.setENDERECO_NUMERO(rs.getInt("ENDERECO_NUMERO"));
            endereco.setENDERECO_CEP(rs.getString("ENDERECO_CEP"));
            endereco.setENDEROCO_CIDADE(rs.getString("ENDEROCO_CIDADE"));
            endereco.setENDERECO_ESTADO(rs.getString("ENDERECO_ESTADO"));
            fornecedor.setEndereco(endereco);
            
            lista.add(fornecedor);
        }
        rs.close();
        stm.close();
        return lista;
}
}