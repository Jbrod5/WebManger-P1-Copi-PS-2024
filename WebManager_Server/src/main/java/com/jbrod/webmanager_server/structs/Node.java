
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

    public String getId(){
        return id; 
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
        page.generateHtmlFile();
    }
    
    /**
     * Inserta un nodo como hijo del nodo actual, usado por el arbol al insertar.
     * @param node : Node ya instanciado con la pagina ya guardada en el.
     **/
    public void insertChildNode(Node node){
        // Si este es el nodo donde insertar, insertar.
        if(node.getPage().getParentPage().equals(page.getParentPage())){
            addChildNode(node);
        }else{
            Node actual; 
            for (int i = 0; i < childNodes.size(); i++) {
                actual = childNodes.get(i);
                if(actual != null){
                    insertChildNode(node);
                }
            }
        } 
    }
    
    /**
     * Elimina el archivo html de la pagina en el nodo.
     **/
    public void deletePage(LinkedList<Node> pages){
        //Borrar pagina
        page.deleteHtmlFile();
        
        //Borrar nodos hijos
        Node actual;
        for (int i = 0; i < childNodes.size(); i++) {
            actual = childNodes.get(i);
            if(actual != null){
                //Eliminar hijos
                actual.deletePage(pages);
                //Remover esta pagina de la lista de paginas
                pages.remove(actual);
            }
            
        }
    }
    
    
    
}
