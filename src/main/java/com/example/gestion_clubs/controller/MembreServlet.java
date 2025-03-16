package com.example.gestion_clubs.controller;

import com.example.gestion_clubs.dao.MembreDAO;
import com.example.gestion_clubs.model.Membre;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/MembreServlet")
public class MembreServlet extends HttpServlet {

    private MembreDAO membreDAO = new MembreDAO();

    public MembreServlet() throws SQLException, ClassNotFoundException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String action = request.getParameter("action");
         if ("edit".equals(action)) {
             int id = Integer.parseInt(request.getParameter("id_membre"));
             Membre membre = membreDAO.findById(id);
             request.setAttribute("membre", membre);
          request.getRequestDispatcher("membreedit.jsp").forward(request, response);

         }else if ("delete".equals(action)) {
             int id = Integer.parseInt(request.getParameter("id_membre"));
              membreDAO.delete(id);
              response.sendRedirect("/MembreServlet");

            }else {
             List<Membre> membrelist = membreDAO.findAll();
             request.setAttribute("membrelist", membrelist);
             request.getRequestDispatcher("MembreList.jsp").forward(request, response);
         }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

         if ("edit".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id_membre"));
            String nom_membre= request.getParameter("nom_membre");
            String sport_pratiquee = request.getParameter("sport_pratiquee");
            Membre membre = new Membre(id,nom_membre, sport_pratiquee);
            membre.setId(id);
            membreDAO.update(membre);

        }else{
             String nom_membre= request.getParameter("nom_membre");
             String sport_pratiquee = request.getParameter("sport_pratiquee");
             Membre membre =new Membre(nom_membre,sport_pratiquee);
             membreDAO.save(membre);
         }
         response.sendRedirect("/MembreServlet");
    }
}