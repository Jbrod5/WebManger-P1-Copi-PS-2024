
package com.jbrod.webmanager_server.webcomponents;

/**
 * Clase que representa a un video html.
 * @author jbravo
 */
public class VideoWebComponent extends WebComponent {
    
    /**
     * Construye un video html.
     * @param id : String con el id de la imagen. 
     * @param origen : String con la direccion url de la imagen a mostrar.
     * @param height : String con la altura que tendra la imagen.
     * @param width  : String con la anchura que tendra la imagen.
     **/
    public VideoWebComponent(String id, String origen, String width, String height){
        super.id = id;
        String src = "src=\""   + origen + "\"";
        String wdt = "width=\"" + width  + "\"";
        String hgt = "height=\"" + height + "\"";
        
        super.htmlContent = "<video " + src + wdt + hgt + " controls> </video>";
    }
    
}
