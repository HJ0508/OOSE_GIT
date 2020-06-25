/*
작성 일자: 2020.05.26
작성자: 김해준
내용: workplace 사업장 및 사업장 필요 속성
산출물 기준: CD-2501
*/
package OOSE.Model;

public class Workplace {
    private int id;
    private String name;
    private String manager;
    private String address;
    private String phoneNumber;
    private String status;
    private int fee;
    private String openingTime;
    private String closingTime;
    private int square;
    private String otherInfo;

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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Workplace(int id, String name, String manager, String address, String phoneNumber, String status, int fee, String openingTime, String closingTime, int square, String otherInfo) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.fee = fee;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.square = square;
        this.otherInfo = otherInfo;
    }

    public Workplace() {
    }
}
