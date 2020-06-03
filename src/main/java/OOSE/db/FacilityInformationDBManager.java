package OOSE.db;
import OOSE.model.Facility;

public class FacilityInformationDBManager {
    DBConnector conn;
    int autority;
    public FacilityInformationDBManager() {
        conn = new DBConnector();
    }
    public boolean registerFacilityInfo(String s) {
        return false;
    }

    public boolean modifyFacilityInfo(String s) {
        return false;
    }

    public boolean deleteFacilityInfo(String s) {
        return false;
    }

    public String[] browseFacilityInfo() {
        String[] temp = new String[3];
        return temp;
    }

    public boolean checkAutority(String s) {
        return false;
    }

    public boolean checkDuplicateInfo(Facility s) {
        return false;
    }
}
