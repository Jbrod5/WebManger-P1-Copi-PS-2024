/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jbrod.webmanager_client;

import com.jbrod.webmanager_client.app.server_com.InputServerSocket;
import com.jbrod.webmanager_client.app.server_com.OutputServerSocket;
import com.jbrod.webmanager_client.ui.Mainframe;
import java.util.Scanner;

/**
 *
 * @author jbravo
 */
public class WebManager_Client {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int outPort = 0;
        int inPort = 0; 
        String ip = ""; 
        String op = "";
        boolean pass = false;
    
        //Obtener el puerto de salida
        while(!pass){ 
            try{
                System.out.println("Ingrese el puerto de comunicacion de salida.");
                op = scanner.nextLine();
                outPort = Integer.parseInt(op);
                pass = true;
            }catch(NumberFormatException nfe){
                System.out.println("El valor ingresado no es un numero, intentelo de nuevo.");
                pass = false; 
            }
        }
        
        //Obtener la direccion IP: hostname -I
        do {
            System.out.print("Ingrese la dirección IP para la comunicacion: ");
            ip = scanner.nextLine();
        } while (!isValidIpAddress(ip));
        
        //Obtener el puerto de entrada
        pass = false; 
        while(!pass){ 
            try{
                System.out.println("Ingrese el puerto de comunicacion de entrada.");
                op = scanner.nextLine();
                inPort = Integer.parseInt(op);
                pass = true;
            }catch(NumberFormatException nfe){
                System.out.println("El valor ingresado no es un numero, intentelo de nuevo.");
                pass = false; 
            }
        }
        
        
        
        //Crear los objetos de conexion
        OutputServerSocket outputServerSocket = new OutputServerSocket(ip, outPort);
        InputServerSocket inputServerSocket = new InputServerSocket(ip, inPort);        
        
        //Instanciar la ventana
        Mainframe mainframe = new Mainframe(outputServerSocket, inputServerSocket);
        mainframe.setVisible(true);
        
        //Ejecutar la escucha
        Thread listener = new Thread(inputServerSocket);
        listener.run();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    //Comprobar si el formato dfe ip es valido
    public static boolean isValidIpAddress(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        
        if (parts.length != 4) {
            return false;
        }
        
        for (String part : parts) {
            try {
                int number = Integer.parseInt(part);
                if (number < 0 || number > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        return true;
    }
}
