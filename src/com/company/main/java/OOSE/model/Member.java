/*
작성 일자: 2020.05.26
작성자: 김해준
내용: Member 회원 정보 내 필요 속성
산출물 기준: CD-101
*/
package Model;

public class Member {
    private String id;
    private String name;
    private String password;
    private int authority;
    private String phoneNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
