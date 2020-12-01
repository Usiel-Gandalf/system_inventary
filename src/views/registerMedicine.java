/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author usiel
 */
import system_inventary.medicine;
import validations.*;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import system_inventary.clasification;

public class registerMedicine extends javax.swing.JFrame {

    /**
     * Creates new form createMedicine
     */
    medicine objMedicine = new medicine();
    clasification objClasification = new clasification();
    medicines_main medic = new medicines_main();
    
    
    public registerMedicine() {
        initComponents();
        addItemCMBClasification();
        this.setLocationRelativeTo(null);
    }
    
    public void addItemCMBClasification(){
        JSONArray clasifications = new JSONArray();
        clasifications = objClasification.show_clasifications();
        for (int i = 0; i < clasifications.length(); i++) {
            String clasification = clasifications.getJSONObject(i).getString("clasification");
            Integer id = clasifications.getJSONObject(i).getInt("id");
            cmbClasificationRegisterMedicine.addItem(id + ": " +clasification);
            
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

        lblKeyRegisterMedicine = new javax.swing.JLabel();
        txtKeyRegisterMedicine = new javax.swing.JTextField();
        lblNameRegisterMedicine = new javax.swing.JLabel();
        txtNameRegisterMedicine = new javax.swing.JTextField();
        lblDescriptionRegisterMedicine = new javax.swing.JLabel();
        txtDescriptionRegisterMedicine = new javax.swing.JTextField();
        lblClasificationRegisterMedicine = new javax.swing.JLabel();
        cmbClasificationRegisterMedicine = new javax.swing.JComboBox<>();
        lblQuantityMedicine = new javax.swing.JLabel();
        txtQuantityRegisterMedicine = new javax.swing.JTextField();
        lblTitleRegisterMedicine = new javax.swing.JLabel();
        btnRegisterMedicine = new javax.swing.JButton();
        btnCancelRegisterMedicine = new javax.swing.JButton();
        lblAlertRegisterMedicine = new javax.swing.JLabel();

        setTitle("Registrar Medicamento");
        setResizable(false);

        lblKeyRegisterMedicine.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblKeyRegisterMedicine.setText("Clave:");

        lblNameRegisterMedicine.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNameRegisterMedicine.setText("Nombre:");

        lblDescriptionRegisterMedicine.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDescriptionRegisterMedicine.setText("Descripcion:");

        lblClasificationRegisterMedicine.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblClasificationRegisterMedicine.setText("Clasificacion:");

        lblQuantityMedicine.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuantityMedicine.setText("Cantidad:");

        lblTitleRegisterMedicine.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitleRegisterMedicine.setText("REGISTRAR MEDICAMENTO");

        btnRegisterMedicine.setText("Registrar");
        btnRegisterMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterMedicineActionPerformed(evt);
            }
        });

        btnCancelRegisterMedicine.setText("Cancelar");
        btnCancelRegisterMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelRegisterMedicineActionPerformed(evt);
            }
        });

        lblAlertRegisterMedicine.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAlertRegisterMedicine.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClasificationRegisterMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantityMedicine)
                            .addComponent(lblDescriptionRegisterMedicine)
                            .addComponent(lblNameRegisterMedicine)
                            .addComponent(lblKeyRegisterMedicine))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtDescriptionRegisterMedicine, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKeyRegisterMedicine, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameRegisterMedicine, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbClasificationRegisterMedicine, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQuantityRegisterMedicine, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(lblTitleRegisterMedicine))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAlertRegisterMedicine)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelRegisterMedicine)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegisterMedicine)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitleRegisterMedicine)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKeyRegisterMedicine)
                    .addComponent(txtKeyRegisterMedicine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameRegisterMedicine)
                    .addComponent(txtNameRegisterMedicine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescriptionRegisterMedicine)
                    .addComponent(lblDescriptionRegisterMedicine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClasificationRegisterMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbClasificationRegisterMedicine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantityMedicine)
                    .addComponent(txtQuantityRegisterMedicine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAlertRegisterMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelRegisterMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterMedicineActionPerformed
        input_data validation = new input_data();
        medicineValidation medicineValidation = new medicineValidation();

        String key = txtKeyRegisterMedicine.getText().toString();
        String name = txtNameRegisterMedicine.getText().toString();
        String description = txtDescriptionRegisterMedicine.getText().toString();
        Integer clasification = Integer.parseInt(cmbClasificationRegisterMedicine.getSelectedItem().toString().replaceAll("\\D+",""));
        String quantity = txtQuantityRegisterMedicine.getText().toString();

        if (validation.isNumeric(key) == false || validation.isNumeric(quantity) == false) {
            JOptionPane.showMessageDialog(null, "La clave o la cantidad ingresada del medicamento debe de ser de tipo numerico", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            medicine registerMedicine = new medicine();
            Integer keyCorrect = Integer.parseInt(key);
            Integer quantityCorrect = Integer.parseInt(quantity);

            if (keyCorrect <= 0 || quantityCorrect <= 0) {
                JOptionPane.showMessageDialog(null, "La clave o la cantidad ingresada del medicamento no debe de ser negativa", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                boolean result = registerMedicine.register_medicine(keyCorrect, name, description, quantityCorrect, clasification);
                if (result == true) {
                    JOptionPane.showMessageDialog(null, "Nuevo medicamento agregado correctamente");
                    medic.tableMedicine();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "La clave del medicamento ya existe");
                }
            }
        }
    }//GEN-LAST:event_btnRegisterMedicineActionPerformed

    private void btnCancelRegisterMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRegisterMedicineActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelRegisterMedicineActionPerformed

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
            java.util.logging.Logger.getLogger(registerMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelRegisterMedicine;
    private javax.swing.JButton btnRegisterMedicine;
    private javax.swing.JComboBox<String> cmbClasificationRegisterMedicine;
    private javax.swing.JLabel lblAlertRegisterMedicine;
    private javax.swing.JLabel lblClasificationRegisterMedicine;
    private javax.swing.JLabel lblDescriptionRegisterMedicine;
    private javax.swing.JLabel lblKeyRegisterMedicine;
    private javax.swing.JLabel lblNameRegisterMedicine;
    private javax.swing.JLabel lblQuantityMedicine;
    private javax.swing.JLabel lblTitleRegisterMedicine;
    private javax.swing.JTextField txtDescriptionRegisterMedicine;
    private javax.swing.JTextField txtKeyRegisterMedicine;
    private javax.swing.JTextField txtNameRegisterMedicine;
    private javax.swing.JTextField txtQuantityRegisterMedicine;
    // End of variables declaration//GEN-END:variables
}
