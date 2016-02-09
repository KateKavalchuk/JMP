package by.epam.kovalchuk.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import by.epam.kovalchuk.exception.ExchangerException;
import by.epam.kovalchuk.executor.Executor;
import by.epam.kovalchuk.model.Account;
import by.epam.kovalchuk.model.CurrencyValue;
import by.epam.kovalchuk.model.ExchangeRate;
import by.epam.kovalchuk.model.ResultAccount;
import by.epam.kovalchuk.util.ExchangeUtil;
import by.epam.kovalchuk.util.FileUtil;

public class RunnableExchangeService implements Runnable {

	private static final Lock LOCK = new ReentrantLock();
	private static final Logger LOGGER = Logger.getLogger(Executor.class);

	private ExchangeRatesService exchangeRatesService = new ExchangeRatesService();
	private AccountService accountService = new AccountService();
	private ResultAccountService resultAccountService = new ResultAccountService();

	@Override
	public void run() {
		try {
			LOGGER.info("Executor service started scanning...");
			List<File> files = FileUtil.readAllFilesFromDirectory("accounts");
			boolean flag = false;
			do {
				flag = false;
				for (File file : files) {
					ResultAccount resultAccount = exchange(file);
					if (resultAccount != null) {
						int accountId = Integer.parseInt(file.getName().split(
								"account_")[1].split(".xml")[0]);
						if (resultAccount != null) {
							try {
								LOCK.lock();
								accountService.updateAccount(
										resultAccount.getAccount(), accountId);
								resultAccountService.addResultAccount(
										resultAccount, accountId);
							} finally {
								LOCK.unlock();
							}
							flag = true;
						}
					}
				}
			} while (flag);
		} catch (ExchangerException e) {
			e.printStackTrace();
		}
	}

	public ResultAccount exchange(File file) throws ExchangerException {
		try {
			LOCK.lock();
			Account account = accountService.getAccount(Integer.parseInt(file
					.getName().split("account_")[1].split(".xml")[0]));
			for (CurrencyValue currencyValue : account.getCurrencyValues()) {
				if (!currencyValue.isChecked()) {
					ResultAccount resultAccount = null;
					BigDecimal rate = getRate(currencyValue);
					if (rate != null) {
						resultAccount = new ResultAccount();
						currencyValue.setChecked(true);
						BigDecimal result = ExchangeUtil.exhange(
								new BigDecimal(currencyValue.getCount()), rate);
						resultAccount.setResult(result);
						resultAccount.setAccount(account);
					}
					return resultAccount;
				}
			}
		} finally {
			LOCK.unlock();
		}
		return null;
	}

	private BigDecimal getRate(CurrencyValue currencyValue)
			throws ExchangerException {
		List<ExchangeRate> exchangeRates = exchangeRatesService
				.getAllExchangesRates();
		for (ExchangeRate exchangeRate : exchangeRates) {
			if (exchangeRate.getFrom().getCode()
					.equals(currencyValue.getFromCurrency().getCode())
					&& exchangeRate.getTo().getCode()
							.equals(currencyValue.getToCurrency().getCode()))
				return new BigDecimal(exchangeRate.getRate());
		}
		return null;

	}
}
