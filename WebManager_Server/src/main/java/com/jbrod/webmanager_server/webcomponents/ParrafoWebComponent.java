
package com.jbrod.webmanager_server.webcomponents;

/**
 * Clase que representa a un parrafo p html.
 * @author jbravo
 */
public class ParrafoWebComponent extends WebComponent{

    /**
     * Construye un parrafo html.
     * @param id    : String con el id de la imagen. 
     * @param text  : String con el texto que conforma el parrafo.
     * @param align : String con la alineacion que tendra el parrafo.
     * @param color : String con el color que tendra el parrafo.
     **/
    public ParrafoWebComponent(String id, String text, String align, String color){
        super.id = id; 
        String position = switch(align){
            case "\"CENTRAR\""      -> "center";
            case "\"IZQUIERDA\""    -> "left";
            case "\"DERECHA\""      -> "right";
            default                 -> "justify";
        };
        
        String style =  "style=\"text-align: "+ position +"; color: "+color+";\"";
        super.htmlContent = "<p " + style + ">" + text + "</p>";
    }
    
}
