package OOSE.db;

import OOSE.model.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityDBManager {
    DBConnector conn;
    int autority;
    public FacilityDBManager() {
        conn = new DBConnector();
    }
    public boolean registerFacilityInfo(String s) {
        if(checkDuplicateInfo(s)) return false;

        //query에서 1부분 어떤 기준으로 workplaceid를 가져와야할까
        try {
            String query = "INSERT INTO oose.facility(SELECT LAST_INSERT_Id(), ?, 1 , NULL, NULL, NULL, NULL, NULL, NULL)";
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(2, s);
            return conn.pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean modifyFacilityInfo(String s) {
        //수정하려는 시설이름은 파라미터로 가져와야하지 않나?
        String query = "UPDATE oose.facility SET facilityName=? WHERE facilityName = 보류";

        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, s);
            return conn.pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean deleteFacilityInfo(String s) {
        String query = "DELETE oose.facility WHERE facilityName=?";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, s);
            return conn.pstmt.execute();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public String[] browseFacilityInfo() {
        String query = "SELECT facilityName FROM oose.facility";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.res = conn.pstmt.executeQuery();
            List<String> temp = new ArrayList<String>();
            while(conn.res.next()) {
                String name = conn.res.getString("facilityName");
                temp.add(name);
            }
            String[] info = new String[temp.size()];
            info = temp.toArray(info);
            return info;
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    //변경
    public boolean checkAutority(String s) {
        String query = "SELECT autority FROM manager WHERE managerName";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            //여기서 return말고 autority의 기준을 알아야 truefalse를 구별할텐데
            return conn.pstmt.execute();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    //변경
    public boolean checkDuplicateInfo(String s) {
        String query = "SELECT * FROM oose.facility GROUP BY facilityName HAVING COUNT(facilityName) > 1";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            //여기서 return말고 autority의 기준을 알아야 truefalse를 구별할텐데
            return conn.pstmt.execute();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
