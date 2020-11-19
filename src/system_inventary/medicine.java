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
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;

public class medicine {

    private int id;
    private String name;
    private String description;
    private String clasification;
    private int quantity;
    private connection con = new connection();
    private medicineValidation validation = new medicineValidation();

    public void register_medicine(int id, String name, String description, String clasification, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.clasification = clasification;
        this.quantity = quantity;
        int vali = validation.id_medicine_validation(this.id);
        if (vali == 0) {
            System.out.print("El id no puede ser negativo");
        } else if (vali == 1) {
            String sql = "INSERT INTO medicine('id', 'name', 'description', 'clasification', 'quantity') VALUES(?,?,?,?,?)";
            try (Connection conn = con.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, this.id);
                pstmt.setString(2, this.name);
                pstmt.setString(3, this.description);
                pstmt.setString(4, this.clasification);
                pstmt.setInt(5, this.quantity);
                pstmt.executeUpdate();
                System.out.print("Se a registrado un nuevo medicamento");
            } catch (Exception e) {
                System.out.print("Hubo un error al intentar hacer la coneccion");
            }
        } else if (vali == 2) {
            System.out.print("EL id ya esta ocupado");
        } else {
            System.out.print("Algo salio mal al intentar validar el id");
        }
    }

    public JSONArray show_medicines() {
        String sql = "SELECT * FROM medicine";
        JSONArray jsonMedicines = new JSONArray();
        int contador = 0;

        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                JSONArray jsonMedicine = new JSONArray();
                jsonMedicine.add(rs.getInt("id"));
                jsonMedicine.add(rs.getString("name"));
                jsonMedicine.add(rs.getString("description"));
                jsonMedicine.add(rs.getString("clasification"));
                jsonMedicine.add(rs.getInt("quantity"));
                jsonMedicines.add(contador, jsonMedicine);
                contador++;
            }

        } catch (Exception e) {
            System.out.print("Hubo un error al intentar hacer la coneccion");

        }
        return jsonMedicines;
    }
}
