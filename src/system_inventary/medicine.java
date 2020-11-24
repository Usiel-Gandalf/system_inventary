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
import validations.medicineValidation;
import java.sql.*;
import org.json.*;

public class medicine {

    private int id;
    private String name;
    private String description;
    private String clasification;
    private int quantity;
    private connection con = new connection();
    private medicineValidation validation = new medicineValidation();

    public boolean register_medicine(int id, String name, String description, String clasification, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.clasification = clasification;
        this.quantity = quantity;
        boolean register;

        String sql = "INSERT INTO medicine('id', 'name', 'description', 'clasification', 'quantity') VALUES(?,?,?,?,?)";
        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.id);
            pstmt.setString(2, this.name);
            pstmt.setString(3, this.description);
            pstmt.setString(4, this.clasification);
            pstmt.setInt(5, this.quantity);
            pstmt.executeUpdate();
            // System.out.print("Se a registrado un nuevo medicamento");
            register = true;
        } catch (Exception e) {
            //System.out.print("Hubo un error al intentar hacer la coneccion");
            register = false;
        }
        return register;
    }

    public JSONArray show_medicines() {
        String sql = "SELECT * FROM medicine";
        JSONArray medicines = new JSONArray();
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
                medicines.put(medicine);
                contador++;
            }

        } catch (Exception e) {
            System.out.print("Hubo un error al intentar hacer la coneccion");

        }
        return medicines;
    }
}
