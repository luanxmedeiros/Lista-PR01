/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao05_Votacao;

import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan Medeiros
 */
public class Servidor {
public static ArrayList<Candidato> candidatos = new ArrayList<>();
public static int start = 0;
public static ServerSocket serverSocket;
public static Socket clienteSocket;

    public static void main(String[] args) throws Exception {
        if(start == 0 )
        {
        candidatos = new ArrayList<>();        
        candidatos.add(new Candidato("BRANCO", "BRANCO"));
        candidatos.add(new Candidato("NULO", "NULO"));        
        candidatos.add(new Candidato("Deadpool", "10"));
        candidatos.add(new Candidato("Givanaldo", "11"));
        candidatos.add(new Candidato("Galego", "12"));  
        candidatos.add(new Candidato("Caio Zumba", "18"));
        candidatos.add(new Candidato("Bruno", "21"));
        candidatos.add(new Candidato("Tiririca", "22"));        
        candidatos.add(new Candidato("Claudivan", "24"));
        candidatos.add(new Candidato("Carlos Cavalinho", "30"));
        candidatos.add(new Candidato("Monic", "31"));        
        candidatos.add(new Candidato("Gidário", "42"));
        candidatos.add(new Candidato("Matador", "47"));
        candidatos.add(new Candidato("Bacatela", "51"));

        start = 1;
        }
        
        //Conexão TCP
        serverSocket = new ServerSocket(3005);                              
        clienteSocket = serverSocket.accept();
        ObjectOutputStream out = new ObjectOutputStream(clienteSocket.getOutputStream());        
        out.writeObject(candidatos);       
        out.close(); 
        clienteSocket.close();        
        
       

        String voto = "";
        //Conexão UDP
        try {
            DatagramSocket socket = new DatagramSocket(2000);
            byte[] buffer = new byte[1024];
            while (true) {
                boolean achou = false;
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
                socket.receive(pacote);
                voto = new String(pacote.getData(), 0, pacote.getLength());
                if(voto.equals("BRANCO"))
                {
                    candidatos.get(0).incremtentaVoto();
                    achou = true;
                }
                else
                {
                    for(Candidato candidato : candidatos)
                    {
                        if(candidato.getNumero().equals(voto))
                        {
                            candidato.incremtentaVoto();
                            achou = true;
                            break;
                        }
                    }
                }
                if (achou==false) 
                {
                    candidatos.get(1).incremtentaVoto();
                }
                achou = false;
                //MOSTRANDO TODOS OS VOTOS
               String todosVotos = candidatos.toString();                
               todosVotos = todosVotos.replace("[", "").replace("]", "").replace(",", "");                
               JOptionPane.showMessageDialog(null,"<html>"+todosVotos+"</html>", "RESULTADO PARCIAL", 0);                
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
