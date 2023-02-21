package regex

/** *****************************************************************************
  * Regular Languages
  *
  * data structure definitions for regular languages
  */

// Add your definitions here

trait RegularLanguage

case object Empty extends RegularLanguage

case object Epsilon extends RegularLanguage

case class Character(obj: Char) extends RegularLanguage

case class Union(objOne: RegularLanguage, objTwo: RegularLanguage) extends RegularLanguage

case class Concat(objOne: RegularLanguage, objTwo: RegularLanguage) extends RegularLanguage

case class Star(objOne: RegularLanguage) extends RegularLanguage

/** *****************************************************************************
  * Derivatives
  *
  * Fill in the function definitions below
  */

/** Simplifies a regular language */
def simplify(lang: RegularLanguage): RegularLanguage = 
  lang match
    case Concat(Empty, x) => simplify(Star(Empty))
    case Concat(x, Empty) => simplify(Star(Empty))
    case Concat(Epsilon, x) => simplify(x)
    case Concat(x, Epsilon) => simplify(x)
    case Concat(x, y) => Concat(simplify(x), simplify(y))
    case Union(Empty, x) => simplify(x)
    case Union(x, Empty) => simplify(x)
    case Union(x, y) => Union(simplify(x), simplify(y))
    case Star(Empty) => Empty
    case Star(Epsilon) => Epsilon
    case Character(x) => Character(x)
    case Star(x) => Star(simplify(x))

/** A language is nullable if it contains ε */
def nullable(lang: RegularLanguage): Boolean = 
  lang match 
    case Concat(Epsilon, Epsilon) => true
    case Concat(Epsilon, objTwo) => false // I dont know why these aren't nullable
    case Concat(objOne, Epsilon) => false // I dont know why these aren't nullable
    case Concat(objOne, objTwo) => false
    case Star(Epsilon) => true
    case Star(objOne) => true
    case Union(Epsilon, objTwo) => true
    case Union(objOne, Epsilon) => true
    case Union(objOne, objTwo) => false
    case Epsilon => true
    case Empty => false
    case Character(obj) => false

/** Computes the derivative of a language, with respect to a character */
def derivative(l: RegularLanguage)(c: Char): RegularLanguage = 
  (l, c) match
    case
  

/** *****************************************************************************
  * String-matching with regular expressions
  */

/** Given a string s and a language l, returns true if the string matches the
  * pattern described by l
  */
def matches(s: String, l: RegularLanguage): Boolean =
  if (s.isEmpty) then nullable(l)
  else matches(s.tail, derivative(l)(s.head))
