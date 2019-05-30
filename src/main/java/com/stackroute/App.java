package com.stackroute;

import com.stackroute.jdbcdemo.*;

public class App 
{
    public static void main( String[] args )
    {
        DataManager dataManager = new DataManager();
        dataManager.getAllStudents();

        DatabaseMetadataDemo databaseMetadataDemo = new DatabaseMetadataDemo();
        databaseMetadataDemo.getDatabaseMetaData();

        ResultSetMetaDataDemo resultSetMetaDataDemo = new ResultSetMetaDataDemo();
        resultSetMetaDataDemo.getResultSetMetaData();

        JdbcBatchProcessingDemo jdbcBatchProcessingDemo = new JdbcBatchProcessingDemo();
        jdbcBatchProcessingDemo.getJdbcBatchProcessing();

        JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
        jdbcTransactionDemo.getJdbcTransaction();

        PreparedStatementDemo preparedStatementDemo = new PreparedStatementDemo();
        preparedStatementDemo.getCourseByName("spring");

        RowsetDemo rowsetDemo = new RowsetDemo();
        rowsetDemo.getAllCourse();
        rowsetDemo.getCourseByName("core java");
        rowsetDemo.getCourseByNameAndDuration("core java", 2);
    }
}