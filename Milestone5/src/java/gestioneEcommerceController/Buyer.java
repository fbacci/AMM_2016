/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneEcommerceController;

import gestioneEcommerceModel.OggettiFactory;
import gestioneEcommerceModel.Oggetto;
import gestioneEcommerceModel.UtentiFactory;
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

        if((request.getParameter("conferma") == null) && (request.getParameter("compra") == null)){
            if(session.getAttribute("tipo").equals("cliente")){
                ArrayList<Oggetto> listaOggetti = OggettiFactory.getInstance().getObjectList();
                request.setAttribute("oggetti", listaOggetti);
                session.setAttribute("accesso","Ok");
            } else {
                session.setAttribute("accesso","No");
            }
        }        
        
        if(request.getParameter("conferma") != null){
            
                Boolean ok = false;
            
                String title = request.getParameter("objtitle");
                int objprice = Integer.parseInt(request.getParameter("objprice"));
                
                // ID CLIENTE
                int idcl = (Integer) session.getAttribute("id");
                // SALDO CLIENTE
                int saldo = UtentiFactory.getInstance().getSaldoCliente(idcl);
                
                // ID OGGETTO
                int idobj = OggettiFactory.getInstance().getObjIdbyTitolo(title);
                
                // ID VENDITORE
                int idv = UtentiFactory.getInstance().getIdVbyObj(idobj);
            
            if(saldo > objprice){                
                try {
                    ok = OggettiFactory.getInstance().compraVendita(title, objprice, idcl, idv);
                    session.setAttribute("esito","good");
                    session.setAttribute("accesso",null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                    session.setAttribute("esito","notgood");
                    session.setAttribute("accesso",null);
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
                    
                    session.setAttribute("accesso","buying");
                } 
        }

        request.getRequestDispatcher("cliente.jsp").forward(request,response);        
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
