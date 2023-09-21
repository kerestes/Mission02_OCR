package com.hemebiotech.analytics;

import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        ISymptomWriter writer = new WriteSymptomDataToFile("Mission02_OCR/Project02Eclipse/Result.out");
        ISymptomReader reader = new ReadSymptomDataFromFile("Mission02_OCR/Project02Eclipse/symptoms.txt");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms();
        analyticsCounter.sortSymptoms(symptoms);
        LinkedHashMap<String, Integer> mapSymptpms = analyticsCounter.countSymptoms(symptoms);
        analyticsCounter.writeSymptoms(mapSymptpms);

    }
}
