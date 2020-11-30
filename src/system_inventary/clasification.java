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

    public boolean register_clasification(String clasification) {
        this.id = id;
        this.clasification = clasification;
        boolean register;

        String sql = "INSERT INTO clasification('clasification') VALUES(?)";
        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.clasification);
            pstmt.executeUpdate();
            register = true;
        } catch (Exception e) {
            register = false;
        }
        return register;
    }

    public JSONArray show_clasifications() {
        String sql = "SELECT * FROM clasification";
        JSONArray clasifications = new JSONArray();
        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                JSONObject clasification = new JSONObject();
                clasification.put("id", rs.getInt("id"));
                clasification.put("clasification", rs.getString("clasification"));
                clasifications.put(clasification);
            }

        } catch (Exception e) {
            System.out.print("Hubo un error al intentar hacer la coneccion");
        }
        return clasifications;
    }

    public JSONObject show_clasification(Integer id) {
        JSONObject medicine = new JSONObject();
        String sql = "SELECT * FROM clasification WHERE id = ?";

        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                medicine.put("id", rs.getInt("id"));
                medicine.put("clasification", rs.getString("clasification"));
            }

        } catch (Exception e) {
            System.out.print("Hubo un error al intentar hacer la coneccion");
        }
        return medicine;
    }

    public boolean delete_clasification(int id) {
        this.id = id;
        boolean status;
        String sql = "DELETE FROM clasification WHERE id = ?";
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

    public boolean update_clasification(Integer id, String clasification) {
        this.id = id;
        this.clasification = clasification;
        boolean status;
        String sql = "UPDATE clasification SET clasification = ? WHERE id = ?";
        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.clasification);
            pstmt.setInt(2, this.id);
            pstmt.executeUpdate();
            status = true;
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    public void search_clasification() {
    }
}
