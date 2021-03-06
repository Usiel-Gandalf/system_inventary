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
    private Integer clasification;
    private int quantity;
    private connection con = new connection();
    private medicineValidation validation = new medicineValidation();

    public boolean register_medicine(Integer id, String name, String description, Integer quantity, Integer clasification) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.clasification = clasification;
        boolean register;

        String sql = "INSERT INTO medicine('id', 'name', 'description', 'quantity', 'idClasification') VALUES(?,?,?,?,?)";
        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.id);
            pstmt.setString(2, this.name);
            pstmt.setString(3, this.description);
            pstmt.setInt(4, this.quantity);
            pstmt.setInt(5, this.clasification);
            pstmt.executeUpdate();
            register = true;
        } catch (Exception e) {
            register = false;
        }
        return register;
    }

    public JSONArray show_medicines() {
        String sql = "SELECT * FROM medicine JOIN clasification ON medicine.idClasification = clasification.id";
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
                medicine.put("quantity", rs.getInt("quantity"));
                medicine.put("idClasification", rs.getInt("idClasification"));
                medicine.put("clasification", rs.getString("clasification"));
                medicines.put(medicine);
                contador++;

            }

        } catch (Exception e) {
            System.out.print("Hubo un error al intentar hacer la coneccion: show_medicines");

        }
        return medicines;
    }

    public JSONObject show_medicine(int id) {
        JSONObject medicine = new JSONObject();
        String sql = "SELECT * FROM medicine JOIN clasification "
                + "ON medicine.idClasification = clasification.id "
                + "WHERE medicine.id = ?";

        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                medicine.put("id", rs.getInt("id"));
                medicine.put("name", rs.getString("name"));
                medicine.put("description", rs.getString("description"));
                medicine.put("quantity", rs.getString("quantity"));
                medicine.put("idClasification", rs.getInt("idClasification"));
                medicine.put("clasification", rs.getString("clasification"));
            }

        } catch (Exception e) {
            System.out.print("Hubo un error al intentar hacer la coneccion");

        }
        return medicine;
    }

    public boolean delete_medicine(int id) {
        this.id = id;
        boolean status;
        String sql = "DELETE FROM medicine WHERE id = ?";
        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.id);
            pstmt.executeUpdate();
            status = true;
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    public boolean update_medicine(Integer id, String name, String description, Integer clasification) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.clasification = clasification;
        boolean status;
        String sql = "UPDATE medicine SET name = ?, description = ?, idClasification = ? WHERE id = ?";
        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.name);
            pstmt.setString(2, this.description);
            pstmt.setInt(3, this.clasification);
            pstmt.setInt(4, this.id);
            pstmt.executeUpdate();
            status = true;
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
}
