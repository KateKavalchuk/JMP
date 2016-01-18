package by.epam.kavalchuk.main;

import by.epam.kavalchuk.stackoverflow.model.Patient;
import static by.epam.kavalchuk.util.Constatns.*;

public class ExecutorClass {

	public static void main(String[] args) {
		// Stack over flow
		Patient patient = new Patient(DEFAULT_NAME, DEFAULT_SURNAME,
				DEFAULT_DIAGNOSIS);
		patient.toString();

		// java.lang.OutOfMemoryError: Java heap space
		String string = new String("str");
		while (true) {
			string += string;
		}

	}

}
