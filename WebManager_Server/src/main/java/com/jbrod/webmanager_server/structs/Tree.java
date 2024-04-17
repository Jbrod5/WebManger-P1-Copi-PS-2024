
package com.jbrod.webmanager_server.structs;

import com.jbrod.webmanager_server.webcomponents.WebPage;

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
    
    /**
     * Inserta una pagina web en el arbol de un sitio web tomando en cuenta su pagina padre.
     * @param toInsert : WebPage ya instanciada que se insertara en el arbol.
     * @return Node : Nodo con la pagina web y sus hijos.
     **/
    public Node insertPage(WebPage toInsert){
        Node node = new Node(toInsert);
        node.getPage().setWebsitePath(websitePath); 
        
        //Si no hay raiz, el arbol esta vacio. Insertar en la raiz.
        if(root == null){
            root = node;
            toInsert.generateHtmlFile();
            return root; 
        }
        
        //Buscar la pagina padre
        String parent = toInsert.getParentPage();
        
        //1. Insertar en index
        if(parent.equals("index") || parent.equals("_index") || parent.equals("-index") || parent.equals("$index")){
            root.addChildNode(node);
            return node;
        }
        
        //2. Buscar el los nodos hijos
        root.insertChildNode(node);
        return node; 
    }
    
}
