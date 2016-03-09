/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao05_Votacao;

import static Questao05_Votacao.Servidor.candidatos;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Luan Medeiros
 */
public class Urna extends javax.swing.JFrame {
    private String diretorioString = "";
    private ImageIcon tiririca;
    private ImageIcon deadpool;
    private String voto = "";
    private Temporizador temporizador;
    private Thread temporizadoT;
    ArrayList<Candidato> candidatos =  new ArrayList<>();
    ArrayList<JButton> botoes =  new ArrayList<>();
    
    
    /** Creates new form Urna */
    
    public void desabilitaBotoes()
    {
        botoes.stream().forEach((botao) -> {
        botao.setEnabled(false);                        
        });
    }
    public void votar(String valor)
    {
        if(temporizadoT.isAlive() == false)
        {
            if(valor.equalsIgnoreCase("BRANCO") && voto.equals(""))
            {
                voto = "BRANCO";
                numero1.setText("");
                numero2.setText("");
                fotoCandidato.setIcon(null);
                nomeCandidato.setText("VOTO BRANCO");
            }
            else if(numero1.getText().equals("") && voto.equals(""))
            {
                voto += valor;
                numero1.setText(valor);
            }
            else if(!numero1.getText().equals("") && numero2.getText().equals("") && voto.length() == 1)
            {
                voto += valor;
                numero2.setText(valor);
                String votoString = "VOTO NULO";
                for(Candidato candidato : candidatos)
                {
                    if(candidato.getNumero().equals(voto))
                    {
                        votoString = candidato.getNome();
                        fotoCandidato.setIcon(new javax.swing.ImageIcon(diretorioString+votoString+".png"));
                        break;
                    }
                }
                    nomeCandidato.setText(votoString);
            }
        }
    }
    
    public void confirmaVoto() throws UnknownHostException, IOException
    {   
        if(voto.length() == 2 || voto == "BRANCO")
        {            
            desabilitaBotoes();
            temporizadoT.start();
            DatagramSocket socketCliente = new DatagramSocket();
            byte[] votoBytes;
            votoBytes = voto.getBytes();
            int tamanho = votoBytes.length;
            InetAddress host = InetAddress.getByName("127.0.0.1");
            DatagramPacket dataGramCliente = new DatagramPacket(votoBytes, tamanho, host, 2000);
            socketCliente.send(dataGramCliente);
            numero1.setText("");
            numero2.setText("");
            numero1.setVisible(false);
            numero2.setVisible(false);            
            voto = "";
            fotoCandidato.setIcon(null);
            nomeCandidato.setText("FIM");                        
        }
    }
    public Urna() throws ClassNotFoundException, IOException {
        diretorioString = System.getProperty("user.dir");
        diretorioString = diretorioString.replace("\\", "/");
        diretorioString += "/src/Questao05_Votacao/";
        tiririca = new javax.swing.ImageIcon(diretorioString+"tiririca.png");
        deadpool = new javax.swing.ImageIcon(diretorioString+"deadpool.png");
        initComponents();
        temporizador = new Temporizador(numero1, numero2, fotoCandidato, nomeCandidato, botoes);
        temporizadoT = new Thread(temporizador);
        botoes.add(zero);
        botoes.add(um);
        botoes.add(dois);
        botoes.add(tres);
        botoes.add(quatro);
        botoes.add(cinco);
        botoes.add(seis);
        botoes.add(sete);
        botoes.add(oito);
        botoes.add(nove);
        botoes.add(branco);
        botoes.add(confirma);
        botoes.add(corrige);
        
        ////// Pegando os candidatos através do socket
        Socket clienteSocket = null; // Socket que irá pegar os candidatos do servidor
        ObjectInputStream in = null;
        try {
            clienteSocket = new Socket("127.0.0.1", 3005);
        } catch (IOException ex) {
            Logger.getLogger(Urna.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {                                                                    
            in = new ObjectInputStream(clienteSocket.getInputStream());
            candidatos = (ArrayList<Candidato>) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Urna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Urna.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        in.close();
        clienteSocket.close();
        System.out.println(candidatos.toString());        
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Urna = new javax.swing.JPanel();
        painelTeclado = new javax.swing.JPanel();
        branco = new javax.swing.JButton();
        confirma = new javax.swing.JButton();
        corrige = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        sete = new javax.swing.JButton();
        oito = new javax.swing.JButton();
        nove = new javax.swing.JButton();
        quatro = new javax.swing.JButton();
        cinco = new javax.swing.JButton();
        seis = new javax.swing.JButton();
        um = new javax.swing.JButton();
        dois = new javax.swing.JButton();
        tres = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        visor = new javax.swing.JPanel();
        numero1 = new javax.swing.JLabel();
        numero2 = new javax.swing.JLabel();
        nomeCandidato = new javax.swing.JLabel();
        fotoCandidato = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        Urna.setBackground(new java.awt.Color(255, 255, 255));

        painelTeclado.setBackground(new java.awt.Color(0, 0, 0));

        branco.setBackground(new java.awt.Color(255, 255, 255));
        branco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        branco.setText("BRANCO");
        branco.setRequestFocusEnabled(false);
        branco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brancoActionPerformed(evt);
            }
        });

        confirma.setBackground(new java.awt.Color(0, 204, 51));
        confirma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        confirma.setText("CONFIRMA");
        confirma.setRequestFocusEnabled(false);
        confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaActionPerformed(evt);
            }
        });

        corrige.setBackground(new java.awt.Color(255, 51, 0));
        corrige.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        corrige.setText("CORRIGE");
        corrige.setRequestFocusEnabled(false);
        corrige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corrigeActionPerformed(evt);
            }
        });

        zero.setBackground(new java.awt.Color(0, 0, 0));
        zero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        zero.setForeground(new java.awt.Color(255, 255, 255));
        zero.setText("0");
        zero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        zero.setOpaque(false);
        zero.setRolloverEnabled(false);
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });

        sete.setBackground(new java.awt.Color(0, 0, 0));
        sete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sete.setForeground(new java.awt.Color(255, 255, 255));
        sete.setText("7");
        sete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sete.setOpaque(false);
        sete.setRolloverEnabled(false);
        sete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seteActionPerformed(evt);
            }
        });

        oito.setBackground(new java.awt.Color(0, 0, 0));
        oito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oito.setForeground(new java.awt.Color(255, 255, 255));
        oito.setText("8");
        oito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oito.setOpaque(false);
        oito.setRolloverEnabled(false);
        oito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oitoActionPerformed(evt);
            }
        });

        nove.setBackground(new java.awt.Color(0, 0, 0));
        nove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nove.setForeground(new java.awt.Color(255, 255, 255));
        nove.setText("9");
        nove.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nove.setOpaque(false);
        nove.setRolloverEnabled(false);
        nove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noveActionPerformed(evt);
            }
        });

        quatro.setBackground(new java.awt.Color(0, 0, 0));
        quatro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quatro.setForeground(new java.awt.Color(255, 255, 255));
        quatro.setText("4");
        quatro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        quatro.setOpaque(false);
        quatro.setRolloverEnabled(false);
        quatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quatroActionPerformed(evt);
            }
        });

        cinco.setBackground(new java.awt.Color(0, 0, 0));
        cinco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cinco.setForeground(new java.awt.Color(255, 255, 255));
        cinco.setText("5");
        cinco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cinco.setOpaque(false);
        cinco.setRolloverEnabled(false);
        cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cincoActionPerformed(evt);
            }
        });

        seis.setBackground(new java.awt.Color(0, 0, 0));
        seis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        seis.setForeground(new java.awt.Color(255, 255, 255));
        seis.setText("6");
        seis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        seis.setOpaque(false);
        seis.setRolloverEnabled(false);
        seis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seisActionPerformed(evt);
            }
        });

        um.setBackground(new java.awt.Color(0, 0, 0));
        um.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        um.setForeground(new java.awt.Color(255, 255, 255));
        um.setText("1");
        um.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        um.setOpaque(false);
        um.setRolloverEnabled(false);
        um.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umActionPerformed(evt);
            }
        });

        dois.setBackground(new java.awt.Color(0, 0, 0));
        dois.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dois.setForeground(new java.awt.Color(255, 255, 255));
        dois.setText("2");
        dois.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dois.setOpaque(false);
        dois.setRolloverEnabled(false);
        dois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doisActionPerformed(evt);
            }
        });

        tres.setBackground(new java.awt.Color(0, 0, 0));
        tres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tres.setForeground(new java.awt.Color(255, 255, 255));
        tres.setText("3");
        tres.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tres.setOpaque(false);
        tres.setRolloverEnabled(false);
        tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelTecladoLayout = new javax.swing.GroupLayout(painelTeclado);
        painelTeclado.setLayout(painelTecladoLayout);
        painelTecladoLayout.setHorizontalGroup(
            painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTecladoLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTecladoLayout.createSequentialGroup()
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTecladoLayout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(branco, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(corrige, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirma))
                    .addGroup(painelTecladoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelTecladoLayout.createSequentialGroup()
                                .addComponent(um, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dois, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(painelTecladoLayout.createSequentialGroup()
                                    .addComponent(quatro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cinco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(seis, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painelTecladoLayout.createSequentialGroup()
                                    .addComponent(sete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(oito, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(nove, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelTecladoLayout.setVerticalGroup(
            painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTecladoLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(um, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dois, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quatro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cinco, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seis, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oito, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nove, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(branco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(corrige, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("<html>  JUSTIÇA <br>ELEITORAL<html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        visor.setBackground(new java.awt.Color(153, 255, 255));
        visor.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        visor.setRequestFocusEnabled(false);

        numero1.setBackground(new java.awt.Color(255, 255, 255));
        numero1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        numero1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numero1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        numero2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        numero2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numero2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nomeCandidato.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nomeCandidato.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout visorLayout = new javax.swing.GroupLayout(visor);
        visor.setLayout(visorLayout);
        visorLayout.setHorizontalGroup(
            visorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(visorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(visorLayout.createSequentialGroup()
                        .addComponent(numero1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(numero2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nomeCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(fotoCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        visorLayout.setVerticalGroup(
            visorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(visorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(visorLayout.createSequentialGroup()
                        .addGroup(visorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numero1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numero2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(nomeCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fotoCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout UrnaLayout = new javax.swing.GroupLayout(Urna);
        Urna.setLayout(UrnaLayout);
        UrnaLayout.setHorizontalGroup(
            UrnaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UrnaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UrnaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UrnaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(painelTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UrnaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)))
                .addContainerGap())
        );
        UrnaLayout.setVerticalGroup(
            UrnaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UrnaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UrnaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UrnaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelTeclado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(visor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Urna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Urna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brancoActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("BRANCO");
        }        
    }//GEN-LAST:event_brancoActionPerformed

    private void corrigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corrigeActionPerformed
        voto = "";
        numero1.setVisible(true);
        numero1.setText("");
        numero2.setText("");
        nomeCandidato.setText("");
        fotoCandidato.setIcon(null);
    }//GEN-LAST:event_corrigeActionPerformed

    private void confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaActionPerformed
        

////////////////////////////////////////////////////////////////////////
        temporizadoT = new Thread(temporizador);
        if(temporizadoT.isAlive() == false)
        {            
            try {
                confirmaVoto();                
            } catch (IOException ex) {
                Logger.getLogger(Urna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_confirmaActionPerformed

    private void umActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("1");
        }
    }//GEN-LAST:event_umActionPerformed

    private void doisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doisActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("2");
        }
    }//GEN-LAST:event_doisActionPerformed

    private void tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("3");
        }
    }//GEN-LAST:event_tresActionPerformed

    private void quatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quatroActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("4");
        }
    }//GEN-LAST:event_quatroActionPerformed

    private void cincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cincoActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("5");
        }
    }//GEN-LAST:event_cincoActionPerformed

    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("0");
        }        
    }//GEN-LAST:event_zeroActionPerformed

    private void seteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seteActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("7");
        }      
    }//GEN-LAST:event_seteActionPerformed

    private void oitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oitoActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("8");
        }      
    }//GEN-LAST:event_oitoActionPerformed

    private void noveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noveActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("9");
        }      
    }//GEN-LAST:event_noveActionPerformed

    private void seisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seisActionPerformed
        if(temporizadoT.isAlive() == false)
        {
            votar("6");
        }      
    }//GEN-LAST:event_seisActionPerformed

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
            java.util.logging.Logger.getLogger(Urna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Urna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Urna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Urna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Urna().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Urna.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Urna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Urna;
    private javax.swing.JButton branco;
    private javax.swing.JButton cinco;
    private javax.swing.JButton confirma;
    private javax.swing.JButton corrige;
    private javax.swing.JButton dois;
    private javax.swing.JLabel fotoCandidato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nomeCandidato;
    private javax.swing.JButton nove;
    private javax.swing.JLabel numero1;
    private javax.swing.JLabel numero2;
    private javax.swing.JButton oito;
    private javax.swing.JPanel painelTeclado;
    private javax.swing.JButton quatro;
    private javax.swing.JButton seis;
    private javax.swing.JButton sete;
    private javax.swing.JButton tres;
    private javax.swing.JButton um;
    private javax.swing.JPanel visor;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables
}
