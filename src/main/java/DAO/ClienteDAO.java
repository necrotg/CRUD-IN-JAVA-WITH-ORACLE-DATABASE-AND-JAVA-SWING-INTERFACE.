package DAO;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.ClienteModel;

public class ClienteDAO {
    private Connection conexao = null;
    
    public ClienteDAO() throws SQLException{
        this.conexao = Conexao.getConexao();
    }
    public void adicionar(ClienteModel cliente) throws SQLException {
    //    String sql = "INSERT INTO CLIENTE (CLI_ID, CLI_NOME, CLI_CPF, CLI_EMAIL, CLI_DDD, CLI_TELEFONE)"
   //             + "VALUES (?, ?, ?, ?, ?, ?)"
     //           + "INSERT INTO ENDERECO_CLIENTE (CLI_ID,ENDERECO_ID)"
     //           + "VALUES (?,?)"
     //           + "INSERT INTO ENDERECO (ENDERECO_ID, ENDERECO_LOGRADOURO, ENDERECO_NUMERO , ENDERECO_CEP, ENDEROCO_CIDADE, ENDERECO_ESTADO)"
     //           + "VALUES (?, ?, ?, ?, ?, ?)";
            String sql = "INSERT INTO CLIENTE (CLI_ID, CLI_NOME, CLI_CPF, CLI_EMAIL, CLI_DDD, CLI_TELEFONE)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, cliente.getCLI_ID());
            stm.setString(2, cliente.getCLI_NOME());
            stm.setString(3, cliente.getCLI_CPF());
            stm.setString(4, cliente.getCLI_EMAIL());
            stm.setInt(5, cliente.getCLI_DDD());
            stm.setInt(6, cliente.getCLI_TELEFONE());
   //         stm.setInt(8, cliente.getEndereco().getENDERECO_ID());
    //        stm.setInt(9, cliente.getEndereco().getENDERECO_ID());
    //        stm.setString(10, cliente.getEndereco().getENDERECO_LOGRADOURO());
     //       stm.setDouble(11, cliente.getEndereco().getENDERECO_NUMERO());
     //       stm.setString(12, cliente.getEndereco().getENDERECO_CEP());
     //       stm.setString(13, cliente.getEndereco().getENDEROCO_CIDADE());
     //       stm.setString(14, cliente.getEndereco().getENDERECO_ESTADO());
            stm.execute();
        
    }
    public void alterar(ClienteModel cliente) throws SQLException {
        String sql = "UPDATE CLIENTE SET CLI_NOME = ?, CLI_CPF = ?, "
                + "CLI_EMAIL = ?, CLI_DDD = ?, CLI_TELEFONE =? WHERE CLI_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, cliente.getCLI_NOME());
        stm.setString(2, cliente.getCLI_CPF());
        stm.setString(3, cliente.getCLI_EMAIL());
        stm.setInt(4, cliente.getCLI_DDD());
        stm.setInt(5, cliente.getCLI_TELEFONE());
        stm.setInt(6, cliente.getCLI_ID());
        stm.execute();
        stm.close();
    }
    public void excluir(ClienteModel cliente) throws SQLException {
        String sql = "DELETE FROM CLIENTE WHERE CLI_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, cliente.getCLI_ID());
        stm.execute();
        stm.close();
    }
    public ArrayList<ClienteModel> consultar(String condicao) throws SQLException {
        ArrayList<ClienteModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
 //       String sql = "SELECT * FROM ((ENDERECO INNER JOIN ENDERECO_CLIENTE ON ENDERECO.ENDERECO_ID = ENDERECO_CLIENTE.ENDERECO_ID) INNER JOIN CLIENTE ON CLIENTE.CLI_ID = ENDERECO_CLIENTE.CLI_ID)";
        String sql = "SELECT * FROM CLIENTE";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();
        while (rs.next()) {
            ClienteModel objusu = new ClienteModel();
            objusu.setCLI_ID(rs.getInt("CLI_ID"));
            objusu.setCLI_NOME(rs.getString("CLI_NOME"));
            objusu.setCLI_CPF(rs.getString("CLI_CPF"));
            objusu.setCLI_EMAIL(rs.getString("CLI_EMAIL"));
            objusu.setCLI_DDD(rs.getInt("CLI_DDD"));
            objusu.setCLI_TELEFONE(rs.getInt("CLI_TELEFONE"));
            
            lista.add(objusu);
        }
        rs.close();
        stm.close();
        return lista;
}
}
