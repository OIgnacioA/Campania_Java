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
import java.awt.Toolkit;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class frmPrincipal extends javax.swing.JFrame { 

    private String codigoElectronico = "";
    private String buenContribuyente = "";
    private String Variable = "";
    private String nombreImpuesto = "";
    private String impuestoLiquidar = "";
    private int cont; 
    private int contt;
    private boolean Existe ;
    
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("DD/MM/YYYY");
    private File zipFile = null;
    private String directorioOrigen = "";
    private String directorioDestino = "";
    private String txtOrigen = "";
    private String txtDestino = "";
    private String txtDestino2 ="";
    private String Dir = "";  
    private String ImpuestoV = "";
    private String NombreOrigen = ""; 
    private String FraccionImpuesto =  "";
    private String DirOrigen = "";
    private String objeto = ""; 
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
    private String cuitFormateado = "";
    private String planta = "";
    private String plantaDescri = "";
    private String fechaOpcion = "";
    private String datosObjeto = "";
    private String objetoFormateado = "";
    private String nombreArchivoCsv = "";
    private String Patth = "";
    private String fullPath = ""; 
    private String CarpetaDestino = "";
    private String carpetLocal = ""; 
    private String ArgumentoreaderNuevo = "";
    private String ArgumentoOpcionCheck1 = "";
    private String ArgumentoOpcionCheck2 = "";
    private String nombreDeZip = "" ;
    
    private int cantidad = 0;
    private int sum = 0;
    private int Maximo = 0; 
    private int counter = 1; 
    private int raws = 0;
    private int contzip = 0; 
    private int  valInt = 0 ;
    private int cantidadaleer = 0 ;
    private int distintos = 0; 
    private int ContadorCSV = 0;
    private long size1 = 0;
    private int conterror = 0; 
    
    
        
    
    private FileNameExtensionFilter filter = new FileNameExtensionFilter ("Archivos Txt", "txt");
  
    public frmPrincipal() {
        initComponents();
        
        txtCantidadCorte.setHorizontalAlignment(txtCantidadCorte.CENTER);
        cantidadAleer.setHorizontalAlignment(cantidadAleer.CENTER);
        JT_Tantos.setHorizontalAlignment(JT_Tantos.CENTER);
        jT_Totales.setHorizontalAlignment(jT_Totales.CENTER);
        
        ConCabecera.setSelected(true);
        ModoOriginal.setSelected(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Generar Bases para campaña por mail - [Avendaño - Cruz] 2.0");
        JT_Tantos.setHorizontalAlignment(JT_Tantos.RIGHT);
        jT_Totales.setHorizontalAlignment(jT_Totales.RIGHT);
        Mails.setHorizontalAlignment(Mails.RIGHT);
        directorioDestino = "";
        directorioOrigen = "";
        
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/sobre.png")));
        
        this.getContentPane().setBackground(Color.getHSBColor(80, 154, 50)); 
        
        Generar_.setEnabled(false);
        Origen_.setEnabled(false);
        
        directorioOrigen = "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen";
        
            // ARBA (trabajo real)    \\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen\\Baldio\\archivos pruebas";
            // ARBA (Compartida -RED -pruebas original avendaño-Cruz- ) \\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen\\Baldio\\archivos pruebas               
            //Home  "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Origen";
            //ARBA (mi pc)  : "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent";                  


        directorioDestino = "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Destino";      


            //Home  "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Destino";
            //ARBA  (mi pc): "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent\\Destino";                  
            //ARBA (Compartida -RED) : \\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen\\Baldio\\archivos pruebas
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SelectorDeMetodo = new javax.swing.ButtonGroup();
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
        Correc_Mayus = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        ModoNuevo = new javax.swing.JRadioButton();
        ModoOriginal = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Impuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Impuesto Automotor", "Impuesto a las Embarcaciones", "Impuesto Urbano Edificado", "Impuesto Urbano Baldío", "Impuesto Rural", "Impuesto Complementario" }));
        Impuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpuestoActionPerformed(evt);
            }
        });

        cantidadAleer.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cantidadAleer.setText("1000000");

        jLabel1.setText("Cant. Suscripciones ");

        jLabel2.setText("URL");

        Origen_.setText("Origen");
        Origen_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Origen_ActionPerformed(evt);
            }
        });

        txtArchivoOrigen.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        Generar_.setText("Generar");
        Generar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generar_ActionPerformed(evt);
            }
        });

        barraLeidos.setStringPainted(true);

        barraGenerados.setForeground(new java.awt.Color(255, 153, 51));
        barraGenerados.setStringPainted(true);

        jLabel3.setText("Subscripciones Leidas");

        jLabel4.setText("Mails generados:");

        jLabel5.setText("Contar C/");

        txtCantidadCorte.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtCantidadCorte.setText("15000");
        txtCantidadCorte.setToolTipText("");

        ConCabecera.setText("Con Cabecera");

        ConAnual.setText("Con Anual");

        DiferenciarMails.setText("Diferenciar Mails");

        jLabel6.setText("fecha Opción");

        FechaOpcion.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        JT_Tantos.setEditable(false);
        JT_Tantos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        jT_Totales.setEditable(false);
        jT_Totales.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        jLabel8.setText("de");

        jLabel9.setText("Subscripciones Leidas:");

        Correc_Mayus.setText("Corrección Mayusculas.(Razón Social)");

        jLabel7.setText("(Registros Aprox.)");

        SelectorDeMetodo.add(ModoNuevo);
        ModoNuevo.setText("a RED");

        SelectorDeMetodo.add(ModoOriginal);
        ModoOriginal.setText("A carpeta Local");

        jLabel10.setText("Mails");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27)
                                .addComponent(barraGenerados, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(Mails, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Origen_)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtArchivoOrigen)
                                    .addComponent(txturl)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FechaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cantidadAleer, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtCantidadCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(175, 175, 175)
                                        .addComponent(ModoNuevo))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(barraLeidos, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(152, 152, 152)
                                        .addComponent(Generar_, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(JT_Tantos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jT_Totales, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Correc_Mayus)
                        .addGap(161, 161, 161))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ModoOriginal)
                            .addComponent(Impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(ConAnual)
                        .addGap(18, 18, 18)
                        .addComponent(ConCabecera)
                        .addGap(43, 43, 43)
                        .addComponent(DiferenciarMails)
                        .addGap(84, 84, 84))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Correc_Mayus)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cantidadAleer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)
                        .addComponent(jLabel10)
                        .addComponent(txtCantidadCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FechaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModoNuevo)
                    .addComponent(ModoOriginal))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txturl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArchivoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Origen_))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Generar_, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barraLeidos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Mails, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(barraGenerados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JT_Tantos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_Totales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Origen_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Origen_ActionPerformed
 
               
        File archivoSeleccionado;
            
        JFileChooser seleccionarArchivo = new JFileChooser();
        seleccionarArchivo.setFileFilter(filter);
        seleccionarArchivo.setCurrentDirectory(new File(directorioOrigen));
        seleccionarArchivo.showOpenDialog(null);
        archivoSeleccionado = seleccionarArchivo.getSelectedFile();
        
        try {
             txtOrigen = archivoSeleccionado.getAbsoluteFile().toString();
         }catch(Exception e) {System.out.println("origen vacio");}
        
            File myFile = new File(txtOrigen); 

            
            /////Peso, barras y textbox informativos: ///////////////////////// 

             size1 = myFile.length();
             valInt =  Long.valueOf(size1).intValue();
             Maximo =  (valInt/ 40700) *100; 
             jT_Totales.setText(Integer.toString(Maximo));
             JT_Tantos.setText("0");

             ////////////////////////////////////////////////////////////
          
          
        if(txtOrigen != ""){ 
            txtArchivoOrigen.setText(txtOrigen);
            Generar_.setEnabled(true);
        }
        
       ModoNuevo.setEnabled(false);
       ModoOriginal.setEnabled(false);
       
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
            
            fullPath = txtOrigen ;

           ////////////////////////////////////////////////////////////////////////////////////////

            if ((ModoOriginal.isSelected()  == true ) || ( ModoOriginal.isSelected()  == false)) {

               txtDestino = ObtenerNombre(txtOrigen);
            }

          
           ///////////////////////////////////////////////////////////////////////////////////////

           Procesar();

        }else {
            cantidadAleer.requestFocus();
            JOptionPane.showMessageDialog(null, " Ingrese la cantidad de suscripciones a procesar. ", " Boleta Electrónica ", JOptionPane.ERROR_MESSAGE);  
        }
            
           
            
    }//GEN-LAST:event_Generar_ActionPerformed

public void Procesar() {
     

      int dist = 0 ; 
      this.getContentPane().setBackground(Color.getHSBColor(80, 150, 49));   
        
      Thread hilo1=new Thread(){
     
      @Override
       public void run(){
            
        try {
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
        cantidadaleer = Integer.parseInt(cantidadAleer.getText());
        Generar_.setText("Procesando");
        int cantidadMailIgual = 0;
        int cont=0;
        int conta = 0;
        int contador = 0;        
        int escritos = 0;
        int cantidadArchivosGenerados = 1;
        int cantidadCorte = Integer.parseInt(txtCantidadCorte.getText());
        Long Lineas = 0L; 
        String line = "" ;
        String mailLinea = ".";
        String datosTodosObjetos =".";
        String ultimoMail = ".";
        
       
        
        BufferedReader filAS = null;
        BufferedReader file = null; 
        FileWriter SW = null; 
       
        FileWriter swResultados = null; 
        BufferedWriter br = null; 
        

        try {
            Date fecha1 = FechaOpcion.getDate();
            DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            String fecha2 = f.format(fecha1);

            fechaOpcion = StringaDate(fecha2);

        } catch (Exception e) {}
         

        String nombreArchivoGenerado = String.format ("%s-Parte-%s.csv", txtDestino, cantidadArchivosGenerados);              
       // String nombreArchivoCsv = String.format("%s %s",directorioDestino, nombreArchivoGenerado);          
       
       
        
        //////////////////////////////////////////////////////////////////////////////////
       
            CarpetaDestino = ObtenerPath(fullPath);          

            if (ModoOriginal.isSelected() == true)
            {
               ArgumentoOpcionCheck1 =  CarpetaDestino + "\\" + nombreArchivoGenerado;
               ArgumentoOpcionCheck2 = fullPath + "-Informe.txt";
            }
            else if (ModoNuevo.isSelected() == true)
            {
                ArgumentoreaderNuevo = directorioDestino + "\\" + nombreArchivoGenerado;
                ArgumentoOpcionCheck1 = ArgumentoreaderNuevo;
                ArgumentoOpcionCheck2 = directorioDestino + "\\" + txtDestino + "-Informe.txt";
System.out.println ("-------------------------XXXX----------" + ArgumentoOpcionCheck1);
            }
 
         ////////////////////////////////////////////////////////////////////////////////
        
        

        try{
            SW = new FileWriter(ArgumentoOpcionCheck1,true);
        } catch (Exception e){System.out.println("Error de lectura del fichero");}
       
         ContadorCSV++;
        
         //Patth = (directorioDestino + "Informe.txt");
         
        try{
            swResultados = new FileWriter(ArgumentoOpcionCheck2,true); 
                br = new BufferedWriter(swResultados);
                br.write("Se generearon los siguientes archivos:");
                br.newLine();
                br.write (String.format("Archivo ** %s **", nombreArchivoGenerado));
                
        } catch (Exception e){}
           
    
        EscribirCabecera(SW);
        
         
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
                                //nombreArchivoCsv = String.format("%s %s", directorioDestino, nombreArchivoGenerado);
                                
                                
                                /////////////////////////////////////////////////////////////////////////

                                
                                if (ModoOriginal.isSelected() == true)
                                {
                                    ArgumentoOpcionCheck1 = CarpetaDestino + "\\" + nombreArchivoGenerado;

                                }
                                else if (ModoNuevo.isSelected() == true)
                                {
                                  ArgumentoreaderNuevo = directorioDestino + "\\" + nombreArchivoGenerado;
                                  ArgumentoOpcionCheck1 = ArgumentoreaderNuevo;

                                }

                               /////////////////////////////////////////////////////////////////////
                                

                                try {
                                    SW = new FileWriter(ArgumentoOpcionCheck1, true);
                                } catch (Exception e) {
                                    System.out.println("Error de lectura del fichero");
                                }
                                    ContadorCSV++;
                                    
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

                    BarraGenerados(Maximo, distintos);

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

               CargarBarra(Maximo);


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
       
        mailLinea += String.format("%s|Cuit: %s | %s | %s | %s | %s | %s | %s | %s ", razonsocialAux, formatearCuit(cuitAux), fechaVencimiento, fechaOpcion, anio, cuota, ImpuestoV, datosTodosObjetos, porcentaje);
        try{
           SW.append(mailLinea);
           SW.append('\n');
        } catch (Exception e){System.out.print("PROBLEM2");} 
            
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
        
 
        try{
            SW.flush();
            SW.close();
        } catch (Exception e){} 
         
        
        OpcionDeZipeado();
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
              
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
    }; 
     
    hilo1.start();    
    
    Generar_.setEnabled(true);
    Origen_.setEnabled(true);
    System.out.println("Lineas erroneas: " + conterror);
}   
 
public void OpcionDeZipeado() throws IOException{
    

    getContentPane().setBackground(Color.getHSBColor(80, 300, 100));
   
    String mensaje = "";

    if (counter != (Integer.parseInt(cantidadAleer.getText()))) {

        mensaje = String.format(" \"Cantidad de registros ERRONEA!!\" %n La cantidad de suscripciones configuradas %d y es distinta a la  %n  cantidad de registros leidos %d.  %n De todas maneras se generaron %d mails para enviar. ", Integer.parseInt(cantidadAleer.getText()), counter, distintos);
        JOptionPane.showMessageDialog(null, mensaje);

    } else {

        String mensaje2 = String.format("Se leyeron %d suscripciones y se generaron %d mails para enviar. %n Armar bases?", counter, distintos);
        JOptionPane.showMessageDialog(null, mensaje2);

        barraGenerados.setValue(cantidadaleer); // agregado Ñ para que la barra de Generados termine. 
    }

    int result = JOptionPane.showConfirmDialog(null, "Informar archivos generados? (Zip)", "Alerta!", JOptionPane.YES_NO_OPTION);

    if (result == JOptionPane.YES_OPTION) {

        InformarArchivosGenerados();
        
        if (directorioDestino == ""){ 
        }else {carpetLocal = directorioDestino; }
        
        
        String mensaje1 = String.format("Se creó un Arhivo .Zip en la carpeta: %n %s %n  bajo el nombre:  %s", carpetLocal,nombreDeZip);
        JOptionPane.showMessageDialog(null, mensaje1);

    } 
    
    counter = 0; //refrescar cantidad de subscriptores leidos. 
    distintos = 0; //refrescar cantidad de mails generados. 
    zipFile = null;
    
    
 }

private void InformarArchivosGenerados() throws FileNotFoundException, IOException{
 
    if (ModoOriginal.isSelected() == true )
    {
        InformarArchivosGenerados_Original();

           
    }else if (ModoNuevo.isSelected() == true){
      

        File Fuente = new File(directorioDestino);
        File[] ficheros = Fuente.listFiles();
        byte[] buffer = new byte[1024];
      

        /// comprobar que no exista ya un zip: cambiar nombre: Y NOMBRAR al Zip
    
            zipFile = VerificarZipPrevio(Fuente, ficheros, zipFile); 
            
         ////////                          
            
      
             
        ///formulario informativo: 
        ConteoZip form2 = new ConteoZip();
        form2.setVisible(true);
        form2.BarraMax(ContadorCSV + 1);
        form2.textTotal(ContadorCSV + 1);
        int cont  = 0;
        //////////////////////////////////////   
            
       
        InputStream input = null;
        ZipOutputStream zipOut = null;
        zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        int len;

      
        
        if (Fuente.isDirectory()) {

            for (int j = 0; j < ficheros.length; j++) {

                if (ficheros[j].getName().contains(".zip")){/* XD */ } else{
                    
                    input = new FileInputStream(ficheros[j]);
                    zipOut.putNextEntry(new ZipEntry(ficheros[j].getName())); //Fuente.getName() + File.separator + 
                    while ((len = input.read(buffer)) > 0) {
                        zipOut.write(buffer, 0, len);
                    }
                    cont++;

                    form2.BarraSuma(cont);
                    form2.textActual(cont);
                    input.close();
                    
                }   
            }
             cont  = 0;
             ContadorCSV = 0;
             
        }
        
        zipOut.close();
       
        //////////////////////////Borrador: 

        
     for (int i = 0; i < ficheros.length; i++) {
            String extension = "";
            String ex = ".csv";
            String ex2 = ".txt";
            
           if ((ficheros[i].getName().contains(txtDestino)) && (ficheros[i].length()!= size1 )) { 
                 
             
                for (int j = 0; j < ficheros[i].getName().length(); j++) {
                    if (ficheros[i].getName().charAt(j) == '.') {
                        extension = ficheros[i].getName().substring(j, (int) ficheros[i].getName().length());
                        if (extension.equals(ex)) {
                            if (ficheros[i].delete()) {
                                System.out.println("El fichero: " + ficheros[i].getName() + " ha sido borrado satisfactoriamente");
                            } else {
                                System.out.println("El fichero no puede ser borrado");
                            }
                        } else if (extension.equals(ex2)) {
                            if (ficheros[i].delete()) {
                                System.out.println("El fichero: " + ficheros[i].getName() + " ha sido borrado satisfactoriamente");
                            } else {
                                System.out.println("El fichero no puede ser borrado");
                            }
                        }
                    }
                }
            }
        }
    }
    
   
    
}

private void  InformarArchivosGenerados_Original() throws FileNotFoundException, IOException{
    
    ///formulario informativo: 
    ConteoZip form2 = new ConteoZip();
    form2.setVisible(true);
    form2.BarraMax(ContadorCSV + 1);
    form2.textTotal(ContadorCSV + 1);
    int cont  = 0;
    //////////////////////////


    File Fuente = new File(CarpetaDestino); //fullpath
    File[] ficheros = Fuente.listFiles();
    byte[] buffer = new byte[1024];
    
    
    // comprobar que no exista ya un zip: cambiar nombre:
    
        zipFile = VerificarZipPrevio(Fuente, ficheros, zipFile); 
        
    ///

    InputStream input = null;
    ZipOutputStream zipOut = null;
    zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
    
   
    int len;

    if (Fuente.isDirectory()) {

        for (int j = 0; j < ficheros.length; j++) {
    
           if ( (ficheros[j].getName().contains(txtDestino)) && (ficheros[j].length()!= size1 ) ) {  { 
               
               if (ficheros[j].getName().contains(".zip")){/* XD */ } else{
                  cont++;
                  
                    input = new FileInputStream(ficheros[j]);
                    zipOut.putNextEntry(new ZipEntry(ficheros[j].getName())); //Fuente.getName() + File.separator + 
                    while ((len = input.read(buffer)) > 0) {
                        zipOut.write(buffer, 0, len);
                    }
                 
                 form2.BarraSuma(cont);
                 form2.textActual(cont);
               } 
               
           }

            input.close();
        }
   
    }
    cont  = 0;
    zipOut.close();
    
    ////////Borrador: 
    

    for (int i = 0; i < ficheros.length; i++) {
        
        String extension = "";
        String ex = ".csv";
        String ex2 = ".txt";
        
        if ((ficheros[i].getName().contains(txtDestino)) && (ficheros[i].length()!= size1 )) { 
          
            for (int j = 0; j < ficheros[i].getName().length(); j++) { 
            
                
                if (ficheros[i].getName().charAt(j) == '.') {
                    extension = ficheros[i].getName().substring(j, (int) ficheros[i].getName().length());

                    if (extension.equals(ex)) {
                        if (ficheros[i].delete()) {
                            System.out.println("El fichero: " + ficheros[i].getName() + " ha sido borrado satisfactoriamente");
                        } else {
                            System.out.println("El fichero no puede ser borrado");
                        }
                    } else if (extension.equals(ex2)) {
                        if (ficheros[i].delete()) {
                            System.out.println("El fichero: " + ficheros[i].getName() + " ha sido borrado satisfactoriamente");
                        } else {
                            System.out.println("El fichero no puede ser borrado");
                        }
                    }
                }
            }
        }
    }
 }    
    
    ContadorCSV = 0 ;  
    
}

   public File VerificarZipPrevio(File Fuente, File[] ficheros, File zipFile ){ 

        int tempN = 0 ;
        String tempS = "";
        char charr = ' '; 
        String tempS2 = "";
        int cont2 = 1; 
        int contParentesis = 0; 

        if (Fuente.isDirectory()) {

            for (int k = 0; k < ficheros.length; k++) {

                if (ficheros[k].getName().contains("zip")) { //se busca el archivo con nombre de zip.

                    for (int l = ficheros[k].getName().length(); l > -1; l--){

                  
                        if ((ficheros[k].getName().charAt(l-1)) == ')') { //Busca el parentesis------charAt mide contando el cero. Por eso se resta uno. Length arranca en el 1. 

                            int temp2 = l ;

                        ///Medir distancia entre parentesis
                            while (ficheros[k].getName().charAt(temp2-2) != '('){
                                contParentesis++;
                                temp2--;
                            }

                            temp2 = l; 

                        /// Tomar elementos ENTRE los parentesis
                            while (cont2 <= contParentesis) {

                                tempS += (ficheros[k].getName().charAt(temp2 - 2)) ;

                                temp2--;
                                cont2++;
                            }

                        /// Voltear numero dentro de los parentesis
                            if (contParentesis >1){ 

                                for (int n = tempS.length() - 1; n > -1; n--) {

                                  tempS2 += tempS.charAt(n);
                                }
                            }else {tempS2 = tempS;}

                            tempN =  Integer.valueOf (tempS2);
                            tempS2 = "";
                            tempS = "";
                            temp2 = 0; 
                            cont2 = 1;
                            contParentesis = 0 ;

                        ///Seleccion del número mas grande entre los zips.

                            if (contzip < tempN){contzip = tempN;}
                            //System.out.println("--------------->: " + ficheros[k].getName().charAt(l - 2));
                            break;

                        }  
 
                    }
                }
            }
        }
    
      //////////////////////////////////////////////////////////////////////////////////
         contzip++;
         
        if (ModoOriginal.isSelected() == true){

            nombreDeZip = txtDestino + "_("+ contzip +").zip" ;
            zipFile = new File(CarpetaDestino + "\\" + nombreDeZip);
           
        }
        else if (ModoNuevo.isSelected() == true){

            nombreDeZip = txtDestino + "_("+ contzip +").zip" ;
            zipFile = new File(directorioDestino + "\\" +  nombreDeZip);
            
        }
        ////////////////////////////////////////////////////////////////////////////////
      contzip = 0 ;
      return zipFile;
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

private void EscribirCabecera(FileWriter pSw){
            if (this.ConCabecera.isSelected())
            {
               try {
                pSw.write("email|nombre|cuit|fechav|fechao|anio|cuota|impuesto|datos|descuento");
                pSw.append('\n');
               }catch(Exception e){}
            }

  }

private void LeerLinea(String line){
           
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
            
            
            
            try{ 
            
            cuit = line.substring(394, 405).replaceAll(" ","");
            //System.out.println ("cuit: " + cuit + " en linea: " + counter);
                           
            } catch (Exception e){
                
                cuit ="";
                //System.out.println ("cuit: " + cuit + " en linea: " + counter);
                //System.out.println("error en línea: "+ counter + ", de tipo : ( " + e.getLocalizedMessage());
                conterror++;
            }
 
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
            
            try{ 
            
            cuit = line.substring(394, 405).replaceAll(" ","");
                           
            } catch (Exception e){
                
                cuit ="";
                System.out.println("error en línea: "+ counter + ", de tipo : ( " + e.getMessage());
                conterror++;
            }

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

    if (Correc_Mayus.isSelected()){razonsocial = Mayusculas(razonsocial);}
     
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
         
         
         
         
          try{ 
            
              cuit = line.substring(245, 256).replaceAll(" ","");
                           
            } catch (Exception e){
                
                cuit ="";
                System.out.println("error en línea: "+ counter + ", de tipo : ( " + e.getMessage());
                conterror++;
            }
    
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


           if (Correc_Mayus.isSelected()){razonsocial = Mayusculas(razonsocial);}
                
    }
    
private String formatearObjetoInmobiliario(String pObjeto){

    String partido = pObjeto.substring(0, 3).replaceAll(" ","") ;
    String partida = pObjeto.substring(3, 9).replaceAll(" ","") ;
    String digito = pObjeto.substring(9, 10).replaceAll(" ","") ;

    return (partido + "-" + partida + "-" + digito );
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

                medioPago = "<a href=\"" + txturl.getText() + objeto + "\">Ingresar</a>";
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
 

    private void ImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImpuestoActionPerformed

        directorioOrigen = ""; 
        FraccionImpuesto = Impuesto.getSelectedItem().toString();
        
        directorioOrigen = "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen";
        directorioDestino = "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Destino";   

        if(FraccionImpuesto == null){
          FraccionImpuesto =".";
        }

        //List<String> cuotas = new List<String>();


        switch (FraccionImpuesto)
        {
            case "Impuesto Automotor":
                {
                    directorioOrigen += "\\Automotores\\";
                    directorioDestino += "\\Automotores\\";

                    impuestoLiquidar = "1";
                    nombreImpuesto = "Automotor";
                    txturl.setText ("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=1&opc=LIC&oi=");
                                     
                    
                                    
                                    
                    break;
                }
            case "Impuesto a las Embarcaciones":
                {
                    directorioOrigen += "\\Embarcaciones\\";
                    directorioDestino += "\\Embarcaciones\\";
                    nombreImpuesto = "Embarcaciones";
                    impuestoLiquidar = "3";
                    txturl.setText ("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=3&opc=LIC&oi=");
                    break;

                }
            case "Impuesto Urbano Edificado":
                {
                    directorioOrigen += "\\Edificado\\";
                    directorioDestino += "\\Edificado\\";
                    nombreImpuesto = "Edificado";
                    impuestoLiquidar = "0";
                    txturl.setText("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=");
                    break;
                }
            case "Impuesto Urbano Baldío":
                {
                    directorioOrigen += "\\Baldio\\";
                    directorioDestino += "\\Baldio\\";
                    nombreImpuesto = "Baldio";
                    impuestoLiquidar = "0";
                    txturl.setText("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=");
                    break;
                }
            case "Impuesto Rural":
                {
                    directorioOrigen += "\\Rural\\";
                    directorioDestino += "\\Rural\\";
                    impuestoLiquidar = "0";
                    nombreImpuesto = "Rural";
                    txturl.setText("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=");
                    break;
                }
            case "Impuesto Complementario":
                {
                    directorioOrigen += "\\Complementario\\";
                    directorioDestino += "\\Complementario\\";
                    nombreImpuesto = "Complementario";
                    impuestoLiquidar = "10";
                    txturl.setText ("https://www.arba.gov.ar/Aplicaciones/LiqPredet.asp?imp=10&Frame=NO&origen=WEB&opc=IIC");
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

        directorioDestino += "Destino2022";
          
    }  
   


/////////////////extras Ñ: 
    
 public void ValoresBarra(){
      
 valInt =  Long.valueOf(size1).intValue();
 Maximo =  (valInt/ 40700) *100; 

 CargarBarra(Maximo);

 jT_Totales.setText(Integer.toString(Maximo));
     
 }   
      
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
       
      
        
       return resultado; 
    }
     
 public String Mayusculas(String cadena) {
       
      StringBuffer strbf = new StringBuffer();
      Matcher match = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(cadena);
      while(match.find()) 
      {
         match.appendReplacement(strbf, match.group(1).toUpperCase() + match.group(2).toLowerCase());
      }
      
     return (match.appendTail(strbf).toString());
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
          
 public String ObtenerNombre(String nom){

    String name = "";
    String Navn = "";


        for (int i = nom.length() - 1; i > -1; i--)
        {
            if (nom.charAt(i) == '\\')
            {
                break; 
            }
            name += nom.charAt(i);
        }

        for (int j = name.length() - 1; j > -1; j--)
        {

            Navn += name.charAt(j);
        }

        return Navn;
     }
     
 public String ObtenerPath(String nom){   
    
    int cont = 0;
    int cont2 = 0;
    String Navn = "";
    boolean go = false; 

    for (int i = nom.length() - 1; i > 0; i--)
    {
        if (nom.charAt(i) == '\\')
        {
            go = true; 
            break;
        }
    }

    if (go == true)
    {
        for (int i = nom.length() - 1; i > 0; i--)
        {
            if (nom.charAt(i) == '\\')
            {
                cont2++; 
            }

            cont++;

            if (cont2 == 1) {
                break;
            }
        }

        int diff = nom.length() - cont; ;

        for (int j = 0; j < diff; j++)
        {
            Navn += nom.charAt(j);
        }

        return Navn;

    }else { return nom; }

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
    private javax.swing.JCheckBox Correc_Mayus;
    private javax.swing.JCheckBox DiferenciarMails;
    private com.toedter.calendar.JDateChooser FechaOpcion;
    private javax.swing.JButton Generar_;
    private javax.swing.JComboBox<String> Impuesto;
    private javax.swing.JTextField JT_Tantos;
    private javax.swing.JLabel Mails;
    private javax.swing.JRadioButton ModoNuevo;
    private javax.swing.JRadioButton ModoOriginal;
    private javax.swing.JButton Origen_;
    private javax.swing.ButtonGroup SelectorDeMetodo;
    private javax.swing.JProgressBar barraGenerados;
    private javax.swing.JProgressBar barraLeidos;
    private javax.swing.JTextField cantidadAleer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jT_Totales;
    private javax.swing.JTextField txtArchivoOrigen;
    private javax.swing.JTextField txtCantidadCorte;
    private javax.swing.JTextField txturl;
    // End of variables declaration//GEN-END:variables

  
}
