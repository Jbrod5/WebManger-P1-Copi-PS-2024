/* CODIGO DE USUARIO */
package 
import java_cup.runtime.*;

%% 

/* DECLARACIONES */
%public
%class WebManagerLexer
%cup
%line
%column

// Uso general
tag_open     =\<
tag_close    =\>
tag_inclose  =\/
equals       =\=
comillas     =\"
nombre_def   =nombre
valor_def    =valor
identificador=[_\-$][a-zA-Z0-9_\-$]*
val_open     =\[
val_close    =\]

// PARAMETROS --------------------------------------------------------------------------------------
parametros_def  =parametros
parametro_def   =parametro
parametros_op   = {tag_open} {parametros_def} {tag_close} 
parametros_cl   = {tag_open} {tag_inclose} {parametros_def} {tag_close}
param_type      = ({param_id} | {param_tit} | {param_sit} | {param_pad} | {param_usc} | {param_fcr} | {param_fmd} | {param_usm} | {param_pag} | {param_cls} )   
parametro_op    = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_type} {comillas} {tag_close}
                //ES GRAMATICAL <parametro nombre="ID">, RETORNAR LO QUE ESTA ENTRE COMILLAS
parametro_cl    = {tag_open} {tag_inclose} {parametro_def} {tag_close}

// PARAMETRO
param_id    =ID
param_tit   =TUTULO
param_sit   =SITIO
param_pad   =PADRE
param_usc   =USUARIO_CREACION
param_fcr   =FECHA_CREACION
param_fmd   =FECHA_MODIFICACION
param_usm   =USUARIO_MODIFICACION
param_pag   =PAGINA
param_cls   =CLASE

// VALORES
prm_val_id  = {identificador}
prm_val_fch = ([0-9]{4})-([0-1][0-9]|2[0-3])-([0-9]{1,2})
prm_val_tit = [A-Za-z0-9\s\.\,\:]+


// ETIQUETAS ---------------------------------------------------------------------------------------
etiquetas_def   =etiquetas
etiqueta_def    =etiqueta
etiquetas_op    = {tag_open} {etiquetas_def} {tag_close}
etiquetas_cl    = {tag_open} {tag_inclose} {etiquetas} {tag_close}
etiqueta        = {tag_open} {etiqueta_def} {valor_def} {equals} {comillas} {identificador} {comillas} {tag_close}
                //ES GRAMATICAL -> <etiqueta valor="etiqueta1"/>  RETORNAR LO QUE ESTA ENTRE COMILLAS

// ATRIBUTOS ---------------------------------------------------------------------------------------
atributos_def   =atributos
atributo_def    =atributo
atributos_op    = {tag_open} {atributos_def} {tag_close}
atributos_cl    = {tag_open} {tag_inclose} {atributos_def} {tag_close}
//atributo_op     = ES GRAMATICAL -> <atributo nombre="TEXTO">
atributo_cl     = {tag_open} {tag_inclose} {atributo_def} {tag_close}


//ATRIBUTO
atr_txt =TEXTO
atr_clr =COLOR
atr_aln =ALINEACION

//VALORES
atr_val_cent =CENTRAR
atr_val_izqd =IZQUIERDA
atr_val_dere =DERECHA
atr_val_just =JUSTIFICAR
atr_val_colh = #([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})
atr_val_text = [A-Za-z0-9\s\.\,\:\;]+
//atr_val_orgn = ¿¿¿¿¿¿ url  ????? 
atr_val_altr = [0-9][0-9]*
atr_val_anch = [0-9][0-9]*
//atr_val_padr = ¿¿¿¿¿¿¿ Menu creado a partir de las paginas hijas del identificador especificado en este atributo??????
//atr_val_etqt = Los atributos de este componente se pueden combinar para filtrar las páginas que se incluyen en el menú. por ejemplo se puede crear un menu de las paginas hijas de ‘productos’ que contengan la etiqueta ‘tenis’ Se debe especificar alguno de los atributos.


// ACCIONES ----------------------------------------------------------------------------------------
accion_def   =accion
acciones_def =acciones
acciones_op  = {tag_open} {acciones_def} {tag_close}
acciones_cl  = {tag_open} {tag_inclose} {acciones_def} {tag_close}
//accion_op    = ES GRAMATICAL -> <accion nombre="MODIFICAR_COMPONENTE">
accion_cl    = {tag_open} {tag_inclose} {accion_def} {tag_close}

add_wbst =NUEVO_SITIO_WEB
del_wbst =BORRAR_SITIO_WEB

add_pagw =NUEVA_PAGINA
del_pagw =BORRAR_PAGINA
mod_pagw =MODIFICAR_PAGINA

add_comp =AGREGAR_COMPONENTE
del_comp =BORRAR_COMPONENTE
mod_comp =MODIFICAR_COMPONENTE

// =================================================================================================

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]


%{
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


  private void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  }
%}


%%
/* REGLAS LEXICAS */

