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
import model.Property;

/**
 *
 * @author TAI
 */
public class PropertyController {

    static Connection conn;
    static Statement stmt;
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static List<Property> getListProperty() throws ClassNotFoundException, SQLException {
        ArrayList<Property> arrayListProperty = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "SELECT [PropertyID]\n"
                + "      ,[TypeID]\n"
                + "      ,[SquareMeter]\n"
                + "      ,[Price]\n"
                + "      ,[OwnerID]\n"
                + "      ,[Address]\n"
                + "      ,[Bedrooms]\n"
                + "      ,[Bathrooms]\n"
                + "      ,[Balcony]\n"
                + "      ,[Pool]\n"
                + "      ,[Garage]\n"
                + "      ,[Desciption]\n"
                + "  FROM [dbo].[Property] order by PropertyID";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Property property = new Property(rs.getInt("PropertyID"), rs.getInt("TypeID"), rs.getString("SquareMeter"), rs.getString("Price"), rs.getInt("OwnerID"), rs.getString("Address"), rs.getInt("Bedrooms"), rs.getInt("Bathrooms"), rs.getBoolean("Balcony"), rs.getBoolean("Pool"), rs.getBoolean("Garage"), rs.getString("Desciption"));
            arrayListProperty.add(property);
        }
        return arrayListProperty;
    }
    //Lấy danh sácg type name

    public static List<String> getTypeName() throws ClassNotFoundException, SQLException {
        ArrayList<String> listTypeName = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select TypeName from PropertysType";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            listTypeName.add(rs.getString("TypeName"));
        }
        return listTypeName;
    }

    //Lấy danh sách type name với ID
    public static List<String> getTypeNameWithID(String typeID) throws ClassNotFoundException, SQLException {
        ArrayList<String> listTypeName = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select TypeName from PropertysType where TypeID = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, typeID);
        rs = ps.executeQuery();
        while (rs.next()) {
            listTypeName.add(rs.getString("TypeName"));
        }
        return listTypeName;
    }

//ADD
    public static int addNewProperty(int typeID, String squareMetes, String price, int ownerID, String address, int bedrooms, int bathrooms, boolean balcony, boolean pool, boolean garage, String description) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "INSERT INTO [dbo].[Property]\n"
                + "           ([TypeID]\n"
                + "           ,[SquareMeter]\n"
                + "           ,[Price]\n"
                + "           ,[OwnerID]\n"
                + "           ,[Address]\n"
                + "           ,[Bedrooms]\n"
                + "           ,[Bathrooms]\n"
                + "           ,[Balcony]\n"
                + "           ,[Pool]\n"
                + "           ,[Garage]\n"
                + "           ,[Desciption])\n"
                + "     VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, typeID);
        ps.setString(2, squareMetes);
        ps.setString(3, price);
        ps.setInt(4, ownerID);
        ps.setString(5, address);
        ps.setInt(6, bedrooms);
        ps.setInt(7, bathrooms);
        ps.setBoolean(8, balcony);
        ps.setBoolean(9, pool);
        ps.setBoolean(10, garage);
        ps.setString(11, description);

        return ps.executeUpdate();

    }

    //Kiểm tra ownerID có tồn tại hay không ?
    public static boolean checkExistOwnerID(int ownerID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select OwnerID from Owners where OwnerID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, ownerID);
        rs = ps.executeQuery();
        while (rs.next()) {
            rs.close();
            ps.close();
            conn.close();
            return true;
        }
        return false;
    }

    // Lấy ra TypeID theo TypeName đang chọn
    public static int getTypeID(String typeName) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "select TypeID from PropertysType where TypeName = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, typeName);
        rs = ps.executeQuery();
        int typeID = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getInt("TypeID"));
            typeID = list.get(0);
        }
        return typeID;
    }

}
