// **********************************************
// Program4: Scala
// Course: CS451
// Student Name: Madison Kell
// Instructor: Il-Hyung Cho
// Date of submission: 4/10/23
// Program Description: 
// completed the scala functions that were provided using
// functional programming
// **********************************************

import scala.annotation.tailrec
@main def m() =
    // #1
    val l4 = List(1, 2, 3, 4)
    println("#1")
    println(member(2, l4))
    println(member(5, l4))
    println()
    val l1 = List('A', 'B', 'C', 'D')
    val l2 = List('A', 'C', 'D')
    val l3 = List('A', 'C', 'D')
    // #1

    // #2
    println("#2")
    println(equalsimp(l1, l2))
    println(equalsimp(l3, l2))
    println(equalsimp(l3, List('D', 'A', 'C')))
    println(equalsimp(l1, List('D', 'A', 'C', 'B')))
    println()
    // #2

    // #3
    println("#3")
    println(append(l1, l2))
    println(append(l3, l1))
    val l5 = List(10, 11)
    println(append(l4, l5))
    println()
    // #3


    // #4
    println("#4")
    println(quadratic_roots(1, -2, -3))
    println()
    // #4


    //#5
    println("#5")
    println(factorial(10))
    println()
    //println(factorial(10000)) // Stack Overflow
    // #5

    // #6
    println("#6")
    println(tailFactorial(10000)) // much faster and no stack overflow
    println()
    // #6

    // #7
    val add2 = (x: Int) => x + 2
    val times3 = (x: Int) => x * 3
    println("#7")
    println(h(add2, times3)(4))
    println()
    // #7

    // #8
    //val l1 = List(1, 2, 3, 4)
    println("#8")
    println(third_list(l4))
    println(third_list(List(1,2,(3,4,5), 6, 7)))
    println()
    // #8

    // #9
    println("#9")
    println(nth_list(2, l1))
    println(nth_list(2, List(1,2,(3,4,5), 6, 7)))
    println()
    // #9

// checking for member
// [[HW1: (10 pts) complete the member function
// function to check if list a is in list b
def member(a: Int, b: List[Int]) : Boolean = {
    //if the end of list b is reached and a is not found,
    //a is not in b
    if (b.isEmpty){
        false
        //if a is found in b
    } else if (a == b.head){
        true
        //recursivley call member
    } else {
        member(a, b.tail)
    }
}
// HW1]]

// [[HW2: (10 pts) complete the list equality function
// Assume that list of chars are passed as parameters
//check if two lists are equal
def equalsimp(a: List[Char], b: List[Char]): Boolean = {
    //if you recursivley traverse both lists and they are the same until they are empty,
    //then they are equal
    if (a.isEmpty && b.isEmpty){
        true
        //if either list is empty, they are not the same
    } else if (b.isEmpty || a.isEmpty){
        false
        //if the current element is the same
    } else if (a.head == b.head){
        //recursivley call equalsimp
        equalsimp(a.tail, b.tail)
        //any other case
    } else{
        false
    }
}

// HW2]]

// [[HW3: (10 pts) Complete the append function
//pattern match, if the first list is empty, return the second list else append the list
def append[A](l1: List[A], l2: List[A]): List[A] = {
    //if the first list is empty return 2nd list 
  if(l1.isEmpty){
    l2
    //recursivley append the tail element of list 1
  } else {
    l1.head :: append(l1.tail,  l2)
  }
      
}
// HW3]]

// [[HW4: (10 pts) Complete the quadratic_roots function
// hint: for square root, you can call math.sqrt() function
//function to find quadratic root
def quadratic_roots(a: Int, b: Int, c: Int) = {
    //b^2(4ac)/2a
    val root_part = (Math.sqrt(b * b - (4 * a * c))) / (2 * a)
    //-b/2a
    val minus_b = -1 * b / (2 * a)
    List(minus_b + root_part, minus_b - root_part)
}
// HW4]]

// [[HW5: (10 pts) Complete the factorial functin using recursion
//function to find factorial
def factorial(n: Int): BigInt = {
    //if n is 0 return 1
    if (n == 0){
        1
    }
    //recursivly call factorial
    else{
        n * factorial(n-1)
    }
}
// HW5]]

// [[HW6: (10 pts) Complete the factorial function with tail recursion
// fucntion to find factorial using tail recursion
def factHelper(n: Int, factPartial: BigInt): BigInt ={
    //if n is less than or = 1 return the result
    if (n <= 1){
        factPartial
    }
    //rescursivly call facthelper
    else{
        factHelper(n-1, n * factPartial)
    }
}

//helper function
def tailFactorial(n: Int): BigInt ={
    factHelper(n, 1)
}
// HW6]]

// [[HW7
// Function composition
// function to find the composition of two functions
// this was already done?
def h[A, B, C](f: B => C, g: A => B): A => C = {
 x => f(g(x))
}
// HW7]]

// [[HW8: (10 pts) Complete the third_list function
// function to return the third element in the list
def third_list[A](ls: List[A]): A = {
    //get the 3rd element 
    ls.tail.tail.head
}
// HW8]]

// [[HW9: (20 pts) Complete the nth_list function
// function to return the nth element in the list
def nth_list[A](n: Int, ls: List[A]): A = {
   // if n=1, return that element
    if(n == 1){
        ls.head
        //recursively traverse the list until n=1
    }else{
        nth_list(n-1, ls.tail)
    }
}

// HW9]]