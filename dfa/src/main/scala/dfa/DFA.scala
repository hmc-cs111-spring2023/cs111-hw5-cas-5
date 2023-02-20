package dfa // leave this line in the file

<<<<<<< HEAD
=======
// TODO: replace this comment with your implementation
>>>>>>> 43b9d98ae81ee77d3bdc4bc534f6f4203bd764d4
case class State(label: String)

case class Transition(from: State, symbol: Char, to: State)

<<<<<<< HEAD
class DFA(states: Set[State], transitions: Set[Transition], startState: State, acceptingStates: Set[State]) {
    def accepts(states: String): Boolean = 
        val states_state = State(states)
        if (acceptingStates.contains(states_state)) {
=======
case class DFA(val states: Set[State], val transitions: Set[Transition], val startState: State, val acceptingStates: Set[State])
    def accepts(states: String): Boolean = 
        if (acceptingStates.contains(states)) {
>>>>>>> 43b9d98ae81ee77d3bdc4bc534f6f4203bd764d4
            true
        }
        else {
            false
        } 
<<<<<<< HEAD
}
=======


>>>>>>> 43b9d98ae81ee77d3bdc4bc534f6f4203bd764d4
