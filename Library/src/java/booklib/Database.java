package booklib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database 
{
    //create connection with MySql and create db "booklibrary"
    private final static String createDatabase = "CREATE DATABASE IF NOT EXISTS booklibrary CHARACTER SET utf8 COLLATE utf8_general_ci";
    //create table Users
    private final static String createTableUsers = "CREATE TABLE IF NOT EXISTS booklibrary.Users ("+
                                                    "idUsers INT NOT NULL AUTO_INCREMENT,"+
                                                    "Name VARCHAR(45) NOT NULL,"+
                                                    "Patronymic VARCHAR(45) NOT NULL,"+
                                                    "Email VARCHAR(45) NOT NULL,"+
                                                    "Login VARCHAR(45) NOT NULL,"+
                                                    "Passwd INT NOT NULL,"+
                                                    "AdminRole VARCHAR(45),"+
                                                    "PRIMARY KEY (idUsers))"+
                                                    "ENGINE = InnoDB DEFAULT CHARSET=utf8;";
    //create table Books
    private final static String createTableBooks = "CREATE TABLE IF NOT EXISTS booklibrary.Books ("+
                                                    "idBooks INT NOT NULL AUTO_INCREMENT,"+
                                                    "BookTitle VARCHAR(45) NOT NULL,"+
                                                    "Author VARCHAR(45) NOT NULL,"+
                                                    "Genry VARCHAR(45) NOT NULL,"+
                                                    "ISDN INT NOT NULL,"+
                                                    "NumPage VARCHAR(45) NOT NULL,"+
                                                    "Owner INT NOT NULL,"+
                                                    "PRIMARY KEY (idBooks),"+
                                                    "FOREIGN KEY (Owner) REFERENCES Users (idUsers))"+
                                                    "ENGINE = InnoDB DEFAULT CHARSET=utf8;";
    public static void main(String[] args) 
    {
        Connection connection = null;
        Statement statement = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/mysql";
            connection = DriverManager.getConnection(url, "root", "1408007");
            statement = connection.createStatement();
            //NOTE: changing encoding my database (latin1 --> utf8)
            statement.execute("set character_set_client='utf8';");
            statement.execute("set character_set_server='utf8';");
            statement.execute("set character_set_database='utf8';");
            statement.execute("set character_set_connection='utf8';");
            statement.execute("set character_set_results='utf8';");
            statement.executeUpdate(createDatabase);
            statement.executeUpdate(createTableUsers);
            statement.executeUpdate(createTableBooks);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

