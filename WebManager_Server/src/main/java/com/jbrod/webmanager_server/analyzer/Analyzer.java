
package com.jbrod.webmanager_server.analyzer;

import com.jbrod.webmanager_server.webmanager.WebManager;
import java.io.StringReader;

/**
 * Clase que contiene al lexer y al parser. Contiene el metodo Analyze que sirve para ejecutar el analisis lexico y sintactico.
 * @author jbravo
 */
public class Analyzer {

    private WebManager webManager; 
    private WebLexer lexer; 
    private WebParser parser; 
    
    public Analyzer(){
        webManager = new WebManager();
    }
    
    
    /**
     * Ejecuta el analisis lexico y sintactico.
     * @param content : String con el contenido a analizar. 
     **/
    public void analyze(String content){
        
        StringReader reader = new StringReader(content);
        lexer = new WebLexer(reader);
        parser = new WebParser(lexer, webManager);
        
        //Analizar
        try{
            parser.parse(); 
        }catch(Exception e){
            System.out.println("Ocurrio un error al analizar la entrada: ");
            //e.printStackTrace();
        }
    }
    
    
}
