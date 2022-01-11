package campania_java;

import java.awt.Color;
import java.awt.List;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class frmPrincipal extends javax.swing.JFrame { 
    

    private String directorioOrigen = "";
    private String directorioDestino = "";
    private String txtOrigen = "";
    private String txtDestino = "";
    private int cantidad = 0;
    private String Dir = ""; 
    private String Path = "";
    private String ImpuestoV = "";
    private String NombreOrigen = ""; 
    private String FraccionImpuesto =  "";
    
    private String objeto = ""; 
    private String nombreImpuesto = "";
    private String impuestoLiquidar = "";
    private String medioPago = "";
    private String debitoCredito = ""; //ejemplo con contenid previo
    
    
    
    private FileNameExtensionFilter filter = new FileNameExtensionFilter ("Archivos Txt", "txt");
  
    public frmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Generar Bases para campaña por mail V1");
       
        Generar.setEnabled(false);
        Origen.setEnabled(false);
        
        Dir = "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Origen";
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Impuesto = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txturl = new javax.swing.JTextField();
        Origen = new javax.swing.JButton();
        txtArchivoOrigen = new javax.swing.JTextField();
        Generar = new javax.swing.JButton();
        barraLeidos = new javax.swing.JProgressBar();
        barraGenerados = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad1 = new javax.swing.JTextField();
        ConCabecera = new javax.swing.JCheckBox();
        ConAnual = new javax.swing.JCheckBox();
        DiferenciarMails = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        FechaOpcion = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Impuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Impuesto Automotor", "Impuesto a las Embarcaciones", "Impuesto Urbano Edificado", "Impuesto Urbano Baldío", "Impuesto Rural", "Impuesto Complementario" }));
        Impuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpuestoActionPerformed(evt);
            }
        });

        txtCantidad.setText("5");

        jLabel1.setText("Cant. Suscripciones ");

        jLabel2.setText("URL");

        Origen.setText("Origen");
        Origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrigenActionPerformed(evt);
            }
        });

        Generar.setText("Generar");
        Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarActionPerformed(evt);
            }
        });

        jLabel3.setText("Subscripciones Leidas");

        jLabel4.setText("Mail generados");

        jLabel5.setText("Contar Cada");

        txtCantidad1.setText("15000");

        ConCabecera.setText("Con Cabecera");

        ConAnual.setText("Con Anual");

        DiferenciarMails.setText("Diferenciar Mails");

        jLabel6.setText("fecha Opcion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Impuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(ConAnual)
                                .addGap(45, 45, 45)
                                .addComponent(ConCabecera)
                                .addGap(52, 52, 52)
                                .addComponent(DiferenciarMails)
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Origen)
                                        .addGap(2, 2, 2))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(FechaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtArchivoOrigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel4)
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(barraGenerados, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                            .addComponent(barraLeidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(13, 13, 13))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Generar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txturl, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConAnual)
                    .addComponent(ConCabecera)
                    .addComponent(DiferenciarMails))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(FechaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txturl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArchivoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Origen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Generar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraLeidos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barraGenerados, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrigenActionPerformed
       
        String DirOrigen ="";
        //Dir = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().toString();
        
        //Dir = "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent";
          DirOrigen = Dir + "\\" + directorioOrigen;
        
          
        File archivoSeleccionado;
        
        
        JFileChooser seleccionarArchivo = new JFileChooser();
        seleccionarArchivo.setFileFilter(filter);
        seleccionarArchivo.setCurrentDirectory(new File(DirOrigen));
        seleccionarArchivo.showOpenDialog(null);
        archivoSeleccionado = seleccionarArchivo.getSelectedFile();
        Path = archivoSeleccionado.getAbsoluteFile().toString();
        
        txtOrigen = Path; 
        
        if(txtOrigen != ""){ 
        txtArchivoOrigen.setText(txtOrigen);
        Generar.setEnabled(true);
        }

    }//GEN-LAST:event_OrigenActionPerformed

    private void GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarActionPerformed
        boolean seguir = false;
      
            try
            {
                int cantidad = Integer.parseInt(this.txtCantidad.getText());
                seguir = true;
            }
            catch (Exception e) {
                
             }

            if (seguir){
                
                ImpuestoV = Impuesto.getSelectedItem().toString();
                txtDestino = Path;
                
                MyReplace(Dir, txtDestino);
  
               //procesar();
            }
            else
            {
                txtCantidad.requestFocus();
                JOptionPane.showMessageDialog(null, " Ingrese la cantidad de suscripciones a procesar. ", " Boleta Electrónica ", JOptionPane.ERROR_MESSAGE);    
              
            }
            
            this.getContentPane().setBackground(Color.orange);
    }//GEN-LAST:event_GenerarActionPerformed

    private void ImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImpuestoActionPerformed

            FraccionImpuesto = Impuesto.getSelectedItem().toString();

            directorioOrigen = "";

            directorioDestino = "C:\\Users\\sehent\\Desktop\\CampaniaOriginal\\TXTBase-pruebas-\\Destino\\";

            //List<String> cuotas = new List<String>();



            switch (FraccionImpuesto)
            {
                case "Impuesto Automotor":
                    {
                        directorioOrigen += "Automotores\\";
                        directorioDestino += "Automotores\\";

                        System.out.println("Origen-------------> " + directorioOrigen) ;
                        System.out.println("Destino-------------> " + directorioDestino) ;    
                        
                        impuestoLiquidar = "1";
                        nombreImpuesto = "Automotor";
                        txturl.setText ("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D1%26opc%3DLIC%26Frame%3DSI%26oi%3D");


                        break;
                    }
                case "Impuesto Embarcaciones":
                    {
                        directorioOrigen += "Embarcaciones\\";
                        directorioDestino += "Embarcaciones\\";
                        nombreImpuesto = "Embarcaciones";
                        impuestoLiquidar = "3";
                        txturl.setText ("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D3%26opc%3DLIC%26Frame%3DSI%26oi%3D");
                        break;

                    }
                case "Impuesto Edificado":
                    {
                        directorioOrigen += "Edificado\\";
                        directorioDestino += "Edificado\\";
                        nombreImpuesto = "Edificado";
                        impuestoLiquidar = "0";
                        txturl.setText("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D0%26opc%3DLIC%26Frame%3DSI%26oi%3D");
                        break;
                    }
                case "Impuesto Baldio":
                    {
                        directorioOrigen += "Baldio\\";
                        directorioDestino += "Baldio\\";
                        nombreImpuesto = "Baldio";
                        impuestoLiquidar = "0";
                        txturl.setText("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D0%26opc%3DLIC%26Frame%3DSI%26oi%3D");
                        break;
                    }
                case "Impuesto Rural":
                    {
                        directorioOrigen += "Rural\\";
                        directorioDestino += "Rural\\";
                        impuestoLiquidar = "0";
                        nombreImpuesto = "Rural";
                        txturl.setText("http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D0%26opc%3DLIC%26Frame%3DSI%26oi%3D");
                        break;
                    }
                case "Impuesto Complementario":
                    {
                        directorioOrigen += "Complementario\\";
                        directorioDestino += "Complementario\\";
                        nombreImpuesto = "Complementario";
                        impuestoLiquidar = "10";
                        txturl.setText ("https://www.arba.gov.ar/aplicaciones/LiqPredet.asp?imp=10&Fame=NO&origen=WEB&op=IIC");
                        break;
                    }

                default:
                    {
                       // cuotas = new List<string>() { "0" };
                        break;
                    }       
                   
    }//GEN-LAST:event_ImpuestoActionPerformed
       
            if(FraccionImpuesto != ""){
            
            Origen.setEnabled(true);
            }
    
    }  
   
    public String MyReplace(String Val1, String Val2){
     
        String resultado = "";
        
        int diff = ( Val2.length() - Val1.length());
         
            System.out.println ("diff-----> " + diff);
            
        for (int j = 0 ; j < diff ; j++){
            Val1 += " "; 
        }
            
            
        for (int i= 11 ; i<Val2.length();i++) {
        
           if (Val2.charAt(i) != Val1.charAt(i)){
               NombreOrigen += Val2.charAt(i);
           }
        }
        
      
   
       
        resultado = NombreOrigen.substring(1);
       
        System.out.print("my Replace----------> " + resultado);
        
       return resultado; 
    }
    
    private void ArmarDatosMail() 
        {

            switch (debitoCredito) 
            {
                case "1":
                    {
                        medioPago = "Débito en Cuenta";
                        break;
                    }
                case "D":
                    {
                        medioPago = "Débito en Cuenta";                        
                        break;
                    }
                case "2":
                    {
                        medioPago = "Tarjeta de Crédito";                        
                        break;
                    }
                case "0":
                case "C":
                    {
                        medioPago = "<a href=\"" + txturl.getText() + objeto + "\">Ingresar</a>";
                        
                        /*
                        if (this.Impuesto.SelectedIndex == 5)
                        {
                            //medioPago = "<a href=\"https://sso.arba.gov.ar/Login/login?service=http%3A%2F%2Fwww4.arba.gov.ar%2FLiqPredet%2Fsso%2FInicioLiquidacionIIC.do%3FFrame%3DNO%26origen%3DWEB%26imp%3D10%26cuit%3D\">Ingresar</a>";
                            medioPago =  "<a href=\"https://www.arba.gov.ar/aplicaciones/LiqPredet.asp?imp=10&Fame=NO&origen=WEB&op=IIC\">Ingresar</a>";
                        }
                        else
                        {
                            medioPago = string.Format("<a href=\"http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D{0}%26opc%3DLIC%26Frame%3DSI%26oi%3D{1}\">Ingresar</a>", impuestoLiquidar, objeto);
                        }      
                        */
                        break;
                    }
             /*   case "C":
                    {
                        if (this.Impuesto.SelectedIndex == 5)
                        {
                            medioPago = "<a href=\"https://sso.arba.gov.ar/Login/login?service=http%3A%2F%2Fwww4.arba.gov.ar%2FLiqPredet%2Fsso%2FInicioLiquidacionIIC.do%3FFrame%3DNO%26origen%3DWEB%26imp%3D10%26cuit%3D\">Ingresar</a>";
                        }
                        else
                        {
                            medioPago = string.Format("<a href=\"http://www.arba.gov.ar/AplicacionesFrame.asp?url=Aplicaciones%2FLiquidacion%2Easp%3Fimp%3D{0}%26opc%3DLIC%26Frame%3DSI%26oinombreImpuesto%3D{1}\">Ingresar</a>", impuestoLiquidar, objeto);
                        }
                        break;
                    }*/
                default:
                    {
                        // medioPago = "ERROR";
                        // break;

                        /* Automotores entra acá por defaoult, el "txturl.text" de 
                           automotores suma "+ {0}" que acá 
                           va a tomar el valor de 'objeto' */



                        medioPago = "<a href=\"" + txturl.getText() + objeto +"\">Ingresar</a>"; 
                        break;
                    }
            }
        }
  /* 
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
 */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ConAnual;
    private javax.swing.JCheckBox ConCabecera;
    private javax.swing.JCheckBox DiferenciarMails;
    private com.toedter.calendar.JDateChooser FechaOpcion;
    private javax.swing.JButton Generar;
    private javax.swing.JComboBox<String> Impuesto;
    private javax.swing.JButton Origen;
    private javax.swing.JProgressBar barraGenerados;
    private javax.swing.JProgressBar barraLeidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtArchivoOrigen;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidad1;
    private javax.swing.JTextField txturl;
    // End of variables declaration//GEN-END:variables
}
