package br.edu.ifsp.arq.web1.model;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {
	
	public List<Person> getPersons(String persons) {
		List<Person> list = new ArrayList<>();
		if(persons.length() > 0) {
			String[] lines = persons.split("\n");
			for(int i = 0; i < lines.length; i++) {
				String[] data = lines[i].split("\\s*;\\s*");
				if(data.length == 3) {
					Person person = new Person(data[0], data[1], data[2]);
					list.add(person);
				}
			}
		}
		return list;
	}
}