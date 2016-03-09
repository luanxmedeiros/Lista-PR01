/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao04_Corrida;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Luan Medeiros
 */
public class ChecaThreads implements Runnable {

          
    private JLabel vencedor;
    private Thread carro2;
    private Thread carro1;
    private Carro carroObjeto1;
    private Carro carroObjeto2;

        public ChecaThreads(JLabel vencedor, Thread carro2, Thread carro1, Carro carroObjeto1, Carro carroObjeto2) {
            this.vencedor = vencedor;
            this.carro2 = carro2;
            this.carro1 = carro1;
            this.carroObjeto1 = carroObjeto1;
            this.carroObjeto2 = carroObjeto2;
        }

    @Override
    public void run(){
      checaThreads(vencedor, carro2, carro1, carroObjeto1, carroObjeto2);
    }
    
    public void checaThreads(JLabel vencedor, Thread carro1, Thread carro2, Carro carroObjeto1, Carro carroObjeto2){                  
            while(true)
            {
                if(carro1.isAlive() == false && carro2.isAlive() == false)
                {
                    System.out.println(carroObjeto1.getNomePiloto()+" gastou "+carroObjeto1.getTempoVoltas());
                    System.out.println(carroObjeto2.getNomePiloto()+" gastou "+carroObjeto2.getTempoVoltas());
                    if(carroObjeto1.getTempoVoltas() < carroObjeto2.getTempoVoltas())
                        vencedor.setText(carroObjeto1.getNomePiloto()+" ganhou a corrida!!");
                    else if(carroObjeto1.getTempoVoltas() > carroObjeto2.getTempoVoltas())
                    {
                        vencedor.setText(carroObjeto2.getNomePiloto()+" ganhou a corrida!!");
                    }
                    else
                    {
                        vencedor.setText(carroObjeto2.getNomePiloto()+" e "+carroObjeto1.getNomePiloto()+" empataram!!");
                    }
                    break; 
                }
            }

    }

}


    
    
 

