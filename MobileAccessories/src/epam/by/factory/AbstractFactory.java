package epam.by.factory;

import java.util.List;

import epam.by.model.AbstractAccessory;

public interface AbstractFactory {

	List<AbstractAccessory> createAccessories(String fileName);
}
