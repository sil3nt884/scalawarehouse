package com.QA.util

/**
 * @author rluu
 */
class MethodThread (callback: () => Unit )extends Runnable {
  
  
  def run(){
     callback ()
  }
  
}