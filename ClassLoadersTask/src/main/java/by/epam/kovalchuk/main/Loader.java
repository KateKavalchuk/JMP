package by.epam.kovalchuk.main;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

public class Loader {
	private static Logger LOGGER = Logger.getLogger(Loader.class);

	public static final String METHOD_WAS_LOADED = "Method was successfully invoked.";
	public static final String CLASS_WAS_LOADED = "Class test.Example have been loaded.";
	public static final String METHOD = "method";
	public static final String SYSTEM_PATH = "file:/";
	public static final String CLASS_NAME = "test.Example";

	public Class loadClass(String path) throws MalformedURLException,
			ClassNotFoundException {
		String fullPath = SYSTEM_PATH + path;
		URL[] urls = { new URL(fullPath) };
		URLClassLoader child = new URLClassLoader(urls,
				Loader.class.getClassLoader());
		LOGGER.debug(CLASS_WAS_LOADED);
		return Class.forName(CLASS_NAME, true, child);
	}

	public void invokeMethod(Class classToLoad) throws Exception {
		Method method = classToLoad.getDeclaredMethod(METHOD);
		Object instance = classToLoad.newInstance();
		method.invoke(instance);
		LOGGER.debug(METHOD_WAS_LOADED);
	}
}
