/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao05_Votacao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 *
 * @author Luan Medeiros
 */
public class Temporizador implements Runnable {
    private JLabel numero1;
    private JLabel numero2;
    private JLabel fotoCandidato;
    private JLabel nomeCandidato;
    private ArrayList<JButton> botoes;

    public Temporizador(JLabel numero1, JLabel numero2, JLabel fotoCandidato, JLabel nomeCandidato, ArrayList<JButton> botoes) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.fotoCandidato = fotoCandidato;
        this.nomeCandidato = nomeCandidato;
        this.botoes = botoes;
    }
   
    
    @Override    
    public void run() {
        atualizaLabels(fotoCandidato, numero1, numero2, nomeCandidato, botoes);
    }
    
    public void atualizaLabels(JLabel fotoCandidato, JLabel numero1, JLabel numero2, JLabel nomeCandidato, ArrayList<JButton> botoes)
    {
        try {
            Thread.sleep(2000);
            botoes.stream().forEach((botao) -> {
                botao.setEnabled(true);
            });
            numero1.setVisible(true);
            numero2.setVisible(true);
            nomeCandidato.setText("");            
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }    
}
