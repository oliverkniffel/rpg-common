/*
 * Oliver Kniffel, 2022.
 */
package rpg.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public abstract class NumberUtils {

  public static final String DECIMAL_FORMAT_PATTERN_DEFAULT = "#.#";

  public static double round(double value, int digits) {
    BigDecimal result = BigDecimal.valueOf(value).setScale(digits, RoundingMode.HALF_EVEN);
    return result.doubleValue();
  }

  public static boolean isBetween(int value, int minimum, int maximum) {
    return (value >= minimum && value <= maximum);
  }

  public static boolean isOneOf(int value, int... numbers) {
    for (int number : numbers) {
      if (value == number) {
        return true;
      }
    }
    return false;
  }

  public static int squeeze(int value, int minimum, int maximum) {
    if (value < minimum) {
      return minimum;
    } else if (value > maximum) {
      return maximum;
    } else {
      return value;
    }
  }

  public static <T> T getEntry(T[] array, int index) {
    int adjustedIndex = squeeze(index, 0, array.length - 1);
    return array[adjustedIndex];
  }

  public static <T> T getEntry(List<T> list, int index) {
    int adjustedIndex = squeeze(index, 0, list.size() - 1);
    return list.get(adjustedIndex);
  }

  public static String format(final double value) {
    return format(DECIMAL_FORMAT_PATTERN_DEFAULT, value);
  }

  public static String format(final String pattern, final double value) {
    DecimalFormat format = new DecimalFormat(pattern, new DecimalFormatSymbols(Locale.ROOT));
    format.setGroupingUsed(false);
    return format.format(value);
  }
}
