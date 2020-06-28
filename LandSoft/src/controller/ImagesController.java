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
import model.Images;

/**
 *
 * @author TAI
 */
public class ImagesController {

    static Connection conn;
    static Statement stmt;
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static List<Images> getListImages() throws ClassNotFoundException, SQLException {
        ArrayList<Images> al = new ArrayList<>();
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "SELECT [ImageID]\n"
                + "      ,[PropertyID]\n"
                + "      ,[Image]\n"
                + "  FROM [dbo].[Images]";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Images images = new Images(rs.getInt("ImageID"), rs.getInt("PropertyID"), rs.getBytes("Image"));
            al.add(images);
        }
        return al;
    }

    public static int addNewPropertyImage(int propertyID, byte[] image) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "insert into Images(PropertyID,Image) values (?,?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, propertyID);
        ps.setBytes(2, image);
        return ps.executeUpdate();
    }

    public static int updatePropertyImage(Images images) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "update Images set PropertyID = ?, Image = ? where ImageID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, images.getPropertyID());
        ps.setBytes(2, images.getImage());
        ps.setInt(3, images.getImageID());
        return ps.executeUpdate();
    }

    public static int deletePropertyImage(int imageID) throws ClassNotFoundException, SQLException {
        conn = controller.ConnectionSQL.connectSQLServer();
        sql = "delete from Images where ImageID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, imageID);
        return ps.executeUpdate();
    }

}
