/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao03_Cara_Coroa;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Luan Medeiros
 */
public class Tela extends javax.swing.JFrame implements ActionListener {

    private final String commandEnter = "ENTER";
    private javax.swing.JPanel jContentPane = null;
    private javax.swing.JTextField jTextField = null;
    private Action pressEnter;
    private String diretorioString = "";
    private Moeda moeda;
    private ImageIcon cara;
    private ImageIcon coroa;
    private Jogada lancaCoroa;
    private Jogada lancaCara;
    private Thread lancaCoroaThread;
    private Thread lancaCaraThread;
//Path path = Paths.get(diretorioString+"processos.txt");
    /** Creates new form Moeda */
    public Tela() {
        diretorioString = System.getProperty("user.dir");
        diretorioString = diretorioString.replace("\\", "/");
        diretorioString += "/src/Questao03_Cara_Coroa/";
        cara = new javax.swing.ImageIcon(diretorioString+"Cara.png");
        coroa = new javax.swing.ImageIcon(diretorioString+"Coroa.png");
        
        System.out.println(diretorioString);
        initComponents();
        pressEnter = new AbstractAction(commandEnter) {
            public void actionPerformed(ActionEvent e) {

            lancaCaraThread.stop();
            lancaCoroaThread.stop();

            COROA.setEnabled(true);
            CARA.setEnabled(true);
            jogar.setEnabled(true);

            if(moeda.getPalpite().equalsIgnoreCase(moeda.getFaceAtualString())) resultado.setText("ACERTOU MIZERAVI!!!!");                       
            else resultado.setText("ERROU MIZERAVI!!!!");            

                
            }
        };
        /* Guarda a condição - sem isso não funciona */
        int cond = JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
        /* Cria KeyStrokes para F1 e F2 */
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        /* Guarda o RootPane */
        JRootPane rootPane = getRootPane();
        /* Modo obsoleto */
        rootPane.registerKeyboardAction(this, enter, cond);
        /* Modo recomendado */
        rootPane.getInputMap(cond).put(enter, commandEnter);
        rootPane.getActionMap().put(commandEnter, pressEnter);
        /* Inicialização da JFrame */
        initialize();
        moedaLabel.setIcon(cara);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        COROA = new javax.swing.JRadioButton();
        CARA = new javax.swing.JRadioButton();
        moedaLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jogar = new javax.swing.JButton();
        resultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CARA OU COROA");
        setSize(new java.awt.Dimension(500, 500));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(COROA);
        COROA.setText("COROA");

        buttonGroup1.add(CARA);
        CARA.setText("CARA");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PALPITE");

        jogar.setText("JOGAR MOEDA");
        jogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jogarActionPerformed(evt);
            }
        });

        resultado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CARA)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(COROA)
                                    .addComponent(jogar))
                                .addGap(65, 65, 65)
                                .addComponent(moedaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CARA, COROA});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CARA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(COROA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jogar)
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(moedaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CARA, COROA});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jogarActionPerformed

        resultado.setText("");
        if(COROA.isSelected())
        {   resultado.setText("PRESSIONE ENTER PARA PARAR");            
            jogar.setEnabled(false);
            COROA.setEnabled(false);
            CARA.setEnabled(false);
            jPanel1.requestFocus();
            moeda = new Moeda(coroa, cara, "COROA");
            lancaCoroa = new Jogada(moeda, moedaLabel, coroa, "COROA");
            lancaCara = new Jogada(moeda, moedaLabel, cara, "CARA");
            lancaCaraThread = new Thread(lancaCara);
            lancaCoroaThread = new Thread(lancaCoroa);
            lancaCaraThread.start();
            lancaCoroaThread.start();            
            
        }
        else if(CARA.isSelected())
        {
            resultado.setText("PRESSIONE ENTER PARA PARAR");
            jogar.setEnabled(false);
            COROA.setEnabled(false);
            CARA.setEnabled(false);
            jPanel1.requestFocus();
            moeda = new Moeda(coroa, cara, "CARA");
            lancaCoroa = new Jogada(moeda, moedaLabel, coroa, "COROA");
            lancaCara = new Jogada(moeda, moedaLabel, cara, "CARA");
            lancaCaraThread = new Thread(lancaCara);
            lancaCoroaThread = new Thread(lancaCoroa);
            lancaCaraThread.start();
            lancaCoroaThread.start();
        }
    }//GEN-LAST:event_jogarActionPerformed

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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CARA;
    private javax.swing.JRadioButton COROA;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jogar;
    private javax.swing.JLabel moedaLabel;
    private javax.swing.JLabel resultado;
    // End of variables declaration//GEN-END:variables

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    ///////////////////////////// CAPTURANDO ENTER /////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        System.out.println("TESTANDO");
        if (key.equals(commandEnter))
        {

        }
    }

    private void initialize() {
        this.pack();
        this.setSize(650, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(getjPanel1());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
