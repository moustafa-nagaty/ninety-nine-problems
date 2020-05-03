package problems

import java.util.NoSuchElementException

import scala.annotation.tailrec

object Lists {

//  P01 (*) Find the last element of a list.
  def last[A](l: List[A]): A = l.last

  def lastRecursion[A](ls: List[A]): A = {
    ls match {
      case head :: Nil => head
      case _ :: tail => lastRecursion(tail)
      case Nil         => throw new NoSuchElementException
    }
  }

  //  P02 (*) Find the last but one element of a list.
  def penultimate[A](ls: List[A]): A = {
    ls match {
      case h :: _ :: Nil => h
      case _ :: tail => penultimate(tail)
      case _ => throw new NoSuchElementException
    }
  }

  def lastNthRecursive[A](n: Int, ls: List[A]): A = {
    def helper[A](count: Int, originalList: List[A], currentList: List[A]): A = {
      currentList match {
        case Nil if count > 0 => throw new NoSuchElementException
        case Nil => originalList.head
        case _ :: tail => helper(count - 1, if(count > 0) originalList else originalList.tail, tail)
      }
    }
    if (n <= 0) throw new IllegalArgumentException
    helper(n, ls, ls)
  }

  // P03 (*) Find the Kth element of a list.
  def nth[A](n: Int, ls: List[A]): A = {
    if (n < 0 || n >= ls.size) throw new IllegalArgumentException
    ls match {
      case list if n == 0 => list.head
      case _ :: tail => nth(n - 1, tail)
    }
  }

  //P04 (*) Find the number of elements of a list.
  def length[A](ls: List[A]) = {
    @tailrec def helper[A](count: Int, ls: List[A]): Int = {
      ls match {
        case Nil => count
        case _ :: tail => helper(count + 1, tail)
      }
    }
    helper(0, ls)
  }

  def lengthFunctional[A](ls: List[A]): Int = ls.foldLeft(0) { (length, _) => length + 1 }
}
