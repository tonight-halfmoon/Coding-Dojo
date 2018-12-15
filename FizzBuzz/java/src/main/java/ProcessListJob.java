import java.util.List;
import java.util.PrimitiveIterator;
import java.util.ArrayList;
import java.util.Arrays;

enum ProcessListJob {
  $;

  static List<String> process(final int [] input) throws Exception {
    final PrimitiveIterator.OfInt iterator = Arrays.stream(input).iterator();
    return process(iterator, new ArrayList<String>(input.length));
  }

  private static List<String> process(final PrimitiveIterator.OfInt iterator, List<String> result) throws Exception {
    if (!iterator.hasNext()) {
	return result;
    }
    final String partResult = ProcessJob.process(iterator.nextInt());
    result.add(partResult);
    return process(iterator, result);
  }
}
