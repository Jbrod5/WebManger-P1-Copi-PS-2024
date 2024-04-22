/* CODIGO DE USUARIO */
package com.jbrod.webmanager_client.app.stats;
import java_cup.runtime.*;

%%

%public 
%class QueriesLexer
%cup
%line
%column


// Uso general
consultar   =  [cC][oO][nN][sS][uU][lL][tT][aA][rR] 

vsts_sitio  = [Vv][Ii][Ss][Ii][Tt][Aa][Ss][_][Ss][Ii][Tt][Ii][Oo]
vsts_pagina = [vV][iI][sS][iI][tT][aA][sS][_][pP][aA][gG][iI][nN][aA]
vsts_pgpops = [pP][aA][gG][iI][nN][aA][sS][_][pP][oO][pP][uU][lL][aA][rR][eE][sS]
componente  = [cC][oO][mM][pP][oO][nN][eE][nN][tT][eE]

// Componentes
tit = [tT][iI][tT][uU][lL][oO]
par = [pP][aA][rR][rR][aA][fF][oO]
img = [iI][mM][aA][gG][eE][nN]
vid = [vV][iI][dD][eE][oO]
men = [mM][eE][nN][uU]
tds = [tT][oO][dD][oO][sS]

comp_op = {tit} | {par} | {img} | {vid} | {men} | {tds}

//Simbolos generales
comillas =[\"] | [\“] | [\”]
coma =\,
eoi =\;
val_op =\<
val_cl =\>

inicio = "C:"  
id = [a-zA-Z0-9$_.-]+
separador = "/" | "\\"
path = {inicio} {separador} ({id} {separador})+  {id} | {separador} ({id} {separador})+  {id}

%{
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    System.out.println("Token reconocido: " + yytext());
    //response += "Token reconocido: " + yytext() + "\n";
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


  private void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
    //response += "Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message + "\n";
  }

%}


%%


/* REGLAS LEXICAS */

{consultar}  { return symbol(sym.CONSULTAR, yytext()); }

{vsts_sitio}  { return symbol(sym.VISITAS_SITIO    , yytext()); }
{vsts_pagina} { return symbol(sym.VISITAS_PAGINA   , yytext()); }
{vsts_pgpops} { return symbol(sym.PAGINAS_POPULARES, yytext()); }
{componente}  { return symbol(sym.COMPONENTE       , yytext()); }

{comp_op} { return symbol(sym.COMPONENTE_TYPE, yytext()); }

{comillas}  { return symbol(sym.COMILLAS, yytext()); }
{coma}      { return symbol(sym.COMMA   , yytext()); }
{eoi}       { return symbol(sym.FININSTR, yytext()); }
{val_op}    { return symbol(sym.VAL_OP  , yytext()); }
{val_cl}    { return symbol(sym.VAL_CL  , yytext()); }

{path}      { return symbol(sym.PATH     , yytext()); }
{inicio}    { return symbol(sym.INICIO   , yytext()); }
{separador} { return symbol(sym.SEPARADOR, yytext()); }
{id}        { return symbol(sym.ID       , yytext()); }




[^]            { System.out.println("No se reconocio el lexema " + yytext() + " como un token valido y se ignoro.");}
<<EOF>>        { return symbol(sym.EOF); }