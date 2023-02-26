/*
 * Oliver Kniffel, 2022.
 */
package rpg.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {

  @Test
  void testRound() {
    Assertions.assertEquals(100.0, NumberUtils.round(100.1, 0));
    Assertions.assertEquals(100.0, NumberUtils.round(100.5, 0));
    Assertions.assertEquals(101.0, NumberUtils.round(100.6, 0));
    Assertions.assertEquals(100.1, NumberUtils.round(100.1234, 1));
    Assertions.assertEquals(100.12, NumberUtils.round(100.1234, 2));
    Assertions.assertEquals(100.123, NumberUtils.round(100.1234, 3));
    Assertions.assertEquals(100.124, NumberUtils.round(100.1235, 3));
  }
  
  @Test
  void testFormat() {
    Assertions.assertEquals("1", NumberUtils.format(1.0));
    Assertions.assertEquals("1.2", NumberUtils.format(1.22));
    Assertions.assertEquals("1.2", NumberUtils.format(1.225));
    Assertions.assertEquals("1000", NumberUtils.format(1000));
    Assertions.assertEquals("10000", NumberUtils.format(10000));
    Assertions.assertEquals("10000.1", NumberUtils.format(10000.123456789));
    Assertions.assertEquals("10001", NumberUtils.format(10000.987654321));
  }
}
