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
    private String Path = "";
    private String ImpuestoV = "";
    private String NombreOrigen = ""; 
    private String FraccionImpuesto =  "";
    
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

    
    
    private FileNameExtensionFilter filter = new FileNameExtensionFilter ("Archivos Txt", "txt");
  
    public frmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Generar Bases para campaña por mail V1");
       
        Generar.setEnabled(false);
        Origen.setEnabled(false);
        
        Dir = "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Origen";
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Impuesto = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txturl = new javax.swing.JTextField();
        Origen = new javax.swing.JButton();
        txtArchivoOrigen = new javax.swing.JTextField();
        Generar = new javax.swing.JButton();
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

        txtCantidad.setText("5");

        jLabel1.setText("Cant. Suscripciones ");

        jLabel2.setText("URL");

        Origen.setText("Origen");
        Origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrigenActionPerformed(evt);
            }
        });

        Generar.setText("Generar");
        Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarActionPerformed(evt);
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
                                        .addComponent(Origen)
                                        .addGap(2, 2, 2))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(FechaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(Generar, javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(Origen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Generar)
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

    private void OrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrigenActionPerformed
       
        String DirOrigen ="";
        //Dir = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().toString();
        
        //Dir = "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent";
          DirOrigen = Dir + "\\" + directorioOrigen;
        
          
        File archivoSeleccionado;
        
        
        JFileChooser seleccionarArchivo = new JFileChooser();
        seleccionarArchivo.setFileFilter(filter);
        seleccionarArchivo.setCurrentDirectory(new File(DirOrigen));
        seleccionarArchivo.showOpenDialog(null);
        archivoSeleccionado = seleccionarArchivo.getSelectedFile();
        Path = archivoSeleccionado.getAbsoluteFile().toString();
         System.out.println ("path1-----> " + Path);
        
        txtOrigen = Path; 
        
        if(txtOrigen != ""){ 
        txtArchivoOrigen.setText(txtOrigen);
        Generar.setEnabled(true);
        }

    }//GEN-LAST:event_OrigenActionPerformed

    private void GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarActionPerformed
        boolean seguir = false;
      
            try
            {
                int cantidad = Integer.parseInt(this.txtCantidad.getText());
                seguir = true;
            }
            catch (Exception e) {
                
             }

            if (seguir){
                
                ImpuestoV = Impuesto.getSelectedItem().toString();
                txtDestino = Path;
                
                MyReplace(Dir, txtDestino);
  
               //procesar();
            }
            else
            {
                txtCantidad.requestFocus();
                JOptionPane.showMessageDialog(null, " Ingrese la cantidad de suscripciones a procesar. ", " Boleta Electrónica ", JOptionPane.ERROR_MESSAGE);    
              
            }
            
            this.getContentPane().setBackground(Color.orange);
            
            Procesar();
   
    }//GEN-LAST:event_GenerarActionPerformed

    
    
    
    
    
    
    
    
    
    public void Procesar() throws IOException{
        
        int cantidadMailIgual = 0;
        int counter = 0; 
        int distintos = 0; 
        int contador = 0;        
        int escritos = 0;
        int cantidadCorte = Integer.parseInt(txtCantidadCorte.getText());
        String line ;
        String mailLinea = ".";
        String datosTodosObjetos =".";
        String ultimoMail = ".";
        int cont=0;
        BufferedReader file = null; 
        FileWriter sw = null;
        FileWriter SWinforme = null;
        BufferedWriter buffer = null; 
        int cantidadArchivosGenerados = 1;
        
        String  Patth = directorioOrigen + "informe.txt"; 
        String nombreArchivoGenerado = txtDestino + "-Parte-{1}.csv";
        
         try{
            SWinforme = new FileWriter(Path,true);
                buffer = new BufferedWriter(SWinforme);
                buffer.write("Se generearon los siguientes archivos:");
                buffer.newLine();
                buffer.flush();
                buffer.close();             
                buffer.write(String.format("Archivo ** %s ** ", nombreArchivoGenerado));
        
        } catch (FileNotFoundException e) {
                    System.out.println("Archivo no encontrado. Cambia la ruta de INFORME");
        }
         

        try{
        file = new BufferedReader (new FileReader(txtOrigen));

        while((line = file.readLine()) != null){
        
            
            
            
            
           /* while((line = file.readLine()) != null){


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


                if ((DiferenciarMails.isSelected()) && (mailAux == ultimoMail))
                {
                    cantidadMailIgual++;
                }
                else
                {
                    cantidadMailIgual = 0;             
                }                   
                  if (cantidadMailIgual == 0)
                {
                    mailLinea = String.format("%s"|,mailAux);             
                }
                else
                {
                    mailLinea = String.format("s% s%|", mailAux, String.valueOf(cantidadMailIgual);                  
                }*/
                  

                  //Esto es una prueba num
                  
                    ultimoMail = mailAux;
                    
                    formatearCuit(cuitAux);
                    mailLinea += String.format("%s|Cuit: %s | %s |  %s  | %s | %s | %s | %s | %s", razonsocialAux, cuitAux, fechaVencimiento, fechaOpcion, anio, cuota, impuesto, datosTodosObjetos, porcentaje); 
    
                    System.out.println("--Mai Linea ---" + mailLinea);
                    
                   if (escritos == cantidadCorte)
                    {
                     buffer = new BufferedWriter(SWinforme);
                     buffer.write(String.format("Con %d suscripciones y %d mails para enviar", contador, escritos));
                      buffer.newLine();
                      buffer.flush();
                      buffer.close();
                    
                      escritos = 0;
                      contador = 0;
                      cantidadArchivosGenerados++;
                    
                      buffer = new BufferedWriter(sw);
                      buffer.flush();
                      buffer.close();
                                        
                    

                      nombreArchivoGenerado = String.format(" %s-Parte-%s.csv", txtDestino, cantidadArchivosGenerados);

                      sw = new System.IO.StreamWriter(nombreArchivoGenerado);
                      
                      
                      
                      
                      
                      SWinforme.Write(String.format("Archivo ** {0} **", nombreArchivoGenerado));                        
                      this.EscribirCabecera(sw);
                    }*/

                        distintos++;//
                        escritos++;//


                       /* if (distintos <= this.barraGenerados.Maximum)
                        {
                            this.barraGenerados.Value = distintos;       //                 
                        }

                      */
                  
                  ///Prueba Ñ : Writer 
                  
                  /* FileWriter sw = null;
                   PrintWriter pw= null;*/
                  
                  try {
                     String archivo = directorioDestino + "prueba.txt";
                     
                   
                      sw = new FileWriter(archivo,true);
     
                      LeerLinea(line);    
                      buffer = new BufferedWriter(sw);
                      
                      buffer.write(mailLinea);
                      buffer.newLine();
                      
                      buffer.flush();
                      buffer.close();
                                             
                  } catch (FileNotFoundException e) {

                         System.out.println("Archivo no encontrado. Cambia la ruta");
                  }

                        
    
            }
           //}//if

         //}//while

        }catch(FileNotFoundException e){

             System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(file != null)
                    file.close();
            }
            catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
    
        
 }

    public void formatearCuit(String mail){
                
        
        
        
        
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

           /* TextInfo myTI = CultureInfo.CurrentCulture.TextInfo;
            razonsocial = myTI.ToTitleCase(razonsocial);*/

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


            /*TextInfo myTI = CultureInfo.CurrentCulture.TextInfo;
            razonsocial = myTI.ToTitleCase(razonsocial);*/

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

            directorioOrigen = "";

            directorioDestino = "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Destino\\";

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
            
            Origen.setEnabled(true);
            }
    
    }  
   
    private void ArmarDatosMail() 
        {

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

       System.out.println ("La fecha final ---->"+Fechas);
      
    return Fechas; 
    
    }
    
    public String MyReplace(String Val1, String Val2){
     
        String resultado = "";
        
        int diff = ( Val2.length() - Val1.length());
         
           
            
        for (int j = 0 ; j < diff ; j++){
            Val1 += " "; 
        }
            
            
        for (int i= 11 ; i<Val2.length();i++) {
        
           if (Val2.charAt(i) != Val1.charAt(i)){
               NombreOrigen += Val2.charAt(i);
           }
        }
        
      
   
       
        resultado = NombreOrigen.substring(1);
       
        System.out.print("my Replace----------> " + resultado);
        
       return resultado; 
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
    private javax.swing.JButton Generar;
    private javax.swing.JComboBox<String> Impuesto;
    private javax.swing.JButton Origen;
    private javax.swing.JProgressBar barraGenerados;
    private javax.swing.JProgressBar barraLeidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtArchivoOrigen;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadCorte;
    private javax.swing.JTextField txturl;
    // End of variables declaration//GEN-END:variables
}
