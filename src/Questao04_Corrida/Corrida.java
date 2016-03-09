package Questao04_Corrida;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luan Medeiros
 */
public class Corrida implements Runnable {
    private int tempoVoltas = 0;
    private Thread carroThread;
    private Carro carroObjeto;


    public Corrida(Thread carroThread, Carro carroObjeto)
    {        

        this.carroThread = carroThread;
        this.carroObjeto = carroObjeto;
    }
    

    @Override
    public void run(){
      acelera(carroThread, carroObjeto);
    }
    public void acelera(Thread carroThread, Carro carroObjeto)
    {                  
        tempoVoltas = 0;                        
        for(int j = 0; j < 65; j++)
        {

            int sono = (int)(Math.random() * 1000);
            tempoVoltas += sono;              
            carroObjeto.getCarro().setLocation(carroObjeto.getCarro().getLocation().x+13, carroObjeto.getCarro().getLocation().y+0);
            
            try {                  
                Thread.sleep((int)(Math.random() * sono));
            } catch (InterruptedException ex) {
                Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }             
        carroObjeto.setTempoVoltas(tempoVoltas);
    }     
}


    
    
 
