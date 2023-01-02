package campania_java;
import java.util.Base64;

//////////////////////////////Testing - 12_9/////////////////////

// Form original  ---------------

/*import java.util.UUID;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import com.google.zxing.Writer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.zip.GZIPOutputStream;*/

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.WriterException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class frmPrincipal extends javax.swing.JFrame { 

    
    private String buenContribuyente = "";
    private String Variable = "";
    private String nombreImpuesto = "";
    private String impuestoLiquidar = "";
    private int cont; 
    private int contt;
    private boolean Existe ;
    private String nombreArchivoCsv = "";
    private String Patth = "";
    private String txtDestino2 ="";
    private String Dir = ""; 
    private String DirOrigen = "";
    private String cuotaNumero = "";
    private String cuitFormateado = "";
    private int cantidad = 0;
    private int sum = 0;
    private int raws = 0;
    private String FraseQR = "";
    
    public static SimpleDateFormat sdf2 = new  SimpleDateFormat("dd/MM/yyyy");
    private String codigoElectronico = "";
    private File zipFile = null;
    private String directorioOrigen = "";
    private String directorioDestino = "";
    private String txtOrigen = "";
    private String txtDestino = "";
    private String ImpuestoV = "";
    private String NombreOrigen = ""; 
    private String FraccionImpuesto =  "";
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
    private String fechaVencimiento = "";
    private String fechaVencimientoNumero = "";
    private String montoCuota = "";
    private String montoAnual = "";
    private String planta = "";
    private String plantaDescri = "";
    private String fechaOpcion = "";
    private String datosObjeto = "";
    private String objetoFormateado = "";
    private String fullPath = ""; 
    private String CarpetaDestino = "";
    private String carpetLocal = ""; 
    private String ArgumentoreaderNuevo = "";
    private String ArgumentoOpcionCheck1 = "";
    private String ArgumentoOpcionCheck2 = "";
    private String nombreDeZip = "" ;
    private int Maximo = 0; 
    private int counter = 0;
    private int contzip = 0; 
    private int  valInt = 0 ;
    private int cantidadaleer = 0 ;
    private int distintos = 0; 
    private int ContadorCSV = 0;
    private long size1 = 0;
    private int conterror = 0; 
    private String QRString = "";
    private String QRContenido = "" ;
    private String Ente = "";
    private String Rubro = ""; 
    private String ImpuestoCorto = "";
    private int X = 0;
    public Date fechaActual; 
    public Date dateAux;
    public Date dateAux2;
    public Date FechaFormateada;
    public String nombreDeUltimo = ""; 
    public String formatted = "";
    public String Original = "";
    public int contadorerrorFecha = 0 ; 
    public boolean click = true; 
    public boolean seleccionerronea = true; 
    public boolean inermail = true;
    public Thread hilo1;
    
    //hash
    
    public static final String CLAVEHASH ="akljf@?ha873254sgdkj%/&%'ndslfaf-lkhifewr3247";
    
    //QR QRnuevo = new QR();
   // Encoder Encoder = new Encoder();
   // File f =  new File("C:\\Users\\oscar.avendano\\Desktop\\imgs\\foto.png");
    
    private FileNameExtensionFilter filter = new FileNameExtensionFilter ("Archivos Txt", "txt");
  
    public frmPrincipal() {
        initComponents();
        
        Impuesto.setEnabled(false);
        Generar_.setEnabled(false);
        Origen_.setEnabled(false);
        
        
         /////////////////////////////////////////////setear la fecha del JDateChooser por defoult. 
            
            LocalDate todaysDate = LocalDate.now();
            String formattedDate = todaysDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
            dateAux2 = java.sql.Date.valueOf(todaysDate);
            FechaOpcion.setDate(dateAux2); 
            
         ////////////////////////////////////////////////////////////
        
       
        txtCantidadCorte.setHorizontalAlignment(txtCantidadCorte.CENTER);
        cantidadAleer.setHorizontalAlignment(cantidadAleer.CENTER);
        JT_Tantos.setHorizontalAlignment(JT_Tantos.CENTER);
        jT_Totales.setHorizontalAlignment(jT_Totales.CENTER);
        
        ConCabecera.setSelected(true);
        ModoOriginal.setSelected(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Generar Bases para campaña por mail - [Avendaño - Cruz] 3.0");
        JT_Tantos.setHorizontalAlignment(JT_Tantos.RIGHT);
        jT_Totales.setHorizontalAlignment(jT_Totales.RIGHT);
        Mails.setHorizontalAlignment(Mails.RIGHT);
        directorioDestino = "";
        directorioOrigen = "";

        this.getContentPane().setBackground(Color.getHSBColor(80, 154, 50)); 
        
        directorioOrigen = "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen";
        directorioDestino = "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Destino";      


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SelectorDeMetodo = new javax.swing.ButtonGroup();
        SelectorDePago = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        ConQrCB = new java.awt.Checkbox();
        Tipo_prueba = new java.awt.Checkbox();
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
        CO = new javax.swing.JRadioButton();
        DT = new javax.swing.JRadioButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setForeground(new java.awt.Color(255, 51, 0));
        jButton1.setText("Stop");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 540, -1, -1));

        ConQrCB.setLabel("Con Codigo QR");
        getContentPane().add(ConQrCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, -1, -1));

        Tipo_prueba.setLabel("Envio de Prueba");
        Tipo_prueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tipo_pruebaMouseClicked(evt);
            }
        });
        getContentPane().add(Tipo_prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 170, -1, -1));

        Impuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Impuesto", "Impuesto Automotor", "Impuesto a las Embarcaciones", "Impuesto Urbano Edificado", "Impuesto Urbano Baldío", "Impuesto Rural", "Impuesto Complementario" }));
        Impuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpuestoActionPerformed(evt);
            }
        });
        getContentPane().add(Impuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 430, 40));

        cantidadAleer.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cantidadAleer.setText("1000000");
        getContentPane().add(cantidadAleer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 124, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cant. Suscripciones ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("URL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));
        getContentPane().add(txturl, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 590, -1));

        Origen_.setText("Selec Origen");
        Origen_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Origen_ActionPerformed(evt);
            }
        });
        getContentPane().add(Origen_, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 110, -1));

        txtArchivoOrigen.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        getContentPane().add(txtArchivoOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 580, 53));

        Generar_.setText("Generar");
        Generar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generar_ActionPerformed(evt);
            }
        });
        getContentPane().add(Generar_, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 170, 44));

        barraLeidos.setStringPainted(true);
        getContentPane().add(barraLeidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 909, 21));

        barraGenerados.setForeground(new java.awt.Color(255, 153, 51));
        barraGenerados.setStringPainted(true);
        getContentPane().add(barraGenerados, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 500, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Subscripciones Leidas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 136, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mails generados:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contar C/");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        txtCantidadCorte.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtCantidadCorte.setText("150000");
        txtCantidadCorte.setToolTipText("");
        txtCantidadCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadCorteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantidadCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 65, -1));

        ConCabecera.setText("Con Cabecera");
        getContentPane().add(ConCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        ConAnual.setText("Con Anual");
        getContentPane().add(ConAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        DiferenciarMails.setText("Diferenciar Mails");
        getContentPane().add(DiferenciarMails, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("fecha Opción");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        FechaOpcion.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        getContentPane().add(FechaOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 207, -1));
        getContentPane().add(Mails, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 68, 21));

        JT_Tantos.setEditable(false);
        JT_Tantos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        getContentPane().add(JT_Tantos, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 330, 90, -1));

        jT_Totales.setEditable(false);
        jT_Totales.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        getContentPane().add(jT_Totales, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, 96, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("de");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, 23, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Suscripciones Leidas:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 310, 138, -1));

        Correc_Mayus.setText("Corrección Mayusculas.(Razón Social)");
        getContentPane().add(Correc_Mayus, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("(Registros Aprox.)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 380, -1, -1));

        ModoNuevo.setBackground(new java.awt.Color(0, 0, 0));
        SelectorDeMetodo.add(ModoNuevo);
        ModoNuevo.setForeground(new java.awt.Color(255, 255, 255));
        ModoNuevo.setText("a RED");
        getContentPane().add(ModoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 270, -1, -1));

        ModoOriginal.setBackground(new java.awt.Color(0, 0, 0));
        SelectorDeMetodo.add(ModoOriginal);
        ModoOriginal.setForeground(new java.awt.Color(255, 255, 255));
        ModoOriginal.setText("A carpeta Local");
        getContentPane().add(ModoOriginal, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 230, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mails");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        CO.setBackground(new java.awt.Color(0, 0, 0));
        SelectorDePago.add(CO);
        CO.setForeground(new java.awt.Color(255, 255, 255));
        CO.setText("CO");
        CO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COActionPerformed(evt);
            }
        });
        getContentPane().add(CO, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        DT.setBackground(new java.awt.Color(0, 0, 0));
        SelectorDePago.add(DT);
        DT.setForeground(new java.awt.Color(255, 255, 255));
        DT.setText("DT");
        DT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DTActionPerformed(evt);
            }
        });
        getContentPane().add(DT, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo_1.png"))); // NOI18N
        fondo.setText("fondo");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 580));

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
          
          
        if((txtOrigen != "" ) && (seleccionerronea != false)){ 
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
            
            fullPath = txtOrigen ;

           ////////////////////////////////////////////////////////////////////////////////////////

            if ((ModoOriginal.isSelected()  == true ) || ( ModoOriginal.isSelected()  == false)) {

               txtDestino = ObtenerNombre(txtOrigen);
            }

          ModoNuevo.setEnabled(false);
          ModoOriginal.setEnabled(false); 
          
           ///////////////////////////////////////////////////////////////////////////////////////

           int contaclicks = 0;
           
         if (click == true ){ Procesar(); click = false;} else {contaclicks++;} 
           

            seleccionerronea = true;
          

        }else {
            cantidadAleer.requestFocus();
            JOptionPane.showMessageDialog(null, " Ingrese la cantidad de suscripciones a procesar. ", " Boleta Electrónica ", JOptionPane.ERROR_MESSAGE);  
        }  
    }//GEN-LAST:event_Generar_ActionPerformed

    
public void Procesar() {
     

    int dist = 0 ; 
    this.getContentPane().setBackground(Color.getHSBColor(80, 150, 49));   

    hilo1=new Thread(){

        @Override
        public void run(){

        try {

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        cantidadaleer = Integer.parseInt(cantidadAleer.getText());
        Generar_.setText("Procesando");
        int cantidadMailIgual = 0;
        int cont=0;
        String mailLinea = ".";
        Long Lineas = 0L; 
        int conta = 0;
        int contador = 0;        
        int escritos = 0;
        int cantidadArchivosGenerados = 1;
        int cantidadCorte = Integer.parseInt(txtCantidadCorte.getText());

        String line = "" ;
        String datosTodosObjetos ="";
        String ultimoMail = "";
        BufferedReader filAS = null;
        BufferedReader file = null; 
        
        //------------------------------------->utf_8
        
        Writer SW = null; 
        Writer swResultados = null; 
        BufferedWriter br = null; 
        
        /*
        
        //-------------------------------------> (ANSI)
        //original 
        FileWriter SW = null; 
        FileWriter swResultados = null; 
        BufferedWriter br = null; 
        //------------------------------------------------------------*/

        try {
            Date fecha1 = FechaOpcion.getDate();
            DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            String fecha2 = f.format(fecha1);
            fechaOpcion = fecha2;
           // fechaOpcion = StringaDate(fecha2);

        } catch (Exception e) {}


        String nombreArchivoGenerado = String.format ("%s-Parte-%s.csv", txtDestino, cantidadArchivosGenerados);      //.csv        
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
            
            /* ----------------------------------(ANSI)
            //original 
            
            SW = new FileWriter(ArgumentoOpcionCheck1,true); 
            
            */
            
            
            //------------------------------------- uft_8: 
            
             SW = new OutputStreamWriter(new FileOutputStream(ArgumentoOpcionCheck1), StandardCharsets.UTF_8);
             
            //------------------------------------- uft_8: 
             
        } catch (Exception e){System.out.println("Error de lectura del fichero");}

        ContadorCSV++;

        try{
            
            
            /*--------------------------------(ANSI)
            
            //original
            
            swResultados = new FileWriter(ArgumentoOpcionCheck2,true);
            
          */
            
           //------------------------------------- uft_8: 
           
           swResultados = new OutputStreamWriter(new FileOutputStream(ArgumentoOpcionCheck2), StandardCharsets.UTF_8);
          
           //------------------------------------- uft_8: */
           
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

                // aca se suma uno mas y se diferencian los mails de prueba para envio

                X++;
                if(X>=10){ X = 0;}


                if ((DiferenciarMails.isSelected()) && (mailAux == ultimoMail)) {
                    cantidadMailIgual++;
                } else {
                    cantidadMailIgual = 0;
                }

                if (cantidadMailIgual == 0) {

                    mailLinea = String.format("%s|", MailEnviadoA());

                } else {
                    mailLinea = String.format("s% + s%|", MailEnviadoA(), String.valueOf(cantidadMailIgual));
                }

                ultimoMail = mailAux;

                mailLinea += String.format("%s|Cuit: %s|%s|%s|%s|%s|%s|%s|%s", razonsocialAux, formatearCuit(cuitAux), fechaVencimiento, fechaOpcion, anio, cuota, ImpuestoV, datosTodosObjetos, porcentaje);

                
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
                            } catch (Exception e) {}

                            nombreArchivoGenerado = String.format("%s-Parte-%s.csv", txtDestino, cantidadArchivosGenerados); //.csv
                            //nombreArchivoCsv = String.format("%s %s", directorioDestino, nombreArchivoGenerado);


                            ////////////////////////////////////////////////////////////////////////


                            if (ModoOriginal.isSelected() == true) //modo rodo
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
                                
                                /*--------------------------------(Ansi)
                                
                                
                                SW = new FileWriter(ArgumentoOpcionCheck1, true);
                                
                                */
                               //-----------------------------------(UTF_8)
                               
                              SW = new OutputStreamWriter(new FileOutputStream(ArgumentoOpcionCheck1), StandardCharsets.UTF_8);
                                
                                //-----------------------------------
                                
                                
                                
                                
                            } catch (Exception e) {System.out.println("Error de lectura del fichero");}
                                
                            ContadorCSV++;

                            br.write(String.format("Archivo ** %s **", nombreArchivoGenerado));

                            EscribirCabecera(SW);

                        } catch (Exception e) {}
                    }
                } catch (Exception e) {System.out.println("Archivo no encontrado. Cambia la ruta de INFORME");}

                distintos++;
                escritos++;

                BarraGenerados(Maximo, distintos);

                try {

                // filtroNombresInternos(mail); //para prueba de QR
   
                   if (inermail== true){ 

                            SW.append(mailLinea + "\r\n"); //cambio de cierre a windows (CRLF)
                        
                        //SW.append();
                    }

                } catch (Exception e) {System.out.print("PROBLEM1");}

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
            } catch (Exception e) {System.out.println("Error de lectura del fichero");}

            // Corte de tipos de prueba en numero máximo
            
            if ((Tipo_prueba.getState() ) && (distintos  >= 9)) {

             break; 
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

        mailLinea += String.format("%s|Cuit:%s|%s|%s|%s|%s|%s|%s|%s", razonsocialAux, formatearCuit(cuitAux), fechaVencimiento, fechaOpcion, anio, cuota, ImpuestoV, datosTodosObjetos, porcentaje);
       
       

        System.out.println("fechas erradas: " + contadorerrorFecha);
        System.out.println("Lineas erroneas: " + conterror);
        
        
        
        try{
            
        //    filtroNombresInternos(mail); //para prueba de QR....en espera.... 
                    
                if (inermail== true){ 
                       
                     
                    SW.append(mailLinea + "\r\n");//cambio de cierre a windows (CRLF)
                  //  SW.append('\n');
                        
                }
       
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
        } catch (Exception e) {}

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
    
}   
 




public void OpcionDeZipeado() throws IOException{
    

    getContentPane().setBackground(Color.getHSBColor(80, 300, 100));
   
    String mensaje = "";

    if (counter != (Integer.parseInt(cantidadAleer.getText()))) {

        mensaje = String.format(" \"Cantidad de registros Diferente!!\" %n La cantidad de suscripciones configuradas es de %d , y es distinta a la  %n  cantidad de registros leidos %d.  %n De todas maneras se generaron %d mails para enviar. ", Integer.parseInt(cantidadAleer.getText()), counter, distintos);
        JOptionPane.showMessageDialog(null, mensaje);

    } else {

        String mensaje2 = String.format("Se leyeron %d suscripciones y se generaron %d mails para enviar.", counter, distintos);
        JOptionPane.showMessageDialog(null, mensaje2);

        barraGenerados.setValue(cantidadaleer); // agregado Ñ para que la barra de Generados termine. 
    }

    int result = JOptionPane.showConfirmDialog(null, "GENERAR ARCHIVO ZIP?", "Alerta!", JOptionPane.YES_NO_OPTION);

    if (result == JOptionPane.YES_OPTION) {

        InformarArchivosGenerados();
        
        if (directorioDestino == ""){ 
        }else {carpetLocal = directorioDestino; }
        
        
        String mensaje1 = String.format("Se creó un Arhivo .Zip en la carpeta: %n %s %n  bajo el nombre:  %s", ArgumentoOpcionCheck1,nombreDeZip);
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

           
    }else if (ModoNuevo.isSelected() == true){ // a red
      

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

            if ( ficheros[j].getName().contains(txtDestino) ) {   //debe llamarse como el archivo que se esta traajando, asi no guarda cualquier otra cosa. 
                
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
            
           if ((ficheros[i].getName().contains(txtDestino)) && (ficheros[i].length()!= size1 )) {  //debe llamarse como el archivo que se esta traajando, asi no guarda cualquier otra cosa. y no ser el mismo archivo (tener el mismo peso) 
                 
             
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
                String Test = ficheros[j].getName(); 
                
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

private void EscribirCabecera(Writer pSw){ /*-----------------------UTF8*/
            if (this.ConCabecera.isSelected())
            {
               try {
                pSw.write("email|nombre|cuit|fechav|fechao|anio|cuota|impuesto|datos|descuento" + "\r\n" ); //cambio de cierre a windows (CRLF)
               // pSw.append('\n');
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
            
            try {
            fechaVencimientoNumero = (line.substring(334, 344).replaceAll(" ",""));                        
            fechaVencimiento = StringaDate(fechaVencimientoNumero); 
            } catch (Exception e){ 
                
                contadorerrorFecha++;
            
            System.out.println ("error de lectura de fecha en automotor / embarcaciones");}
            
            montoCuota = line.substring(345, 362).replaceAll(" ","") ;
            montoAnual = line.substring(362, 378) ;
            codigoElectronico = line.substring(378, 392).replaceAll(" ","");
            debitoCredito = line.substring(392, 393).replaceAll(" ","");                           
            buenContribuyente = line.substring(393, 394).replaceAll(" ","");    
            
            //System.out.println("flag 1---"+ debitoCredito);

            try{ 
            
            cuit = line.substring(394, 405).replaceAll(" ","");
            //System.out.println ("cuit: " + cuit + " en linea: " + counter);
                           
            } catch (Exception e){
                
                cuit ="";
                //System.out.println ("cuit: " + cuit + " en linea: " + counter);
               // System.out.println("error en línea: "+ counter + ", de tipo : ( " + e.getLocalizedMessage());
                conterror++;
            }
 
            Variable = "Prueba  Automotor" ;

            
            porcentaje = "20";// ?????????????????????
            anio = (line.substring(340,344));
            cuota = (line.substring(333,334));

            //anio = "2022";  -----> asi lo tenia Juan
            //cuota = "4";


              break;
        }
        case "Impuesto Urbano Edificado":
        case "Impuesto Urbano Baldío":
        case "Impuesto Rural":
        {
                       
            mail = ((line.substring(0, 255).toLowerCase()).replaceAll(" ","") );
            objeto = (line.substring(255,266).replaceAll(" ",""));     
            
            try {
            
            objetoFormateado = formatearObjetoInmobiliario(objeto);
            
            } catch (Exception e){}
                     
            razonsocial = trimEnd(line.substring(266,326));   
            porcentaje = "";  
            
            try{
            fechaVencimientoNumero = (line.substring(334, 344).replaceAll(" ",""));                        
            fechaVencimiento = StringaDate(fechaVencimientoNumero); 
             }catch (Exception e){contadorerrorFecha++; System.out.println ("error de lectura de fecha en Edificado/Baldio/Rural");}
            
            montoCuota = line.substring(345, 362).replaceAll(" ","") ;
            montoAnual = line.substring(362, 378) ;
            codigoElectronico = line.substring(378, 392).replaceAll(" ","");
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
    
     //razonsocial = filtroNombresCaracteres(razonsocial); 

     if (Correc_Mayus.isSelected()){ Mayusculas(razonsocial);}
          // if (Correc_Mayus.isSelected()){razonsocial = Mayusculas(razonsocial);}
   
    
}

private void LeerLineaNuevo(String line){  //"Impuesto Complementario"
    
    mail = ((line.substring(0, 120).toLowerCase()).replaceAll(" ","") );
         objeto = (line.substring(120,131).replaceAll(" ","")); 
          
         
           try {
            
            objetoFormateado = formatearObjetoInmobiliario(objeto);
            
            } catch (Exception e){}
         
         planta = (line.substring(131,132).replaceAll(" ",""));
         razonsocial = trimEnd(line.substring(132,192));   
         porcentaje = (line.substring(192,194).replaceAll(" ",""));
         anio = (line.substring(194,198).replaceAll(" ",""));
         cuota = (line.substring(198,200).replaceAll(" ",""));
         
         try {
         fechaVencimientoNumero = (line.substring(200, 210).replaceAll(" ",""));   
         fechaVencimiento = StringaDate(fechaVencimientoNumero); 
         } catch (Exception e){
 
              contadorerrorFecha++;
             
             System.out.println ("error de lectura de fecha en Complementario");
         
         }
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

           if (Correc_Mayus.isSelected()){ Mayusculas(razonsocial);}
          // if (Correc_Mayus.isSelected()){razonsocial = Mayusculas(razonsocial);}
                
           
        //System.out.println("Variable : " + Variable + ",cuit: "+ cuit + ",Mail: " + mail +  ", objeto: " + objeto +  ", ob formteado: " + objetoFormateado + ", planta: " + planta + ", razon social" + razonsocial + ", Porcentaje: " + porcentaje  + ", anio: " + anio + ", cuota: "+cuota + ", vencimiento num: " + fechaVencimientoNumero  + ", fecha vencimiento:  " +   fechaVencimiento  +  ", monto cuota: " + montoCuota + ", montoanual: " + montoAnual + ", debito credito: " +  debitoCredito );   
           
           
           
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
            case "1":{ //.DT
                
                medioPago = "Débito en Cuenta";
                break;
            }
            case "D":{
                
                medioPago = "Débito en Cuenta"; 
                break;
                
                }
            case "2":{
                
                medioPago = "Tarjeta de Crédito";  
                break;
            }
            case "0": //.CO
            case "C":
                    {
             
                     medioPago = "<a href=\"" + txturl.getText() + objeto + "\">Ingresar</a>"; 
                     QR_Hash();  

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

                /* Automotores entra acá por default, el "txturl.text" de 
                automotores suma "+ {0}" que acá 
                va a tomar el valor de 'objeto' */

                
                    
                medioPago = "<a href=\"" + txturl.getText() + objeto + "\">Ingresar</a>"; 
                QR_Hash();
                break;
            }
        }
        
    
        if ((Impuesto.getSelectedItem().toString())== "Impuesto Complementario")
            {
                objeto = formatearCuit(objeto);    //en este impuesto Cuit y objeto son el mismo numero. 
                datosObjeto = "<tr class='datos'>";
                datosObjeto += String.format("<td class='gris'>%s - %s</td>", objeto, plantaDescri);
                datosObjeto += String.format("<td class='amarillo'>Cuota %s </td>", cuotaNumero);
                datosObjeto += String.format("<td class='amarillo'>%s</td>", montoCuota);
                datosObjeto += String.format("<td class='gris'>%s</td>", medioPago);
                
                
               // datosObjeto += string.Format("<td class=''>%s</td>", Variable);
               
                WithQRcod();  
                
                datosObjeto += "</tr>";
        }else{
            
            if (ConAnual.isSelected())
             {
                  objeto = formatearCuit(objeto);    //en este impuesto Cuit y objeto son el mismo numero. 
                datosObjeto = "<tr class='datos'>";
                datosObjeto += String.format("<td rowspan='2' class='gris'>%s</td>", objeto);
                datosObjeto += String.format("<td class='amarillo'>Cuota %s</td>", cuotaNumero);
                datosObjeto += String.format("<td class='amarillo'>%s</td>", montoCuota);
                datosObjeto += String.format("<td rowspan='2' class='gris'>%s</td>", medioPago);
                WithQRcod();
                
                
                datosObjeto += "</tr>";
                datosObjeto += "<tr class='datos'><td class='blanco'>Anual</td>";
                datosObjeto += String.format("<td class='blanco'>%s</td>", montoAnual);
                 // datosObjeto += String.Format("<td class=''>%s</td>", Variable);
             
                datosObjeto += "</tr>";
            }else{
                datosObjeto = "<tr class='datos'>";
                datosObjeto += String.format("<td class='gris'>%s</td>", objetoFormateado); //0190117251
                datosObjeto += String.format("<td class='amarillo'>Cuota %S</td>", cuotaNumero);// Palabra: 'Cuota'. (?) 
                datosObjeto += String.format("<td class='amarillo'>%s</td>", montoCuota);//7.780.90
                datosObjeto += String.format("<td class='gris'>%s</td>", medioPago);//www.ARBA.gov.ar
                WithQRcod();
                

                // datosObjeto += String.Format("<td class='gris'>%s</td>", Variable);
                
               
                
                datosObjeto += "</tr>";
            }
        }
    }

        //////////////////////////---QR ///////////////////

        public void WithQRcod()
        {
            if (ConQrCB.getState() == true){
            
                 datosObjeto += QRString;
            }
          
        }


        //////////////////////////---Envios Pruebas ///////////////////

        public String MailEnviadoA()
        {

            if (Tipo_prueba.getState()  == true)
            {
                String[] Mails = new String[] { "oscar.avendano@arba.gov.ar", "cecilia.cerda@arba.gov.ar",
                    "nicol.cruz@arba.gov.ar", "lilian.sayago@arba.gov.ar", "marcelo.maranino@arba.gov.ar",
                    "mario.lestani@arba.gov.ar", "sebastian.marcon@arba.gov.ar", "patricia.feo @arba.gov.ar", 
                    "rodolfo.sosarainone@arba.gov.ar", "romina.montenegro@arba.gov.ar", "natalia.vacun@arba.gob.ar" };

                return  Mails[X];     
            }
            else 
            {              
                return mailAux;      
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
            case "Seleccionar Impuesto":{
            
            
             String mensaje = String.format(" \"Por favor Seleccione un Impuesto\" ");
             JOptionPane.showMessageDialog(null, mensaje);
            
              seleccionerronea = false;
              break;
            
            }
            case "Impuesto Automotor":
                {
                    directorioOrigen += "\\Automotores\\";
                    directorioDestino += "\\Automotores\\";

                    impuestoLiquidar = "1";
                    nombreImpuesto = "Automotor";
                    txturl.setText ("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=1&opc=LIC&oi=");
                                     
                    Ente = "002";
                    Rubro = "05";
                                    
                    ImpuestoCorto="AUT";      
                    seleccionerronea = true;
                    break;
                }
            case "Impuesto a las Embarcaciones":
                {
                    directorioOrigen += "\\Embarcaciones\\";
                    directorioDestino += "\\Embarcaciones\\";
                    nombreImpuesto = "Embarcaciones";
                    impuestoLiquidar = "3";
                    /* hash -->  txturl.setText ("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=3&opc=LIC&oi=");*/
                    Ente = "030";
                    Rubro = "";  //consultar. 
                    ImpuestoCorto="EMB" ;
                    seleccionerronea = true;
                    break;

                }
            case "Impuesto Urbano Edificado":
                {
                    directorioOrigen += "\\Edificado\\";
                    directorioDestino += "\\Edificado\\";
                    nombreImpuesto = "Edificado";
                    impuestoLiquidar = "0";
                    txturl.setText("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=");
                    Ente = "001";
                    Rubro = "07";
                    ImpuestoCorto="EDI" ;
                    seleccionerronea = true;
                    break;
                }
            case "Impuesto Urbano Baldío":
                {
                    directorioOrigen += "\\Baldio\\";
                    directorioDestino += "\\Baldio\\";
                    nombreImpuesto = "Baldio";
                    impuestoLiquidar = "0";
                    txturl.setText("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=");
                    Ente = "001";
                    Rubro = "07";
                    ImpuestoCorto="BAL" ;
                    seleccionerronea = true;
                    break;
                }
            case "Impuesto Rural":
                {
                    directorioOrigen += "\\Rural\\";
                    directorioDestino += "\\Rural\\";
                    impuestoLiquidar = "0";
                    nombreImpuesto = "Rural";
                    txturl.setText("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=");
                    Ente = "001";
                    Rubro = "07";
                    ImpuestoCorto="RUR" ;
                    seleccionerronea = true;
                    break;
                }
            case "Impuesto Complementario":
                {
                    directorioOrigen += "\\Complementario\\";
                    directorioDestino += "\\Complementario\\";
                    nombreImpuesto = "Complementario";
                    impuestoLiquidar = "10";
                      txturl.setText ("https://app.arba.gov.ar/LiqPredet/sso/InicioLiquidacionIIC.do?Frame=NO&origen=WEB&imp=10&cuit=");
                    //txturl.setText ("https://www.arba.gov.ar/Aplicaciones/LiqPredet.asp?imp=10&Frame=NO&origen=WEB&opc=IIC");
                  
                    Ente = "004";
                    Rubro = "07";
                    ImpuestoCorto="IIC" ;
                    seleccionerronea = true;
                    break;
                }

                default:
                {
                        // cuotas = new List<string>() { "0" };
                       break;
                 }       

    }//GEN-LAST:event_ImpuestoActionPerformed
         if((FraccionImpuesto != "") && (seleccionerronea != false)){
        Origen_.setEnabled(true);
        }

        //directorioDestino += "Destino2022";
        
        BuscadorPorNombre( directorioOrigen,ImpuestoCorto);
        
        
       
    }  
   
    
    /////////////// Hasta que no se eleije forma de pago en radioCheck no hay selectro de impuesto. (esto para la forma de seleccion automática de archivo origen)
    
    
    private void COActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COActionPerformed

               Impuesto.setEnabled(true); 
    }//GEN-LAST:event_COActionPerformed

    private void DTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DTActionPerformed
               Impuesto.setEnabled(true);
    }//GEN-LAST:event_DTActionPerformed

    private void txtCantidadCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadCorteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadCorteActionPerformed

    private void Tipo_pruebaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tipo_pruebaMouseClicked
       
         if (Tipo_prueba.getState() == true){

            jLabel1.setEnabled(true);
            cantidadAleer.setEnabled(true);
            jLabel5.setEnabled(true);
            txtCantidadCorte.setEnabled(true);
            jLabel10.setEnabled(true);
            
        }else if (Tipo_prueba.getState() == false) {    
             
            jLabel1.setEnabled(false);
            cantidadAleer.setEnabled(false);
            jLabel5.setEnabled(false);
            txtCantidadCorte.setEnabled(false);
            jLabel10.setEnabled(false);

          }
        

        
    }//GEN-LAST:event_Tipo_pruebaMouseClicked


/////////////////extras Ñ: 
    
    
 ////////////////////////// HASH... y QR:
    
    
 public void QR_Hash(){

     if (ImpuestoCorto =="EMB"){

    
        medioPago = funcionHash();

      }


        QRString = generarStringQr(); 
    
    }
    
 public String funcionHash(){
         
     try {  
                           
                           
        String hash = getHashEmail(impuestoLiquidar, objeto, planta);
        medioPago = "<a href=\"" + "https://app.arba.gov.ar/pdfDeuda/emisiones/ARBADeuda/" + hash + "\"><i class=\"fa-solid fa-file-pdf\"></i></a>";       
              
            //System.out.println("Hash-->" + "https://app.arba.gov.ar/pdfDeuda/emisiones/ARBADeuda/" + hash);

        return  medioPago; 

       }catch (Exception e){}


        medioPago = "<a href=\"" + txturl.getText() + objeto + "\"><i class=\"fa-solid fa-file-pdf\"></a>";

       return  medioPago; 
                 
     }
     
 public static String getHashEmail(String impuesto,String objeto,String planta) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		

// Se acomoda-sobreescribe impuesto para que quede con unicidad de entrada y funcione en Queries
		
impuesto = impuestoRevisado(impuesto);
					
    // Se acomoda objeto y planta
    objeto = objeto.equals("")?"": objeto.toUpperCase();			
    planta = planta.equals("")?"N":planta.toUpperCase();

    String text = CLAVEHASH+impuesto+objeto+planta;

    MessageDigest sha256=MessageDigest.getInstance("SHA-256");
    sha256.update(text.getBytes("UTF-8"));
    byte[] digest = sha256.digest();
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<digest.length;i++){
             sb.append(String.format("%02x", digest[i]));
    }
    String hash=sb.toString();		
    String hashFinal = impuesto+hash.substring(0,hash.length()/2)+planta+hash.substring(hash.length()/2)+objeto;

    return hashFinal;
 
 }
 
 public static String impuestoRevisado(String impuesto) {
        String imp = impuesto;
        try {

        switch(imp) {
        case "0":
                imp = "00";
                break;
        case "1":
                imp = "01";
                break;
        case "3":
                imp = "03";
                break;
        }
        }catch(Exception e) {
                System.out.println("El impuesto --> "+impuesto+" no pudo ser revisado");
        }

        return imp;
}
 
 
 
  //**************************hash
 
 
    
    ////////////////////////////////////armado del string de QR: 
     
public String generarStringQr(){

    QRContenido = "https://app.arba.gov.ar/PagoQR/imagencdni?url=" + "https%3A%2F%2fcdni.redlink.com.ar%2flinkarba.html%3Fprod%3Dcdniarba%26ente%3D" 
                + Ente + "%26rubro%3D" + Rubro + "%26cpe%3D" + codigoElectronico ; //+ "%26crc%3DXXXX"

    QRString = "<td class='qr' align=\"center\" valign=\"middle\"  ><img src=" + "'" + QRContenido + "'" + " height='100' width='100'></td> "; //style=\"padding: 1rem; border: solid 1px black;\"

     return QRString; 
               
}
     
     
     
     
     
     
     
  
      //////////////////////////--- Selector automático de nombre de archivo. ///////////////////
        
        
        
       public String BuscadorPorNombre(String Origen, String ImpuestoCorto){//EDI, AUT, BAL,RUR, EMB, IIC

       
        String tipo = ""; 
         
        if(CO.isSelected() == true){
         
           tipo = "CO"; 

        } else if(DT.isSelected() == true){tipo = "DT";}
        ///////////////////////////////////////
         
        
        File FoldFuente = new File(directorioOrigen); 
        File[] Archivos = FoldFuente.listFiles();
        byte[] buffer = new byte[1024];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //dd/MM/yyyyHH:mm:ss
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy"); 
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy"); 
     
       
        
        BasicFileAttributes attrs;
    try {                   
        try { 

            dateAux = sdf3.parse("12/06/2000");

        } catch (Exception e) {e.printStackTrace();}


        for (int j = 0; j < Archivos.length; j++) {

           if ((Archivos[j].getName().contains(ImpuestoCorto)) && (Archivos[j].getName().contains(tipo))) {

                if (Archivos[j].getName().contains("Informe") || Archivos[j].getName().contains("zip") ){ /*XD*/}else {


                 attrs = Files.readAttributes(Archivos[j].toPath(), BasicFileAttributes.class);

                 FileTime time = attrs.creationTime();   

                 formatted = sdf.format( new Date( time.toMillis() ) );

                  //System.out.println( "La fecha y hora de creación del archivo es: " + formatted );


                  //////////////////////////////////////////////////////////***////////////////

                   try {  
                  FechaFormateada = sdf2.parse(formatted); 
                  } catch (ParseException ex) {System.out.println("catch 666");} 

                    if (FechaFormateada.after(dateAux)) { //msL < msLAux

                         nombreDeUltimo = Archivos[j].getName();
                         System.out.println("nombre: " + nombreDeUltimo + ", fecha: " + FechaFormateada);
                         //msLAux = msL;    
                        dateAux = FechaFormateada;

                    }
                }
            } 
        }   

        System.out.println(nombreDeUltimo + formatted);

	} catch (IOException e) {e.printStackTrace();}
         

        ///////////////////////////////////////////////////////////////
 

         File archivoSeleccionado;
            
            Original = Origen + nombreDeUltimo; 
        
            txtOrigen = Original;
                 
            File myFile = new File(txtOrigen); 

            
            /////Peso, barras y textbox informativos: ///////////////////////// 

             size1 = myFile.length();
             valInt =  Long.valueOf(size1).intValue();
             Maximo =  (valInt/ 40700) *100; 
             jT_Totales.setText(Integer.toString(Maximo));
             JT_Tantos.setText("0");

            ////////////////////////////////////////////////////////////
         
           if (seleccionerronea != false){
            
            txtArchivoOrigen.setText(Original);
            Generar_.setEnabled(true);
           }
       return nombreDeUltimo;
    }
    
    
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       hilo1.interrupt();
    }//GEN-LAST:event_jButton1ActionPerformed
 
 /*public void filtroNombresInternos(String mail){
 

    String [] ARBAM = new String [] {"patriciafeo64@gmail.com","sebastian_marcon@hotmail.com"}; //
    
    for (int i = 0 ; i < ARBAM.length; i++){
    
    
        if (ARBAM[i].equals(mail)){

        inermail = true;

        }else { inermail = false;}

    }
    
   
 
 }   */
    
 public String filtroNombresCaracteres(String Nombre){
 
      String  nombre2 = ""; 
     
    for (int i = 0; i<Nombre.length(); i++){

     if(Nombre.substring(i,i+1).matches("[a-z]*")){
        nombre2+=Nombre.substring(i,i+1);
     } else {
        nombre2+=" ";
     }
     
    } 
    return nombre2 ;
 }

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
  
  public void Mayusculas(String cadena)  {


       String nombre ="" ; 
       String vacio = " "; 
       char[] myChars = cadena.toCharArray();
       char[] CharVacio = vacio.toCharArray();
       
      for (int i = 0 ; i< myChars.length; i++) {
         
          
          
          if(( i == 0)){
          
           nombre+= (String.valueOf(myChars[i])).toUpperCase();
          
          }else if ( myChars[i - 1] == CharVacio[0]) {

             nombre+= (String.valueOf(myChars[i])).toUpperCase();
     
         }else {nombre+= String.valueOf(myChars[i]);}
          
          
      }
          System.out.println("---->" + nombre);
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
    private javax.swing.JRadioButton CO;
    private javax.swing.JCheckBox ConAnual;
    private javax.swing.JCheckBox ConCabecera;
    private java.awt.Checkbox ConQrCB;
    private javax.swing.JCheckBox Correc_Mayus;
    private javax.swing.JRadioButton DT;
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
    private javax.swing.ButtonGroup SelectorDePago;
    private java.awt.Checkbox Tipo_prueba;
    private javax.swing.JProgressBar barraGenerados;
    private javax.swing.JProgressBar barraLeidos;
    private javax.swing.JTextField cantidadAleer;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
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

  

//Historial: 


///se csambió el streamWriter por esto: (31/8/2022) para corregir el problema del utf-8: https://stackoverflow.com/questions/35132693/set-encoding-as-utf-8-for-a-filewriter
}

 
    
