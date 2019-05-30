package com.stackroute.jdbcdemo;

import java.sql.*;

public class ResultSetMetaDataDemo
{
    public void getResultSetMetaData()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root", "Root@123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from course");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            if (resultSetMetaData != null)
            {
                int cols = resultSetMetaData.getColumnCount();
                System.out.println("Number of Columns: " + cols);
                System.out.println("Table Name: " +resultSetMetaData.getTableName(1));
                System.out.println("Catalog Name: " +resultSetMetaData.getCatalogName(1));
                System.out.println("------------------------------------------");
                for (int i = 1; i <= cols; i++)
                {
                    System.out.println("Class Name: " +resultSetMetaData.getColumnClassName(i));
                    System.out.println("Column Name: " +resultSetMetaData.getColumnName(i));
                    System.out.println("Column Type Name: " +resultSetMetaData.getColumnTypeName(i));
                    System.out.println("--------------------------------------");
                }
            }
            else{
                System.out.println("ResultSetMetadata not supported");
            }
        }
        catch (ClassNotFoundException cnfException)
        {
            System.out.println("exception thrown" + cnfException.getStackTrace());
        }
        catch (SQLException sqlException)
        {
            System.out.println("exception thrown" + sqlException.getStackTrace());
        }
        finally {
            try
            {
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch (Exception ex) {
            }
        }
    }
}