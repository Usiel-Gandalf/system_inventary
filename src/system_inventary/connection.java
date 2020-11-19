/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_inventary;

import java.sql.*;

/**
 *
 * @author usiel
 */
public class connection {

    Connection conn = null;
    Statement stmt = null;

    public Connection connect() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:inventary_system.db");
        } catch (Exception e) {
            System.out.print("a habido un error mientras se intentaba conectar con la base de datos" + e.getMessage());
        }
        return conn;
    }
/*
    public void Select() {
        String sql = "SELECT * FROM medicine";

        try {
            Connection conn = this.connect();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM medicine;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + description);
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
*/
}
