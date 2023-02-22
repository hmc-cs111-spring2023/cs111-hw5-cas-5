package dfa // leave this line in the file
//import scala.util.control._

case class State(label: String)

case class Transition(from: State, to: State, symbol: Char)

case class DFA(val states: Set[State], val transitions: Set[Transition], val start: State, val accept: Set[State]){
    def accepts(states: String): Boolean = 
        var state: State = start
        for (s <- states) {
            var trans: Transition = transitions.head
            for (t <- transitions) {
                if (t.from == state && t.symbol == s) {
                    trans = t
                    //break
                }
            }
            state = trans.to
        }
        if (accept.contains(state)) {
            true
        }
        else {
            false
        } 
}


