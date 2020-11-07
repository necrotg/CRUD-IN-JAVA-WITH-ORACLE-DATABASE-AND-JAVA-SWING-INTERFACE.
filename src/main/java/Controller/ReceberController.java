package Controller;

import DAO.ReceberDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.ReceberModel;

public class ReceberController {

    private List<ReceberModel> listareceber;

    public ArrayList<ReceberModel> consultar(String filtro) throws SQLException {
        listareceber = new ReceberDAO().consultar(filtro);
        return (ArrayList<ReceberModel>) listareceber;
    }

    public void excluir(ReceberModel receber) throws SQLException {
        ReceberDAO dao = new ReceberDAO();
        dao.excluir(receber);
    }

    public void adicionar(ReceberModel receber) throws SQLException {
        ReceberDAO dao = new ReceberDAO();
        dao.adicionar(receber);
    }

    public void alterar(ReceberModel receber) throws SQLException {
        ReceberDAO dao = new ReceberDAO();
        dao.alterar(receber);
    }

    public void gravar(String operacao, ReceberModel receber) throws SQLException {
        boolean retorno = true;
        if (operacao.equals("incluir")) {
            adicionar(receber);
        } else if (operacao.equals("alterar")) {
            alterar(receber);
        }
    }
}