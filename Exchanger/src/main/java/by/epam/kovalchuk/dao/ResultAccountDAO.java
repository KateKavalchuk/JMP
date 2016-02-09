package by.epam.kovalchuk.dao;

import by.epam.kovalchuk.exception.ExchangerException;
import by.epam.kovalchuk.model.ResultAccount;
import by.epam.kovalchuk.util.JAXBUtil;

public class ResultAccountDAO {
	private static final String FILE_NAME = "\\results\\account_";
	private static final String EXTENSION = ".xml";

	public ResultAccountDAO() {
	}

	public void addResultAccount(ResultAccount resultAccount, int id)
			throws ExchangerException {
		JAXBUtil.writeObject(System.getProperty("user.dir") + FILE_NAME + id
				+ EXTENSION, resultAccount, ResultAccount.class);
	}

	public ResultAccount getResultAccount(int id) throws ExchangerException {
		return (ResultAccount) JAXBUtil.loadObject(FILE_NAME + id + EXTENSION,
				ResultAccount.class);
	}
}
