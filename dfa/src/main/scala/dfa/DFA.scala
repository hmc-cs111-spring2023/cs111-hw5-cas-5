package dfa // leave this line in the file

case class State(label: String)

case class Transition(from: State, symbol: Char, to: State)

class DFA(states: Set[State], transitions: Set[Transition], startState: State, acceptingStates: Set[State]) {
    def accepts(states: String): Boolean = 
        val states_state = State(states)
        if (acceptingStates.contains(states_state)) {
            true
        }
        else {
            false
        } 
}
