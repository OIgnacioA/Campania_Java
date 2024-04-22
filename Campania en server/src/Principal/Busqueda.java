package Principal;
import java.io.File;

public class Busqueda {

    private String archivoOrigen;

    public static void main(String[] args) {

    }

    public String procesarArchivos(String carpetaPath, String Tipo) {
    	
    	//System.out.println( "----->" + carpetaPath);
    	//carpetaPath = "/home/operemi/Oscar_A/Impuestos/Origen/RU";
    	
        File carpeta = new File(carpetaPath);

        File[] archivos = carpeta.listFiles();  // Obtener la lista de archivos en la carpeta
        
    
        if (archivos != null) {
 	
            for (File archivo : archivos) {
            	
            	
            	
                if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                
                	String nombreArchivo = archivo.getName();  //NOMBRE DEL ARCHIVO
              
                    if (nombreArchivo.contains(Tipo)) {// Verificar si contiene "co" o "dt"
                        archivoOrigen = nombreArchivo;
                        return archivoOrigen;
                    }
                }
            }
        }
  
        return archivoOrigen;
    }


}