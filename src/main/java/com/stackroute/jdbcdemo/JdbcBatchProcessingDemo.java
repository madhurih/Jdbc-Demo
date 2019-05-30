package com.stackroute.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchProcessingDemo
{
    public void getJdbcBatchProcessing()
    {
        Connection connection = null;
        try
        {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root", "Root@123");
            Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            statement.addBatch("INSERT INTO course VALUES(4, 'html', 3)");
            statement.addBatch("INSERT INTO course VALUES(5, 'bootstrap', 4)");
            statement.addBatch("INSERT INTO course VALUES(6, 'javascript', 2)");
            statement.executeBatch();
            connection.commit();
        }

        catch(ClassNotFoundException cnfException)
        {
            System.out.println("exception thrown"+cnfException.getStackTrace());
        }
        catch(SQLException sqlException)
        {
            System.out.println("exception thrown"+sqlException.getStackTrace());
        }
        finally {
            try
            {
                connection.close();
            }
            catch (Exception ex) {
            }
        }
    }
}