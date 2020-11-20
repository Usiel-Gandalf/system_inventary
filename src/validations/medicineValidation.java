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
    private boolean estado;
    private connection con = new connection();

    public boolean id_medicine_validation(int id) {
        this.id = id;
        String sql = "SELECT COUNT(*) FROM medicine WHERE id = ?";
        try (Connection conn = con.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                this.estado = true; // no Se pude usar
            } else {
                this.estado = false; // se puede usar
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return this.estado;
    }
}
