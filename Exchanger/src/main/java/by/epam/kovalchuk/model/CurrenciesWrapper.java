package by.epam.kovalchuk.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "currencies")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrenciesWrapper {

	@XmlElement(name = "currency")
	private List<Currency> currencies;

	public CurrenciesWrapper() {
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}

}
