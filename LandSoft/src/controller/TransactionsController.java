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
import model.Transactions;

/**
 *
 * @author TAI
 */
public class TransactionsController {

    static Connection conn;
    static Statement stmt;
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static List<Transactions> getListTransactions() throws ClassNotFoundException, SQLException {
        ArrayList<Transactions> arrList = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "SELECT [TransactionID]\n"
                + "      ,[PropertyID]\n"
                + "      ,[CustomerID]\n"
                + "      ,[Date]\n"
                + "      ,[FinalPrice]\n"
                + "  FROM [dbo].[Transactions] order by TransactionID";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Transactions transactions = new Transactions(rs.getInt("TransactionID"), rs.getInt("PropertyID"), rs.getInt("CustomerID"), rs.getString("Date"), rs.getString("FinalPrice"));
            arrList.add(transactions);
        }
        return arrList;
    }

    public static int addNewTransaction(int propertyID, int customerID, String date, String finalPrice) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "insert into Transactions(PropertyID,CustomerID,Date,FinalPrice) values (?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, propertyID);
        ps.setInt(2, customerID);
        ps.setString(3, date);
        ps.setString(4, finalPrice);
        return ps.executeUpdate();
    }

    public static boolean checkExistPropertyID(int propertyID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select PropertyID from Property where PropertyID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, propertyID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

    public static boolean checkExistCustomerID(int customerID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select CustomerID from Customers where CustomerID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, customerID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

    public static int updateTransaction(int transactionID, int propertyID, int customerID, String date, String finalPrice) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "update Transactions set PropertyID = ?, CustomerID = ?, Date = ?, FinalPrice = ? where TransactionID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, propertyID);
        ps.setInt(2, customerID);
        ps.setString(3, date);
        ps.setString(4, finalPrice);
        ps.setInt(5, transactionID);
        return ps.executeUpdate();
    }

    public static int deleteTransaction(int transactionID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "delete Transactions where TransactionID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, transactionID);
        return ps.executeUpdate();
    }

}
