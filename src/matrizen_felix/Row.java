package matrizen_felix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Row {
	
	private final List<Integer> numbers;
	
	public Row(int[] numbers) {
		this.numbers = Arrays.stream(numbers)
				.mapToObj(Integer::valueOf)
				.collect(Collectors.toList());
	}

	public int size() {
		return numbers.size();
	}

	public int getNumber(int position) {
		return numbers.get(position);
	}

}
