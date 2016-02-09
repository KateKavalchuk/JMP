package by.epam.kovalchuk.dao;

import by.epam.kovalchuk.exception.ExchangerException;
import by.epam.kovalchuk.model.CurrenciesWrapper;
import by.epam.kovalchuk.model.Currency;
import by.epam.kovalchuk.util.JAXBUtil;

public class CurrencyDAO {

	private String fileName = "currencies.xml";

	public CurrencyDAO() {
	}

	public CurrencyDAO(String fileName) {
		this.fileName = fileName;
	}

	public void addCurrency(Currency currency) throws ExchangerException {
		CurrenciesWrapper currencies = (CurrenciesWrapper) JAXBUtil.loadObject(
				fileName, CurrenciesWrapper.class);
		currencies.getCurrencies().add(currency);
		JAXBUtil.writeObject(fileName, currencies, CurrenciesWrapper.class);
	}

	public CurrenciesWrapper getAll() throws ExchangerException {
		return (CurrenciesWrapper) JAXBUtil.loadObject(fileName,
				CurrenciesWrapper.class);
	}

}
