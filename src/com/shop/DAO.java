package com.shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection connection;

    public DAO() {
        connection = DBUtil.getConnection();
    }

    public String addSong(Song song) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO public.song (id_song, title_song, duration) values (?, ?, ?)");
            preparedStatement.setInt(1, song.getIdSong());
            preparedStatement.setString(2, song.getNameSong());
            preparedStatement.setInt(3, song.getDuration());
            preparedStatement.execute();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String addAlbom(Albom albom) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO public.albom (id_albom, title_albom, genre_albom) values (?, ?, ?)");
            preparedStatement.setInt(1, albom.getIdAlbom());
            preparedStatement.setString(2, albom.getNameAlbom());
            preparedStatement.setString(3, albom.getStyle());
            preparedStatement.execute();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String addSinger(Singer singer) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO public.singer (id_singler, name) values (?, ?)");
            preparedStatement.setInt(1, singer.getIdSingler());
            preparedStatement.setString(2, singer.getName());
            preparedStatement.execute();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String deleteSong(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from public.song where id_song=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String deleteAlbom(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from public.albom where id_albom=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String deleteSinger(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from public.singer where id_singer=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String updateSong(Song song) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update song set title_song = ?, duration = ? where id_song = ?");
            preparedStatement.setString(1, song.getNameSong());
            preparedStatement.setInt(2, song.getDuration());
            preparedStatement.execute();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String updateAlbom(Albom albom) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update albom set title_albom = ?, genre_albom = ? where id_albom = ?");
            preparedStatement.setString(1, albom.getNameAlbom());
            preparedStatement.setString(2, albom.getStyle());
            preparedStatement.execute();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String updateSingler(Singer singer) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update singer set name = ? where id_singler = ?");
            preparedStatement.setString(1, singer.getName());
            preparedStatement.execute();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public ArrayList<Song> getAllSong() {
        ArrayList<Song> songs = new ArrayList<Song>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from song");
            while (rs.next()) {
                Song song = new Song();
                song.setIdSong(rs.getInt(1));
                song.setNameSong(rs.getString(2));
                song.setDuration(rs.getInt(3));
                songs.add(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songs;
    }

    public ArrayList<Albom> getAllAlboms() {
        ArrayList<Albom> alboms = new ArrayList<Albom>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from albom");
            while (rs.next()) {
                Albom albom = new Albom();
                albom.setIdAlbom(rs.getInt(1));
                albom.setNameAlbom(rs.getString(2));
                albom.setStyle(rs.getString(3));
                alboms.add(albom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alboms;
    }

    public ArrayList<Singer> getAllSingler() {
        ArrayList<Singer> singers = new ArrayList<Singer>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from singer");
            while (rs.next()) {
                Singer singer = new Singer();
                singer.setIdSingler(rs.getInt(1));
                singer.setName(rs.getString(2));
                singers.add(singer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return singers;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Song> songs = dao.getAllSong();
        List<Albom> alboms = dao.getAllAlboms();
        List<Singer> singers = dao.getAllSingler();
        /*for (Animal animal : animals) {
            System.out.println(animal);
        }
        for (Employer employer : employers) {
            System.out.println(employer);
        }
        for (Aviary aviary : avians) {
            System.out.println(aviary);
        }*/
    }

}
