package campania_java;

/*
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.time.LocalDate;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker; */

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class frmPrincipal extends javax.swing.JFrame { 
    
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("DD/MM/YYYY");
    private String directorioOrigen = "";
    private String directorioDestino = "";
    private String txtOrigen = "";
    private String txtDestino = "";
    private String txtDestino2 ="";
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
    //private String impuesto = "";
    private String fechaOpcion = "";
    private String datosObjeto = "";
    private String objetoFormateado = "";
    private String Variable = "";
    private String nombreArchivoCsv = "";
    private String Patth = "";
    int sum = 0;
    int counter = 0; 
    int raws = 0; 
        int cont; 
                   int contt;
    
    
    private FileNameExtensionFilter filter = new FileNameExtensionFilter ("Archivos Txt", "txt");
  
    public frmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Generar Bases para campaña por mail V1");
        JT_Tantos.setHorizontalAlignment(JT_Tantos.RIGHT);
        jT_Totales.setHorizontalAlignment(jT_Totales.RIGHT);
        
         //this.getContentPane().setBackground(Color.getHSBColor(80, 154, 50)); 
        
        Generar_.setEnabled(false);
        Origen_.setEnabled(false);
        
        Dir = "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Origen";
        
              //Home  "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Origen";
              //ARBA : "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent";                  
        
        directorioDestino = "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Destino\\";      
        
        
               //Home  "C:\Users\sehent\Desktop\CampaniaOriginal\TXTBase-pruebas-\Destino";
              //ARBA : "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Destino\\";                  
        
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
        Mails = new javax.swing.JLabel();
        JT_Tantos = new javax.swing.JTextField();
        jT_Totales = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Impuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Impuesto Automotor", "Impuesto a las Embarcaciones", "Impuesto Urbano Edificado", "Impuesto Urbano Baldío", "Impuesto Rural", "Impuesto Complementario" }));
        Impuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpuestoActionPerformed(evt);
            }
        });

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

        barraLeidos.setStringPainted(true);

        barraGenerados.setForeground(new java.awt.Color(255, 153, 51));

        jLabel3.setText("Subscripciones Leidas");

        jLabel4.setText("Mails generados");

        jLabel5.setText("Contar Cada");

        ConCabecera.setText("Con Cabecera");

        ConAnual.setText("Con Anual");

        DiferenciarMails.setText("Diferenciar Mails");

        jLabel6.setText("fecha Opcion");

        Mails.setText(".");

        JT_Tantos.setEditable(false);

        jT_Totales.setEditable(false);

        jLabel8.setText("de");

        jLabel9.setText("Subscripciones Leidas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Mails, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(barraGenerados, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(Generar_)))
                .addContainerGap(240, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Impuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(138, 138, 138)
                                .addComponent(ConCabecera)
                                .addGap(52, 52, 52)
                                .addComponent(DiferenciarMails)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Origen_)
                                        .addGap(2, 2, 2))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtArchivoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(FechaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(ConAnual))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1)
                                                .addGap(27, 27, 27)
                                                .addComponent(cantidadAleer, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCantidadCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txturl, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(JT_Tantos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jT_Totales, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraLeidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txturl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArchivoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Origen_))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Generar_, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addComponent(barraLeidos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Mails, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barraGenerados, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JT_Tantos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_Totales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Origen_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Origen_ActionPerformed
 
        //Dir = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().toString();

          DirOrigen ="";
          DirOrigen = Dir + "\\" + directorioOrigen;//directorigen tiene el valor que viene de impuesto "automotor//"
                 
        File archivoSeleccionado;
            
        JFileChooser seleccionarArchivo = new JFileChooser();
        seleccionarArchivo.setFileFilter(filter);
        seleccionarArchivo.setCurrentDirectory(new File(DirOrigen));
        seleccionarArchivo.showOpenDialog(null);
        archivoSeleccionado = seleccionarArchivo.getSelectedFile();
        
        try {
             txtOrigen = archivoSeleccionado.getAbsoluteFile().toString();
             
         }catch(Exception e) {System.out.println("origen vacio");}
        
        
       
        System.out.println("origen ventanilla---------------------"+txtOrigen);
         
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
              
                System.out.println("txtdestino ------"+ txtDestino);
                Procesar();

            }else {
                cantidadAleer.requestFocus();
                JOptionPane.showMessageDialog(null, " Ingrese la cantidad de suscripciones a procesar. ", " Boleta Electrónica ", JOptionPane.ERROR_MESSAGE);  
            }
            
           
            
    }//GEN-LAST:event_Generar_ActionPerformed


    public void Procesar() {
      
      this.getContentPane().setBackground(Color.getHSBColor(80, 150, 49));   
        
      Thread hilo1=new Thread(){
     
      @Override
       public void run(){
            
        try {
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
       
        int cantidadMailIgual = 0;
        int cont=0;
        int conta = 0;
        int distintos = 0; 
        int contador = 0;        
        int escritos = 0;
        int cantidadArchivosGenerados = 1;
        int cantidadCorte = Integer.parseInt(txtCantidadCorte.getText());
        int cantidadaleer = Integer.parseInt(cantidadAleer.getText());
        Long Lineas = 0L; 
        String line = "" ;
        String mailLinea = ".";
        String datosTodosObjetos =".";
        String ultimoMail = ".";
       
        
        BufferedReader filAS = null;
        BufferedReader file = null; 
        FileWriter SW = null; 
       
        FileWriter SWinforme = null;
        BufferedWriter br = null; 
        
        
        try {
            Date fecha1 = FechaOpcion.getDate();
            DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            String fecha2 = f.format(fecha1);

            fechaOpcion = StringaDate(fecha2);

        } catch (Exception e) {
       }
         
       
        String nombreArchivoGenerado = String.format ("%s-Parte-%s.csv", txtDestino, cantidadArchivosGenerados);        
        
        String nombreArchivoCsv = String.format("%s %s",directorioDestino, nombreArchivoGenerado);          
        
        System.out.println("Destino------------" + nombreArchivoCsv);
        try{
            SW = new FileWriter(nombreArchivoCsv,true);
        } catch (Exception e){System.out.println("Error de lectura del fichero");}
       
        
        
         Patth = (directorioDestino + "Informe.txt");
        try{
            SWinforme = new FileWriter(Patth,true);
                br = new BufferedWriter(SWinforme);
                br.write("Se generearon los siguientes archivos:");
                br.newLine();
                br.write (String.format("Archivo ** %s **", nombreArchivoGenerado));
                
        } catch (Exception e){}
           
    
        EscribirCabecera(SW);
        
         
        try{
            filAS = new BufferedReader (new FileReader(txtOrigen));
            line = filAS.readLine();

            Lineas = filAS.lines().count();
            raws =  Math.toIntExact(Lineas); 
            jT_Totales.setText(String.valueOf(raws)); 
            filAS.close();
            }catch(Exception e) {System.out.println("Error de lectura del fichero");}
        
        

        try{          
            file = new BufferedReader (new FileReader(txtOrigen));
            line = file.readLine();
        }catch(Exception e) {System.out.println("Error de lectura del fichero");}


            while (line != null) {

                LeerLinea(line);

                if (mailAux == "") {
                    mailAux = mail;
                    razonsocialAux = razonsocial;
                    cuitAux = cuit;
                }

                ArmarDatosMail();

                if ((!mail.equals(mailAux)) || (!razonsocial.equals(razonsocialAux))) {

                    if ((DiferenciarMails.isSelected()) && (mailAux == ultimoMail)) {
                        cantidadMailIgual++;
                    } else {
                        cantidadMailIgual = 0;
                    }

                    if (cantidadMailIgual == 0) {
                        mailLinea = String.format("%s|", mailAux);
                    } else {
                        mailLinea = String.format("s% + s%|", mailAux, String.valueOf(cantidadMailIgual));
                    }

                    ultimoMail = mailAux;

                    mailLinea += String.format("%s|Cuit: %s | %s | %s | %s | %s | %s | %s | %s ", razonsocialAux, formatearCuit(cuitAux), fechaVencimiento, fechaOpcion, anio, cuota, ImpuestoV, datosTodosObjetos, porcentaje);

                    System.out.println("--Mai Linea ---" + mailLinea);

                    try {
                        if (escritos == cantidadCorte) {
                            try {

                                br.write(String.format("Con %d suscripciones y %d mails para enviar", contador, escritos));
                                br.newLine();

                                escritos = 0;
                                contador = 0;
                                cantidadArchivosGenerados++;

                                try {
                                    SW.flush();
                                    SW.close();
                                } catch (Exception e) {
                                }

                                nombreArchivoGenerado = String.format("%s-Parte-%s.csv", txtDestino, cantidadArchivosGenerados);
                                nombreArchivoCsv = String.format("%s %s", directorioDestino, nombreArchivoGenerado);
                                try {
                                    SW = new FileWriter(nombreArchivoCsv, true);
                                } catch (Exception e) {
                                    System.out.println("Error de lectura del fichero");
                                }

                                br.write(String.format("Archivo ** %s **", nombreArchivoGenerado));

                                EscribirCabecera(SW);

                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Archivo no encontrado. Cambia la ruta de INFORME");
                    }

                    distintos++;
                    escritos++;

                    BarraGenerados(raws, distintos);

                    try {

                        SW.append(mailLinea);
                        SW.append('\n');

                    } catch (Exception e) {
                        System.out.print("PROBLEM1");
                    }

                    mailAux = mail;
                    razonsocialAux = razonsocial;
                    cuitAux = cuit;
                    datosTodosObjetos = datosObjeto;
                    datosObjeto = "";
                } else {
                    datosTodosObjetos += datosObjeto;
                    conta++;
                }//if

                counter++;
                contador++;
                
                JT_Tantos.setText(String.valueOf(counter));   

                CargarBarra(raws);


                try {
                    line = file.readLine();
                } catch (Exception e) {
                    System.out.println("Error de lectura del fichero");
                }

            }//while

        

        if ((DiferenciarMails.isSelected()) && (mailAux == ultimoMail)){
            cantidadMailIgual++;
           }else{
            cantidadMailIgual = 0;             
        }        
                      
        if (cantidadMailIgual == 0){
            mailLinea = String.format("%s|",mailAux);             
         }else{                
            mailLinea = String.format("s% + s%|", mailAux, String.valueOf(cantidadMailIgual));                  
        }
        
       
        ultimoMail = mailAux;  
            
        mailLinea += String.format("Cuit: %s | %s | %s | %s | %s | %s | %s | %s ", formatearCuit(cuitAux), fechaVencimiento, fechaOpcion, anio, cuota, ImpuestoV, datosTodosObjetos, porcentaje); 

        try{
           SW.append(mailLinea);
           SW.append('\n');
        } catch (Exception e){System.out.print("PROBLEM1");} 
            
        mailAux = mail;
        razonsocialAux = razonsocial;
        cuitAux = cuit;

        distintos++;
        escritos++;
            
        try {
            br.write(String.format("Con %d suscripciones y %d mails para enviar", contador, escritos));
            br.newLine();
            br.flush();
            br.close();
        } catch (Exception e) {
        }
            
        try{          
            file.close();
        }catch(Exception e){} 
        
        String mensaje = "";
        
        
        getContentPane().setBackground(Color.getHSBColor(80, 300, 100));     
        
        if (counter != (Integer.parseInt(cantidadAleer.getText()))){
                 
            mensaje = String.format(", \"Cantidad de registros ERRONEA!!\" La cantidad de suscripciones configuradas %d y es distinta a la cantidad de registros leidos %d. De todas maneras se generaron %d mails para enviar. ", Integer.parseInt(cantidadAleer.getText()), counter, distintos);
            JOptionPane.showMessageDialog(null, mensaje);
                
        }else{
                
            mensaje = String.format("Se leyeron %d suscripciones y se generaron %d mails para enviar. Armar bases?", counter, distintos);

            barraGenerados.setValue (cantidadaleer); // agregado Ñ para que la barra de Generados termine. 
        }
        
        int result = JOptionPane.showConfirmDialog(null, "Informar archivos generados? (Zip)", "Alerta!", JOptionPane.YES_NO_OPTION);
        
        if ( result == JOptionPane.YES_OPTION){
                   
                InformarArchivosGenerados();
                directorioDestino = "";
                 directorioOrigen = "";
                    
        }else{
            
                directorioDestino = "";
                 directorioOrigen = "";
            
        }
            
    
        
        try{
            SW.flush();
            SW.close();
        } catch (Exception e){} 
         
        
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
    }; 
     
    hilo1.start();    
        
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

   private void EscribirCabecera(FileWriter pSw){
            if (this.ConCabecera.isSelected())
            {
               try {
                pSw.write("email|nombre|cuit|fechav|fechao|anio|cuota|impuesto|datos|descuento");
                pSw.append('\n');
               }catch(Exception e){}
            }

  }

private void LeerLinea(String line)
{
           
    switch (ImpuestoV)
    {
        case "Impuesto Automotor":
        case "Impuesto a las Embarcaciones":
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
        case "Impuesto Urbano Edificado":
        case "Impuesto Urbano Baldío":
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


      //razonsocial = Mayusculas(razonsocial);
       
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


           

            if(FraccionImpuesto == null){
              FraccionImpuesto =".";
            }
            


                                //home :"C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Destino\\"; 
                                //ARBA : "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent\\Destino\\";
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
                case "Impuesto a las Embarcaciones":
                    {
                        directorioOrigen += "Embarcaciones\\";
                        directorioDestino += "Embarcaciones\\";
                        nombreImpuesto = "Embarcaciones";
                        impuestoLiquidar = "3";
                        txturl.setText ("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D3%26opc%3DLIC%26Frame%3DSI%26oi%3D");
                        break;

                    }
                case "Impuesto Urbano Edificado":
                    {
                        directorioOrigen += "Edificado\\";
                        directorioDestino += "Edificado\\";
                        nombreImpuesto = "Edificado";
                        impuestoLiquidar = "0";
                        txturl.setText("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D0%26opc%3DLIC%26Frame%3DSI%26oi%3D");
                        break;
                    }
                case "Impuesto Urbano Baldío":
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
            case "1":{
                
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
        
    
        if ((Impuesto.getSelectedItem().toString())== "Impuesto Complementario")
            {
                datosObjeto = "<tr class='datos'>";
                datosObjeto += String.format("<td class='gris'>%s - %s</td>", objetoFormateado, plantaDescri);
                datosObjeto += String.format("<td class='amarillo'>Cuota s%</td>", cuotaNumero);
                datosObjeto += String.format("<td class='amarillo'>%s</td>", montoCuota);
                datosObjeto += String.format("<td class='gris'>%s</td>", medioPago);
               // datosObjeto += string.Format("<td class=''>%s</td>", Variable);

                datosObjeto += "</tr>";
        }else{
            
            if (ConAnual.isSelected())
             {
                datosObjeto = "<tr class='datos'>";
                datosObjeto += String.format("<td rowspan='2' class='gris'>%s</td>", objetoFormateado);
                datosObjeto += String.format("<td class='amarillo'>Cuota %s</td>", cuotaNumero);
                datosObjeto += String.format("<td class='amarillo'>%s</td>", montoCuota);
                datosObjeto += String.format("<td rowspan='2' class='gris'>%s</td>", medioPago);
                datosObjeto += "</tr>";
                datosObjeto += "<tr class='datos'><td class='blanco'>Anual</td>";
                datosObjeto += String.format("<td class='blanco'>%s</td>", montoAnual);
                 // datosObjeto += String.Format("<td class=''>%s</td>", Variable);
                datosObjeto += "</tr>";
            }else{
                datosObjeto = "<tr class='datos'>";
                datosObjeto += String.format("<td class='gris'>%s</td>", objetoFormateado); //0190117251
                datosObjeto += String.format("<td class='amarillo'>Cuota %s</td>", cuotaNumero);// Palabra: 'Cuota'. (?) 
                datosObjeto += String.format("<td class='amarillo'>%s</td>", montoCuota);//7.780.90
                datosObjeto += String.format("<td class='gris'>%s</td>", medioPago);//www.ARBA.gov.ar
                // datosObjeto += String.Format("<td class='gris'>%s</td>", Variable);
                datosObjeto += "</tr>";
            }
        }
    }
    
 private void InformarArchivosGenerados(){
   
 // contiene la ruta donde están los archivos a comprimir
        File Fuente = new File(directorioDestino);

     // valida si existe el directorio
     if (Fuente.exists()) {
         
         
         // lista los archivos que hay dentro del directorio
         File[] ficheros = Fuente.listFiles();
       
         System.out.println(" ficheros total : " + ficheros.length);

         // ciclo para recorrer todos los archivos a comprimir
         for (int i = 0; i < ficheros.length; i++) {
             System.out.println("Nombre del fichero: " + ficheros[i].getName());
           


             try {
                 // ruta completa donde están los archivos a comprimir
                 File zipFile = new File(directorioDestino + "guardado.zip");
                

                 InputStream input = null;
                 ZipOutputStream zipOut = null;



                 zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
                 
                int temp = 0;

                if (Fuente.isDirectory()) {
                    
                     for (int j = 0; j < ficheros.length; j++) {
                         
                         input = new FileInputStream(ficheros[j]);
                         zipOut.putNextEntry(new ZipEntry(Fuente.getName() + File.separator + ficheros[j].getName()));
                         while ((temp = input.read()) != -1) {
                             zipOut.write(temp);
                             cont++;
                             
                         }
                         System.out.println("while1 " + cont);
                         
                         contt++;

                         input.close();
                     }
                        System.out.println("while2 " + contt);
                 }

                 zipOut.close();
             } catch (IOException e) {
                 System.err.println("Error -> " + e.getMessage());
             }
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
    
 public String MyReplace(String Val3, String Val4){
     
        String resultado = "";
        NombreOrigen = ""; 
        int diff = ( Val4.length() - Val3.length());          
            
        for (int j = 0 ; j < diff ; j++){
            Val3 += " "; 
        }
                      
        for (int i= 0 ; i<Val4.length();i++) {
        
           if (Val4.charAt(i) != Val3.charAt(i)){
                NombreOrigen += Val4.charAt(i);
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
  
 
 
 private void CargarBarra(int IKant) {
    
     try {
           barraLeidos.setMaximum(IKant);
           barraLeidos.setValue(counter);    

        } catch (Exception e) {
            e.printStackTrace();
        }
     
 }
  
  private void BarraGenerados(int IKant, int IKant2) {
    
     
      try {
           barraGenerados.setMaximum(IKant);
           barraGenerados.setValue(IKant2);  
           Mails.setText(String.valueOf(IKant2));

        } catch (Exception e) {
            e.printStackTrace();
        }
      

      /*Thread hilo2=new Thread(){
     
      @Override
       public void run(){
        try {
           barraGenerados.setMaximum(IKant);
           barraGenerados.setValue(IKant2);  
           Mails.setText(String.valueOf(IKant2));

        } catch (Exception e) {
            e.printStackTrace();
        }
      }
    }; 
     hilo2.start();  */
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
    private javax.swing.JTextField JT_Tantos;
    private javax.swing.JLabel Mails;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jT_Totales;
    private javax.swing.JTextField txtArchivoOrigen;
    private javax.swing.JTextField txtCantidadCorte;
    private javax.swing.JTextField txturl;
    // End of variables declaration//GEN-END:variables

  
}
