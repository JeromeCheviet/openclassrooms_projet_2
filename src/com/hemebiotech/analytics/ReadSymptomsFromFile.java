package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>Class to read all symptoms and put in a list from a file</b>
 */
public class ReadSymptomsFromFile implements Readable {
    /**
     * <p>The method read all symptoms contain in a file and create a dictionary with the number of occurrence
     * for each.</p>
     *
     * @param filePath is the path of file that contains the symptoms.
     * @return a list with each occurrence for all symptoms contain in "filePath" or null if they are some
     * issue with the file.
     */
    @Override
    public List<String> readSymptoms(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            // Put all line in a list.
            List<String> symptomsList = new ArrayList<>();
            while (line != null) {
                symptomsList.add(line);
                line = reader.readLine();
            }
            reader.close();
            return symptomsList;
            
        } catch (FileNotFoundException e) {
            System.out.println("The file " + filePath + " do not exist !");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("The file " + filePath + " can't be read " + e.getMessage());
            System.exit(-1);
        }
        return null;
    }
}
