package OOSE.controller.FacilityManagement;
import OOSE.model.*;
import OOSE.db.FacilityDBManager;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;

public class FacilityInformationController extends HttpServlet {
    FacilityDBManager dbManager = new FacilityDBManager();

    boolean facilityInformationRegister(String s) {
        dbManager.registerFacilityInfo(s);
        return false;
    }

    boolean facilityInformationModify(String s) {
//        dbManager.modifyFacilityInfo(s); 매개변수 부족, 주석처리 0620 김해준
        return false;
    }

    boolean facilityInformationDelete(String s) {
        dbManager.deleteFacilityInfo(s);
        return false;
    }

    ArrayList<Facility> facilityInformationBrowse() {
        return dbManager.browseFacilityInfo();
    }

    boolean checkMissingInfo(Facility f) {
        //잊은거 있는지 확인
        return false;
    }

    void identifyReqView(String s, int n) {

    }
}
