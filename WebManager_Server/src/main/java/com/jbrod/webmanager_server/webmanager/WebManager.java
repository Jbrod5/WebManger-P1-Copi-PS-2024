
package com.jbrod.webmanager_server.webmanager;

import com.jbrod.webmanager_server.structs.Tree;
import com.jbrod.webmanager_server.webcomponents.WebPage;
import java.util.LinkedList;

/**
 * Clase que maneja toda la logica del manejo de base de datos.
 * @author jbravo
 */
public class WebManager {

    private LinkedList<Tree> websites;
    private LinkedList<WebPage> pages;
    private WebsiteMgr websiteMgr; 
    
    public WebManager(){
        websiteMgr = new WebsiteMgr();
    }
    
    
    
    /* - - - - - - - - - - - - - - - - - - - - - - ACCIONES CON SITIOS WEB - - - - - - - - - - - - - - - - - - - - - - */
    
    /**
     * Crea la carpeta donde se alojara el sitio web y un arbol que lo represente y lo añadira a la lista de sitios.
     * @param websiteName : String con el nombre del sitio web que se creara.
     **/
    public void createWebsite(String websiteName){
        System.out.println("WebManager -> createWebsite():");
        Tree actual; 
        
        //Verificar si ya existe el sitio web
        for (int i = 0; i < websites.size(); i++) {
            actual = websites.get(i);
            if(actual != null && websiteName.equals(actual.getName())){
                System.out.println("El sitio web " + websiteName +  " ya existia.");
                return; 
            }
        }
        
        //Crear el sitio web
        String webSitePath = websiteMgr.createWebsite(websiteName);
        Tree newSite = new Tree(websiteName, webSitePath);
        //Agregarlo a la lista de sitios web
        websites.add(newSite);
        System.out.println("Sitio web " + websiteName + " creado correctamente.");
    }
    
    /**
     * Elimina la carpeta donde se aloja el sitio web y el arbol que lo representaba de la lista de sitios.
     * @param websiteName : nombre del sitio web que se desea eliminar.
     **/
    public void deleteWebsite(String websiteName){
        System.out.println("WebManager -> deleteWebsite():");
        int position = 0; 
        boolean exists = false;
        Tree actual; 
        
        //Verificar si existe el sitio web
        for (int i = 0; i < websites.size() && !exists; i++) {
            actual = websites.get(i);
            if(actual != null && websiteName.equals(actual.getName())){
                //El sitio si existe, eliminarlo
                websites.remove(i);
                System.out.println("El sitio web " + websiteName +  " se elimino de la lista de sitios web.");
                websiteMgr.deleteWebsite(websiteName);
                return; 
            }
        }
        System.out.println("No se encontro " + websiteName + " en la base de sitios para ser eliminado.");
    }
    
    
}
