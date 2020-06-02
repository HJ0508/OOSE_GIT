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

    public Workplace[] selectWorkplaceInfo(int workplaceId) throws SQLException {

//            workplaceId = 123; // 테스트용
            dbConnector.pstmt = dbConnector.conn.prepareStatement("SELECT * FROM oose.workplace where workplaceId = ?;");
            dbConnector.pstmt.setInt(1,workplaceId);
            dbConnector.res = dbConnector.pstmt.executeQuery();
            Vector<Workplace> workplaceVector = new Vector<>();
            Workplace workplaceTemp;
            while(dbConnector.res.next()){
                workplaceTemp = new Workplace(dbConnector.res.getInt(1),dbConnector.res.getString(2),dbConnector.res.getString(3),dbConnector.res.getString(4),dbConnector.res.getString(5),dbConnector.res.getString(6),dbConnector.res.getInt(7),dbConnector.res.getString(8),dbConnector.res.getString(9),dbConnector.res.getInt(10),null);
                workplaceVector.add(workplaceTemp);
            }

            int vectorSize = workplaceVector.size();
            Workplace[] workplaces = new Workplace[vectorSize];
            for(int i = 0; i < vectorSize; i++) {
                workplaces[i]=workplaceVector.get(i);
            }
            return workplaces;
    }
}
