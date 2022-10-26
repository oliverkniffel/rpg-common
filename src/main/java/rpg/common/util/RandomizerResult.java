/*
 * Oliver Kniffel, 2022.
 */
package rpg.common.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RandomizerResult {

  private int number;
  private int type;
  private List<Integer> rolls;
  private int total;
  private int minimum;
  private int maximum;
}
