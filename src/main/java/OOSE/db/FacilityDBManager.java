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
            int result = conn.pstmt.executeUpdate();
            if(result > 0) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean modifyFacilityInfo(String oldName, String name) {
        String query = "UPDATE oose.facility SET facilityName=? WHERE facilityName = ?";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, name);
            conn.pstmt.setString(2, oldName);
            int result = conn.pstmt.executeUpdate();
            if(result > 0) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean deleteFacilityInfo(String s) {
        String query = "DELETE FROM oose.facility WHERE facilityName=?";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, s);
            int result = conn.pstmt.executeUpdate();
            if(result > 0) {
                return true;
            }else {
                return false;
            }
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

    public boolean registerFacilityInforInfo(String s) {
        return false;
    }

    public boolean modifyFacilityInforInfo(String s) {
        return false;
    }

    public boolean deleteFacilityInforInfo(String s) {
        return false;
    }

    public ArrayList<Facility> browseFacilityInforInfo() {
        String query = "SELECT * FROM oose.facility";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.res = conn.pstmt.executeQuery();

            ArrayList<Facility> info = new ArrayList<Facility>();
            while(conn.res.next()) {
                Facility f = new Facility();
                f.setId(conn.res.getInt(1));
                f.setName(conn.res.getString(2));
                f.setWorkPlaceId(conn.res.getInt(3));
                f.setFacilityState(conn.res.getString(4));
                f.setFee(conn.res.getInt(5));
                f.setOpenTime(conn.res.getString(6));
                f.setCloseTime(conn.res.getString(7));
                f.setManager(conn.res.getString(8));
                f.setCapacity(conn.res.getInt(9));
                info.add(f);
            }
            return info;
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }


}
