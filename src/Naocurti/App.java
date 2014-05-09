package Naocurti;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author husbeh@gmail.com
 * 
 */

public class App {

	public static void main(String[] args) throws SQLException {

	/*	UsuarioDao e = new UsuarioDao();

		e.conectar();

		try {
			Usuario retorno = e.encontraUsuario(1);
			System.out.println("Retorno: " + retorno);
			System.out.println("Nome: " + retorno.getNome());

		

		} catch (Exception ex) {
			System.out.println("Informação não encontrada.");

		}  */
		
		MulticastSocket socket = null;

        try{
            InetAddress grupo = InetAddress.getByName("228.5.6.7");
            socket = new MulticastSocket(6789);
            socket.joinGroup(grupo);
            byte[] msg = JOptionPane.showInputDialog("Digite a mensagem: ").getBytes();
            DatagramPacket mensagemOut = new DatagramPacket(msg, msg.length,grupo, 6789);
            socket.send(mensagemOut);

            for(int i=0;i<10;i++)
            {
                byte[] buffer = new byte[1000];
                DatagramPacket mensagemIn = new DatagramPacket(buffer, buffer.length);
                
                socket.receive(mensagemIn);
                System.out.println("Recebido de "+InetAddress.getByAddress(mensagemIn.getAddress().getAddress())
                        +" a mensagem: "+new String(mensagemIn.getData()));
            }
            socket.leaveGroup(grupo);
        }catch(SocketException se){System.out.println("Problema no Socket: "+se.getMessage());
        }catch(IOException ie){System.out.println("Problema no I/O: "+ie.getMessage());
        }finally{if(socket!=null) socket.close();
        
		}
	}  

}