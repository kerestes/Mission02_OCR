package com.hemebiotech.analytics;

import java.util.LinkedHashMap;

public interface ISymptomWriter {
    void writeSymptoms (LinkedHashMap<String,Integer> frequencyMap);
}
