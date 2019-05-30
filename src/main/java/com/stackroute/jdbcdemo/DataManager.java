package com.stackroute.jdbcdemo;

import java.sql.*;

public class DataManager
{
    public void getAllStudents()
    {
        Connection connection = null;
        ResultSet resultSet = null;
        try
        {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root", "Root@123");
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from course");
            resultSet.absolute(4);
            while (resultSet.previous())
            {
                int id = resultSet.getInt(1);
                System.out.println(id);
            }
        }
        catch(ClassNotFoundException cnfException)
        {
            System.out.println("exception thrown"+cnfException.getStackTrace());
        }
        catch(SQLException sqlException)
        {
            System.out.println("exception thrown"+sqlException.getStackTrace());
        }
        finally
        {
            try
            {
                connection.close();
                resultSet.close();
            }
            catch (Exception ex) {
            }
        }
    }
}