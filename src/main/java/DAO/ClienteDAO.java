package DAO;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.ClienteModel;
import Model.EnderecoModel;

public class ClienteDAO {
    private Connection conexao = null;
    
    public ClienteDAO() throws SQLException{
        this.conexao = Conexao.getConexao();
    }
    public void adicionar(ClienteModel cliente) throws SQLException {
            String sql = "INSERT INTO CLIENTE (CLI_ID, CLI_NOME, CLI_CPF, CLI_EMAIL, CLI_DDD, CLI_TELEFONE)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
            String sql2 = "INSERT INTO ENDERECO_CLIENTE (CLI_ID,ENDERECO_ID)"
            + "VALUES (?, ?)";
            String sql3 = "INSERT INTO ENDERECO (ENDERECO_ID, ENDERECO_LOGRADOURO, ENDERECO_NUMERO , ENDERECO_CEP, ENDEROCO_CIDADE, ENDERECO_ESTADO)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, cliente.getCLI_ID());
            stm.setString(2, cliente.getCLI_NOME());
            stm.setString(3, cliente.getCLI_CPF());
            stm.setString(4, cliente.getCLI_EMAIL());
            stm.setInt(5, cliente.getCLI_DDD());
            stm.setInt(6, cliente.getCLI_TELEFONE());
            PreparedStatement stm2 = conexao.prepareStatement(sql2);
            stm2.setInt(2, cliente.getEndereco().getENDERECO_ID());
            stm2.setInt(1, cliente.getCLI_ID());
            PreparedStatement stm3 = conexao.prepareStatement(sql3);
            stm3.setInt(1, cliente.getEndereco().getENDERECO_ID());
            stm3.setString(2, cliente.getEndereco().getENDERECO_LOGRADOURO());
            stm3.setDouble(3, cliente.getEndereco().getENDERECO_NUMERO());
            stm3.setString(4, cliente.getEndereco().getENDERECO_CEP());
            stm3.setString(5, cliente.getEndereco().getENDEROCO_CIDADE());
            stm3.setString(6, cliente.getEndereco().getENDERECO_ESTADO());
            stm.execute();
            stm3.execute();
            stm2.execute();
        
    }
    public void alterar(ClienteModel cliente) throws SQLException {
        String sql = "UPDATE CLIENTE SET CLI_NOME = ?, CLI_CPF = ?, "
                + "CLI_EMAIL = ?, CLI_DDD = ?, CLI_TELEFONE =? WHERE CLI_ID = ?";
        String sql2 = "UPDATE ENDERECO SET ENDERECO_LOGRADOURO = ? , ENDERECO_NUMERO = ?, ENDERECO_CEP = ?, ENDEROCO_CIDADE = ?, ENDERECO_ESTADO = ? WHERE ENDERECO_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, cliente.getCLI_NOME());
        stm.setString(2, cliente.getCLI_CPF());
        stm.setString(3, cliente.getCLI_EMAIL());
        stm.setInt(4, cliente.getCLI_DDD());
        stm.setInt(5, cliente.getCLI_TELEFONE());
        stm.setInt(6, cliente.getCLI_ID());
        PreparedStatement stm2 = conexao.prepareStatement(sql2); 
            stm2.setString(1, cliente.getEndereco().getENDERECO_LOGRADOURO());
            stm2.setDouble(2, cliente.getEndereco().getENDERECO_NUMERO());
            stm2.setString(3, cliente.getEndereco().getENDERECO_CEP());
            stm2.setString(4, cliente.getEndereco().getENDEROCO_CIDADE());
            stm2.setString(5, cliente.getEndereco().getENDERECO_ESTADO());
            stm2.setInt(6, cliente.getEndereco().getENDERECO_ID());
        
        stm.execute();
        stm.close();
        stm2.execute();
        stm2.close();
    }
    public void excluir(ClienteModel cliente) throws SQLException {
        String sql = "DELETE FROM ENDERECO_CLIENTE WHERE CLI_ID = ?";
        String sql2 = "DELETE FROM CLIENTE WHERE CLI_ID = ?";
        String sql3 = "DELETE FROM ENDERECO WHERE ENDERECO_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        PreparedStatement stm2 = conexao.prepareStatement(sql2);
        PreparedStatement stm3 = conexao.prepareStatement(sql3);
        stm.setInt(1, cliente.getCLI_ID());
        stm2.setInt(1, cliente.getCLI_ID());
        stm3.setInt(1, cliente.getEndereco().getENDERECO_ID());
        stm.execute();
        stm.close();
        stm2.execute();
        stm2.close();
        stm3.execute();
        stm3.close();
    }
    public ArrayList<ClienteModel> consultar(String condicao) throws SQLException {
        ArrayList<ClienteModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT ENDERECO.ENDERECO_ID, ENDERECO.ENDERECO_LOGRADOURO, ENDERECO.ENDERECO_NUMERO , ENDERECO.ENDERECO_CEP, ENDERECO.ENDEROCO_CIDADE, ENDERECO.ENDERECO_ESTADO, CLIENTE.CLI_ID,CLIENTE.CLI_NOME,CLIENTE.CLI_CPF,CLIENTE.CLI_EMAIL,CLIENTE.CLI_DDD,CLIENTE.CLI_TELEFONE FROM ENDERECO, CLIENTE, ENDERECO_CLIENTE WHERE CLIENTE.CLI_ID = ENDERECO_CLIENTE.CLI_ID AND ENDERECO_CLIENTE.ENDERECO_ID = ENDERECO.ENDERECO_ID";
        if (!condicao.equals("")) {
            sql += " AND " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();
        while (rs.next()) {
            ClienteModel cliente = new ClienteModel();
            EnderecoModel endereco = new EnderecoModel();
            cliente.setCLI_ID(rs.getInt("CLI_ID"));
            cliente.setCLI_NOME(rs.getString("CLI_NOME"));
            cliente.setCLI_CPF(rs.getString("CLI_CPF"));
            cliente.setCLI_EMAIL(rs.getString("CLI_EMAIL"));
            cliente.setCLI_DDD(rs.getInt("CLI_DDD"));
            cliente.setCLI_TELEFONE(rs.getInt("CLI_TELEFONE"));
            endereco.setENDERECO_ID(rs.getInt("ENDERECO_ID"));
            endereco.setENDERECO_LOGRADOURO(rs.getString("ENDERECO_LOGRADOURO"));
            endereco.setENDERECO_NUMERO(rs.getInt("ENDERECO_NUMERO"));
            endereco.setENDERECO_CEP(rs.getString("ENDERECO_CEP"));
            endereco.setENDEROCO_CIDADE(rs.getString("ENDEROCO_CIDADE"));
            endereco.setENDERECO_ESTADO(rs.getString("ENDERECO_ESTADO"));
            cliente.setEndereco(endereco);

            lista.add(cliente);
        }
        rs.close();
        stm.close();
        return lista;
}
}
