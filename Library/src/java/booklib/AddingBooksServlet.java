package booklib;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddingBooksServlet extends HttpServlet
{

    DataBaseConnection testCon = DataBaseConnection.getDbCon();
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, ClassNotFoundException, SQLException 
    {   
        //NOTE: Get Id from session This id will be owner of these books
        HttpSession session = request.getSession();
        int UserId =   (Integer) session.getAttribute("ID");
              
        //NOTE: changing encoding to utf-8 when data transmiss from jsp <<register.jsp>>
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //get user's parametrs from jsp page 
        String booktitle = request.getParameter("title");
        String author = request.getParameter("author");
        String Genre = request.getParameter("genre");
        String ISDN = request.getParameter("isdn");
        String NumberOfPages = request.getParameter("num");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {   
            String insertTable = "INSERT INTO Books (BookTitle, Author, Genry, ISDN, NumPage, Owner) VALUES "
                        + "('"+booktitle+"', '"+author+"', '"+Genre+"', '"+ISDN+"', "+NumberOfPages+", "+UserId+");";
            testCon.insert(insertTable);
               
            /*TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddingBooksServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddingBooksServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet AddingBooksServlet at " + booktitle + "</h1>");
            out.println("<h1>Servlet AddingBooksServlet at " + author + "</h1>");
            out.println("<h1>Servlet AddingBooksServlet at " + Genre + "</h1>");
            out.println("<h1>Servlet AddingBooksServlet at " + ISDN + "</h1>");
            out.println("<h1>Servlet AddingBooksServlet at " + NumberOfPages + "</h1>");
            // out.println("<h1>Servlet AddingBooksServlet at " + owner + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
        } 
        finally 
        {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddingBooksServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddingBooksServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddingBooksServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddingBooksServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
