
package com.jbrod.webmanager_server.webcomponents;

/**
 * Clase que representa a un componente de una pagina web.
 * Puede ser TITULO, PARRAFO, IMAGEN, VIDEO, MENU.
 * @author jbravo
 */
public class WebComponent {
    protected String htmlContent;
    protected String id; 
    
    public String getHtml(){
        return htmlContent;
    }
    
    public String getId(){
        return id;
    }

}
