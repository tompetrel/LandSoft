/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
}
