package epam.by.factory;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import epam.by.model.AbstractAccessory;
import epam.by.model.CaseAccessory;

public class CaseFactory implements AbstractFactory {

	public List<AbstractAccessory> createAccessories(String fileName) {
		List<AbstractAccessory> accessories = new ArrayList<>();
		try (FileReader reader = new FileReader(fileName)) {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray caseAccessories = (JSONArray) jsonObject
					.get("caseAccessories");
			Iterator i = caseAccessories.iterator();
			while (i.hasNext()) {
				JSONObject accesssory = (JSONObject) i.next();
				CaseAccessory caseAccessory = new CaseAccessory();
				caseAccessory.setName((String) accesssory.get("name"));
				caseAccessory.setProducer((String) accesssory.get("producer"));
				caseAccessory.setPrice((String) accesssory.get("price"));
				caseAccessory.setModel((String) accesssory.get("model"));
				caseAccessory.setType((String) accesssory.get("type"));
				accessories.add(caseAccessory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessories;
	}
}
