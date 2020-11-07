package View;

import Model.ReceberModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ReceberTableModel extends AbstractTableModel {

    private ArrayList<ReceberModel> linhasRec;

    String[] colunasRec;
    
    public ReceberTableModel(ArrayList<ReceberModel> arrayreceber, String[] colunas) {
        this.colunasRec = colunas;
        linhasRec = arrayreceber;
    }

    //Retorna a quantidade de colunas do modelo, que no caso será fixa
    @Override
    public int getColumnCount() {
        return colunasRec.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhasRec.size();
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunasRec[indiceColuna];
    }

    @Override
    public Object getValueAt(int row, int col) {
        ReceberModel receber = (ReceberModel) linhasRec.get(row);
        switch (col) {
            case 0:
                return receber.getFINAN_ID();
            case 1:
                return receber.getFINAN_NUM();
            case 2:
                return receber.getFINAN_EMISSAO();
            case 3:
                return receber.getFINAN_VENC();
            case 4:
                return receber.getFINAN_PAG();  
            case 5:
                return receber.getFINAN_VAL();
            case 6:
                return receber.getFINAN_JUROS();   
            case 7:
                return receber.getFINAN_MULTA();
            case 8:
                return receber.getFINAN_DESCONTO();   
            case 9:
                return receber.getFINAN_TOTAL();
            case 10:
                return receber.getNOTA_FISCAL();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de ReceberModel
    public void addLista(ArrayList<ReceberModel> receber) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhasRec.addAll(receber);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
} 
   
