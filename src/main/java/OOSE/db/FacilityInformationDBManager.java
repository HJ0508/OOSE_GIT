package OOSE.db;
import OOSE.model.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class FacilityInformationDBManager {
    DBConnector conn;
    int autority;
    public FacilityInformationDBManager() {
        conn = new DBConnector();
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

    public boolean checkAutority(String s) {
        return false;
    }

    public boolean checkDuplicateInforInfo(Facility s) {
        return false;
    }
}
