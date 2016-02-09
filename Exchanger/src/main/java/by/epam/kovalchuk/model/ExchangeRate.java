package by.epam.kovalchuk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exchangeRate")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRate {

	private Currency from;
	private Currency to;
	private float rate;

	public ExchangeRate() {
	}

	public ExchangeRate(Currency from, Currency to, float rate) {
		this.from = from;
		this.to = to;
		this.rate = rate;
	}

	public Currency getFrom() {
		return from;
	}

	public void setFrom(Currency from) {
		this.from = from;
	}

	public Currency getTo() {
		return to;
	}

	public void setTo(Currency to) {
		this.to = to;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

}
