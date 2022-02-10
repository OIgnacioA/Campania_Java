
package campania_java;

import java.awt.Color;


public class Campania_Java {
     
      
      
    public static void main(String[] args) {
       
          String txtOrigen = "C:\\Users\\nicol.cruz\\Desktop\\Nicol\\C#\\OrigenN\\BaldioN\\SISTE.INMEBOLE.C122.ED.CO.txt";
          
         
          CuentaLineas lineass= new CuentaLineas(txtOrigen);
          final int raws=lineass.rawss(txtOrigen);
        
        
        
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal(raws).setVisible(true);
               
            }
        });
    
    
    }
    
}
