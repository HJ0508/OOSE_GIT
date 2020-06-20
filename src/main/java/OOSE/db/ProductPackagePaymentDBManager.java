/*
작성 일자: 2020.05.31
작성자: 윤진
내용: product package - 상품 패키지 결제에 대한 DB Manager
산출물 기준: DCD-1712
*/

package OOSE.db;

import OOSE.model.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ProductPackagePaymentDBManager {
    private DBConnector conn;
    private int autority;

    public ProductPackagePaymentDBManager(){
        conn = new DBConnector();
        autority = 2;
    }

//    boolean registerProductPackagePaymentInfo(Model.ProductPackage.Model.ProductPackage info){
//
//    }

    public ProductPackagePayment[] browseProductPaymentInfo(String date) throws SQLException {
        System.out.println(date);
        ProductPackagePayment productPackagePayment;
        Vector<ProductPackagePayment> vector = new Vector<>();
        String sql = "SELECT productpackage.productName, sum(productpackagepayment.amount), sum(productpackage.price)  \n" +
                "FROM productpackage, productpackagepayment \n" +
                "where productpackage.productId = productpackagepayment.productid and productpackagepayment.paidDate > '"+ date + "'\n" +
                "group by productName;";
        conn.setRes((conn.getConn().prepareStatement(sql)).executeQuery());

        ResultSet res = conn.getRes();

        int no = 1;
        while(res.next()){
            productPackagePayment = new ProductPackagePayment();
            productPackagePayment.setId(no++);
            productPackagePayment.setProductName(res.getString(1));
            productPackagePayment.setAmount(res.getInt(2));
            productPackagePayment.setPaidAmount(res.getInt(3));
            vector.add(productPackagePayment);
        }

        System.out.println(no);

        return vector.toArray(new ProductPackagePayment[vector.size()]);
    }

    //boolean checkAutority(String id){

    //} //권한검사 쪽이니 일단 두는걸로 하자
}
