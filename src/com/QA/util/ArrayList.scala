package com.QA.util
import java.lang.RuntimeException
import scala.collection.mutable.Seq

/**
 * @author Ricky Luu
 * Scala ArrayList has a default
 * size of 100
 *
 *
 */
class ArrayList extends Seq[Any]{
  var data = new Array[Object](100)
  var capacity = new Integer(100)
  var num = new Integer(0)
 

  /**
   * Gets the size of the list
   */
  
  def length () :  Int = {
     num
  }

  def apply (idx : Int) : Any ={
    
  }
  def  iterator () : Iterator [Any] ={
    Iterator[Any](10)
  }
  
 override def  size():  Int = {
     num
  }
 
 def update(idx : Int, elem: Any ){
   
 }
 

 

  def toJavaArrayList()  ={
    val list = new java.util.ArrayList [Object]()
    for(i <- 0 until num){
      list.add(get(i))
    }
    list
  }
  
  
  /**
   * Returns the element at the specified position in this list.
   *
   * @return the element at the specified position in this list
   * @throws index out of bounds
   */

  def get(i: Integer): Object = {
    if (i < 0 || i > num) {
      throw new RuntimeException("index out of bounds")
    }
    data(i)
  }
  /**
   * Adds Any element into the List
   * if the number objects added
   * exceeds the capacity a new
   * list is created adding 10 to the
   * size
   */

  def add(obj: Object) {
    if (num == capacity) {
      capacity = new Integer(capacity.+(10))
      var datanew = new Array[Object](capacity)
      loop(0,num)
      def loop ( start: Int, num : Int){
        if(start < num){
          
          datanew(start) = data(start)
          loop(start.+(1),num)
        }
      }
      data = datanew
    }
    data(num) = obj
    num+=1
  }
}