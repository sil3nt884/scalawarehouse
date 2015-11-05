package com.QA.runner

import com.QA.implementatons.SQLImpl
import java.sql.ResultSet

/**
 * @author rluu
 */
trait SQLRunner extends SQLImpl {
  def findAllSQL(statement : String) : ResultSet ={
     this.statement.createStatement().executeQuery(statement)
  }
  
  def insertSQL(statement : String){
     this.statement.createStatement().execute(statement)
  }
  def updateSQL(statement : String){
     this.statement.createStatement().executeUpdate(statement)
  }
  def deleteSQL(statement : String){
    this.statement.createStatement().executeUpdate(statement)
  }
  
}