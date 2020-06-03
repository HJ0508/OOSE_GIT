package OOSE.controller.FacilityManagement;
import OOSE.model.*;
import OOSE.db.FacilityDBManager;

import javax.servlet.http.HttpServlet;

public class FacilityInformationController extends HttpServlet {
    FacilityDBManager dbManager = new FacilityDBManager();

    boolean facilityInformationRegister(String s) {
        dbManager.registerFacilityInfo(s);
        return false;
    }

    boolean facilityInformationModify(String s) {
        dbManager.modifyFacilityInfo(s);
        return false;
    }

    boolean facilityInformationDelete(String s) {
        dbManager.deleteFacilityInfo(s);
        return false;
    }

    String[] facilityInformationBrowse() {
        return dbManager.browseFacilityInfo();
    }

    boolean checkMissingInfo(Facility f) {
        //잊은거 있는지 확인
        return false;
    }

    void identifyReqView(String s, int n) {

    }
}
