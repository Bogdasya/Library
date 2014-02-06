 
package booklib;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class RecoveryServlet extends HttpServlet
{
    
    DataBaseConnection testCon = DataBaseConnection.getDbCon();
    // parametrs for mail
    final String usermail = "bogdasya93@gmail.com";
    final String password = "1408007Grid$";
    RequestDispatcher dispatcher;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                                throws ServletException, IOException, ClassNotFoundException, SQLException 
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //get user's mail
        String mail = request.getParameter("mail");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        { 
            //select passwd 
            String selectFromTable = "SELECT Passwd FROM Users WHERE Email = '"+mail+"'"; 
            ResultSet resultset = testCon.query(selectFromTable);
            
            int passwd = 0;
            if (resultset.next()!= false)
            {
                //Retrieve by column name
                passwd = resultset.getInt("Passwd");
                //Display value
                System.out.println("Passwd: " + passwd);
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet RecoveryServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet RecoveryServlet at " + request.getContextPath() + "</h1>");
                out.println("<p> Your mail is "+mail+"</p>");
                out.println("<p> Your passwd is " + passwd+"</p>");
                out.println("</body>");
                out.println("</html>");
                 
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");

                Session session = Session.getInstance(props,new javax.mail.Authenticator() 
                {
                    protected PasswordAuthentication getPasswordAuthentication() 
                    {
                        return new PasswordAuthentication(usermail, password);
                    }
                });
                try 
                {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("from-email@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mail));
                    message.setSubject("Dear user here is your passwd");
                    message.setText("\n\n Your passwd is "+passwd+" ");
                    Transport.send(message);
                    System.out.println("Done");
                }
                catch (MessagingException e)
                {   
                    throw new RuntimeException(e);
                }
                finally 
                {            
                    out.close();
                }
            }
            else 
            {
                dispatcher = getServletContext().getRequestDispatcher("/BadPage.jsp");
                dispatcher.forward(request, response); 
            }
            resultset.close();
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
            Logger.getLogger(RecoveryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RecoveryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RecoveryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RecoveryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
