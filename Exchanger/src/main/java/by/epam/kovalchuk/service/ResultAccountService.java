package by.epam.kovalchuk.service;

import by.epam.kovalchuk.dao.ResultAccountDAO;
import by.epam.kovalchuk.exception.ExchangerException;
import by.epam.kovalchuk.model.ResultAccount;

public class ResultAccountService {

	private ResultAccountDAO accountDAO = new ResultAccountDAO();

	public ResultAccountService() {
	}

	public void addResultAccount(ResultAccount resultAccount, int id)
			throws ExchangerException {
		accountDAO.addResultAccount(resultAccount, id);
	}
	
	public void getAccount(int id) throws ExchangerException {
		accountDAO.getResultAccount(id);
	}
}
