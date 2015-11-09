


package com.QA.Connectors

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import com.mongodb.MongoClient  



/**
 * @author rluu
 */

class DataConfig {
  
  /**
   * Sets up the connection to the SQL database
   * 
   * @returns DataSource
   */
  
 def  dataSource():  DataSource ={
      val dataSource  = new MysqlDataSource() 
        dataSource.setDatabaseName("mydb");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("localhost");
        dataSource
 }
 
 /**
  * Connects to a Mongo database
  */
 
 def MongoClient() :MongoClient ={
   new MongoClient("localhost");
 }
 
 
}