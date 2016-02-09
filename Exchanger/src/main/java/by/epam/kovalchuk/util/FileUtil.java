package by.epam.kovalchuk.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import by.epam.kovalchuk.exception.ExchangerException;

public class FileUtil {
	private static final Logger LOGGER = Logger.getLogger(FileUtil.class);
	private static final Lock LOCK = new ReentrantLock();

	public static List<File> readAllFilesFromDirectory(String directory)
			throws ExchangerException {
		File[] listFiles = {};
		try {
			LOCK.lock();
			File folder = new File(directory);
			if (folder.isDirectory()) {
				listFiles = folder.listFiles();
			}
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ExchangerException(e.getMessage());
		} finally {
			LOCK.unlock();
		}
		return Arrays.asList(listFiles);
	}

}
