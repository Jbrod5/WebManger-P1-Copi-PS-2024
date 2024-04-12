
package com.jbrod.webmanager_server.structs;

import com.jbrod.webmanager_server.webcomponents.WebPage;
import java.util.LinkedList;

/**
 * Clase nodo para un arbol de paginas.
 * @author jbravo
 */
public class Node {

    private String id; 
    private WebPage page;
    private LinkedList<Node> childNodes; 
    
    /**
     * Crea un nodo con una pagina web, ademas de crear la instancia de la lista enlazada de nodos hijos.
     * @param page : WebPage pagina web que se almacenara en el nodo.
     **/
    public Node(WebPage page){
        this.page = page;
        childNodes = new LinkedList<>();
        this.id = page.getId();
    }

    public LinkedList<Node> getChildNodes() {
        return childNodes;
    }

    public WebPage getPage() {
        return page;
    }

    /**
     * Actualiza la pagina web almacenada en el nodo.
     * @param  page : WebPage que reemplazara a la pagina ya existente.
     **/
    public void setPage(WebPage page) {
        this.page = page;
    }
    
    /**
     * Agrega un nodo como hijo del nodo actual.
     * @param node : Node ya instanciado con la pagina ya guardada en el.
     **/
    public void addChildNode(Node node){
        childNodes.add(node);
    }
    
    
    
    
}
