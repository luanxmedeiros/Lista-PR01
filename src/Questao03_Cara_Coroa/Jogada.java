/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao03_Cara_Coroa;

import Questao03_Cara_Coroa.Moeda;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Luan Medeiros
 */
public class Jogada implements Runnable {

    
    private Moeda moedaObjeto;
    private JLabel moedaLabel;
    private ImageIcon faceImagem;   
    private String faceString = "CARA"; 


    public Jogada(Moeda moedaObjeto, JLabel moedaLabel, ImageIcon faceImagem, String faceString) {
        this.moedaObjeto = moedaObjeto;
        this.moedaLabel = moedaLabel;
        this.faceImagem = faceImagem;
        this.faceString = faceString;        
    }
    

    @Override
    public void run(){
      giraMoeda(moedaObjeto, moedaLabel, faceImagem, faceString);
    }
    public void giraMoeda(Moeda moedaObjeto, JLabel moedaLabel, ImageIcon faceImagem, String faceString){                  
            while(true)
            {
                moedaLabel.setIcon(faceImagem);            
                moedaObjeto.setFaceAtualString(faceString);          
                try {                  
                    Thread.sleep((int)(Math.random() * 30));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jogada.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }    


    
    
    
}
