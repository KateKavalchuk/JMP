package by.epam.kovalchuk.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import by.epam.kovalchuk.exception.ExchangerException;
import by.epam.kovalchuk.model.Account;
import by.epam.kovalchuk.model.Currency;
import by.epam.kovalchuk.model.CurrencyValue;
import by.epam.kovalchuk.model.ExchangeRate;
import by.epam.kovalchuk.service.AccountService;
import by.epam.kovalchuk.service.CurrencyService;
import by.epam.kovalchuk.service.ExchangeRatesService;
import by.epam.kovalchuk.service.RunnableExchangeService;

public class Executor {
	// private static final String MENU =
	// "Schoose menu point:\n 1)Add new account.\n 2)Create exchange rate.\n 3)Exit.";
	private static CurrencyService currencyService = new CurrencyService();
	private static AccountService accountService = new AccountService();
	private static ExchangeRatesService exchangeRatesService = new ExchangeRatesService();

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		service.scheduleAtFixedRate(new RunnableExchangeService(), 0, 30,
				TimeUnit.SECONDS);
		/*
		 * Scanner scanner = new Scanner(System.in); while (true) {
		 * System.out.println(MENU); int menuPoint = scanner.nextInt(); switch
		 * (menuPoint) { case 1: { try { addAccount();
		 * LOGGER.info("Account has been added..."); } catch (ExchangerException
		 * e) { e.printStackTrace(); } } break; case 2: { try {
		 * addExhangeRate(); LOGGER.info("Exchange rate has been added..."); }
		 * catch (ExchangerException e) { e.printStackTrace(); } } break; case
		 * 3: { LOGGER.info("Executor service shutdowning...");
		 * executorService.shutdown(); System.exit(0); } break; default: break;
		 * } }
		 */
	}

	private static void addAccount() throws ExchangerException {
		Account account = createAccount();
		accountService.addAccount(account);
	}

	private static void addExhangeRate() throws ExchangerException {
		exchangeRatesService.addExchangeService(createExchangeRate());
	}

	private static Account createAccount() throws ExchangerException {
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();
		List<CurrencyValue> currencyValues = new ArrayList<>();
		boolean flag = true;
		List<Currency> currencies = null;
		while (flag) {
			currencies = currencyService.loadAllCurriencies();
			CurrencyValue currencyValue = new CurrencyValue();
			System.out.println("Choose FROM currency:");
			int i = 1;
			for (Currency currency : currencies) {
				System.out.println(i + " " + currency.getShortName());
				i++;
			}
			int fromId = -1;
			boolean errorFlag;
			do {
				errorFlag = false;
				fromId = scanner.nextInt();
				if (fromId < 0 || fromId > currencies.size()) {
					System.out
							.println("Sorry, but you entered a wrong currency number!");
					errorFlag = true;
				}
			} while (errorFlag);
			currencyValue.setFromCurrency(currencies.get(fromId - 1));

			System.out.println("Choose TO currency:");
			i = 1;
			for (Currency currency : currencies) {
				System.out.println(i + " " + currency.getShortName());
				i++;
			}
			int toId = -1;
			errorFlag = false;
			do {
				errorFlag = false;
				toId = scanner.nextInt();
				if (toId < 0 || toId > currencies.size()) {
					System.out
							.println("Sorry, but you entered a wrong currency number!");
					errorFlag = true;
				}
			} while (errorFlag);
			currencyValue.setToCurrency(currencies.get(toId - 1));
			System.out.println("Enter account sum:");
			float count = scanner.nextFloat();
			scanner.nextLine();
			currencyValue.setCount(count);
			currencyValues.add(currencyValue);
			System.out
					.println("Continue adding currency values? For YES press 1:");
			String continueAnswer = scanner.nextLine();
			if (!"1".equals(continueAnswer)) {
				flag = false;
			}
		}
		account.setCurrencyValues(currencyValues);
		return account;
	}

	private static ExchangeRate createExchangeRate() throws ExchangerException {
		Scanner scanner = new Scanner(System.in);
		ExchangeRate exchangeRate = new ExchangeRate();
		List<Currency> currencies = currencyService.loadAllCurriencies();
		System.out.println("Choose FROM currency:");
		int i = 1;
		for (Currency currency : currencies) {
			System.out.println(i + " " + currency.getShortName());
			i++;
		}
		int fromId = -1;
		boolean errorFlag;
		do {
			errorFlag = false;
			fromId = scanner.nextInt();
			if (fromId < 0 || fromId > currencies.size()) {
				System.out
						.println("Sorry, but you entered a wrong currency number!");
				errorFlag = true;
			}
		} while (errorFlag);
		exchangeRate.setFrom(currencies.get(fromId - 1));

		System.out.println("Choose TO currency:");
		i = 1;
		for (Currency currency : currencies) {
			System.out.println(i + " " + currency.getShortName());
			i++;
		}
		int toId = -1;
		errorFlag = false;
		do {
			errorFlag = false;
			toId = scanner.nextInt();
			if (toId < 0 || toId > currencies.size()) {
				System.out
						.println("Sorry, but you entered a wrong currency number!");
				errorFlag = true;
			}
		} while (errorFlag);
		exchangeRate.setTo(currencies.get(toId - 1));

		System.out.println("Enter rate:");
		float rate = 0;
		errorFlag = false;
		do {
			rate = scanner.nextFloat();
			if (rate < 0) {
				System.out.println("Sorry, but you entered a wrong rate!");
				errorFlag = true;
			}
		} while (errorFlag);
		exchangeRate.setRate(rate);
		return exchangeRate;
	}
}
