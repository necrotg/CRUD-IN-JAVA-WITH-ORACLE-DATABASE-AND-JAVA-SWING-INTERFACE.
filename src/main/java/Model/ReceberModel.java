package Model;

public class ReceberModel extends FinanceiroModel {
    private String NOTA_FISCAL;
    private ClienteModel cliente;
    
    public ReceberModel(){
        
    }
    
    public ReceberModel(int FINAN_ID, int FINAN_NUM, String FINAN_EMISSAO, String FINAN_VENC, String FINAN_PAG,double FINAN_VAL, double FINAN_JUROS, double FINAN_MULTA, double FINAN_DESCONTO, double FINAN_TOTAL, String NOTA_FISCAL, ClienteModel cliente){
        super(FINAN_ID, FINAN_NUM,FINAN_EMISSAO,FINAN_VENC,FINAN_PAG,FINAN_VAL, FINAN_JUROS, FINAN_MULTA,FINAN_DESCONTO,FINAN_TOTAL);
        this.NOTA_FISCAL = NOTA_FISCAL;
        this.cliente = cliente;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public String getNOTA_FISCAL() {
        return NOTA_FISCAL;
    }

    public void setNOTA_FISCAL(String NOTA_FISCAL) {
        this.NOTA_FISCAL = NOTA_FISCAL;
    }
    
}
