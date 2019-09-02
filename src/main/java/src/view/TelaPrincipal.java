/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.view;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import src.controller.TabuleiroController;
import src.model.Observador;
import src.model.TabuleiroVelha;

/**
 *
 * @author gabriel
 */
public class TelaPrincipal extends javax.swing.JFrame implements Observador {

    int tamanhoTabuleiro;
    final private TabuleiroController controle;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        controle = TabuleiroController.getInstance();
        controle.addObservador(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanelTabuleiro = new javax.swing.JPanel();
        jButtonComecar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha - IA");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1024, 1100));
        setMinimumSize(new java.awt.Dimension(1024, 580));
        setName("framePrincipal"); // NOI18N
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("Jogo da Velha");
        jPanel1.add(jLabelTitle);
        jPanel1.add(jSeparator1);
        jPanelTabuleiro.setBackground(new java.awt.Color(214, 217, 223));
        jPanelTabuleiro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));

        jButtonComecar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonComecar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonComecar.setForeground(new java.awt.Color(204, 204, 204));
        jButtonComecar.setText("Começar!");
        jButtonComecar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonComecar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComecarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonComecar)
                                .addGap(440, 440, 440))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonComecar)
                                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelTabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(439, 439, 439)
                                .addComponent(jButtonComecar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(431, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelTabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonComecar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, javax.swing.GroupLayout.DEFAULT_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>   

    private void jButtonComecarActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.backgroundTabuleiro == null) {
            montaContainerTabuleiro();
        } else {
            jPanelTabuleiro.remove(backgroundTabuleiro);
            montaContainerTabuleiro();
        }

    }

    public void montaContainerTabuleiro() {

        tamanhoTabuleiro = Integer.parseInt(JOptionPane.showInputDialog("Qual a dimensão do tabuleiro?\n Digite:\n                3 ~> (3x3)\n                ou até\n                15 ~> (15x15)"));
        if (tamanhoTabuleiro < 3 || tamanhoTabuleiro > 15) {
            tamanhoTabuleiro = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor igual ou entre 3 a 15"));
        }
        controle.iniciar(tamanhoTabuleiro);
        tabuleiro = configuraTabuleiro(tamanhoTabuleiro);

        backgroundTabuleiro = new JPanel();

        // Layout backgroundTabuleiro
        javax.swing.GroupLayout jPanelbackgroundTabuleiroLayout = new javax.swing.GroupLayout(backgroundTabuleiro);
        backgroundTabuleiro.setLayout(jPanelbackgroundTabuleiroLayout);
        jPanelbackgroundTabuleiroLayout.setHorizontalGroup(
                jPanelbackgroundTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(tabuleiro)
        );
        jPanelbackgroundTabuleiroLayout.setVerticalGroup(
                jPanelbackgroundTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(tabuleiro)
        );
        this.setMaximumSize(new Dimension((int) tabuleiro.getMaximumSize().getWidth(), (int) tabuleiro.getMaximumSize().getHeight() + 30));
        backgroundTabuleiro.setBorder(BorderFactory.createEmptyBorder(0, 300, 0, 0));
        //Layout jPanelTabuleiro
        javax.swing.GroupLayout jPanelTabuleiroLayout = new javax.swing.GroupLayout(jPanelTabuleiro);
        jPanelTabuleiro.setLayout(jPanelTabuleiroLayout);
        jPanelTabuleiroLayout.setHorizontalGroup(
                jPanelTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(backgroundTabuleiro)
        );
        jPanelTabuleiroLayout.setVerticalGroup(
                jPanelTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(backgroundTabuleiro)
        );

        this.repaint();
        jPanel3.repaint();
    }

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    public JTable configuraTabuleiro(int tamanhoTabuleiro) {

        int tamanhoCelula = 130;
        JTable jTtabuleiro = new JTable();
        TabuleiroVelha configTabuleiro = new TabuleiroVelha(tamanhoTabuleiro);
        jTtabuleiro.setModel(configTabuleiro);

        if (tamanhoTabuleiro == 4) {
            tamanhoCelula = 100;
        } else if (tamanhoTabuleiro == 5) {
            tamanhoCelula = 80;
        } else if (tamanhoTabuleiro == 6) {
            tamanhoCelula = 65;
        } else if (tamanhoTabuleiro > 6 && tamanhoTabuleiro < 9) {
            tamanhoCelula = 50;
        } else if (tamanhoTabuleiro > 8 && tamanhoTabuleiro < 11) {
            tamanhoCelula = 40;
        } else if (tamanhoTabuleiro == 11) {
            tamanhoCelula = 35;
        } else if (tamanhoTabuleiro > 11) {
            tamanhoCelula = 30;
        }else if (tamanhoTabuleiro > 12) {
            tamanhoCelula = 2;
        }

        for (int x = 0; x < jTtabuleiro.getColumnModel().getColumnCount(); x++) {
            jTtabuleiro.getColumnModel().getColumn(x).setWidth(tamanhoCelula);
            jTtabuleiro.getColumnModel().getColumn(x).setMinWidth(tamanhoCelula);
            jTtabuleiro.getColumnModel().getColumn(x).setMaxWidth(tamanhoCelula);
        }
        jTtabuleiro.setRowHeight(tamanhoCelula);
        jTtabuleiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTtabuleiro.setShowGrid(true);
        jTtabuleiro.setDefaultRenderer(String.class, configTabuleiro.getTabuleiroRender());
        jTtabuleiro.setCellSelectionEnabled(true);
        jTtabuleiro.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent m) {
                int row = jTtabuleiro.getSelectedRow();
                int col = jTtabuleiro.getSelectedColumn();
                
                try {
                    //controle.selecionarCasa(row, col);
                    controle.selecionarCasaModoAI(row, col);
                } catch (Exception ex) {
                    System.out.println("Msg de erro seleção: " + ex.getMessage());

                }
            }

            @Override
            public void mouseClicked(MouseEvent me) {

            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }

        });

        return jTtabuleiro;
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonComecar;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTabuleiro;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private JTable tabuleiro;
    JPanel backgroundTabuleiro = new JPanel();
    // End of variables declaration   

    public String[][] toMatriz(JTable tabuleiro) {
        String[][] matrizTabuleiro = new String[tamanhoTabuleiro][tamanhoTabuleiro];
        for (int i = 0; i < tamanhoTabuleiro; i++) {
            for (int j = 0; j < tamanhoTabuleiro; j++) {
                matrizTabuleiro[i][j] = (String) tabuleiro.getModel().getValueAt(i, j);
            }
        }
        return matrizTabuleiro;
    }

    @Override
    public void atualizarTela() {
        this.repaint();
        this.backgroundTabuleiro.repaint();
        this.jPanel3.repaint();
        this.jPanel2.repaint();
        this.jPanel1.repaint();
        this.jPanelTabuleiro.repaint();
    }

    @Override
    public void terminarJogo(String vencedor) {
        
        JOptionPane.showMessageDialog(rootPane, "Terminou o jogo!\n"+ (!vencedor.equals("empate") ? "Jogador "+vencedor.trim()+"\nVenceu!" : "Empate!"));
    }

}
