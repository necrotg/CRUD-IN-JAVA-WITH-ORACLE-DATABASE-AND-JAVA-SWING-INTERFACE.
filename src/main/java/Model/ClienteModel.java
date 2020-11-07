package Model;

public class ClienteModel extends ReceberModel {
    private int CLI_ID;
    private String CLI_NOME;
    private String CLI_CPF;
    private String CLI_EMAIL;
    private int CLI_DDD;
    private int CLI_TELEFONE;
    private EnderecoModel endereco;
    
    public ClienteModel(){
        
    }
    public ClienteModel(int CLI_ID, String CLI_NOME, String CLI_CPF, String CLI_EMAIL, int CLI_DDD, int CLI_TELEFONE ){
        this.CLI_ID = CLI_ID;
        this.CLI_NOME = CLI_NOME;
        this.CLI_CPF = CLI_CPF;
        this.CLI_EMAIL = CLI_EMAIL;
        this.CLI_DDD = CLI_DDD;
        this.CLI_TELEFONE = CLI_TELEFONE;
    }

    public int getCLI_ID() {
        return CLI_ID;
    }

    public void setCLI_ID(int CLI_ID) {
        this.CLI_ID = CLI_ID;
    }

    public String getCLI_NOME() {
        return CLI_NOME;
    }

    public void setCLI_NOME(String CLI_NOME) {
        this.CLI_NOME = CLI_NOME;
    }

    public String getCLI_CPF() {
        return CLI_CPF;
    }

    public void setCLI_CPF(String CLI_CPF) {
        this.CLI_CPF = CLI_CPF;
    }

    public String getCLI_EMAIL() {
        return CLI_EMAIL;
    }

    public void setCLI_EMAIL(String CLI_EMAIL) {
        this.CLI_EMAIL = CLI_EMAIL;
    }

    public int getCLI_DDD() {
        return CLI_DDD;
    }

    public void setCLI_DDD(int CLI_DDD) {
        this.CLI_DDD = CLI_DDD;
    }

    public int getCLI_TELEFONE() {
        return CLI_TELEFONE;
    }

    public void setCLI_TELEFONE(int CLI_TELEFONE) {
        this.CLI_TELEFONE = CLI_TELEFONE;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }
}
