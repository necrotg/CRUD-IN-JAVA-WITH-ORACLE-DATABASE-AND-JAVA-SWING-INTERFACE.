package Principal;
import Conexao.Conexao;
import View.UserView;



public class Main {
    
    Conexao objconexao;
    UserView usuarioview;
        

    public Main() {
        objconexao = new Conexao();
        usuarioview = new UserView();
        
    }

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
        Main main = new Main();
    }

}

