
package com.jbrod.webmanager_server;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbravo
 */
public class InputServerSocket implements Runnable {

    ServerSocket inputSocket; 
    
    public InputServerSocket(int ip, int port){
        //Crear el hilo     
        Thread parseListener = new Thread(this);

       try {
           //Crear el socket de escucha
            inputSocket = new ServerSocket(port);
            
        } catch (IOException ex) {
            Logger.getLogger(InputServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    @Override
    public void run() {
        
        //Ciclo para escuchar
        while(true){

            try {
                
                Socket input = inputSocket.accept();
                DataInputStream in_str = new DataInputStream(input.getInputStream());
                String entrada = in_str.readUTF();
                //Pasar la entrada al analizador
                
                
            } catch (IOException ex) {
                Logger.getLogger(InputServerSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
        
}