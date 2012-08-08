package net.jakubholy.examples.byteman;

public class MyMain {

	public String sayHello() {
		System.out.println(getClass().getSimpleName() + ".sayHello: called");
		return "MyMain: helper says: " + new MainsHelper().sayHello();
	}
}
