
package com.jbrod.webmanager_client.app;

import com.jbrod.webmanager_client.ui.XmlView;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Clase que permite la comunicacion servidor -> app.
 * @author jbravo
 */
public class InputServerSocket implements Runnable{
    
    private ServerSocket inputSocket;
    private XmlView xmlView;
    
    
    
    public InputServerSocket(String ip, int port){
        //Crear el hilo     
        Thread parseListener = new Thread(this);

       try {
           //Crear el socket de escucha
            inputSocket = new ServerSocket(port);
            
        } catch (IOException ex) {
            //Manejar la excepcion
            ex.printStackTrace();
        }
    }
    
    
    public void setXmlView(XmlView view){
        this.xmlView = view; 
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
                
                //Pasar la entrada a la vista xml que hizo la solicitud
                if(xmlView != null){
                    xmlView.setServerResponse(entrada);
                }
                
                
            } catch (IOException ex) {
                //Manejar la excepcion
            }
        }
        
    }
    
}
