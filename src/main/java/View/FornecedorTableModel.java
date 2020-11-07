package View;

import Model.FornecedorModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class FornecedorTableModel extends AbstractTableModel {

    private ArrayList<FornecedorModel> linhasFor;
    String[] colunasFor;

    public FornecedorTableModel(ArrayList<FornecedorModel> arrayfornecedor, String[] colunas) {
        this.colunasFor = colunas;
        linhasFor = arrayfornecedor;
    }

    //Retorna a quantidade de colunas do modelo, que no caso será fixa
    @Override
    public int getColumnCount() {
        return colunasFor.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhasFor.size();
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunasFor[indiceColuna];
    }

    @Override
    public Object getValueAt(int row, int col) {
        FornecedorModel fornecedor = (FornecedorModel) linhasFor.get(row);
        switch (col) {
            case 0:
                return fornecedor.getFOR_ID();
            case 1:
                return fornecedor.getFOR_NOME();
            case 2:
                return fornecedor.getFOR_RAZAO(); 
            case 3:
                return fornecedor.getFOR_CNPJ();
            case 4:
                return fornecedor.getFOR_EMAIL(); 
            case 5:
                return fornecedor.getFOR_DDD();  
            case 6:
                return fornecedor.getFOR_NUMERO();    
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de ClienteModel
    public void addLista(ArrayList<FornecedorModel> fornecedor) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhasFor.addAll(fornecedor);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
} 
   
