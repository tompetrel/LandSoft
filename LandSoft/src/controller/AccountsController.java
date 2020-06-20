/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/**
 *
 * @author TAI
 */
public class AccountsController {

    static Connection conn;
    static Statement stmt;
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    //Mã hóa MD5 cho password
    public static String MD5(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(msg.getBytes());
        byte bytedata[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytedata.length; i++) {
            sb.append(Integer.toString((bytedata[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    //Kiểm tra Username và Password có đúng không ?
    public static boolean checkLoginAccounts(String userName, String password) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select UserName, Password from Accounts where UserName = ? AND Password = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, MD5(password));
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

    //Kiểm tra UserName đã tồn tại chưa ?
    public static boolean checkExistUserName(String userName) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select UserName from Accounts where UserName = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

    //Kiểm tra Email đã tồn tại chưa ?
    public static boolean checkExistEmail(String email) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select Email from Accounts where Email = ?";
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

    //Kiểm tra Phone đã tồn tại chưa ?
    public static boolean checkExistPhoneNumber(String phoneNumber) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select PhoneNumber from Accounts where PhoneNumber = ?";
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

    //Tạo Account mới
    public static void signUpAccounts(String userName, String email, String phoneNumber, String password) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "insert into Accounts(UserName,Email,PhoneNumber,Password) values (?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, email);
        ps.setString(3, phoneNumber);
        ps.setString(4, MD5(password));//Password được mã hóa MD5
        ps.executeUpdate();
    }

    //Kiểm tra Email có tồn tại và thuộc Username đang làm việc không ?
    public static boolean checkEmailBelongUsername(String userName, String email) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select Email from Accounts where UserName = ? AND Email = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, email);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

    //New Password
    public static void forgotPassword(String userName, String email, String password) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "update Accounts set Password = ? where UserName = ? AND Email = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, MD5(password));
        ps.setString(2, userName);
        ps.setString(3, email);
        ps.executeUpdate();
    }

}
