/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao05_Votacao;

import java.io.Serializable;

/**
 *
 * @author Luan Medeiros
 */
public class Candidato implements Serializable{
    private String nome;
    private String numero;
    private int votos = 0;

    public Candidato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }
    
    public void incremtentaVoto()
    {
        votos++;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public int getVotos() {
        return votos;
    }

    @Override
    public String toString() {
        return "Candidato: " + "Nome = " + nome + " - Número = " + numero + " - Votos = " + votos + "<br>";
        
    }


   
}
