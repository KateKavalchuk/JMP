package by.epam.kovalchuk.dao;

import by.epam.kovalchuk.exception.ExchangerException;
import by.epam.kovalchuk.model.Account;
import by.epam.kovalchuk.util.JAXBUtil;

public class AccountDAO {

	private static final String FILE_NAME = "\\accounts\\account_";
	private static final String EXTENSION = ".xml";

	public AccountDAO() {
	}

	public void addAccount(Account account, int id) throws ExchangerException {
		JAXBUtil.writeObject(System.getProperty("user.dir") + FILE_NAME + id
				+ EXTENSION, account, Account.class);
	}

	public Account getAccount(int id) throws ExchangerException {
		return (Account) JAXBUtil.loadObject(System.getProperty("user.dir")
				+ FILE_NAME + id + EXTENSION, Account.class);
	}

}
