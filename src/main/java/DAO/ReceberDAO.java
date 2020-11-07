package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.ReceberModel;

public class ReceberDAO {
    private Connection conexao = null;
    
    public ReceberDAO() throws SQLException{
        this.conexao = Conexao.getConexao();
    }
    public void adicionar(ReceberModel receber) throws SQLException {
        String sql = "INSERT INTO FINANCEIRO (FINAN_ID, FINAN_NUM, FINAN_EMISSAO,FINAN_VENC, FINAN_PAG, FINAN_VAL, FINAN_JUROS, FINAN_MULTA, FINAN_DESCONTO, FINAN_TOTAL)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
                
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, receber.getFINAN_ID());
            stm.setInt(2, receber.getFINAN_NUM());
            stm.setString(3, receber.getFINAN_EMISSAO());
            stm.setString(4, receber.getFINAN_VENC());
            stm.setString(5, receber.getFINAN_PAG());
            stm.setDouble(6, receber.getFINAN_VAL());
            stm.setDouble(7, receber.getFINAN_JUROS());
            stm.setDouble(8, receber.getFINAN_MULTA());
            stm.setDouble(9, receber.getFINAN_DESCONTO());
            stm.setDouble(10, receber.getFINAN_TOTAL());
                       
            stm.execute();
        
    }
    public void alterar(ReceberModel receber) throws SQLException {
        String sql = "UPDATE FINANCEIRO SET FINAN_NUM = ?, FINAN_EMISSAO = ?, "
                + "FINAN_VENC = ?, FINAN_PAG = ?, FINAN_VAL = ?, FINAN_JUROS = ?, FINAN_MULTA = ?, FINAN_DESCONTO = ?, FINAN_TOTAL = ? WHERE FINAN_ID = ?";
                
        PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, receber.getFINAN_NUM());
            stm.setString(2, receber.getFINAN_EMISSAO());
            stm.setString(3, receber.getFINAN_VENC());
            stm.setString(4, receber.getFINAN_PAG());
            stm.setDouble(5, receber.getFINAN_VAL());
            stm.setDouble(6, receber.getFINAN_JUROS());
            stm.setDouble(7, receber.getFINAN_MULTA());
            stm.setDouble(8, receber.getFINAN_DESCONTO());
            stm.setDouble(9, receber.getFINAN_TOTAL());
            stm.setInt(10, receber.getFINAN_ID());
            
        stm.execute();
        stm.close();
    }
    public void excluir(ReceberModel receber) throws SQLException {
        String sql = "DELETE FROM RECEBER WHERE FINAN_ID = ?";
        String sql2 = "DELETE FROM FINANCEIRO WHERE FINAN_ID = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, receber.getFINAN_ID());
        PreparedStatement stm2 = conexao.prepareStatement(sql2);
        stm2.setInt(2, receber.getFINAN_ID());
        stm.execute();
        stm.close();
        stm2.execute();
        stm2.close();
    }
    public ArrayList<ReceberModel> consultar(String condicao) throws SQLException {
        ArrayList<ReceberModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT * FROM FINANCEIRO INNER JOIN RECEBER ON FINANCEIRO.FINAN_ID = RECEBER.FINAN_ID";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();
        while (rs.next()) {
            ReceberModel objusu = new ReceberModel();
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
            objusu.setNOTA_FISCAL(rs.getString("NOTA_FISCAL"));
            lista.add(objusu);
        }
        rs.close();
        stm.close();
        return lista;
}
}

