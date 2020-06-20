package OOSE.db;

import OOSE.model.AccomodationPayment;
import OOSE.model.Member;
import OOSE.model.Reservation;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class AccomodationPaymentDBManager extends OOSE.db.DBConnector{
    private String query;
    public boolean registerAccomodationPayment(AccomodationPayment accomodationPayment){
        try{
            query = "INSERT INTO oose.ccomodationPayment (paymentID,totalPeople,money,paymentWay,refund,division,paidDate) VALUES (?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,accomodationPayment.getPaymentId());
            pstmt.setInt(2,accomodationPayment.getTotalPeople());
            pstmt.setInt(3,accomodationPayment.getMoney());
            pstmt.setString(4,accomodationPayment.getPaymentWay());
            pstmt.setString(5,accomodationPayment.getRefund());
            pstmt.setInt(6,accomodationPayment.getDivision());
            pstmt.setString(7,accomodationPayment.getPaidDate());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean modifyAccomodationPayment(AccomodationPayment accomodationPayment){
        try{
            query = "UPDATE `oose`.`accomodationPayment` SET `paymentId` = ?, `totalPeople` = ?, `money` = ?, `paymentWay` = ?, `refund` = ?, `division` = ?, `paidDate` = ? WHERE `paymentId` = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,accomodationPayment.getPaymentId());
            pstmt.setInt(2,accomodationPayment.getTotalPeople());
            pstmt.setInt(3,accomodationPayment.getMoney());
            pstmt.setString(4,accomodationPayment.getPaymentWay());
            pstmt.setString(5,accomodationPayment.getRefund());
            pstmt.setInt(6,accomodationPayment.getDivision());
            pstmt.setString(7,accomodationPayment.getPaidDate());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.getStackTrace();
            return false;
        }
    }
    public boolean deleteAccomodationPayment(AccomodationPayment accomodationPayment) throws SQLException {
        try
        {
            String query = "delete from oose.accomodationPayment where paymentId=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, accomodationPayment.getPaymentId());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("error");
            return false;
        }
    }
    public ArrayList<AccomodationPayment> browseAccomodationPaymentList()
    {
        try
        {
            String query="SELECT * from oose.accomodationPayment";
            pstmt=conn.prepareStatement(query);
            res=pstmt.executeQuery();

            ArrayList<AccomodationPayment> list=new ArrayList<AccomodationPayment>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                AccomodationPayment accomodationPayment=new AccomodationPayment();

                accomodationPayment.setPaymentId(res.getInt("paymentId"));
                System.out.println(accomodationPayment.getPaymentId());
                accomodationPayment.setTotalPeople(res.getInt("totalPeople"));
                accomodationPayment.setMoney(res.getInt("money"));
                accomodationPayment.setPaymentWay(res.getString("paymentWay"));
                accomodationPayment.setRefund(res.getString("refund"));
                accomodationPayment.setDivision(res.getInt("division"));
                accomodationPayment.setPaidDate(res.getString("paidDate"));

                list.add(accomodationPayment);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }
}
