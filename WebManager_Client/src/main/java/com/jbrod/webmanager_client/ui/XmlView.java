package com.jbrod.webmanager_client.ui;

import com.jbrod.webmanager_client.app.server_com.InputServerSocket;
import com.jbrod.webmanager_client.app.server_com.OutputServerSocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author jbravo
 */
public class XmlView extends javax.swing.JPanel {
    
    private OutputServerSocket outputServerSocket; //Para la comunicacion de salida
    
    //Contiene el path del archivo que se representa.
    private String path;
    private JTabbedPane maestro; 
    private String tituloTab; 
    
    private InputServerSocket inputServerSocket; 
    
    /**
     * Crear un panel con un path especifico. Si existe el path, cargar el archivo.
     */
    public XmlView(String path, JTabbedPane maestro, OutputServerSocket oss, InputServerSocket iss) {
        outputServerSocket = oss;
        this.inputServerSocket = iss;
        
        initComponents();
        this.path = path;
        this.maestro = maestro; 
        this.tituloTab = "XmlNuevo"; 
        
        
        if (path != null  && path.length() > 0 ) { 
            try  {
                File file = new File(path);
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                String linea;
                
                //Cargar el contenido del archivo en el area de texto
                while ((linea = br.readLine()) != null) {
                    txaXml.append(linea + "\n");
                }
                
                //Obtener el titulo de la ventana
                tituloTab = file.getName();
                
                br.close();
                reader.close();
                
            } catch (IOException e) {
               //Hubo un problema
                System.out.println("Hubo un problema al cargar el archivo. " + path);
            }
        }
        
    }

    
    public String obtenerTitulo(){
        return tituloTab;
    }
    
    public void setServerResponse(String content){
        txaRespuestaServidor.setText(content);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCerrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaXml = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaRespuestaServidor = new javax.swing.JTextArea();

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("XML"));

        txaXml.setColumns(20);
        txaXml.setRows(5);
        jScrollPane3.setViewportView(txaXml);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Respuesta del servidor"));

        txaRespuestaServidor.setColumns(20);
        txaRespuestaServidor.setRows(5);
        jScrollPane1.setViewportView(txaRespuestaServidor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnProcesar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnGuardar)
                    .addComponent(btnProcesar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // Eliminar del tabbed pane maestro
        maestro.remove(this);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(path == null   || path.length() <= 0){
            //Crear el archivo
            JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Solo seleccionar directorios
        fileChooser.setDialogTitle("Seleccionar directorio"); // Título del diálogo

        int seleccion = fileChooser.showOpenDialog(null); // Mostrar el diálogo

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File directorio = fileChooser.getSelectedFile();

            String nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo (con extension):");
          
            String rutaArchivo = directorio.getAbsolutePath() + File.separator + nombreArchivo ;
            path =rutaArchivo; 
            File archivo = new File(rutaArchivo);

            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado exitosamente en: " + rutaArchivo);
                    tituloTab = archivo.getName();
                    maestro.remove(this);
                    maestro.addTab(tituloTab, this);
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se seleccionó ningún directorio.");
        }
        }
        
        //Guardar el contenido del archivo.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            String contenido = txaXml.getText();
            writer.write(contenido);
            System.out.println("Archivo guardado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        // TODO add your handling code here:
        String content = txaXml.getText();
        inputServerSocket.setXmlView(this);
        outputServerSocket.sendMessage(content);
    }//GEN-LAST:event_btnProcesarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txaRespuestaServidor;
    private javax.swing.JTextArea txaXml;
    // End of variables declaration//GEN-END:variables
}
