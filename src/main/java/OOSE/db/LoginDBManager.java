package OOSE.db;

import OOSE.model.Member;

import java.sql.SQLException;

public class LoginDBManager extends DBConnector{
    

    public LoginDBManager() {
        super();
    }

    public Member getManager(String id){
        try {
        pstmt = conn.prepareStatement("SELECT * FROM oose.manager where managerId = ?;");

        pstmt.setString(1, id);

        res = pstmt.executeQuery();

        res.next();
        Member member = new Member();
        member.setId(res.getString(1));
        member.setName(res.getString(2));
        member.setPassword(res.getString(3));
        member.setAuthority(res.getInt(4));
        member.setPhoneNum(res.getString(5));
        return member;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public Member getEmployee(String id){
        try {
            pstmt = conn.prepareStatement("SELECT * FROM oose.employee where employeeId = ?;");

            pstmt.setString(1, id);

            res = pstmt.executeQuery();

            res.next();
            Member member = new Member();
            member.setId(res.getString(1));
            member.setName(res.getString(2));
            member.setPassword(res.getString(3));
            member.setAuthority(res.getInt(4));
            member.setPhoneNum(res.getString(5));
            return member;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public Member getMember(String id){
        try {
            pstmt = conn.prepareStatement("SELECT * FROM oose.member where memberId = ?;");

            pstmt.setString(1, id);

            res = pstmt.executeQuery();

            res.next();
            Member member = new Member();
            member.setId(res.getString(1));
            member.setName(res.getString(2));
            member.setPassword(res.getString(3));
            member.setAuthority(res.getInt(4));
            member.setPhoneNum(res.getString(5));
            return member;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }





}
