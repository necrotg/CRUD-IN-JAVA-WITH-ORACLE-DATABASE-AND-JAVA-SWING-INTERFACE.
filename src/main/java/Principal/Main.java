package Principal;

import View.LoginView;

public class Main {

    public Main() {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}

