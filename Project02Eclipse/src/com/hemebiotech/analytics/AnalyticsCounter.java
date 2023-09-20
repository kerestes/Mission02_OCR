package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class AnalyticsCounter {

	private WriteSymptomDataToFile writer;
	private ReadSymptomDataFromFile reader;

	public AnalyticsCounter(ReadSymptomDataFromFile reader, WriteSymptomDataToFile writer) {
		this.writer = writer;
		this.reader = reader;
	}

	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

	public LinkedHashMap<String, Integer> countSymptoms (List<String> listSymptom){
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

		listSymptom.forEach(item -> {
				if(lhm.containsKey(item)){
						int i = lhm.get(item);
						i++;
						lhm.put(item, i);
				} else {
						lhm.put(item, 1);
				}
		});

		return lhm;
    }

	public void sortSymptoms(List<String> list){
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
					return arg0.compareTo(arg1);
			}

		});
    }

	public void writeSymptoms(LinkedHashMap<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
}
