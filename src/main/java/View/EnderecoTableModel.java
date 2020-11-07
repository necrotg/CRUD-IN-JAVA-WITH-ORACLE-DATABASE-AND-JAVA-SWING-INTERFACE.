package View;

import Model.EnderecoModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class EnderecoTableModel extends AbstractTableModel {

    private ArrayList<EnderecoModel> linhasEnde;

    String[] colunasEnde;
    
    public EnderecoTableModel(ArrayList<EnderecoModel> arrayendereco, String[] colunas) {
        this.colunasEnde = colunas;
        linhasEnde = arrayendereco;
    }

    //Retorna a quantidade de colunas do modelo, que no caso será fixa
    @Override
    public int getColumnCount() {
        return colunasEnde.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhasEnde.size();
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunasEnde[indiceColuna];
    }

    @Override
    public Object getValueAt(int row, int col) {
        EnderecoModel endereco = (EnderecoModel) linhasEnde.get(row);
        switch (col) {
            case 0:
                return endereco.getENDERECO_ID();
            case 1:
                return endereco.getENDERECO_LOGRADOURO();
            case 2:
                return endereco.getENDERECO_NUMERO();
            case 3:
                return endereco.getENDERECO_CEP();
            case 4:
                return endereco.getENDEROCO_CIDADE();  
            case 5:
                return endereco.getENDERECO_ESTADO();                      
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de EnderecoModel
    public void addLista(ArrayList<EnderecoModel> endereco) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhasEnde.addAll(endereco);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
} 
   


