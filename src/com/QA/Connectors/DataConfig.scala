


package com.QA.Connectors

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import com.mongodb.MongoClient  



/**
 * @author rluu
 */

class DataConfig {
  
 def  dataSource():  DataSource ={
      val dataSource  = new MysqlDataSource() 
        dataSource.setDatabaseName("mydb");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("10.50.15.3");
        dataSource
 }
 
 def MongoClient() :MongoClient ={
   new MongoClient("10.50.15.3");
 }
 
 
}