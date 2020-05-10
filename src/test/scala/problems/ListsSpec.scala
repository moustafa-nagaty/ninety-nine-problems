package problems

import org.scalatest._

import scala.util.{Failure, Try}

class ListsSpec extends WordSpec with Matchers {
  "Lists Problems" should {
    "P01 (*) return the last element of a list" in {
      Lists.lastRecursion(List(1, 1, 2, 3, 5, 8)) shouldEqual 8
      Lists.lastRecursion(List(1)) shouldEqual 1
    }

    "P01 (*) raise an error if the list is empty" in {
      Try(Lists.lastRecursion(List.empty[Int])) shouldBe a[Failure[_]]
    }

    "P02 (*) return the last but one element of a list" in {
      Lists.penultimate(List(1, 1, 2, 3, 5, 8)) shouldEqual 5
      Lists.penultimate(List(7,4)) shouldEqual 7
    }

    "P02 (*) raise an error if the list is empty or has one element" in {
      Try(Lists.penultimate(List.empty[Int])) shouldBe a[Failure[_]]
      Try(Lists.penultimate(List(1))) shouldBe a[Failure[_]]
    }

    "P02 (*) nth last recursive" in {
      Lists.lastNthRecursive(3, List(12,13,14,15,16)) shouldEqual 14
      Lists.lastNthRecursive(5, List(1,2,3,4,5,6,7,8)) shouldEqual 4
    }

    "P03 (*) return the nth element of a list" in {
      Lists.nth(2, List(1, 1, 2, 3, 5, 8)) shouldEqual 2
      Lists.nth(5, List(1, 1, 2, 3, 5, 8)) shouldEqual 8
    }

    "P03 (*) raise an error if the list is empty or k is outside range" in {
      Try(Lists.nth(0, List.empty[Int])) shouldBe a[Failure[_]]
      Try(Lists.nth(5, List(1,2,3,4,5))) shouldBe a[Failure[_]]
    }

    "P04 (*) return the length of a list" in {
      Lists.length(List(1, 1, 2, 3, 5, 8)) shouldEqual 6
      Lists.length(List.empty[Int]) shouldEqual 0
    }

    "P05 (*) Reverse a list" in {
      Lists.reverse(List(1, 1, 2, 3, 5, 8)) shouldEqual List(8,5,3,2,1,1)
      Lists.reverse(List.empty[Int]) shouldEqual List.empty[Int]
    }

    "P05 (*) Reverse a list with foldLeft" in {
      Lists.reverseFoldLeft(List(1, 1, 2, 3, 5, 8)) shouldEqual List(8,5,3,2,1,1)
      Lists.reverseFoldLeft(List.empty[Int]) shouldEqual List.empty[Int]
    }

    "P05 (*) Reverse a list with foldRight" in {
      Lists.reverseFoldRight(List(1, 1, 2, 3, 5, 8)) shouldEqual List(8,5,3,2,1,1)
      Lists.reverseFoldRight(List.empty[Int]) shouldEqual List.empty[Int]
    }

    "P05 (*) Reverse a list with tailRec" in {
      Lists.reverseTailRecursive(List(1, 1, 2, 3, 5, 8)) shouldEqual List(8,5,3,2,1,1)
      Lists.reverseTailRecursive(List.empty[Int]) shouldEqual List.empty[Int]
    }

    "P06 (*) Find out whether a list is a palindrome." in {
      Lists.palindrome(List(1, 2, 3, 2, 1)) shouldEqual true
      Lists.palindrome(List(1, 1, 2, 3, 5, 8)) shouldEqual false
      Lists.palindrome(List.empty[Int]) shouldEqual true
    }
  }

}
