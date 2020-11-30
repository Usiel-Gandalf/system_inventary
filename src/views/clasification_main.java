/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import system_inventary.clasification;

/**
 *
 * @author usiel
 */
import system_inventary.clasification;
public class clasification_main extends javax.swing.JFrame {

    /**
     * Creates new form clasifications
     */
    clasification objClasification = new clasification();
    public void tableClasifications() {
        JSONArray clasificationsList = new JSONArray();
        clasificationsList = objClasification.show_clasifications();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Clave");
        modelo.addColumn("Clasification");
        for (int i = 0; i < clasificationsList.length(); i++) {
            Integer id = clasificationsList.getJSONObject(i).getInt("id");
            String clasif = clasificationsList.getJSONObject(i).getString("clasification");
            modelo.addRow(new Object[]{id, clasif});
        }
        tableClasifications.setModel(modelo);
    }

    public clasification_main() {
        initComponents();
        tableClasifications();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableClasifications = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnRegisterClasification = new javax.swing.JButton();
        btnEditClasification = new javax.swing.JButton();
        btnDeleteClasification = new javax.swing.JButton();
        menubarClasifications = new javax.swing.JMenuBar();
        menuReturnClasifications = new javax.swing.JMenu();

        tableClasifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Clasificacion"
            }
        ));
        jScrollPane1.setViewportView(tableClasifications);

        btnRegisterClasification.setText("Registrar");
        btnRegisterClasification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterClasificationActionPerformed(evt);
            }
        });

        btnEditClasification.setText("Editar");
        btnEditClasification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditClasificationActionPerformed(evt);
            }
        });

        btnDeleteClasification.setText("Eliminar");
        btnDeleteClasification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClasificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnRegisterClasification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditClasification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteClasification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegisterClasification)
                .addGap(18, 18, 18)
                .addComponent(btnEditClasification)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteClasification)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuReturnClasifications.setText("Regresar");
        menuReturnClasifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuReturnClasificationsMouseClicked(evt);
            }
        });
        menubarClasifications.add(menuReturnClasifications);

        setJMenuBar(menubarClasifications);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuReturnClasificationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuReturnClasificationsMouseClicked
        this.setVisible(false);
        new medicines_main().setVisible(true);
    }//GEN-LAST:event_menuReturnClasificationsMouseClicked

    private void btnRegisterClasificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterClasificationActionPerformed
        new registerClasification().setVisible(true);
    }//GEN-LAST:event_btnRegisterClasificationActionPerformed

    private void btnEditClasificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditClasificationActionPerformed
        try {
            Object idSelected = tableClasifications.getValueAt(tableClasifications.getSelectedRow(), 0);
            Integer id = Integer.parseInt(idSelected.toString());
            new editClasification(id).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar una clasificacion para poder editarla");
        }
    }//GEN-LAST:event_btnEditClasificationActionPerformed

    private void btnDeleteClasificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClasificationActionPerformed
        try {
            Object idSelected = tableClasifications.getValueAt(tableClasifications.getSelectedRow(), 0);
            int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar esta clasificacion?");
            if (confirm == JOptionPane.OK_OPTION) {
                clasification deleteClasification = new clasification();
                boolean result = deleteClasification.delete_clasification(Integer.parseInt(idSelected.toString()));
                if (result == true) {
                    JOptionPane.showMessageDialog(null, "Clasificacion eliminada correctamente");
                    System.out.println("Se a eliminado correctamente la clasificacion");
                } else {
                    JOptionPane.showMessageDialog(null, "Algo a salido mal mientras se intentaba eliminar la clasificacion");
                    System.out.println("Assssssssss");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar una clasificacion para poder eliminarla");
        }
    }//GEN-LAST:event_btnDeleteClasificationActionPerformed

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
            java.util.logging.Logger.getLogger(clasification_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clasification_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clasification_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clasification_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clasification_main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteClasification;
    private javax.swing.JButton btnEditClasification;
    private javax.swing.JButton btnRegisterClasification;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuReturnClasifications;
    private javax.swing.JMenuBar menubarClasifications;
    private javax.swing.JTable tableClasifications;
    // End of variables declaration//GEN-END:variables
}
