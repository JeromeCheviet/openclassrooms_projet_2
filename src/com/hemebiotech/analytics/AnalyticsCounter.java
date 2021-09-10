package com.hemebiotech.analytics;

import java.io.*;
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
        String filePath = "symptoms.txt";
        try {

            Map<String, Integer> symptoms = new ReadSymptomsFromFile().readSymptoms(filePath);

            //TODO transform to method
            FileWriter writer = new FileWriter("result.out");

            for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
                writer.write(symptom.getKey() + " : " + symptom.getValue() + "\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file " + filePath + " do not exist !");
            System.exit(-1);
        }
    }
}
