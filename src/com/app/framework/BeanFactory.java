package com.app.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class BeanFactory implements ApplicationContextAware {

	private static final Logger LOGGER = LoggerFactory.getLogger(BeanFactory.class);

	private static ApplicationContext applicationContext;

	@Override
	@SuppressWarnings("all")
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		applicationContext = context;
	}

	public static boolean isReady() {
		return applicationContext != null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		Object object = null;
		try {
			object = applicationContext.getBean(beanName);
		} catch (NoSuchBeanDefinitionException e) {
			LOGGER.info("{}", e);
		}
		return (T) object;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		Object object = null;
		try {
			object = applicationContext.getBean(clazz);
		} catch (NoSuchBeanDefinitionException e) {
			LOGGER.info("{}", e);
		}
		return (T) object;
	}
}
