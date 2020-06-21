package OOSE.db;

import OOSE.model.Workplace;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class WorkplaceDBManager extends DBConnector{
//    DBConnector dbConnector;
    int authorityLevel;

    public WorkplaceDBManager() {
        super();
//        authorityLevel = 0;
    }

    public Workplace selectWorkplaceInfo(int workplaceId)  {
        try {

            pstmt = conn.prepareStatement("SELECT * FROM oose.workplace where workplaceId = ?;");
            pstmt.setInt(1, workplaceId);
            res = pstmt.executeQuery();

            Workplace workplace = null;
            while(res.next()) {
                workplace = new Workplace(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8), res.getString(9), res.getInt(10), res.getString(11));
            }

            return workplace;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateWorkplaceInfo(int workplaceId, String workplaceName, String manager, String address, String phoneNumber, String status, int fee, String openTime, String closeTime, String square, String otherInfo){
        try {
            pstmt = conn.prepareStatement("UPDATE oose.workplace SET workplaceName=?, personInCharge=?, address=?, phoneNumber=?, workplaceStatus=?, " +
                    "fee = ?, openingTime=?, closingTime=?, squareMeasure=?, otherInfo=? WHERE workplaceId = ?;");

            pstmt.setString(1, workplaceName);
            pstmt.setString(2, manager);
            pstmt.setString(3, address);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, status);
            pstmt.setInt(6, fee);
            pstmt.setString(7, openTime);
            pstmt.setString(8, closeTime);
            pstmt.setString(9, square);
            pstmt.setString(10, otherInfo);
            pstmt.setInt(11, workplaceId);
            pstmt.executeUpdate();
            if(res!=null){
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
            pstmt = conn.prepareStatement("UPDATE oose.workplace SET workplaceName=?, personInCharge=?, address=?, phoneNumber=?, workplaceStatus=?, " +
                    "fee = ?, openingTime=?, closingTime=?, squareMeasure=?, otherInfo=? WHERE workplaceId = ?;");

            pstmt.setString(1, workplaceName);
            pstmt.setString(2, manager);
            pstmt.setString(3, address);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, status);
            pstmt.setInt(6, fee);
            pstmt.setString(7, openTime);
            pstmt.setString(8, closeTime);
            pstmt.setString(9, square);
            pstmt.setString(10, otherInfo);
            pstmt.setInt(11, workplaceId);
//        res = pstmt.executeQuery();
            pstmt.executeUpdate();
            if(res!=null){
                System.out.println("삭제성공");
            }
            else{
                System.out.println("뭔가잘못됨");
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Workplace> browseWorkplace(){
        String query = "SELECT workplaceName FROM oose.workplace";
        try{
            pstmt = conn.prepareStatement(query);
            res = pstmt.executeQuery();

            ArrayList<Workplace> info = new ArrayList<Workplace>();

            while(res.next()){
                Workplace w = new Workplace();
                w.setId(res.getInt(1));
                w.setName(res.getString(2));
                info.add(w);
            }
            return info;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
