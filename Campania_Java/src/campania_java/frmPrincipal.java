package campania_java;

import java.awt.Color;
import java.awt.List;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class frmPrincipal extends javax.swing.JFrame { 
    
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("DD/MM/YYYY");
    private String directorioOrigen = "";
    private String directorioDestino = "";
    private String txtOrigen = "";
    private String txtDestino = "";
    private int cantidad = 0;
    private String Dir = "";  
    private String ImpuestoV = "";
    private String NombreOrigen = ""; 
    private String FraccionImpuesto =  "";
     private String DirOrigen = "";
    private String objeto = ""; 
    private String nombreImpuesto = "";
    private String impuestoLiquidar = "";
    private String medioPago = "";
    private String debitoCredito = ""; //ejemplo con contenid previo
    private String mailAux ="";
    private String mail ="";
    private String razonsocialAux = "";
    private String cuitAux ="";
    private String cuit ="";
    private String razonsocial ="";
    private String porcentaje = "";
    private String anio = "";
    private String cuota = "";
    private String cuotaNumero = "";
    private String fechaVencimiento = "";
    private String fechaVencimientoNumero = "";
    private String montoCuota = "";
    private String montoAnual = "";
    private String codigoElectronico = "";
    private String buenContribuyente = "";
    private String cuitFormateado = "";
    private String planta = "";
    private String plantaDescri = "";
    private String impuesto = "";
    private String fechaOpcion = "";
    private String datosObjeto = "";
    private String objetoFormateado = "";
    private String Variable = "";
    private String nombreArchivoCsv = "";
    //private String Path = "";
    
    
    private FileNameExtensionFilter filter = new FileNameExtensionFilter ("Archivos Txt", "txt");
  
    public frmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Generar Bases para campaña por mail V1");
       
        Generar_.setEnabled(false);
        Origen_.setEnabled(false);
        
        Dir = "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent";
              
              //Home  "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Origen";
              //ARBA : "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent";                  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Impuesto = new javax.swing.JComboBox<>();
        cantidadAleer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txturl = new javax.swing.JTextField();
        Origen_ = new javax.swing.JButton();
        txtArchivoOrigen = new javax.swing.JTextField();
        Generar_ = new javax.swing.JButton();
        barraLeidos = new javax.swing.JProgressBar();
        barraGenerados = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidadCorte = new javax.swing.JTextField();
        ConCabecera = new javax.swing.JCheckBox();
        ConAnual = new javax.swing.JCheckBox();
        DiferenciarMails = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        FechaOpcion = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Impuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Impuesto Automotor", "Impuesto a las Embarcaciones", "Impuesto Urbano Edificado", "Impuesto Urbano Baldío", "Impuesto Rural", "Impuesto Complementario" }));
        Impuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpuestoActionPerformed(evt);
            }
        });

        cantidadAleer.setText("5");

        jLabel1.setText("Cant. Suscripciones ");

        jLabel2.setText("URL");

        Origen_.setText("Origen");
        Origen_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Origen_ActionPerformed(evt);
            }
        });

        Generar_.setText("Generar");
        Generar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generar_ActionPerformed(evt);
            }
        });

        jLabel3.setText("Subscripciones Leidas");

        jLabel4.setText("Mail generados");

        jLabel5.setText("Contar Cada");

        txtCantidadCorte.setText("15000");

        ConCabecera.setText("Con Cabecera");

        ConAnual.setText("Con Anual");

        DiferenciarMails.setText("Diferenciar Mails");

        jLabel6.setText("fecha Opcion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Impuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(ConAnual)
                                .addGap(45, 45, 45)
                                .addComponent(ConCabecera)
                                .addGap(52, 52, 52)
                                .addComponent(DiferenciarMails)
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Origen_)
                                        .addGap(2, 2, 2))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(FechaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(cantidadAleer, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCantidadCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtArchivoOrigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel4)
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(barraGenerados, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                            .addComponent(barraLeidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(13, 13, 13))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Generar_, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txturl, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConAnual)
                    .addComponent(ConCabecera)
                    .addComponent(DiferenciarMails))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cantidadAleer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtCantidadCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(FechaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txturl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArchivoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Origen_))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Generar_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraLeidos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barraGenerados, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Origen_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Origen_ActionPerformed
 
        //Dir = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().toString();
        
        
          DirOrigen = Dir + "\\" + directorioOrigen;//directorigen tiene el valor que viene de impuesto "automotor//"
        
          
        File archivoSeleccionado;
        
        
        JFileChooser seleccionarArchivo = new JFileChooser();
        seleccionarArchivo.setFileFilter(filter);
        seleccionarArchivo.setCurrentDirectory(new File(DirOrigen));
        seleccionarArchivo.showOpenDialog(null);
        archivoSeleccionado = seleccionarArchivo.getSelectedFile();
        txtOrigen = archivoSeleccionado.getAbsoluteFile().toString();
  
         
        if(txtOrigen != ""){ 
        txtArchivoOrigen.setText(txtOrigen);
        Generar_.setEnabled(true);
        }

    }//GEN-LAST:event_Origen_ActionPerformed

    private void Generar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Generar_ActionPerformed
        boolean seguir = false;
      
            try
            {
                int cantidad = Integer.parseInt(this.cantidadAleer.getText());
                seguir = true;
            }
            catch (Exception e) {
                System.out.println ("No está especificado 'Cantidad' ");
            }

            if (seguir){
                
                ImpuestoV = Impuesto.getSelectedItem().toString();
                 
                txtDestino = MyReplace(DirOrigen, txtOrigen);

                Procesar();

            }else {
                cantidadAleer.requestFocus();
                JOptionPane.showMessageDialog(null, " Ingrese la cantidad de suscripciones a procesar. ", " Boleta Electrónica ", JOptionPane.ERROR_MESSAGE);  
            }
            
            this.getContentPane().setBackground(Color.orange);
            
    }//GEN-LAST:event_Generar_ActionPerformed

    

    public void Procesar() {
        
        int cantidadMailIgual = 0;
        int counter = 0; 
        int conta = 0; 
        int valor1 = 0;
        int distintos = 0; 
        int contador = 0;        
        int escritos = 0;
        int cantidadCorte = Integer.parseInt(txtCantidadCorte.getText());
        String line = "" ;
        String mailLinea = ".";
        String datosTodosObjetos =".";
        String ultimoMail = ".";
        int cont=0;
        
        BufferedReader file = null; 
        
        FileWriter SW = null; 
        BufferedWriter CsvSW = null;
        
        FileWriter SWinforme = null;
        BufferedWriter br = null; 
        
        
        
        int cantidadArchivosGenerados = 1;
       
        
         try {
         Date fecha1 = FechaOpcion.getDate();
         DateFormat f=new SimpleDateFormat("dd-MM-yyyy");
         String fecha2 =f.format(fecha1);
        
              fechaOpcion = StringaDate(fecha2);
         
         } catch (Exception e) {}
         
         
         
        String  Patth = directorioOrigen + "informe.txt"; 
        String nombreArchivoGenerado = String.format ("%s -Parte- %s.csv", txtDestino, cantidadArchivosGenerados);
        
        String nombreArchivoCsv = String.format("%s-Archivo-%s.csv",directorioDestino, txtDestino);
                  
        System.out.println ("archivo destino------------->"+nombreArchivoCsv);
        try{
            SW = new FileWriter(nombreArchivoCsv,true);
            CsvSW = new BufferedWriter(SW);     
            
            CsvSW.flush();
            CsvSW.close(); 
        } catch (Exception e){}
       

        
       try{
            SWinforme = new FileWriter(DirOrigen,true);
                br = new BufferedWriter(SWinforme);
                br.write("Se generearon los siguientes archivos:");
                br.newLine();
                br.write (String.format("Archivo ** %s **", nombreArchivoGenerado));
                
                br.flush();
                br.close(); 
        } catch (Exception e){}
           
    
        EscribirCabecera(CsvSW);
       
        try{          
            file = new BufferedReader (new FileReader(txtOrigen));
            line = file.readLine();
          }catch(Exception e) {
            System.out.println("Error de lectura del fichero");
         }

            while(line != null){

                    LeerLinea(line);

                    if(mailAux == "")
                    {
                     mailAux = mail; 
                     razonsocialAux = razonsocial;
                     cuitAux = cuit;
                    }

                    ArmarDatosMail();

                if ((mail != mailAux) || (razonsocial != razonsocialAux))
                {


                    if ((DiferenciarMails.isSelected()) && (mailAux == ultimoMail)){
                        cantidadMailIgual++;
                    }
                    else{
                        cantidadMailIgual = 0;             
                    }        
                    
                    
                    if (cantidadMailIgual == 0){
                        mailLinea = String.format("%s|",mailAux);             
                    }
                    else{                
                        mailLinea = String.format("s% s%|", mailAux, String.valueOf(cantidadMailIgual));                  
                    }



                        ultimoMail = mailAux;

                       
                        mailLinea += String.format("%s|Cuit: %s | %s | %s | %s | %s | %s | %s | %s", razonsocialAux, formatearCuit(cuitAux), fechaVencimiento, fechaOpcion, anio, cuota, impuesto, datosTodosObjetos, porcentaje); 

                        System.out.println("--Mai Linea ---" + mailLinea);
                    
                    try {           
                        if (escritos == cantidadCorte){
                           try{ 

                                br.write(String.format("Con %d suscripciones y %d mails para enviar", contador, escritos));
                                br.newLine();
                                br.flush();
                              br.close();

                                escritos = 0;
                                contador = 0;
                                cantidadArchivosGenerados++;

                              nombreArchivoGenerado = String.format(" %s-Parte-%s.csv", txtDestino, cantidadArchivosGenerados);
                                
                                br = new BufferedWriter(SWinforme);
                                br.write("Se generearon los siguientes archivos:");
                                br.newLine();
                                br.write (String.format("Archivo ** %s **", nombreArchivoGenerado));
                                
                                br.flush();
                              br.close();

                                EscribirCabecera(CsvSW);
                                
                            } catch (Exception e){} 
                        }      
                    } catch (Exception e) {
                      System.out.println("Archivo no encontrado. Cambia la ruta de INFORME");
                    }   

                    distintos++;
                    escritos++;

                   /* valor1 = (Integer.parseInt(cantidadAleer.getText())/ 100);
                    
                    if ( barraGenerados.getValue()==0){
                    
                        barraGenerados.setValue(distintos / valor1);
                          
                    }
                   
                    if ((distintos/ valor1) <= (barraGenerados.getValue()))
                    {
                        barraGenerados.setValue (distintos/ valor1);                
                    }
                   */

                   try {
                   
                    CsvSW.write(mailLinea);
                    CsvSW.newLine();
                    
                     CsvSW.flush();
                     CsvSW.close(); 
                    
                    } catch (Exception e){
                    
                    System.out.print("que pasó?");
                    
                    } 
                     
                    mailAux = mail;
                    razonsocialAux = razonsocial;
                    cuitAux = cuit;                   
                    datosTodosObjetos = datosObjeto;                    
                    datosObjeto = "";
                }
                else{ 
                    datosTodosObjetos += datosObjeto;
                    conta++; 
                }//if

                try{          
                     line = file.readLine();
                  }catch(Exception e) {
                      System.out.println("Error de lectura del fichero");
                  }  
              
            }//while

        
            ultimoMail = mailAux;  
            
            
            mailLinea += String.format("Cuit: %s | %s | %s | %s | %s | %s | %s | %s", formatearCuit(cuitAux), fechaVencimiento, fechaOpcion, anio, cuota, impuesto, datosTodosObjetos, porcentaje); 

            
            try{
                
               CsvSW.write(mailLinea);
               CsvSW.newLine();   
               
               CsvSW.flush();
               CsvSW.close(); 

            } catch (Exception e){} 
            
            mailAux = mail;
            razonsocialAux = razonsocial;
            cuitAux = cuit;

            distintos++;
            escritos++;
            
            try{ 
                br.write(String.format("Con %d suscripciones y %d mails para enviar", contador, escritos));
                br.newLine();
                br.flush();
                br.close();
            }catch(Exception e){} 
            
            try{          
               file.close();
            }catch(Exception e){} 
        
            String mensaje = "";
            
            
             if (counter != (Integer.parseInt(cantidadAleer.getText()))){
                 
                mensaje = String.format(", \"Cantidad de registros ERRONEA!!\" La cantidad de suscripciones configuradas %d y es distinta a la cantidad de registros leidos %d. De todas maneras se generaron %d mails para enviar. ", Integer.parseInt(cantidadAleer.getText()), counter, distintos);
                 JOptionPane.showMessageDialog(null, mensaje);
                
            }else{
                
                mensaje = String.format("Se leyeron %d suscripciones y se generaron %d mails para enviar. Armar bases?", counter, distintos);


               barraGenerados.setValue (100); // agregado Ñ para que la barra de Generados termine. 

              
               
               
                if ( JOptionPane.showConfirmDialog(null, "Control Totales ATENCION", "Alerta!", JOptionPane.YES_NO_OPTION) == 1)
                {
                    //this.InformarArchivosGenerados();
                }

            }
            
            
            
            
            
            
 }   
 

        

private String formatearCuit(String pCuit){
                
        
    String cuitFormateado = "";
            
        if (pCuit.length() == 11)
        {
          String primeraParte = pCuit.substring(0, 2);
          String dni = pCuit.substring(2, 10);
          String digito = pCuit.substring(10, 11);
          cuitFormateado = String.format("%s-%s-%s", primeraParte, dni, digito);
         }
        
     return cuitFormateado;

}
//Dife

   private void EscribirCabecera(BufferedWriter pSw){
            if (this.ConCabecera.isSelected())
            {
               try {
                pSw.write("email|nombre|cuit|fechav|fechao|anio|cuota|impuesto|datos|descuento");
                pSw.newLine();
               }catch(Exception e){}
            }

  }

private void LeerLinea(String line)
{
            
           
    switch (ImpuestoV)
    {
        case "Impuesto Automotor":
        case "Impuesto Embarcaciones":
        {
                        
            mail = ((line.substring(0, 255).toLowerCase()).replaceAll(" ","") );
            objeto = (line.substring(255,266).replaceAll(" ",""));                                                    
            objetoFormateado = objeto.toUpperCase();
            razonsocial = trimEnd(line.substring(266,326));   
            porcentaje = "";  
            fechaVencimientoNumero = (line.substring(334, 344).replaceAll(" ",""));                        
            fechaVencimiento = StringaDate(fechaVencimientoNumero); 
            montoCuota = line.substring(345, 362).replaceAll(" ","") ;
            montoAnual = line.substring(362, 378) ;
            codigoElectronico = line.substring(378, 392).replaceAll(" ","");
            debitoCredito = line.substring(392, 393).replaceAll(" ","");                           
            buenContribuyente = line.substring(393, 394).replaceAll(" ","");                           
            cuit = line.substring(394, 405).replaceAll(" ","");
                           
                    System.out.println ("mail----->"+ mail);
                    System.out.println ("objeto----->"+ objeto);
                    System.out.println ("razon social----->"+ razonsocial);
                    System.out.println ("fecha de vencimiento----->"+ fechaVencimientoNumero);
                    System.out.println ("monto cuota----->"+ montoCuota);
                    System.out.println ("monto anual----->"+ montoAnual);
                    System.out.println ("codigo electronico----->"+ codigoElectronico);
                    System.out.println ("debito credito----->"+ debitoCredito);
                    System.out.println ("buen contribuyente----->"+ buenContribuyente);
                    System.out.println ("cuit----->"+ cuit);
 
            Variable = "Prueba  Automotor" ;


            porcentaje = "20";
            anio = "2020";
            cuota = "3";

              break;
        }
        case "Impuesto Edificado":
        case "Impuesto Baldio":
        case "Impuesto Rural":
        {
                       
            mail = ((line.substring(0, 255).toLowerCase()).replaceAll(" ","") );
            objeto = (line.substring(255,266).replaceAll(" ",""));                                                    
            objetoFormateado = formatearObjetoInmobiliario(objeto);
            razonsocial = trimEnd(line.substring(266,326));   
            porcentaje = "";  
            fechaVencimientoNumero = (line.substring(334, 344).replaceAll(" ",""));                        
            fechaVencimiento = StringaDate(fechaVencimientoNumero); 
            montoCuota = line.substring(345, 362).replaceAll(" ","") ;
            montoAnual = line.substring(362, 378) ;
            // codigoElectronico = line.substring(378, 392).replaceAll(" ","");
            debitoCredito = line.substring(392, 393).replaceAll(" ","");                           
            buenContribuyente = line.substring(393, 394).replaceAll(" ","");                           
            cuit = line.substring(394, 405).replaceAll(" ","");

            Variable = "Prueba Edificacion -baldio -rural ";    
                                    
              break;
        }
        case "Impuesto Complementario":
        {
             LeerLineaNuevo(line);
              break;
        }
        default:
              break;
        }


      razonsocial = Mayusculas(razonsocial);
       
}



private void LeerLineaNuevo(String line){
    
    mail = ((line.substring(0, 120).toLowerCase()).replaceAll(" ","") );
         objeto = (line.substring(120,131).replaceAll(" ",""));                                                    
         objetoFormateado = formatearObjetoInmobiliario(objeto);
         planta = (line.substring(131,132).replaceAll(" ",""));
         razonsocial = trimEnd(line.substring(132,192));   
         porcentaje = (line.substring(192,194).replaceAll(" ",""));
         anio = (line.substring(194,198).replaceAll(" ",""));
         cuota = (line.substring(198,200).replaceAll(" ",""));
         fechaVencimientoNumero = (line.substring(200, 210).replaceAll(" ",""));                        
         fechaVencimiento = StringaDate(fechaVencimientoNumero); 
         montoCuota = line.substring(210, 227).replaceAll(" ","") ;
         montoAnual = line.substring(227, 244) ;
         debitoCredito = line.substring(244, 245).replaceAll(" ","");                                                  
         cuit = line.substring(245, 256).replaceAll(" ","");
    
         Variable = "Prueba  Complementario ";

           
            if (ConAnual.isSelected())
            {
                cuota = cuota + " y Saldo Anual";
            }

            switch (planta)
            {
                case "B":
                    {
                        plantaDescri = "Baldio";
                        break;
                    }
                case "E":
                    {
                        plantaDescri = "Edificado";
                        break;
                    }
                case "R":
                    {
                        plantaDescri = "Rural";
                        break;
                    }
                default:
                    break;
            }


            razonsocial = Mayusculas(razonsocial);
                
    }
    
    private String formatearObjetoInmobiliario(String pObjeto)
        {
           
            String partido = pObjeto.substring(0, 3).replaceAll(" ","") ;
            String partida = pObjeto.substring(3, 9).replaceAll(" ","") ;
            String digito = pObjeto.substring(9, 10).replaceAll(" ","") ;

            return (partido + "-" + partida + "-" + digito );
        }  
    
    private void ImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImpuestoActionPerformed

            FraccionImpuesto = Impuesto.getSelectedItem().toString();

            directorioDestino = "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent\\Destino\\";

                                //home :"C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Destino\\";                    
            //List<String> cuotas = new List<String>();



            switch (FraccionImpuesto)
            {
                case "Impuesto Automotor":
                    {
                        directorioOrigen += "Automotores\\";
                        directorioDestino += "Automotores\\";

                        System.out.println("Origen-------------> " + directorioOrigen) ;
                        System.out.println("Destino-------------> " + directorioDestino) ;    
                        
                        impuestoLiquidar = "1";
                        nombreImpuesto = "Automotor";
                        txturl.setText ("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D1%26opc%3DLIC%26Frame%3DSI%26oi%3D");


                        break;
                    }
                case "Impuesto Embarcaciones":
                    {
                        directorioOrigen += "Embarcaciones\\";
                        directorioDestino += "Embarcaciones\\";
                        nombreImpuesto = "Embarcaciones";
                        impuestoLiquidar = "3";
                        txturl.setText ("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D3%26opc%3DLIC%26Frame%3DSI%26oi%3D");
                        break;

                    }
                case "Impuesto Edificado":
                    {
                        directorioOrigen += "Edificado\\";
                        directorioDestino += "Edificado\\";
                        nombreImpuesto = "Edificado";
                        impuestoLiquidar = "0";
                        txturl.setText("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D0%26opc%3DLIC%26Frame%3DSI%26oi%3D");
                        break;
                    }
                case "Impuesto Baldio":
                    {
                        directorioOrigen += "Baldio\\";
                        directorioDestino += "Baldio\\";
                        nombreImpuesto = "Baldio";
                        impuestoLiquidar = "0";
                        txturl.setText("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D0%26opc%3DLIC%26Frame%3DSI%26oi%3D");
                        break;
                    }
                case "Impuesto Rural":
                    {
                        directorioOrigen += "Rural\\";
                        directorioDestino += "Rural\\";
                        impuestoLiquidar = "0";
                        nombreImpuesto = "Rural";
                        txturl.setText("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D0%26opc%3DLIC%26Frame%3DSI%26oi%3D");
                        break;
                    }
                case "Impuesto Complementario":
                    {
                        directorioOrigen += "Complementario\\";
                        directorioDestino += "Complementario\\";
                        nombreImpuesto = "Complementario";
                        impuestoLiquidar = "10";
                        txturl.setText ("https://www.arba.gov.ar/aplicaciones/LiqPredet.asp?imp=10&Fame=NO&origen=WEB&op=IIC");
                        break;
                    }

                default:
                    {
                       // cuotas = new List<string>() { "0" };
                        break;
                    }       
                   
    }//GEN-LAST:event_ImpuestoActionPerformed
       
            
            
            
            if(FraccionImpuesto != ""){
            Origen_.setEnabled(true);
            }

    }  
   
    private void ArmarDatosMail(){

            switch (debitoCredito) 
            {
                case "1":
                    {
                        medioPago = "Débito en Cuenta";
                        break;
                    }
                case "D":
                    {
                        medioPago = "Débito en Cuenta";                        
                        break;
                    }
                case "2":
                    {
                        medioPago = "Tarjeta de Crédito";                        
                        break;
                    }
                case "0":
                case "C":
                    {
                        medioPago = "<a href=\"" + txturl.getText() + objeto + "\">Ingresar</a>";
                        
                        /*
                        if (this.Impuesto.SelectedIndex == 5)
                        {
                            //medioPago = "<a href=\"https://sso.arba.gov.ar/Login/login?service=http%3A%2F%2Fwww4.arba.gov.ar%2FLiqPredet%2Fsso%2FInicioLiquidacionIIC.do%3FFrame%3DNO%26origen%3DWEB%26imp%3D10%26cuit%3D\">Ingresar</a>";
                            medioPago =  "<a href=\"https://www.arba.gov.ar/aplicaciones/LiqPredet.asp?imp=10&Fame=NO&origen=WEB&op=IIC\">Ingresar</a>";
                        }
                        else
                        {
                            medioPago = string.Format("<a href=\"http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D{0}%26opc%3DLIC%26Frame%3DSI%26oi%3D{1}\">Ingresar</a>", impuestoLiquidar, objeto);
                        }      
                        */
                        break;
                    }
             /*   case "C":
                    {
                        if (this.Impuesto.SelectedIndex == 5)
                        {
                            medioPago = "<a href=\"https://sso.arba.gov.ar/Login/login?service=http%3A%2F%2Fwww4.arba.gov.ar%2FLiqPredet%2Fsso%2FInicioLiquidacionIIC.do%3FFrame%3DNO%26origen%3DWEB%26imp%3D10%26cuit%3D\">Ingresar</a>";
                        }
                        else
                        {
                            medioPago = string.Format("<a href=\"http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D{0}%26opc%3DLIC%26Frame%3DSI%26oinombreImpuesto%3D{1}\">Ingresar</a>", impuestoLiquidar, objeto);
                        }
                        break;
                    }*/
                default:
                    {
                        // medioPago = "ERROR";
                        // break;

                        /* Automotores entra acá por defaoult, el "txturl.text" de 
                           automotores suma "+ {0}" que acá 
                           va a tomar el valor de 'objeto' */



                        medioPago = "<a href=\"" + txturl.getText() + objeto +"\">Ingresar</a>"; 
                        break;
                    }
            }
        }
    
    
    
    /////////////////extras Ñ: 
    
    public static String trimEnd(String value) {
        return value.replaceFirst("\\s+$", "");
    }
    
    public static String StringaDate(String fechaCadena){
        
       int anio, mes, dia;
     
       String Fechas;
       
       dia =  Integer.valueOf(fechaCadena.substring(0,2));
       mes =  Integer.valueOf(fechaCadena.substring(3,5));
       anio =  Integer.valueOf(fechaCadena.substring(6,10));
 
        ZoneId zoneId = ZoneId.of( "Europe/Madrid" );
        ZonedDateTime zdt = ZonedDateTime.of(anio,  mes, dia,  0,  0,  0,  0,  zoneId );   
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate ( FormatStyle.FULL );
        Locale locale = new Locale ( "es" , "ES" );
        formatter = formatter.withLocale ( locale );

        String output = zdt.format ( formatter );    

        //("zdt: " + zdt + " with locale: " + locale + " | output: " + output);

        Fechas = output;

    return Fechas; 
    
    }
    
    public String MyReplace(String Val1, String Val2){
     
        String resultado = "";
        
        int diff = ( Val2.length() - Val1.length());          
            
        for (int j = 0 ; j < diff ; j++){
            Val1 += " "; 
        }
                      
        for (int i= 0 ; i<Val2.length();i++) {
        
           if (Val2.charAt(i) != Val1.charAt(i)){
               
               if ( Val2.charAt(i) != '.' ){
                   
                 NombreOrigen += Val2.charAt(i);
               
               }
               
           }
        }

        resultado = NombreOrigen; //.substring(1)
       
        System.out.println("my Replace----------> " + resultado);
        
       return resultado; 
    }
    
    
    
  public String Mayusculas(String cadena) {
       
    char[] caracteres = cadena.toCharArray();
   
    caracteres[0] = Character.toUpperCase(caracteres[0]);

    for (int i = 0; i < cadena.length()- 2; i++) {

        if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ','){
              caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]); 
            }
    }
   
    return new String(caracteres);
  }
    
    
  /* 
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
 */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ConAnual;
    private javax.swing.JCheckBox ConCabecera;
    private javax.swing.JCheckBox DiferenciarMails;
    private com.toedter.calendar.JDateChooser FechaOpcion;
    private javax.swing.JButton Generar_;
    private javax.swing.JComboBox<String> Impuesto;
    private javax.swing.JButton Origen_;
    private javax.swing.JProgressBar barraGenerados;
    private javax.swing.JProgressBar barraLeidos;
    private javax.swing.JTextField cantidadAleer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtArchivoOrigen;
    private javax.swing.JTextField txtCantidadCorte;
    private javax.swing.JTextField txturl;
    // End of variables declaration//GEN-END:variables

  
}
