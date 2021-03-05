package com.shop;

public class Singler {
    private int idSingler;
    private String name;

    public Singler(){
    }

    public Singler( int idSingler, String name){
        this.idSingler = idSingler;
        this.name = name;
    }

    public Singler(String name){
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

