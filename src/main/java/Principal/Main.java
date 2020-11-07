package Principal;
import Conexao.Conexao;
import View.LoginView;
import View.UserView;



public class Main {
    
    LoginView loginview;

    public Main() {
        loginview = new LoginView();
        
    }

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
        Main main = new Main();
    }

}

