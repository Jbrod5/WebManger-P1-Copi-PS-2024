package com.jbrod.webmanager_server.webmanager;
import java.io.File; 
import org.apache.commons.io.FileUtils;
import java.io.IOException;

/**
 * Clase que maneja la creacion y eliminacion de sitios web.
 * Los sitios web son carpetas en las que se coloca su contenido.
 * Los sitios web se colocan en: /home/jbravo/Web/.
 * @author jbravo
 */
public class WebsiteMgr {
    
    //Los sitios web se colocan en: /home/jbravo/Web/
    public static final String URL_BASE = "/home/jbravo/Web/"; 
    
    
    /**
     * Crea una carpeta que funciona como sitio web en /home/jbravo/Web/nombre_del_sitio_nuevo
     * @param name String : string con el nombre del sitio web. Este nombre será el de la carpeta que se creará en /home/jbravo/Web/.
     **/
    public void createWebsite(String name){
        System.out.println("WebsiteMgr -> createWebsite(): ");
        String path = URL_BASE + name; 
        File website = new File(path);
        
        // Si no existe, crear la carpeta
        if(!website.exists()){
            website.mkdir();
            System.out.println("Carpeta " + path + " creada correctamente");
        }else{
            // La carpeta ya existía
            System.out.println("La carpeta " + path + " ya existia." );
        }
    }
    
    
    /**
     * Elimina una carpeta que funciona como sitio web en /home/jbravo/Web/.
     * @param name String: nombre del sitio web que será eliminado en /home/jbravo/Web/.
     **/
    public void deleteWebsite(String name){
        System.out.println("WebsiteMgr -> deleteWebsite(): ");
        String path = URL_BASE + name; 
        File website = new File(path);
        
        try{
            //Si existe el directorio, eliminarlo.
            if(website.exists()){
                FileUtils.deleteDirectory(website);
                System.out.println("Carpeta " + path + " eliminada correctamente.");
            }else{
                //El directorio no existe
                System.out.println("La carpeta " + path + " no existe.");
            }
        }catch(IOException e){
            System.out.println("No se pudo eliminar el directorio  " + path + " y sus archivos y subdirectorios.");
        }
        
    }

}
