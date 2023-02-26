/*
 * Oliver Kniffel, 2023.
 */
package rpg.common.util;

/**
 * @author oliver
 */
public abstract class Preconditions {

  public static void checkArgument(final boolean condition) {
    if (!condition) {
      throw new IllegalArgumentException();
    }
  }
}
