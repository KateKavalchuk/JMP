package by.epam.kovalchuk.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

	@XmlElement(name = "currencyValue")
	private List<CurrencyValue> currencyValues = new ArrayList<>();

	public Account() {
	}

	public List<CurrencyValue> getCurrencyValues() {
		return currencyValues;
	}

	public void setCurrencyValues(List<CurrencyValue> currencyValues) {
		this.currencyValues = currencyValues;
	}

}
