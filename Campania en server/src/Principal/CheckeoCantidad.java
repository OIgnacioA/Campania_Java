package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CheckeoCantidad {
    String Impuesto = "";
    String line = "";
    String mailAux = "";
    String mail = "";
    String razonsocialAux = "";
    String razonsocial = "";
    String mailLinea = "";
    int escritos = 0;
    int cantidadcorte = 0;
    String Ori = "";
    BufferedReader file = null; 
    int cantidadArchivosGenerados = 1;

    public CheckeoCantidad(String Origen, String Impuesto, int cantidadCorte) {
        this.Impuesto = Impuesto;
        Ori = Origen;
        this.cantidadcorte = cantidadCorte;
    }

    public void EjecucionContar() {
        try {
            file = Files.newBufferedReader(Paths.get(Ori), StandardCharsets.ISO_8859_1);

            while ((line = file.readLine()) != null) {
            	
                LeerLinea(line, Impuesto);
                
                if (mailAux.equals("")) {
                    mailAux = mail;
                    razonsocialAux = razonsocial;
                }

                if ((!mail.equals(mailAux)) || (!razonsocial.equals(razonsocialAux))) {
   

		                if (escritos == cantidadcorte) {
	
		                    	//#########################################################
		                	
		                        escritos = 0;  	
		                        cantidadArchivosGenerados++;
		                  
		                        
		                        //#########################################################
		                    }
	                
	                mailAux = mail;
	                razonsocialAux = razonsocial;
	                escritos++;    
                
                 }


            }
            file.close();
        } catch (IOException e) {
            System.out.println("Excepcion catch6: " + e);
        }
    }

    public void LeerLinea(String line, String Impuesto) {
        switch (Impuesto) {
            case "AU":
            case "EM": {
                mail = ((line.substring(0, 255).toLowerCase()).replaceAll(" ", ""));
                razonsocial = trimEnd(line.substring(345, 405));
                break;
            }
            case "ED":
            case "BA":
            case "RU": {
                mail = ((line.substring(0, 255).toLowerCase()).replaceAll(" ", ""));
                razonsocial = trimEnd(line.substring(345, 405));
                break;
            }
            case "IC": {
                LeerLineaNuevo(line);
                break;
            }
            default:
                break;
        }
    }

    private void LeerLineaNuevo(String line) { // "Impuesto Complementario"
        mail = ((line.substring(0, 120).toLowerCase()).replaceAll(" ", ""));
        razonsocial = trimEnd(line.substring(196, 256));
    }

    public static String trimEnd(String value) {
        return value.replaceFirst("\\s+$", "");
    }

    
    
    public int getCantidadArchivos() {
        return cantidadArchivosGenerados;
    }
}
