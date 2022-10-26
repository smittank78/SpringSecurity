package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServeletInitialize extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		@SuppressWarnings("rawtypes")
		Class[] classes = {SpringBeanConfigurationFile.class};
		System.out.println("xml configured...");
		return classes;
	}

	@Override
	protected String[] getServletMappings() {
		String[] urlStrings = {"/"};
		return urlStrings;
	}

}