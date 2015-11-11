package com.QA.Handlers
import com.QA.util.ActionHander
import javafx.event.ActionEvent
import java.sql.ResultSet
import com.QA.util.ArrayList
import com.QA.entities.CustomerOrder
import com.QA.util.Session
import javafx.scene.control._
import com.QA.panefx.CustomerOrderPane

/**
 * @author rluu
 */
class CheckoutHandler (id: Integer, item : CustomerOrder, tab : TabPane) extends ActionHander {
  val result = findAllSQL("Select * from inventory")
  val list : ArrayList = new ArrayList()
  
  
  def handle(event: ActionEvent){
    updateDatabase("Update customerorder , orders set Status=3, EmplyoeeID=" + Session.getSession() + " Where (CustomerID=" + item.getCustomerID + " and orders.ProductID=" + item.getProductID + " and Date='" + item.getDate + "');")
    checkDatabase(result.next(), result)
    tab.getTabs.remove(1)
        val tabs = new Tab("Customer Order")
        tabs.setContent(new CustomerOrderPane(tab))
        tabs.setClosable(false)
        tab.getTabs.add(1, tabs)
  }
  
  def checkDatabase(check: Boolean, rs: ResultSet){
    if(check){
      if(id==rs.getInt(1)){
        list.add(rs.getString(4))
      }
      checkDatabase(rs.next(), rs)
    }
  }
  
  
  def travelingSalesmen(){
    
  }
  
  
   def updateDatabase(statement: String) {
    updateSQL(statement)
  }
  
}


