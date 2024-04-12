
package com.jbrod.webmanager_server.webcomponents;

/**
 * Clase que representa una imagen html.
 * @author jbravo
 */
public class ImagenWebComponent extends WebComponent{

    /**
     * Construye una imagen.
     * @param id : String con el id de la imagen. 
     * @param origen : String con la direccion url de la imagen a mostrar.
     * @param align  : String con la alineacion de la imagen.
     * @param height : String con la altura que tendra la imagen.
     * @param width  : String con la anchura que tendra la imagen.
     **/
    public ImagenWebComponent(String id, String origen, String align, String height, String width) {
        super.id = id; 
        String position = switch(align){
            case "\"CENTRAR\""      -> "center";
            case "\"IZQUIERDA\""    -> "left";
            case "\"DERECHA\""      -> "right";
            default                 -> "middle";
        };
        String src   = "src=\""    + origen   + "\"";
        String ancho = "width=\""  + width    + "\"";
        String alto  = "height=\"" + height   + "\"";
        String aln   = "align=\""  + position + "\"";  
        
        super.htmlContent = "<img " + src + ancho + alto + aln + ">";
    }
}
