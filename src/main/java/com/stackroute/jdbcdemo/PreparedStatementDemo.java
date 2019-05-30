package com.stackroute.jdbcdemo;

import java.sql.*;

public class PreparedStatementDemo
{
    public void getCourseByName(String courseName)
    {
       //insted of closing the connection and prepared statement objects manually, we can declare them in try block like below...
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root", "Root@123");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from course where name=?"))
        {

            Class.forName("com.mysql.cj.jdbc.Driver");
            preparedStatement.setString(1, courseName);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int duration = resultSet.getInt(3);
                System.out.println(id + " " + name + " " + duration);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        catch (ClassNotFoundException cnfException)
        {
            cnfException.printStackTrace();
        }
    }
}

