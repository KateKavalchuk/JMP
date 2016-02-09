package by.epam.kovalchuk.service;

import java.io.File;
import java.util.Collections;
import java.util.List;

import by.epam.kovalchuk.dao.AccountDAO;
import by.epam.kovalchuk.exception.ExchangerException;
import by.epam.kovalchuk.model.Account;
import by.epam.kovalchuk.util.FileUtil;

public class AccountService {

	private AccountDAO accountDAO = new AccountDAO();

	public AccountService() {
	}

	public void addAccount(Account account) throws ExchangerException {
		int accountId = 1;
		List<File> userFiles = FileUtil.readAllFilesFromDirectory("accounts");
		Collections.sort(userFiles, (file1, file2) -> file1.getName()
				.compareTo(file2.getName()));
		File file = userFiles.get(userFiles.size() - 1);
		String fileName = file.getName();
		accountId = Integer.parseInt(fileName.split("account_")[1]
				.split(".xml")[0]) + 1;
		accountDAO.addAccount(account, accountId);
	}

	public void updateAccount(Account account, int accountId)
			throws ExchangerException {
		accountDAO.addAccount(account, accountId);
	}

	public Account getAccount(int id) throws ExchangerException {
		return accountDAO.getAccount(id);
	}

}
