package OOSE.db;

import OOSE.model.AccomodationPayment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccomodationPaymentDBManager extends OOSE.db.DBConnector{
    private String query;
    boolean registerAccomodationPayment(AccomodationPayment accomodationPayment) throws SQLException{
        query = "INSERT INTO oose.ccomodationPayment VALUES (?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1,accomodationPayment.getPaymentId());
        pstmt.setInt(2,accomodationPayment.getTotalPeople());
        pstmt.setInt(3,accomodationPayment.getMoney());
        pstmt.setString(4,accomodationPayment.getPaymentWay());
        pstmt.setString(5,accomodationPayment.getRefund());
        pstmt.setInt(6,accomodationPayment.getDivision());
        pstmt.setString(7,accomodationPayment.getPaidDate());
        int tmp = pstmt.executeUpdate();
        if(tmp!=0)return true;
        return false;
    }
}
