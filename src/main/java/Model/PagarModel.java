package Model;

public class PagarModel extends FinanceiroModel {
    private String BOLETO;
    private FornecedorModel fornecedor;
    
    public PagarModel(){
        
    }
    public PagarModel(int FINAN_ID, int FINAN_NUM, String FINAN_EMISSAO, String FINAN_VENC, String FINAN_PAG,double FINAN_VAL, double FINAN_JUROS, double FINAN_MULTA, double FINAN_DESCONTO, double FINAN_TOTAL, String BOLETO, FornecedorModel fornecedor){
       super(FINAN_ID, FINAN_NUM,FINAN_EMISSAO,FINAN_VENC,FINAN_PAG,FINAN_VAL, FINAN_JUROS, FINAN_MULTA,FINAN_DESCONTO,FINAN_TOTAL);
       this.BOLETO = BOLETO;
       this.fornecedor = fornecedor;
    }

    public FornecedorModel getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorModel fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getBOLETO() {
        return BOLETO;
    }

    public void setBOLETO(String BOLETO) {
        this.BOLETO = BOLETO;
    }
    
}
