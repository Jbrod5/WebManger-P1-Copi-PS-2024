
package com.jbrod.webmanager_client.app.stats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Cuenta las coincidencias de un string en un archivo.
 * @author jbravo
 */
public class CountMatches {


    public  String  contarCoincidencias(String type, String path) {
        
        
        int todos    = 0;
        int titulo     = 0; 
        int parrafo = 0; 
        int imagen = 0; 
        int video     = 0; 
        int menu    = 0;
        
        String result = ""; 
        
        

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String palabra : palabras) {
                    
                    //coincidencia de titulo
                    if (palabra.contains("<h1>")) {
                        titulo ++;
                        
                    }else if (palabra.contains("<p>")){
                        //Coincidencia de parrafo
                        parrafo ++;
                        
                        //Coincidencia de imagen
                    }else if (palabra.contains("<img")){
                        imagen ++;
                    
                    }else if (palabra.contains("<video")){
                        // Coincidencia video
                        video++;
                        
                    }else if(palabra.contains("<nav>")){
                        //Coincidencia menu
                        menu ++;
                    }
            }
                
           }
            br.close();
        } catch (IOException e) {
            System.out.println("Ocurrio un error inesperado.");
        }
        
        int contador = 0; 
    
        switch(type){
            case "TITULO":
                result = "Se encontraron " + titulo + " titulos en la pagina.";
                break;
            case "PARRAFO":
                result = "Se encontraron " + parrafo + " parrafos en la pagina.";
                break; 
            case "IMAGEN":
                result = "Se encontraron " +  imagen + " imagenes en la pagina."; 
                break; 
            case "VIDEO":
                result  =  "Se encontraron " + video + " videos en la pagina."; 
                break; 
            case "MENU":
                result = "Se encontraron " + menu + " menus en la pagina.";
                break; 
            case "TODOS":
                contador = titulo + parrafo + imagen + video + menu;
                result = "Se encontraron " +  contador + " elementos en la pagina.\n"
                        + "Titulos: " + titulo + "\n"
                        + "Parrafos: " + parrafo + "\n"
                        + "Imagenes: " + imagen + "\n"
                        + "Videos: " + video + "\n"
                        + "Menus: " +  menu + "\n";
                
                break; 
            default:
                result = type + " no es un elemento valido para buscar.\n";
        }
        
        return result; 
    }
}
