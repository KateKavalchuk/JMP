package epam.by.executor;

import java.util.List;

import epam.by.factory.AbstractFactory;
import epam.by.factory.CaseFactory;
import epam.by.holder.FactoryHolder;
import epam.by.model.AbstractAccessory;

public class Executor {

	private static final String fileName = "D:\\accessories.json";

	public static void main(String[] args) {
		FactoryHolder holder = new FactoryHolder();

		AbstractFactory caseFactory = new CaseFactory();
		List<AbstractAccessory> cases = holder.createAccessories(fileName,
				caseFactory);
		
	}
}
