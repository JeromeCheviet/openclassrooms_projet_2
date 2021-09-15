package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <b>Class to count each symptom from a file and write each occurrence for all symptoms in a dictionary</b>
 */
public class ProccessSymptoms implements Proccesssable {

    /**
     * <p>The method count all occurrences from list and create a dictionary with symptoms name for Key and
     * number of occurrence for value</p>
     *
     * @param symptomsList is a list contains the symptoms.
     * @return a dictionary contain all symptoms with each number of occurrence. If they are any issue, return an empty dictionary.
     */
    @Override
    public Map sortSymptoms(List<String> symptomsList) {
        try {
            Map<String, Integer> symptoms = new TreeMap<>();
            for (String list : symptomsList) {
                /*
                If a symptom already exist in dictionary, increase the value.
                Else, put the symptom in dictionary with the value 1
                */
                if (symptoms.containsKey(list)) {
                    int newCount = symptoms.get(list) + 1;
                    symptoms.put(list, newCount);
                } else {
                    symptoms.put(list, 1);
                }
            }
            return symptoms;
        } catch (Exception e) {
            System.out.println("The file do not exist !");
            System.exit(-1);
            return null;
        }
    }
}
