package matrizen_felix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
	
	private final List<Row> rows;
	
	public Matrix(List<Row> rows) {
		checkRowSizes(rows);
		this.rows = rows;
	}

	public Matrix(int[][] resultNumbers) {
		this.rows = Arrays.stream(resultNumbers)
				.map(Row::new)
				.collect(Collectors.toList());
	}

	private void checkRowSizes(List<Row> rows) {
		for (int i = 1; i < rows.size(); i++) {
			if (rows.get(i - 1).size() != rows.get(i).size()) {
				throw new IllegalArgumentException("Das ist keine Matrix!");
			}
		}
	}
	
	public int getColumnCount() {
		return this.rows.size() > 0 ? this.rows.get(0).size() : 0;
	}
	
	public int getRowCount() {
		return this.rows.size();
	}
	
	public int getNumberAt(int row, int column) {
		Row rowObject = this.rows.get(row);
		Integer number = rowObject.getNumber(column);
		return number;
	}
	
	private Column getColumn(int column) {
		Column columnObject = new Column();
		for (Row row : this.rows) {
			columnObject.add(row.getNumber(column));
		}
		return columnObject;
	}
	
	public Matrix multiply(Matrix other) {
		if (getColumnCount() != other.getRowCount()) {
			throw new IllegalArgumentException("Diese Matrizen kann man nicht multiplizieren!");
		}
		
		int resultRowCount = getRowCount();
		int resultColumnCount = other.getColumnCount();
		int resultNumbers[][] = new int[resultRowCount][resultColumnCount];
		
		for (int row = 0; row < resultRowCount; row++) {
			Row rowObject = this.rows.get(row);
			for (int column = 0; column < resultColumnCount; column++) {
				Column columnObject = other.getColumn(column);
				resultNumbers[row][column] = scalarProduct(rowObject, columnObject);
			}
		}
		
		return new Matrix(resultNumbers);
	}

	private int scalarProduct(Row row, Column column) {
		int returnValue = 0;
		int summandCount = row.size();
		for (int summandIndex = 0; summandIndex < summandCount; summandIndex++) {
			returnValue += row.getNumber(summandIndex) * column.getNumber(summandIndex);
		}
		return returnValue;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < getRowCount(); row++) {
			for (int column = 0; column < getColumnCount(); column++) {
				sb.append(getNumberAt(row, column));
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString().trim();
	}
	
}
