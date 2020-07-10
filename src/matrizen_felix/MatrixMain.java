package matrizen_felix;

public class MatrixMain {

	static int[][] A = {
			{1,5},
			{2,3},
			{1,7}
	};
	
	static int[][] B = {
			{1,2,3,7},
			{5,2,8,1}
	};
	
	static int[][] C = {{1, 2},{1, 2}};
	
	public static void main(String[] args) {
		Matrix a = new Matrix(A);
		Matrix b = new Matrix(B);
		
		Matrix result = a.multiply(b);
		
		System.out.println(a);
		System.out.println("x");
		System.out.println(b);
		System.out.println("=");
		System.out.println(result);
		
		System.out.println(new Matrix(C).multiply(new Matrix(C)));
	}
	
}
