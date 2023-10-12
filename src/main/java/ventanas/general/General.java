/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas.general;

import java.awt.Image;
import javax.swing.ImageIcon;
import ventanas.emergentes.*;
import clases.*;

public final class General extends javax.swing.JFrame {
    private Persona per;

    public General() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\lado-del-camion.png");
        Image image = icon.getImage();
        this.setIconImage(image);
        this.setTitle("Fenix Global Delibery");
        this.AutoLogin();
    }
    public void AutoLogin(){
        if(per == null){
            Login lo = new Login();
            escritorio.add(lo);
            lo.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        Menu = new javax.swing.JMenuBar();
        inicio = new javax.swing.JMenu();
        Login = new javax.swing.JMenuItem();
        Register = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        Usuario = new javax.swing.JMenu();
        ajususer = new javax.swing.JMenuItem();
        Seguimiento = new javax.swing.JMenu();
        amov = new javax.swing.JMenuItem();
        Proveedores = new javax.swing.JMenu();
        Productos = new javax.swing.JMenu();
        Informe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(153, 153, 153));
        escritorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1036, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );

        getContentPane().add(escritorio, java.awt.BorderLayout.CENTER);

        Menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        inicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inicio.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\hogar.png"));
        inicio.setText("Inicio");
        inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        Login.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\usuario.png"));
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        inicio.add(Login);

        Register.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\agregar-usuario.png"));
        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        inicio.add(Register);

        Salir.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\salida.png"));
        Salir.setText("Salir");
        inicio.add(Salir);

        Menu.add(inicio);

        Usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Usuario.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\circulo-de-usuario.png"));
        Usuario.setText("Usuario");
        Usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Usuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        ajususer.setText("Ajuste de Usuario");
        ajususer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajususerActionPerformed(evt);
            }
        });
        Usuario.add(ajususer);

        Menu.add(Usuario);

        Seguimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Seguimiento.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\envio-rapido.png"));
        Seguimiento.setText("Seguimiento");
        Seguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Seguimiento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        amov.setText("Añadir Movimiento");
        amov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amovActionPerformed(evt);
            }
        });
        Seguimiento.add(amov);

        Menu.add(Seguimiento);

        Proveedores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Proveedores.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\carrito-de-compras.png"));
        Proveedores.setText("Proveedores");
        Proveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Proveedores.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Menu.add(Proveedores);

        Productos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Productos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\cajas.png"));
        Productos.setText("Productos");
        Productos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Productos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Menu.add(Productos);

        Informe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Informe.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\grafico-histograma.png"));
        Informe.setText("Informe");
        Informe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Informe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Menu.add(Informe);

        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        if(per != null){
            Login lo = new Login();
            escritorio.add(lo);
            lo.setVisible(true);
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterActionPerformed

    private void ajususerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajususerActionPerformed
        AjusteUsuario us = new AjusteUsuario();
        escritorio.add(us);
        us.setVisible(true);
    }//GEN-LAST:event_ajususerActionPerformed

    private void amovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amovActionPerformed
        Seguimiento seg = new Seguimiento();
        escritorio.add(seg);
        seg.setVisible(true);
    }//GEN-LAST:event_amovActionPerformed

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
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new General().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Informe;
    private javax.swing.JMenuItem Login;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu Productos;
    private javax.swing.JMenu Proveedores;
    private javax.swing.JMenuItem Register;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenu Seguimiento;
    private javax.swing.JMenu Usuario;
    private javax.swing.JMenuItem ajususer;
    private javax.swing.JMenuItem amov;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu inicio;
    // End of variables declaration//GEN-END:variables
}
