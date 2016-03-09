/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao01_Eco;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Luan Medeiros
 */

public class TrataCliente extends Thread {
	private Socket clienteSocket;
        private String ipServidor;
	private BufferedReader input;
        
	public TrataCliente(Socket clientSocket, String ipServidor) {
		this.clienteSocket = clientSocket;
                this.ipServidor = ipServidor;
		try {
			input = new BufferedReader(new InputStreamReader(this.clienteSocket
					.getInputStream()));
		} catch (IOException e) {
			System.out.println("## ERRO: Ao acessar streams de entrada e saida do cliente ##");
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		String mensagem = null ;
		while(true && !clienteSocket.isClosed()) {	
			try {
				mensagem = input.readLine() ;
			} catch (IOException e) {
				System.out.println("## ERRO: Ao ler mensagem do cliente ##");
				e.printStackTrace();
			}
			if (mensagem != null) {				                                                  
                            try {           
                                DataInputStream in = new DataInputStream(clienteSocket.getInputStream());                                
                                DataOutputStream out = new DataOutputStream(clienteSocket.getOutputStream());
                                out.writeUTF(ipServidor+" responde: "+mensagem+"\n");// retornando mensagem
                                in.close();
                                out.close();            
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }	
			}
		}
	}
}