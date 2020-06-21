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
                + "  FROM [dbo].[Owners] order by OwnerID";
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

    public static int addNewOwners(String firstName, String lastName, boolean gender, String birthDay, String email, String phoneNumber, String address) throws ClassNotFoundException, SQLException {

        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "insert into Owners(FirstName,LastName,Gender,BirthDay,Email,PhoneNumber,Address) values(?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setBoolean(3, gender);
        ps.setString(4, birthDay);
        ps.setString(5, email);
        ps.setString(6, phoneNumber);
        ps.setString(7, address);
        return ps.executeUpdate();

    }

    //Kiểm tra Email đã tồn tại chưa ?
    public static boolean checkExistEmail(String email) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select Email from Owners where Email = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

    //Kiểm tra Phone number đã tồn tại chưa ?
    public static boolean checkExistPhoneNumber(String phoneNumber) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select PhoneNumber from Owners where PhoneNumber = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, phoneNumber);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

    public static int updateOwner(Owners owners) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "UPDATE Owners set FirstName = ?,LastName = ?,Gender = ?,BirthDay = ?,Email = ?, PhoneNumber = ?, Address = ? where OwnerID = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, owners.getFirstName());
        ps.setString(2, owners.getLastName());
        ps.setBoolean(3, owners.isGender());
        ps.setString(4, owners.getBirthDay());
        ps.setString(5, owners.getEmail());
        ps.setString(6, owners.getPhoneNumber());
        ps.setString(7, owners.getAddress());
        ps.setInt(8, owners.getOwnerID());
        return ps.executeUpdate();
    }

    //Kiểm tra Email có tồn tại, không tính Email hiện tại thuộc OwnerID đang chọn ?
    public static boolean checkExistEmailOfOwnerOther(String email, int OwnerID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select Email from Owners where Email = ? and OwnerID != ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ps.setInt(2, OwnerID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

    //Kiểm tra Phone number có tồn tại, không tính Phone number hiện tại thuộc OwnerID đang chọn ?
    public static boolean checkExistPhoneNumberOfOwnerOther(String phoneNumber, int OwnerID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select PhoneNumber from Owners where PhoneNumber = ? and OwnerID != ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, phoneNumber);
        ps.setInt(2, OwnerID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

}
