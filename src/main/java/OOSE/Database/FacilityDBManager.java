package OOSE.Database;

import java.sql.SQLException;
import java.util.ArrayList;

import OOSE.Model.*;

public class FacilityDBManager {
    DBConnector conn;
    int autority;

    public FacilityDBManager() {
        conn = new DBConnector();
    }

    public boolean registerFacilityInfo(String s) {
        if (checkDuplicateInfo(s)) return false;
        try {
            String query = "INSERT INTO oose.facility (`facilityName`) VALUES (?)";
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, s);
            int result = conn.pstmt.executeUpdate();
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

    public boolean modifyFacilityInfo(String oldName, String name) {
        String query = "UPDATE oose.facility SET facilityName=? WHERE facilityName = ?";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, name);
            conn.pstmt.setString(2, oldName);
            int result = conn.pstmt.executeUpdate();
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

    public boolean deleteFacilityInfo(String s) {
        String query = "DELETE FROM oose.facility WHERE facilityName=?";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, s);
            int result = conn.pstmt.executeUpdate();
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

    public ArrayList<Facility> browseFacilityInfo() {
        String query = "SELECT * FROM oose.facility";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.res = conn.pstmt.executeQuery();

            ArrayList<Facility> info = new ArrayList<Facility>();
            while (conn.res.next()) {
                Facility f = new Facility();
                f.setId(conn.res.getInt(1));
                f.setName(conn.res.getString(2));
                info.add(f);
            }
            return info;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    //변경
    public boolean checkAuthority(String s, String str) {
        String query = "SELECT accessRange FROM oose.authority WHERE authorityId = (SELECT authority FROM oose.manager WHERE managerId = ?)";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, s);
            conn.res = conn.pstmt.executeQuery();
            if (conn.res.next()) {
                String result = conn.res.getString(1);
                if(result.contains(str))
                    return true;
                else
                    return false;
            }

        } catch (SQLException throwables) {
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
            if (conn.res.next()) {
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean registerFacilityInforInfo(String name, String workPlaceId, String facilityState, String fee, String openTime, String closeTime, String manager, String capacity) {
        try {
            String query = "UPDATE oose.facility SET `facilityName` = ?, `workplaceId` = ?, `facilityState` = ?, `fee` = ?, `openTime` = ?, `closeTime` = ?, `manager` = ?, `capacity` = ? WHERE `facilityName` = ?";
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, name);
            conn.pstmt.setString(2, workPlaceId);
            conn.pstmt.setString(3, facilityState);
            conn.pstmt.setString(4, fee);
            conn.pstmt.setString(5, openTime);
            conn.pstmt.setString(6, closeTime);
            conn.pstmt.setString(7, manager);
            conn.pstmt.setString(8, capacity);
            conn.pstmt.setString(9, name);
            int result = conn.pstmt.executeUpdate();
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

    public boolean modifyFacilityInforInfo(String oldName, String name, String workPlaceId, String facilityState, String fee, String openTime, String closeTime, String manager, String capacity) {
        try {
            String query = "UPDATE oose.facility SET `facilityName` = ?, `workplaceId` = ?, `facilityState` = ?, `fee` = ?, `openTime` = ?, `closeTime` = ?, `manager` = ?, `capacity` = ? WHERE `facilityName` = ?";
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, name);
            conn.pstmt.setString(2, workPlaceId);
            conn.pstmt.setString(3, facilityState);
            conn.pstmt.setString(4, fee);
            conn.pstmt.setString(5, openTime);
            conn.pstmt.setString(6, closeTime);
            conn.pstmt.setString(7, manager);
            conn.pstmt.setString(8, capacity);
            conn.pstmt.setString(9, oldName);
            int result = conn.pstmt.executeUpdate();
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

    public boolean deleteFacilityInforInfo(String s) {
        try {
            String query = "UPDATE oose.facility SET `facilityName` = ?, `workplaceId` = ?, `facilityState` = ?, `fee` = ?, `openTime` = ?, `closeTime` = ?, `manager` = ?, `capacity` = ? WHERE `facilityName` = ?";
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.pstmt.setString(1, s);
            conn.pstmt.setString(2, null);
            conn.pstmt.setString(3, null);
            conn.pstmt.setString(4, null);
            conn.pstmt.setString(5, null);
            conn.pstmt.setString(6, null);
            conn.pstmt.setString(7, null);
            conn.pstmt.setString(8, null);
            conn.pstmt.setString(9, s);
            int result = conn.pstmt.executeUpdate();
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

    public ArrayList<Facility> browseFacilityInforInfo() {
        String query = "SELECT * FROM oose.facility";
        try {
            conn.pstmt = conn.conn.prepareStatement(query);
            conn.res = conn.pstmt.executeQuery();

            ArrayList<Facility> info = new ArrayList<Facility>();
            while (conn.res.next()) {
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }


}
