package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Anything that will <b>read</b> symptom data from a source and <b>count</b> number of occurrence.
 */
public interface Proccesssable {
    /**
     * If no data is available, return an empty List
     *
     * @param symptomsList is a list contains the symptoms.
     * @return a raw dictionary of all Symptoms obtained from a data source and number of occurrence for each.
     */
    Map sortSymptoms(List<String> symptomsList);
}
