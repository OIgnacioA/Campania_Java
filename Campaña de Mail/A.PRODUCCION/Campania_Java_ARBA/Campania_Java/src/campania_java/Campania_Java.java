
package campania_java;

import java.awt.Color;


public class Campania_Java {

    public static void main(String[] args) {
       
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
               
            }
        });
    
    
    }
    
}
