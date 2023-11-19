/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ventanas.emergentes;

import Modelo.*;
import com.toedter.calendar.JCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class Encli extends javax.swing.JInternalFrame {

    private Usuario us;
    private Sistema sis;
    private Pedido pe;
    private List<RenglonPedido> rp = new ArrayList<>();
    private JDesktopPane es;
    private List<TipoProducto> tps ;

    /**
     * Creates new form Encli
     *
     * @param s
     * @param e
     */
    public Encli(Sistema s, JDesktopPane e) {
        initComponents();
        Icon icon = new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\imagenes\\minicon\\caja-abierta.png");
        setFrameIcon(icon);
        this.sis = s;
        this.es = e;
        setCategoria();
    }

    private RenglonPedido modproducto(int id) {
        RenglonPedido re = null;
        for (RenglonPedido rpt : this.rp) {
            if (rpt.getId() == id) {
                setProducto(rpt);
                re = rpt;
            }
        }
        return re;
    }

    private void setProducto(RenglonPedido rp) {
        IDs.setText(String.valueOf(rp.getId()));
        Cantidad.setText(String.valueOf(rp.getCantidad()));
        Nombre.setText(rp.getProducto().getNombre());
        Categorias.setSelectedItem(rp.getProducto().getTipoProducto().getNombre());
    }

    private void setCategoria() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        Usuario us = sis.obtenerSesion();
        if (us instanceof Administrativo admin) {
            this.tps = admin.listarTipoProducto();
            for (TipoProducto t : tps) {
                model.addElement(t.getNombre());
            }
            Categorias.setModel(model);
        }
    }

    private void setModelLista(RenglonPedido r) {
        DefaultTableModel model = (DefaultTableModel) ListaProductos.getModel();
        Vector<Object> row = new Vector<>();
        row.addElement(rp.size());
        row.addElement(r.getProducto().getNombre());
        row.addElement(r.getCantidad());
        row.addElement(r.getProducto().getTipoProducto().getNombre());
        model.addRow(row);
        model.fireTableDataChanged();
    }

    private Ruta optenerruta() {
// Formateador de fechas 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

// Componentes del dialogo
        JTextField origenField = new JTextField(20);
        JTextField destinoField = new JTextField(20);
        JCalendar fechasalida = new JCalendar();
        JCalendar fechallegada = new JCalendar();

// Panel con los componentes
        JPanel panel = new JPanel();
        panel.add(new JLabel("Origen:"));
        panel.add(origenField);
        panel.add(new JLabel("Destino:"));
        panel.add(destinoField);
        panel.add(new JLabel("Fecha salida:"));
        panel.add(fechasalida);
        panel.add(new JLabel("Fecha llegada:"));
        panel.add(fechallegada);

        int option = JOptionPane.showConfirmDialog(null, panel, "Datos vuelo",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            String origen = origenField.getText();
            String destino = destinoField.getText();

            
            Date llegada = fechallegada.getDate();
            Date salida = fechasalida.getDate();
            Instant instant1 = llegada.toInstant();
            Instant instant2 = salida.toInstant();
            LocalDate fechaSalida = instant2.atZone(ZoneId.systemDefault()).toLocalDate();

            LocalDate fechaLlegada = instant1.atZone(ZoneId.systemDefault()).toLocalDate();

            Ruta ru = new Ruta(origen, destino, fechaSalida, fechaLlegada);
            return ru;
        } else {
            return null;
        }
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Mod = new javax.swing.JPopupMenu();
        Modificar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        Agregar = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        Enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        IngresarCliente = new javax.swing.JTextField();
        BuscarCliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Agregar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        IDs = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Categorias = new javax.swing.JComboBox<>();
        Buscar = new javax.swing.JButton();

        Mod.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        Modificar.setText("jMenuItem1");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        Mod.add(Modificar);

        Eliminar.setText("jMenuItem1");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        Mod.add(Eliminar);

        Agregar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Agregar.setText("jMenuItem1");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        Mod.add(Agregar);

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Crear Envio");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        Enviar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Enviar.setText("Enviar");
        Enviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        ListaProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ListaProductos.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ListaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre del Producto", "Cantidad", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ListaProductos.setComponentPopupMenu(Mod);
        ListaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(ListaProductos);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        IngresarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        BuscarCliente.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        BuscarCliente.setText("Buscar");
        BuscarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        Agregar1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Agregar1.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\imagenes\\minicon\\agregar.png"));
        Agregar1.setText("Agregar");
        Agregar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Agregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Cantidad:");

        Cantidad.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Cantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Producto ID:");

        IDs.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        IDs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Nombre:");

        Nombre.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Categoria:");

        Categorias.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Categorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        Categorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Categorias.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                CategoriasComponentAdded(evt);
            }
        });

        Buscar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Buscar.setText("Buscar");
        Buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nombre))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDs, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IDs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Agregar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Enviar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        ListaProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = ListaProductos.rowAtPoint(e.getPoint());
                if (pos != -1) {
                    ListaProductos.setRowSelectionInterval(pos, pos);
                    int id = (int) ListaProductos.getValueAt(pos, 0);
                    RenglonPedido rpa = modproducto(id);
                    if (rpa != null) {
                        ListaProductos.setValueAt(rpa.getProducto().getNombre(), pos, 1);
                        ListaProductos.setValueAt(String.valueOf(rpa.getCantidad()), pos, 2);
                        ListaProductos.setValueAt(rpa.getProducto().getTipoProducto().getNombre(), pos, 3);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: No se pudo encontrar el Renglon Del Pedido!");
                    }
                }
            }
        });
    }//GEN-LAST:event_ModificarActionPerformed

    private void BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarClienteActionPerformed
        try {
            us = sis.buscarUsuario(IngresarCliente.getText());
            JOptionPane.showInternalConfirmDialog(null, "Usuario: " + us.getUsername() + " selecionado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_BuscarClienteActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        ListaProductos.addMouseListener(new MouseAdapter() {
            public void mouseClicked1(MouseEvent e) {
                int pos = ListaProductos.rowAtPoint(e.getPoint());
                if (pos != -1) {
                    ListaProductos.setRowSelectionInterval(pos, pos);
                    int id = (int) ListaProductos.getValueAt(pos, 0);
                    rp.remove(id - 1);
                    ListaProductos.removeRowSelectionInterval(pos, pos);
                }
            }
        });
    }//GEN-LAST:event_EliminarActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed

    }//GEN-LAST:event_AgregarActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        try {
            Usuario use = sis.obtenerSesion();
            Ruta ru = optenerruta();
            if (use instanceof Administrativo admin) {
                if (us instanceof Cliente cli) {
                    Pedido pe = new Pedido(LocalDate.now(), ru, rp);
                    admin.crearPedido(cli, pe);
                    dispose();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo enviar el pedido!");
        }
    }//GEN-LAST:event_EnviarActionPerformed

    private void Agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar1ActionPerformed
        try {
            Usuario us = sis.obtenerSesion();
            if (us instanceof Administrativo admin) {
                TipoProducto t = admin.buscarTipoProducto(Categorias.getItemAt(Categorias.getSelectedIndex()));
                RenglonPedido r = new RenglonPedido(Integer.parseInt(Cantidad.getText()), new Producto(Nombre.getText(), t));
                rp.add(r);
                setModelLista(r);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_Agregar1ActionPerformed

    private void CategoriasComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_CategoriasComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriasComponentAdded

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        Usuario us = sis.obtenerSesion();
        if (us instanceof Administrativo admin) {
            Producto pro = admin.buscarProducto(Nombre.getText());
            IDs.setText(String.valueOf(pro.getId()));
            Categorias.setSelectedItem(pro.getTipoProducto().getNombre());
        }
    }//GEN-LAST:event_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Agregar;
    private javax.swing.JButton Agregar1;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton BuscarCliente;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JComboBox<String> Categorias;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JButton Enviar;
    private javax.swing.JTextField IDs;
    private javax.swing.JTextField IngresarCliente;
    private javax.swing.JTable ListaProductos;
    private javax.swing.JPopupMenu Mod;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
