package campania_java;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class frmPrincipal extends javax.swing.JFrame {
    
    private String txtOrigen = "";
    private String txtDestino = "";
    private int cantidad = 0;
    private String Dir = ""; 
    private String Path = "";
    private String ImpuestoV = "";
    private String NombreOrigen = ""; 
    
    private FileNameExtensionFilter filter = new FileNameExtensionFilter ("Archivos Txt", "txt");
  
    public frmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Generar Bases para campaña por mail V2");
        
        Generar.setEnabled(false);
        
        
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
       
        //Dir = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().toString();
        Dir = "C:\\Users\\oscar.avendano\\Desktop\\DB Campaña\\Archivos de Prueba\\sehent";
        File archivoSeleccionado;
        
        
        JFileChooser seleccionarArchivo = new JFileChooser();
        seleccionarArchivo.setFileFilter(filter);
        seleccionarArchivo.setCurrentDirectory(new File(Dir + "\\"));
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
    }//GEN-LAST:event_GenerarActionPerformed

    
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
        
       System.out.print("Dir-------------> " + Dir) ;
       System.out.println("");
       System.out.print("Original--------> " + txtDestino);
       System.out.println("");
      
       
        resultado = NombreOrigen.substring(1);
       
        System.out.print("Final----------> " + resultado);
        
       return resultado; 
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
