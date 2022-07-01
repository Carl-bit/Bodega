/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.com.mycompany.interfacebodega;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author VULCANO
 */
public class VistaPaqueteAgregar extends javax.swing.JFrame {

    /**
     * Creates new form VistaPaqueteAgregar
     */
    private ListaPaquetes paquetes;
    private DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    private Conection NuevaConexion = new Conection();

    public VistaPaqueteAgregar() throws SQLException {
        paquetes = new ListaPaquetes();
        initComponents();
        fechaField.setText(dtf3.format(LocalDateTime.now()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fechalabel = new javax.swing.JLabel();
        EncargadoLabel = new javax.swing.JLabel();
        estadolabel = new javax.swing.JLabel();
        fechaField = new javax.swing.JTextField();
        encargadoField = new javax.swing.JTextField();
        estadoBox = new javax.swing.JComboBox<>();
        agregar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        lblcodigoQR = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Paquete");
        setBackground(new java.awt.Color(153, 153, 255));
        setPreferredSize(new java.awt.Dimension(400, 400));

        fechalabel.setText("Fecha");

        EncargadoLabel.setText("ID Encargado");

        estadolabel.setText("Estado");

        fechaField.setEditable(false);

        estadoBox.setForeground(new java.awt.Color(153, 153, 255));
        estadoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recibido", "Traslado", "Salida", "Enviado" }));
        estadoBox.setSelectedIndex(-1);
        estadoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoBoxActionPerformed(evt);
            }
        });

        agregar.setForeground(java.awt.Color.blue);
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        limpiar.setForeground(java.awt.Color.magenta);
        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        lblcodigoQR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("QR ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estadoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(estadolabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(EncargadoLabel))
                                .addComponent(fechaField)
                                .addComponent(encargadoField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fechalabel))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(lblcodigoQR, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(88, 88, 88))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(limpiar)
                        .addGap(195, 195, 195)
                        .addComponent(agregar)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechalabel)
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fechaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EncargadoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(encargadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(estadolabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(estadoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblcodigoQR, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(limpiar))
                .addGap(67, 67, 67))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estadoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoBoxActionPerformed

    //--------------Limpiar Campos-----------------------------------
    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        encargadoField.setText(null);   //
        estadoBox.setSelectedIndex(-1);
        fechaField.setText(dtf3.format(LocalDateTime.now()));
    }//GEN-LAST:event_limpiarActionPerformed

    //---------------Agregar Paquete----------------------
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed

        String encargado, estado, fecha, hora, id;
        Date date = new Date();
        id = Math.random() * 1000 + "";
        encargado = encargadoField.getText();
        estado = estadoBox.getSelectedItem().toString();
        fecha = dtf3.format(LocalDateTime.now());
        hora = dateFormat.format(date);
        Paquete nuevoPaquete = new Paquete(id, fecha, hora, encargado, estado);

        try {
            GenerarCodigoQR(paquetes.agregarPaquete(nuevoPaquete)); // Se agrega el paquete a la base de datos y devuelve el numero id para generar el código QR
        } catch (SQLException ex) {
            Logger.getLogger(VistaPaqueteAgregar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaPaqueteAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }

        encargadoField.setText(null);
        estadoBox.setSelectedIndex(-1);

    }//GEN-LAST:event_agregarActionPerformed

    public void GenerarCodigoQR(int ID) throws IOException, SQLException {
        String newID = String.valueOf(ID);
        ByteArrayOutputStream out = QRCode.from(newID).to(ImageType.PNG).stream();
        ImageIcon imageIcon = new ImageIcon(out.toByteArray());
        this.lblcodigoQR.setIcon(imageIcon);
        GuardarQR_BD(imageIcon, newID);
    }

    public void GuardarQR_BD(ImageIcon QR, String NewID) throws IOException, SQLException {
        Conection con = new Conection();
        PreparedStatement cs = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imageIconToBufferedImage(QR), "jpg", baos);

        try {
            String consulta = ("update paquetes set qr_paquete=? where id_paquete =" + NewID + ";"); // el codigo QR se guarda en forma de bytes en la base de datos
            cs = (PreparedStatement) con.connectToDB().prepareStatement(consulta);
            cs.setBinaryStream(1, new ByteArrayInputStream(baos.toByteArray()));
            cs.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se guardó correctamente los datos" + ex.toString());

        }
        con.cerrarConexion();
    }

    public static BufferedImage imageIconToBufferedImage(ImageIcon icon) {
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.createGraphics();
        icon.paintIcon(null, graphics, 0, 0);
        graphics.dispose();//from   w  ww.j a  va  2  s.  co m
        return bufferedImage;
    }

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
            java.util.logging.Logger.getLogger(VistaPaqueteAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPaqueteAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPaqueteAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPaqueteAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaPaqueteAgregar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaPaqueteAgregar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EncargadoLabel;
    private javax.swing.JButton agregar;
    private javax.swing.JTextField encargadoField;
    private javax.swing.JComboBox<String> estadoBox;
    private javax.swing.JLabel estadolabel;
    private javax.swing.JTextField fechaField;
    private javax.swing.JLabel fechalabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblcodigoQR;
    private javax.swing.JButton limpiar;
    // End of variables declaration//GEN-END:variables
}