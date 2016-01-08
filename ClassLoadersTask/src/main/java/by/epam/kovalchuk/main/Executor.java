package by.epam.kovalchuk.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class Executor {

	private final static Logger logger = Logger.getLogger(Executor.class);
	public static final String ENTER_FILE_NAME = "Enter file name, please:";
	public static final String MENU = "Choose menu point: \n1)Load class and execute method.\n2)Exit.";
	public static final String ERROR_LOAD_FILE = "Error load class.";
	public static final String ERROR_READ_FILE = "Read file exception.";

	public static void main(String[] args) {
		while (true) {
			System.out.println(MENU);
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			String answer = null;
			try {
				answer = bufferRead.readLine();
			} catch (IOException e) {
				logger.error(ERROR_READ_FILE);
			}
			Loader loader = new Loader();
			switch (answer) {
			case "1": {
				try {
					System.out.println(ENTER_FILE_NAME);
					@SuppressWarnings("rawtypes")
					Class classToLoad = loader.loadClass(bufferRead.readLine());
					loader.invokeMethod(classToLoad);
				} catch (Exception e) {
					logger.error(ERROR_LOAD_FILE);
				}
			}
				break;
			case "2": {
				System.exit(0);
			}
			}
		}
	}
}
