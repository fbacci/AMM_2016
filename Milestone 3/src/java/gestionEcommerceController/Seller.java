/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionEcommerceController;

import java.io.IOException;
import java.io.PrintWriter;
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
        
        if(request.getParameter("Invia") == null){
            if(session.getAttribute("isLogged").equals(true) && session.getAttribute("tipo").equals("venditore")){
                    session.setAttribute("accesso","Ok");
            } else {
                session.setAttribute("accesso","No");
            }
        } else {
            String titolo = request.getParameter("nomep");
            String imm = request.getParameter("imm");
            String desc = request.getParameter("desc");
            int prezzo = Integer.parseInt(request.getParameter("prezzo"));
            int quant = Integer.parseInt(request.getParameter("quant"));
            
            request.setAttribute("titolo", titolo);
            request.setAttribute("urlimm", imm);  
            request.setAttribute("descrizione", desc);  
            request.setAttribute("prezzo", prezzo);  
            request.setAttribute("quantita", quant);  
            request.getRequestDispatcher("inserimento.jsp").forward(request, response);
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
