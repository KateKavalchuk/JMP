package by.epam.kovalchuk.util;

import java.io.File;
import java.net.URL;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import by.epam.kovalchuk.exception.ExchangerException;

public class JAXBUtil {
	private static Logger LOGGER = Logger.getLogger(JAXBUtil.class);
	private final static Lock LOCK = new ReentrantLock();

	private static final String ERROR_LOAD_FILE = "Loading file error!";
	private static final String ERROR_WRITE_IN_FILE = "Writing file error!";

	public static Object loadObject(String filename, Class<?> className)
			throws ExchangerException {
		Object object = null;
		try {
			LOCK.lock();
			URL url = ClassLoader.getSystemResource(filename);
			JAXBContext jaxbContext = JAXBContext.newInstance(className);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			if (url == null) {
				object = jaxbUnmarshaller.unmarshal(new File(filename));
			} else {
				object = jaxbUnmarshaller.unmarshal(new File(url.getFile()));
			}
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ExchangerException(ERROR_LOAD_FILE, e);
		} finally {
			LOCK.unlock();
		}
		return object;
	}

	public static void writeObject(String fileName, Object data, Class<?> clazz)
			throws ExchangerException {
		try {
			LOCK.lock();
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			URL ips = ClassLoader.getSystemResource(fileName);
			if (ips == null) {
				jaxbMarshaller.marshal(data, new File(fileName));
			} else {
				jaxbMarshaller.marshal(data, new File(ips.getFile()));
			}
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ExchangerException(ERROR_WRITE_IN_FILE, e);
		} finally {
			LOCK.unlock();
		}
	}
}
