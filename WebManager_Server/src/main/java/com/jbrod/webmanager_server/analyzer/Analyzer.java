
package com.jbrod.webmanager_server.analyzer;

import com.jbrod.webmanager_server.OutputServerSocket;
import com.jbrod.webmanager_server.webmanager.WebManager;
import java.io.StringReader;

/**
 * Clase que contiene al lexer y al parser. Contiene el metodo Analyze que sirve para ejecutar el analisis lexico y sintactico.
 * @author jbravo
 */
public class Analyzer {

    private OutputServerSocket oss;
    
    private WebManager webManager; 
    private WebLexer lexer; 
    private WebParser parser; 
    
    private String response;
    
    
    public Analyzer(OutputServerSocket oss){
        webManager = new WebManager();
        this.oss = oss;
    }
    
    
    /**
     * Ejecuta el analisis lexico y sintactico.
     * @param content : String con el contenido a analizar. 
     **/
    public void analyze(String content){
        response = ""; //Reiniciar la respuesta
        
        StringReader reader = new StringReader(content);
        lexer = new WebLexer(reader);
        parser = new WebParser(lexer, webManager);
        
        //Analizar
        try{
            parser.parse();            
        }catch(Exception e){
            System.out.println("Ocurrio un error al analizar la entrada: ");
            response += "Ocurrio un error al analizar la entrada.\n\n\n";
        }
        
            response += "- - - - - - - - RESULTADO DEL ANALISIS LEXICO - - - - - - - -\n\n";
            response += lexer.getResponse();
            response += "\n\n\n\n\n";
            response += "- - - - - - - RESULTADO DEL ANALISIS SINTACTICO - - - - - - -\n\n";
            response += parser.getResponse();
        
        //Enviar la respuesta al servidor
        oss.sendMessage(response);
    }
    
    
}
