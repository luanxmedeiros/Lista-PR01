/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao01_Eco;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luan Medeiros
 */
public class Servidor {
private ServerSocket serverSocket ;
	public void iniciaServidor() 
        {
            String ipServidor;
            try {
                ipServidor = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException ex) {
                ipServidor = "127.0.0.1";
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try 
            {                    
                serverSocket = new ServerSocket(3005);
                System.out.printf("Servidor escutando porta: %d \n", 3005);
                while (true)
                {
                    new TrataCliente(serverSocket.accept(), ipServidor).start();
                    //serverSocket.getInetAddress().getHostAddress()).start()
                }
            } catch (IOException e) {
                    System.out.println("## ERRO: Ao escutar porata 3005");
                    e.printStackTrace();
            }
	}
	public static void main(String args[]) {
		Servidor servidor = new Servidor() ;
		servidor.iniciaServidor() ;
	}
}
