/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ClienteController;
import Controller.FornecedorController;
import Controller.PagarController;
import Controller.ReceberController;
import Model.ClienteModel;
import Model.EnderecoModel;
import Model.FornecedorModel;
import Model.PagarModel;
import Model.ReceberModel;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author fgmil
 */
public class UserView extends javax.swing.JFrame {

    private String operacao;
    
    private String colunasCli[] = {"ID", "Nome", "CPF", "EMAIL","DDD","Telefone","Logradouro","Numero", "CIDADE", "CEP","Estado"};
    private String colunasFor[] = {"ID", "Nome","Razão", "CNPJ", "EMAIL","DDD","Telefone","Logradouro","Numero", "CIDADE", "CEP","Estado"};
    private String colunasEnde[] = {"ID","Logradouro","Numero", "CEP", "Cidade","Estado"};
    private String colunasPag[] = {"ID","NUMERO", "DATA DE EMISSÃO", "VENCIMENTO","PAGAMENTO","VALOR","JUROS","MULTA","DESCONTO","TOTAL","BOLETO","Fornecedor"};
    private String colunasRec[] = {"ID","NUMERO", "DATA DE EMISSÃO", "VENCIMENTO","PAGAMENTO","VALOR","JUROS","MULTA","DESCONTO","TOTAL","NOTA FISCAL","Cliente ID","Cliente Nome"};
    private String cbEstado[] = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
    
    private ArrayList<ClienteModel> listaCli;
    private ClienteTableModel tabelaCli;
       
    private ArrayList<FornecedorModel> listaFor;
    private FornecedorTableModel tabelaFor;
    
    private ArrayList<PagarModel> listaPag;
    private PagarTableModel tabelaPag;
    
    private ArrayList<ReceberModel> listaRec;
    private ReceberTableModel tabelaRec;
    final DefaultComboBoxModel model = new DefaultComboBoxModel(cbEstado);

    private String getOperacao() {
        return operacao;
    }

    private void setOperacao(String operacao) {
        Boolean ativar = (operacao.equals("") ? false : true);
        // operacao=""(consulta), operacao="incluir"(inclusão), operacao="alterar"(alteração)
        this.operacao = operacao;
        btnGRAVAR1.setEnabled(ativar);
        btnGRAVAR.setEnabled(ativar);
        btnGRAVAR2.setEnabled(ativar);
        btnGRAVAR3.setEnabled(ativar);     
    }

    public UserView() {
        this.setPreferredSize(new Dimension(1100, 820));
        initComponents();
        jInternalFrame1.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        cbESTADO.setModel(model);
        cbESTADO1.setModel(model);
        setOperacao(""); 
        setLocationRelativeTo(null);
        consultarFornecedor();
        consultarCliente();
        consultarPagar();
        consultarReceber();
        
        
        // adiciona evento para qdo navegar no JTable, atualizar os dados nos JTextField´s
        tblCliente.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                int selecionado = tblCliente.getSelectedRow();
                if (selecionado >= 0) {
                    mostrarCliente(listaCli.get(selecionado));
                }
            }
        });
        tblFornecedor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                int selecionado = tblFornecedor.getSelectedRow();
                if (selecionado >= 0) {
                    mostrarFornecedor(listaFor.get(selecionado));
                }
            }
        });
        tblPagar.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                int selecionado = tblPagar.getSelectedRow();
                if (selecionado >= 0) {
                    mostrarPagar(listaPag.get(selecionado));
                }
            }
        });
        tblReceber.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                int selecionado = tblReceber.getSelectedRow();
                if (selecionado >= 0) {
                    mostrarReceber(listaRec.get(selecionado));
                }
            }
        });
        setVisible(true);
        pack();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame2 = new javax.swing.JInternalFrame();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblNOME = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblDDD = new javax.swing.JLabel();
        lblNUMERO = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        tfNOME = new javax.swing.JTextField();
        tfCPF = new javax.swing.JTextField();
        tfDDD = new javax.swing.JTextField();
        tfNUMERO = new javax.swing.JTextField();
        lblEMAIL = new javax.swing.JLabel();
        tfEMAIL = new javax.swing.JTextField();
        btnALTERAR = new javax.swing.JButton();
        btnEXCLUIR = new javax.swing.JButton();
        btnCRIAR = new javax.swing.JButton();
        btnGRAVAR = new javax.swing.JButton();
        lblLOGRA = new javax.swing.JLabel();
        tfLOGRA = new javax.swing.JTextField();
        lblCIDADE = new javax.swing.JLabel();
        tfCIDADE = new javax.swing.JTextField();
        lblESTADO = new javax.swing.JLabel();
        cbESTADO = new javax.swing.JComboBox<>();
        lblCEP = new javax.swing.JLabel();
        tfCEP = new javax.swing.JTextField();
        lblNUM = new javax.swing.JLabel();
        tfNUM = new javax.swing.JTextField();
        lblENDE = new javax.swing.JLabel();
        tfENDE = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblID2 = new javax.swing.JLabel();
        lbla = new javax.swing.JLabel();
        tfID3 = new javax.swing.JTextField();
        tfID2 = new javax.swing.JTextField();
        lblNOME2 = new javax.swing.JLabel();
        tfNOME2 = new javax.swing.JTextField();
        lblCPF2 = new javax.swing.JLabel();
        tfCPF2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        lblEMAIL2 = new javax.swing.JLabel();
        tfEMAIL2 = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnLIMPAR = new javax.swing.JButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        lblID1 = new javax.swing.JLabel();
        lblNOME1 = new javax.swing.JLabel();
        lblCPF1 = new javax.swing.JLabel();
        lblDDD1 = new javax.swing.JLabel();
        lblNUMERO1 = new javax.swing.JLabel();
        tfID1 = new javax.swing.JTextField();
        tfNOME1 = new javax.swing.JTextField();
        tfCPF1 = new javax.swing.JTextField();
        tfDDD1 = new javax.swing.JTextField();
        tfNUMERO1 = new javax.swing.JTextField();
        lblEMAIL1 = new javax.swing.JLabel();
        tfEMAIL1 = new javax.swing.JTextField();
        btnALTERAR1 = new javax.swing.JButton();
        btnEXCLUIR1 = new javax.swing.JButton();
        btnCRIAR1 = new javax.swing.JButton();
        btnGRAVAR1 = new javax.swing.JButton();
        lblRAZAO = new javax.swing.JLabel();
        tfRAZAO = new javax.swing.JTextField();
        tfNUM1 = new javax.swing.JTextField();
        lblNUM1 = new javax.swing.JLabel();
        tfESTADO1 = new javax.swing.JLabel();
        tfCIDADE1 = new javax.swing.JTextField();
        lblCEP1 = new javax.swing.JLabel();
        tfCEP1 = new javax.swing.JTextField();
        lblENDE1 = new javax.swing.JLabel();
        tfENDE1 = new javax.swing.JTextField();
        tfLOGRA1 = new javax.swing.JTextField();
        cbESTADO1 = new javax.swing.JComboBox<>();
        lblLOGRA1 = new javax.swing.JLabel();
        lblCIDADE1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblID3 = new javax.swing.JLabel();
        lbla1 = new javax.swing.JLabel();
        tfID4 = new javax.swing.JTextField();
        tfID5 = new javax.swing.JTextField();
        lblNOME3 = new javax.swing.JLabel();
        tfNOME3 = new javax.swing.JTextField();
        lblCPF3 = new javax.swing.JLabel();
        tfCPF3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFornecedor = new javax.swing.JTable();
        lblEMAIL3 = new javax.swing.JLabel();
        tfEMAIL3 = new javax.swing.JTextField();
        btnConsultar1 = new javax.swing.JButton();
        btnLIMPAR1 = new javax.swing.JButton();
        lblRAZAO2 = new javax.swing.JLabel();
        tfRAZAO2 = new javax.swing.JTextField();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jPanel6 = new javax.swing.JPanel();
        lblID4 = new javax.swing.JLabel();
        lblNUMEROboleto = new javax.swing.JLabel();
        lblEMISSAOboleto = new javax.swing.JLabel();
        lblPAGBOLETO = new javax.swing.JLabel();
        lblVALBOLETO = new javax.swing.JLabel();
        tfIDBOLETO = new javax.swing.JTextField();
        tfNUMEROBOLETO = new javax.swing.JTextField();
        tfEMISSAOBOLETO = new javax.swing.JTextField();
        tfPAGBOLETO = new javax.swing.JTextField();
        tfVALBOLETO = new javax.swing.JTextField();
        lblVENCIMENTOboleto = new javax.swing.JLabel();
        tfVENCBOLETO = new javax.swing.JTextField();
        btnALTERAR2 = new javax.swing.JButton();
        btnEXCLUIR2 = new javax.swing.JButton();
        btnCRIAR2 = new javax.swing.JButton();
        btnGRAVAR2 = new javax.swing.JButton();
        lblJUROSBOLETO = new javax.swing.JLabel();
        tfJUROSBOLETO = new javax.swing.JTextField();
        tfTOTALBOLETO = new javax.swing.JTextField();
        lblTOTAL = new javax.swing.JLabel();
        lblMULTABOLETO = new javax.swing.JLabel();
        tfMULTABOLETO = new javax.swing.JTextField();
        tfDESCONTOBOLETO = new javax.swing.JTextField();
        lblDESCONTOBOLETO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfBOLETO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfFORNECEDORBOLETO = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        lblID5 = new javax.swing.JLabel();
        lbla2 = new javax.swing.JLabel();
        tfID7 = new javax.swing.JTextField();
        tfID8 = new javax.swing.JTextField();
        lblBOLETONUMERO2 = new javax.swing.JLabel();
        tfNUMEROBOLETO2 = new javax.swing.JTextField();
        lblCPF5 = new javax.swing.JLabel();
        tfCPF5 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPagar = new javax.swing.JTable();
        btnConsultar2 = new javax.swing.JButton();
        btnLIMPAR2 = new javax.swing.JButton();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jPanel8 = new javax.swing.JPanel();
        lblID6 = new javax.swing.JLabel();
        lblNUMEROboleto1 = new javax.swing.JLabel();
        lblEMISSAOboleto1 = new javax.swing.JLabel();
        lblPAGBOLETO1 = new javax.swing.JLabel();
        lblVALBOLETO1 = new javax.swing.JLabel();
        tfIDBOLETO1 = new javax.swing.JTextField();
        tfNUMEROBOLETO1 = new javax.swing.JTextField();
        tfEMISSAOBOLETO1 = new javax.swing.JTextField();
        tfPAGBOLETO1 = new javax.swing.JTextField();
        tfVALBOLETO1 = new javax.swing.JTextField();
        lblVENCIMENTOboleto1 = new javax.swing.JLabel();
        tfVENCBOLETO1 = new javax.swing.JTextField();
        btnALTERAR3 = new javax.swing.JButton();
        btnEXCLUIR3 = new javax.swing.JButton();
        btnCRIAR3 = new javax.swing.JButton();
        btnGRAVAR3 = new javax.swing.JButton();
        lblJUROSBOLETO1 = new javax.swing.JLabel();
        tfJUROSBOLETO1 = new javax.swing.JTextField();
        tfTOTALBOLETO1 = new javax.swing.JTextField();
        lblTOTAL1 = new javax.swing.JLabel();
        lblMULTABOLETO1 = new javax.swing.JLabel();
        tfMULTABOLETO1 = new javax.swing.JTextField();
        tfDESCONTOBOLETO1 = new javax.swing.JTextField();
        lblDESCONTOBOLETO1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfBOLETO1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfFORNECEDORBOLETO1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        lblID7 = new javax.swing.JLabel();
        lbla3 = new javax.swing.JLabel();
        tfID9 = new javax.swing.JTextField();
        tfID10 = new javax.swing.JTextField();
        lblBOLETONUMERO3 = new javax.swing.JLabel();
        tfNUMEROBOLETO3 = new javax.swing.JTextField();
        lblCPF6 = new javax.swing.JLabel();
        tfCPF6 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblReceber = new javax.swing.JTable();
        btnConsultar3 = new javax.swing.JButton();
        btnLIMPAR3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setTitle("Cadastro de Cliente");
        jInternalFrame1.setVisible(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        lblID.setText("ID:");

        lblNOME.setText("NOME:");

        lblCPF.setText("CPF:");

        lblDDD.setText("DDD:");

        lblNUMERO.setText("NUMERO:");

        lblEMAIL.setText("E-MAIL:");

        btnALTERAR.setText("Alterar");
        btnALTERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERARActionPerformed(evt);
            }
        });

        btnEXCLUIR.setText("Excluir");
        btnEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIRActionPerformed(evt);
            }
        });

        btnCRIAR.setText("Criar");
        btnCRIAR.setToolTipText("");
        btnCRIAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRIARActionPerformed(evt);
            }
        });

        btnGRAVAR.setText("Gravar");
        btnGRAVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGRAVARActionPerformed(evt);
            }
        });

        lblLOGRA.setText("Logradouro:");

        lblCIDADE.setText("CIDADE:");

        lblESTADO.setText("ESTADO:");

        lblCEP.setText("CEP:");

        lblNUM.setText("NUMERO:");

        lblENDE.setText("ENDE_ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID)
                    .addComponent(lblCPF)
                    .addComponent(lblDDD)
                    .addComponent(lblENDE)
                    .addComponent(lblCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNOME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNOME, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEMAIL))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfENDE, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblLOGRA))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblESTADO)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCIDADE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCIDADE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfLOGRA, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNUM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNUM, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tfEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(tfDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblNUMERO)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfNUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnALTERAR)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCRIAR, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEXCLUIR)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnGRAVAR))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNOME)
                    .addComponent(tfNOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEMAIL)
                            .addComponent(tfEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblCPF, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(tfCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDDD)
                    .addComponent(lblNUMERO)
                    .addComponent(btnALTERAR)
                    .addComponent(btnEXCLUIR)
                    .addComponent(btnCRIAR)
                    .addComponent(btnGRAVAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLOGRA)
                    .addComponent(tfLOGRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNUM)
                    .addComponent(tfNUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfENDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblENDE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblESTADO)
                    .addComponent(cbESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCIDADE)
                    .addComponent(tfCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCEP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        lblID2.setText("ID:");

        lbla.setText("á");

        lblNOME2.setText("Nome:");

        lblCPF2.setText("CPF:");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCliente);

        lblEMAIL2.setText("E-MAIL:");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnLIMPAR.setText("Limpar");
        btnLIMPAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIMPARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID2)
                            .addComponent(lblCPF2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEMAIL2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfEMAIL2, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfID2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfID3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNOME2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNOME2))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLIMPAR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(7, 7, 7)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID2)
                    .addComponent(lbla)
                    .addComponent(tfID3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNOME2)
                    .addComponent(tfNOME2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF2)
                    .addComponent(tfCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEMAIL2)
                    .addComponent(tfEMAIL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLIMPAR)
                    .addComponent(btnConsultar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jInternalFrame3.setClosable(true);
        jInternalFrame3.setTitle("Cadastro de Fornecedor");
        jInternalFrame3.setVisible(true);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Fornecdor"));

        lblID1.setText("ID:");

        lblNOME1.setText("NOME:");

        lblCPF1.setText("CNPJ:");

        lblDDD1.setText("DDD:");

        lblNUMERO1.setText("NUMERO:");

        lblEMAIL1.setText("E-MAIL:");

        btnALTERAR1.setText("Alterar");
        btnALTERAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERAR1ActionPerformed(evt);
            }
        });

        btnEXCLUIR1.setText("Excluir");
        btnEXCLUIR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIR1ActionPerformed(evt);
            }
        });

        btnCRIAR1.setText("Criar");
        btnCRIAR1.setToolTipText("");
        btnCRIAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRIAR1ActionPerformed(evt);
            }
        });

        btnGRAVAR1.setText("Gravar");
        btnGRAVAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGRAVAR1ActionPerformed(evt);
            }
        });

        lblRAZAO.setText("Razão:");

        lblNUM1.setText("NUMERO:");

        tfESTADO1.setText("ESTADO:");

        lblCEP1.setText("CEP:");

        lblENDE1.setText("ENDE_ID");

        lblLOGRA1.setText("LOGRADOURO:");

        lblCIDADE1.setText("CIDADE:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblID1)
                                    .addComponent(lblCPF1)
                                    .addComponent(lblDDD1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(tfDDD1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblNUMERO1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfNUMERO1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tfRAZAO, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnALTERAR1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCRIAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEXCLUIR1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnGRAVAR1))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(tfCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblEMAIL1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfEMAIL1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(tfID1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblNOME1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfNOME1))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblRAZAO)
                                        .addGap(98, 98, 98))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblENDE1)
                                        .addGap(6, 6, 6)
                                        .addComponent(tfENDE1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(lblLOGRA1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfLOGRA1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNUM1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNUM1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblCEP1)
                        .addGap(25, 25, 25)
                        .addComponent(tfCEP1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfESTADO1)
                        .addGap(13, 13, 13)
                        .addComponent(cbESTADO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCIDADE1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCIDADE1)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID1)
                    .addComponent(tfID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNOME1)
                    .addComponent(tfNOME1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEMAIL1)
                            .addComponent(tfEMAIL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblCPF1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(tfCPF1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDDD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNUMERO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDDD1)
                            .addComponent(lblNUMERO1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRAZAO)
                            .addComponent(tfRAZAO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnALTERAR1)
                        .addComponent(btnCRIAR1)
                        .addComponent(btnEXCLUIR1)
                        .addComponent(btnGRAVAR1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNUM1)
                        .addComponent(tfNUM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblENDE1)
                        .addComponent(tfENDE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLOGRA1)
                        .addComponent(tfLOGRA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfESTADO1)
                        .addComponent(cbESTADO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCIDADE1)
                        .addComponent(tfCIDADE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCEP1)
                    .addComponent(tfCEP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(494, 494, 494))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        lblID3.setText("ID:");

        lbla1.setText("á");

        lblNOME3.setText("Nome:");

        lblCPF3.setText("CNPJ:");

        tblFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblFornecedor);

        lblEMAIL3.setText("E-MAIL:");

        btnConsultar1.setText("Consultar");
        btnConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar1ActionPerformed(evt);
            }
        });

        btnLIMPAR1.setText("Limpar");
        btnLIMPAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIMPAR1ActionPerformed(evt);
            }
        });

        lblRAZAO2.setText("Razão:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID3)
                            .addComponent(lblCPF3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tfCPF3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEMAIL3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfEMAIL3))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tfID5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbla1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfID4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNOME3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNOME3))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblRAZAO2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRAZAO2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnLIMPAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID3)
                    .addComponent(lbla1)
                    .addComponent(tfID4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfID5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNOME3)
                    .addComponent(tfNOME3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF3)
                    .addComponent(tfCPF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEMAIL3)
                    .addComponent(tfEMAIL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRAZAO2)
                    .addComponent(tfRAZAO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLIMPAR1)
                    .addComponent(btnConsultar1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Dados do Fornecedor");

        jInternalFrame4.setClosable(true);
        jInternalFrame4.setTitle("Contas a Pagar");
        jInternalFrame4.setVisible(true);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Boleto"));

        lblID4.setText("ID:");

        lblNUMEROboleto.setText("NUMERO:");

        lblEMISSAOboleto.setText("EMISSÃO:");

        lblPAGBOLETO.setText("DATA DE PAGAMENTO:");

        lblVALBOLETO.setText("VALOR:");

        lblVENCIMENTOboleto.setText("VENCIMENTO:");

        btnALTERAR2.setText("Alterar");
        btnALTERAR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERAR2ActionPerformed(evt);
            }
        });

        btnEXCLUIR2.setText("Excluir");
        btnEXCLUIR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIR2ActionPerformed(evt);
            }
        });

        btnCRIAR2.setText("Criar");
        btnCRIAR2.setToolTipText("");
        btnCRIAR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRIAR2ActionPerformed(evt);
            }
        });

        btnGRAVAR2.setText("Gravar");
        btnGRAVAR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGRAVAR2ActionPerformed(evt);
            }
        });

        lblJUROSBOLETO.setText("JUROS:");

        lblTOTAL.setText("TOTAL:");

        lblMULTABOLETO.setText("MULTA:");

        lblDESCONTOBOLETO.setText("DESCONTO:");

        jLabel1.setText("BOLETO:");

        jLabel2.setText("FORNECEDOR:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lblEMISSAOboleto)
                                        .addGap(22, 22, 22)
                                        .addComponent(tfEMISSAOBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblVENCIMENTOboleto))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lblVALBOLETO)
                                        .addGap(31, 31, 31)
                                        .addComponent(tfVALBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblJUROSBOLETO)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfJUROSBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(tfVENCBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPAGBOLETO)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPAGBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lblMULTABOLETO)
                                        .addGap(138, 138, 138)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfBOLETO))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnALTERAR2)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCRIAR2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEXCLUIR2)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGRAVAR2)
                                        .addGap(10, 10, 10))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(lblID4)
                                .addGap(59, 59, 59)
                                .addComponent(tfIDBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNUMEROboleto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNUMEROBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfMULTABOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDESCONTOBOLETO, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(tfDESCONTOBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTOTAL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTOTALBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfFORNECEDORBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID4)
                    .addComponent(tfIDBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNUMEROboleto)
                    .addComponent(tfNUMEROBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEMISSAOboleto)
                    .addComponent(tfEMISSAOBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVENCIMENTOboleto)
                    .addComponent(tfVENCBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPAGBOLETO)
                    .addComponent(tfPAGBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJUROSBOLETO)
                        .addComponent(tfJUROSBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMULTABOLETO)
                        .addComponent(tfMULTABOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfVALBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblVALBOLETO))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tfBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGRAVAR2)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDESCONTOBOLETO)
                        .addComponent(tfDESCONTOBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTOTAL)
                        .addComponent(tfTOTALBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnALTERAR2)
                        .addComponent(btnCRIAR2)
                        .addComponent(btnEXCLUIR2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfFORNECEDORBOLETO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(514, 514, 514))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        lblID5.setText("ID:");

        lbla2.setText("á");

        lblBOLETONUMERO2.setText("NUMERO:");

        lblCPF5.setText("EMISSÃO:");

        tblPagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblPagar);

        btnConsultar2.setText("Consultar");
        btnConsultar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar2ActionPerformed(evt);
            }
        });

        btnLIMPAR2.setText("Limpar");
        btnLIMPAR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIMPAR2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID5)
                            .addComponent(lblCPF5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(tfID8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbla2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfID7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBOLETONUMERO2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNUMEROBOLETO2, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(tfCPF5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(368, 368, 368)
                                .addComponent(btnLIMPAR2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConsultar2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID5)
                    .addComponent(lbla2)
                    .addComponent(tfID7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfID8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBOLETONUMERO2)
                    .addComponent(tfNUMEROBOLETO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF5)
                    .addComponent(tfCPF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar2)
                    .addComponent(btnLIMPAR2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jInternalFrame5.setClosable(true);
        jInternalFrame5.setTitle("Contas a Receber");
        jInternalFrame5.setVisible(true);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Nota Fiscal"));

        lblID6.setText("ID:");

        lblNUMEROboleto1.setText("NUMERO:");

        lblEMISSAOboleto1.setText("EMISSÃO:");

        lblPAGBOLETO1.setText("DATA DE PAGAMENTO:");

        lblVALBOLETO1.setText("VALOR:");

        lblVENCIMENTOboleto1.setText("VENCIMENTO:");

        btnALTERAR3.setText("Alterar");
        btnALTERAR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERAR3ActionPerformed(evt);
            }
        });

        btnEXCLUIR3.setText("Excluir");
        btnEXCLUIR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIR3ActionPerformed(evt);
            }
        });

        btnCRIAR3.setText("Criar");
        btnCRIAR3.setToolTipText("");
        btnCRIAR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRIAR3ActionPerformed(evt);
            }
        });

        btnGRAVAR3.setText("Gravar");
        btnGRAVAR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGRAVAR3ActionPerformed(evt);
            }
        });

        lblJUROSBOLETO1.setText("JUROS:");

        lblTOTAL1.setText("TOTAL:");

        lblMULTABOLETO1.setText("MULTA:");

        lblDESCONTOBOLETO1.setText("DESCONTO:");

        jLabel3.setText("NOTA FISCAL:");

        jLabel4.setText("CLIENTE:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(lblEMISSAOboleto1)
                                        .addGap(22, 22, 22)
                                        .addComponent(tfEMISSAOBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblVENCIMENTOboleto1))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(lblVALBOLETO1)
                                        .addGap(31, 31, 31)
                                        .addComponent(tfVALBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblJUROSBOLETO1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfJUROSBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblDESCONTOBOLETO1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(tfVENCBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPAGBOLETO1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPAGBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(lblMULTABOLETO1)
                                        .addGap(138, 138, 138)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfBOLETO1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(btnALTERAR3)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCRIAR3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEXCLUIR3)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGRAVAR3)
                                        .addGap(10, 10, 10))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(lblID6)
                                .addGap(59, 59, 59)
                                .addComponent(tfIDBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNUMEROboleto1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNUMEROBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfMULTABOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(tfDESCONTOBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTOTAL1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTOTALBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfFORNECEDORBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID6)
                    .addComponent(tfIDBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNUMEROboleto1)
                    .addComponent(tfNUMEROBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEMISSAOboleto1)
                    .addComponent(tfEMISSAOBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVENCIMENTOboleto1)
                    .addComponent(tfVENCBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPAGBOLETO1)
                    .addComponent(tfPAGBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJUROSBOLETO1)
                        .addComponent(tfJUROSBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMULTABOLETO1)
                        .addComponent(tfMULTABOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfVALBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblVALBOLETO1))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGRAVAR3)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDESCONTOBOLETO1)
                        .addComponent(tfDESCONTOBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTOTAL1)
                        .addComponent(tfTOTALBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnALTERAR3)
                        .addComponent(btnCRIAR3)
                        .addComponent(btnEXCLUIR3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfFORNECEDORBOLETO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(514, 514, 514))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        lblID7.setText("ID:");

        lbla3.setText("á");

        lblBOLETONUMERO3.setText("NUMERO:");

        lblCPF6.setText("EMISSÃO:");

        tblReceber.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblReceber);

        btnConsultar3.setText("Consultar");
        btnConsultar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar3ActionPerformed(evt);
            }
        });

        btnLIMPAR3.setText("Limpar");
        btnLIMPAR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIMPAR3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID7)
                            .addComponent(lblCPF6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(tfID10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbla3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfID9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBOLETONUMERO3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNUMEROBOLETO3, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(tfCPF6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(368, 368, 368)
                                .addComponent(btnLIMPAR3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConsultar3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID7)
                    .addComponent(lbla3)
                    .addComponent(tfID9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfID10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBOLETONUMERO3)
                    .addComponent(tfNUMEROBOLETO3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF6)
                    .addComponent(tfCPF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar3)
                    .addComponent(btnLIMPAR3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jMenu1.setText("Cadastro");

        jMenuItem1.setText("Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Fornecedor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Movimentos");

        jMenuItem5.setText("Contas a Pagar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Contas a Receber");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Sair");

        jMenuItem3.setText("Sair");
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jInternalFrame1)
                    .addComponent(jInternalFrame3))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jInternalFrame4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultarCliente();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnLIMPARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIMPARActionPerformed
       limparCliente();       
    }//GEN-LAST:event_btnLIMPARActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jInternalFrame1.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnALTERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERARActionPerformed
                setOperacao("alterar");       
    }//GEN-LAST:event_btnALTERARActionPerformed

    private void btnCRIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRIARActionPerformed
        limparCliente();
        setOperacao("incluir");
        tfNOME.setFocusable(true);        
    }//GEN-LAST:event_btnCRIARActionPerformed

    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Usuário ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ClienteModel objcliente = new ClienteModel();
                EnderecoModel endereco = new EnderecoModel();
                objcliente.setEndereco(endereco);
                endereco.setENDERECO_LOGRADOURO(tfLOGRA.getText());
                endereco.setENDERECO_NUMERO(Integer.parseInt(tfNUMERO.getText()));
                endereco.setENDERECO_CEP((tfNUMERO.getText()));
                endereco.setENDEROCO_CIDADE((tfCIDADE.getText()));
                endereco.setENDERECO_ESTADO(cbESTADO.getSelectedItem().toString());
                objcliente.setCLI_ID(Integer.parseInt(tfID.getText()));
                objcliente.setCLI_NOME(tfNOME.getText());
                objcliente.setCLI_CPF(tfCPF.getText());
                objcliente.setCLI_EMAIL(tfEMAIL.getText());
                objcliente.setCLI_DDD(Integer.parseInt(tfDDD.getText()));
                objcliente.setCLI_TELEFONE(Integer.parseInt(tfNUMERO.getText()));
                
                ClienteController clientecontroller = new ClienteController();
                clientecontroller.gravar(getOperacao(), objcliente);

                JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso");
                consultarCliente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Gravação \n" + ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnGRAVARActionPerformed

    private void btnEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRActionPerformed
        setOperacao("");
        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão deste Registro ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ClienteModel objcliente = new ClienteModel();
                EnderecoModel endereco = new EnderecoModel();
                objcliente.setEndereco(endereco);
                endereco.setENDERECO_LOGRADOURO(tfLOGRA.getText());
                endereco.setENDERECO_NUMERO(Integer.parseInt(tfNUMERO.getText()));
                endereco.setENDERECO_CEP((tfNUMERO.getText()));
                endereco.setENDEROCO_CIDADE((tfCIDADE.getText()));
                endereco.setENDERECO_ESTADO(cbESTADO.getSelectedItem().toString());
                objcliente.setCLI_ID(Integer.parseInt(tfID.getText()));
                objcliente.setCLI_NOME(tfNOME.getText());
                objcliente.setCLI_CPF(tfCPF.getText());
                objcliente.setCLI_EMAIL(tfEMAIL.getText());
                objcliente.setCLI_DDD(Integer.parseInt(tfDDD.getText()));
                objcliente.setCLI_TELEFONE(Integer.parseInt(tfNUMERO.getText()));
                
                ClienteController clientecontroller = new ClienteController();
                
                clientecontroller.excluir(objcliente);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultarCliente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }      
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void btnALTERAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERAR1ActionPerformed
        setOperacao("alterar");   
    }//GEN-LAST:event_btnALTERAR1ActionPerformed

    private void btnEXCLUIR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIR1ActionPerformed
        setOperacao("");
        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão deste Registro ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                FornecedorModel objfornecedor = new FornecedorModel();
                EnderecoModel endereco = new EnderecoModel();
                endereco.setENDERECO_LOGRADOURO(tfLOGRA1.getText());
                endereco.setENDERECO_NUMERO(Integer.parseInt(tfNUMERO1.getText()));
                endereco.setENDERECO_CEP((tfNUMERO1.getText()));
                endereco.setENDEROCO_CIDADE((tfCIDADE1.getText()));
                endereco.setENDERECO_ESTADO(cbESTADO1.getSelectedItem().toString());
                objfornecedor.setFOR_ID(Integer.parseInt(tfID1.getText()));
                objfornecedor.setFOR_NOME(tfNOME1.getText());
                objfornecedor.setFOR_CNPJ(tfCPF1.getText());
                objfornecedor.setFOR_RAZAO(tfRAZAO.getText());
                objfornecedor.setFOR_EMAIL(tfEMAIL1.getText());
                objfornecedor.setFOR_DDD(Integer.parseInt(tfDDD1.getText()));
                objfornecedor.setFOR_NUMERO(Integer.parseInt(tfNUMERO1.getText()));
                objfornecedor.setEndereco(endereco);
                FornecedorController fornecedorcontroller = new FornecedorController();
                
                fornecedorcontroller.excluir(objfornecedor);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultarFornecedor();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }      
    }//GEN-LAST:event_btnEXCLUIR1ActionPerformed

    private void btnCRIAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRIAR1ActionPerformed
        limparFornecedor();
        setOperacao("incluir");
        tfNOME1.setFocusable(true);   
    }//GEN-LAST:event_btnCRIAR1ActionPerformed

    private void btnGRAVAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVAR1ActionPerformed
            if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Registro ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                FornecedorModel objfornecedor = new FornecedorModel();
                EnderecoModel endereco = new EnderecoModel();
                endereco.setENDERECO_LOGRADOURO(tfLOGRA1.getText());
                endereco.setENDERECO_NUMERO(Integer.parseInt(tfNUMERO1.getText()));
                endereco.setENDERECO_CEP((tfNUMERO1.getText()));
                endereco.setENDEROCO_CIDADE((tfCIDADE1.getText()));
                endereco.setENDERECO_ESTADO(cbESTADO1.getSelectedItem().toString());
                objfornecedor.setFOR_ID(Integer.parseInt(tfID1.getText()));
                objfornecedor.setFOR_NOME(tfNOME1.getText());
                objfornecedor.setFOR_CNPJ(tfCPF1.getText());
                objfornecedor.setFOR_RAZAO(tfRAZAO.getText());
                objfornecedor.setFOR_EMAIL(tfEMAIL1.getText());
                objfornecedor.setFOR_DDD(Integer.parseInt(tfDDD1.getText()));
                objfornecedor.setFOR_NUMERO(Integer.parseInt(tfNUMERO1.getText()));
                FornecedorController fornecedorcontroller = new FornecedorController();
                objfornecedor.setEndereco(endereco);
                fornecedorcontroller.gravar(getOperacao(),objfornecedor);

                JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso");
                consultarFornecedor();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Gravação de Registro \n" + ex.getMessage());
            }
        }      
    }//GEN-LAST:event_btnGRAVAR1ActionPerformed

    private void btnConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar1ActionPerformed
        consultarFornecedor();
    }//GEN-LAST:event_btnConsultar1ActionPerformed

    private void btnLIMPAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIMPAR1ActionPerformed
        limparFornecedor();
    }//GEN-LAST:event_btnLIMPAR1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jInternalFrame3.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnALTERAR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERAR2ActionPerformed
        setOperacao("alterar"); 
    }//GEN-LAST:event_btnALTERAR2ActionPerformed

    private void btnEXCLUIR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIR2ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão deste Registro ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                PagarModel objpagar = new PagarModel();
                objpagar.setFINAN_ID(Integer.parseInt(tfIDBOLETO.getText()));
                objpagar.setFINAN_NUM(Integer.parseInt(tfNUMEROBOLETO.getText()));
                objpagar.setFINAN_EMISSAO(tfEMISSAOBOLETO.getText());
                objpagar.setFINAN_VENC(tfVENCBOLETO.getText());
                objpagar.setFINAN_PAG(tfPAGBOLETO.getText());
                objpagar.setFINAN_VAL(Double.parseDouble(tfVALBOLETO.getText()));
                objpagar.setFINAN_JUROS(Double.parseDouble(tfJUROSBOLETO.getText()));
                objpagar.setFINAN_MULTA(Double.parseDouble(tfMULTABOLETO.getText()));
                objpagar.setFINAN_DESCONTO(Double.parseDouble(tfDESCONTOBOLETO.getText()));
                objpagar.setFINAN_TOTAL(Double.parseDouble(tfTOTALBOLETO.getText()));
                
                
                PagarController pagarcontroller = new PagarController();
                
                pagarcontroller.excluir(objpagar);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultarPagar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }     
    }//GEN-LAST:event_btnEXCLUIR2ActionPerformed

    private void btnCRIAR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRIAR2ActionPerformed
        limparPag();
        setOperacao("incluir");
        tfNUMERO.setFocusable(true);  
    }//GEN-LAST:event_btnCRIAR2ActionPerformed

    private void btnGRAVAR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVAR2ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Registro ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                PagarModel objpagar = new PagarModel();
                objpagar.setFINAN_ID(Integer.parseInt(tfIDBOLETO.getText()));
                objpagar.setFINAN_NUM(Integer.parseInt(tfNUMEROBOLETO.getText()));
                objpagar.setFINAN_EMISSAO(tfEMISSAOBOLETO.getText());
                objpagar.setFINAN_VENC(tfVENCBOLETO.getText());
                objpagar.setFINAN_PAG(tfPAGBOLETO.getText());
                objpagar.setFINAN_VAL(Double.parseDouble(tfVALBOLETO.getText()));
                objpagar.setFINAN_JUROS(Double.parseDouble(tfJUROSBOLETO.getText()));
                objpagar.setFINAN_MULTA(Double.parseDouble(tfMULTABOLETO.getText()));
                objpagar.setFINAN_DESCONTO(Double.parseDouble(tfDESCONTOBOLETO.getText()));
                objpagar.setFINAN_TOTAL(Double.parseDouble(tfTOTALBOLETO.getText()));
                
               
                PagarController pagarcontroller = new PagarController();
                
                pagarcontroller.gravar(getOperacao(),objpagar);

                JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso");
                consultarPagar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Gravação de Registro \n" + ex.getMessage());
            }
        }     
    }//GEN-LAST:event_btnGRAVAR2ActionPerformed

    private void btnConsultar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar2ActionPerformed
        consultarPagar();
    }//GEN-LAST:event_btnConsultar2ActionPerformed

    private void btnLIMPAR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIMPAR2ActionPerformed
        limparPag();
    }//GEN-LAST:event_btnLIMPAR2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       jInternalFrame4.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btnALTERAR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERAR3ActionPerformed
        setOperacao("alterar");
    }//GEN-LAST:event_btnALTERAR3ActionPerformed

    private void btnEXCLUIR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIR3ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão deste Registro ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ReceberModel objreceber = new ReceberModel();
                objreceber.setFINAN_ID(Integer.parseInt(tfIDBOLETO1.getText()));
                objreceber.setFINAN_NUM(Integer.parseInt(tfNUMEROBOLETO1.getText()));
                objreceber.setFINAN_EMISSAO(tfEMISSAOBOLETO1.getText());
                objreceber.setFINAN_VENC(tfVENCBOLETO1.getText());
                objreceber.setFINAN_PAG(tfPAGBOLETO1.getText());
                objreceber.setFINAN_VAL(Double.parseDouble(tfVALBOLETO1.getText()));
                objreceber.setFINAN_JUROS(Double.parseDouble(tfJUROSBOLETO1.getText()));
                objreceber.setFINAN_MULTA(Double.parseDouble(tfMULTABOLETO1.getText()));
                objreceber.setFINAN_DESCONTO(Double.parseDouble(tfDESCONTOBOLETO1.getText()));
                objreceber.setFINAN_TOTAL(Double.parseDouble(tfTOTALBOLETO1.getText()));
                
                
                ReceberController recebercontroller = new ReceberController();
                
                recebercontroller.excluir(objreceber);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultarPagar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }     
    }//GEN-LAST:event_btnEXCLUIR3ActionPerformed

    private void btnCRIAR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRIAR3ActionPerformed
        limparRec();
        setOperacao("incluir");
        tfNUMEROBOLETO1.setFocusable(true); 
    }//GEN-LAST:event_btnCRIAR3ActionPerformed

    private void btnGRAVAR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVAR3ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Registro ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ReceberModel objreceber = new ReceberModel();
                objreceber.setFINAN_ID(Integer.parseInt(tfIDBOLETO1.getText()));
                objreceber.setFINAN_NUM(Integer.parseInt(tfNUMEROBOLETO1.getText()));
                objreceber.setFINAN_EMISSAO(tfEMISSAOBOLETO1.getText());
                objreceber.setFINAN_VENC(tfVENCBOLETO1.getText());
                objreceber.setFINAN_PAG(tfPAGBOLETO1.getText());
                objreceber.setFINAN_VAL(Double.parseDouble(tfVALBOLETO1.getText()));
                objreceber.setFINAN_JUROS(Double.parseDouble(tfJUROSBOLETO1.getText()));
                objreceber.setFINAN_MULTA(Double.parseDouble(tfMULTABOLETO1.getText()));
                objreceber.setFINAN_DESCONTO(Double.parseDouble(tfDESCONTOBOLETO1.getText()));
                objreceber.setFINAN_TOTAL(Double.parseDouble(tfTOTALBOLETO1.getText()));
            
                ReceberController recebercontroller = new ReceberController();
                
                recebercontroller.gravar(getOperacao(),objreceber);

                JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso");
                consultarReceber();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Gravação de Registro \n" + ex.getMessage());
            }
        }     
    }//GEN-LAST:event_btnGRAVAR3ActionPerformed

    private void btnConsultar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar3ActionPerformed
        consultarReceber();
    }//GEN-LAST:event_btnConsultar3ActionPerformed

    private void btnLIMPAR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIMPAR3ActionPerformed
        limparRec();
    }//GEN-LAST:event_btnLIMPAR3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        jInternalFrame5.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserView().setVisible(true);
            }
        });
    }
    public void limparCliente(){
        tfID2.setText("");
        tfID3.setText("");
        tfNOME2.setText("");
        tfEMAIL2.setText("");
        tfCPF2.setText("");
    }
    
    public void limparFornecedor(){
        tfID4.setText("");
        tfID5.setText("");
        tfNOME3.setText("");
        tfEMAIL3.setText("");
        tfCPF3.setText("");
        tfRAZAO.setText("");
    }
    
    public void limparPag(){
        tfID8.setText("");
        tfID7.setText("");
        tfNUMEROBOLETO2.setText("");
    }
    public void limparRec(){
        tfID10.setText("");
        tfID9.setText("");
        tfNUMEROBOLETO3.setText("");
    }
    
    
    private String filtroConsultaCliente() {
        String condicao = "";
        if (!tfID2.getText().trim().equals("")) {
            condicao += "(CLIENTE.CLI_ID >= " + tfID2.getText() + ")";
        }
        if (!tfID3.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CLIENTE.CLI_ID <= " + tfID3.getText() + ")";
        }
        if (!tfNOME2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(CLIENTE.CLI_NOME) LIKE ('%" + tfNOME2.getText().toUpperCase() + "%'))";
        }
        if (!tfCPF2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(CLIENTE.CLI_CPF) LIKE ('%" + tfCPF2.getText().toUpperCase() + "%'))";
        }
        if (!tfEMAIL2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(CLIENTE.CLI_EMAIL) LIKE ('%" + tfEMAIL2.getText().toUpperCase() + "%'))";
        }
        return condicao;
    }
    
    private String filtroConsultaFornecedor() {
        String condicao = "";
        if (!tfID5.getText().trim().equals("")) {
            condicao += "(FORNECEDOR.FOR_ID >= " + tfID5.getText() + ")";
        }
        if (!tfID4.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(FORNECEDOR.FOR_ID <= " + tfID4.getText() + ")";
        }
        if (!tfNOME3.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(FORNECEDOR.FOR_NOME) LIKE ('%" + tfNOME3.getText().toUpperCase() + "%'))";
        }
        if (!tfCPF3.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(FORNECEDOR.FOR_CNPJ) LIKE ('%" + tfCPF3.getText().toUpperCase() + "%'))";
        }
        if (!tfEMAIL3.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(FORNECEDOR.FOR_EMAIL) LIKE ('%" + tfEMAIL3.getText().toUpperCase() + "%'))";
        }
        if (!tfRAZAO.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(FORNECEDOR.FOR_RAZAO) LIKE ('%" + tfRAZAO.getText().toUpperCase() + "%'))";
        }
        return condicao;
    }
    private String filtroConsultaPagar() {
        String condicao = "";
        if (!tfID8.getText().trim().equals("")) {
            condicao += "(FINAN_ID >= " + tfID8.getText() + ")";
        }
        if (!tfID7.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(FINAN_ID <= " + tfID7.getText() + ")";
        }
        if (!tfNUMEROBOLETO2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(FINAN_NUM) LIKE ('%" + tfNUMEROBOLETO2.getText().toUpperCase() + "%'))";
        }
        
        return condicao;
    }
    private String filtroConsultaReceber() {
        String condicao = "";
        if (!tfID10.getText().trim().equals("")) {
            condicao += "(FINAN_ID >= " + tfID10.getText() + ")";
        }
        if (!tfID9.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(FINAN_ID <= " + tfID9.getText() + ")";
        }
        if (!tfNUMEROBOLETO3.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(FINAN_NUM) LIKE ('%" + tfNUMEROBOLETO3.getText().toUpperCase() + "%'))";
        }
        
        return condicao;
    }
    
    private void consultarCliente() {
        try {
            String condicao = filtroConsultaCliente();
            ClienteController clientecontroller = new ClienteController();
            listaCli = null;
            listaCli = clientecontroller.consultar(condicao);
            
            if (listaCli.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não Existem Clientes Cadastrados !");
            } else {
                tabelaCli = new ClienteTableModel(listaCli, colunasCli);
                tblCliente.setModel(tabelaCli);
                tblCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta do Clientes \n" + ex.getMessage());
        }
    }
    private void consultarFornecedor() {
        try {
            String condicao = filtroConsultaFornecedor();
            FornecedorController fornecedorcontroller = new FornecedorController();
            listaFor = null;
            listaFor = fornecedorcontroller.consultar(condicao);
            if (listaFor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não Existem Fornecedores Cadastrados !");
            } else {
                tabelaFor = new FornecedorTableModel(listaFor, colunasFor);
                tblFornecedor.setModel(tabelaFor);
                tblFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta do Fornecedores \n" + ex.getMessage());
        }
    }
    private void consultarPagar() {
        try {
            String condicao = filtroConsultaPagar();
            PagarController pagarcontroller = new PagarController();
            listaPag = null;
            listaPag = pagarcontroller.consultar(condicao);
            if (listaPag.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não Existem Fornecedores Boleto!");
            } else {
                tabelaPag = new PagarTableModel(listaPag, colunasPag);
                tblPagar.setModel(tabelaPag);
                tblPagar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta do Boleto\n" + ex.getMessage());
        }
    }
    private void consultarReceber() {
        try {
            String condicao = filtroConsultaReceber();
            ReceberController recebercontroller = new ReceberController();
            listaRec = null;
            listaRec = recebercontroller.consultar(condicao);
            if (listaRec.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não Existem Fornecedores Boleto!");
            } else {
                tabelaRec = new ReceberTableModel(listaRec, colunasRec);
                tblReceber.setModel(tabelaRec);
                tblReceber.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta do Boleto\n" + ex.getMessage());
        }
    }
    
    private void mostrarCliente(ClienteModel cliente) {
        tfID.setText(String.valueOf(cliente.getCLI_ID()));
        tfNOME.setText(cliente.getCLI_NOME());
        tfCPF.setText(cliente.getCLI_CPF());
        tfEMAIL.setText(cliente.getCLI_EMAIL());
        tfDDD.setText(String.valueOf(cliente.getCLI_DDD()));
        tfNUMERO.setText(String.valueOf(cliente.getCLI_TELEFONE()));
        tfENDE.setText(String.valueOf(cliente.getEndereco().getENDERECO_ID()));
        tfLOGRA.setText(cliente.getEndereco().getENDERECO_LOGRADOURO());
        tfNUM.setText(String.valueOf(cliente.getEndereco().getENDERECO_NUMERO()));
        tfCEP.setText(String.valueOf(cliente.getEndereco().getENDERECO_CEP()));
        tfCIDADE.setText(String.valueOf(cliente.getEndereco().getENDEROCO_CIDADE()));
        cbESTADO.setSelectedItem(cliente.getEndereco().getENDERECO_ESTADO());
        
        
    }
    private void mostrarFornecedor(FornecedorModel fornecedor) {
        tfID1.setText(String.valueOf(fornecedor.getFOR_ID()));
        tfNOME1.setText(fornecedor.getFOR_NOME());
        tfRAZAO.setText(fornecedor.getFOR_RAZAO());
        tfCPF1.setText(fornecedor.getFOR_CNPJ());
        tfEMAIL1.setText(fornecedor.getFOR_EMAIL());
        tfDDD1.setText(String.valueOf(fornecedor.getFOR_DDD()));
        tfNUMERO1.setText(String.valueOf(fornecedor.getFOR_NUMERO()));
        tfENDE1.setText(String.valueOf(fornecedor.getEndereco().getENDERECO_ID()));
        tfLOGRA1.setText(fornecedor.getEndereco().getENDERECO_LOGRADOURO());
        tfNUM1.setText(String.valueOf(fornecedor.getEndereco().getENDERECO_NUMERO()));
        tfCEP1.setText(String.valueOf(fornecedor.getEndereco().getENDERECO_CEP()));
        tfCIDADE1.setText(String.valueOf(fornecedor.getEndereco().getENDEROCO_CIDADE()));
        cbESTADO1.setSelectedItem(fornecedor.getEndereco().getENDERECO_ESTADO());
    }
    private void mostrarPagar(PagarModel pagar) {
        tfIDBOLETO.setText(String.valueOf(pagar.getFINAN_ID()));
        tfNUMEROBOLETO.setText(String.valueOf(pagar.getFINAN_NUM()));
        tfEMISSAOBOLETO.setText(pagar.getFINAN_EMISSAO());
        tfVENCBOLETO.setText(pagar.getFINAN_VENC());
        tfPAGBOLETO.setText(pagar.getFINAN_PAG());
        tfVALBOLETO.setText(String.valueOf(pagar.getFINAN_VAL()));
        tfJUROSBOLETO.setText(String.valueOf(pagar.getFINAN_JUROS()));
        tfMULTABOLETO.setText(String.valueOf(pagar.getFINAN_MULTA()));
        tfDESCONTOBOLETO.setText(String.valueOf(pagar.getFINAN_DESCONTO()));
        tfTOTALBOLETO.setText(String.valueOf(pagar.getFINAN_TOTAL()));
        tfBOLETO.setText(pagar.getBOLETO());
        
    }
    private void mostrarReceber(ReceberModel receber) {
        tfIDBOLETO1.setText(String.valueOf(receber.getFINAN_ID()));
        tfNUMEROBOLETO1.setText(String.valueOf(receber.getFINAN_NUM()));
        tfEMISSAOBOLETO1.setText(receber.getFINAN_EMISSAO());
        tfVENCBOLETO1.setText(receber.getFINAN_VENC());
        tfPAGBOLETO1.setText(receber.getFINAN_PAG());
        tfVALBOLETO1.setText(String.valueOf(receber.getFINAN_VAL()));
        tfJUROSBOLETO1.setText(String.valueOf(receber.getFINAN_JUROS()));
        tfMULTABOLETO1.setText(String.valueOf(receber.getFINAN_MULTA()));
        tfDESCONTOBOLETO1.setText(String.valueOf(receber.getFINAN_DESCONTO()));
        tfTOTALBOLETO1.setText(String.valueOf(receber.getFINAN_TOTAL()));
        tfBOLETO1.setText(receber.getNOTA_FISCAL());
        tfFORNECEDORBOLETO1.setText(receber.getCliente().getCLI_NOME());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnALTERAR;
    private javax.swing.JButton btnALTERAR1;
    private javax.swing.JButton btnALTERAR2;
    private javax.swing.JButton btnALTERAR3;
    private javax.swing.JButton btnCRIAR;
    private javax.swing.JButton btnCRIAR1;
    private javax.swing.JButton btnCRIAR2;
    private javax.swing.JButton btnCRIAR3;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultar1;
    private javax.swing.JButton btnConsultar2;
    private javax.swing.JButton btnConsultar3;
    private javax.swing.JButton btnEXCLUIR;
    private javax.swing.JButton btnEXCLUIR1;
    private javax.swing.JButton btnEXCLUIR2;
    private javax.swing.JButton btnEXCLUIR3;
    private javax.swing.JButton btnGRAVAR;
    private javax.swing.JButton btnGRAVAR1;
    private javax.swing.JButton btnGRAVAR2;
    private javax.swing.JButton btnGRAVAR3;
    private javax.swing.JButton btnLIMPAR;
    private javax.swing.JButton btnLIMPAR1;
    private javax.swing.JButton btnLIMPAR2;
    private javax.swing.JButton btnLIMPAR3;
    private javax.swing.JComboBox<String> cbESTADO;
    private javax.swing.JComboBox<String> cbESTADO1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblBOLETONUMERO2;
    private javax.swing.JLabel lblBOLETONUMERO3;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCEP1;
    private javax.swing.JLabel lblCIDADE;
    private javax.swing.JLabel lblCIDADE1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCPF1;
    private javax.swing.JLabel lblCPF2;
    private javax.swing.JLabel lblCPF3;
    private javax.swing.JLabel lblCPF5;
    private javax.swing.JLabel lblCPF6;
    private javax.swing.JLabel lblDDD;
    private javax.swing.JLabel lblDDD1;
    private javax.swing.JLabel lblDESCONTOBOLETO;
    private javax.swing.JLabel lblDESCONTOBOLETO1;
    private javax.swing.JLabel lblEMAIL;
    private javax.swing.JLabel lblEMAIL1;
    private javax.swing.JLabel lblEMAIL2;
    private javax.swing.JLabel lblEMAIL3;
    private javax.swing.JLabel lblEMISSAOboleto;
    private javax.swing.JLabel lblEMISSAOboleto1;
    private javax.swing.JLabel lblENDE;
    private javax.swing.JLabel lblENDE1;
    private javax.swing.JLabel lblESTADO;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblID2;
    private javax.swing.JLabel lblID3;
    private javax.swing.JLabel lblID4;
    private javax.swing.JLabel lblID5;
    private javax.swing.JLabel lblID6;
    private javax.swing.JLabel lblID7;
    private javax.swing.JLabel lblJUROSBOLETO;
    private javax.swing.JLabel lblJUROSBOLETO1;
    private javax.swing.JLabel lblLOGRA;
    private javax.swing.JLabel lblLOGRA1;
    private javax.swing.JLabel lblMULTABOLETO;
    private javax.swing.JLabel lblMULTABOLETO1;
    private javax.swing.JLabel lblNOME;
    private javax.swing.JLabel lblNOME1;
    private javax.swing.JLabel lblNOME2;
    private javax.swing.JLabel lblNOME3;
    private javax.swing.JLabel lblNUM;
    private javax.swing.JLabel lblNUM1;
    private javax.swing.JLabel lblNUMERO;
    private javax.swing.JLabel lblNUMERO1;
    private javax.swing.JLabel lblNUMEROboleto;
    private javax.swing.JLabel lblNUMEROboleto1;
    private javax.swing.JLabel lblPAGBOLETO;
    private javax.swing.JLabel lblPAGBOLETO1;
    private javax.swing.JLabel lblRAZAO;
    private javax.swing.JLabel lblRAZAO2;
    private javax.swing.JLabel lblTOTAL;
    private javax.swing.JLabel lblTOTAL1;
    private javax.swing.JLabel lblVALBOLETO;
    private javax.swing.JLabel lblVALBOLETO1;
    private javax.swing.JLabel lblVENCIMENTOboleto;
    private javax.swing.JLabel lblVENCIMENTOboleto1;
    private javax.swing.JLabel lbla;
    private javax.swing.JLabel lbla1;
    private javax.swing.JLabel lbla2;
    private javax.swing.JLabel lbla3;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblFornecedor;
    private javax.swing.JTable tblPagar;
    private javax.swing.JTable tblReceber;
    private javax.swing.JTextField tfBOLETO;
    private javax.swing.JTextField tfBOLETO1;
    private javax.swing.JTextField tfCEP;
    private javax.swing.JTextField tfCEP1;
    private javax.swing.JTextField tfCIDADE;
    private javax.swing.JTextField tfCIDADE1;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfCPF1;
    private javax.swing.JTextField tfCPF2;
    private javax.swing.JTextField tfCPF3;
    private javax.swing.JTextField tfCPF5;
    private javax.swing.JTextField tfCPF6;
    private javax.swing.JTextField tfDDD;
    private javax.swing.JTextField tfDDD1;
    private javax.swing.JTextField tfDESCONTOBOLETO;
    private javax.swing.JTextField tfDESCONTOBOLETO1;
    private javax.swing.JTextField tfEMAIL;
    private javax.swing.JTextField tfEMAIL1;
    private javax.swing.JTextField tfEMAIL2;
    private javax.swing.JTextField tfEMAIL3;
    private javax.swing.JTextField tfEMISSAOBOLETO;
    private javax.swing.JTextField tfEMISSAOBOLETO1;
    private javax.swing.JTextField tfENDE;
    private javax.swing.JTextField tfENDE1;
    private javax.swing.JLabel tfESTADO1;
    private javax.swing.JTextField tfFORNECEDORBOLETO;
    private javax.swing.JTextField tfFORNECEDORBOLETO1;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfID1;
    private javax.swing.JTextField tfID10;
    private javax.swing.JTextField tfID2;
    private javax.swing.JTextField tfID3;
    private javax.swing.JTextField tfID4;
    private javax.swing.JTextField tfID5;
    private javax.swing.JTextField tfID7;
    private javax.swing.JTextField tfID8;
    private javax.swing.JTextField tfID9;
    private javax.swing.JTextField tfIDBOLETO;
    private javax.swing.JTextField tfIDBOLETO1;
    private javax.swing.JTextField tfJUROSBOLETO;
    private javax.swing.JTextField tfJUROSBOLETO1;
    private javax.swing.JTextField tfLOGRA;
    private javax.swing.JTextField tfLOGRA1;
    private javax.swing.JTextField tfMULTABOLETO;
    private javax.swing.JTextField tfMULTABOLETO1;
    private javax.swing.JTextField tfNOME;
    private javax.swing.JTextField tfNOME1;
    private javax.swing.JTextField tfNOME2;
    private javax.swing.JTextField tfNOME3;
    private javax.swing.JTextField tfNUM;
    private javax.swing.JTextField tfNUM1;
    private javax.swing.JTextField tfNUMERO;
    private javax.swing.JTextField tfNUMERO1;
    private javax.swing.JTextField tfNUMEROBOLETO;
    private javax.swing.JTextField tfNUMEROBOLETO1;
    private javax.swing.JTextField tfNUMEROBOLETO2;
    private javax.swing.JTextField tfNUMEROBOLETO3;
    private javax.swing.JTextField tfPAGBOLETO;
    private javax.swing.JTextField tfPAGBOLETO1;
    private javax.swing.JTextField tfRAZAO;
    private javax.swing.JTextField tfRAZAO2;
    private javax.swing.JTextField tfTOTALBOLETO;
    private javax.swing.JTextField tfTOTALBOLETO1;
    private javax.swing.JTextField tfVALBOLETO;
    private javax.swing.JTextField tfVALBOLETO1;
    private javax.swing.JTextField tfVENCBOLETO;
    private javax.swing.JTextField tfVENCBOLETO1;
    // End of variables declaration//GEN-END:variables

}
