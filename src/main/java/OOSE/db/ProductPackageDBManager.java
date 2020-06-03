/*
작성 일자: 2020.05.31
작성자: 윤진
내용: product package - 상품 패키지 DB Manager
산출물 기준: DCD-1711
*/

package OOSE.db;


import OOSE.model.ProductPackage;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;

public class ProductPackageDBManager {
    private DBConnector conn;
    private int autority;

    //    boolean registerProductInfo(Model.ProductPackage.Model.ProductPackage info){
//
//    }
//
//    boolean modifyProductInfo(Model.ProductPackage.Model.ProductPackage info){
//
//    }
//
//    boolean deleteProductInfo(Model.ProductPackage.Model.ProductPackage info){
//
//    }
//
    /*Model.ProductPackage.Model.*/
    public ProductPackage[] browseProductInfo() throws SQLException {
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
