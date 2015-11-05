package com.QA.implementatons
import com.QA.Connectors.DataConfig
import com.QA.util.ArrayList
import java.sql.ResultSet
/**
 * @author rluu
 */
trait SQLImpl {
  
  val statement = new DataConfig ().dataSource().getConnection
  
  def findAllSQL(statement : String) : ResultSet
  def insertSQL(statement : String)
  def updateSQL(statement : String)
  def deleteSQL(statement : String)
 
}