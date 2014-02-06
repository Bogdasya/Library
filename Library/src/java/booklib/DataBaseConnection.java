package booklib;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.DriverManager;
//Singlton pattern here will be connection in the private constructor
public final class DataBaseConnection 
{
    public Connection conn;
    private Statement statement;
    public static DataBaseConnection db;
    
    private DataBaseConnection()
    {
        String url = "jdbc:mysql://127.0.0.1/booklibrary?autoReconnect=true&useUnicode=true&characterEncoding=utf-8";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "1408007";
        
        try
        {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url,userName,password);
        }
        catch (Exception sqle)
        {
            sqle.printStackTrace();
        }
        
    }
    // public method for conection from my classes or servlets
    public static synchronized DataBaseConnection getDbCon()
    {
        if ( db == null )
        {
            db = new DataBaseConnection();
        }
        return db;
 
    }
    
    public ResultSet query(String query) throws SQLException
    {
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    
    public int insert(String insertQuery) throws SQLException 
    {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;
 
    }
    
        
    
}
