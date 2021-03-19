package com.construction

import org.mockito.Mockito._
import org.scalatest._
import org.scalatest.mockito._

class FloorSpec extends FlatSpec with MockitoSugar {

  val s = "any"
  val n = 3

  "Foo1 Spec " should "calculate" in {
    val mockFloor = spy(new Floor)

    //when(mockFloor.foo1(n)).thenReturn(n * n)
    //when(mockFloor.door).thenReturn(null)

    assertResult(9) {
      mockFloor.foo1(n)
    }
    assertResult(null) {
      mockFloor.door
    }
  }

  "Foo2 Spec " should "calculate" in {

    val mockFloor = spy(new Floor)

    assertResult("This is door") {
      intercept[Exception] {
        mockFloor.foo2(s)
      }.getMessage
    }

    assertResult(null) {
      mockFloor.door
    }
  }

  "Foo3 Spec " should "calculate" in {
    val mockFloor = spy( new Floor)

    //when(mockFloor.foo3(s)).thenReturn(s"$s should be set")
    //when(mockFloor.door).thenReturn(s)

    assertResult(s"$s should be set") {
      mockFloor.foo3(s)
    }

    assertResult(s) {
      mockFloor.door
    }
  }

}
