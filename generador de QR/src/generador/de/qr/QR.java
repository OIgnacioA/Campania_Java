/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generador.de.qr;

import java.util.UUID;
import javax.swing.JFileChooser;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class QR extends javax.swing.JFrame {

  
    public QR() {
        initComponents();
       setTitle("Generador de Codigo QR- Avendaño-Cruz");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblqr = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jButton1.setText("Guardar /Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel1.setText("Colocar aqui direccion a Codificar: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblqr, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(120, 120, 120)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblqr, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int size = 1000;
        String FileType = "png";
        
        String codigo =txtCode.getText().trim();
        String filePath = "";
        // ruta de la imagen 
        

        String userDir = System.getProperty("user.home");
        JFileChooser Chooser  = new JFileChooser(userDir +"/Desktop");
        
        Chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        if ( Chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)  {
        filePath = Chooser.getSelectedFile () .getAbsolutePath();
        
        
        // Generar el nombre
        
        UUID uuid= UUID.randomUUID();
        String randomName = uuid.toString();
        
        //generar el QR 
        QRCodeWriter qrcode = new QRCodeWriter();
        
        
            try {
                BitMatrix matrix = qrcode.encode(codigo, BarcodeFormat.QR_CODE, size, size);
                
                File f = new File(filePath + "/" +randomName + FileType);
                
                int matrixWidth = matrix.getWidth();
                
                BufferedImage image = new BufferedImage (matrixWidth,matrixWidth, BufferedImage.TYPE_INT_RGB);
                image.createGraphics();
                
                Graphics2D gd = (Graphics2D) image.getGraphics();
                gd.setColor(Color.white);//fondo
                gd.fillRect(0,0, size, size);
                gd.setColor(Color.black);//qr
                
                for (int b = 0; b < matrixWidth; b++) {
                
                    for (int j = 0; j < matrixWidth;j++){

                        if (matrix.get(b, j)) {
                             gd.fillRect (b,j,1,1);
                        }
                    }
                }

                
                
              // mostrar la imagen 
              
              
              ImageIO.write(image, FileType, f);
              Image MImagen = new ImageIcon(filePath + "/" +randomName + FileType).getImage();
              ImageIcon mIcono = new ImageIcon(MImagen.getScaledInstance(lblqr.getWidth(), lblqr.getHeight(), 0));
              lblqr.setIcon(mIcono);  
                
            } catch (WriterException ex) {
                
                Logger.getLogger(QR.class.getName()).log(Level.SEVERE, null, ex);
                
            } catch (IOException ex) {
                Logger.getLogger(QR.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
    }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblqr;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
