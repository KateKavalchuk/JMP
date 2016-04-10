package by.epam.kovalchuk.util;

import java.io.File;
import java.io.StringWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbUtil {
	private static final Lock LOCK = new ReentrantLock();
	private static final String ERROR_LOADINIG_FILE = "Problems working with file.";

	public static void writeObject(String fileName, Object object)
			throws Exception {
		try {
			LOCK.lock();
			JAXBContext jaxbContext = JAXBContext
					.newInstance(object.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			File file = new File(fileName);
			jaxbMarshaller.marshal(object, file);
		} catch (Exception e) {
			throw new Exception(ERROR_LOADINIG_FILE, e);
		} finally {
			LOCK.unlock();
		}
	}

	public static Object readObject(String fileName, Class<?> className)
			throws Exception {
		Object result = null;
		try {
			LOCK.lock();
			JAXBContext jaxbContext = JAXBContext.newInstance(className);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			File file = new File(fileName);
			result = jaxbUnmarshaller.unmarshal(file);
		} catch (Exception e) {
			throw new Exception(ERROR_LOADINIG_FILE, e);
		} finally {
			LOCK.unlock();
		}
		return result;
	}

	public static String marshal(Object object) throws Exception {
		Marshaller m = JAXBContext.newInstance(object.getClass())
				.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter w = new StringWriter();
		m.marshal(object, w);
		return w.toString();
	}
}
