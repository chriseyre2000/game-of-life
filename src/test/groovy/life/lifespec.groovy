package life

import spock.lang.*

class LifeSpecification extends Specification {
  @Unroll
  void "Life tests #name"() {
    given:
      Dimensions dimensions = Dimensions.withWidthAndHeight(3, 3);
      State state = new State(dimensions, input);
      StateTransitionCalulator stateTransitionCalulator = new StateTransitionCalulator(state);
    when:
      State newState = stateTransitionCalulator.next();
      Display display = newState.display(); 
    then:
       display.print() == expected
    where:
      name             | input        || expected
      'Vertical line'  | "000111000"  || "010\n010\n010\n"    
      'Vertical line2' | "111111111"  || "101\n000\n101\n"    
  }
}

      
      
      
      