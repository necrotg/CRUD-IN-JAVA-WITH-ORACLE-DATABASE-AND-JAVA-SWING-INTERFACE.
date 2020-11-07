package View;

import Model.PagarModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class PagarTableModel extends AbstractTableModel {

    private ArrayList<PagarModel> linhasPag;

    String[] colunasPag;
    
    public PagarTableModel(ArrayList<PagarModel> arraypagar, String[] colunas) {
        this.colunasPag = colunas;
        linhasPag = arraypagar;
    }

    //Retorna a quantidade de colunas do modelo, que no caso será fixa
    @Override
    public int getColumnCount() {
        return colunasPag.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhasPag.size();
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunasPag[indiceColuna];
    }

    @Override
    public Object getValueAt(int row, int col) {
        PagarModel pagar = (PagarModel) linhasPag.get(row);
        switch (col) {
            case 0:
                return pagar.getFINAN_ID();
            case 1:
                return pagar.getFINAN_NUM();
            case 2:
                return pagar.getFINAN_EMISSAO();
            case 3:
                return pagar.getFINAN_VENC();
            case 4:
                return pagar.getFINAN_PAG();  
            case 5:
                return pagar.getFINAN_VAL();
            case 6:
                return pagar.getFINAN_JUROS();   
            case 7:
                return pagar.getFINAN_MULTA();
            case 8:
                return pagar.getFINAN_DESCONTO();   
            case 9:
                return pagar.getFINAN_TOTAL();
            case 10:
                return pagar.getBOLETO();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de PagarModel
    public void addLista(ArrayList<PagarModel> pagar) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhasPag.addAll(pagar);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
} 
   
