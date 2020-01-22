package com.inheritance;

class BaseClass {

	public static void method1() {
		try {
			System.out.println("BaseClass");
		} catch (Exception e) {

		}
	}
}

class SubClass extends BaseClass {

	public static void method1() {
		System.out.println("SubClass");
	}
}

public class MainClass {

	public static void main(String[] args) {

		BaseClass.method1();
		SubClass.method1();


		BaseClass b = new SubClass();
		b.method1();

		SubClass s = new SubClass();
		s.method1();

		b = new BaseClass();
		b.method1();

	}

}
