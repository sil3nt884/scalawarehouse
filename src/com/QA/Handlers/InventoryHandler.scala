package com.QA.Handlers
import com.QA.util.ActionHander
import javafx.event._
import com.QA.entities.Product

/**
 * @author rluu
 */
class InventoryHandler() extends ActionHander {
  
  def handle(event : ActionEvent){
    createDialog()
    addProduct(new Product())
  }
  
  def createDialog( ){
    
  }
  
  
  def addProduct(product : Product){
    
  }
  
}