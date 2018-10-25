package life;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
class LifeShould {
 
    @Test
    void printTheCurrentStateOfTheWorld() {
      Dimensions dimensions = Dimensions.withWidthAndHeight(3, 3);
      State state = new State(dimensions, "000111000");
      Display display = state.display();
      assertEquals(display.print(), "000\n111\n000\n"); 
    }
    
    @Test
    void initialStateLengthMustMatchDimensions() {
      Dimensions dimensions = Dimensions.withWidthAndHeight(3, 3);
      
      assertThrows(IllegalArgumentException.class, () -> {
        new State(dimensions, "0"); 
      });
    }

    @Test
    void calculateNextState() {
      Dimensions dimensions = Dimensions.withWidthAndHeight(3,3);
      State state = new State(dimensions, "000111000");
      
      StateTransitionCalulator stateTransitionCalulator = new StateTransitionCalulator(state);
      
      State newState = stateTransitionCalulator.next();
      Display display = newState.display();
      assertEquals(display.print(), "010\n010\n010\n"); 
    }
}