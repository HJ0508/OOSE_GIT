package OOSE.db;

import OOSE.model.AccommodationPayment;
import OOSE.model.Member;
import OOSE.model.Accommodation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class AccommodationPaymentDBManager extends DBConnector{
    private int autority = 3;


    public boolean registerAccommodationPayment(AccommodationPayment accommodationPayment){
        try
        {
            String query = "INSERT INTO oose.accommodationpayment (paymentId,userId,accommodationId,totalPeople,money,paymentWay,refund,division,paidDate) VALUES (?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,accommodationPayment.getPaymentId());
            pstmt.setString(2,accommodationPayment.getUserId());
            pstmt.setInt(3,accommodationPayment.getAccommodationId());
            pstmt.setInt(4,accommodationPayment.getTotalPeople());
            pstmt.setInt(5,accommodationPayment.getMoney());
            pstmt.setString(6,accommodationPayment.getPaymentWay());
            pstmt.setString(7,accommodationPayment.getRefund());
            pstmt.setInt(8,accommodationPayment.getDivision());
            pstmt.setString(9,accommodationPayment.getPaidDate());
            pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("error");
            return false;
        }
        return true;
    }
    public boolean checkDuplicationInfo(String id)
    {
        try {
            String query = "select paymentId from oose.accommodationPayment where paymentId=?";
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, id);
            res = pstmt.executeQuery();

            while (res.next())
            {
                if(res.getString("paymentId").equals(id))
                    return true;       //중복 있음
            }
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return true;
        }
        return false;        //중복 없음
    }

    public boolean modifyAccommodationPayment(AccommodationPayment accommodationPayment){
        try{
            String query = "UPDATE oose.accommodationpayment SET userId=?,accommodationId=?,totalPeople=?,money = ?, paymentWay = ?, refund = ?, division = ?,paidDate = ? WHERE paymentId = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,accommodationPayment.getUserId());
            pstmt.setInt(2,accommodationPayment.getAccommodationId());
            pstmt.setInt(3,accommodationPayment.getTotalPeople());
            pstmt.setInt(4,accommodationPayment.getMoney());
            pstmt.setString(5,accommodationPayment.getPaymentWay());
            pstmt.setString(6,accommodationPayment.getRefund());
            pstmt.setInt(7,accommodationPayment.getDivision());
            pstmt.setString(8,accommodationPayment.getPaidDate());
            pstmt.setInt(9,accommodationPayment.getPaymentId());
            if(pstmt.executeUpdate()!=0)
                return true;        //성공
            else
                return false;
        }catch (SQLException e){
            e.getStackTrace();
            System.out.println("수정에러");
            return false;
        }
    }
    public boolean modifyRefund(AccommodationPayment accommodationPayment){
        try{
            String query = "UPDATE oose.accommodationpayment SET userId=?,money = ?, paymentWay = ?, refund = ?, division = ? WHERE paymentId = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,accommodationPayment.getUserId());
            pstmt.setInt(2,accommodationPayment.getMoney());
            pstmt.setString(3,accommodationPayment.getPaymentWay());
            pstmt.setString(4,accommodationPayment.getRefund());
            pstmt.setInt(5,accommodationPayment.getDivision());
            pstmt.setInt(6,accommodationPayment.getPaymentId());
            if(pstmt.executeUpdate()!=0)
                return true;        //성공
            else
                return false;
        }catch (SQLException e){
            e.getStackTrace();
            System.out.println("수정에러");
            return false;
        }
    }
    public boolean deleteAccommodationPayment(String id) {
        try
        {
            String query = "DELETE FROM oose.accommodationpayment WHERE userId = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,id);
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
    public boolean deleteRefund(String re) {
        try
        {
            String query = "DELETE FROM oose.accommodationpayment WHERE refund = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,re);
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
    public ArrayList<AccommodationPayment> browseAccommodationPaymentList()
    {
        try
        {
            String query="SELECT * FROM oose.accommodationpayment";
            pstmt = conn.prepareStatement(query);
            res = pstmt.executeQuery();

            ArrayList<AccommodationPayment> list=new ArrayList<AccommodationPayment>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                AccommodationPayment a=new AccommodationPayment();

                a.setPaymentId(res.getInt("paymentId"));
                a.setUserId(res.getString("userId"));
                a.setAccommodationId(res.getInt("accommodationId"));
                a.setTotalPeople(res.getInt("totalPeople"));
                a.setMoney(res.getInt("money"));
                a.setPaymentWay(res.getString("paymentWay"));
                a.setRefund(res.getString("refund"));
                a.setDivision(res.getInt("division"));
                a.setPaidDate(res.getString("paidDate"));

                list.add(a);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("error");
            return null;
        }
    }

}