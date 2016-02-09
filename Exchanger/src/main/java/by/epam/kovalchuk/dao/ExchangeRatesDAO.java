package by.epam.kovalchuk.dao;

import java.util.List;

import by.epam.kovalchuk.exception.ExchangerException;
import by.epam.kovalchuk.model.ExchangeRate;
import by.epam.kovalchuk.model.ExchangeRatesWrapper;
import by.epam.kovalchuk.util.JAXBUtil;

public class ExchangeRatesDAO {

	private final String fileName = "exchangeRates.xml";

	public void addExchangeRate(ExchangeRate exchangeRate)
			throws ExchangerException {
		ExchangeRatesWrapper exchangeRatesWrapper = (ExchangeRatesWrapper) JAXBUtil
				.loadObject(fileName, ExchangeRatesWrapper.class);
		exchangeRatesWrapper.getExchangeRates().add(exchangeRate);
		JAXBUtil.writeObject(fileName, exchangeRatesWrapper,
				ExchangeRatesWrapper.class);
	}

	public List<ExchangeRate> getAll() throws ExchangerException {
		return ((ExchangeRatesWrapper) JAXBUtil.loadObject(fileName,
				ExchangeRatesWrapper.class)).getExchangeRates();
	}

}
