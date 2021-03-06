/*
작성 일자: 2020.05.26
작성자: 김해준
내용: Authority 권한 정보 내 필요 속성
산출물 기준: CD-1201
*/
package OOSE.Model;

public class Authority {
    private int id;
    private String name;
    private String accessRange;

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

    public String getAccessRange() {
        return accessRange;
    }

    public void setAccessRange(String accessRange) {
        this.accessRange = accessRange;
    }

    public Authority(int id, String name, String accessRange) {
        this.id = id;
        this.name = name;
        this.accessRange = accessRange;
    }

    public Authority() { }
}
