package Controller;

import DAO.ClienteDAO;
import DAO.EnderecoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.EnderecoModel;

public class EnderecoController {

    private List<EnderecoModel> listaendereco;

    public ArrayList<EnderecoModel> consultar(String filtro) throws SQLException {
        listaendereco = new EnderecoDAO().consultar(filtro);
        return (ArrayList<EnderecoModel>) listaendereco;
    }

    
    }