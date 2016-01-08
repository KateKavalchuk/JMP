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
import epam.by.model.HeadSetAccessory;

public class HeadSetFactory implements AbstractFactory {

	public List<AbstractAccessory> createAccessories(String fileName) {
		List<AbstractAccessory> accessories = new ArrayList<>();
		try (FileReader reader = new FileReader(fileName)) {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray headSetAccessories = (JSONArray) jsonObject
					.get("headSetAccessories");
			Iterator i = headSetAccessories.iterator();
			while (i.hasNext()) {
				JSONObject accesssory = (JSONObject) i.next();
				HeadSetAccessory headSetAccessory = new HeadSetAccessory();
				headSetAccessory.setName((String) accesssory.get("name"));
				headSetAccessory.setProducer((String) accesssory
						.get("producer"));
				headSetAccessory.setPrice((String) accesssory.get("price"));
				headSetAccessory.setModel((String) accesssory.get("model"));

				headSetAccessory.setWireless(new Boolean((String) accesssory
						.get("type")));
				accessories.add(headSetAccessory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessories;
	}

}
