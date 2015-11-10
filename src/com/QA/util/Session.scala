package com.QA.util

/**
 * @author rluu
 */
object Session  {
  
  var session : Int = 0;
  
  def setSession (id : Int){
    session = id;
  }
  
  def closeSession(){
    session  = 0
  }
  
  def getSession() = {
    session
  }
  
 
  
}