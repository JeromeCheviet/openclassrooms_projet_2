package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * <b>Class to read and count each symptom from a file and write each occurrence for all symptoms in a file
 * in alphabetical order.</b>
 */
public class ProccessSymptomsFromFile implements Proccesssable {

    /**
     * <p>The method read all symptoms contain in a file and create a dictionary with the number of occurrence
     * for each.</p>
     *
     * @param filePath is the path of file that contains the symptoms.
     * @return a raw dictionary with each occurrence for all symptoms contain in "filePath" or null if they are some
     * issue with the file.
     */
    @Override
    public Map readSymptoms(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            Map<String, Integer> symptoms = new TreeMap<>();

            /*
            All symptoms contain in file are count and put in dictionary. The key is symptom's name and the value is
            the number of times it appears in the file.
            */
            while (line != null) {
                /*
                If a symptom already exist in dictionary, increase the value.
                Else, put the symptom in dictionary with the value 1
                */
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
        } catch (IOException e) {
            System.out.println("The file " + filePath + " can't be read " + e.getMessage());
            System.exit(-1);
        }
        return null;
    }

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
