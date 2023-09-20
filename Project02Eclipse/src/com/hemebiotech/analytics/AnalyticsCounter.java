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

	/**
	 * @return the source file symptom list
	 */
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

	
	/**
	 * @param the source file symptom list (preferred order)
	 * @return a LinkedHashMap with symptoms in the same order as the entry list and with their respective counters
	 */
	public LinkedHashMap<String, Integer> countSymptoms (List<String> symptomsList){
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

		symptomsList.forEach(item -> {
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

	/**
	 * @param a source file symptom list 
	 */
	public void sortSymptoms(List<String> symptomsList){
		Collections.sort(symptomsList, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
					return arg0.compareTo(arg1);
			}

		});
    }

	/**
	 * @param a LinkedHashMap with symptoms and their count
	 */
	public void writeSymptoms(LinkedHashMap<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
}
