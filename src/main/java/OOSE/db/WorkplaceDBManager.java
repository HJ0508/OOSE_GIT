package OOSE.db;


import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Vector;

import OOSE.model.*;
import sun.awt.image.ImageAccessException;

import javax.xml.transform.Result;

public class WorkplaceDBManager {
    DBConnector dbConnector;
    int authorityLevel;

    public WorkplaceDBManager() {
        dbConnector = new DBConnector();
//        authorityLevel = 0;
    }

    public Workplace selectWorkplaceInfo(int workplaceId)  {
        try {

            dbConnector.pstmt = dbConnector.conn.prepareStatement("SELECT * FROM oose.workplace where workplaceId = ?;");
            dbConnector.pstmt.setInt(1, workplaceId);
            dbConnector.res = dbConnector.pstmt.executeQuery();

            Workplace workplace = null;
            while(dbConnector.res.next()) {
                workplace = new Workplace(dbConnector.res.getInt(1), dbConnector.res.getString(2), dbConnector.res.getString(3), dbConnector.res.getString(4), dbConnector.res.getString(5), dbConnector.res.getString(6), dbConnector.res.getInt(7), dbConnector.res.getString(8), dbConnector.res.getString(9), dbConnector.res.getInt(10), null);
            }

            return workplace;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateWorkplaceInfo(int workplaceId, String workplaceName, String manager, String address, String phoneNumber, String status, int fee, String openTime, String closeTime, String square, String otherInfo){
        try {
            dbConnector.pstmt = dbConnector.conn.prepareStatement("UPDATE oose.workplace SET workplaceName=?, personInCharge=?, address=?, phoneNumber=?, workplaceStatus=?, " +
                    "fee = ?, openingTime=?, closingTime=?, squareMeasure=?, otherInfo=? WHERE workplaceId = ?;");

            dbConnector.pstmt.setString(1, workplaceName);
            dbConnector.pstmt.setString(2, manager);
            dbConnector.pstmt.setString(3, address);
            dbConnector.pstmt.setString(4, phoneNumber);
            dbConnector.pstmt.setString(5, status);
            dbConnector.pstmt.setInt(6, fee);
            dbConnector.pstmt.setString(7, openTime);
            dbConnector.pstmt.setString(8, closeTime);
            dbConnector.pstmt.setString(9, square);
            dbConnector.pstmt.setString(10, otherInfo);
            dbConnector.pstmt.setInt(11, workplaceId);
//        dbConnector.res = dbConnector.pstmt.executeQuery();
            dbConnector.pstmt.executeUpdate();
            if(dbConnector.res!=null){
                System.out.println("수정성공");
            }
            else{
                System.out.println("뭔가잘못됨");
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteWorkplaceInfo(int workplaceId, String workplaceName, String manager, String address, String phoneNumber, String status, int fee, String openTime, String closeTime, String square, String otherInfo){
        try {
            dbConnector.pstmt = dbConnector.conn.prepareStatement("UPDATE oose.workplace SET workplaceName=?, personInCharge=?, address=?, phoneNumber=?, workplaceStatus=?, " +
                    "fee = ?, openingTime=?, closingTime=?, squareMeasure=?, otherInfo=? WHERE workplaceId = ?;");

            dbConnector.pstmt.setString(1, workplaceName);
            dbConnector.pstmt.setString(2, manager);
            dbConnector.pstmt.setString(3, address);
            dbConnector.pstmt.setString(4, phoneNumber);
            dbConnector.pstmt.setString(5, status);
            dbConnector.pstmt.setInt(6, fee);
            dbConnector.pstmt.setString(7, openTime);
            dbConnector.pstmt.setString(8, closeTime);
            dbConnector.pstmt.setString(9, square);
            dbConnector.pstmt.setString(10, otherInfo);
            dbConnector.pstmt.setInt(11, workplaceId);
//        dbConnector.res = dbConnector.pstmt.executeQuery();
            dbConnector.pstmt.executeUpdate();
            if(dbConnector.res!=null){
                System.out.println("수정성공");
            }
            else{
                System.out.println("뭔가잘못됨");
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //승환 - 수정 6/21
    public ArrayList<Workplace> browseWorkplace(){
        String query = "SELECT workplaceId,workplaceName FROM oose.workplace";
        try{
            dbConnector.pstmt = dbConnector.conn.prepareStatement(query);
            dbConnector.res = dbConnector.pstmt.executeQuery();

            ArrayList<Workplace> info = new ArrayList<Workplace>();

            while(dbConnector.res.next()){
                Workplace w = new Workplace();
                w.setId(dbConnector.res.getInt(1));
                w.setName(dbConnector.res.getString(2));
                info.add(w);
            }
            return info;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    //승환-추가 6/21
    public boolean registerWorkplace(String s1,String s2) {
        if (checkDuplicateInfo(s2)) return false;
        try {
            String query = "INSERT INTO oose.workplace (`workplaceId`,`workplaceName`) VALUES (?,?)";
            dbConnector.pstmt = dbConnector.conn.prepareStatement(query);
            dbConnector.pstmt.setString(1, s1);
            dbConnector.pstmt.setString(2, s2);
            int result = dbConnector.pstmt.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean modifyWorkplace(String oldName, String name) {
        String query = "UPDATE oose.workplace SET workplaceName=? WHERE workplaceName = ?";
        try {
            dbConnector.pstmt = dbConnector.conn.prepareStatement(query);
            dbConnector.pstmt.setString(1, name);
            dbConnector.pstmt.setString(2, oldName);
            int result = dbConnector.pstmt.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean deleteWorkplace(String s) {
        String query = "DELETE FROM oose.workplace WHERE workplaceName=?";
        try {
            dbConnector.pstmt = dbConnector.conn.prepareStatement(query);
            dbConnector.pstmt.setString(1, s);
            int result = dbConnector.pstmt.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    //권한체크
    public boolean checkAuthority(String s) {
        //이부분 좀 이상한데.. managerName=? 형식으로 해야되는건가
        String query = "SELECT authority FROM manager WHERE managerName";
        try {
            dbConnector.pstmt = dbConnector.conn.prepareStatement(query);

            return dbConnector.pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    //중복체크
    public boolean checkDuplicateInfo(String s) {
        String query = "SELECT workplaceName FROM oose.workplace WHERE workplaceName = ?";
        try {
            dbConnector.pstmt = dbConnector.conn.prepareStatement(query);
            dbConnector.pstmt.setString(1, s);
            dbConnector.res = dbConnector.pstmt.executeQuery();

            if (dbConnector.res.next()) {
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    //승환 - 추가 끝
}
