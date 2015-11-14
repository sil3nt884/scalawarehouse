package com.QA.Handlers
import com.QA.util.ActionHander
import com.QA.entities.Inventory
import javafx.event.ActionEvent
import java.sql.ResultSet
import com.QA.util.ArrayList
import com.QA.entities.CustomerOrder
import com.QA.util.Session
import javafx.scene.control._
import com.QA.panefx.CustomerOrderPane
import javax.swing.JOptionPane
/**
 * @author rluu
 */
class CheckoutHandler (id: Integer, item : CustomerOrder, tab : TabPane) extends ActionHander {
  val result = findAllSQL("Select * from inventory")
  val list : ArrayList = new ArrayList()
  var picker : Boolean = false
  
  
  def handle(event: ActionEvent){
    updateDatabase("Update customerorder , orders set Status=3, EmplyoeeID=" + Session.getSession() + " Where (CustomerID=" + item.getCustomerID + " and orders.ProductID=" + item.getProductID + " and Date='" + item.getDate + "');")
    checkDatabase(result.next(), result)
   checkPicker(0,list)
   if(picker){
     JOptionPane.showMessageDialog(null, "Picker is needed")
   }else if(!picker){
     JOptionPane.showMessageDialog(null, "Picker is not needed")
   }
   
    tab.getTabs.remove(1)
        val tabs = new Tab("Customer Order")
        tabs.setContent(new CustomerOrderPane(tab))
        tabs.setClosable(false)
        tab.getTabs.add(1, tabs)
  }
  
  def checkDatabase(check: Boolean, rs: ResultSet){
    if(check){
      if(id==rs.getInt(1)){
        list.add(new Inventory(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)))
      }
      checkDatabase(rs.next(), rs)
    }
    
  }
  
  
  def checkPicker(start : Int,list : ArrayList) {
  
    if(start < list.size()){
      list.get(start) match{
        case line : Inventory =>
          if(line.getSize() >= 20){
             picker=true
          }
          else {
            picker=false
          }
      }
   
     checkPicker(start.+(1), list)
    }
  
  }
  
  
   def updateDatabase(statement: String) {
    updateSQL(statement)
  }
  
}


