
package campania_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CuentaLineas {
    
    String txtOrigen="";
    
    public CuentaLineas(){
        
        
    }
    
    
    
    
    
    public int rawss(String txtOrigen){
                Object[] lineas = null; 
                
            
        try {
            FileReader fr = new FileReader(txtOrigen);
            BufferedReader br = new BufferedReader(fr);

            lineas = br.lines().toArray();
            

            br.close();
            fr.close(); 
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
        return lineas.length;
    }
    
}
