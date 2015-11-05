package com.QA.entities

/**
 * @author rluu
 */
trait  Entity {
  
  def getID() : Integer
  def getName(): String
  def getClassName() : String ={
    this.getClass().getSimpleName
  }

  
 
  
}