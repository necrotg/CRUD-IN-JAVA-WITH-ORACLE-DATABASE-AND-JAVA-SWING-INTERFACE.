package Controller;

import DAO.FornecedorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.FornecedorModel;

public class FornecedorController {

    private List<FornecedorModel> listafornecedor;

    public ArrayList<FornecedorModel> consultar(String filtro) throws SQLException {
        listafornecedor = new FornecedorDAO().consultar(filtro);
        return (ArrayList<FornecedorModel>) listafornecedor;
    }

    public void excluir(FornecedorModel fornecedor) throws SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        dao.excluir(fornecedor);
    }

    public void adicionar(FornecedorModel fornecedor) throws SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        dao.adicionar(fornecedor);
    }

    public void alterar(FornecedorModel fornecedor) throws SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        dao.alterar(fornecedor);
    }

    public void gravar(String operacao, FornecedorModel fornecedor) throws SQLException {
        boolean retorno = true;
        if (operacao.equals("incluir")) {
            adicionar(fornecedor);
        } else if (operacao.equals("alterar")) {
            alterar(fornecedor);
        }
    }
} 