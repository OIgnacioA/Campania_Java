
package campania_java;

public class BarraDesarrollo implements Runnable{
    
    frmPrincipal fmr = new frmPrincipal();
    
    public BarraDesarrollo(int Leidos){
          this.Leidos = Leidos;
    }
    
    
    
    public void run(){
        try {
            //fmr.CargarBarra(Leidos);
            
            System.out.println("***********************************************************************************************");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
    private int Leidos;
}
