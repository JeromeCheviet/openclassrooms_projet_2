package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * <g>Class to count number of symptom in file symptoms.txt</g>
 *
 * @author J.Cheviet
 * @version 1.0.1
 */
public class AnalyticsCounter {

    /**
     * <u>Main class</u>
     *
     * <p>Read the file "symptoms.txt" and put each line into a dictionary <i>TreeMap</i>'s class and implement the
     * number of symptom in alphabetical order.
     * The data are register in the file "result.out"</p>
     */
    public static void main(String[] args) throws Exception {
        //TODO create variable with path file.
        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();

        Map<String, Integer> symptoms = new TreeMap<>();

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
        FileWriter writer = new FileWriter("result.out");

        for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
            writer.write(symptom.getKey() + " : " + symptom.getValue() + "\n");
        }
        writer.close();
    }
}
