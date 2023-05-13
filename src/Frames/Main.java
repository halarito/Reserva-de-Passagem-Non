package Frames;

import Classes.Modulo;
import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.ScrollBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import net.proteanit.sql.DbUtils;

public class Main extends JFrame {

    JTextField campocod = new JTextField();
    JTextField camponome = new JTextField();
    JComboBox cbnat = new JComboBox();
    JTextField campomor = new JTextField();
    JTextField campocont = new JTextField();
    JTextField campobi = new JTextField();
    JComboBox cbcargo = new JComboBox();
    JComboBox cbperfil = new JComboBox();
    JPasswordField campopass = new JPasswordField();
    JTextField campouser = new JTextField();
    JTable table = new JTable();
    Connection conexao = null;
    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    ResultSet rs = null;
    
    JToggleButton toggle1 = new JToggleButton("1");
        JToggleButton toggle2 = new JToggleButton("2");
        JToggleButton toggle3 = new JToggleButton("3");
        JToggleButton toggle4 = new JToggleButton("4");
        JToggleButton toggle5 = new JToggleButton("5");
        JToggleButton toggle6 = new JToggleButton("6");
        JToggleButton toggle7 = new JToggleButton("7");
        JToggleButton toggle8 = new JToggleButton("8");
        JToggleButton toggle9 = new JToggleButton("9");
        JToggleButton toggle10 = new JToggleButton("10");
        JToggleButton toggle11 = new JToggleButton("11");
        JToggleButton toggle12 = new JToggleButton("12");
        JToggleButton toggle13 = new JToggleButton("13");
        JToggleButton toggle14 = new JToggleButton("14");
        JToggleButton toggle15 = new JToggleButton("15");
        JToggleButton toggle16 = new JToggleButton("16");
        JToggleButton toggle17 = new JToggleButton("17");
        JToggleButton toggle18 = new JToggleButton("18");
        JToggleButton toggle19 = new JToggleButton("19");
        JToggleButton toggle20 = new JToggleButton("20");
        JToggleButton toggle21 = new JToggleButton("21");
        JToggleButton toggle22 = new JToggleButton("22");
        JToggleButton toggle23 = new JToggleButton("23");
        JToggleButton toggle24 = new JToggleButton("24");
        JToggleButton toggle25 = new JToggleButton("25");
        JToggleButton toggle26 = new JToggleButton("26");
        JToggleButton toggle27 = new JToggleButton("27");
        JToggleButton toggle28 = new JToggleButton("28");
        JToggleButton toggle29 = new JToggleButton("29");
        JToggleButton toggle30 = new JToggleButton("30");
        JToggleButton toggle31 = new JToggleButton("31");
        JToggleButton toggle32 = new JToggleButton("32");
        JToggleButton toggle33 = new JToggleButton("33");
        JToggleButton toggle34 = new JToggleButton("34");
        JToggleButton toggle35 = new JToggleButton("35");
        JToggleButton toggle36 = new JToggleButton("36");
        JToggleButton toggle37 = new JToggleButton("37");
        JToggleButton toggle38 = new JToggleButton("38");
        JToggleButton toggle39 = new JToggleButton("39");
        JToggleButton toggle40 = new JToggleButton("40");
        JToggleButton toggle41 = new JToggleButton("41");
        JToggleButton toggle42 = new JToggleButton("42");
        JToggleButton toggle43 = new JToggleButton("43");
        JToggleButton toggle44 = new JToggleButton("44");

        JTable tablebilhete = new JTable();
        JScrollPane spane = new JScrollPane(tablebilhete);
        JComboBox cbpartida = new JComboBox();
        JComboBox cbpara = new JComboBox();
        JSpinner js1 = new JSpinner();
        JSpinner js2 = new JSpinner();
        JSpinner js3 = new JSpinner();
        JTextField nomeB = new JTextField();
        JTextField biB = new JTextField();
        JTextField contactoB = new JTextField();
        JTextField contactoaltB = new JTextField();
        JTextField cobradorB = new JTextField();
        JTextField contactocobB = new JTextField();
        JTextField MatriculaB = new JTextField();
        JTextField idViagemB = new JTextField();
        
    public Main() {

        initComponents();

        conexao = Modulo.conector();

        listarFunc();
        listarBilhete();
        
    }

    void listarFunc() {

        String sql = "Select * from func";

        try {
            pst = conexao.prepareStatement(sql);

            rs = pst.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void listarBilhete() {

        String sql = "Select id,nome,contacto, cadeira, cobrador, matricula from bilhete where partida = ? and chegada = ? and data_partida = ?";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, cbpartida.getSelectedItem().toString());
            pst.setString(2, cbpara.getSelectedItem().toString());
            pst.setString(3, js1.getValue().toString() + "-" + js2.getValue().toString() + "-" + js3.getValue().toString());

            rs = pst.executeQuery();

            tablebilhete.setModel(new javax.swing.table.DefaultTableModel(
                    
                    new Object[][]{
                        
                    },
                    new String[]{
                        "ID","Nome","Contacto","Cadeira","Cobrador","Matrícula"
                    }
            ){
                boolean[] edit = new boolean[]{
                    false, false
                };
                
                public boolean editar(int rowIndex, int columnIndex){
                    return edit[columnIndex];
                }
            }
            );
            
        
            
            tablebilhete.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void cadastrarFunc() {

        String registar = "insert into func(nome, naturalidade, morada, contacto, bi, cargo, perfil, senha, usuario) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            pst = conexao.prepareStatement(registar);

            pst.setString(1, camponome.getText());
            pst.setString(2, String.valueOf(cbnat.getSelectedItem()));
            pst.setString(3, campomor.getText());
            pst.setString(4, campocont.getText());
            pst.setString(5, campobi.getText());
            pst.setString(6, String.valueOf(cbcargo.getSelectedItem()));
            pst.setString(7, String.valueOf(cbperfil.getSelectedItem()));
            pst.setString(8, campopass.getText());
            pst.setString(9, campouser.getText());

            if (camponome.getText().isEmpty() || campocont.getText().isEmpty() || campopass.getText().isEmpty() || campouser.getText().isEmpty() || campobi.getText().isEmpty() || campomor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "PREENCHA OS CAMPOS OBRIGATÓRIOS");

            } else {
                int cadastrar = JOptionPane.showConfirmDialog(rootPane, "CADASTRAR NOVO FUNCIONÁRIO?", "Funcionário", JOptionPane.YES_NO_OPTION);
                if (cadastrar == JOptionPane.YES_OPTION) {
                    int cadastro = pst.executeUpdate();
                    if (cadastro > 0) {
                        JOptionPane.showMessageDialog(null, "FUNCIONÁRIO CADASTRADO COM SUCESSO");

                        listarFunc();

                    } else {
                        JOptionPane.showMessageDialog(null, "FALHA AO CADASTRAR NOVO FUNCIONARIO");
                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void alterarFunc() {

        String actualizar = "update func set nome = ?, naturalidade = ?, morada = ?, contacto = ?, bi = ?, cargo = ?, perfil = ?, senha = ?, usuario = ? where id = ?";
        
        /*nome, naturalidade, morada, contacto, bi, cargo, perfil, senha, usuario*/
        try {

            pst = conexao.prepareStatement(actualizar);

            pst.setString(1, camponome.getText());
            pst.setString(2, String.valueOf(cbnat.getSelectedItem()));
            pst.setString(3, campomor.getText());
            pst.setString(4, campocont.getText());
            pst.setString(5, campobi.getText());
            pst.setString(6, String.valueOf(cbcargo.getSelectedItem()));
            pst.setString(7, String.valueOf(cbperfil.getSelectedItem()));
            pst.setString(8, campopass.getText());
            pst.setString(9, campouser.getText());
            
            pst.setString(10, campocod.getText());
            
            if (camponome.getText().isEmpty() || campocont.getText().isEmpty() || campopass.getText().isEmpty() || campouser.getText().isEmpty() || campobi.getText().isEmpty() || campomor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "PREENCHA OS CAMPOS OBRIGATÓRIOS");

            } else {
                int confirmacao = JOptionPane.showConfirmDialog(rootPane, "ALTERAR DADOS?", "FUNCIONARIO", JOptionPane.YES_NO_OPTION);

                if (confirmacao == JOptionPane.YES_OPTION) {
                    int alterar = pst.executeUpdate();

                    if (alterar > 0) {
                        JOptionPane.showMessageDialog(rootPane, "DADOS ALTERADOS COM SUCESSO!");

                        listarFunc();

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "FALHA AO ALTERAR DADOS!");

                    }
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    void limparFunc() {

        int limpar = JOptionPane.showConfirmDialog(rootPane, "LIMPAR CAMPOS?", "CAMPOS", JOptionPane.YES_OPTION);

        if (limpar == JOptionPane.YES_OPTION) {

            camponome.setText(null);
            campobi.setText(null);
            campocod.setText(null);
            campocont.setText("(+258)");
            cbcargo.setSelectedIndex(0);
            cbnat.setSelectedIndex(0);
            cbperfil.setSelectedIndex(0);
            campomor.setText(null);
            campopass.setText(null);
            campouser.setText(null);

        }

    }
    
    void eliminarFunc() {

        String eliminar = "delete from Func where id = ?";

        try {

            String id = campocod.getText();

            pst = conexao.prepareStatement(eliminar);

            pst.setString(1, id);

            int apagar = JOptionPane.showConfirmDialog(rootPane, "ELIMINAR?", "FUNCIONARIO", JOptionPane.YES_NO_OPTION);

            if (apagar == JOptionPane.YES_OPTION) {
                int apadago = pst.executeUpdate();

                if (apadago > 0) {
                    JOptionPane.showMessageDialog(rootPane, "DADOS ELIMINADOS COM SUCESSO!");

                    listarFunc();

                } else {
                    JOptionPane.showMessageDialog(rootPane, "FALHA NA ELIMINACAO!");

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
    }

    
    private void initComponents() {

        JFrame frame = new JFrame();
        frame.setSize(910, 710);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        JPanel painel = new JPanel();
        painel.setBackground(new Color(255, 255, 255));
        painel.setBounds(1, 1, 902, 680);
        painel.setLayout(null);

        JLabel llogo = new JLabel("=-= LOGOTIPO =-=");
        //JTextField llogo = new JTextField("=-= LOGOTIPO =-=");
        llogo.setBounds(5, 10, 892, 120);
        llogo.setHorizontalAlignment(JLabel.CENTER);
        llogo.setForeground(Color.BLACK);
        llogo.setFont(new Font("Stencil", Font.BOLD, 36));

        JSeparator jsep = new JSeparator();
        jsep.setBounds(10, 135, 882, 5);

        JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP);
        pane.setBounds(8, 145, 887, 530);

        /**
         * ************************************************************
         */
        /**
         * ************************************************************
         */
        //Painel 1 (Opcoes)
        JPanel pane1 = new JPanel();
        pane1.setLayout(null);

        JLabel llogof = new JLabel("=-= Dados do Funcionário =-=");
        llogof.setBounds(10, 10, 880, 30);
        llogof.setHorizontalAlignment(JLabel.CENTER);
        llogof.setForeground(Color.BLACK);
        llogof.setFont(new Font("Tahoma", Font.BOLD, 24));

        JSeparator jsep1 = new JSeparator();
        jsep1.setBounds(10, 60, 860, 5);

        Font fonte = new Font("Tahoma", Font.ITALIC, 16);
        Font fonte1 = new Font("Tahoma", Font.PLAIN, 15);

        JLabel label1 = new JLabel("CODIGO: ");
        label1.setBounds(40, 135, 140, 30);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setForeground(Color.BLACK);
        label1.setFont(fonte);

        JLabel label2 = new JLabel("NOME: ");
        label2.setBounds(40, 170, 140, 30);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setForeground(Color.BLACK);
        label2.setFont(fonte);

        JLabel label3 = new JLabel("NATURALIDADE: ");
        label3.setBounds(40, 205, 140, 30);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setForeground(Color.BLACK);
        label3.setFont(fonte);

        JLabel label4 = new JLabel("MORADA: ");
        label4.setBounds(40, 240, 140, 30);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label4.setForeground(Color.BLACK);
        label4.setFont(fonte);

        JLabel label5 = new JLabel("CONTACTO: ");
        label5.setBounds(40, 275, 140, 30);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label5.setForeground(Color.BLACK);
        label5.setFont(fonte);
        
        spane.setBounds(265, 75, 600, 160);
        
        campocod.setBounds(185, 135, 100, 30);
        campocod.setHorizontalAlignment(JLabel.CENTER);
        campocod.setForeground(Color.BLACK);
        campocod.setFont(fonte1);

        camponome.setBounds(185, 170, 250, 30);
        camponome.setHorizontalAlignment(JLabel.CENTER);
        camponome.setForeground(Color.BLACK);
        camponome.setFont(fonte1);

        cbnat.setBounds(185, 205, 250, 30);
        cbnat.setForeground(Color.BLACK);
        cbnat.setFont(fonte1);

        cbnat.addItem("Maputo");
        cbnat.addItem("Gaza");
        cbnat.addItem("Inhambane");
        cbnat.addItem("Sofala");
        cbnat.addItem("Manica");
        cbnat.addItem("Tete");
        cbnat.addItem("Zambezia");
        cbnat.addItem("Nampula");
        cbnat.addItem("Cabo Delgado");
        cbnat.addItem("Niassa");

        campomor.setBounds(185, 240, 250, 30);
        campomor.setHorizontalAlignment(JLabel.CENTER);
        campomor.setForeground(Color.BLACK);
        campomor.setFont(fonte1);

        campocont.setBounds(185, 275, 250, 30);
        campocont.setHorizontalAlignment(JLabel.CENTER);
        campocont.setForeground(Color.BLACK);
        campocont.setFont(fonte1);

        JLabel label6 = new JLabel("BI NR:");
        label6.setBounds(480, 135, 100, 30);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label6.setForeground(Color.BLACK);
        label6.setFont(fonte);

        campobi.setBounds(585, 135, 250, 30);
        campobi.setHorizontalAlignment(JLabel.CENTER);
        campobi.setForeground(Color.BLACK);
        campobi.setFont(fonte1);

        JLabel label7 = new JLabel("CARGO: ");
        label7.setBounds(480, 170, 100, 30);
        label7.setHorizontalAlignment(JLabel.CENTER);
        label7.setForeground(Color.BLACK);
        label7.setFont(fonte);

        cbcargo.setBounds(585, 170, 250, 30);
        cbcargo.setForeground(Color.BLACK);
        cbcargo.setFont(fonte1);
        cbcargo.addItem("Controle de cargas");
        cbcargo.addItem("Check-in Check-out");
        cbcargo.addItem("Venda de Bilhetes");

        JLabel label8 = new JLabel("PERFIL: ");
        label8.setBounds(480, 205, 100, 30);
        label8.setHorizontalAlignment(JLabel.CENTER);
        label8.setForeground(Color.BLACK);
        label8.setFont(fonte);

        cbperfil.setBounds(585, 205, 250, 30);
        cbperfil.setForeground(Color.BLACK);
        cbperfil.setFont(fonte1);
        cbperfil.addItem("Administrador");
        cbperfil.addItem("Funcionário");

        JLabel label10 = new JLabel("USUARIO: ");
        label10.setBounds(480, 240, 100, 30);
        label10.setHorizontalAlignment(JLabel.CENTER);
        label10.setForeground(Color.BLACK);
        label10.setFont(fonte);

        JLabel label9 = new JLabel("SENHA: ");
        label9.setBounds(480, 275, 100, 30);
        label9.setHorizontalAlignment(JLabel.CENTER);
        label9.setForeground(Color.BLACK);
        label9.setFont(fonte);

        campopass.setBounds(585, 275, 250, 30);
        campopass.setHorizontalAlignment(JLabel.CENTER);
        campopass.setForeground(Color.BLACK);
        campopass.setFont(fonte1);

        campouser.setBounds(585, 240, 250, 30);
        campouser.setHorizontalAlignment(JLabel.CENTER);
        campouser.setForeground(Color.BLACK);
        campouser.setFont(fonte1);

        JSeparator jsep2 = new JSeparator();
        jsep2.setBounds(10, 390, 860, 5);

        JButton bcad = new JButton("Cadastrar");
        bcad.setBounds(187, 415, 120, 40);
        bcad.setForeground(Color.BLACK);
        bcad.setFont(fonte);
        bcad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarFunc();
            }
        });

        JButton balt = new JButton("Alterar");
        balt.setBounds(322, 415, 120, 40);
        balt.setForeground(Color.BLACK);
        balt.setFont(fonte);
        balt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                alterarFunc();
            }
        });

        JButton bexc = new JButton("Excluir");
        bexc.setBounds(457, 415, 120, 40);
        bexc.setForeground(Color.BLACK);
        bexc.setFont(fonte);
        bexc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarFunc();
            }
        });

        JButton blimp = new JButton("Limpar");
        blimp.setBounds(592, 415, 120, 40);
        blimp.setForeground(Color.BLACK);
        blimp.setFont(fonte);
        blimp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                limparFunc();
            }
        });

        pane1.add(llogof);
        pane1.add(jsep1);
        pane1.add(jsep2);
        pane1.add(label1);
        pane1.add(label2);
        pane1.add(label3);
        pane1.add(label4);
        pane1.add(label5);
        pane1.add(label6);
        pane1.add(label7);
        pane1.add(label8);
        pane1.add(label9);
        pane1.add(label10);
        pane1.add(campocod);
        pane1.add(camponome);
        pane1.add(campomor);
        pane1.add(campocont);
        pane1.add(campopass);
        pane1.add(campouser);
        pane1.add(campobi);
        pane1.add(cbnat);
        pane1.add(cbperfil);
        pane1.add(cbcargo);
        pane1.add(balt);
        pane1.add(bcad);
        pane1.add(bexc);
        pane1.add(blimp);

        /**
         * ************************************************************
         */
        /**
         * ************************************************************
         */
        //Painel 2 (Lista)
        JPanel pane2 = new JPanel();
        pane2.setLayout(null);

        JLabel llogoL/*labelLogoLista*/ = new JLabel("=-= Lista de Funcionários =-=");
        llogoL.setBounds(10, 10, 880, 30);
        llogoL.setHorizontalAlignment(JLabel.CENTER);
        llogoL.setForeground(Color.BLACK);
        llogoL.setFont(new Font("Tahoma", Font.BOLD, 24));

        JSeparator jsep3 = new JSeparator();
        jsep3.setBounds(10, 60, 860, 5);

       
        table.setBounds(10, 85, 860, 370);

        pane2.add(llogoL);
        pane2.add(jsep3);
        pane2.add(table);

        /**
         * ************************************************************
         */
        /**
         * ************************************************************
         */
        //Painel 3 (Bilheteira)
        JPanel pane3 = new JPanel();
        pane3.setLayout(null);

        JLabel llogoB/*labelLogoBilhete*/ = new JLabel("=-= Dados do Bilhete =-=");
        llogoB.setBounds(10, 10, 880, 30);
        llogoB.setHorizontalAlignment(JLabel.CENTER);
        llogoB.setForeground(Color.BLACK);
        llogoB.setFont(new Font("Tahoma", Font.BOLD, 24));

        JSeparator jsep4 = new JSeparator();
        jsep4.setBounds(10, 60, 860, 5);

        JLabel lmapa = new JLabel("- MAPA -");
        lmapa.setBounds(50, 75, 150, 30);
        lmapa.setHorizontalAlignment(JLabel.CENTER);
        lmapa.setForeground(Color.BLACK);
        lmapa.setFont(new Font("Stencil", Font.BOLD, 22));

        JPanel mapa = new JPanel();
        mapa.setBackground(Color.LIGHT_GRAY);
        mapa.setBounds(10, 110, 230, 305);
        mapa.setLayout(null);

        JSeparator jsep7 = new JSeparator();
        jsep7.setBounds(112, 5, 5, 295);
        jsep7.setOrientation(JSeparator.VERTICAL);

        JSeparator jsep8 = new JSeparator();
        jsep8.setBounds(118, 5, 3, 295);
        jsep8.setOrientation(JSeparator.VERTICAL);

        
        Font fonte2 = new Font("Tahoma", Font.PLAIN, 10);

        toggle1.setBounds(126, 5, 45, 20);
        toggle1.setFont(fonte2);
        toggle1.setEnabled(false);

        toggle2.setBounds(178, 5, 45, 20);
        toggle2.setFont(fonte2);
        toggle2.setEnabled(false);

        toggle3.setBounds(126, 30, 45, 20);
        toggle3.setFont(fonte2);

        toggle4.setBounds(178, 30, 45, 20);
        toggle4.setFont(fonte2);

        toggle5.setBounds(126, 55, 45, 20);
        toggle5.setFont(fonte2);

        toggle6.setBounds(178, 55, 45, 20);
        toggle6.setFont(fonte2);

        toggle7.setBounds(126, 80, 45, 20);
        toggle7.setFont(fonte2);

        toggle8.setBounds(178, 80, 45, 20);
        toggle8.setFont(fonte2);

        toggle9.setBounds(126, 105, 45, 20);
        toggle9.setFont(fonte2);

        toggle10.setBounds(178, 105, 45, 20);
        toggle10.setFont(fonte2);

        toggle11.setBounds(126, 130, 45, 20);
        toggle11.setFont(fonte2);

        toggle12.setBounds(178, 130, 45, 20);
        toggle12.setFont(fonte2);

        toggle13.setBounds(126, 155, 45, 20);
        toggle13.setFont(fonte2);

        toggle14.setBounds(178, 155, 45, 20);
        toggle14.setFont(fonte2);

        toggle15.setBounds(126, 180, 45, 20);
        toggle15.setFont(fonte2);

        toggle16.setBounds(178, 180, 45, 20);
        toggle16.setFont(fonte2);

        toggle17.setBounds(126, 205, 45, 20);
        toggle17.setFont(fonte2);

        toggle18.setBounds(178, 205, 45, 20);
        toggle18.setFont(fonte2);

        toggle19.setBounds(126, 230, 45, 20);
        toggle19.setFont(fonte2);

        toggle20.setBounds(178, 230, 45, 20);
        toggle20.setFont(fonte2);

        toggle21.setBounds(126, 255, 45, 20);
        toggle21.setFont(fonte2);

        toggle22.setBounds(178, 255, 45, 20);
        toggle22.setFont(fonte2);

        toggle23.setBounds(126, 280, 45, 20);
        toggle23.setFont(fonte2);

        toggle24.setBounds(178, 280, 45, 20);
        toggle24.setFont(fonte2);

        toggle25.setBounds(7, 30, 45, 20);
        toggle25.setFont(fonte2);

        toggle26.setBounds(60, 30, 45, 20);
        toggle26.setFont(fonte2);

        toggle27.setBounds(7, 55, 45, 20);
        toggle27.setFont(fonte2);

        toggle28.setBounds(60, 55, 45, 20);
        toggle28.setFont(fonte2);

        toggle29.setBounds(7, 80, 45, 20);
        toggle29.setFont(fonte2);

        toggle30.setBounds(60, 80, 45, 20);
        toggle30.setFont(fonte2);

        toggle31.setBounds(7, 105, 45, 20);
        toggle31.setFont(fonte2);

        toggle32.setBounds(60, 105, 45, 20);
        toggle32.setFont(fonte2);

        toggle33.setBounds(7, 130, 45, 20);
        toggle33.setFont(fonte2);

        toggle34.setBounds(60, 130, 45, 20);
        toggle34.setFont(fonte2);

        toggle35.setBounds(7, 155, 45, 20);
        toggle35.setFont(fonte2);

        toggle36.setBounds(60, 155, 45, 20);
        toggle36.setFont(fonte2);

        toggle37.setBounds(7, 180, 45, 20);
        toggle37.setFont(fonte2);

        toggle38.setBounds(60, 180, 45, 20);
        toggle38.setFont(fonte2);

        toggle39.setBounds(7, 205, 45, 20);
        toggle39.setFont(fonte2);

        toggle40.setBounds(60, 205, 45, 20);
        toggle40.setFont(fonte2);

        toggle41.setBounds(7, 230, 45, 20);
        toggle41.setFont(fonte2);

        toggle42.setBounds(60, 230, 45, 20);
        toggle42.setFont(fonte2);

        toggle43.setBounds(7, 255, 45, 20);
        toggle43.setFont(fonte2);

        toggle44.setBounds(60, 255, 45, 20);
        toggle44.setFont(fonte2);

        JLabel wc = new JLabel("WC");
        wc.setBounds(7, 280, 96, 20);
        wc.setFont(fonte2);
        wc.setHorizontalAlignment(JLabel.CENTER);

        JSeparator jsep6 = new JSeparator();
        jsep6.setBounds(10, 430, 860, 5);

        mapa.add(jsep7);
        mapa.add(jsep8);
        mapa.add(wc);

        mapa.add(toggle1);
        mapa.add(toggle2);
        mapa.add(toggle3);
        mapa.add(toggle4);
        mapa.add(toggle5);
        mapa.add(toggle6);
        mapa.add(toggle7);
        mapa.add(toggle8);
        mapa.add(toggle9);
        mapa.add(toggle10);
        mapa.add(toggle11);
        mapa.add(toggle12);
        mapa.add(toggle13);
        mapa.add(toggle14);
        mapa.add(toggle15);
        mapa.add(toggle16);
        mapa.add(toggle17);
        mapa.add(toggle18);
        mapa.add(toggle19);
        mapa.add(toggle20);
        mapa.add(toggle21);
        mapa.add(toggle22);
        mapa.add(toggle23);
        mapa.add(toggle24);
        mapa.add(toggle25);
        mapa.add(toggle26);
        mapa.add(toggle27);
        mapa.add(toggle28);
        mapa.add(toggle29);
        mapa.add(toggle30);
        mapa.add(toggle31);
        mapa.add(toggle32);
        mapa.add(toggle33);
        mapa.add(toggle34);
        mapa.add(toggle35);
        mapa.add(toggle36);
        mapa.add(toggle37);
        mapa.add(toggle38);
        mapa.add(toggle39);
        mapa.add(toggle40);
        mapa.add(toggle41);
        mapa.add(toggle42);
        mapa.add(toggle43);
        mapa.add(toggle44);

        JSeparator jsep5 = new JSeparator();
        jsep5.setBounds(250, 75, 5, 340);
        jsep5.setOrientation(JSeparator.VERTICAL);

        

        Font fonte3 = new Font("Tahoma", Font.ITALIC, 14);

        JLabel label11 = new JLabel("DE: ");
        label11.setBounds(265, 245, 40, 30);
        label11.setHorizontalAlignment(JLabel.CENTER);
        label11.setForeground(Color.BLACK);
        label11.setFont(fonte3);

        cbpartida.setBounds(310, 245, 80, 30);
        cbpartida.setForeground(Color.BLACK);
        cbpartida.setFont(fonte1);

        cbpartida.addItem("Tete");

        JLabel label12 = new JLabel("PARA: ");
        label12.setBounds(395, 245, 60, 30);
        label12.setHorizontalAlignment(JLabel.CENTER);
        label12.setForeground(Color.BLACK);
        label12.setFont(fonte3);

        cbpara.setBounds(460, 245, 200, 30);
        cbpara.setForeground(Color.BLACK);
        cbpara.setFont(fonte1);

        cbpara.addItem("Niassa - 3600 Mzn");
        cbpara.addItem("Cabo Delgado - 3200 Mzn");
        cbpara.addItem("Nampula - 2900 Mzn");
        cbpara.addItem("Beira - 1600 Mzn");
        cbpara.addItem("Chimoio - 1000 Mzn");
        cbpara.addItem("Inhambane - 2800 Mzn");
        cbpara.addItem("Gaza - 2800 Mzn");
        cbpara.addItem("Maputo - 2800 Mzn");

        JLabel label13 = new JLabel("DATA: ");
        label13.setBounds(665, 245, 60, 30);
        label13.setHorizontalAlignment(JLabel.CENTER);
        label13.setForeground(Color.BLACK);
        label13.setFont(fonte3);
        
        js1.setBounds(730, 245, 40, 30);
        js1.setFont(fonte1);

        js2.setBounds(775, 245, 40, 30);
        js2.setFont(fonte1);

        js3.setBounds(820, 245, 50, 30);
        js3.setFont(fonte1);

        JLabel label14 = new JLabel("NOME:");
        label14.setBounds(265, 280, 115, 30);
        label14.setHorizontalAlignment(JLabel.CENTER);
        label14.setForeground(Color.BLACK);
        label14.setFont(fonte3);

        JLabel label15 = new JLabel("BI/PASSAPORTE:");
        label15.setBounds(265, 315, 115, 30);
        label15.setHorizontalAlignment(JLabel.CENTER);
        label15.setForeground(Color.BLACK);
        label15.setFont(fonte3);

        JLabel label16 = new JLabel("CONTACTO:");
        label16.setBounds(265, 350, 115, 30);
        label16.setHorizontalAlignment(JLabel.CENTER);
        label16.setForeground(Color.BLACK);
        label16.setFont(fonte3);

        JLabel label17 = new JLabel("CONTACTO ALt.:");
        label17.setBounds(265, 385, 115, 30);
        label17.setHorizontalAlignment(JLabel.CENTER);
        label17.setForeground(Color.BLACK);
        label17.setFont(fonte3);

        JLabel label18 = new JLabel("COBRADOR:");
        label18.setBounds(585, 280, 80, 30);
        label18.setHorizontalAlignment(JLabel.CENTER);
        label18.setForeground(Color.BLACK);
        label18.setFont(fonte3);

        JLabel label19 = new JLabel("CONTACTO:");
        label19.setBounds(585, 315, 80, 30);
        label19.setHorizontalAlignment(JLabel.CENTER);
        label19.setForeground(Color.BLACK);
        label19.setFont(fonte3);

        JLabel label20 = new JLabel("MATRICULA:");
        label20.setBounds(585, 350, 80, 30);
        label20.setHorizontalAlignment(JLabel.CENTER);
        label20.setForeground(Color.BLACK);
        label20.setFont(fonte3);

        JLabel label21 = new JLabel("ID VIAGEM:");
        label21.setBounds(585, 385, 80, 30);
        label21.setHorizontalAlignment(JLabel.CENTER);
        label21.setForeground(Color.BLACK);
        label21.setFont(fonte3);
        
        nomeB.setBounds(385, 280, 195, 30);
        nomeB.setHorizontalAlignment(JLabel.CENTER);
        nomeB.setForeground(Color.BLACK);
        nomeB.setFont(fonte1);

        
        biB.setBounds(385, 315, 195, 30);
        biB.setHorizontalAlignment(JLabel.CENTER);
        biB.setForeground(Color.BLACK);
        biB.setFont(fonte1);

        
        contactoB.setBounds(385, 350, 195, 30);
        contactoB.setHorizontalAlignment(JLabel.CENTER);
        contactoB.setForeground(Color.BLACK);
        contactoB.setFont(fonte1);

        contactoaltB.setBounds(385, 385, 195, 30);
        contactoaltB.setHorizontalAlignment(JLabel.CENTER);
        contactoaltB.setForeground(Color.BLACK);
        contactoaltB.setFont(fonte1);

        
        cobradorB.setBounds(670, 280, 195, 30);
        cobradorB.setHorizontalAlignment(JLabel.CENTER);
        cobradorB.setForeground(Color.BLACK);
        cobradorB.setFont(fonte1);

        
        contactocobB.setBounds(670, 315, 195, 30);
        contactocobB.setHorizontalAlignment(JLabel.CENTER);
        contactocobB.setForeground(Color.BLACK);
        contactocobB.setFont(fonte1);

        
        MatriculaB.setBounds(670, 350, 195, 30);
        MatriculaB.setHorizontalAlignment(JLabel.CENTER);
        MatriculaB.setForeground(Color.BLACK);
        MatriculaB.setFont(fonte1);

        idViagemB.setBounds(670, 385, 195, 30);
        idViagemB.setHorizontalAlignment(JLabel.CENTER);
        idViagemB.setForeground(Color.BLACK);
        idViagemB.setFont(fonte1);

        pane3.add(label11);
        pane3.add(label12);
        pane3.add(label13);
        pane3.add(label14);
        pane3.add(label15);
        pane3.add(label16);
        pane3.add(label17);
        pane3.add(label18);
        pane3.add(label19);
        pane3.add(label20);
        pane3.add(label21);

        pane3.add(cbpartida);
        pane3.add(cobradorB);
        pane3.add(contactocobB);
        pane3.add(MatriculaB);
        pane3.add(idViagemB);

        pane3.add(nomeB);
        pane3.add(biB);
        pane3.add(contactoB);
        pane3.add(contactoaltB);

        pane3.add(cbpara);

        pane3.add(js1);
        pane3.add(js2);
        pane3.add(js3);

        JButton bcadb = new JButton("Cadastrar");
        bcadb.setBounds(187, 445, 120, 40);
        bcadb.setForeground(Color.BLACK);
        bcadb.setFont(fonte);
        bcadb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                comprarBilhete();
            }
        });

        JButton baltb = new JButton("Alterar");
        baltb.setBounds(322, 445, 120, 40);
        baltb.setForeground(Color.BLACK);
        baltb.setFont(fonte);
        baltb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                alterarBilhete();
            }
        });

        JButton bexcb = new JButton("Excluir");
        bexcb.setBounds(457, 445, 120, 40);
        bexcb.setForeground(Color.BLACK);
        bexcb.setFont(fonte);
        bexcb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarBilhete();
            }
        });

        JButton blimpb = new JButton("Limpar");
        blimpb.setBounds(592, 445, 120, 40);
        blimpb.setForeground(Color.BLACK);
        blimpb.setFont(fonte);
        blimpb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                limparBilhete();
            }
        });

        pane3.add(bcadb);
        pane3.add(baltb);
        pane3.add(bexcb);
        pane3.add(blimpb);

        pane3.add(llogoB);
        pane3.add(jsep4);
        pane3.add(jsep5);
        pane3.add(jsep6);
        pane3.add(lmapa);
        pane3.add(mapa);
        pane3.add(spane);
        

        JTabbedPane pane1a = new JTabbedPane(JTabbedPane.TOP);
        pane1a.setBounds(1, 1, 880, 520);

        painel.add(llogo);
        painel.add(jsep);
        painel.add(pane);

        pane.add("FUNCIONARIOS", pane1a);
        pane.add("BILHETEIRA", pane3);

        pane1a.add("OPCOES", pane1);
        pane1a.add("ACESSAR LISTA", pane2);

        frame.add(painel);
    }
    
String[] cadeiras = new String[44];
    
void comprarBilhete() {

        String comprar = "insert into bilhete (nome, bi, contacto, contacto_alt, cadeira, cobrador, contacto_c, matricula, partida, chegada, data_partida) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String botao = "tb";
        int cont = 0;
        
        for (int i = 0; i <= 43; i++) {

            cadeiras[i] = botao + i;
            

        }
        

        if (toggle1.isSelected() == false && toggle2.isSelected() == false && toggle3.isSelected() == false && toggle4.isSelected() == false && toggle5.isSelected() == false && toggle6.isSelected() == false && toggle7.isSelected() == false && toggle8.isSelected() == false && toggle9.isSelected() == false && toggle10.isSelected() == false && toggle11.isSelected() == false && toggle12.isSelected() == false && toggle13.isSelected() == false && toggle14.isSelected() == false && toggle15.isSelected() == false && toggle16.isSelected() == false && toggle17.isSelected() == false && toggle18.isSelected() == false && toggle19.isSelected() == false && toggle20.isSelected() == false && toggle21.isSelected() == false && toggle22.isSelected() == false && toggle23.isSelected() == false && toggle24.isSelected() == false && toggle25.isSelected() == false && toggle26.isSelected() == false && toggle27.isSelected() == false && toggle28.isSelected() == false && toggle29.isSelected() == false && toggle30.isSelected() == false && toggle31.isSelected() == false && toggle32.isSelected() == false && toggle33.isSelected() == false && toggle34.isSelected() == false && toggle35.isSelected() == false && toggle36.isSelected() == false && toggle37.isSelected() == false && toggle38.isSelected() == false && toggle39.isSelected() == false && toggle40.isSelected() == false && toggle41.isSelected() == false && toggle42.isSelected() == false && toggle43.isSelected() == false && toggle44.isSelected() == false) {
            verCadeira = false;
        } else {
            verCadeira = true;
        }
        try {

            pst = conexao.prepareStatement(comprar);

            pst.setString(1, nomeB.getText());
            pst.setString(2, biB.getText());
            pst.setString(3, contactoB.getText());
            pst.setString(4, contactoaltB.getText());

            //pst.setString(5, jTextField6.getText());

            if (toggle1.isSelected()) {
                cadeira = "1";
            } else if (toggle2.isSelected()) {
                cadeira = "2";
            } else if (toggle3.isSelected()) {
                cadeira = "3";
            } else if (toggle4.isSelected()) {
                cadeira = "4";
            } else if (toggle5.isSelected()) {
                cadeira = "5";
            } else if (toggle6.isSelected()) {
                cadeira = "6";
            } else if (toggle7.isSelected()) {
                cadeira = "7";
            } else if (toggle8.isSelected()) {
                cadeira = "8";
            } else if (toggle9.isSelected()) {
                cadeira = "9";
            } else if (toggle10.isSelected()) {
                cadeira = "10";
            } else if (toggle11.isSelected()) {
                cadeira = "11";
            } else if (toggle12.isSelected()) {
                cadeira = "12";
            } else if (toggle13.isSelected()) {
                cadeira = "13";
            } else if (toggle14.isSelected()) {
                cadeira = "14";
            } else if (toggle15.isSelected()) {
                cadeira = "15";
            } else if (toggle16.isSelected()) {
                cadeira = "16";
            } else if (toggle17.isSelected()) {
                cadeira = "17";
            } else if (toggle18.isSelected()) {
                cadeira = "18";
            } else if (toggle19.isSelected()) {
                cadeira = "19";
            } else if (toggle20.isSelected()) {
                cadeira = "20";
            } else if (toggle21.isSelected()) {
                cadeira = "21";
            } else if (toggle22.isSelected()) {
                cadeira = "22";
            } else if (toggle23.isSelected()) {
                cadeira = "23";
            } else if (toggle24.isSelected()) {
                cadeira = "26";
            } else if (toggle25.isSelected()) {
                cadeira = "25";
            } else if (toggle26.isSelected()) {
                cadeira = "26";
            } else if (toggle27.isSelected()) {
                cadeira = "27";
            } else if (toggle28.isSelected()) {
                cadeira = "28";
            } else if (toggle29.isSelected()) {
                cadeira = "29";
            } else if (toggle30.isSelected()) {
                cadeira = "30";
            } else if (toggle31.isSelected()) {
                cadeira = "31";
            } else if (toggle32.isSelected()) {
                cadeira = "32";
            } else if (toggle33.isSelected()) {
                cadeira = "33";
            } else if (toggle34.isSelected()) {
                cadeira = "34";
            } else if (toggle35.isSelected()) {
                cadeira = "35";
            } else if (toggle36.isSelected()) {
                cadeira = "36";
            } else if (toggle37.isSelected()) {
                cadeira = "37";
            } else if (toggle38.isSelected()) {
                cadeira = "38";
            } else if (toggle39.isSelected()) {
                cadeira = "39";
            } else if (toggle40.isSelected()) {
                cadeira = "40";
            } else if (toggle41.isSelected()) {
                cadeira = "37";
            } else if (toggle42.isSelected()) {
                cadeira = "38";
            } else if (toggle43.isSelected()) {
                cadeira = "39";
            } else if (toggle44.isSelected()) {
                cadeira = "40";
            }

            pst.setString(5, cadeira);
            pst.setString(6, cobradorB.getText());
            pst.setString(7, contactocobB.getText());
            pst.setString(8, MatriculaB.getText());
            pst.setString(9, cbpartida.getSelectedItem().toString());
            pst.setString(10, cbpara.getSelectedItem().toString());
            pst.setString(11, js1.getValue().toString() + "-" + js2.getValue().toString() + "-" + js3.getValue().toString());

            if (nomeB.getText().isEmpty() || biB.getText().isEmpty() || contactoB.getText().isEmpty() || cobradorB.getText().isEmpty() || MatriculaB.getText().isEmpty() || contactoaltB.getText().isEmpty() || contactocobB.getText().isEmpty() || verCadeira == false) {

                JOptionPane.showMessageDialog(rootPane, "PREENCHA TODOS OS CAMPOS (e escolha o assunto), POR FAVOR");

            } else {
                int cmprar = JOptionPane.showConfirmDialog(rootPane, "COMPRAR BILHETE?", "BILHETE", JOptionPane.YES_OPTION);

                if (cmprar == JOptionPane.YES_OPTION) {

                    String ver = "select nome, cadeira from bilhete where cadeira = ? and partida = ? and chegada = ? and data_partida = ?";

                    try {

                        pst1 = conexao.prepareStatement(ver);

                        pst1.setString(1, cadeira);
                        pst1.setString(2, cbpartida.getSelectedItem().toString());
                        pst1.setString(3, cbpara.getSelectedItem().toString());
                        pst1.setString(4, js1.getValue().toString() + "-" + js2.getValue().toString() + "-" + js3.getValue().toString());

                        rs = pst1.executeQuery();
                        
                        if (rs.next()) {
                            
                            JOptionPane.showMessageDialog(rootPane, "CADEIRA OCUPADA OU INDISPONIVEL");
                            
                        }else{
                            
                           
                                int comprado = pst.executeUpdate();

                                if (comprado > 0) {

                                    JOptionPane.showMessageDialog(rootPane, "BILHETE COMPRADO");
                                    listarBilhete();
                                    limparBilhete();

                                }
                            
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, e);
                    }

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

void alterarBilhete(){
        
        String alterar = "update bilhete set nome = ?, bi = ?, contacto = ?, contacto_alt = ?, cadeira = ?, cobrador = ?, contacto_c = ?, matricula = ?, partida = ?, chegada = ?, data_partida = ? where id = ?";
        
        if (toggle1.isSelected() == false && toggle2.isSelected() == false && toggle3.isSelected() == false && toggle4.isSelected() == false && toggle5.isSelected() == false && toggle6.isSelected() == false && toggle7.isSelected() == false && toggle8.isSelected() == false && toggle9.isSelected() == false && toggle10.isSelected() == false && toggle11.isSelected() == false && toggle12.isSelected() == false && toggle13.isSelected() == false && toggle14.isSelected() == false && toggle15.isSelected() == false && toggle16.isSelected() == false && toggle17.isSelected() == false && toggle18.isSelected() == false && toggle19.isSelected() == false && toggle20.isSelected() == false && toggle21.isSelected() == false && toggle22.isSelected() == false && toggle23.isSelected() == false && toggle24.isSelected() == false && toggle25.isSelected() == false && toggle26.isSelected() == false && toggle27.isSelected() == false && toggle28.isSelected() == false && toggle29.isSelected() == false && toggle30.isSelected() == false && toggle31.isSelected() == false && toggle32.isSelected() == false && toggle33.isSelected() == false && toggle34.isSelected() == false && toggle35.isSelected() == false && toggle36.isSelected() == false && toggle37.isSelected() == false && toggle38.isSelected() == false && toggle39.isSelected() == false && toggle40.isSelected() == false && toggle41.isSelected() == false && toggle42.isSelected() == false && toggle43.isSelected() == false && toggle44.isSelected() == false) {
            verCadeira = false;
        } else {
            verCadeira = true;
        }
        
        try {
            
            pst = conexao.prepareStatement(alterar);
            
            pst.setString(1, nomeB.getText());
            pst.setString(2, biB.getText());
            pst.setString(3, contactoB.getText());
            pst.setString(4, contactoaltB.getText());

            //pst.setString(5, jTextField6.getText());

            if (toggle1.isSelected()) {
                cadeira = "1";
            } else if (toggle2.isSelected()) {
                cadeira = "2";
            } else if (toggle3.isSelected()) {
                cadeira = "3";
            } else if (toggle4.isSelected()) {
                cadeira = "4";
            } else if (toggle5.isSelected()) {
                cadeira = "5";
            } else if (toggle6.isSelected()) {
                cadeira = "6";
            } else if (toggle7.isSelected()) {
                cadeira = "7";
            } else if (toggle8.isSelected()) {
                cadeira = "8";
            } else if (toggle9.isSelected()) {
                cadeira = "9";
            } else if (toggle10.isSelected()) {
                cadeira = "10";
            } else if (toggle11.isSelected()) {
                cadeira = "11";
            } else if (toggle12.isSelected()) {
                cadeira = "12";
            } else if (toggle13.isSelected()) {
                cadeira = "13";
            } else if (toggle14.isSelected()) {
                cadeira = "14";
            } else if (toggle15.isSelected()) {
                cadeira = "15";
            } else if (toggle16.isSelected()) {
                cadeira = "16";
            } else if (toggle17.isSelected()) {
                cadeira = "17";
            } else if (toggle18.isSelected()) {
                cadeira = "18";
            } else if (toggle19.isSelected()) {
                cadeira = "19";
            } else if (toggle20.isSelected()) {
                cadeira = "20";
            } else if (toggle21.isSelected()) {
                cadeira = "21";
            } else if (toggle22.isSelected()) {
                cadeira = "22";
            } else if (toggle23.isSelected()) {
                cadeira = "23";
            } else if (toggle24.isSelected()) {
                cadeira = "26";
            } else if (toggle25.isSelected()) {
                cadeira = "25";
            } else if (toggle26.isSelected()) {
                cadeira = "26";
            } else if (toggle27.isSelected()) {
                cadeira = "27";
            } else if (toggle28.isSelected()) {
                cadeira = "28";
            } else if (toggle29.isSelected()) {
                cadeira = "29";
            } else if (toggle30.isSelected()) {
                cadeira = "30";
            } else if (toggle31.isSelected()) {
                cadeira = "31";
            } else if (toggle32.isSelected()) {
                cadeira = "32";
            } else if (toggle33.isSelected()) {
                cadeira = "33";
            } else if (toggle34.isSelected()) {
                cadeira = "34";
            } else if (toggle35.isSelected()) {
                cadeira = "35";
            } else if (toggle36.isSelected()) {
                cadeira = "36";
            } else if (toggle37.isSelected()) {
                cadeira = "37";
            } else if (toggle38.isSelected()) {
                cadeira = "38";
            } else if (toggle39.isSelected()) {
                cadeira = "39";
            } else if (toggle40.isSelected()) {
                cadeira = "40";
            } else if (toggle41.isSelected()) {
                cadeira = "37";
            } else if (toggle42.isSelected()) {
                cadeira = "38";
            } else if (toggle43.isSelected()) {
                cadeira = "39";
            } else if (toggle44.isSelected()) {
                cadeira = "40";
            }

            pst.setString(5, cadeira);
            pst.setString(6, cobradorB.getText());
            pst.setString(7, contactocobB.getText());
            pst.setString(8, MatriculaB.getText());
            pst.setString(9, cbpartida.getSelectedItem().toString());
            pst.setString(10, cbpara.getSelectedItem().toString());
            pst.setString(11, js1.getValue().toString() + "-" + js2.getValue().toString() + "-" + js3.getValue().toString());

            pst.setString(12, idViagemB.getText());
            
            
            if (nomeB.getText().isEmpty() || biB.getText().isEmpty() || contactoB.getText().isEmpty() || cobradorB.getText().isEmpty() || MatriculaB.getText().isEmpty() || contactoaltB.getText().isEmpty() || contactocobB.getText().isEmpty() || verCadeira == false) {

                JOptionPane.showMessageDialog(rootPane, "PREENCHA TODOS OS CAMPOS (e escolha o assunto), POR FAVOR");

            }  else{
                int alter = JOptionPane.showConfirmDialog(rootPane, "ALTERAR BILHETE?", "BILHETE", JOptionPane.YES_OPTION);

                if (alter == JOptionPane.YES_OPTION){
                    
                    String ver = "select nome, cadeira from bilhete where cadeira = ? and partida = ? and chegada = ? and data_partida = ?";

                    try {

                        pst1 = conexao.prepareStatement(ver);

                        pst1.setString(1, cadeira);
                        pst1.setString(2, cbpartida.getSelectedItem().toString());
                        pst1.setString(3, cbpara.getSelectedItem().toString());
                        pst1.setString(4, js1.getValue().toString() + "-" + js2.getValue().toString() + "-" + js3.getValue().toString());

                        rs = pst1.executeQuery();
                        
                        if (rs.next()) {
                            
                            JOptionPane.showMessageDialog(rootPane, "CADEIRA OCUPADA OU INDISPONIVEL");
                            
                        }else{
                           
                                int comprado = pst.executeUpdate();

                                if (comprado > 0) {

                                    JOptionPane.showMessageDialog(rootPane, "BILHETE ALTERADO");
                                    listarBilhete();
                                    limparBilhete();

                                }
                            
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, e);
                    }
                    
                }
            }
            
        } catch (Exception e) {
        
            JOptionPane.showMessageDialog(rootPane, e);
        
        }
        
        
    }
    
    void limparBilhete() {

        nomeB.setText(null);
        biB.setText(null);
        idViagemB.setText(null);
        contactoB.setText(null);
        contactoaltB.setText(null);
        contactocobB.setText(null);
        cobradorB.setText(null);
        MatriculaB.setText(null);
      
    }

    void eliminarBilhete() {

        String eliminar = "delete from bilhete where id = ?";

        try {

            String id = idViagemB.getText();

            pst = conexao.prepareStatement(eliminar);

            pst.setString(1, id);

            int apagar = JOptionPane.showConfirmDialog(rootPane, "ELIMINAR?", "BILHETE", JOptionPane.YES_NO_OPTION);

            if (apagar == JOptionPane.YES_OPTION) {
                int apadago = pst.executeUpdate();

                if (apadago > 0) {
                    JOptionPane.showMessageDialog(rootPane, "BILHETE ELIMINADO!");

                    listarBilhete();

                } else {
                    JOptionPane.showMessageDialog(rootPane, "FALHA NA ELIMINACAO!");

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
    }
    
        
    private static boolean verCadeira;
    private static String cadeira;
    
    public static void main(String[] args) {

        new Main();

    }

}
