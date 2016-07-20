/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneEcommerceController;

import gestioneEcommerceModel.OggettiFactory;
import gestioneEcommerceModel.Oggetto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Francy
 */
@WebServlet(name = "Seller", urlPatterns = {"/venditore.html"})
public class Seller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        
        if(request.getParameter("Invia") == null && request.getParameter("Elimina") == null && request.getParameter("Edit") == null){
            if(session.getAttribute("isLogged").equals(true) && session.getAttribute("tipo").equals("venditore")){
                    session.setAttribute("accesso","Ok");
            } else {
                session.setAttribute("accesso","No");
            }
        }
        
        if(request.getParameter("Invia") != null){
            String titolo = request.getParameter("titolo");
            String categoria = request.getParameter("categoria");
            int prezzo = Integer.parseInt(request.getParameter("prezzo"));
            int quantita = Integer.parseInt(request.getParameter("quantita"));

            Oggetto o = OggettiFactory.getInstance().creaOggetto(titolo, categoria, quantita, prezzo);

            request.setAttribute("titolo", o.titolo);
            request.setAttribute("categoria", o.categoria);
            request.setAttribute("quantita", o.quantita);  
            request.setAttribute("prezzo", o.prezzo);  

            request.getRequestDispatcher("inserimento.jsp").forward(request, response);
        }
        
        if(request.getParameter("Edit") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            String titolo = request.getParameter("titolo");
            String categoria = request.getParameter("categoria");
            int prezzo = Integer.parseInt(request.getParameter("prezzo"));
            int quantita = Integer.parseInt(request.getParameter("quantita"));
                               
            Oggetto o = OggettiFactory.getInstance().modificaOggetto(id, titolo, categoria, prezzo, quantita);
                        
            request.setAttribute("titolo", o.titolo);
            request.setAttribute("categoria", o.categoria);
            request.setAttribute("quantita", o.quantita);  
            request.setAttribute("prezzo", o.prezzo);  

            request.getRequestDispatcher("inserimento.jsp").forward(request, response);             
        }
        
        if(request.getParameter("Elimina") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            OggettiFactory.getInstance().cancellaOggetto(id); 
        }
      
        request.getRequestDispatcher("venditore.jsp").forward(request,response);        
    }
               

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
