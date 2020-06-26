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
        while(rs.next()){
            Transactions transactions = new Transactions(rs.getInt("TransactionID"), rs.getInt("PropertyID"), rs.getInt("CustomerID"), rs.getString("Date"), rs.getString("FinalPrice"));
            arrList.add(transactions);
        }
        return arrList;
    }
}
