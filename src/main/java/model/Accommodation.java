/*
작성 일자: 2020.05.26
작성자: 김해준
내용: Accommodation 숙박시설 정보 내 필요 속성
산출물 기준: CD-101
*/
package model;

public class Accommodation {

    private int id;
    private String name;
    private int roomNumber;
    private int roomPrice;
    private int capacity;
    private String usableDate;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getUsableDate() {
        return usableDate;
    }

    public void setUsableDate(String usableDate) {
        this.usableDate = usableDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
