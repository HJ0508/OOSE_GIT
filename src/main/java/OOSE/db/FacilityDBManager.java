package OOSE.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import OOSE.model.*;

import javax.xml.transform.Result;

public class FacilityDBManager {
    DBConnector conn;
    int autority;
    public FacilityDBManager() {
        conn = new DBConnector();
    }
    public boolean registerFacilityInfo(String s) {
        if(checkDuplicateInfo(s)) return false;
        try {
            String query = "INSERT INTO oose.facility (`facilityName`) VALUES (?)";
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, s);
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

    public ArrayList<Facility> browseFacilityInfo() {
        String query = "SELECT * FROM oose.facility";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.res = conn.pstmt.executeQuery();

            ArrayList<Facility> info = new ArrayList<Facility>();
            while(conn.res.next()) {
                Facility f = new Facility();
                f.setId(conn.res.getInt(1));
                f.setName(conn.res.getString(2));
                info.add(f);
            }
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
        String query = "SELECT facilityName FROM oose.facility WHERE facilityName = ?";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, s);
            conn.res = conn.pstmt.executeQuery();
            //여기서 return말고 autority의 기준을 알아야 truefalse를 구별할텐데
            if(conn.res.next()) {
                return true;
            }
            return false;
        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
