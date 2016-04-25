package com.yzb808.agentmain;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 *
 */
public class Agentmain {

	public static void agentmain(String args, Instrumentation inst) {
		System.out.println("MyAgentMain agentmain attach...");
		// inst中包含所有已经加载了的类，这里也能够测试说明，用户自定的类是在用户使用该类的时候才被classLoader加载进来
		for (Class<?> clazz : inst.getAllLoadedClasses()) {
			if (clazz.getName().startsWith("com.yzb808.main")) {
				System.out.println(clazz.getName());
			}
		}
		System.out.println("MyAgentMain agentmain end...");
	}
}
