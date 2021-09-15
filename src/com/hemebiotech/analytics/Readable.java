package com.hemebiotech.analytics;

import java.util.List;
/**
 * Anything that will <b>read</b> symptom data from a source and put them in a list.
 */
public interface Readable {
    /**
     *
     * @param filePath is the path of file.
     * @return a list of all lines contains in a file.
     */
    List<String> readSymptoms(String filePath);
}
