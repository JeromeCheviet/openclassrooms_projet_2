package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

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
        String resultPath = "result.out";
        // Create list with symptoms from a file.
        List<String> symptomsList = new ReadSymptomsFromFile().readSymptoms(filePath);
        // Create a dictionary from symptoms's list.
        Map symptoms = new ProccessSymptoms().sortSymptoms(symptomsList);
        // Write the dictionary into a file
        new WriteSymptomsInFile().writeSymptoms(resultPath, symptoms);
    }
}
