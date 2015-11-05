package com.QA.implementatons
import com.QA.Connectors.DataConfig
import com.QA.util.ArrayList
/**
 * @author rluu
 */
trait SQImpl {
  
  val statement = new DataConfig ().dataSource().getConnection.createStatement()
  
  def findAllSQL(statement : String) : ArrayList
  def insertSQL(statement : String)
  def updateSQL(statement : String)
  def deleteSQL(statement : String)
 
}