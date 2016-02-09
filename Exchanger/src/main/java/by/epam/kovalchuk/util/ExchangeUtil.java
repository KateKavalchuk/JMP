package by.epam.kovalchuk.util;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExchangeUtil {

	private static final Lock LOCK = new ReentrantLock();

	public static BigDecimal exhange(BigDecimal count, BigDecimal rate) {
		BigDecimal result = null;
		try {
			LOCK.lock();
			result = rate.multiply(count);
		} finally {
			LOCK.unlock();
		}
		return result;
	}

}
