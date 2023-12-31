/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ventanas.emergentes;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import Modelo.*;
import javax.swing.JOptionPane;
import ventanas.general.General;
/**
 *
 * @author Rodrigo
 */
public class Login extends javax.swing.JInternalFrame {
    private JDesktopPane escritorio;
    private Sistema gen;
    private General g;
    
    public Login( JDesktopPane des, Sistema genes, General god) {
        initComponents();
        Icon icon = new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\imagenes\\minicon\\circulo-de-usuario.png");
        this.setFrameIcon(icon);
        this.escritorio = des;
        this.gen = genes;
        this.g = god;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jusuario = new javax.swing.JTextField();
        jcontrasena = new javax.swing.JPasswordField();
        jLogin = new javax.swing.JButton();
        jRegister = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Login");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\imagenes\\circulo-de-usuario.png"));
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Contraseña");

        jusuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jcontrasena.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcontrasena.setText("Contraseña");
        jcontrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcontrasenaMouseClicked(evt);
            }
        });

        jLogin.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLogin.setText("Login");
        jLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginActionPerformed(evt);
            }
        });

        jRegister.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jRegister.setText("Register");
        jRegister.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jusuario)
                    .addComponent(jcontrasena)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogin)
                    .addComponent(jRegister))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterActionPerformed
        if(gen.getSesion() == null){
            Register res = new Register(gen);
            escritorio.add(res);
            res.setVisible(true);
        }
    }//GEN-LAST:event_jRegisterActionPerformed

    private void jLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginActionPerformed
        try{
            char[] pas = jcontrasena.getPassword();
            String rpas = String.valueOf(pas);
            gen.iniciarSesion(jusuario.getText(), rpas);
            Sesion ses = gen.getSesion();
            int tipo = gen.obtenerCodigoUsuario(ses.getUsuario());
            if(gen.getSesion() != null){
                g.mostrarmenu();
                dispose();
            }else{
                JOptionPane.showInternalMessageDialog(this, "Usuario o contraseña no son correctos");
            }
            
        }catch(Exception e){
            JOptionPane.showInternalMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jLoginActionPerformed

    private void jcontrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcontrasenaMouseClicked
        jcontrasena.setText("");
    }//GEN-LAST:event_jcontrasenaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jLogin;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jRegister;
    private javax.swing.JPasswordField jcontrasena;
    private javax.swing.JTextField jusuario;
    // End of variables declaration//GEN-END:variables
}
