package com.hemebiotech.analytics;

import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        WriteSymptomDataToFile writer = new WriteSymptomDataToFile("Mission02_OCR/Project02Eclipse/Result.out");
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Mission02_OCR/Project02Eclipse/symptoms.txt");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms();
        analyticsCounter.sortSymptoms(symptoms);
        LinkedHashMap<String, Integer> mapSymptpms = analyticsCounter.countSymptoms(symptoms);
        analyticsCounter.writeSymptoms(mapSymptpms);

    }
}
