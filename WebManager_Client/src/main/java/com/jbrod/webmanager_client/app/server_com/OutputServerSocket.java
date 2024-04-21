
package com.jbrod.webmanager_client.app.server_com;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Clase que realiza la salida de datos desde el cliente hacia el server.
 * @author jbravo
 */
public class OutputServerSocket {

    private String ip; 
    private int port; 

    /**
     * Construye un objeto de tipo OtputServerSocket, el cual permite realizar una comunicacion de salida con un servidor.
     * @param ip : String con la direccion ip donde esta el serciror.
     * @param port : int con el puerto que tendra abierto el sevidor para comunicacion.
     */
    public OutputServerSocket(String ip, int port){
        this.ip = ip;
        this.port = port; 
    }


    /**
     * Metodo que realiza una comunicación de salida con el servidor.
     * @param message : String con el mensaje que se enviara al servidor.
     */
    public void sendMessage(String message){
        Socket comSocket;
        try {
            comSocket = new Socket(ip, port);
            DataOutputStream outputStream = new DataOutputStream(comSocket.getOutputStream());
            outputStream.writeUTF(message);
            outputStream.close(); 
        } catch (IOException ex) {
            System.out.println("Hubo un problema al realizar la comunicacion.");
        }
        
    }
}
