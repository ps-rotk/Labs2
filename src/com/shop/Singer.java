package com.shop;

public class Singer {
    private int idSingler;
    private String name;

    public Singer(){
    }

    public Singer(int idSingler, String name){
        this.idSingler = idSingler;
        this.name = name;
    }

    public Singer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdSingler() {
        return idSingler;
    }

    public void setIdSingler(int idSingler) {
        this.idSingler = idSingler;
    }
}

