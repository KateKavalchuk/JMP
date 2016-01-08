package epam.by.factory;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import epam.by.model.AbstractAccessory;
import epam.by.model.ProtectiveAccessory;

public class ProtectiveGlassFactory implements AbstractFactory {

	public List<AbstractAccessory> createAccessories(String fileName) {
		List<AbstractAccessory> accessories = new ArrayList<>();
		try (FileReader reader = new FileReader(fileName)) {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray protectiveAccessories = (JSONArray) jsonObject
					.get("headSetAccessories");
			Iterator i = protectiveAccessories.iterator();
			while (i.hasNext()) {
				JSONObject accesssory = (JSONObject) i.next();
				ProtectiveAccessory protectiveAccessory = new ProtectiveAccessory();
				protectiveAccessory.setName((String) accesssory.get("name"));
				protectiveAccessory.setProducer((String) accesssory
						.get("producer"));
				protectiveAccessory.setPrice((String) accesssory.get("price"));
				protectiveAccessory.setModel((String) accesssory.get("model"));

				protectiveAccessory.setDiagonal((String) accesssory
						.get("diagonal"));
				protectiveAccessory.setMaterial((String) accesssory
						.get("material"));
				accessories.add(protectiveAccessory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessories;
	}
}
