package ventanas.general;

import java.awt.Image;
import javax.swing.ImageIcon;
import ventanas.emergentes.*;
import Modelo.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public final class General extends javax.swing.JFrame {

    private Sistema sis;
    private Sesion ses;

    public General() throws Exception {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\imagenes\\minicon\\lado-del-camion.png");
        Image image = icon.getImage();
        this.setIconImage(image);
        this.setTitle("Fenix Global Delibery");
        this.sis = Sistema.iniciar();
        this.AutoLogin();
    }

    public void addcentrarpanel(Component com) {
        escritorio.add(com);
        Dimension escSize = escritorio.getSize();
        Dimension comSize = com.getSize();
        com.setLocation((escSize.width - comSize.width) / 2, (escSize.height - comSize.height) / 2);
        com.setVisible(true);
    }

    public void AutoLogin() {
        if (sis.getSesion() == null) {
            Login lo = new Login(escritorio, sis);
            addcentrarpanel(lo);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\imagenes\\fondos\\ciudad futurista.jpeg");
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        Menu = new javax.swing.JMenuBar();
        inicio = new javax.swing.JMenu();
        Login = new javax.swing.JMenuItem();
        Register = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        Usuario = new javax.swing.JMenu();
        ajususer = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Seguimiento = new javax.swing.JMenu();
        amov = new javax.swing.JMenuItem();
        Proveedores = new javax.swing.JMenu();
        AgrProveedor = new javax.swing.JMenuItem();
        ModProveedor = new javax.swing.JMenuItem();
        Productos = new javax.swing.JMenu();
        AgrProducto = new javax.swing.JMenuItem();
        ModProducto = new javax.swing.JMenuItem();
        Informe = new javax.swing.JMenu();
        newinfo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Envio = new javax.swing.JMenu();
        CrearEnvio = new javax.swing.JMenuItem();
        gestionarenvio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
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

        jMenuItem2.setText("Ajustes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Usuario.add(jMenuItem2);

        Menu.add(Usuario);

        Seguimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Seguimiento.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\envio-rapido.png"));
        Seguimiento.setText("Seguimiento");
        Seguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Seguimiento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        amov.setText("Movimientos");
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

        AgrProveedor.setText("Añadir Proveedor");
        AgrProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgrProveedorActionPerformed(evt);
            }
        });
        Proveedores.add(AgrProveedor);

        ModProveedor.setText("Modificar Proveedor");
        Proveedores.add(ModProveedor);

        Menu.add(Proveedores);

        Productos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Productos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\cajas.png"));
        Productos.setText("Productos");
        Productos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Productos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        AgrProducto.setText("Agregar Producto");
        Productos.add(AgrProducto);

        ModProducto.setText("Modificar Producto");
        ModProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModProductoActionPerformed(evt);
            }
        });
        Productos.add(ModProducto);

        Menu.add(Productos);

        Informe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Informe.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\grafico-histograma.png"));
        Informe.setText("Informe");
        Informe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Informe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        newinfo.setText("Nuevo Informe");
        Informe.add(newinfo);

        jMenuItem1.setText("Buscar Informe");
        Informe.add(jMenuItem1);

        Menu.add(Informe);

        Envio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Envio.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\caja-abierta.png"));
        Envio.setText("Envio");
        Envio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Envio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        CrearEnvio.setText("Crear Envio");
        CrearEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearEnvioActionPerformed(evt);
            }
        });
        Envio.add(CrearEnvio);

        gestionarenvio.setText("Gestionar Envio");
        gestionarenvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarenvioActionPerformed(evt);
            }
        });
        Envio.add(gestionarenvio);

        Menu.add(Envio);

        setJMenuBar(Menu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        if (sis.getSesion() == null) {
            Login lo = new Login(escritorio, sis);
            escritorio.add(lo);
            lo.setVisible(true);
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        if (sis.getSesion() == null) {
            Register res = new Register(sis);
            addcentrarpanel(res);
        }
    }//GEN-LAST:event_RegisterActionPerformed

    private void ajususerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajususerActionPerformed
        Usuario us = null;
        try {
            us = sis.obtenerSesion();
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        int per = sis.obtenerCodigoUsuario(us);
        if (per != 4 && per != 1) {
            AjusteUsuario aus = new AjusteUsuario(sis);
            escritorio.add(aus);
            aus.setVisible(true);
        } else {
            ajususer.setVisible(false);
        }
    }//GEN-LAST:event_ajususerActionPerformed

    private void amovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amovActionPerformed
        Usuario us = null;
        try {
            us = sis.obtenerSesion();
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        int per = sis.obtenerCodigoUsuario(us);
        if (per != 4) {
            Seguimiento seg = new Seguimiento(sis);
            escritorio.add(seg);
            seg.setVisible(true);
        } else {
            amov.setVisible(false);
        }
    }//GEN-LAST:event_amovActionPerformed

    private void CrearEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearEnvioActionPerformed
        Usuario us = null;
        try {
            us = sis.obtenerSesion();
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        int per = sis.obtenerCodigoUsuario(us);
        System.out.println(per);
        if (per != 4) {
            Encli ec = new Encli();
            escritorio.add(ec);
            ec.setVisible(true);
        } else {
            CrearEnvio.setVisible(false);
        }
    }//GEN-LAST:event_CrearEnvioActionPerformed

    private void gestionarenvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarenvioActionPerformed
        Usuario us = null;
        try {
            us = sis.obtenerSesion();
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        int per = sis.obtenerCodigoUsuario(us);
        if (per != 4) {
            Envio en = new Envio();
            escritorio.add(en);
            en.setVisible(true);
        } else {
            gestionarenvio.setVisible(false);
        }
    }//GEN-LAST:event_gestionarenvioActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void ModProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModProductoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Conuser user = null;
        try {
            user = new Conuser(sis);
            escritorio.add(user);
            user.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void AgrProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgrProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgrProveedorActionPerformed

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
            try {
                new General().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgrProducto;
    private javax.swing.JMenuItem AgrProveedor;
    private javax.swing.JMenuItem CrearEnvio;
    private javax.swing.JMenu Envio;
    private javax.swing.JMenu Informe;
    private javax.swing.JMenuItem Login;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem ModProducto;
    private javax.swing.JMenuItem ModProveedor;
    private javax.swing.JMenu Productos;
    private javax.swing.JMenu Proveedores;
    private javax.swing.JMenuItem Register;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenu Seguimiento;
    private javax.swing.JMenu Usuario;
    private javax.swing.JMenuItem ajususer;
    private javax.swing.JMenuItem amov;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem gestionarenvio;
    private javax.swing.JMenu inicio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem newinfo;
    // End of variables declaration//GEN-END:variables
}
