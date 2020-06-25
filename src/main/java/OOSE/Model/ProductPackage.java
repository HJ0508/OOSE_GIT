/*
작성 일자: 2020.05.26
작성자: 김해준
내용: product package - 상품 패키지 내 필요 속성
산출물 기준: CD-1701
*/
package OOSE.Model;

public class ProductPackage {
    private int id;
    private String name;
    private int price;
    private int stock;
    private String state;
    private String note;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
