package com.QA.util
import java.lang.RuntimeException

/**
 * @author Ricky Luu
 * Scala ArrayList has a default
 * size of 100
 *
 *
 */
class ArrayList {
  var data = new Array[Any](100)
  var capacity = new Integer(100)
  var num = new Integer(0)

  /**
   * Gets the size of the list
   */

  def size(): Integer = {
    num
  }

  /**
   * Returns the element at the specified position in this list.
   *
   * @return the element at the specified position in this list
   * @throws index out of bounds
   */

  def get(i: Integer): Any = {
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

  def add(obj: Any) {
    if (num == capacity) {
      capacity = new Integer(capacity.+(10))
      var datanew = new Array[Any](capacity)
      for (i <- 0 until num) {
        datanew(i) = data(i)
      }
      data = datanew
    }
    data(num) = obj
    num+=1
  }
}