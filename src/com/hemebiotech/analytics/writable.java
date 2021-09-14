package com.hemebiotech.analytics;

import java.util.Map;

public interface writable {
    void writeSymptoms(String resultPath, Map<String, Integer> symptoms);
}
