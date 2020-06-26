package OOSE.Database;

import OOSE.Model.Accommodation;

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
            result.add(new Accommodation(res.getInt(1), res.getString(2)));
        }
        return result.toArray(new Accommodation[result.size()]);
    }

    public Accommodation[] browseRoomInfo() throws SQLException {
        query = "SELECT * FROM oose.roominfo";
        pstmt = conn.prepareStatement(query);
        res = pstmt.executeQuery();
        Vector<Accommodation> result = new Vector<>();
        while(res.next()){
            result.add(new Accommodation(res.getInt(2), null, res.getInt(3),
                    res.getInt(4), res.getInt(5), null, res.getString(6)));
        }
        return result.toArray(new Accommodation[result.size()]);
    }

    public int getRoomPrice(int accommodationId, int roomNumber) throws SQLException {
        query = "SELECT `roominfo`.`roomPrice` FROM `oose`.`roominfo` where accomodationId = ? and roomNumber = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, accommodationId);
        pstmt.setInt(2, roomNumber);

        res = pstmt.executeQuery();
        res.next();
        System.out.println("roomPrice: "+res.getInt(1));
        return res.getInt(1);
    }
}
