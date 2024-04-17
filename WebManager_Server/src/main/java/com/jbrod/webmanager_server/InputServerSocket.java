
package com.jbrod.webmanager_server;
import com.jbrod.webmanager_server.analyzer.Analyzer;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbravo
 */
public class InputServerSocket implements Runnable{

    private ServerSocket inputSocket;
    private Analyzer analyzer; 
    
    public InputServerSocket(String ip, int port, Analyzer analyzer){
        //Crear el hilo     
        Thread parseListener = new Thread(this);
        this.analyzer = analyzer; 

       try {
           //Crear el socket de escucha
            inputSocket = new ServerSocket(port);
            
        } catch (IOException ex) {
            Logger.getLogger(InputServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       parseListener.run();
        
        
    }
    
    @Override
    public void run() {
        
        //Ciclo para escuchar
        while(true){

            try {
                
                Socket input = inputSocket.accept();
                DataInputStream in_str = new DataInputStream(input.getInputStream());
                String entrada = in_str.readUTF();
                
                System.out.println("\n\n\n\n\n\n");
                System.out.println("Se recibio: ");
                System.out.println(entrada);
                //Pasar la entrada al analizador
                analyzer.analyze(entrada);
                
                
            } catch (IOException ex) {
                Logger.getLogger(InputServerSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
        
}
