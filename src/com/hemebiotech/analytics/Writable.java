package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Write a Map contents with String's key and Integer's value everywhere.
 */
public interface Writable {
    /**
     * @param resultPath is the path where the list of symptoms and the number of occurrences are written.
     * @param symptoms is the raw dictionary contains all symptoms and number of occurrence for each.
     */
    void writeSymptoms(String resultPath, Map<String, Integer> symptoms);
}
