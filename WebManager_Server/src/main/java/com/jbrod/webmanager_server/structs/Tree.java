
package com.jbrod.webmanager_server.structs;

/**
 *
 * @author jbravo
 */
public class Tree {
    private String websiteName;
    private String websitePath; 
    private Node root;
    
    
    /**
     * Crea una instancia de un arbol que actua como sitio web.
     * @param websiteName : String con el nombre del sitio web representado por el arbol.
     * @param websitePath : String con el path donde se encuentra almacenado el sitio web.
     **/
    public Tree(String websiteName, String websitePath){
        this.websiteName = websiteName; 
        this.websitePath = websitePath;
    }
    
    public String getName(){
        return websiteName;
    }
    
}
