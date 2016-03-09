/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao04_Corrida;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Luan Medeiros
 */
public class Pista extends javax.swing.JFrame {
    private String diretorioString = "";
    private ImageIcon ferrari;
    private ImageIcon mercedes;
    private ImageIcon chegada;
    private int posXFerrari = 0;
    private int posYFerrari = 0;
    private int posXMercedes = 0;
    private int posYMercedes = 0;
    private Carro carroFerrari;
    private Carro carroMercedes;
    private Thread corridaFelipeT;
    private Thread corridaLewisT;
    private Thread checadorT;
    private Corrida corridaFelipe;
    private Corrida corridaLewis;
    private ChecaThreads checador;


    /** Creates new form Pista */
    public Pista() {
        diretorioString = System.getProperty("user.dir");
        diretorioString = diretorioString.replace("\\", "/");
        diretorioString += "/src/Questao04_Corrida/";
        ferrari = new javax.swing.ImageIcon(diretorioString+"Ferrari.png");
        mercedes = new javax.swing.ImageIcon(diretorioString+"Mercede.png");
        chegada = new javax.swing.ImageIcon(diretorioString+"Chegada02.png");
        ImageIcon evento = new javax.swing.ImageIcon(diretorioString+"hot.png");
        initComponents();
        ferrariLabel.setIcon(ferrari);
        hotW.setIcon(evento);
        mercedesLabel.setIcon(mercedes);
        chegadaLabel.setIcon(chegada);
        posXFerrari = ferrariLabel.getLocation().x;
        posYFerrari = ferrariLabel.getLocation().y;
        posXMercedes = mercedesLabel.getLocation().x;
        posYMercedes = mercedesLabel.getLocation().y;
        carroFerrari = new Carro("Felipe Massa", ferrariLabel);
        carroMercedes = new Carro("Craudivan Silva", mercedesLabel);
        corridaFelipe = new Corrida(corridaLewisT ,carroFerrari);  
        corridaLewis = new Corrida(corridaFelipeT,carroMercedes);
        corridaFelipeT = new Thread(corridaLewis);
        corridaLewisT = new Thread(corridaFelipe);         
        this.setLocationRelativeTo(null);
    }

   
        public void iniciarThreads() throws InterruptedException
    {
        
       // corridaFelipe = new Corrida(labelVencedor, corridaLewisT ,carroFerrari);  
       // corridaLewis = new Corrida(labelVencedor, corridaFelipeT,carroMercedes);
        checador = new ChecaThreads(labelVencedor, corridaFelipeT, corridaLewisT, carroFerrari, carroMercedes);
       // checadorT =  new Thread(checador);     
        
       
       corridaFelipeT.join();
        corridaLewisT.join();
        corridaLewisT.start();
        corridaFelipeT.start();
       checadorT = new Thread(new Runnable() {
            public void run() {
                checaThreads(labelVencedor, corridaFelipeT, corridaLewisT, carroFerrari, carroMercedes);
            }

            private void checaThreads(JLabel vencedor, Thread carro1, Thread carro2, Carro carroObjeto1, Carro carroObjeto2) {
                while (true) {
                    if (carro1.isAlive() == false && carro2.isAlive() == false) {
                        System.out.println(carroObjeto1.getNomePiloto() + " gastou " + carroObjeto1.getTempoVoltas());
                        System.out.println(carroObjeto2.getNomePiloto() + " gastou " + carroObjeto2.getTempoVoltas());
                        if (carroObjeto1.getTempoVoltas() < carroObjeto2.getTempoVoltas()) {
                            vencedor.setText(carroObjeto1.getNomePiloto() + " ganhou a corrida!!");
                        } else if (carroObjeto1.getTempoVoltas() > carroObjeto2.getTempoVoltas()) {
                            vencedor.setText(carroObjeto2.getNomePiloto() + " ganhou a corrida!!");
                        } else {
                            vencedor.setText(carroObjeto2.getNomePiloto() + " e " + carroObjeto1.getNomePiloto() + " empataram!!");
                        }
                        break;
                    }
                }
            }
        });        
        checadorT.start();        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pista = new javax.swing.JPanel();
        mercedesLabel = new javax.swing.JLabel();
        ferrariLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        chegadaLabel = new javax.swing.JLabel();
        labelVencedor = new javax.swing.JLabel();
        hotW = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Corrida");
        setResizable(false);

        Pista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pista.setToolTipText("");
        Pista.setName("Oi"); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("INICIAR CORRIDA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelVencedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelVencedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVencedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PistaLayout = new javax.swing.GroupLayout(Pista);
        Pista.setLayout(PistaLayout);
        PistaLayout.setHorizontalGroup(
            PistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PistaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(PistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ferrariLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PistaLayout.createSequentialGroup()
                        .addGroup(PistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hotW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelVencedor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mercedesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addComponent(chegadaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        PistaLayout.setVerticalGroup(
            PistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hotW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelVencedor, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PistaLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(ferrariLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(mercedesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(132, Short.MAX_VALUE))
                    .addComponent(chegadaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(!labelVencedor.getText().equals(""))
      {
        corridaFelipeT = new Thread(corridaLewis);
        corridaLewisT = new Thread(corridaFelipe);
      }
      if(corridaFelipeT.isAlive() == false && corridaLewisT.isAlive() == false){
        labelVencedor.setText("");
        try {        
            iniciarThreads();
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Pista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pista;
    private javax.swing.JLabel chegadaLabel;
    private javax.swing.JLabel ferrariLabel;
    private javax.swing.JLabel hotW;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelVencedor;
    private javax.swing.JLabel mercedesLabel;
    // End of variables declaration//GEN-END:variables
}
