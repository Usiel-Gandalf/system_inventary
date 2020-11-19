/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validations;

import system_inventary.connection;
import java.sql.*;

/**
 *
 * @author usiel
 */
public class medicineValidation {

    private int id;
    int estado;
    private connection con = new connection();

    public int id_medicine_validation(int id) {
        this.id = id;
        String sql = "SELECT COUNT(*) FROM medicine WHERE id = ?";
        if (this.id <= 0) {
            estado = 0; // El id no puede ser negativo
        } else {
            try (Connection conn = con.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, this.id);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.getRow() == 0) {
                    estado = 1; // Se puede registrar el medicamento
                }else{
                    estado = 2; // EL id ya esta en uso
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return estado;
    }
}
