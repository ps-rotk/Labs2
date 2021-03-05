package com.shop;

public class Albom {
    private int idAlbom;
    private String nameAlbom;
    private String style;

    public Albom() {
    }

    public Albom(String nameAlbom, String style) {
        this.nameAlbom = nameAlbom;
        this.style = style;
    }

    public Albom(int idAlbom, String nameAlbom, String style) {
        this.idAlbom = idAlbom;
        this.nameAlbom = nameAlbom;
        this.style = style;
    }

    public int getIdAlbom() {
        return idAlbom;
    }

    public void setIdAlbom(int idAlbom) {
        this.idAlbom = idAlbom;
    }

    public String getNameAlbom() {
        return nameAlbom;
    }

    public void setNameAlbom(String nameAlbom) {
        this.nameAlbom = nameAlbom;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
