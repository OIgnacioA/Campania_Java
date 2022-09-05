/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.text.*;
import java.util.Date;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;



/**
 *
 * @author sehent
 * 
 * 
 * 
 * 
 * directorioOrigen = ""; // el origen es siempre el mismo en el caso de WEB. 
 *                      - por eso no se utiliza aqui esta variable. 
 * 
 * 
 * 
 * 
 *   // JOptionPane.showMessageDialog(null, "...");
 */
public class Proceso {       
    
    
    
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
    private String QRString = "";
    private String QRString1 = "";
    private String QRString2 = "";
    private String URLText = ""; 
    private String URLText1 = "";
    
        
    private String FraseQR = "";
    private String QRContenido = "" ;     
    private boolean res ; 
    
////////////////////////////////////////// WEB : 
    
    String cantSubscrip = "";
    String Impuesto =  "";
    String Fecha = "";
    String CheckAnual="";
    String CheckCabecera= "";
    String ChecDiferenciar= "" ;
    String CheckMayus= "" ;
    String Radio= "" ;    
    String Corte= "" ;  
    
    Boolean Local = false; 
    Boolean Red = false;
    String Npath ="";
    int cantidadArchivosGenerados = 1;
    String nombreArchivoGenerado = ""; 
    String Escritorio = System.getProperty("user.home") + "\\desktop";

public void Origen_ () {

    txtOrigen = Escritorio +"\\"+ Npath ;
    
    fullPath = txtOrigen ;

   

    /*////Peso, barras y textbox informativos: ///////////////////////// 

        size1 = myFile.length();
        valInt =  Long.valueOf(size1).intValue();
        Maximo =  (valInt/ 40700) *100; 
        jT_Totales.setText(Integer.toString(Maximo));
        JT_Tantos.setText("0");
    
     *////////////////////////////////////////////////////////////

}
   
    
    
public void Generar(String cantSubscrip,String Corte, String Fecha, String CheckAnual,String CheckCabecera,String ChecDiferenciar,String CheckMayus,String Radio, String URLtext, String path) {      

    Npath = path; 
    URLText = URLtext;
    this.cantSubscrip = cantSubscrip;
    this.Corte = Corte;
    this.Fecha = Fecha;
    this.CheckAnual= CheckAnual;
    this.CheckCabecera= CheckCabecera;
    this.ChecDiferenciar= ChecDiferenciar ;
    this.CheckMayus= CheckMayus ;
    this.Radio= Radio ;

    boolean seguir = false;

    if ("A carpeta Local".equals(Radio)){

        Local = true; 

    }else if ("A Red".equals(Radio)){

        Red = true; 
    } 

    try{      
        int cantidad = Integer.parseInt(cantSubscrip);
        if (cantidad != 0){seguir = true;}
    }catch (Exception e) {}

    if (seguir){

        ImpuestoV = Impuesto;  

        fullPath = txtOrigen ;

        Origen_ ();  
        Nambrar (); 

    }else {
        JOptionPane.showMessageDialog(null, " Ingrese la cantidad de suscripciones a procesar. ", " Boleta Electrónica ", JOptionPane.ERROR_MESSAGE);  
    }      

}    

public void Nambrar () {
   
   nombreArchivoGenerado = String.format ("%s-Parte-%s.csv", Npath, cantidadArchivosGenerados);   
   
  boolean GO =  VerificarPrevio(nombreArchivoGenerado);
       
  if (GO){
      JOptionPane.showMessageDialog(null, "Ya existe un elemento creado con este nombre.\n Puede Presionar boton 'Limpiar File' para \n cambiar a otro archivo.");
  }else if (GO == false){
    Procesar();
  }
   
}


public void Procesar() {
     
      Thread hilo1=new Thread(){
     
      @Override
       public void run(){
            
        try {
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
        cantidadaleer = Integer.parseInt(cantSubscrip);
        
        //Generar_.setText("Procesando");
        
        int cantidadMailIgual = 0;
        int cont=0;
        int conta = 0;
        int contador = 0;        
        int escritos = 0;
        
        int cantidadCorte = Integer.parseInt(Corte);
        Long Lineas = 0L; 
        String line = "" ;
        String mailLinea = ".";
        String datosTodosObjetos =".";
        String ultimoMail = ".";
        int contt = 0 ; 
       
        
        BufferedReader filAS = null;
        BufferedReader file = null; 
        FileWriter SW = null; 
       
        FileWriter swResultados = null; 
        BufferedWriter br = null; 
        

      fechaOpcion = Fecha;
              
    
        
        //////////////////////////////////////////////////////////////////////////////////

            if (Local == true)
            {

               ArgumentoOpcionCheck1 =  Escritorio + "\\" + nombreArchivoGenerado;
               ArgumentoOpcionCheck2 = fullPath + "-Informe.txt";
               
            }
            else if (Red == true)
            {
                ArgumentoreaderNuevo = directorioDestino + "\\" + nombreArchivoGenerado;
                ArgumentoOpcionCheck1 = ArgumentoreaderNuevo;
                ArgumentoOpcionCheck2 = directorioDestino + "\\" + Npath + "-Informe.txt";
        
             System.out.println ("-------------------------XXXX----------" + ArgumentoOpcionCheck1);
            }
 
         ////////////////////////////////////////////////////////////////////////////////
        
        try{
            SW = new FileWriter(ArgumentoOpcionCheck1,true);   
        } catch (Exception e){System.out.println("Error de lectura del fichero 1");}
        //JOptionPane.showMessageDialog(null, "Error de lectura del fichero 1: ---" + Hard);
       
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
        }catch(Exception e) { JOptionPane.showMessageDialog(null, "Error de lectura del fichero 2");}

     

            while (line != null) {
       
              LeerLinea(line);
              
              //JOptionPane.showMessageDialog(null,"mail------"+ mail);
              
                if (mailAux == "") {
                    mailAux = mail;
                    razonsocialAux = razonsocial;
                    cuitAux = cuit;
                }


              ArmarDatosMail();
                
                if ((!mail.equals(mailAux)) || (!razonsocial.equals(razonsocialAux))) {

                   if (( ChecDiferenciar != "") && (mailAux.equals(ultimoMail))) {
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

                                
                                
                                nombreArchivoGenerado = String.format("%s-Parte-%s.csv", Npath, cantidadArchivosGenerados);
                                //nombreArchivoCsv = String.format("%s %s", directorioDestino, nombreArchivoGenerado);
                                
                                
                                /////////////////////////////////////////////////////////////////////////

                                
                                if (Local == true)
                                {
                                    
                                    ArgumentoOpcionCheck1 = CarpetaDestino + "\\" + nombreArchivoGenerado;
                                    
                                }
                                else if (Red == true)
                                {
                                    
                                  ArgumentoreaderNuevo = directorioDestino + "\\" + nombreArchivoGenerado;
                                  ArgumentoOpcionCheck1 = ArgumentoreaderNuevo;

                                }

                               /////////////////////////////////////////////////////////////////////
                                

                                try {
                                    SW = new FileWriter(ArgumentoOpcionCheck1, true);
                                } catch (Exception e) {
                                    System.out.println("Error de lectura del fichero 3");
                                    JOptionPane.showMessageDialog(null, "Error de lectura del fichero 3");
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

//                    BarraGenerados(Maximo, distintos);

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
                
               // JT_Tantos.setText(String.valueOf(counter));   

 //              CargarBarra(Maximo);


                try {
                    line = file.readLine();
                } catch (Exception e) {
                    System.out.println("Error de lectura del fichero 4");
                    JOptionPane.showMessageDialog(null, "Error de lectura del fichero 4");
                }
              
            }//while

         

        if (( ChecDiferenciar != "") && (mailAux == ultimoMail)){
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
    
    //Generar_.setEnabled(true);
    //Origen_.setEnabled(true);
    System.out.println("Lineas erroneas: " + conterror);
} 


public boolean VerificarPrevio(String Nombre){
    
////Primero ver donde fijarse: 

String Workspace= "";

       if (Local == true){

           Workspace= Escritorio; 
           
        }
        else if (Red == true){

           Workspace= directorioDestino;
            
        }
 // Luego :    verificar si nombre ya existe allí: 
 
    String Nom = Nombre; 
    File Esq = new File(Workspace);
    File[] archivos = Esq.listFiles();
    byte[] buffer = new byte[1024];
    boolean respuesta = false; 
    String Arch = (Npath + "_"); 

   if (Esq.isDirectory()) {

            for (int k = 0; k < archivos.length; k++) {

                if (archivos[k].getName().contains(Arch)) { //se busca el archivo con nombre de csv.

                    respuesta = true; 

                }
            }

        }
   
   return respuesta; 
   
}


public void OpcionDeZipeado() throws IOException{
    

    //getContentPane().setBackground(Color.getHSBColor(80, 300, 100));
   
    String mensaje = "";

    if (counter != (Integer.parseInt(cantSubscrip))) {

        mensaje = String.format(" \"Cantidad de registros ERRONEA!!\" %n La cantidad de suscripciones configuradas %d y es distinta a la  %n  cantidad de registros leidos %d.  %n De todas maneras se generaron %d mails para enviar. ", Integer.parseInt(cantSubscrip), counter, distintos);
        JOptionPane.showMessageDialog(null, mensaje);

    } else {

        String mensaje2 = String.format("Se leyeron %d suscripciones y se generaron %d mails para enviar. %n Armar bases?", counter, distintos);
        JOptionPane.showMessageDialog(null, mensaje2);

        //barraGenerados.setValue(cantSubscrip); // agregado Ñ para que la barra de Generados termine. 
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



public void InformarArchivosGenerados() throws FileNotFoundException, IOException{
 
    if (Local == true)
    {
        InformarArchivosGenerados_Original();

           
    }else if (Red == true){
      

        File Fuente = new File(directorioDestino);
        File[] ficheros = Fuente.listFiles();
        byte[] buffer = new byte[1024];
      

        /// comprobar que no exista ya un zip: cambiar nombre: Y NOMBRAR al Zip
    
            zipFile = VerificarZipPrevio(Fuente, ficheros, zipFile); 
            
         ////////                          
            
      
             
        /*//formulario informativo: 
        ConteoZip form2 = new ConteoZip();
        form2.setVisible(true);
        form2.BarraMax(ContadorCSV + 1);
        form2.textTotal(ContadorCSV + 1);
        int cont  = 0;
        /////////////////////////////////////*/   
            
       
        InputStream input = null;
        ZipOutputStream zipOut = null;
        zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        int len;

       String Arch = (Npath + "-");
        
        if (Fuente.isDirectory()) {

            for (int j = 0; j < ficheros.length; j++) {

                if (ficheros[j].getName().contains(Arch)){
                    
                    input = new FileInputStream(ficheros[j]);
                    zipOut.putNextEntry(new ZipEntry(ficheros[j].getName())); //Fuente.getName() + File.separator + 
                    while ((len = input.read(buffer)) > 0) {
                        zipOut.write(buffer, 0, len);
                    }
                    cont++;
/*
                    form2.BarraSuma(cont);
                    form2.textActual(cont);
                    input.close();
*/                    
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
            
           if ( ficheros[i].getName().contains(Arch) ){ //&& (ficheros[i].length()!= size1
                 
              ficheros[i].delete();
              
              /*
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
                }*/
            }
        }
    }
    
   
    
}

public void  InformarArchivosGenerados_Original() throws FileNotFoundException, IOException{
    
    /*//formulario informativo: 
    ConteoZip form2 = new ConteoZip();
    form2.setVisible(true);
    form2.BarraMax(ContadorCSV + 1);
    form2.textTotal(ContadorCSV + 1);
    int cont  = 0;
    /////////////////////////*/


    File Fuente = new File(Escritorio); //fullpath
    File[] ficheros = Fuente.listFiles();
    byte[] buffer = new byte[1024];
    
    
    // comprobar que no exista ya un zip: cambiar nombre:
    
        zipFile = VerificarZipPrevio(Fuente, ficheros, zipFile); 
        
    ///

    InputStream input = null;
    ZipOutputStream zipOut = null;
    zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
    
    String Arch = (Npath + "-");
   
    int len;

    if (Fuente.isDirectory()) {

        for (int j = 0; j < ficheros.length; j++) {
    
           if ( (ficheros[j].getName().contains(Arch) )   ) {  { // no introducir el Archivo original
               
               if (ficheros[j].getName().contains(".zip")){/* XD */ } else{ //no introducir el Zip. 
                  cont++;
                  
                    input = new FileInputStream(ficheros[j]);
                    zipOut.putNextEntry(new ZipEntry(ficheros[j].getName())); //Fuente.getName() + File.separator + 
                    while ((len = input.read(buffer)) > 0) {
                        zipOut.write(buffer, 0, len);
                    }
/*                 
                 form2.BarraSuma(cont);
                 form2.textActual(cont);
*/               } 
               
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
        
        if (ficheros[i].getName().contains(Arch)) { // && (ficheros[i].length()!= size1 )
         
            
            ficheros[i].delete();
                  
                            
                  
          /*        
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
            }*/
        }
    }
 }    
    
    ContadorCSV = 0 ;  
    
}

   public File VerificarZipPrevio(File Fuente, File[] ficheros, File zipFile ){ // verificar y crear nombre nuevo

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
         
        if (Local == true){

            nombreDeZip = Npath + "_("+ contzip +").zip" ;
            zipFile = new File(Escritorio + "\\" + nombreDeZip);
           
        }
        else if (Red == true){

            nombreDeZip = Npath + "_("+ contzip +").zip" ;
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
            if (CheckCabecera != "")
            {
               try {
                pSw.write("email|nombre|cuit|fechav|fechao|anio|cuota|impuesto|datos|descuento");
                pSw.append('\n');
               }catch(Exception e){}
            }

  }

private void LeerLinea(String line){
           
    
   // JOptionPane.showMessageDialog(null,"---Impuesto: " + Impuesto);
    
    switch (Impuesto)
      
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
            
            
          
            System.out.println("----***"+debitoCredito);
            
            
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

    if (CheckMayus != ""){razonsocial = Mayusculas(razonsocial);}
     
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

           
            if (CheckAnual != "")
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


           if (CheckMayus != ""){razonsocial = Mayusculas(razonsocial);}
                
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
                        medioPago = "<a href=\"" + URLText + objeto + "\">Ingresar</a>";
                        System.out.println("urltext tiene el valor: "+URLText);
                        
                        
                        QRString1="https://qrcode.tec-it.com/API/QRCode?data="+URLText+ objeto;
                        QRString2 = "<td><img src= " + QRString1 + " height='100' width='100'></td>";
                       
                        
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

                medioPago = "<a href=\"" + URLText + objeto + "\">Ingresar</a>";
                QRString1="https://qrcode.tec-it.com/API/QRCode?data="+URLText+ objeto;
                QRString2 = "<td><img src= " + QRString1 + " height='100' width='100'></td>";   
                        
                        ;
                break;
            }
        }
        
    
        if ("Impuesto Complementario".equals(Impuesto))
            {
                datosObjeto = "<tr class='datos'>";
                datosObjeto += String.format("<td class='gris'>%s - %s</td>", objetoFormateado, plantaDescri);
                datosObjeto += String.format("<td class='amarillo'>Cuota s%</td>", cuotaNumero);
                datosObjeto += String.format("<td class='amarillo'>%s</td>", montoCuota);
                datosObjeto += String.format("<td class='gris'>%s</td>", medioPago);
                datosObjeto += String.format(QRString2);
                
               // datosObjeto += string.Format("<td class=''>%s</td>", Variable);

                datosObjeto += "</tr>";
        }else{
            
            if (CheckAnual !="")
             {
                datosObjeto = "<tr class='datos'>";
                datosObjeto += String.format("<td rowspan='2' class='gris'>%s</td>", objetoFormateado);
                datosObjeto += String.format("<td class='amarillo'>Cuota %s</td>", cuotaNumero);
                datosObjeto += String.format("<td class='amarillo'>%s</td>", montoCuota);
                datosObjeto += String.format("<td rowspan='2' class='gris'>%s</td>", medioPago);
                datosObjeto += String.format(QRString2);
                
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
                
              /* QRnuevo.generador(medioPago);
               
                try {
                   QRString = Encoder.encodeFileToBase64Binary(f);      
                } catch (IOException ex) {Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);}
                
                datosObjeto += String.format("<td><img src='data:image/png;base64, %s' alt='Red dot'/></td>", QRString);//www.ARBA.gov.ar
                */
              
                // datosObjeto += String.Format("<td class='gris'>%s</td>", Variable);
                
                datosObjeto += String.format(QRString2);
                
                datosObjeto += "</tr>";
                
               // System.out.println(datosObjeto);
            }
        }
    }
 

    public void ImpuestoComboBox(String Imp) {
       

        switch (Imp){
        case "1": 
        {Impuesto="Impuesto Automotor";
            break;}
        case "2": 
        {Impuesto="Impuesto a las Embarcaciones";
            break;}
        case "3": 
        {Impuesto="Impuesto Urbano Edificado";
            break;}
        case "4": 
        {Impuesto="Impuesto Urbano Baldío";
            break;}
        case "5": 
        {Impuesto="Impuesto Rural";
            break;}
        case "6":
        {Impuesto="Impuesto Complementario";
            break;}
        default:
        { break;
        }           
        }

      
        directorioOrigen = ""; 
        FraccionImpuesto = Impuesto;
        
               // directorioOrigen =  
        directorioDestino = "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Destino";   
        
        
        
       /* 
        directorioOrigen = "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen";
        directorioDestino = "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Destino";   

     */          
               
               
               
        if(FraccionImpuesto == null){
          FraccionImpuesto =".";
        }

        //List<String> cuotas = new List<String>();

        System.out.println("XXXXllllllllllllllllllll  Fraccion impuesto: :   "+FraccionImpuesto);
        switch (FraccionImpuesto)
        {
            case "Impuesto Automotor":
                {
                    directorioOrigen += "\\Automotores\\";
                    directorioDestino += "\\Automotores\\";

                    impuestoLiquidar = "1";
                    nombreImpuesto = "Automotor";
                    URLText1 = ("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=1&opc=LIC&oi=");
                                     

                                    
                    break;
                }
            case "Impuesto a las Embarcaciones":
                {
                    directorioOrigen += "\\Embarcaciones\\";
                    directorioDestino += "\\Embarcaciones\\";
                    nombreImpuesto = "Embarcaciones";
                    impuestoLiquidar = "3";
                    URLText1 = ("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=3&opc=LIC&oi=");
                    break;

                }
            case "Impuesto Urbano Edificado":
                {
                    directorioOrigen += "\\Edificado\\";
                    directorioDestino += "\\Edificado\\";
                    nombreImpuesto = "Edificado";
                    impuestoLiquidar = "0";
                    URLText1 =("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=");
                    break;
                }
            case "Impuesto Urbano Baldío":
                {
                    directorioOrigen += "\\Baldio\\";
                    directorioDestino += "\\Baldio\\";
                    nombreImpuesto = "Baldio";
                    impuestoLiquidar = "0";
                    URLText1 =("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=");
                    
                    break;
                }
            case "Impuesto Rural":
                {
                    directorioOrigen += "\\Rural\\";
                    directorioDestino += "\\Rural\\";
                    impuestoLiquidar = "0";
                    nombreImpuesto = "Rural";
                    URLText1 =("https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=");
                    break;
                }
            case "Impuesto Complementario":
                {
                    directorioOrigen += "\\Complementario\\";
                    directorioDestino += "\\Complementario\\";
                    nombreImpuesto = "Complementario";
                    impuestoLiquidar = "10";
                    URLText1 = ("https://www.arba.gov.ar/Aplicaciones/LiqPredet.asp?imp=10&Frame=NO&origen=WEB&opc=IIC");
                    break;
                }

                default:
                {
                       URLText1 = "Selecinar un Impuesto.";
                       break;
                 }       

    }

   
/*  if(FraccionImpuesto != ""){
        Origen_.setEnabled(true);
        }
*/  

        directorioDestino += "Destino2022";
        
    }  

    
public String  GetURL(){

System.out.println("valor valor valor "+ URLText1);
 return URLText1 ;


}


/////////////////extras Ñ: 
  /*   
 public void ValoresBarra(){
      
 valInt =  Long.valueOf(size1).intValue();
 Maximo =  (valInt/ 40700) *100; 

 CargarBarra(Maximo);


 jT_Totales.setText(Integer.toString(Maximo));
  
 }   
 */      
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
 /* 
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
     hilo2.start();  
 }
 */         
 
 
 
 /*public String ObtenerNombre(String nom){

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
*/


}


