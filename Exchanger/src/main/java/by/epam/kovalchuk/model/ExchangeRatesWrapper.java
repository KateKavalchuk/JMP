package by.epam.kovalchuk.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exchangeRates")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRatesWrapper {

	@XmlElement(name="exchangeRate")
	private List<ExchangeRate> exchangeRates = new ArrayList<>();

	public ExchangeRatesWrapper() {
	}

	public List<ExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<ExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

}
