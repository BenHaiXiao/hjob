package com.github.bh.hjob.utils;

import org.springframework.context.ApplicationContext;

/**
 * @author xiaobenhai
 */
public final class SpringHolder {

	private static ApplicationContext ctx;

	private SpringHolder() {
		// no-op
	}

	public static ApplicationContext getContext() {
		return ctx;
	}

	public static void setContext(ApplicationContext context) {
		ctx = context;
	}

	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}

}
