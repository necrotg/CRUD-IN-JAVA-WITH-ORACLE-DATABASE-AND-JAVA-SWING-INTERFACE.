package Model;

public class FornecedorModel extends PagarModel {
    private int FOR_ID;
    private String FOR_NOME;
    private String FOR_RAZAO;
    private String FOR_CNPJ;
    private String FOR_EMAIL;
    private int FOR_DDD;
    private int FOR_NUMERO;
    private EnderecoModel endereco;
    
    public FornecedorModel(){
        
    }
    public FornecedorModel(int FOR_ID,String FOR_NOME,String FOR_RAZAO,String FOR_CNPJ,String FOR_EMAIL,int FOR_DDD,int FOR_NUMERO){
        this.FOR_ID = FOR_ID;
        this.FOR_NOME = FOR_NOME;
        this.FOR_RAZAO = FOR_RAZAO;
        this.FOR_CNPJ = FOR_CNPJ;
        this.FOR_EMAIL = FOR_EMAIL;
        this.FOR_DDD = FOR_DDD;
        this.FOR_NUMERO = FOR_NUMERO;
    }

    public int getFOR_ID() {
        return FOR_ID;
    }

    public void setFOR_ID(int FOR_ID) {
        this.FOR_ID = FOR_ID;
    }

    public String getFOR_NOME() {
        return FOR_NOME;
    }

    public void setFOR_NOME(String FOR_NOME) {
        this.FOR_NOME = FOR_NOME;
    }

    public String getFOR_RAZAO() {
        return FOR_RAZAO;
    }

    public void setFOR_RAZAO(String FOR_RAZAO) {
        this.FOR_RAZAO = FOR_RAZAO;
    }

    public String getFOR_CNPJ() {
        return FOR_CNPJ;
    }

    public void setFOR_CNPJ(String FOR_CNPJ) {
        this.FOR_CNPJ = FOR_CNPJ;
    }

    public String getFOR_EMAIL() {
        return FOR_EMAIL;
    }

    public void setFOR_EMAIL(String FOR_EMAIL) {
        this.FOR_EMAIL = FOR_EMAIL;
    }

    public int getFOR_DDD() {
        return FOR_DDD;
    }

    public void setFOR_DDD(int FOR_DDD) {
        this.FOR_DDD = FOR_DDD;
    }

    public int getFOR_NUMERO() {
        return FOR_NUMERO;
    }

    public void setFOR_NUMERO(int FOR_NUMERO) {
        this.FOR_NUMERO = FOR_NUMERO;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }
}
