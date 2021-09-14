package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomsInFile implements writable{
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
