/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ventanas.emergentes;

import Modelo.*;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class Envio extends javax.swing.JInternalFrame {

    private Sistema sis;
    private JDesktopPane escritorio;
    private DefaultTableModel modelo;
    private Pedido pedido;

    /**
     * Creates new form Envio
     *
     * @param s
     * @param des
     */
    public Envio(Sistema s, JDesktopPane des) {
        initComponents();
        Icon icon = new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\imagenes\\minicon\\caja-abierta.png");
        setFrameIcon(icon);
        this.sis = s;
        this.escritorio = des;
        ponerListaPedidos();
        selecPedido();
    }

    private void ponerListaPedidos() {
        this.modelo = (DefaultTableModel) ListaPedidos.getModel();
        modelo.setRowCount(0);
        Usuario us = sis.obtenerSesion();
        if (us instanceof Administrativo admin) {
            List<Pedido> pe = admin.listarPedidosSistema();
            for (Pedido p : pe) {
                Object[] per = new Object[3];
                per[0] = p.getId();
                per[1] = p.getFechaCreacion().toString();
                per[2] = p.getEstado();
                modelo.addRow(per);
            }
        }
        ListaPedidos.setModel(modelo);
    }

    private void selecPedido() {
        ListaPedidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int index = ListaPedidos.rowAtPoint(evt.getPoint());
                int id = (int) ListaPedidos.getValueAt(index, 0);
                Usuario us = sis.obtenerSesion();
                if (us instanceof Administrativo admin) {
                    pedido = admin.buscarPedidoEnSistema(id);
                }
            }
        });
    }

    private String actualizarestado() {
        // Crear el combo box
        JComboBox<String> combo = new JComboBox<>();
        combo.addItem("Proceso");
        combo.addItem("En espera");
        combo.addItem("En posesión del cartero");
        combo.addItem("Entregado");
        combo.addItem("Devuelto");

        // Crear el pane
        Object[] options = {combo};

        int option = JOptionPane.showConfirmDialog(null, options, "Estado del pedido", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            // Obtener la selección 
            String selection = (String) combo.getSelectedItem();

            // Mostrar mensaje 
            JOptionPane.showMessageDialog(null, "Seleccionado: " + selection);

            // Devolver la selección
            return selection;

        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopMenu = new javax.swing.JPopupMenu();
        Mod = new javax.swing.JMenuItem();
        Eli = new javax.swing.JMenuItem();
        todos = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        CrearEnvio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaPedidos = new javax.swing.JTable();
        Actualizar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        todo = new javax.swing.JButton();

        Mod.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Mod.setText("Actualizar");
        Mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModActionPerformed(evt);
            }
        });
        PopMenu.add(Mod);

        Eli.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Eli.setText("Eliminar");
        Eli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliActionPerformed(evt);
            }
        });
        PopMenu.add(Eli);

        todos.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        todos.setText("Todo");
        todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosActionPerformed(evt);
            }
        });
        PopMenu.add(todos);

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestionar Envio");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        CrearEnvio.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        CrearEnvio.setText("Crear envio");
        CrearEnvio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        CrearEnvio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrearEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearEnvioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("ID:");

        id.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Buscar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Buscar.setText("Buscar");
        Buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        ListaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Fecha de inicio", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ListaPedidos.setComponentPopupMenu(PopMenu);
        jScrollPane2.setViewportView(ListaPedidos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Actualizar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        todo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        todo.setText("Todo");
        todo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        todo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(CrearEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(todo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Actualizar)
                    .addComponent(Eliminar)
                    .addComponent(todo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrearEnvio)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearEnvioActionPerformed
        Encli ec = new Encli(sis, escritorio);
        escritorio.add(ec);
        ec.setVisible(true);
    }//GEN-LAST:event_CrearEnvioActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        Usuario us = sis.obtenerSesion();
        if (us instanceof Administrativo admin) {
            admin.cambiarEstado(pedido, actualizarestado());
            JOptionPane.showMessageDialog(this, "Pedido Actualizado!");
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        Usuario us = sis.obtenerSesion();
        if (us instanceof Administrativo admin) {
            List<Pedido> p = admin.listarPedidosSistema();
            p.remove(pedido);
            JOptionPane.showMessageDialog(this, "Pedido Eliminado!");
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todoActionPerformed
        ponerListaPedidos();
    }//GEN-LAST:event_todoActionPerformed

    private void ModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModActionPerformed
        ActualizarActionPerformed(evt);
    }//GEN-LAST:event_ModActionPerformed

    private void EliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliActionPerformed
        EliminarActionPerformed(evt);
    }//GEN-LAST:event_EliActionPerformed

    private void todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosActionPerformed
        todoActionPerformed(evt);
    }//GEN-LAST:event_todosActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        Usuario us = sis.obtenerSesion();
        if (us instanceof Administrativo admin) {
            pedido = admin.buscarPedidoEnSistema(Integer.getInteger(id.getText()));
            modelo.setRowCount(0);
            Object[] per = new Object[3];
            per[0] = pedido.getId();
            per[1] = pedido.getFechaCreacion().toString();
            per[2] = pedido.getEstado();
            modelo.addRow(per);
            ListaPedidos.setModel(modelo);
        }
    }//GEN-LAST:event_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton CrearEnvio;
    private javax.swing.JMenuItem Eli;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTable ListaPedidos;
    private javax.swing.JMenuItem Mod;
    private javax.swing.JPopupMenu PopMenu;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton todo;
    private javax.swing.JMenuItem todos;
    // End of variables declaration//GEN-END:variables
}
