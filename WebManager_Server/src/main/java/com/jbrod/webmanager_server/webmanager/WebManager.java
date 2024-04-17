
package com.jbrod.webmanager_server.webmanager;

import com.jbrod.webmanager_server.structs.Node;
import com.jbrod.webmanager_server.structs.Tree;
import com.jbrod.webmanager_server.webcomponents.WebComponent;
import com.jbrod.webmanager_server.webcomponents.WebPage;
import java.util.LinkedList;

/**
 * Clase que maneja toda la logica del manejo de base de datos.
 * @author jbravo
 */
public class WebManager {

    private LinkedList<Tree> websites;
    private LinkedList<Node> pages;
    private WebsiteMgr websiteMgr; 
    
    public WebManager(){
        websiteMgr = new WebsiteMgr();
        websites = new LinkedList<>();
        pages = new LinkedList<>();
        
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
    








    /* - - - - - - - - - - - - - - - - - - - - - - ACCIONES CON PAGINAS WEB - - - - - - - - - - - - - - - - - - - - - - */
    
    /**
     * Agrega una página a su respectivo sitio web por medio de los árboles de sitio.
     * @param toAdd : WebPage ya instanciada. Se agrega comparando el sitio encontrado en la instancia.
     **/
    public void addPage(WebPage toAdd){
        // Buscar el arbol donde insertar
        String webSite = toAdd.getSite();
        Tree actual; 
        
        for (int i = 0; i < websites.size(); i++) {
            actual = websites.get(i);
            
            if(webSite.equals(actual.getName())){
                pages.add(actual.insertPage(toAdd));
                // La pagina se genera desde el nodo
                return; 
            }
            
        }
        System.out.println("WebManager -> addPage():");
        System.out.println("No se encontro " + webSite + " en la base de sitios para agregar la pagina " + toAdd.getId() +".");
    }
    
    
    /**
     * Busca una pagina en base a un id y elimina: su nodo, su archivo htm y sus hijos de manera recursiva (logica de eliminacion recursiva en Node).
     * @param idPag : String con el id de la pagina a eliminar.
     * @see Node.
     **/
    public void deletePage(String idPag){
        System.out.println("WebManager -> deletePage():");
        //Buscar nodo/pagina a eliminar
        
        Node actual; 
        for (int i = 0; i < pages.size(); i++) {
            actual = pages.get(i);
            if(actual != null && idPag.equals(actual.getId())){
                //Pagina encontrada, eliminar sus hijos
                actual.deletePage(pages);
                //Eliminar la pagina
                pages.remove(actual);
                System.out.println("Se ha eliminado la pagina " + idPag + " y sus hijos.");
                return;
            }
            
        }
        System.out.println("No se encontro " + idPag + " para ser eliminada.");
    }
    
    
    /**
     * Modifica el titulo y las etiquetas de una pagina web segun su id.
     * @param idPagToModify : String con el id de la pagina que se desea modificar.
     * @param title : String con el nuevo titulo que tendra la pagina.
     * @param tagslist : LinkedList de WebComponent con las etiquetas que se pondran en la pagina.
     **/
    public void modifyPage(String idPagToModify, String title, LinkedList<WebComponent> tagslist){
        System.out.println("WebManager -> modifyPage():");
        // 1. Obtener la pagina
        Node pagToModify = getPageById(idPagToModify);
        
        if(pagToModify != null){
            // Si se encontro el nodo, obtener la pagina
            WebPage page = pagToModify.getPage();
            //Verificar que la pagina no sea nula
            if(page != null){
                //Modificar
                page.deleteHtmlFile();
                page.replaceTags(tagslist);
                page.replaceTitle(title);
                System.out.println("La pagina " + idPagToModify +  " se modifico correctamente.");
                page.generateHtmlFile();
            }else{
                System.out.println("Se encontro un nodo con el id " + idPagToModify + " pero la pagina que contiene es nula.");
            }
        }else{
            System.out.println("No se encontro una pagina con el id " + idPagToModify);
        }
        
    }
    
    
    


    /* - - - - - - - - - - - - - - - - - - - - - ACCIONES CON COMPONENTES WEB - - - - - - - - - - - - - - - - - - - - - */
    
    /**
     * Agrega un componente a una pagina en base a su id.
     * @param idPagWhereAdd : String con el id de la pagina donde se desea agregar el componente.
     * @param componentToAdd : WebComponent ya instanciado que se agregara en la pagina.
     **/
    public void addComponent(String idPagWhereAdd, WebComponent componentToAdd){
        System.out.println("WebManager -> addComponent():");
        //1. Buscar la pagina web
        Node pagWhereAdd = getPageById(idPagWhereAdd);
        
        //2. Verificar que no sea nulo
        if(pagWhereAdd != null && pagWhereAdd.getPage() != null){
            //3. Agregar el componente
            pagWhereAdd.getPage().addHtmlComponent(componentToAdd);
        }else{
            System.out.println("No se encontro la pagina " + idPagWhereAdd);
        }
    }

    
    /**
     * Elimina un componente de una pagina en base al id de la pagina y del componente.
     * @param idPagWhereDelete : Strting con el id de la pagina donde se hara la eliminacion.
     * @param idComponenrtToDelete : String con el id del componente que se eliminara de la pagina.
     **/
    public void deleteComponent(String idPagWhereDelete, String idComponenrtToDelete){
        System.out.println("WebManager -> deleteComponent():");
        //1. Buscar la pagina web
        Node pagWhereDelete = getPageById(idPagWhereDelete);

        //2. Verificar que la pagina exista
        if(pagWhereDelete != null && pagWhereDelete.getPage() != null){
            //3. Eliminar el componente
            pagWhereDelete.getPage().removeHtmlComponent(idComponenrtToDelete);
        }else{
            System.out.println("No se encontro la pagina " + idPagWhereDelete);
        }

    }

    /**
     * Reemplaza un componente de una pagina web por otro.
     * @param idPagWhereModify : String con el id de la pagina donde se hara el reemplazdo del componente.
     * @param componentToAdd : WebComponent ya instanciado que sera insertado en la pagina.
     **/
    public void modifyComponent(String idPagWhereModify, WebComponent componentToAdd){
        System.out.println("WebManager -> modifyComponent():");
        //1. Buscar la pagina web
        Node pagWhereModify = getPageById(idPagWhereModify);

        //2. Verificar que la pagina exista
        if(pagWhereModify != null && pagWhereModify.getPage() != null){
            //3. Reemplazar el componente
            pagWhereModify.getPage().replaceHtmlComponent(componentToAdd);
        }else{
            System.out.println("No se encontro la pagina " + idPagWhereModify);
        } 
    }



    
    
    /**
     * Para uso interno: retorna un nodo segun el id de la pagina que se este buscando.
     * @param id : String con el id de la pagina que se busca.
     **/
    Node getPageById(String id){
        Node actual;
        
        for (int i = 0; i < pages.size(); i++) {
            actual = pages.get(i);
            if(id.equals(actual.getId())){
                return actual;
            }
        }
        
        return null;
    }
    
}
