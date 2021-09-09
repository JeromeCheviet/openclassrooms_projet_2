package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to count number of symptom in file symptoms.txt
 *
 * @author J.Cheviet
 * @version 1.0.0
 */
public class AnalyticsCounter {

    /**
     * Main class
     * <p>
     * Read all line of file symptoms.txt, count the number of headache, rash and deleted pupils.
     * The total is register in file "result.out"
     */
    public static void main(String[] args) throws Exception {
        //TODO create variable with path file.
        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();

        Map<String, Integer> symptoms = new HashMap<>();

        //TODO Change while to method
        while (line != null) {
            if (symptoms.containsKey(line)) {
                int newCount = symptoms.get(line) + 1;
                symptoms.put(line, newCount);
            } else {
                symptoms.put(line, 1);
            }

            line = reader.readLine();
        }
        reader.close();

        //TODO transform to method
        Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);

        FileWriter writer = new FileWriter ("result.out");

        for (Map.Entry<String,Integer> symptom : sortedSymptoms.entrySet()) {
            writer.write(symptom.getKey() + " : " + symptom.getValue() + "\n");
        }
        writer.close();
    }
}
