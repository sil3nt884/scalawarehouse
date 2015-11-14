package com.QA.entities
import javafx.beans.property.SimpleStringProperty;

/**
 * @author rluu
 */
class Inventory (productID : Int,  employeeID : Int ,  quantity : Int , location : String , size : Integer) {
  
  val ProductID = new SimpleStringProperty(productID.toString())
  val EmployeeID = new SimpleStringProperty(employeeID.toString())
  val Quantity = new SimpleStringProperty(quantity.toString())
  val Location = new SimpleStringProperty(location)
  
  
  def getSize()={
    size
  }
  
  
   def setProductID(id: String){
    ProductID.set(id)
  }
  
  def setEmployeID(id: String){
    EmployeeID.set(id)
  }
 
 
  def setQuantity(num  : String){
    Quantity.set(num)
  }
  
  def setLocation(location  : String){
    Quantity.set(location)
  }
  
  def getProductID : String ={
    ProductID.get()
    
  }
  
  def getEmployeeID()  : String ={
    EmployeeID.get()
  }
  
  def getQuantity()  : String = {
   Quantity.get()
  }
  
  def getLocation () : String ={
    Location.get()
  }
 
  
}