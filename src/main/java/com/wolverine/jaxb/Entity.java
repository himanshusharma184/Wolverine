package com.wolverine.jaxb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
 * @author himanshusharma
 */
@XmlRootElement
public class Entity {

	@XmlElementWrapper(name = "entityMap")
	Map<String, ListWrapper> intgerStringArrMap;

	@XmlElementWrapper(name = "mappingEntity")
	List<EntityValue> entityValueList;
	@XmlElementWrapper(name = "collectionMap")
	Map<String, ListWrapper> collectionMap;

	Entity() {

	}

	@XmlTransient
	public List<EntityValue> getEntityValueList() {
		return entityValueList;
	}

	public void setEntityValueList(List<EntityValue> entityValueList) {
		this.entityValueList = entityValueList;
	}

	@XmlTransient
	public Map<String, ListWrapper> getCollectionMap() {
		return collectionMap;
	}

	public void setCollectionMap(Map<String, ListWrapper> collectionMap) {
		this.collectionMap = collectionMap;
	}

	public Map<String, ListWrapper> getEtity() {

		return intgerStringArrMap;

	}

	public void setEntity(Map<String, ListWrapper> map) {
		this.intgerStringArrMap = map;
	}

	public static void main(String[] args) throws JAXBException, IOException {
		Map<String, ListWrapper> intgerStringArrMap = new HashMap<String, ListWrapper>();
		Map<String, String> dataType = new HashMap<String, String>();
		ListWrapper wrapper = new ListWrapper();
		for (int i = 0; i < 2; i++) {
			ArrayList<String> stringArrayList = new ArrayList<String>();

			dataType.put("name", "String");
			dataType.put("address", "String");
			wrapper.setDataType(dataType);
			for (int j = 0; j < 2; j++) {
				stringArrayList.add("2");
			}
			intgerStringArrMap.put("employee", wrapper);
		}
		File file = File.createTempFile("temp", "xml");
		Entity box = new Entity();
		box.setEntity(intgerStringArrMap);
		Map<String, ListWrapper> collectionMapList = new HashMap<String, ListWrapper>();
		collectionMapList.put("abcd", wrapper);
		List<EntityValue> entityValueLists = new ArrayList<EntityValue>();
		EntityValue entityValue = new EntityValue();
		entityValue.setId("1");
		entityValue.setName("Student");
		entityValue.setKey("studentId");
		entityValueLists.add(entityValue);
		box.setEntityValueList(entityValueLists);
		box.setCollectionMap(collectionMapList);
		JAXBContext jc = JAXBContext.newInstance(Entity.class);
		jc.createMarshaller().marshal(box, System.out);
		System.out.println();
		jc.createMarshaller().marshal(box, file);

		JAXBContext jaxbContext = JAXBContext.newInstance(Entity.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Entity empMap = (Entity) jaxbUnmarshaller.unmarshal(file);
		file.deleteOnExit();
		for (String empId : empMap.getEtity().keySet()) {
			System.out.println(empMap.getEtity().get(empId).getDataType()
					.values().iterator().next());
		}
		JAXBContext jaxbContext1 = JAXBContext.newInstance(Entity.class);
		Unmarshaller jaxbUnmarshaller1 = jaxbContext1.createUnmarshaller();
		Entity empMap1 = (Entity) jaxbUnmarshaller1.unmarshal(new File(
				"src/main/resources/sample.xml"));
		for (String empId1 : empMap.getEtity().keySet()) {
			System.out.println(empMap.getEtity().get(empId1).getDataType()
					.values().iterator().next());
		}
		if (empMap.equals(empMap1)) {
			System.out.println("true!!!");
		}
	}
}
