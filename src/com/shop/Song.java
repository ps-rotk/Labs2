package com.shop;

public class Song {
    private int idSong;
    private String nameSong;
    private int duration; //TODO: тип ниоч

    public Song() {
    }

    public Song(String nameSong, int duration) {
        this.nameSong = nameSong;
        this.duration = duration;
    }

    public Song(int idSong, String nameSong, int duration) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.duration = duration;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
