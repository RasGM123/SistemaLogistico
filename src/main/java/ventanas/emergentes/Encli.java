/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ventanas.emergentes;

import Modelo.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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

    /**
     * Creates new form Encli
     *
     * @param s
     */
    public Encli(Sistema s) {
        initComponents();
        Icon icon = new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\imagenes\\minicon\\caja-abierta.png");
        setFrameIcon(icon);
        this.sis = s;
    }

    private RenglonPedido modproducto(int id) {
        RenglonPedido re = null;
        for (RenglonPedido rpt : this.rp) {
            if (rpt.getId() == id) {
                AgrProductoEnvio ape = new AgrProductoEnvio(rpt, sis);
                ape.setVisible(true);
                re = rpt;
            }
        }
        return re;
    }

    private Ruta optenerruta() {
// Formateador de fechas 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

// Componentes del dialogo
        JTextField origenField = new JTextField(20);
        JTextField destinoField = new JTextField(20);
        JTextField fechaSalidaField = new JTextField(20);
        JTextField fechaLlegadaField = new JTextField(20);

// Panel con los componentes
        JPanel panel = new JPanel();
        panel.add(new JLabel("Origen:"));
        panel.add(origenField);
        panel.add(new JLabel("Destino:"));
        panel.add(destinoField);
        panel.add(new JLabel("Fecha salida:"));
        panel.add(fechaSalidaField);
        panel.add(new JLabel("Fecha llegada:"));
        panel.add(fechaLlegadaField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Datos vuelo",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            String origen = origenField.getText();
            String destino = destinoField.getText();

            LocalDateTime fechaSalida = LocalDateTime.parse(
                    fechaSalidaField.getText(), format);

            LocalDateTime fechaLlegada = LocalDateTime.parse(
                    fechaLlegadaField.getText(), format);

            Ruta ru = new Ruta(sis.getRutas().size()+1, origen, destino, fechaSalida, fechaLlegada);
            return ru;
        }else{
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
        jPanel2 = new javax.swing.JPanel();
        AgregarProducto = new javax.swing.JButton();
        Enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        IngresarCliente = new javax.swing.JTextField();
        BuscarCliente = new javax.swing.JButton();
        Estado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

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
        setTitle("Crear Envio");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        AgregarProducto.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        AgregarProducto.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\imagenes\\agregar.png"));
        AgregarProducto.setText("Agregar producto");
        AgregarProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        AgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProductoActionPerformed(evt);
            }
        });

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
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre del Producto", "Cantidad", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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

        Estado.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preimposicion", "Proceso", "Poseeción del cartero", "Entregado" }));
        Estado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Estado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(310, 310, 310))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AgregarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Enviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

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

    private void AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProductoActionPerformed
        try {
            RenglonPedido rp1 = new RenglonPedido(rp.size() + 1, 0, null);
            AgrProductoEnvio ape = new AgrProductoEnvio(rp1, sis);
            ape.setVisible(true);
            String data[] = {String.valueOf(rp1.getId()), rp1.getProducto().getNombre(), String.valueOf(rp1.getCantidad()), rp1.getProducto().getTipoProducto().getNombre()};
            DefaultTableModel modelo = (DefaultTableModel) ListaProductos.getModel();
            modelo.addColumn(data);
            rp.add(rp1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_AgregarProductoActionPerformed

    private void BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarClienteActionPerformed
        try {
            us = sis.buscarUsuario(IngresarCliente.getText());
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
        AgregarProductoActionPerformed(evt);
    }//GEN-LAST:event_AgregarActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        try{
        Usuario use = sis.obtenerSesion();
        Ruta ru = optenerruta();
        if (use instanceof Administrativo admin ) {
            if(us instanceof Cliente cli){
                Pedido pe = new Pedido(sis.getPedidos().size() + 1, LocalDateTime.now(),ru, rp);
                admin.crearPedido(cli, pe);
            }
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: no se pudo enviar el pedido!");
        }
    }//GEN-LAST:event_EnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Agregar;
    private javax.swing.JButton AgregarProducto;
    private javax.swing.JButton BuscarCliente;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JButton Enviar;
    private javax.swing.JComboBox<String> Estado;
    private javax.swing.JTextField IngresarCliente;
    private javax.swing.JTable ListaProductos;
    private javax.swing.JPopupMenu Mod;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
