package com.QA.implementatons
import com.QA.Connectors.DataConfig
import com.QA.util.ArrayList
/**
 * @author rluu
 */
trait SQLImpl {
  
  val statement = new DataConfig ().dataSource().getConnection
  
  def findAllSQL(statement : String) : ArrayList
  def insertSQL(statement : String)
  def updateSQL(statement : String)
  def deleteSQL(statement : String)
 
}