
package com.jbrod.webmanager_server.webcomponents;

/**
 * Clase que representa y maneja una pagina web.
 * @author jbravo
 */
public class webPage {
    
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
    
    
    
    
    public webPage() {
    
    }

    public webPage(String id, String title, String site, String parentPage, String creatorUser, String creationDate, String modificationDate, String modifierUser) {
        this.id = id;
        this.title = title;
        this.site = site;
        this.parentPage = parentPage;
        this.creatorUser = creatorUser;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.modifierUser = modifierUser;
    }
    
    
    
    
    
    
    private String getHtmlComponents(){
        String htmlComponents = "";
        return htmlComponents;
    }
    
    public void generateHtmlFile(){
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
        
    }
    
    
    
    
}
