// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(plus(-20, 3)); // 2 + 3
		System.out.println(plus(2, -3)); // 2 + (-3)
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(minus(-2, -7)); // - 2 - (-7)
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
		System.out.println(sqrt(0));
		System.out.println(sqrt(1));

	}

	public static int abs(int a) {
		if (a < 0) {
			int count = 0;
			int temp = a;
			while (temp < 0) {
				count++;
				temp++;
			}
			return count;
		}
		return a;
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if (x2 < 0) {
			sum = minus(sum, abs(x2));
		} else {
			for (int i = 1; i <= x2; i++) {
				sum++;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		if (x2 < 0) {
			sum = plus(sum, abs(x2));
		}
		for (int i = 1; i <= x2; i++) {
			sum--;
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		int mult = x1;
		if ((x1 < 0 && x2 < 0) || x1 > 0 && x2 > 0) {
			for (int i = 2; i <= abs(x2); i++) {
				mult = plus(mult, x1);
			}
		} else {
			for (int i = 2; i <= x2; i++) {
				mult = plus(mult, x1);
			}
			mult = minus(0, mult);
		}
		return mult;

	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int num = abs(x);
		int temp = abs(x);
		if (x < 0 && mod(n, 2) != 0) {
			for (int i = 2; i <= n; i++) {
				for (int j = 1; j < x; j++) {
					num = plus(num, temp);
				}
				temp = num;
			}
			num = minus(0, num);
		} else {
			for (int i = 2; i <= n; i++) {
				for (int j = 1; j < x; j++) {
					num = plus(num, temp);
				}
				temp = num;
			}
		}
		return num;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int sum = abs(x1);
		int div = abs(x2);
		int count = 0;
		while (sum >= div) {
			sum = minus(sum, div);
			count++;
		}
		if (!((x1 < 0 && x2 < 0) || x1 > 0 && x2 > 0)) {
			count = minus(0, count);
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

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int increment = 1;
		while (increment <= div(x, 2)) {
			if (times(increment, increment) == x) {
				return increment;
			}
			increment++;
		}
		return x;
	}
}