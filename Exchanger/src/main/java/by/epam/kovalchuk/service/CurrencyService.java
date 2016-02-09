package by.epam.kovalchuk.service;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import by.epam.kovalchuk.dao.CurrencyDAO;
import by.epam.kovalchuk.exception.ExchangerException;
import by.epam.kovalchuk.model.Currency;

public class CurrencyService {
	private CurrencyDAO currencyDAO;
	private static Lock LOCK = new ReentrantLock();
	private static Logger LOGGER = Logger.getLogger(CurrencyService.class);

	public CurrencyService() {
		currencyDAO = new CurrencyDAO();
	}

	public List<Currency> loadAllCurriencies() throws ExchangerException {
		List<Currency> currencies = null;
		try {
			LOCK.lock();
			currencies = currencyDAO.getAll().getCurrencies();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			LOCK.unlock();
		}
		return currencies;
	}

	public void addCurrency(Currency currency) {
		try {
			LOCK.lock();
			currencyDAO.addCurrency(currency);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			LOCK.unlock();
		}
	}
}
