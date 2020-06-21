/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Owners;

/**
 *
 * @author TAI
 */
public class OwnersController {

    static Connection conn;
    static Statement stmt;
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static List<Owners> getListOwners() throws ClassNotFoundException, SQLException {
        ArrayList<Owners> arrayListOwners = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "SELECT [OwnerID]\n"
                + "      ,[FirstName]\n"
                + "      ,[LastName]\n"
                + "      ,[Gender]\n"
                + "      ,[BirthDay]\n"
                + "      ,[Email]\n"
                + "      ,[PhoneNumber]\n"
                + "      ,[Address]\n"
                + "  FROM [dbo].[Owners]";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Owners owners = new Owners(rs.getInt("OwnerID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getBoolean("Gender"), rs.getString("BirthDay"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Address"));
            arrayListOwners.add(owners);
        }
        if (arrayListOwners.isEmpty()) {
            return null;
        } else {
            return arrayListOwners;
        }

    }
}
