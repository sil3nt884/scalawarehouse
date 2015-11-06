package com.QA.util

/**
 * @author rluu
 */
class MethodThread (callback: () => Unit )extends Thread{
    
  override def run(){
     callback ()
  }
  
}