package com.example.lab07.Daos;

import com.example.lab07.Beans.Bactor;
import com.example.lab07.Beans.Bcategory;
import com.example.lab07.Beans.Bfilm;

import java.sql.*;
import java.util.ArrayList;

public class SakilaDao {
    private String user = "root";
    private String pass = "root";
    private String url = "jdbc:mysql://localhost:3306/sakila";

    public ArrayList<Bactor> listarActor(){
        ArrayList<Bactor> listaActores = new ArrayList<>();

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
                Bactor bActor = new Bactor();

                bActor.setActor_id(rs.getInt(1));
                bActor.setName(rs.getString(2));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  listaActores;
    }
    public ArrayList<Bcategory> listarCategoria(){
        ArrayList<Bcategory> listaCategorias = new ArrayList<>();
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
                Bcategory bCat = new Bcategory();

                bCat.setCantidad(rs.getInt(3));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Bfilm> listarPelicula(){
        ArrayList<Bfilm> listaPeliculas = new ArrayList<>();
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
                Bfilm bFilm = new Bfilm();

                bFilm.setCantidad(rs.getInt(3));
                listaPeliculas.add(bFilm);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
