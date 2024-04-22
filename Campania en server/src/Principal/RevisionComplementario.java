package Principal;



import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

/*
 * 
 * 		
 * 
 */

public class RevisionComplementario{
	

        public RevisionComplementario(String carpetaCSV) {
            this.carpetaCSV = carpetaCSV;
            this.vuelta = 1;
        }
    	
    public void UltimaRevision() {  	
    	 Tipo = "/DT";
    	 destinoActual = carpetaCSV + Tipo;
    	 File carpeta = new File(destinoActual);
         File[] archivos = carpeta.listFiles();
        	
         System.out.println("   ");
         
      while (vuelta < 3) {   //SE REVISAN CADA CARPETA POR SEPARADO: CO Y DT.
         
         
         
		         if (archivos != null) {
		             for (File archivo : archivos) {
		                 if (archivo.isFile() && archivo.getName().endsWith(".csv")) {
		
		                	 try {
		                		 Revisionado2 rev = new Revisionado2(archivo.getAbsolutePath(), Tipo ); 
		                		 System.out.println("   ");
		                		 System.out.println("revisando: " + archivo.getName() );
		                		 rev.chequeo();
		                     } catch (IOException e) {
		                         System.out.println("Error al procesar el archivo " + archivo.getName() + ": " + e.getMessage());
		                     }
		
		                }	
		            }
		        }  
		         
		         Tipo = "/CO";
		         destinoActual = carpetaCSV + Tipo;    //"C:/Users/oscar.avendano/Desktop/Impuestos/Destino/AU/DT";//COLOCAR DESTINO DESDE PRINCIPAL.
		         carpeta = new File(destinoActual);
		         archivos = carpeta.listFiles();
		         vuelta++;
		      }       
      System.out.println("Revision terminada.");
         }
    
	private String carpetaCSV;
	public String destinoActual; 
	private int vuelta = 1;
	public String Tipo; 

}

class Revisionado2 {
    public String pathDestinoCSV;
    BufferedReader file = null;  
    public String line;
    public String Nombre;
    public String str1;
    public String str2;
    public String str3;
    public String Tipo;
    public int counter = 1;
    
    public Revisionado2(String Path, String Tipo) {
        this.pathDestinoCSV = Path; 
        this.Tipo = Tipo; 
    }

    public void chequeo() throws IOException {
        try {
            file = Files.newBufferedReader(Paths.get(pathDestinoCSV), StandardCharsets.ISO_8859_1);
            file.readLine();
        } catch (Exception e) {
            System.out.println("Excepcion cacht 1: " + e);
        }

        Nombre = obtenerNombreArchivo(pathDestinoCSV);
        
        while ((line = file.readLine()) != null) {
        	
            if (Nombre.contains("_CO.txt")) {
                str1 = detectarYProcesar(line);// //CUIT:
                str2 = formatearNumero(detectarYProcesar2(line));// // "INGRESAR"
               
                
                if (!str1.equals(str2)) {
                   System.out.println("se ha detectado una falta de coincidencias en el archivo: " + Nombre + ". En la linea: " + counter);
                   System.exit(0);
                }
            }else {
            	
            	
            	
            	  str1 = detectarYProcesar(line);// //CUIT:
                  str2 = formatearNumero(detectarYProcesarAQU(line));// AQUI
                  str3 =detectarYProcesar3(line);//'gris'
                  

                  
                Boolean coincidencia = alMenosDosIguales( str1, str2, str3);
                    
                    
                if (!coincidencia) {
                     System.out.println("se ha detectado una falta de coincidencias en el archivo: " + Nombre + ". En la linea: " + counter);
                     System.exit(0);
                  }

            	
            }
            counter++;
        }
        counter = 1; 
    }

    // Función para obtener el nombre del archivo de la ruta completa
    private String obtenerNombreArchivo(String ruta) {
        File archivo = new File(ruta);
        return archivo.getName();
    }

    
    
    private String detectarYProcesar(String linea) { //CUIT:
        String cuit = null;

        int indiceCuit = linea.indexOf("Cuit:");
        if (indiceCuit != -1) { 
            int indiceInicio = indiceCuit + 6; //
            cuit = linea.substring(indiceInicio, indiceInicio + 13); 
        }
        
      
        return cuit;
    }

    
    private String detectarYProcesar3(String linea) {// "='gris'>"
    	  	
   	 String cuit = null;
        int indiceCuit = linea.indexOf("='gris'>");
        if (indiceCuit != -1) { 
            int indiceInicio = indiceCuit + 8; //
            cuit = linea.substring(indiceInicio, indiceInicio + 13); 
        }
        
        return cuit;
   }
    
    
    
    private String detectarYProcesar2(String linea) {// "INGRESAR"
        String caracteresAntes = null;

        int indiceIngresar = linea.indexOf("\">Ingre");
        if (indiceIngresar != -1) { 
            int indiceInicio = Math.max(0, indiceIngresar - 11); 
            caracteresAntes = linea.substring(indiceInicio, indiceIngresar); 
        }
        

        return caracteresAntes;
    }
    
    private String detectarYProcesarAQU(String linea) {// "AQUI"
    	  String cuit = null;

          int indiceCuit = linea.indexOf("\">AQU");
          if (indiceCuit != -1) { 
              int indiceInicio = Math.max(0, indiceCuit - 11); 
              cuit= linea.substring(indiceInicio, indiceCuit); 
          }
          

        return cuit;
    }

    

    



    public static String formatearNumero(String numero) {
    
 
        // Verificar si el número tiene la longitud esperada
        if (numero.length() != 11) {
            throw new IllegalArgumentException("El número debe tener una longitud de 11 caracteres.");
            
        }

        // Dividir el número en partes y unirlo con guiones en las posiciones requeridas
        String parte1 = numero.substring(0, 2);
        String parte2 = numero.substring(2, 10);
        String parte3 = numero.substring(10, 11);


        return parte1 + "-" + parte2 + "-" + parte3;
    }
    
    
    
    public boolean alMenosDosIguales(String str1, String str2, String str3) {
       
    	
        if (str1.equals(str2) || str1.equals(str3)) {
            return true;
        }
        
        if (str2.equals(str3)) {
            return true;
        }
       
        return false;
    }
    

}



