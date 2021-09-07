package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Class to count number of symptom in file symptoms.txt
 *
 * @author J.Cheviet
 * @version 1.0.0
 *
 */
public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	/**
	 * Main class
	 *
	 * Read all line of file symptoms.txt, count the number of headache, rash and deleted pupils.
	 * The total is register in file result.out
	 */
	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		//TODO Change while to method
		while (line != null) {
			System.out.println("symptom from file: " + line);
			
			//TODO study array to recording all symptom in file
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		//TODO transform to method
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
