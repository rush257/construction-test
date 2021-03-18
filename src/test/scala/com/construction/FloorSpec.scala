package com.construction

import org.mockito.Mockito._
import org.scalatest._
import org.scalatest.mockito._

class FloorSpec extends FlatSpec with MockitoSugar {

  val s = "any"
  val n = 3

  "Foo1 Spec " should "calculate" in {
    val mockFloor = mock[Floor]
    when(mockFloor.foo1(n)).thenReturn(n * n)
    when(mockFloor.door).thenReturn(null)

    assertResult(9) {
      mockFloor.foo1(n)
    }
    assert(mockFloor.door === null)
  }

  "Foo2 Spec " should "calculate" in {

    val mockFloor = mock[Floor]

    when(mockFloor.house()).thenThrow(new RuntimeException("This is door"))
    when(mockFloor.foo2(s)).thenThrow(new RuntimeException("This is door"))
    when(mockFloor.door).thenReturn(null)

    assertResult("This is door") {
      intercept[RuntimeException] {
        mockFloor.house()
      }.getMessage
    }

    assertResult("This is door") {
      intercept[RuntimeException] {
        mockFloor.foo2(s)
      }.getMessage
    }

    assert(mockFloor.door === null)
  }

  "Foo3 Spec " should "calculate" in {
    val mockFloor = mock[Floor]

    when(mockFloor.foo3(s)).thenReturn(s"$s should be set")
    when(mockFloor.door).thenReturn(s)

    assertResult(s"$s should be set") {
      mockFloor.foo3(s)
    }

    assert(mockFloor.door.equals(s))
  }

}
