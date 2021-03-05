package com.shop;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
    private Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public String addSong(Song song) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO public.song (idSong, nameSong, duration) values (?, ?, ?)");
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
                    .prepareStatement("INSERT INTO public.albom (idAlbom, nameAlbom, style) values (?, ?, ?)");
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

    public String addSingler(Singler singler) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO public.song (idSingler, name) values (?, ?)");
            preparedStatement.setInt(1, singler.getIdSingler());
            preparedStatement.setString(2, singler.getName());
            preparedStatement.execute();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String deleteSong(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from public.Song where idSong=?");
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
            PreparedStatement preparedStatement = connection.prepareStatement("delete from public.Albom where idAlbom=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String deleteSingler(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from public.Singler where idSingler=?");
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
                    .prepareStatement("update Song set nameSong = ?, duration = ? where idSong = ?");
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
                    .prepareStatement("update Albom set nameAlbom = ?, style = ? where idAlbom = ?");
            preparedStatement.setString(1, albom.getNameAlbom());
            preparedStatement.setString(2, albom.getStyle());
            preparedStatement.execute();
            return "Успешно";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка";
        }
    }

    public String updateSingler(Singler singler) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update Singler set name = ? where idSingler = ?");
            preparedStatement.setString(1, singler.getName());
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
            ResultSet rs = statement.executeQuery("select * from Song");
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
            ResultSet rs = statement.executeQuery("select * from Albom");
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

    public ArrayList<Singler> getAllSingler() {
        ArrayList<Singler> singlers = new ArrayList<Singler>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Singler");
            while (rs.next()) {
                Singler singler = new Singler();
                singler.setIdSingler(rs.getInt(1));
                singler.setName(rs.getString(2));
                singlers.add(singler);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return singlers;
    }


}
