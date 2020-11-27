/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_inventary;

/**
 *
 * @author usiel
 */
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class clasification {

    private Integer id;
    private String clasification;
    private connection con = new connection();


    public boolean register_clasification(Integer id, String clasification) {
        this.id = id;
        this.clasification = clasification;
        boolean register;

        String sql = "INSERT INTO clasification('id', 'clasification') VALUES(?,?)";
        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.id);
            pstmt.setString(2, this.clasification);
            pstmt.executeUpdate();
            // System.out.print("Se a registrado un nuevo medicamento");
            register = true;
        } catch (Exception e) {
            //System.out.print("Hubo un error al intentar hacer la coneccion");
            register = false;
        }
        return register;
    }

    public JSONObject show_clasifications() {
        String sql = "SELECT * FROM clasification";
        JSONObject medicines = new JSONObject();
        int contador = 0;

        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                JSONObject medicine = new JSONObject();
                medicine.put("id", rs.getInt("id"));
                medicine.put("name", rs.getString("name"));
                medicine.put("description", rs.getString("description"));
                medicine.put("clasification", rs.getString("clasification"));
                medicine.put("quantity", rs.getInt("quantity"));
                //medicines.put(medicine);
                contador++;
            }

        } catch (Exception e) {
            System.out.print("Hubo un error al intentar hacer la coneccion");

        }
        return medicines;
    }

    public void show_clasification() {
    }

    public void delete_clasification() {
    }

    public void update_clasification() {
    }

    public void search_clasification() {
    }
}
