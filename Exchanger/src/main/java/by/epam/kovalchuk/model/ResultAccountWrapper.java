package by.epam.kovalchuk.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resultAccounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultAccountWrapper {

	@XmlElement(name = "resultAccount")
	private List<ResultAccount> accounts = new ArrayList<>();

	public ResultAccountWrapper() {
	}

	public List<ResultAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<ResultAccount> accounts) {
		this.accounts = accounts;
	}

}
