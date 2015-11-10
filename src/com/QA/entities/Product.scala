

package com.QA.entities


/**
 * @author rluu
 */
class Product(id: Integer , name : String , price : Integer) extends Entity {
  

  
  
  def this () = this (0 ,null , 0)
  
  def getID(): Integer ={
    id
  }
  
  def getName(): String = {
    name
  }
  
  def getPrice(): Integer ={
    price
  }
 
 override def toString () : String = {
     "product id :"+id+" product name: "+name+" product price : "+price
  }
  

}