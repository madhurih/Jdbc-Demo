package com.stackroute.jdbcdemo;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowsetDemo
{
    public void getAllCourse()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating and Executing RowSet
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/studentInfo","root","Root@123");
            // Creating statement
            statement = connection.createStatement();
            // Executing query
            resultSet = statement.executeQuery("select * from course");

            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(resultSet);
            while (rowSet.next())
            {
                int id = rowSet.getInt(1);
                System.out.print(id);
                String name=rowSet.getString(2);
                System.out.print(" "+name);
                int duration=rowSet.getInt(3);
                System.out.print(" "+duration);
                System.out.println("");
            }
        }
        catch(ClassNotFoundException classNotFound)
        {
            System.out.println("Exception thrown1:"+classNotFound.getStackTrace());
        }
        catch (SQLException sqlException)
        {
            System.out.println("Exception thrown2:"+sqlException.getStackTrace());
        }
        finally
        {
            try
            {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
            }
            catch (Exception ex) {
            }
        }
    }

    public void getCourseByName(String courseName)
    {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try
        {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating and Executing RowSet
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/studentInfo","root","Root@123");
            // Creating statement
            preparedStatement = connection.prepareStatement("select * from course where name=?");
            // Executing query
            preparedStatement.setString(1, courseName);
            resultSet=preparedStatement.executeQuery();

            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(resultSet);
            while (rowSet.next())
            {
                int id = rowSet.getInt(1);
                System.out.print(id);
                String name=rowSet.getString(2);
                System.out.print(" "+name);
                int duration=rowSet.getInt(3);
                System.out.print(" "+duration);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        catch (ClassNotFoundException cnfException)
        {
            cnfException.printStackTrace();
        }
        finally
        {
            try {
                connection.close();
                resultSet.close();
                preparedStatement.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getCourseByNameAndDuration(String courseName, int dur)
    {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try
        {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating and Executing RowSet
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/studentInfo","root","Root@123");
            // Creating statement
            preparedStatement = connection.prepareStatement("select * from course where name = ? and duration = ?");
            // Executing query
            preparedStatement.setString(1, courseName);
            preparedStatement.setInt(2, dur);
            resultSet=preparedStatement.executeQuery();

            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(resultSet);
            while (rowSet.next())
            {
                int id = rowSet.getInt(1);
                System.out.print(id);
                String name=rowSet.getString(2);
                System.out.print(" "+name);
                int duration=rowSet.getInt(3);
                System.out.print(" "+duration);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        catch (ClassNotFoundException cnfException)
        {
            cnfException.printStackTrace();
        }
        finally
        {
            try {
                connection.close();
                resultSet.close();
                preparedStatement.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
