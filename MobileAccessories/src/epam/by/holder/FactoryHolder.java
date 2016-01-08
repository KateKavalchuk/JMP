package epam.by.holder;

import java.util.List;

import epam.by.factory.AbstractFactory;
import epam.by.model.AbstractAccessory;

public class FactoryHolder {

	public List<AbstractAccessory> createAccessories(String fileName,
			AbstractFactory factory) {
		return factory.createAccessories(fileName);
	}
}
