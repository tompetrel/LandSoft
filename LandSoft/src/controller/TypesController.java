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
import model.Types;

/**
 *
 * @author TAI
 */
public class TypesController {

    static Connection conn;
    static Statement stmt;
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static List<Types> getListTypes() throws ClassNotFoundException, SQLException {
        ArrayList<Types> arrayListTypes = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "SELECT [TypeID]\n"
                + "      ,[TypeName]\n"
                + "      ,[Description]\n"
                + "  FROM [dbo].[PropertysType] order by TypeID";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Types types = new Types(rs.getInt("TypeID"), rs.getString("TypeName"), rs.getString("Description"));
            arrayListTypes.add(types);
        }

        return arrayListTypes;
    }
//ADD

    public static int addNewTypes(String typeName, String description) throws ClassNotFoundException, SQLException {

        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "insert into PropertysType(TypeName,Description) values(?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, typeName);
        ps.setString(2, description);
        return ps.executeUpdate();

    }

    //Kiểm tra type name có tồn tại không ?
    public static boolean checkExistTypeName(String typeName) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select TypeName from PropertysType where TypeName = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, typeName);
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

    public static int updateType(Types types) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "update PropertysType set TypeName = ? ,Description = ? where TypeID = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, types.getTypeName());
        ps.setString(2, types.getDescription());
        ps.setInt(3, types.getTypeID());
        return ps.executeUpdate();
    }

    //Kiểm tra type name có tồn tại, không tính type name hiện tại thuộc typeID đang chọn ?
    public static boolean checkExistTypeNameOfTypeOther(String typeName, int typeID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select TypeName from PropertysType where TypeName = ? and TypeID != ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, typeName);
        ps.setInt(2, typeID);
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
    public static int deleteType(int typeID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "delete from PropertysType where TypeID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, typeID);
        return ps.executeUpdate();
    }

// Lấy ra Type name theo TypeID
    public static List<String> getListTypeName(int TypeID) throws ClassNotFoundException, SQLException {
        ArrayList<String> arrayListTypeName = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select TypeName from PropertysType where TypeID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, TypeID);
        rs = ps.executeQuery();
        while (rs.next()) {
            arrayListTypeName.add(rs.getString("TypeName"));
        }
        return arrayListTypeName;
    }

}
