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
tag_open     = "\<"
tag_close    = "\>"
tag_inclose  = "\/"
equals       = "\="
comillas     = "\""
nombre_def   = "nombre"
valor_def    = "valor"
identificador= [_\-$][a-zA-Z0-9_\-$]*
val_open     = "\["
val_close    = "\]"

// Valaores generales
// valores parametros
prm_val_id  = {val_open} {identificador} {val_close}
prm_val_fch = {val_open} ([0-9]{4})-([0-1][0-9]|2[0-3])-([0-9]{1,2}) {val_close}
prm_val_tit = {val_open} [A-Za-z0-9\s\.\,\:]+ {val_close}

//valores atributos
atr_val_cent = {val_open} "CENTRAR" {val_close}
atr_val_izqd = {val_open} "IZQUIERDA" {val_close}
atr_val_dere = {val_open} "DERECHA" {val_close}
atr_val_just = {val_open} "JUSTIFICAR" {val_close}
atr_val_colh = {val_open} "#" ([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3}) {val_close}
atr_val_text = {val_open} [A-Za-z0-9\s\.\,\:\;]+ {val_close}
//atr_val_orgn = ¿¿¿¿¿¿ url  ????? 
//     atr_val_altr = [0-9][0-9]*
//     atr_val_anch = [0-9][0-9]*
atr_val_intg = {val_open} [0-9][0-9]* {val_close}

//atr_val_padr = ¿¿¿¿¿¿¿ Menu creado a partir de las paginas hijas del identificador especificado en este atributo??????
//atr_val_etqt = Los atributos de este componente se pueden combinar para filtrar las páginas que se incluyen en el menú. por ejemplo se puede crear un menu de las paginas hijas de ‘productos’ que contengan la etiqueta ‘tenis’ Se debe especificar alguno de los atributos.



// PARAMETROS --------------------------------------------------------------------------------------
parametros_def  = "parametros"
parametro_def   = "parametro"
parametros_op   = {tag_open} {parametros_def} {tag_close} 
parametros_cl   = {tag_open} {tag_inclose} {parametros_def} {tag_close}
//param_type      = ({param_id} | {param_tit} | {param_sit} | {param_pad} | {param_usc} | {param_fcr} | {param_fmd} | {param_usm} | {param_pag} | {param_cls} )   
//parametro_op    = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_type} {comillas} {tag_close}
                  //ES GRAMATICAL <parametro nombre="ID">, RETORNAR LO QUE ESTA ENTRE COMILLAS
param_type_id  = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_id}  {comillas} {tag_close}
param_type_tit = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_tit} {comillas} {tag_close}
param_type_sit = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_sit} {comillas} {tag_close}
param_type_pad = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_pad} {comillas} {tag_close}
param_type_usc = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_usc} {comillas} {tag_close}
param_type_fcr = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_fcr} {comillas} {tag_close}
param_type_fmd = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_fmd} {comillas} {tag_close}
param_type_usm = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_usm} {comillas} {tag_close}
param_type_pag = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_pag} {comillas} {tag_close}
param_type_cls = {tag_open} {parametro_def} {nombre_def} {equals} {comillas} {param_cls} {comillas} {tag_close}
parametro_cl   = {tag_open} {tag_inclose} {parametro_def} {tag_close}

// PARAMETRO
param_id    = "ID"
param_tit   = "TUTULO"
param_sit   = "SITIO"
param_pad   = "PADRE"
param_usc   = "USUARIO_CREACION"
param_fcr   = "FECHA_CREACION"
param_fmd   = "FECHA_MODIFICACION"
param_usm   = "USUARIO_MODIFICACION"
param_pag   = "PAGINA"
param_cls   = "CLASE"




// ETIQUETAS ---------------------------------------------------------------------------------------
etiquetas_def   = "etiquetas"
etiqueta_def    = "etiqueta"
etiquetas_op    = {tag_open} {etiquetas_def} {tag_close}
etiquetas_cl    = {tag_open} {tag_inclose} {etiquetas} {tag_close}
etiqueta        = {tag_open} {etiqueta_def} {valor_def} {equals} {comillas} {identificador} {comillas} {tag_close}
                //ES GRAMATICAL -> <etiqueta valor="etiqueta1"/>  RETORNAR LO QUE ESTA ENTRE COMILLAS

// ATRIBUTOS ---------------------------------------------------------------------------------------
atributos_def   = "atributos"
atributo_def    = "atributo"
atributos_op    = {tag_open} {atributos_def} {tag_close}
atributos_cl    = {tag_open} {tag_inclose} {atributos_def} {tag_close}
//atrib_option    = ( {atr_txt} | {atr_clr} | {atr_aln})
//atributo_op     = {tag_open} {atributo_def}   {nombre_def} {equals} {comillas}  {comillas}  {tag_close}
                  // ES GRAMATICAL -> <atributo nombre="TEXTO"> RETORNAR LO QUE ESTA ENTRE COMILLAS
atr_typle_txt   = {tag_open} {atributo_def} {nombre_def} {equals} {comillas} {atr_txt} {comillas} {tag_close}
atr_typle_clr   = {tag_open} {atributo_def} {nombre_def} {equals} {comillas} {atr_clr} {comillas} {tag_close}
atr_typle_aln   = {tag_open} {atributo_def} {nombre_def} {equals} {comillas} {atr_aln} {comillas} {tag_close}
atributo_cl     = {tag_open} {tag_inclose} {atributo_def} {tag_close}


//ATRIBUTO
atr_txt = "TEXTO"
atr_clr = "COLOR"
atr_aln = "ALINEACION"




// ACCIONES ----------------------------------------------------------------------------------------
accion_def   = "accion"
acciones_def = "acciones"
acciones_op  = {tag_open} {acciones_def} {tag_close}
acciones_cl  = {tag_open} {tag_inclose} {acciones_def} {tag_close}
//acc_opt      = ({add_wbst} | {del_wbst} | {add_pagw} | {del_pagw} | {mod_pagw} | {add_comp} | {del_comp} | {mod_comp})
//accion_op    = {tag_open} {accion_def}      {nombre_def} {equals} {comillas} {acc_opt}  {comillas}    {tag_close}
             // ES GRAMATICAL -> <accion nombre="MODIFICAR_COMPONENTE">
acc_add_wbst = {tag_open} {accion_def} {nombre_def} {equals} {comillas} {add_wbst} {tag_close} 
acc_del_wbst = {tag_open} {accion_def} {nombre_def} {equals} {comillas} {del_wbst} {tag_close} 
acc_add_pagw = {tag_open} {accion_def} {nombre_def} {equals} {comillas} {add_pagw} {tag_close}
acc_del_pagw = {tag_open} {accion_def} {nombre_def} {equals} {comillas} {del_pagw} {tag_close}
acc_mod_pagw = {tag_open} {accion_def} {nombre_def} {equals} {comillas} {mod_pagw} {tag_close}
acc_add_comp = {tag_open} {accion_def} {nombre_def} {equals} {comillas} {add_comp} {tag_close}
acc_del_comp = {tag_open} {accion_def} {nombre_def} {equals} {comillas} {del_comp} {tag_close}
acc_mod_comp = {tag_open} {accion_def} {nombre_def} {equals} {comillas} {mod_comp} {tag_close}
accion_cl    = {tag_open} {tag_inclose} {accion_def} {tag_close}

add_wbst = "NUEVO_SITIO_WEB"
del_wbst = "BORRAR_SITIO_WEB"

add_pagw = "NUEVA_PAGINA"
del_pagw = "BORRAR_PAGINA"
mod_pagw = "MODIFICAR_PAGINA"

add_comp = "AGREGAR_COMPONENTE"
del_comp = "BORRAR_COMPONENTE"
mod_comp = "MODIFICAR_COMPONENTE"


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

// Valores
{prm_val_id}   { return symbol(sym.PRM_VAL_ID,    yytext()); }
{prm_val_fch}  { return symbol(sym.PRM_VAL_FCH,   yytext()); }
{prm_val_tit}  { return symbol(sym.PRM_VAL_TIT,   yytext()); }

{atr_val_cent}  { return symbol(sym.ATR_VAL_CENT,  yytext()); }
{atr_val_izqd}  { return symbol(sym.ATR_VAL_IZQD,  yytext()); }
{atr_val_dere}  { return symbol(sym.ATR_VAL_DERE,  yytext()); }
{atr_val_just}  { return symbol(sym.ATR_VAL_JUST,  yytext()); }
{atr_val_colh}  { return symbol(sym.ATR_VAL_COLH,  yytext()); }
{atr_val_text}  { return symbol(sym.ATR_VAL_TEXT,  yytext()); }

{atr_val_intg}  { return symbol(sym.ATR_VAL_INTG,  yytext()); }

// Parametros
{parametros_op} { return symbol(sym.PARAMETROS_OP,  yytext()); }
{parametros_cl} { return symbol(sym.PARAMETROS_CL,  yytext()); }

{param_type_id}  { return symbol(sym.PARAM_TYPE_ID,  yytext()); }
{param_type_tit} { return symbol(sym.PARAM_TYPE_TIT, yytext()); }
{param_type_sit} { return symbol(sym.PARAM_TYPE_SIT, yytext()); }
{param_type_pad} { return symbol(sym.PARAM_TYPE_PAD, yytext()); }
{param_type_usc} { return symbol(sym.PARAM_TYPE_USC, yytext()); }
{param_type_fcr} { return symbol(sym.PARAM_TYPE_FCR, yytext()); }
{param_type_fmd} { return symbol(sym.PARAM_TYPE_FMD, yytext()); }
{param_type_usm} { return symbol(sym.PARAM_TYPE_USM, yytext()); }
{param_type_pag} { return symbol(sym.PARAM_TYPE_PAG, yytext()); }
{param_type_cls} { return symbol(sym.PARAM_TYPE_CLS, yytext()); }
{parametro_cl}   { return symbol(sym.PARAMETRO_CL,   yytext()); }

// Atributos
{atributos_op}  { return symbol(sym.ATRIBUTOS_OP,   yytext()); }
{atributos_cl}  { return symbol(sym.ATRIBUTOS_CL,   yytext()); }

{atr_typle_txt}  { return symbol(sym.ATR_TYPE_TXT,   yytext()); }
{atr_typle_clr}  { return symbol(sym.ATR_TYPE_CLR,   yytext()); }
{atr_typle_aln}  { return symbol(sym.ATR_TYPE_ALN,   yytext()); }
{atributo_cl}    { return symbol(sym.ATRIBUTO_CL,    yytext()); }

// Acciones
{acciones_op}  { return symbol(ACCIONES_OP,  yytext()); }
{acciones_cl}  { return symbol(ACCIONES_CL,  yytext()); } 

{acc_add_wbst}  { return symbol(ACC_ADD_WBST, yytext()); }
{acc_del_wbst}  { return symbol(ACC_DEL_WBST, yytext()); }
{acc_add_pagw}  { return symbol(ACC_ADD_PAGW, yytext()); }
{acc_del_pagw}  { return symbol(ACC_DEL_PAGW, yytext()); }
{acc_mod_pagw}  { return symbol(ACC_MOD_PAGW, yytext()); }
{acc_add_comp}  { return symbol(ACC_ADD_COMP, yytext()); }
{acc_del_comp}  { return symbol(ACC_DEL_COMP, yytext()); }
{acc_mod_comp}  { return symbol(ACC_MOD_COMP, yytext()); }
{accion_cl}     { return symbol(ACCION_CL,    yytext()); }