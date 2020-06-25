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

      public boolean registerProductPackagePaymentInfo(ProductPackagePayment info, String user) throws SQLException{
          ProductPackagePayment pp = new ProductPackagePayment();

          String sql = "select productName, price, stock from productpackage where productName = '" + info.getProductName() + "';";
          conn.setRes((conn.getConn().prepareStatement(sql)).executeQuery());
          ResultSet res = conn.getRes();
          int price = 0; //상품 가격
          int stock = 0; //상품 재고

          while (res.next()) {
              pp.setProductName(res.getString(1));
              price = res.getInt(2);
              stock = res.getInt(3);
          }

          int amount = info.getAmount();
          if(stock >= amount){
              String productName = info.getProductName();

              info.setPaidAmount(price * amount);
              int paidAmount = info.getPaidAmount();
              String paymentOption = info.getPaymentOption();
              String refundAccount = info.getRefundAccount();
              String userId = user; //나중에 처리하기. 일단 임의로 이렇게 두었다.

              sql = "UPDATE productpackage \n" +
                      "SET stock = stock-"+amount+" WHERE (productName = ?);";

              conn.pstmt = conn.getConn().prepareStatement(sql);
              conn.pstmt.setString(1, productName);
              conn.pstmt.executeUpdate();

              sql = "INSERT INTO productpackagepayment \n" +
                      "(paymentId, userId, productName, amount, paidAmount, paymentOption, refundAccount, paidDate) \n" +
                      "VALUES (NULL, ? , ?, ?, ?, ?, ?, now());\n";
              conn.pstmt = conn.getConn().prepareStatement(sql);
              conn.pstmt.setString(1, userId);
              conn.pstmt.setString(2, productName);
              conn.pstmt.setInt(3, amount);
              conn.pstmt.setInt(4, paidAmount);
              conn.pstmt.setString(5, paymentOption);
              conn.pstmt.setString(6, refundAccount);
              conn.pstmt.executeUpdate();

              return true;
          }

          return false;
      }

    public ProductPackagePayment[] browseProductPaymentInfo(String date) throws SQLException {
        System.out.println(date);
        ProductPackagePayment productPackagePayment;
        Vector<ProductPackagePayment> vector = new Vector<>();
        String sql = "SELECT productpackage.productName, sum(productpackagepayment.amount), sum(productpackage.price)  \n" +
                "FROM productpackage, productpackagepayment \n" +
                "where productpackage.productName = productpackagepayment.productName and productpackagepayment.paidDate > '"+ date + "'\n" +
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
