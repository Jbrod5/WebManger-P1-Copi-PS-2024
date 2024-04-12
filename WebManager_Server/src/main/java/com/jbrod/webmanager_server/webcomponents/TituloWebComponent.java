
package com.jbrod.webmanager_server.webcomponents;

/**
 * Clase que representa a un titulo h1 html.
 * @author jbravo
 */
public class TituloWebComponent extends WebComponent{
    
    /**
     * Construye un titulo html.
     * @param id    : String con el id de la imagen. \n
     * @param text  : String el texto a mostrar en el titulo. \n
     * @param align : String con la alineacion de la imagen.  \n
     * @param color : String con el color que tendra el titulo. \n
     **/
    public TituloWebComponent(String id, String text, String align, String color){
        super.id = id; 
        String position = switch(align){
            case "\"CENTRAR\""      -> "center";
            case "\"IZQUIERDA\""    -> "left";
            case "\"DERECHA\""      -> "right";
            default                 -> "justify";
        };
        
        String style =  "style=\"text-align: "+ position +"; color: "+color+";\"";
        super.htmlContent = "<h1 " + style + ">" + text + "</h1>";
    }
}
