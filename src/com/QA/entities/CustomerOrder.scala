package com.QA.entities
import java.util.Date
import javafx.beans.property.SimpleStringProperty;

class CustomerOrder(customerid : Integer, ID: Integer, productID: Integer, date: String, quantity: Integer, status: Integer) {
  
  val CustomerID = new SimpleStringProperty(customerid.toString())
  val OrderID = new SimpleStringProperty(ID.toString())
  val ProductID = new SimpleStringProperty(productID.toString())
  val Date = new SimpleStringProperty(date.toString())
  val Quantity = new SimpleStringProperty(quantity.toString())
  val Status = new SimpleStringProperty(status.toString())

  def setCustomerID(id: String){
    CustomerID.set(id)
  }
  
  def setOrderID(id: String){
    OrderID.set(id)
  }
  
  def setProductID(id: String) {
    ProductID.set(id)
  }

  def setDate(date: String) {
    Date.set(date)
  }

  def setQuantity(num: String) {
    Quantity.set(num)
  }

  def setStatus(status: String) {
    Status.set(status)
  }
  
  def getCustomerID : String ={
    CustomerID.get
  }
  
  def getOrderID () : String ={
     OrderID.get()
  }

  def getProductID: String = {
    ProductID.get()

  }
 

  def getDate: String = {
    Date.get()
  }

  def getQuantity(): String = {
    Quantity.get()
  }

  def getStatus: String = {
    Status.get()
  }

}