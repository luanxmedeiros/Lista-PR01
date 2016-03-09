/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao03_Cara_Coroa;

import javax.swing.ImageIcon;

/**
 *
 * @author Luan Medeiros
 */
public class Moeda {
    private String palpite;
    private String faceAtualString;
    private ImageIcon coroa;
    private ImageIcon cara;
    private ImageIcon faceAtualImagem;

    public Moeda(ImageIcon coroa, ImageIcon cara, String palpite) {

        this.coroa = coroa;
        this.cara = cara;
        this.faceAtualImagem = cara;
        this.palpite = palpite;
    }

    public String getPalpite() {
        return palpite;
    }

    public void setPalpite(String palpite) {
        this.palpite = palpite;
    }

    public String getFaceAtualString() {
        return faceAtualString;
    }

    public void setFaceAtualString(String faceAtualString) {
        this.faceAtualString = faceAtualString;
    }

    public ImageIcon getCoroa() {
        return coroa;
    }

    public void setCoroa(ImageIcon coroa) {
        this.coroa = coroa;
    }

    public ImageIcon getCara() {
        return cara;
    }

    public void setCara(ImageIcon cara) {
        this.cara = cara;
    }

    public ImageIcon getFaceAtualImagem() {
        return faceAtualImagem;
    }

    public void setFaceAtualImagem(ImageIcon faceAtualImagem) {
        this.faceAtualImagem = faceAtualImagem;
    }



    




    
    
}
