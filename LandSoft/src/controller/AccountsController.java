/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Accounts;

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

    public static List<Accounts> getListAccounts() throws ClassNotFoundException, SQLException {
        ArrayList<Accounts> arrList = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "SELECT [AccountID]\n"
                + "      ,[Username]\n"
                + "      ,[FirstName]\n"
                + "      ,[LastName]\n"
                + "      ,[Gender]\n"
                + "      ,[BirthDay]\n"
                + "      ,[Email]\n"
                + "      ,[PhoneNumber]\n"
                + "      ,[Address]\n"
                + "      ,[Password]\n"
                + "      ,[Image]\n"
                + "      ,[RoleID]\n"
                + "  FROM [dbo].[Accounts] order by AccountID";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Accounts accounts = new Accounts(rs.getInt("AccountID"), rs.getString("Username"), rs.getString("FirstName"), rs.getString("LastName"), rs.getBoolean("Gender"), rs.getString("BirthDay"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Address"), rs.getString("Password"), rs.getBytes("Image"), rs.getString("RoleID"));
            arrList.add(accounts);
        }
        return arrList;
    }

//ADD
    public static int addNewAccount(String userName, String firstName, String lastName, boolean gender, String birthDay, String email, String phoneNumber, String address, String password, byte[] image) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "insert into Accounts(Username,FirstName,LastName,Gender,BirthDay,Email,PhoneNumber,Address,Password,Image)values(?,?,?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, firstName);
        ps.setString(3, lastName);
        ps.setBoolean(4, gender);
        ps.setString(5, birthDay);
        ps.setString(6, email);
        ps.setString(7, phoneNumber);
        ps.setString(8, address);
        ps.setString(9, MD5(password));
        ps.setBytes(10, image);
        return ps.executeUpdate();
    }

    //Update
    public static int updateAccount(String userName, String firstName, String lastName, boolean gender, String birthDay, String email, String phoneNumber, String address, String password, byte[] image, int accountID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "update Accounts set Username=?, FirstName=?,LastName=?,Gender=?,BirthDay=?,Email=?,PhoneNumber=?,Address=?,Password=?,Image=? where AccountID = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, firstName);
        ps.setString(3, lastName);
        ps.setBoolean(4, gender);
        ps.setString(5, birthDay);
        ps.setString(6, email);
        ps.setString(7, phoneNumber);
        ps.setString(8, address);
        ps.setString(9, MD5(password));
        ps.setBytes(10, image);
        ps.setInt(11, accountID);
        return ps.executeUpdate();
    }

    //Delete
    public static int deleteAccount(int accountID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "delete Accounts where AccountID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, accountID);
        return ps.executeUpdate();
    }
//Kiểm tra Username có tồn tại chưa, không tính Account đang chọn

    public static boolean checkExistUserNameOfAccountOrther(String userName, int accountID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select Username from Accounts where Username = ? and AccountID != ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setInt(2, accountID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;

    }
//Kiểm tra Email có tồn tại chưa, không tính Account đang chọn

    public static boolean checkExistEmailOfAccountOrther(String email, int accountID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select Email from Accounts where Email = ? and AccountID != ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ps.setInt(2, accountID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;

    }
//Kiểm tra Phone number có tồn tại chưa, không tính Account đang chọn

    public static boolean checkExistPhoneNumberOfAccountOrther(String phoneNumber, int accountID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select PhoneNumber from Accounts where Email = ? and AccountID != ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, phoneNumber);
        ps.setInt(2, accountID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;

    }

    //Kiểm tra Username và Password có đúng không ?
    public static boolean checkLoginAccounts(String userName, String password) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select Username, Password from Accounts where Username = ? AND Password = ?";
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
        sql = "select Username from Accounts where Username = ?";
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

    //Kiểm tra Email có tồn tại và thuộc Username đang chọn không ?
    public static boolean checkEmailBelongUsername(String userName, String email) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select Email from Accounts where Username = ? AND Email = ?";
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
        sql = "update Accounts set Password = ? where Username = ? AND Email = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, MD5(password));
        ps.setString(2, userName);
        ps.setString(3, email);
        ps.executeUpdate();
    }

    //Lấy ra role name
    public static List<String> getListRoleName() throws ClassNotFoundException, SQLException {
        ArrayList<String> listRoleName = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select RoleName from Role";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            listRoleName.add(rs.getString("RoleName"));

        }
        return listRoleName;
    }

    //Kiểm tra accountID có tồn tại ?
    public static boolean checkExistAccountID(int accountID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select AccountID  from Accounts where AccountID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, accountID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;

    }

    //Lấy ra roleID dựa trên role name
    public static int getRoleIDWithRoleName(String roleName) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select RoleID from Role where RoleName = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, roleName);
        rs = ps.executeQuery();
        int roleID = 0;
        ArrayList<Integer> listRoleID = new ArrayList<>();
        while (rs.next()) {
            listRoleID.add(rs.getInt("RoleID"));
            roleID = listRoleID.get(0);
        }
        return roleID;
    }

    //Lấy ra roleName dựa trên userName
    public static String getRoleNameWithUserName(String userName) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select RoleName from Role join Accounts on Role.RoleID = Accounts.RoleID where Accounts.Username = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        rs = ps.executeQuery();
        String roleName = "";
        ArrayList<String> listRoleName = new ArrayList<>();
        while (rs.next()) {
            listRoleName.add(rs.getString("RoleName"));
            roleName = listRoleName.get(0);
        }
        return roleName;
    }

    //Chèn role cho Account
    public static int insertRoleIDToAccount(int roleID, int accountID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "update Accounts set RoleID = ? where AccountID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, roleID);
        ps.setInt(2, accountID);
        return ps.executeUpdate();
    }

    //Với accountID = 1 thì roleID của account đó cũng là 1
    public static void insertRoleAdmin() throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        int index = 1;
        sql = "update Accounts set RoleID = 1 where AccountID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, index);
        ps.executeUpdate();
    }

    public static String getRoleName(String userName) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select RoleName from Role join Accounts on Role.RoleID = Accounts.RoleID where Accounts.Username = ?";
        String roleName = "";
        return roleName;
    }

}
