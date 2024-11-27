// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		for (int i = 1; i <= x2; i++) {
			sum++;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		for (int i = 1; i <= x2; i++) {
			sum--;
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x2 == 0) {
			return 0;
		}
		int mult = x1;
		for (int i = 2; i <= x2; i++) {
			mult = plus(mult, x1);
		}
		return mult;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int num = x;
		int temp = x;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < x; j++) {
				num = plus(num, temp);
			}
			temp = num;
		}
		return num;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int div = x1;
		int count = 0;
		while (div >= x2) {
			div = minus(div, x2);
			count++;
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int mod = x1;
		while (mod >= x2) {
			mod = minus(mod, x2);
		}
		return mod;
	}

	public static int abs(int a) {
		if (a >= 0) {
			return a;
		}
		return minus(0, a);
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int increment = 1;
		while (increment <= div(x, 2)) {
			if (times(increment, increment) == x) {
				return increment;
			}
			increment++;
		}
		return -1;
	}
}