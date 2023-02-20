package dfa // leave this line in the file

// TODO: replace this comment with your implementation
case class State(label: String)

case class Transition(from: State, symbol: Char, to: State)

case class DFA(val states: Set[State], val transitions: Set[Transition], val startState: State, val acceptingStates: Set[State])
    def accepts(states: String): Boolean = 
        if (acceptingStates.contains(states)) {
            true
        }
        else {
            false
        } 


