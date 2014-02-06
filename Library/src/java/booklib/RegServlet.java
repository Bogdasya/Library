package booklib;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

    //DataBaseconnection from Singlton
    DataBaseConnection testCon = DataBaseConnection.getDbCon();
    // parametrs for mail
    final String usermail = "bogdasya93@gmail.com";
    final String password = "1408007Grid$";
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchProviderException, MessagingException, ClassNotFoundException, SQLException 
{
    //NOTE: changing encoding to utf-8 when data transmiss from jsp <<register.jsp>>
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    //get user's parametrs from jsp page 
    String username = request.getParameter("name");
    String patronymic = request.getParameter("patronymic");
    String mail = request.getParameter("mail");
    String login = request.getParameter("login");
    String passwd = request.getParameter("passwd");
    
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try 
    {   
        //NOTE: test driver and insert data into the table (PARAMETR ADMIN IS ALWAYS) and it is only english 
        String insertTable = "INSERT INTO Users (Name, Patronymic, Email, Login, Passwd, AdminRole) VALUES "
                            + "('"+username+"', '"+patronymic+"', '"+mail+"', '"+login+"', "+passwd+", 'admin');";
        testCon.insert(insertTable);
         
        //display  data
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello  "+username+" "+ patronymic+" </title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet RegServlet at " + request.getContextPath() + "</h1>");
        out.println("<p> Your name is "+username+"</p>");
        out.println("<p> Your patronymiic is "+patronymic+"</p>");
        out.println("<p> Your login is "+login+"</p>");
        out.println("<p> Your mail is "+mail+"</p>");
        out.println("<p> Your password is "+passwd+"</p>");
        out.println("</body>");
        out.println("</html>");
        // NOTE: sending mail to user (but only from my own address) via TLS, all setings are in properties
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
        //TODO: I can add link to user's own page in this mail 
        try 
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from-email@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mail));
            message.setSubject("Thank"+username+"for registration");
            message.setText("Dear,"+ username + "\n\n Thank you for registration in my library ");
            Transport.send(message);
            System.out.println("Done");
        }
        catch (MessagingException e)
        {
            throw new RuntimeException(e);
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
    } catch (NoSuchProviderException ex) {
        Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MessagingException ex) {
        Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    } catch (NoSuchProviderException ex) {
        Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MessagingException ex) {
        Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(RegServlet.class.getName()).log(Level.SEVERE, null, ex);
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
