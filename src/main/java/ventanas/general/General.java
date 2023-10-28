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
import javax.swing.Action;
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
        mostrarmenu();
    }

    public void addcentrarpanel(Component com) {
        escritorio.add(com);
        Dimension escSize = escritorio.getSize();
        Dimension comSize = com.getSize();
        com.setLocation((escSize.width - comSize.width) / 2, (escSize.height - comSize.height) / 2);
        com.setVisible(true);
    }

    public void mostrarmenu() {
        if (sis.getSesion() == null) {
            Usuario.setVisible(false);
            Seguimiento.setVisible(false);
            Proveedores.setVisible(false);
            Productos.setVisible(false);
            Informe.setVisible(false);
            Envio.setVisible(false);
            Usuario1.setVisible(false);
            Seguimiento1.setVisible(false);
            Proveedores1.setVisible(false);
            Productos1.setVisible(false);
            Informe1.setVisible(false);
            Envio1.setVisible(false);
        } else {
            if (sis.obtenerCodigoUsuario(sis.obtenerSesion()) == 1) {
                Usuario.setVisible(true);
                Seguimiento.setVisible(true);
                Envio.setVisible(true);
                Usuario1.setVisible(true);
                Seguimiento1.setVisible(true);
                Envio1.setVisible(true);
                ajususer.setVisible(false);
            } else {
                Usuario.setVisible(true);
                Seguimiento.setVisible(true);
                Proveedores.setVisible(true);
                Productos.setVisible(true);
                Informe.setVisible(true);
                Envio.setVisible(true);
                Usuario1.setVisible(true);
                Seguimiento1.setVisible(true);
                Proveedores1.setVisible(true);
                Productos1.setVisible(true);
                Informe1.setVisible(true);
                Envio1.setVisible(true);
            }
        }
    }

    public void AutoLogin() {
        if (sis.getSesion() == null) {
            Login lo = new Login(escritorio, sis, this);
            addcentrarpanel(lo);
        }
        mostrarmenu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        Usuario1 = new javax.swing.JMenu();
        ajususer1 = new javax.swing.JMenuItem();
        ajuste1 = new javax.swing.JMenuItem();
        contacto1 = new javax.swing.JMenuItem();
        Proveedores1 = new javax.swing.JMenu();
        AgrProveedor1 = new javax.swing.JMenuItem();
        ModProveedor1 = new javax.swing.JMenuItem();
        Seguimiento1 = new javax.swing.JMenu();
        amov1 = new javax.swing.JMenuItem();
        infoenvio1 = new javax.swing.JMenuItem();
        Productos1 = new javax.swing.JMenu();
        AgrProducto1 = new javax.swing.JMenuItem();
        ModProducto1 = new javax.swing.JMenuItem();
        Informe1 = new javax.swing.JMenu();
        newinfo1 = new javax.swing.JMenuItem();
        BusInfo = new javax.swing.JMenuItem();
        Envio1 = new javax.swing.JMenu();
        CrearEnvio1 = new javax.swing.JMenuItem();
        gestionarenvio1 = new javax.swing.JMenuItem();
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
        ajustes = new javax.swing.JMenuItem();
        contacto = new javax.swing.JMenuItem();
        Seguimiento = new javax.swing.JMenu();
        amov = new javax.swing.JMenuItem();
        infoenvio = new javax.swing.JMenuItem();
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

        Usuario1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Usuario1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\circulo-de-usuario.png"));
        Usuario1.setText("Usuario");
        Usuario1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Usuario1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        ajususer1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ajususer1.setText("Ajuste de Usuario");
        ajususer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajususer1ActionPerformed(evt);
            }
        });
        Usuario1.add(ajususer1);

        ajuste1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ajuste1.setText("Ajustes");
        ajuste1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste1ActionPerformed(evt);
            }
        });
        Usuario1.add(ajuste1);

        contacto1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        contacto1.setText("Contacto");
        contacto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contacto1ActionPerformed(evt);
            }
        });
        Usuario1.add(contacto1);

        popMenu.add(Usuario1);

        Proveedores1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Proveedores1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\carrito-de-compras.png"));
        Proveedores1.setText("Proveedores");
        Proveedores1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Proveedores1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        AgrProveedor1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        AgrProveedor1.setText("Añadir Proveedor");
        AgrProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgrProveedor1ActionPerformed(evt);
            }
        });
        Proveedores1.add(AgrProveedor1);

        ModProveedor1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ModProveedor1.setText("Modificar Proveedor");
        Proveedores1.add(ModProveedor1);

        popMenu.add(Proveedores1);

        Seguimiento1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Seguimiento1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\envio-rapido.png"));
        Seguimiento1.setText("Seguimiento");
        Seguimiento1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Seguimiento1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        amov1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        amov1.setText("Movimientos");
        amov1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amov1ActionPerformed(evt);
            }
        });
        Seguimiento1.add(amov1);

        infoenvio1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        infoenvio1.setText("Info Envio");
        Seguimiento1.add(infoenvio1);

        popMenu.add(Seguimiento1);

        Productos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Productos1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\cajas.png"));
        Productos1.setText("Productos");
        Productos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Productos1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        AgrProducto1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        AgrProducto1.setText("Agregar Producto");
        Productos1.add(AgrProducto1);

        ModProducto1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ModProducto1.setText("Modificar Producto");
        ModProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModProducto1ActionPerformed(evt);
            }
        });
        Productos1.add(ModProducto1);

        popMenu.add(Productos1);

        Informe1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Informe1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\grafico-histograma.png"));
        Informe1.setText("Informe");
        Informe1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Informe1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        newinfo1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        newinfo1.setText("Nuevo Informe");
        Informe1.add(newinfo1);

        BusInfo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        BusInfo.setText("Buscar Informe");
        Informe1.add(BusInfo);

        popMenu.add(Informe1);

        Envio1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Envio1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\caja-abierta.png"));
        Envio1.setText("Envio");
        Envio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Envio1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        CrearEnvio1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        CrearEnvio1.setText("Crear Envio");
        CrearEnvio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearEnvio1ActionPerformed(evt);
            }
        });
        Envio1.add(CrearEnvio1);

        gestionarenvio1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        gestionarenvio1.setText("Gestionar Envio");
        gestionarenvio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarenvio1ActionPerformed(evt);
            }
        });
        Envio1.add(gestionarenvio1);

        popMenu.add(Envio1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pantalla de Inicio");

        escritorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        escritorio.setComponentPopupMenu(popMenu);

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

        Login.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Login.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\usuario.png"));
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        inicio.add(Login);

        Register.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Register.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\agregar-usuario.png"));
        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        inicio.add(Register);

        Salir.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
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

        ajususer.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ajususer.setText("Ajuste de Usuario");
        ajususer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajususerActionPerformed(evt);
            }
        });
        Usuario.add(ajususer);

        ajustes.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ajustes.setText("Ajustes");
        ajustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustesActionPerformed(evt);
            }
        });
        Usuario.add(ajustes);

        contacto.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        contacto.setText("Contacto");
        contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactoActionPerformed(evt);
            }
        });
        Usuario.add(contacto);

        Menu.add(Usuario);

        Seguimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Seguimiento.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\envio-rapido.png"));
        Seguimiento.setText("Seguimiento");
        Seguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Seguimiento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        amov.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        amov.setText("Movimientos");
        amov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amovActionPerformed(evt);
            }
        });
        Seguimiento.add(amov);

        infoenvio.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        infoenvio.setText("Info Envio");
        Seguimiento.add(infoenvio);

        Menu.add(Seguimiento);

        Proveedores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Proveedores.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\carrito-de-compras.png"));
        Proveedores.setText("Proveedores");
        Proveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Proveedores.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        AgrProveedor.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        AgrProveedor.setText("Añadir Proveedor");
        AgrProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgrProveedorActionPerformed(evt);
            }
        });
        Proveedores.add(AgrProveedor);

        ModProveedor.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ModProveedor.setText("Modificar Proveedor");
        Proveedores.add(ModProveedor);

        Menu.add(Proveedores);

        Productos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Productos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\cajas.png"));
        Productos.setText("Productos");
        Productos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Productos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        AgrProducto.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        AgrProducto.setText("Agregar Producto");
        Productos.add(AgrProducto);

        ModProducto.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
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

        newinfo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        newinfo.setText("Nuevo Informe");
        Informe.add(newinfo);

        jMenuItem1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jMenuItem1.setText("Buscar Informe");
        Informe.add(jMenuItem1);

        Menu.add(Informe);

        Envio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Envio.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\imagenes\\minicon\\caja-abierta.png"));
        Envio.setText("Envio");
        Envio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Envio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        CrearEnvio.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        CrearEnvio.setText("Crear Envio");
        CrearEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearEnvioActionPerformed(evt);
            }
        });
        Envio.add(CrearEnvio);

        gestionarenvio.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
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
            Login lo = new Login(escritorio, sis, this);
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
        AjusteUsuario aus = new AjusteUsuario(sis);
        escritorio.add(aus);
        aus.setVisible(true);
    }//GEN-LAST:event_ajususerActionPerformed

    private void amovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amovActionPerformed
        Seguimiento seg = new Seguimiento(sis);
        escritorio.add(seg);
        seg.setVisible(true);
    }//GEN-LAST:event_amovActionPerformed

    private void CrearEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearEnvioActionPerformed
        Encli ec = new Encli();
        escritorio.add(ec);
        ec.setVisible(true);
    }//GEN-LAST:event_CrearEnvioActionPerformed

    private void gestionarenvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarenvioActionPerformed
        Envio en = new Envio();
        escritorio.add(en);
        en.setVisible(true);
    }//GEN-LAST:event_gestionarenvioActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void ModProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModProductoActionPerformed

    private void ajustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustesActionPerformed
        Conuser user = null;
        try {
            user = new Conuser(sis);
            escritorio.add(user);
            user.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ajustesActionPerformed

    private void AgrProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgrProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgrProveedorActionPerformed

    private void ajususer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajususer1ActionPerformed
        ajususerActionPerformed(evt);
    }//GEN-LAST:event_ajususer1ActionPerformed

    private void ajuste1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste1ActionPerformed
        ajustesActionPerformed(evt);
    }//GEN-LAST:event_ajuste1ActionPerformed

    private void AgrProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgrProveedor1ActionPerformed
        AgrProveedorActionPerformed(evt);
    }//GEN-LAST:event_AgrProveedor1ActionPerformed

    private void amov1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amov1ActionPerformed
        amovActionPerformed(evt);
    }//GEN-LAST:event_amov1ActionPerformed

    private void ModProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModProducto1ActionPerformed
        ModProductoActionPerformed(evt);
    }//GEN-LAST:event_ModProducto1ActionPerformed

    private void CrearEnvio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearEnvio1ActionPerformed
        CrearEnvioActionPerformed(evt);
    }//GEN-LAST:event_CrearEnvio1ActionPerformed

    private void gestionarenvio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarenvio1ActionPerformed
        gestionarenvioActionPerformed(evt);
    }//GEN-LAST:event_gestionarenvio1ActionPerformed

    private void contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactoActionPerformed
        mensaje men = new mensaje(sis);
        escritorio.add(men);
        men.setVisible(true);
    }//GEN-LAST:event_contactoActionPerformed

    private void contacto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contacto1ActionPerformed
        contactoActionPerformed(evt);
    }//GEN-LAST:event_contacto1ActionPerformed

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
    private javax.swing.JMenuItem AgrProducto1;
    private javax.swing.JMenuItem AgrProveedor;
    private javax.swing.JMenuItem AgrProveedor1;
    private javax.swing.JMenuItem BusInfo;
    private javax.swing.JMenuItem CrearEnvio;
    private javax.swing.JMenuItem CrearEnvio1;
    private javax.swing.JMenu Envio;
    private javax.swing.JMenu Envio1;
    private javax.swing.JMenu Informe;
    private javax.swing.JMenu Informe1;
    private javax.swing.JMenuItem Login;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem ModProducto;
    private javax.swing.JMenuItem ModProducto1;
    private javax.swing.JMenuItem ModProveedor;
    private javax.swing.JMenuItem ModProveedor1;
    private javax.swing.JMenu Productos;
    private javax.swing.JMenu Productos1;
    private javax.swing.JMenu Proveedores;
    private javax.swing.JMenu Proveedores1;
    private javax.swing.JMenuItem Register;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenu Seguimiento;
    private javax.swing.JMenu Seguimiento1;
    private javax.swing.JMenu Usuario;
    private javax.swing.JMenu Usuario1;
    private javax.swing.JMenuItem ajuste1;
    private javax.swing.JMenuItem ajustes;
    private javax.swing.JMenuItem ajususer;
    private javax.swing.JMenuItem ajususer1;
    private javax.swing.JMenuItem amov;
    private javax.swing.JMenuItem amov1;
    private javax.swing.JMenuItem contacto;
    private javax.swing.JMenuItem contacto1;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem gestionarenvio;
    private javax.swing.JMenuItem gestionarenvio1;
    private javax.swing.JMenuItem infoenvio;
    private javax.swing.JMenuItem infoenvio1;
    private javax.swing.JMenu inicio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem newinfo;
    private javax.swing.JMenuItem newinfo1;
    private javax.swing.JPopupMenu popMenu;
    // End of variables declaration//GEN-END:variables
}
