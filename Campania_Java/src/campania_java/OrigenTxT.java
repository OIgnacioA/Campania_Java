package campania_java;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OrigenTxT extends javax.swing.JFrame {

    private String directorioOrigen = "";
    
    private String Dir =  "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen\\Baldio\\archivos pruebas";;
    
    //Home  "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Origen";
    //ARBA (mi pc)  : "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent";                  
    // ARBA (Compartida -RED) \\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen\\Baldio\\archivos pruebas
    
    
    private String directorioDestino = "\\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen\\Baldio\\archivos pruebas\\Destino\\";      
        
        
    //Home  "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Destino\\";
    //ARBA  (mi pc): "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent\\Destino\\";                  
    //ARBA (Compartida -RED) : \\\\arba.gov.ar\\DE\\GGTI\\Gerencia de Produccion\\Mantenimiento\\Boleta Electronica\\Origen\\Baldio\\archivos pruebas
    
    
    
    private String DirOrigen = "";
    private String txtOrigen = "";
    private String nombreImpuesto = "";
    private String impuestoLiquidar = "";
    private String FraccionImpuesto =  "";
    private String txturl = "";
    private long   size = 0;
    private int tamanio = 0;
   
    
    
    private FileNameExtensionFilter filter = new FileNameExtensionFilter ("Archivos Txt", "txt");
    
    public OrigenTxT() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        Ejecutar_.setEnabled(false);
        setTitle("Seleccion de Archivo");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ejecutar_ = new javax.swing.JButton();
        Impuesto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Origen_1 = new javax.swing.JButton();
        TxTSelected = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Ejecutar_.setText("Ejecutar");
        Ejecutar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ejecutar_ActionPerformed(evt);
            }
        });

        Impuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Impuesto Automotor", "Impuesto a las Embarcaciones", "Impuesto Urbano Edificado", "Impuesto Urbano Baldío", "Impuesto Rural", "Impuesto Complementario" }));
        Impuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpuestoActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione Impuesto a trabajar");

        Origen_1.setText("Buscar");
        Origen_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Origen_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxTSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(Ejecutar_, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(139, 139, 139)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(167, 167, 167)
                            .addComponent(Origen_1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(Impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Origen_1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(TxTSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Ejecutar_, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImpuestoActionPerformed
      
        directorioOrigen = ""; 
        FraccionImpuesto = Impuesto.getSelectedItem().toString();


        if(FraccionImpuesto == null){
          FraccionImpuesto =".";
        }

        //List<String> cuotas = new List<String>();


        switch (FraccionImpuesto)
        {
            case "Impuesto Automotor":
                {
                    directorioOrigen += "Automotores\\";
                    directorioDestino += "Automotores\\";



                    impuestoLiquidar = "1";
                    nombreImpuesto = "Automotor";
                    txturl = "http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D1%26opc%3DLIC%26Frame%3DSI%26oi%3D";


                    break;
                }
            case "Impuesto a las Embarcaciones":
                {
                    directorioOrigen += "Embarcaciones\\";
                    directorioDestino += "Embarcaciones\\";
                    nombreImpuesto = "Embarcaciones";
                    impuestoLiquidar = "3";
                    txturl = "http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D3%26opc%3DLIC%26Frame%3DSI%26oi%3D";
                    break;

                }
            case "Impuesto Urbano Edificado":
                {
                    directorioOrigen += "Edificado\\";
                    directorioDestino += "Edificado\\";
                    nombreImpuesto = "Edificado";
                    impuestoLiquidar = "0";
                    txturl = "http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D0%26opc%3DLIC%26Frame%3DSI%26oi%3D";
                    break;
                }
            case "Impuesto Urbano Baldío":
                {
                    directorioOrigen += "Baldio\\";
                    directorioDestino += "Baldio\\";
                    nombreImpuesto = "Baldio";
                    impuestoLiquidar = "0";
                    txturl= "http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D0%26opc%3DLIC%26Frame%3DSI%26oi%3D";
                    break;
                }
            case "Impuesto Rural":
                {
                    directorioOrigen += "Rural\\";
                    directorioDestino += "Rural\\";
                    impuestoLiquidar = "0";
                    nombreImpuesto = "Rural";
                    txturl= "http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D0%26opc%3DLIC%26Frame%3DSI%26oi%3D";
                    break;
                }
            case "Impuesto Complementario":
                {
                    directorioOrigen += "Complementario\\";
                    directorioDestino += "Complementario\\";
                    nombreImpuesto = "Complementario";
                    impuestoLiquidar = "10";
                    txturl = "https://www.arba.gov.ar/aplicaciones/LiqPredet.asp?imp=10&Fame=NO&origen=WEB&op=IIC";
                    break;
                }

                default:
                {
                        // cuotas = new List<string>() { "0" };
                       break;
                 }       

    }                                        
 
   
    }//GEN-LAST:event_ImpuestoActionPerformed

    private void Ejecutar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ejecutar_ActionPerformed
       
    if (size > 500000000){ 
        String mensaje_0 = ("El archivo supera POR MUCHO el peso mínimo; Por favor AGUARDE: LA OPERACION TARDARÁ UNOS segundos EN INICIAR");
        JOptionPane.showMessageDialog(null, mensaje_0);}
        
  
        CuentaLineas lineass= new CuentaLineas();
        tamanio = lineass.rawss(txtOrigen);
                  
        new frmPrincipal(tamanio, txturl).setVisible(true);

    }//GEN-LAST:event_Ejecutar_ActionPerformed

    private void Origen_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Origen_1ActionPerformed
         //Dir = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().toString();

          DirOrigen ="";
          DirOrigen = Dir + "\\" + directorioOrigen;//directorigen tiene el valor que viene de impuesto "automotor//"
                
        File archivoSeleccionado;
            
        JFileChooser seleccionarArchivo = new JFileChooser();
        seleccionarArchivo.setFileFilter(filter);
        seleccionarArchivo.setCurrentDirectory(new File(DirOrigen));
        seleccionarArchivo.showOpenDialog(null);
        archivoSeleccionado = seleccionarArchivo.getSelectedFile();
        
        try {
            txtOrigen = archivoSeleccionado.getAbsoluteFile().toString();
            
            TxTSelected.setText(txtOrigen) ;
             
         }catch(Exception e) {System.out.println("origen vacio");}
        
        File myFile = new File(txtOrigen); 
        size = myFile.length();
       
         
        if(TxTSelected.getText() != ""){ 
          Ejecutar_.setEnabled(true);
        }
             
    }//GEN-LAST:event_Origen_1ActionPerformed

    public String GettextoOrigen(){return txtOrigen;}
    
    public void SetTextOrigen(String val){directorioOrigen = val; }
    
    public void SetTextdestino(String val2){directorioDestino  = val2;}
    
    public long GetSize(){ return size; }
    
    
    
    
    
    /*
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrigenTxT().setVisible(true);
            }
        });
    }
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ejecutar_;
    private javax.swing.JComboBox<String> Impuesto;
    private javax.swing.JButton Origen_1;
    private javax.swing.JTextField TxTSelected;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
