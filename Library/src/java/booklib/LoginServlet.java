package booklib;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet 
{
        
    DataBaseConnection testCon = DataBaseConnection.getDbCon();
    RequestDispatcher dispatcher;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException 
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //get user's parametrs from jsp page 
        String login = request.getParameter("name");
        String passwd = request.getParameter("Password");
        
        //Http Session test
        HttpSession session = request.getSession();
        session.setAttribute("userName", login);
        String id = session.getId();
        //Testing session
        System.out.println(id);
        
        
        PrintWriter out = response.getWriter();
        
        try 
        {
            
            //select User 
            String selectFromTable = "SELECT * FROM Users WHERE Login = '"+login+"' AND Passwd = '"+passwd+"'"; 
            ResultSet result = testCon.query(selectFromTable);
                       
            if (result.next() == false)
            {
                dispatcher = getServletContext().getRequestDispatcher("/BadPage.jsp");
                dispatcher.forward(request, response); 
            }
            else 
            {
                String user = result.getString("Login");
                String adres = result.getString("Email");
                int password = result.getInt("Passwd");
                String name = result.getString("Name");
                int idPerson = result.getInt("idUsers");
                //Save ID person in session
                session.setAttribute("ID", idPerson);
                
                System.out.println(idPerson);
                
                request.setAttribute("Name", name );
                request.setAttribute("Passwd", password );
                request.setAttribute("Email", adres );
                request.setAttribute("User", user);
                dispatcher = getServletContext().getRequestDispatcher("/PrivateRoom.jsp");
                dispatcher.forward(request, response);
            }
                
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
