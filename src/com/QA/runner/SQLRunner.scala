package com.QA.runner

import com.QA.implementatons.SQLImpl
import com.QA.util.ArrayList

/**
 * @author rluu
 */
trait SQLRunner extends SQLImpl {
  def findAllSQL(statement : String) : ArrayList ={
   val rs = this.statement.createStatement().executeQuery(statement)
   while(rs.next()){
     
   }
   
  }
  def insertSQL(statement : String)
  def updateSQL(statement : String)
  def deleteSQL(statement : String)
  
  
}