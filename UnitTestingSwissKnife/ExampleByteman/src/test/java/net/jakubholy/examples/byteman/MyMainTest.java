package net.jakubholy.examples.byteman;

import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMUnitRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static junit.framework.Assert.fail;

/**
 * Example of fault injection into the code under test using Byteman.
 *
 * Based on <a href="https://community.jboss.org/wiki/FaultInjectionTestingWithByteman">Fault Injection Testing With Byteman</a> (9/2011).
 */
@RunWith(BMUnitRunner.class)
public class MyMainTest {

	@Rule public final ExpectedException exception = ExpectedException.none();

	/**
	 * Use Byteman to redefine the method <code>MainsHelper.sayHello</code> called from
	 * <code>MyMain.sayHello</code> to throw an IllegalStateException.
	 * <p>
	 *     Notice that we do not have access to the instance of MainsHelper that is being
	 *     modified. It could well be even class we do not own, e.g. java.net.Socket.
	 * </p>
	 */
	@Test(expected = IllegalStateException.class)
	@BMRule(name="throw IllegalStateException from the helper",
			targetClass = "MainsHelper",
			targetMethod = "sayHello",
			action = "throw new java.lang.IllegalStateException(\"Exception injected by Byteman\")")
	public void testSayHello() {
		//exception.expect(IllegalStateException.class);
		//exception.expectMessage("Exception injected by Byteman");

		new MyMain().sayHello();

		fail("sayHello should have failed due to Byteman injecting an exception into its helper");
	}
}
