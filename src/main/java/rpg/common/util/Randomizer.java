/*
 * Oliver Kniffel, 2022.
 */
package rpg.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Helper class for randomization.
 * 
 * @author oliver
 */
public class Randomizer {

  private final Random random = new Random();

  public int roll(int type) {
    Preconditions.checkArgument(type > 1);
    return random.nextInt(type) + 1;
  }

  public int roll(int number, int type) {
    Preconditions.checkArgument(number > 0);
    Preconditions.checkArgument(type > 1);

    int result = 0;

    for (int i = 0; i < number; i++) {
      result += roll(type);
    }

    return result;
  }

  public RandomizerResult rollMulti(int number, int type) {
    Preconditions.checkArgument(number > 0);
    Preconditions.checkArgument(type > 1);

    List<Integer> rolls = new ArrayList<>();
    int total = 0;
    int minimum = type;
    int maximum = 1;

    for (int i = 0; i < number; i++) {
      int roll = roll(type);

      rolls.add(roll);
      total += roll;
      minimum = Math.min(minimum, roll);
      maximum = Math.max(maximum, roll);
    }

    // @formatter:off
    RandomizerResult result = RandomizerResult.builder()
        .number(number)
        .type(type)
        .rolls(rolls)
        .total(total)
        .minimum(minimum)
        .maximum(maximum)
        .build();
    // @formatter:on

    return result;
  }

  public int rollFromTo(int minimum, int maximum) {
    Preconditions.checkArgument(minimum < maximum);
    int range = maximum - minimum;
    return random.nextInt(range) + minimum;
  }

  public <T> T getRandomEntry(T[] entries) {
    Preconditions.checkArgument(entries != null && entries.length > 0);
    return entries[rollFromTo(0, entries.length)];
  }

  public <T> T getRandomEntry(List<T> entries) {
    Preconditions.checkArgument(entries != null && entries.size() > 0);
    return entries.get(rollFromTo(0, entries.size()));
  }
}
