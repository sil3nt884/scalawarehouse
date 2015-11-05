package com.QA.implementatons
import com.QA.Connectors.DataConfig
import com.QA.util.ArrayList
/**
 * @author rluu
 */
trait SQImpl {
  
  val statement = new DataConfig ().dataSource().getConnection.createStatement()
  
  def findAll(obj : Any) : ArrayList
  def insert(statement : String)
  def update(statement : String)
  def delete(statement : String)
    
  
  
}