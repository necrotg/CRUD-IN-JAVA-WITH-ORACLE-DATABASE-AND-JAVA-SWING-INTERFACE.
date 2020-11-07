package DAO;
import Conexao.Conexao;
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
            stm.execute();
        
    }
    public void alterar(FornecedorModel fornecedor) throws SQLException {
        String sql = "UPDATE FORNECEDOR SET FOR_NOME = ?, FOR_RAZAO = ?, FOR_CNPJ = ?, "
                + "FOR_EMAIL = ?, FOR_DDD = ?, FOR_NUMERO =? WHERE FOR_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, fornecedor.getFOR_NOME());
        stm.setString(2, fornecedor.getFOR_RAZAO());
        stm.setString(3, fornecedor.getFOR_CNPJ());
        stm.setString(4, fornecedor.getFOR_EMAIL());
        stm.setInt(5, fornecedor.getFOR_DDD());
        stm.setInt(6, fornecedor.getFOR_NUMERO());
        stm.setInt(7, fornecedor.getFOR_ID());
        stm.execute();
        stm.close();
    }
    public void excluir(FornecedorModel fornecedor) throws SQLException {
        String sql = "DELETE FROM FORNECEDOR WHERE FOR_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, fornecedor.getFOR_ID());
        stm.execute();
        stm.close();
    }
    public ArrayList<FornecedorModel> consultar(String condicao) throws SQLException {
        ArrayList<FornecedorModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT * FROM FORNECEDOR";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();
        while (rs.next()) {
            FornecedorModel objusu = new FornecedorModel();
            objusu.setFOR_ID(rs.getInt("FOR_ID"));
            objusu.setFOR_NOME(rs.getString("FOR_NOME"));
            objusu.setFOR_RAZAO(rs.getString("FOR_RAZAO"));
            objusu.setFOR_CNPJ(rs.getString("FOR_CNPJ"));
            objusu.setFOR_EMAIL(rs.getString("FOR_EMAIL"));
            objusu.setFOR_DDD(rs.getInt("FOR_DDD"));
            objusu.setFOR_NUMERO(rs.getInt("FOR_NUMERO"));
            lista.add(objusu);
        }
        rs.close();
        stm.close();
        return lista;
}
}