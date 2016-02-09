package by.epam.kovalchuk.service;

import java.util.List;

import by.epam.kovalchuk.dao.ExchangeRatesDAO;
import by.epam.kovalchuk.exception.ExchangerException;
import by.epam.kovalchuk.model.ExchangeRate;

public class ExchangeRatesService {
	private ExchangeRatesDAO exchangeRatesDAO;

	public ExchangeRatesService() {
		exchangeRatesDAO = new ExchangeRatesDAO();
	}

	public void addExchangeService(ExchangeRate exchangeRate)
			throws ExchangerException {
		exchangeRatesDAO.addExchangeRate(exchangeRate);
	}

	public List<ExchangeRate> getAllExchangesRates() throws ExchangerException {
		return exchangeRatesDAO.getAll();
	}
}
