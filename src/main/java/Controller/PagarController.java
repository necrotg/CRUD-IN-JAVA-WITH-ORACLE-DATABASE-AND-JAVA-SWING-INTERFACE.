package Controller;

import DAO.PagarDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.PagarModel;

public class PagarController {

    private List<PagarModel> listapagar;

    public ArrayList<PagarModel> consultar(String filtro) throws SQLException {
        listapagar = new PagarDAO().consultar(filtro);
        return (ArrayList<PagarModel>) listapagar;
    }

    public void excluir(PagarModel pagar) throws SQLException {
        PagarDAO dao = new PagarDAO();
        dao.excluir(pagar);
    }

    public void adicionar(PagarModel pagar) throws SQLException {
        PagarDAO dao = new PagarDAO();
        dao.adicionar(pagar);
    }

    public void alterar(PagarModel pagar) throws SQLException {
        PagarDAO dao = new PagarDAO();
        dao.alterar(pagar);
    }

    public void gravar(String operacao, PagarModel pagar) throws SQLException {
        boolean retorno = true;
        if (operacao.equals("incluir")) {
            adicionar(pagar);
        } else if (operacao.equals("alterar")) {
            alterar(pagar);
        }
    }
} 