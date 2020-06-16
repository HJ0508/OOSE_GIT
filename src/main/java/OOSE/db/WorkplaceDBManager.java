package OOSE.db;

import OOSE.model.Workplace;

import java.sql.SQLException;
import java.util.Vector;

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


}
