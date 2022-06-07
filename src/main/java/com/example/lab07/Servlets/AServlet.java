package com.example.lab07.Servlets;

import com.example.lab07.Beans.Bactor;
import com.example.lab07.Beans.Bcategory;
import com.example.lab07.Beans.Bfilm;
import com.example.lab07.Daos.SakilaDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AServlet", value = "/AServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Bactor> listaActores= SakilaDao.listarActor();
        ArrayList<Bcategory> listaCategorias= SakilaDao.listarCategoria();
        ArrayList<Bfilm> listaFilm= SakilaDao.listarPelicula();

        request.setAttribute("listaActores",listaActores);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Admin/administradorListaAD.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
