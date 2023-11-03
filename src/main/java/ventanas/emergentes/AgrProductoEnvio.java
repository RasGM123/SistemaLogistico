
package ventanas.emergentes;

import Modelo.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class AgrProductoEnvio extends javax.swing.JInternalFrame {

    private RenglonPedido rp;
    private Sistema sis;
    private TipoProducto tp = null;
    /**
     * Creates new form AgrProductoEnvio
     * @param p
     * @param s
     */
    public AgrProductoEnvio(RenglonPedido p,Sistema s) {
        initComponents();
        this.rp = p;
        this.sis = s;
        SetCategoria();
        SetProductos();
    }
    
    private void SetProductos(){
        ID.setText(String.valueOf(rp.getId()));
        Cantidad.setText(String.valueOf(rp.getCantidad()));
        Nombre.setText(rp.getProducto().getNombre());
        Categoria.setSelectedItem(rp.getProducto().getTipoProducto().getNombre());
    }

    private void SetCategoria(){
        Categoria.removeAllItems();
        for(TipoProducto tp : sis.getTiposDeProductos()){
            Categoria.addItem(tp.getNombre());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Agregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Categoria = new javax.swing.JComboBox<>();
        AgregarCategoria = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Agregar Producto");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        Agregar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Agregar.setText("Agregar");
        Agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Cantidad:");

        Cantidad.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Cantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Producto ID:");

        ID.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Nombre:");

        Nombre.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Categoria:");

        Categoria.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Categoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        AgregarCategoria.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        AgregarCategoria.setText("Añadir");
        AgregarCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        AgregarCategoria.setContentAreaFilled(false);
        AgregarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCategoriaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nombre))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cantidad))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Agregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
       try{
           rp.setCantidad(Integer.getInteger(Cantidad.getText()));
           Usuario us = sis.obtenerSesion();
           if(us instanceof Administrativo admin){
               String sele= (String) Categoria.getSelectedItem();
               this.tp = admin.buscarTipoDeProducto(sele);
           }
           Producto pro = new Producto( Nombre.getText(), this.tp);
           rp.setProducto(pro);
           dispose();
       }catch(Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage());
       }
    }//GEN-LAST:event_AgregarActionPerformed

    private void AgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCategoriaActionPerformed
        Usuario us = sis.obtenerSesion();
        if(us instanceof Gerente gen){
            String cat = JOptionPane.showInputDialog("Ingrese El nombre de la categoria: ");
            TipoProducto tp = new TipoProducto( cat);
            try {
                gen.crearTipoDeProducto(tp);
            } catch (Exception ex) {
                Logger.getLogger(AgrProductoEnvio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showInternalInputDialog(null, "No tiene permiso para hacer esto!");
        }
    }//GEN-LAST:event_AgregarCategoriaActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        Usuario us = sis.obtenerSesion();
        if(us instanceof Administrativo admin){
            Producto pro = admin.buscarProducto(ID.getText());
            Nombre.setText(pro.getNombre());
            Categoria.setSelectedItem(pro.getTipoProducto().getNombre());
        }
    }//GEN-LAST:event_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton AgregarCategoria;
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JComboBox<String> Categoria;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
