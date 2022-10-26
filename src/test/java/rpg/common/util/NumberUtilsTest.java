/*
 * Oliver Kniffel, 2022.
 */
package rpg.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {

  @Test
  void test() {
    Assertions.assertEquals(100.0, NumberUtils.round(100.1, 0));
    Assertions.assertEquals(100.0, NumberUtils.round(100.5, 0));
    Assertions.assertEquals(101.0, NumberUtils.round(100.6, 0));
    Assertions.assertEquals(100.1, NumberUtils.round(100.1234, 1));
    Assertions.assertEquals(100.12, NumberUtils.round(100.1234, 2));
    Assertions.assertEquals(100.123, NumberUtils.round(100.1234, 3));
    Assertions.assertEquals(100.124, NumberUtils.round(100.1235, 3));
  }
}
