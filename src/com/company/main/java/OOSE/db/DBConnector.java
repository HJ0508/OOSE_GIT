/*
작성 일자: 2020.05.26
작성자: 김해준
내용: jdbc util
산출물 기준: CD-001
*/
package Database;

import java.sql.*;

public class DBConnector {
    String url = "jdbc:mysql://(host=haejun.iptime.org,port=3306,serverTimezone=UTC,allowMultiQueries=TRUE)/oose?useUnicode=true&characterEncoding=utf8";
    Connection conn = null;
    Statement stmt = null; // 안씀
    ResultSet res = null;
    PreparedStatement pstmt = null; // 이거씀
    String user = "user";
    String password = "5555";

    public DBConnector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user ,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public ResultSet getRes() {
        return res;
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }
}