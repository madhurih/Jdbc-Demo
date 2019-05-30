package com.stackroute.jdbcdemo;

import java.sql.*;

public class JdbcTransactionDemo
{
    public void getJdbcTransaction()
    {
        Connection connection = null;
        Statement statement = null;
        try
        {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root", "Root@123");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO course VALUES(7, 'cpp', 2");
            statement.executeUpdate("INSERT INTO course VALUES(8, 'os', 4");
            connection.commit();

        }

        catch(SQLException sqlException)
        {
            System.out.println("exception thrown"+sqlException.getStackTrace());
            try {
                connection.rollback();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            try
            {
                connection.close();
                statement.close();
            }
            catch (Exception ex) {
            }
        }

    }

}
