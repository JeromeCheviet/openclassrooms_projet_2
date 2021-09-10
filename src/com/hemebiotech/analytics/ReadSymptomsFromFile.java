package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * <b>Class to read and count each symptom in a file</b>
 *
 */
public class ReadSymptomsFromFile {

    Map readSymptoms(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            Map<String, Integer> symptoms = new TreeMap<>();

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
            return symptoms;
        } catch (FileNotFoundException e) {
            System.out.println("The file " + filePath + " do not exist !");
            System.exit(-1);
        } catch(IOException e) {
            System.out.println("The file " + filePath + " can't be read " + e.getMessage());
            System.exit(-1);
        }
        return null;
    }
}
