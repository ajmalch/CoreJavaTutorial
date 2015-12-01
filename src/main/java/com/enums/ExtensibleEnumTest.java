package com.enums;

public class ExtensibleEnumTest {

	public static void main(String[] args) {
		double x = 2.345;
		double y = 14.648;
		test(ExtendedOperation.class, x, y);
		test(BasicOperation.class,x,y);
	}
	private static <T extends Enum<T> & Operation> void test(
		Class<T> opSet, double x, double y) {
		for (Operation op : opSet.getEnumConstants())
		System.out.printf("%f %s %f = %f%n",
		x, op, y, op.apply(x, y));
	}

}
