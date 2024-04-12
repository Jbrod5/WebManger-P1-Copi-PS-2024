
package com.jbrod.webmanager_server.webcomponents;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Clase que representa y maneja una pagina web.
 * @author jbravo
 */
public class WebPage {
    
    private String id; 
    private String title; 
    private String site; 
    private String parentPage; 
    private String creatorUser;
    private String creationDate; 
    private String modificationDate; 
    private String modifierUser;

    private String  websitePath;
    
    // Lista de componentes
    LinkedList<WebComponent> components;
    
    
    
    public WebPage() {
    
    }

    public WebPage(String id, String title, String site, String parentPage, String creatorUser, String creationDate, String modificationDate, String modifierUser) {
        this.id = id;
        this.title = title;
        this.site = site;
        this.parentPage = parentPage;
        this.creatorUser = creatorUser;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.modifierUser = modifierUser;
    }

    public void setWebsitePath(String websitePath) {
        this.websitePath = websitePath;
    }
    
    public String getId(){
        return id; 
    }
    
    /* - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - ACCIONES CON COMPONENTES - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - */
    
    /**
     * Agrega un componente a la pagina, luego, genera de nuevo el codigo html.
     * @param component : WebComponent (puede ser TITULO, PARRAFO, IMAGEN, VIDEO, MENU).
     **/
    private void addHtmlComponent(WebComponent component){
        components.add(component);
        generateHtmlFile();
    }
    
    /**
     * Elimina un componente de la pagina segun su id, luego, genera de nuevo el codigo html.
     * @param id : String con el id del componente a eliminar.
     **/
    private void removeHtmlComponent(String id){
        System.out.println("webPage -> removeHtmlComponent():");
        WebComponent actual;
        for (int i = 0; i < components.size(); i++) {
             actual = components.get(i); 
            if(actual != null && actual.getId().equals(id)){
                components.remove(i);
                System.out.println("Componente " + id + " elimiando correctamente.");
                generateHtmlFile();
                break;
            }
        }
        System.out.println("No se encontro el componente " + id);
        
    }
    
    /**
     * Reemplaza un componente html por otro, luego, genera de nuevo el codigo html.
     * @param newComponent : WebComponent con el que sera reemplazado. Si no se encuentraba en la lista de componentes, se agrega a la lista.
     **/
    private void replaceHtmlComponent(WebComponent newComponent){
        System.out.println("webPage -> replaceHtmlComponent():");
        String idNewComponent = newComponent.getId();
        WebComponent actual;
        for (int i = 0; i < components.size(); i++) {
            actual = components.get(i);
 
            if(actual != null && actual.getId().equals(idNewComponent)){
                //Eliminarlo e insertar en esa posicion
                components.remove(i);
                components.add(i, newComponent);
                System.out.println("Componente con id " + idNewComponent + " reemplazado correctamente.");
                generateHtmlFile();
                break; 
            }            
        }
        System.out.println("No se encontro " + idNewComponent + " por lo que se insertara.");
        addHtmlComponent(newComponent);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    private String getHtmlComponents(){
        String htmlComponents = "";
        WebComponent actual;
        for (int i = 0; i < components.size(); i++) {
             actual = components.get(i); 
            if(actual != null){
                htmlComponents += actual.getHtml();
            }
        }
        return htmlComponents;
    }
    
    public void generateHtmlFile(){
        System.out.println("webPage -> generateHtmlFile():");
        String header = "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "  <title>" + title + "</title>\n" +
                        "  <style>\n" +
                        "    body {\n" +
                        "      font-family: \"Helvetica Neue\", Arial, sans-serif;\n" +
                        "      background-color: #f8f8f8;\n" +
                        "      margin: 0;\n" +
                        "      padding: 0;\n" +
                        "    }\n" +
                        "    \n" +
                        "    header {\n" +
                        "      background-color: #333;\n" +
                        "      color: #fff;\n" +
                        "      padding: 30px;\n" +
                        "      text-align: center;\n" +
                        "    }\n" +
                        "    \n" +
                        "    h1 {\n" +
                        "      font-size: 48px;\n" +
                        "      margin: 0;\n" +
                        "    }\n" +
                        "    \n" +
                        "    main {\n" +
                        "      max-width: 800px;\n" +
                        "      margin: 40px auto;\n" +
                        "      padding: 40px;\n" +
                        "      background-color: #fff;\n" +
                        "      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n" +
                        "      border-radius: 10px;\n" +
                        "    }\n" +
                        "    \n" +
                        "    p {\n" +
                        "      line-height: 1.6;\n" +
                        "      color: #555;\n" +
                        "    }  "+
                        "  </style>";

        String endFile = "</body>\n</html>";


        String html = header + getHtmlComponents() + endFile;

        //Generar el archivo html
        String pagePath = websitePath + title + ".html";
        try{
            File htmlFile = new File(pagePath);
            FileWriter writer = new FileWriter(htmlFile, false); //false: no concatena sino reemplaza
            writer.write(html);
            writer.close(); 
            System.out.println("El archivo html con ruta " +  pagePath + " se ha generado correctamente");
        }catch(IOException e){
            System.out.println("Ocurrio un error al escribir " +  pagePath + ".");            
        }
        
    }
    
    
    
    
}
