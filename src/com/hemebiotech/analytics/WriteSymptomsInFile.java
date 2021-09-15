package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * <b>Class to write symptoms in alphabetical order in a file.</b>
 */
public class WriteSymptomsInFile implements Writable{

    /**
     * <p>This method write all occurrence of each symptom contain in a dictionary in alphabetical order.</p>
     * <p>If they are some issue with the file, the application is stopped.</p>
     *
     * @param resultPath is the path where the list of symptoms and the number of occurrences are written.
     * @param symptoms is the raw dictionary contains all symptoms and number of occurrence for each.
     */
    @Override
    public void writeSymptoms(String resultPath, Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter(resultPath);

            // each symptom in Map are sorted in alphabetical order and write into the file.
            for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
                writer.write(symptom.getKey() + " : " + symptom.getValue() + "\n");
            }

            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("The file " + resultPath + " do not exist !");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("The file " + resultPath + " can't be read " + e.getMessage());
            System.exit(-1);
        }
    }
}
