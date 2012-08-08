package net.jakubholy.examples.byteman;

public class MainsHelper {

	public String sayHello() {
		System.out.println(getClass().getSimpleName() + ".sayHello: called");
		return "Hello from MainsHelper!";
	}
}
