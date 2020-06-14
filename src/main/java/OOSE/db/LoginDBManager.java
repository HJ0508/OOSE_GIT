package OOSE.db;

import OOSE.model.Member;

import java.sql.SQLException;

public class LoginDBManager {
    DBConnector dbConnector;

    public LoginDBManager() {
        dbConnector = new DBConnector();
//        authorityLevel = 0;
    }

    public Member getManager(String id){
        try {
        dbConnector.pstmt = dbConnector.conn.prepareStatement("SELECT * FROM oose.manager where managerId = ?;");

        dbConnector.pstmt.setString(1, id);

        dbConnector.res = dbConnector.pstmt.executeQuery();

        dbConnector.res.next();
        Member member = new Member();
        member.setId(dbConnector.res.getString(1));
        member.setName(dbConnector.res.getString(2));
        member.setPassword(dbConnector.res.getString(3));
        member.setAuthority(dbConnector.res.getInt(4));
        member.setPhoneNum(dbConnector.res.getString(5));
        return member;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public Member getEmployee(String id){
        try {
            dbConnector.pstmt = dbConnector.conn.prepareStatement("SELECT * FROM oose.employee where employeeId = ?;");

            dbConnector.pstmt.setString(1, id);

            dbConnector.res = dbConnector.pstmt.executeQuery();

            dbConnector.res.next();
            Member member = new Member();
            member.setId(dbConnector.res.getString(1));
            member.setName(dbConnector.res.getString(2));
            member.setPassword(dbConnector.res.getString(3));
            member.setAuthority(dbConnector.res.getInt(4));
            member.setPhoneNum(dbConnector.res.getString(5));
            return member;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public Member getMember(String id){
        try {
            dbConnector.pstmt = dbConnector.conn.prepareStatement("SELECT * FROM oose.member where memberId = ?;");

            dbConnector.pstmt.setString(1, id);

            dbConnector.res = dbConnector.pstmt.executeQuery();

            dbConnector.res.next();
            Member member = new Member();
            member.setId(dbConnector.res.getString(1));
            member.setName(dbConnector.res.getString(2));
            member.setPassword(dbConnector.res.getString(3));
            member.setAuthority(dbConnector.res.getInt(4));
            member.setPhoneNum(dbConnector.res.getString(5));
            return member;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }





}
