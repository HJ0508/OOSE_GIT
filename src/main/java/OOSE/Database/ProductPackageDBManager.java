/*
작성 일자: 2020.05.31
작성자: 윤진
내용: product package - 상품 패키지 DB Manager
산출물 기준: DCD-1711
*/

package OOSE.Database;


import OOSE.Model.ProductPackage;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;

public class ProductPackageDBManager {
    private DBConnector conn;

    public boolean checkAuthority(int myAuthority, String useCase) throws SQLException{
        String sql = "SELECT authorityId FROM oose.authority WHERE accessRange LIKE '%"+ useCase +"%'";
        System.out.println(sql);
        conn = new DBConnector();
        conn.setRes((conn.getConn().prepareStatement(sql)).executeQuery());
        ResultSet res = conn.getRes();

        while(res.next()){
            int authority = res.getInt(1);
            if(myAuthority == authority){
                return true;
            }
        }

        return false;
    }


    public boolean registerProductInfo(ProductPackage info) throws SQLException {
        System.out.println("entry");
        conn = new DBConnector();

        String sql;
        sql = "SELECT * FROM productpackage WHERE productpackage.productName = ?;";
        System.out.println(sql);
        conn.pstmt = conn.getConn().prepareStatement(sql);
        conn.pstmt.setString(1, info.getName());
        ResultSet res = conn.pstmt.executeQuery();
        if(res.next()){
            return false;
        }

        sql = "INSERT INTO oose.productpackage (productName, price, productState, stock, note) \n" +
                "VALUES (?, ?, ?, ?, ?);";

        conn.pstmt = conn.getConn().prepareStatement(sql);

        conn.pstmt.setString(1, info.getName());
        conn.pstmt.setInt(2, info.getPrice());
        conn.pstmt.setString(3, info.getState());
        conn.pstmt.setInt(4, info.getStock());
        conn.pstmt.setString(5, info.getNote());

        conn.pstmt.executeUpdate();
        return true;
    }

    public boolean modifyProductInfo(ProductPackage info) throws SQLException {
        conn = new DBConnector();
        String sql = "UPDATE productpackage \n" +
                "SET price = ?, productState = ?, stock = ?, note = ? \n" +
                "WHERE (productName = ?);\n";

        conn.pstmt = conn.getConn().prepareStatement(sql);

        conn.pstmt.setInt(1, info.getPrice());
        conn.pstmt.setString(2, info.getState());
        conn.pstmt.setInt(3, info.getStock());
        conn.pstmt.setString(4, info.getNote());
        conn.pstmt.setString(5, info.getName());

        int tmp = conn.pstmt.executeUpdate();

        if (tmp == 1) {
            return true;
        } else {
            return false;
        }
    }


    public boolean deleteProductInfo(ProductPackage info) throws SQLException{
        conn = new DBConnector();
        String sql = "DELETE FROM productpackage where productName = ?;";

        conn.pstmt = conn.getConn().prepareStatement(sql);
        conn.pstmt.setString(1, info.getName());

        int tmp = conn.pstmt.executeUpdate();

        if (tmp == 1) {
            sql = "select @cnt:=49999999;";
            conn.pstmt = conn.getConn().prepareStatement(sql);
            conn.pstmt.executeQuery();
            sql = "UPDATE productPackage SET productId = @cnt:=@cnt+1;";
            conn.pstmt = conn.getConn().prepareStatement(sql);
            int startPoint = conn.pstmt.executeUpdate();
            sql = "ALTER TABLE productPackage AUTO_INCREMENT=" + startPoint;
            conn.pstmt = conn.getConn().prepareStatement(sql);
            conn.pstmt.executeUpdate();

            return true;
        } else {
            return false;
        }
    }

    public ProductPackage[] browseProductInfo() throws SQLException{
        ProductPackage productPackage;
        Vector<ProductPackage> vector = new Vector<>();
        conn = new DBConnector();
        String sql = "SELECT * FROM productpackage;";
        conn.setRes((conn.getConn().prepareStatement(sql)).executeQuery());

        ResultSet res = conn.getRes();

        int no = 1;
        while (res.next()) {
            productPackage = new ProductPackage();
            productPackage.setId(no++);
            productPackage.setName(res.getString(2));
            productPackage.setPrice(Integer.parseInt(res.getString(3)));
            productPackage.setState(res.getString(4));
            productPackage.setStock(Integer.parseInt(res.getString(5)));
            productPackage.setNote(res.getString(6));
            vector.add(productPackage);
        }

        return vector.toArray(new ProductPackage[vector.size()]);
    }
//
//    boolean checkAutority(String id){
//
//    }
//
//    boolean checkMissingInfo(Model.ProductPackage.Model.ProductPackage info){
//
//    }
}
