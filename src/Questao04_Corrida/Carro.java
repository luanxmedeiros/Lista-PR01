/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao04_Corrida;

import javax.swing.JLabel;

/**
 *
 * @author Luan Medeiros
 */
public class Carro {
    private String nomePiloto;
    private JLabel carro;
    private int tempoVoltas = 0;

    public Carro(String nomePiloto, JLabel carro) {
        this.nomePiloto = nomePiloto;
        this.carro = carro;
    }

    public String getNomePiloto() {
        return nomePiloto;
    }

    public JLabel getCarro() {
        return carro;
    }

    public void setTempoVoltas(int tempoVoltas) {
        this.tempoVoltas = tempoVoltas;
    }

    public int getTempoVoltas() {
        return tempoVoltas;
    }
    
    
    
    
    
    
}
