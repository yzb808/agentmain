package com.yzb808.main;

import java.lang.management.ManagementFactory;

import com.sun.tools.attach.VirtualMachine;

public class AgentMain {
	// 包含agentmain方法的jar包在此处声明，premain方法是在启动时设置javaagent参数声明
	private static String jarPath = "E:/eclipse/workSpace/agentmain/target/agentmain-0.0.1.jar";

	public static void main(String[] args) throws Exception {
		System.out.println("main begin");
		String pid = getJVMPid();
		VirtualMachine vm = VirtualMachine.attach(pid);	// ide的jre要依赖一个jdk的版本，否则会抛异常
		vm.loadAgent(jarPath);
		System.out.println("main end");
	}

	/**
	 * 获取当前JVM的进程号
	 * @return
	 */
	private static String getJVMPid() {
		String pid = ManagementFactory.getRuntimeMXBean().getName();
		int indexOf = pid.indexOf('@');
		if (indexOf > 0) {
			pid = pid.substring(0, indexOf);
		}
		return pid;
	}
}
