package com.hemebiotech.analytics;

import java.util.ArrayList;
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
        try {
            //ReadSymptomDataFromFile symptomList = new ReadSymptomDataFromFile(filePath);
            //List<String> symptomList = new ReadSymptomDataFromFile(filePath);
            //symptomList.GetSymptoms();
            List<String> symptomsList = new ProccessSymptomsFromFile().makeList(filePath);

            for (String list: symptomsList){
                System.out.println(list);
            }

            // Create a dictionary from a file.
            Map symptoms = new ProccessSymptomsFromFile().readSymptoms(symptomsList);
            // Write the dictionary into a file.
            //new ProccessSymptomsFromFile().writeSymptoms(resultPath, symptoms);
            new WriteSymptomsInFile().writeSymptoms(resultPath, symptoms);

        } catch (Exception e) {
            System.out.println("an issue has occurred : "+ e);
            System.exit(-1);
        }
    }
}
