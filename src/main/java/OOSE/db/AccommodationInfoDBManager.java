package OOSE.db;

import OOSE.model.Accommodation;

import java.sql.SQLException;
import java.util.Vector;

public class AccommodationInfoDBManager extends DBConnector{
    private String query;

    public Accommodation[] browseAccommodationInfo() throws SQLException {
        query = "SELECT * FROM oose.accommodation";
        pstmt = conn.prepareStatement(query);
        res = pstmt.executeQuery();
        Vector<Accommodation> result = new Vector<>();
        while(res.next()){
//            06/24 승환 에러나서 주석처리
//            result.add(new Accommodation(res.getInt(1), res.getString(2)));
        }
        return result.toArray(new Accommodation[result.size()]);
    }

    public Accommodation[] browseRoomInfo() throws SQLException {
        query = "SELECT * FROM oose.roominfo";
        pstmt = conn.prepareStatement(query);
        res = pstmt.executeQuery();
        Vector<Accommodation> result = new Vector<>();
        while(res.next()){
            //            06/24 승환 에러나서 주석처리
//            result.add(new Accommodation(res.getInt(2), null, res.getInt(3),
//                    res.getInt(4), res.getInt(5), null, res.getString(6)));
        }
        return result.toArray(new Accommodation[result.size()]);
    }
}
