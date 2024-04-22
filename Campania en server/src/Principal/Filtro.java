package Principal;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Filtro {

    public String Origen;
    public String Impuesto;
    public String TipoPago;
    public boolean CoDT = true; //no hay error por default ( es para poder entrar al bucle. )
    public String Dato = "xxxx";
    public int contador = 1;

    public Filtro(String Origen, String Impuesto, String TipoPago) {
        this.Origen = Origen;
        this.Impuesto = Impuesto;
        this.TipoPago = TipoPago;
    }



    public void CoDt() {
        try (BufferedReader file = Files.newBufferedReader(Paths.get(Origen), StandardCharsets.ISO_8859_1)) {
            String Line;
         
            while (((Line = file.readLine()) != null) && (CoDT == true)) {
            	

                switch (Impuesto) {
                    case "AU":
                    case "EM":
                    case "ED":
                    case "BA":
                    case "RU":
                        Dato = Line.substring(332, 333).replaceAll(" ", "");// "Es debito Credito ?"

                        check(Dato);
                        
                       
	                        if (!CoDT) {
	                        
	                            String mensaje = "No coincidencia en archivo: " + Origen + ". Linea: " + contador + " , Valor encontrado: " + Dato + ", valor esperado '0'";
	                            System.out.println(" ");
	                            System.out.println(mensaje);
	                        }
	                        
	                        break;
                        
                    case "IC":
                        Dato = Line.substring(184, 185).replaceAll(" ", "");// "Es debito Credito ?"

                        checkIC(Dato);

	                        if (!CoDT) {
	                            String mensaje = "No coincidencia en archivo: " + Origen + ". Linea: " + contador + " , Valor encontrado: " + Dato + ", valor esperado 'C', o 'D'";
	                            System.out.println(" ");
	                            System.out.println(mensaje);
	                      
	                        }
	                        
                       
	                        break;

                    default:
                        break;
                }
                contador++;
               
             }
            
            
        } catch (Exception e) {
            System.out.println("Excepcion cacht 1: " + e);
        }
    
    }

    
    
    
    public void check(String Dato) {
    	
        if (TipoPago.equals("CO")){
        	
             if (!Dato.equals("0")) { CoDT = false; }
        }
        
        if (TipoPago.equals("DT")){ if (Dato.equals("1") || Dato.equals("2") || Dato.equals("D")){ //XP
            
             }else { CoDT = false; }

         }
      }
    
    
    //-----------
    
    
    public void checkIC(String Dato) { //COMPLEMENTARIO
    	
        if (TipoPago.equals("CO")){
        	
             if (!Dato.equals("C")) { CoDT = false; }
        }
        
        if (TipoPago.equals("DT")){ if (!Dato.equals("D")){ 
        	
        	CoDT = false; }

         }
      }
    
    
    
    public boolean getCoDT() {
	
    	return CoDT; 
    	    	
    }
    
    

    
   }
