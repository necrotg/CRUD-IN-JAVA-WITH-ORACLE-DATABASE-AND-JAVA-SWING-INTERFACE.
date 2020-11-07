package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.PagarModel;

public class PagarDAO {
    private Connection conexao = null;
    
    public PagarDAO() throws SQLException{
        this.conexao = Conexao.getConexao();
    }
    public void adicionar(PagarModel pagar) throws SQLException {
        String sql ="INSERT INTO PAGAR (FINAN_ID, BOLETO, FOR_ID)"
                + "VALUES (?,?,?)";
        String sql2 = "INSERT INTO FINANCEIRO(FINAN_ID, FINAN_NUM, FINAN_EMISSAO, FINAN_VENC, FINAN_PAG, FINAN_VAL, FINAN_JUROS, FINAN_MULTA, FINAN_DESCONTO, FINAN_TOTAL) VALUES "
                + "(?, ?,  ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, pagar.getFINAN_ID());
            stm.setString(2, pagar.getBOLETO());
            stm.setInt(3, pagar.getFornecedor().getFOR_ID());
            PreparedStatement stm2 = conexao.prepareStatement(sql2);
            stm2.setInt(1, pagar.getFINAN_ID());
            stm2.setInt(2, pagar.getFINAN_NUM());
            stm2.setString(3, pagar.getFINAN_EMISSAO());
            stm2.setString(4, pagar.getFINAN_VENC());
            stm2.setString(5, pagar.getFINAN_PAG());
            stm2.setDouble(6, pagar.getFINAN_VAL());
            stm2.setDouble(7, pagar.getFINAN_JUROS());
            stm2.setDouble(8, pagar.getFINAN_MULTA());
            stm2.setDouble(9, pagar.getFINAN_DESCONTO());
            stm2.setDouble(10, pagar.getFINAN_TOTAL());
            stm.execute();
            stm2.execute();
        
    }
    public void alterar(PagarModel pagar) throws SQLException {
        String sql = "UPDATE FINANCEIRO SET FINAN_NUM = ?, FINAN_EMISSAO = ?,"
                + "FINAN_VENC = ?, FINAN_PAG = ?, FINAN_VAL = ?, FINAN_JUROS = ?, FINAN_MULTA = ?, FINAN_DESCONTO = ?, FINAN_TOTAL = ? WHERE FINAN_ID = ?";
 //       String sql2 = "UPDATE PAGAR SET BOLETO = ? WHERE FINAN_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, pagar.getFINAN_NUM());
            stm.setString(2, pagar.getFINAN_EMISSAO());
            stm.setString(3, pagar.getFINAN_VENC());
            stm.setString(4, pagar.getFINAN_PAG());
            stm.setDouble(5, pagar.getFINAN_VAL());
            stm.setDouble(6, pagar.getFINAN_JUROS());
            stm.setDouble(7, pagar.getFINAN_MULTA());
            stm.setDouble(8, pagar.getFINAN_DESCONTO());
            stm.setDouble(9, pagar.getFINAN_TOTAL());
            stm.setInt(10, pagar.getFINAN_ID());
  //      PreparedStatement stm2 = conexao.prepareStatement(sql2);
//            stm2.setString(1, pagar.getBOLETO());
 //           stm2.setInt(2, pagar.getFINAN_ID());
        stm.execute();
        stm.close();
 //       stm2.execute();
 //       stm2.close();
    }
    public void excluir(PagarModel pagar) throws SQLException {
        String sql = "DELETE FROM PAGAR WHERE FINAN_ID = ?";
        String sql2 = "DELETE FROM FINANCEIRO WHERE FINAN_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, pagar.getFINAN_ID());
        PreparedStatement stm2 = conexao.prepareStatement(sql2);
        stm2.setInt(1, pagar.getFINAN_ID());
        stm.execute();
        stm.close();
    }
    public ArrayList<PagarModel> consultar(String condicao) throws SQLException {
        ArrayList<PagarModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT * FROM FINANCEIRO INNER JOIN PAGAR ON FINANCEIRO.FINAN_ID = PAGAR.FINAN_ID";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();
        while (rs.next()) {
            PagarModel objusu = new PagarModel();
            objusu.setFINAN_ID(rs.getInt("FINAN_ID"));
            objusu.setFINAN_NUM(rs.getInt("FINAN_NUM"));
            objusu.setFINAN_EMISSAO(rs.getString("FINAN_EMISSAO"));
            objusu.setFINAN_VENC(rs.getString("FINAN_VENC"));
            objusu.setFINAN_PAG(rs.getString("FINAN_PAG"));
            objusu.setFINAN_VAL(rs.getDouble("FINAN_VAL"));
            objusu.setFINAN_JUROS(rs.getDouble("FINAN_JUROS"));
            objusu.setFINAN_MULTA(rs.getDouble("FINAN_MULTA"));
            objusu.setFINAN_DESCONTO(rs.getDouble("FINAN_DESCONTO"));
            objusu.setFINAN_TOTAL(rs.getDouble("FINAN_TOTAL"));
            objusu.setBOLETO(rs.getString("BOLETO"));
            lista.add(objusu);
        }
        rs.close();
        stm.close();
        return lista;
}
}

