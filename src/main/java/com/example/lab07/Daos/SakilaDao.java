package com.example.lab07.Daos;

import java.sql.*;
import java.util.ArrayList;

public class SakilaDao {
    private String user = "root";
    private String pass = "root";
    private String url = "jdbc:mysql://localhost:3306/sakila";

    public ArrayList<BActor> listarActor(){
        ArrayList<BActor> listaActores = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select a.actor_id, concat(upper(first_name), \" \", upper(last_name)) as 'Nombre', count(name) as 'N° categorias'\n" +
                     "from actor a, film_actor fa, film f, film_category fc, category c\n" +
                     "where a.actor_id = fa.actor_id and fa.film_id = f.film_id and f.film_id = fc.film_id and fc.category_id = c.category_id\n" +
                     "group by a.actor_id having count(*) >12");){

            while (rs.next()) {
                BActor bActor = new BActor();

                bActor.setIdActor(rs.getInt(1));
                bActor.setName(rs.getString(2));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  listaClientes;
    }
    public ArrayList<BCategory> listarCategoria(){
        ArrayList<BCategory> listaCategorias = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select a.actor_id, concat(upper(first_name), \" \", upper(last_name)) as 'Nombre', count(name) as 'N° categorias'\n" +
                     "from actor a, film_actor fa, film f, film_category fc, category c\n" +
                     "where a.actor_id = fa.actor_id and fa.film_id = f.film_id and f.film_id = fc.film_id and fc.category_id = c.category_id\n" +
                     "group by a.actor_id having count(*) >12");){

            while (rs.next()) {
                BCategory bCat = new BCategory();

                bCat.setCantidad(rs.getInt(3));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<BFilm> listarPelicula(){
        ArrayList<BFilm> listaPeliculas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select a.actor_id, concat(upper(first_name), \" \", upper(last_name)) as 'Nombre', count(name) as 'N° categorias'\n" +
                     "from actor a, film_actor fa, film f, film_category fc, category c\n" +
                     "where a.actor_id = fa.actor_id and fa.film_id = f.film_id and f.film_id = fc.film_id and fc.category_id = c.category_id\n" +
                     "group by a.actor_id having count(*) >12");){

            while (rs.next()) {
                BFilm bFilm = new BFilm();

                bFilm.setCantidad(rs.getInt(3));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
