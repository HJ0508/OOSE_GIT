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
//            workplaceId = 123; // 테스트용
            dbConnector.pstmt = dbConnector.conn.prepareStatement("SELECT * FROM oose.workplace where workplaceId = ?;");
            dbConnector.pstmt.setInt(1, workplaceId);
            dbConnector.res = dbConnector.pstmt.executeQuery();

//            int rowCount;
//            dbConnector.res.last();
//            rowCount = dbConnector.res.getRow();
//            dbConnector.res.first(); //resultSet의 행 끝에서 행 번호 읽어서 rowCount 설정 처음으로 돌아옴
//            Workplace[] workplaces = new Workplace[rowCount];
            dbConnector.res.next();
            Workplace workplace = new Workplace(dbConnector.res.getInt(1), dbConnector.res.getString(2), dbConnector.res.getString(3), dbConnector.res.getString(4), dbConnector.res.getString(5), dbConnector.res.getString(6), dbConnector.res.getInt(7), dbConnector.res.getString(8), dbConnector.res.getString(9), dbConnector.res.getInt(10), null);


//            for(int i = 0; i < rowCount; i++){
//                workplaces[i] = new Workplace(dbConnector.res.getInt(1),dbConnector.res.getString(2),dbConnector.res.getString(3),dbConnector.res.getString(4),dbConnector.res.getString(5),dbConnector.res.getString(6),dbConnector.res.getInt(7),dbConnector.res.getString(8),dbConnector.res.getString(9),dbConnector.res.getInt(10),null);
//
//                dbConnector.res.next();
//            }
            return workplace;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
