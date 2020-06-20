/*
작성 일자: 2020.05.26
작성자: 김해준
내용: Reservation 예약 시 필요 속성
산출물 기준: CD-102
*/
package OOSE.model;

public class Reservation {

    private int reservation;
    private int accommodationId;
    private int roomNumber;
    private String userId;
    private String phoneNum;
    private String carNumber;
    private String checkInDate;
    private String checkOutDate;
    private int totalPrice;
    private String reservationCode;
    private int headCount;

    public int getReservation() {
        return reservation;
    }

    public void setReservation(int reservation) {
        this.reservation = reservation;
    }

    public int getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(int accommodationId) {
        this.accommodationId = accommodationId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public int getHeadCount() {
        return headCount;
    }

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public Reservation(int reservation, int accommodationId, int roomNumber, String userId, String phoneNum, String carNumber, String checkInDate, String checkOutDate, int totalPrice, String reservationCode, int headCount) {
        this.reservation = reservation;
        this.accommodationId = accommodationId;
        this.roomNumber = roomNumber;
        this.userId = userId;
        this.phoneNum = phoneNum;
        this.carNumber = carNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.reservationCode = reservationCode;
        this.headCount = headCount;
    }
}
