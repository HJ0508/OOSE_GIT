/*
작성 일자: 2020.05.26
작성자: 김해준
내용: Reservation
산출물 기준: CD-102
*/
package OOSE.db;

import OOSE.model.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ReservationDBManager extends DBConnector {
    private String query;

    private int authority;

    public Reservation[] browseReservation(String keyword, int option) throws SQLException {
        query = "SELECT oose.reservation.*, oose.member.phoneNumber FROM oose.reservation, oose.member ";

        String condition1 = "where userId=(select memberId from oose.member where memberName = ?) ";
        String condition2 = "where accommodationId=(select accommodationId from oose.accommodation where accommodationName = ?) ";

        if (option == 1) query += condition1; // according to option
        else if(option == 2) query += condition2;

        query += "group by reservationId";
        System.out.println(query);
        pstmt = conn.prepareStatement(query);
        if(option!=0) pstmt.setString(1, keyword);

        res = pstmt.executeQuery();
        Vector<Reservation> data = new Vector<>();
        int i=0;
        while(res.next()){
            data.add(new Reservation(res.getInt(1), res.getInt(2), res.getInt(4),
                    res.getString(3), res.getString(11), res.getString(5), res.getString(6),
                    res.getString(7), res.getInt(8), res.getString(9),
                    res.getInt(10)));
        }
        return data.toArray(new Reservation[data.size()]);

    }
    public boolean registerReservation(Reservation reservation) {
        try {
            query = "INSERT INTO oose.reservation ( `accommodationId`,`userId`,`roomNumber`,`carNumber`,`checkInDate`,`checkOutDate`,`totalPrice`,`reservationCode`,`headCount`)VALUES (?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, reservation.getAccommodationId());
            pstmt.setString(2, reservation.getUserId());
            pstmt.setString(3, Integer.toString(reservation.getRoomNumber()));
            pstmt.setString(4, reservation.getCarNumber());
            pstmt.setString(5, reservation.getCheckInDate());
            pstmt.setString(6, reservation.getCheckOutDate());
            pstmt.setInt(7, reservation.getTotalPrice());
            pstmt.setString(8, reservation.getReservationCode());
            pstmt.setInt(9, reservation.getHeadCount());
            int tmp = pstmt.executeUpdate();
            if (tmp != 0) return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean modifyReservation(Reservation reservation) throws SQLException{

        query = "UPDATE `oose`.`reservation` SET `reservationId` = ?, `accommodationId` = ?, `userId` = ?, `roomNumber` = ?, `carNumber` = ?, `checkInDate` = ?, `checkOutDate` = ?, `totalPrice` = ?, `reservationCode` = ?, `headCount` = ? WHERE `reservationId` = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, reservation.getReservation());
        pstmt.setInt(2, reservation.getAccommodationId());
        pstmt.setString(3, reservation.getUserId());
        pstmt.setString(4, Integer.toString(reservation.getRoomNumber()));
        pstmt.setString(5, reservation.getCarNumber());
        pstmt.setString(6, reservation.getCheckInDate());
        pstmt.setString(7, reservation.getCheckOutDate());
        pstmt.setInt(8, reservation.getTotalPrice());
        pstmt.setInt(9, Integer.parseInt(reservation.getReservationCode()));
        pstmt.setInt(10, reservation.getHeadCount());
        pstmt.setInt(11, reservation.getReservation());
        int tmp = pstmt.executeUpdate();
        if(tmp!=0) return true;
        return false;
    }
    public boolean deleteReservation(String userId) throws SQLException {
        query = "DELETE FROM `oose`.`reservation` WHERE userId = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, userId);
        return pstmt.executeUpdate()!=0;
    }

    public Reservation[] browseReservationCancel(){
        return null;
    }
    public boolean registerReservationCancle(){
        return false;
    }
    public boolean modifyReservationCancle(){
        return false;
    }
    public boolean deleteReservationCancle(){
        return false;
    }

    public boolean checkAuthority(){ // 구현하지 않음
        return false;
    }

    public boolean checkDuplicatedInfo(){
        return false;
    }
}
