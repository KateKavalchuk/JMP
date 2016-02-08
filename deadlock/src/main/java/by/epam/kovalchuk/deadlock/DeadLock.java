package by.epam.kovalchuk.deadlock;

import org.apache.log4j.Logger;

public class DeadLock {
	private static final Logger LOGGER = Logger.getLogger(DeadLock.class);

	public static void main(String[] args) {
		final String resource1 = "resource1";
		final String resource2 = "resource2";
		Thread firstThread = new Thread() {
			@Override
			public void run() {
				synchronized (resource1) {
					LOGGER.info("Thread 1: locked resource 1");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						LOGGER.error(e.getMessage());
					}
					synchronized (resource2) {
						LOGGER.info("Thread 1: locked resource 2");
					}
				}
			}
		};

		Thread secondThread = new Thread() {
			@Override
			public void run() {
				synchronized (resource2) {
					LOGGER.info("Thread 2: locked resource 2");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						LOGGER.error(e.getMessage());
					}
					synchronized (resource1) {
						LOGGER.info("Thread 2: locked resource 1");
					}
				}
			}
		};
		firstThread.start();
		secondThread.start();
	}
}
