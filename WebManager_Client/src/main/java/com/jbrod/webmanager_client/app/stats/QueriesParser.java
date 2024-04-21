
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.jbrod.webmanager_client.app.stats;

import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class QueriesParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public QueriesParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public QueriesParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public QueriesParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\022\000\002\002\004\000\002\002\005\000\002\002" +
    "\002\000\002\003\007\000\002\003\005\000\002\004\003" +
    "\000\002\004\003\000\002\004\003\000\002\004\003\000" +
    "\002\005\004\000\002\006\004\000\002\007\006\000\002" +
    "\013\003\000\002\013\005\000\002\013\003\000\002\012" +
    "\003\000\002\012\003\000\002\010\011" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\040\000\006\002\uffff\004\005\001\002\000\004\002" +
    "\042\001\002\000\012\005\006\006\012\007\016\010\014" +
    "\001\002\000\004\020\034\001\002\000\004\022\ufffc\001" +
    "\002\000\004\022\ufffa\001\002\000\004\022\ufff9\001\002" +
    "\000\004\020\034\001\002\000\004\022\032\001\002\000" +
    "\004\020\022\001\002\000\004\022\ufffb\001\002\000\004" +
    "\020\017\001\002\000\004\027\020\001\002\000\004\020" +
    "\021\001\002\000\004\022\ufff6\001\002\000\004\017\023" +
    "\001\002\000\004\020\024\001\002\000\004\020\025\001" +
    "\002\000\006\027\026\030\027\001\002\000\004\020\ufff1" +
    "\001\002\000\004\020\ufff2\001\002\000\004\020\031\001" +
    "\002\000\004\022\ufff0\001\002\000\004\002\000\001\002" +
    "\000\004\022\ufff7\001\002\000\004\027\035\001\002\000" +
    "\004\020\036\001\002\000\006\021\037\022\ufffd\001\002" +
    "\000\004\020\034\001\002\000\004\022\ufffe\001\002\000" +
    "\004\022\ufff8\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\040\000\004\002\003\001\001\000\002\001\001\000" +
    "\014\004\012\005\006\006\014\007\007\010\010\001\001" +
    "\000\004\003\040\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\003\032\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\012\027\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\003\037\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$QueriesParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$QueriesParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$QueriesParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}





    //String de respuesta
    private String response = ""; 

    public String getResponse(){
        return response; 
    }  


    // Connect this parser to a scanner!
    public QueriesParser(QueriesLexer lex) {
	    super(lex);
    }

    public void syntax_error(Symbol cur_token) {
        System.out.println("Simbolo con error:" + symbl_name_from_id(cur_token.sym));
        System.out.println("Linea " + cur_token.left);
        System.out.println("Columna " + cur_token.right);
        response += "Simbolo con error:" + symbl_name_from_id(cur_token.sym) + "\n";
        response += "Linea: " + cur_token.left + "     Columna: " + cur_token.right + "\n";
        if (expected_token_ids().isEmpty()) {
            System.out.println("Ya no se esperaba ningun simbolo");
            response += "Ya no se esperaba ningun simbolo.\n";
        }

    }
    /*public void unrecovered_syntax_error(Symbol cur_token) {
        System.out.println("Error irrecuperable sobrecargado");
    }*/



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$QueriesParser$actions {
  private final QueriesParser parser;

  /** Constructor */
  CUP$QueriesParser$actions(QueriesParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$QueriesParser$do_action_part00000000(
    int                        CUP$QueriesParser$act_num,
    java_cup.runtime.lr_parser CUP$QueriesParser$parser,
    java.util.Stack            CUP$QueriesParser$stack,
    int                        CUP$QueriesParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$QueriesParser$result;

      /* select the action based on the action number */
      switch (CUP$QueriesParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= consulta EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-1)).right;
		String start_val = (String)((java_cup.runtime.Symbol) CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-1)).value;
		RESULT = start_val;
              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-1)), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$QueriesParser$parser.done_parsing();
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // consulta ::= CONSULTAR op FININSTR 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("consulta",0, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-2)), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // consulta ::= 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("consulta",0, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // cadena_id ::= COMILLAS ID COMILLAS COMMA cadena_id 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("cadena_id",1, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-4)), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // cadena_id ::= COMILLAS ID COMILLAS 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("cadena_id",1, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-2)), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // op ::= visitas_sitio 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("op",2, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // op ::= visitas_pagina 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("op",2, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // op ::= paginas_populares 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("op",2, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // op ::= componentes 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("op",2, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // visitas_sitio ::= VISITAS_SITIO cadena_id 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("visitas_sitio",3, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-1)), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // visitas_pagina ::= VISITAS_PAGINA cadena_id 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("visitas_pagina",4, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-1)), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // paginas_populares ::= PAGINAS_POPULARES COMILLAS ID COMILLAS 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("paginas_populares",5, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-3)), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // dir ::= PATH 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("dir",9, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // dir ::= ID SEPARADOR dir 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("dir",9, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-2)), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // dir ::= ID 
            {
              String RESULT =null;

              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("dir",9, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // ruta ::= PATH 
            {
              String RESULT =null;
		int pathleft = ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()).left;
		int pathright = ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()).right;
		String path = (String)((java_cup.runtime.Symbol) CUP$QueriesParser$stack.peek()).value;
		 RESULT = path; 
              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("ruta",8, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // ruta ::= ID 
            {
              String RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$QueriesParser$stack.peek()).value;
		 RESULT = id; 
              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("ruta",8, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // componentes ::= COMPONENTE COMILLAS COMPONENTE_TYPE COMILLAS COMILLAS ruta COMILLAS 
            {
              String RESULT =null;
		int typeleft = ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-4)).left;
		int typeright = ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-4)).right;
		String type = (String)((java_cup.runtime.Symbol) CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-4)).value;
		int pathleft = ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-1)).left;
		int pathright = ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-1)).right;
		String path = (String)((java_cup.runtime.Symbol) CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-1)).value;
		
                CountMatches countMatches = new CountMatches();
                countMatches.contarCoincidencias(type, path);
            
              CUP$QueriesParser$result = parser.getSymbolFactory().newSymbol("componentes",6, ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.elementAt(CUP$QueriesParser$top-6)), ((java_cup.runtime.Symbol)CUP$QueriesParser$stack.peek()), RESULT);
            }
          return CUP$QueriesParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$QueriesParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$QueriesParser$do_action(
    int                        CUP$QueriesParser$act_num,
    java_cup.runtime.lr_parser CUP$QueriesParser$parser,
    java.util.Stack            CUP$QueriesParser$stack,
    int                        CUP$QueriesParser$top)
    throws java.lang.Exception
    {
              return CUP$QueriesParser$do_action_part00000000(
                               CUP$QueriesParser$act_num,
                               CUP$QueriesParser$parser,
                               CUP$QueriesParser$stack,
                               CUP$QueriesParser$top);
    }
}

}