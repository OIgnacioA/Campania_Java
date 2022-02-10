/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campania_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CuentaLineas {
    
    String txtOrigen="";
    
    public CuentaLineas(String txtOrigen){
        this.txtOrigen=txtOrigen;
        
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
        
        System.out.println("Este archivo tiene " + lineas.length + " lineas");
        return lineas.length;
    }
    
}
