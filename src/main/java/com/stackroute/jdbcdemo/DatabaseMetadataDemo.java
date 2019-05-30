package com.stackroute.jdbcdemo;

import java.sql.*;

public class DatabaseMetadataDemo
{
    public void getDatabaseMetaData()
    {
        Connection connection = null;
        try
        {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root", "Root@123");
            DatabaseMetaData dbmd = connection.getMetaData();

            if (dbmd != null)
            {
                System.out.println("Database Version: " +dbmd.getDatabaseProductVersion());
                System.out.println("Driver Name: " +dbmd.getDriverName());
                System.out.println("Driver Version: " +dbmd.getDriverVersion());
                System.out.println("URL: " +dbmd.getURL());
                System.out.println("User Name: " +dbmd.getUserName());
                System.out.println((dbmd.supportsANSI92FullSQL() ? "ANSI92FullSQL supported." : "ANSI92FullSQL not supported."));
                System.out.println((dbmd.supportsTransactions() ? "Transaction supported." : "Transaction not supported."));
            }
            else
                {
                System.out.println("Metadata not supported");
            }
        }
        catch(ClassNotFoundException cnfException)
        {
            System.out.println("exception thrown" + cnfException.getStackTrace());
        }
        catch(SQLException sqlException)
        {
            System.out.println("exception thrown" + sqlException.getStackTrace());
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