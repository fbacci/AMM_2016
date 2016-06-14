/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneEcommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Buyer", urlPatterns = {"/cliente.html"})
public class Buyer extends HttpServlet {

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
        
        if(request.getParameter("conferma") != null){
                String title = request.getParameter("titolo");
                int objprice = Integer.parseInt(request.getParameter("objprice"));
                
                int idobj = OggettiFactory.getInstance().getObjIdbyTitolo(title);
                
                int idcl = UtentiFactory.getInstance().getIdClbyAcquisto(idobj);
                int idv = UtentiFactory.getInstance().getIdVbyAcquisto(idobj);
                
            try {
                Boolean ok = OggettiFactory.getInstance().compraVendita(title, objprice, idcl, idv);
            } catch (SQLException ex) {
                Logger.getLogger(Buyer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
                if(request.getParameter("compra") != null){
                    String obj = request.getParameter("obj");

                    ArrayList<Oggetto> listaOggetti = OggettiFactory.getInstance().getObjectList();
                    for(Oggetto o : listaOggetti){
                        if(o.getTitolo().equals(obj)){
                            request.setAttribute("titolo", o.titolo);
                            request.setAttribute("prezzo", o.prezzo);  
                            request.setAttribute("quantita", o.quantita); 
                            request.setAttribute("categoria", o.categoria); 
                        }
                    }
                    request.getRequestDispatcher("acquisto.jsp").forward(request,response);
                } else {
                        if(session.getAttribute("isLogged").equals(true)){
                            if(session.getAttribute("tipo").equals("cliente")){
                                ArrayList<Oggetto> listaOggetti = OggettiFactory.getInstance().getObjectList();
                                request.setAttribute("oggetti", listaOggetti);
                                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                            } else {
                                request.getRequestDispatcher("accessonegato.jsp").forward(request, response);
                            }
                       } else {
                            request.getRequestDispatcher("accessonegato.jsp").forward(request, response);
                       }
                }
        }
        
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
