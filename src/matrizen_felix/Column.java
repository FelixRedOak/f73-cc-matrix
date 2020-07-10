package matrizen_felix;

import java.util.ArrayList;
import java.util.List;

public class Column {
	
	private final List<Integer> numbers = new ArrayList<>();
	
	public int getNumber(int position) {
		return numbers.get(position);
	}

	public void add(int number) {
		numbers.add(number);
	}

}
