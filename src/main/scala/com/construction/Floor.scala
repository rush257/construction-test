package com.construction

class Floor {

  var door: String = null

  def foo1(a: Int): Int = {
    a * a
  }

  def foo2(b: String): String = {
    s"$b ${house()}"
  }

  def house(): String = {
    throw new Exception("This is door")
  }

  def foo3(c: String): String = {
    this.door = c
    s"$c should be set"
  }
}


