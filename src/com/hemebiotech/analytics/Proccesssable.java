package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will <b>read</b> symptom data from a source and <b>write</b> number of symptom in a file.
 */
public interface Proccesssable {
    /**
     * If no data is available, return an empty List
     *
     * @param filePath is the path of file that contains the symptoms.
     * @return a raw dictionary of all Symptoms obtained from a data source and number of occurrence for each.
     */
    Map readSymptoms(String filePath);

    /**
     *
     * @param resultPath is the path where the list of symptoms and the number of occurrences are written.
     * @param symptoms is the raw dictionary contains all symptoms and number of occurrence for each.
     */
    void writeSymptoms(String resultPath, Map<String, Integer> symptoms);
}
