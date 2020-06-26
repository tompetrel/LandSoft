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
                + "      ,[Floor]\n"
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
            Property property = new Property(rs.getInt("PropertyID"), rs.getInt("TypeID"), rs.getString("SquareMeter"), rs.getString("Price"), rs.getInt("OwnerID"), rs.getString("Address"), rs.getInt("Floor"), rs.getInt("Bedrooms"), rs.getInt("Bathrooms"), rs.getBoolean("Balcony"), rs.getBoolean("Pool"), rs.getBoolean("Garage"), rs.getString("Desciption"));
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
    public static int addNewProperty(int typeID, String squareMetes, String price, int ownerID, String address, int floor, int bedrooms, int bathrooms, boolean balcony, boolean pool, boolean garage, String description) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "INSERT INTO [dbo].[Property]\n"
                + "           ([TypeID]\n"
                + "           ,[SquareMeter]\n"
                + "           ,[Price]\n"
                + "           ,[OwnerID]\n"
                + "           ,[Address]\n"
                + "           ,[Floor]\n"
                + "           ,[Bedrooms]\n"
                + "           ,[Bathrooms]\n"
                + "           ,[Balcony]\n"
                + "           ,[Pool]\n"
                + "           ,[Garage]\n"
                + "           ,[Desciption]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, typeID);
        ps.setString(2, squareMetes);
        ps.setString(3, price);
        ps.setInt(4, ownerID);
        ps.setString(5, address);
        ps.setInt(6, floor);
        ps.setInt(7, bedrooms);
        ps.setInt(8, bathrooms);
        ps.setBoolean(9, balcony);
        ps.setBoolean(10, pool);
        ps.setBoolean(11, garage);
        ps.setString(12, description);

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

//Update property
    public static int updateProperty(Property property) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "update Property set TypeID = ?, SquareMeter = ?, Price = ?, OwnerID = ?, Address = ?,Floor = ?, Bedrooms = ?, Bathrooms = ?, Balcony = ?, Pool = ?, Garage = ?, Desciption = ? where PropertyID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, property.getTypeID());
        ps.setString(2, property.getSquareMeter());
        ps.setString(3, property.getPrice());
        ps.setInt(4, property.getOwnerID());
        ps.setString(5, property.getAddress());
        ps.setInt(6, property.getFloor());
        ps.setInt(7, property.getBedrooms());
        ps.setInt(8, property.getBedrooms());
        ps.setBoolean(9, property.isBalcony());
        ps.setBoolean(10, property.isPool());
        ps.setBoolean(11, property.isGarage());
        ps.setString(12, property.getDesciption());
        ps.setInt(13, property.getPropertyID());

        return ps.executeUpdate();

    }
//Delete

    public static int deleteProperty(int propertyID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "delete Property where PropertyID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, propertyID);
        return ps.executeUpdate();
    }
}
