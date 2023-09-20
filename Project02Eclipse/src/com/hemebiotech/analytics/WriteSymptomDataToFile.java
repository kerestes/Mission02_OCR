package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    
    private String filepath;

    /**
     * 
     * @param filepath a full or partial path to output file
     */
    public WriteSymptomDataToFile (String filepath) {
                this.filepath = filepath;
        }

    /**
     * 
     * @param frequencyMap the linkedHashMap preserves the ordering of the list and creates the output String to write on the file
     * @return true for success and false for failure 
     */
    @Override
    public void writeSymptoms(LinkedHashMap<String,Integer> frequencyMap){

        StringBuilder sb = new StringBuilder("========= Result Out ========= \n");

               	for (Map.Entry<String,Integer> pair : frequencyMap.entrySet()) {
                        sb.append("\n" + pair.getKey() + ": " + pair.getValue());
                }

        try {
            FileWriter writer = new FileWriter (filepath);
            writer.write(sb.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
