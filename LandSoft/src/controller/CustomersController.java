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
import model.Customers;

/**
 *
 * @author TAI
 */
public class CustomersController {

    static Connection conn;
    static Statement stmt;
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static List<Customers> getListCustomers() throws ClassNotFoundException, SQLException {
        ArrayList<Customers> arrayListCustomers = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "SELECT [CustomerID]\n"
                + "      ,[FirstName]\n"
                + "      ,[LastName]\n"
                + "      ,[Gender]\n"
                + "      ,[BirthDay]\n"
                + "      ,[Email]\n"
                + "      ,[PhoneNumber]\n"
                + "      ,[Address]\n"
                + "  FROM [dbo].[Customers]";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Customers customers = new Customers(rs.getInt("CustomerID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getBoolean("Gender"), rs.getString("BirthDay"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Address"));
            arrayListCustomers.add(customers);
        }
        if (arrayListCustomers.isEmpty()) {
            return null;
        } else {
            return arrayListCustomers;
        }
    }

    //ADD
    public static int addNewCustomers(String firstName, String lastName, boolean gender, String birthDay, String email, String phoneNumber, String address) throws ClassNotFoundException, SQLException {

        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "insert into Customers(FirstName,LastName,Gender,BirthDay,Email,PhoneNumber,Address) values(?,?,?,?,?,?,?)";
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
        sql = "select Email from Customers where Email = ?";
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
        sql = "select PhoneNumber from Customers where PhoneNumber = ?";
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
//UPDATE

    public static int updateCustomer(Customers customers) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "UPDATE Customers set FirstName = ?,LastName = ?,Gender = ?,BirthDay = ?,Email = ?, PhoneNumber = ?, Address = ? where CustomerID = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, customers.getFirstName());
        ps.setString(2, customers.getLastName());
        ps.setBoolean(3, customers.isGender());
        ps.setString(4, customers.getBirthDay());
        ps.setString(5, customers.getEmail());
        ps.setString(6, customers.getPhoneNumber());
        ps.setString(7, customers.getAddress());
        ps.setInt(8, customers.getCustomerID());
        return ps.executeUpdate();
    }

    //Kiểm tra Email có tồn tại, không tính Email hiện tại thuộc CustomerID đang chọn ?
    public static boolean checkExistEmailOfCustomerOther(String email, int CustomerID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select Email from Customers where Email = ? and CustomerID != ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ps.setInt(2, CustomerID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

    //Kiểm tra Phone number có tồn tại, không tính Phone number hiện tại thuộc CustomerID đang chọn ?
    public static boolean checkExistPhoneNumberOfCustomerOther(String phoneNumber, int CustomerID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select PhoneNumber from Customers where PhoneNumber = ? and CustomerID != ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, phoneNumber);
        ps.setInt(2, CustomerID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

//DELETE
    public static int deleteCustomer(int CustomerID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "delete from Customers where CustomerID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, CustomerID);
        return ps.executeUpdate();
    }
}
