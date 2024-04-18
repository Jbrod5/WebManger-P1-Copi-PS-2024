package com.jbrod.webmanager_server;

import com.jbrod.webmanager_server.analyzer.Analyzer;
import java.util.Scanner;

/**
 *9920
 * @author jbravo
 */
public class WebManager_Server {

    public static void main(String[] args) {    
        Scanner scanner = new Scanner(System.in);
        
        int inPort = 0; 
        String ip = ""; 
        String op = "";
        boolean pass = false;
        
        System.out.println("Inicio: Web Manager - Server");
        while(!pass){
            
            //Obtener el puerto 
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
        
        //Obtener la direccion IP: hostname -I
        do {
            System.out.print("Ingrese la dirección IP para la comunicacion de salida: ");
            ip = scanner.nextLine();
        } while (!isValidIpAddress(ip));
        
        System.out.println("Servidor en funcionamiento.");
            
            
            
            //Ejecutar la escucha 
            //El constructor ya ejecuta la escucha
            Analyzer analyzer = new Analyzer();
            InputServerSocket inputServerSocket = new InputServerSocket(ip, inPort, analyzer );
            
            //Ejecutar la salida
            


        
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
