package rpg.common.util;
/*
 * Oliver Kniffel, 2022.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RandomizerUtilsTest {

  private Randomizer testedObj = new Randomizer();

  public static Stream<Arguments> rollInvalidArgumentsProvider() {
    // @formatter:off
    return Stream.of(
        arguments(-1, -1), 
        arguments(-1, 0),
        arguments(-1, 1),
        arguments(-1, 2),
        arguments(0, -1),
        arguments(0, 0), 
        arguments(0, 1), 
        arguments(0, 2), 
        arguments(1, -1), 
        arguments(1, 0),
        arguments(1, 1)
        );
    // @formatter:on
  }

  @ParameterizedTest
  @ValueSource(ints = { 2, 3, 4, 5 })
  public void rollOne(int type) {
    assertTrue(testedObj.roll(type) > 0);
    assertTrue(testedObj.roll(type) <= type);
  }

  @ParameterizedTest
  @MethodSource("rollInvalidArgumentsProvider")
  public void rollInvalidArguments(int number, int type) {
    assertThrows(IllegalArgumentException.class, () -> testedObj.roll(number, type));
  }

  @Test
  public void rollMulti() {
    // Given
    int number = 3;
    int type = 7;

    // When
    RandomizerResult result = testedObj.rollMulti(number, type);

    // Then
    assertNotNull(result);
    assertEquals(number, result.getNumber());
    assertEquals(type, result.getType());
    assertNotNull(result.getRolls());
    assertEquals(number, result.getRolls().size());
    assertTrue(result.getTotal() >= number);
    assertTrue(result.getTotal() <= number * type);
    assertTrue(result.getMinimum() >= 1);
    assertTrue(result.getMinimum() <= type);
    assertTrue(result.getMaximum() >= 1);
    assertTrue(result.getMaximum() <= type);
  }

  @Test
  public void rollFromTo() {
    // Given
    int minimum = -1;
    int maximum = 1;

    // When
    int result = testedObj.rollFromTo(minimum, maximum);

    // Then
    assertTrue(Set.of(-1, 0, 1).contains(result));
  }
}
