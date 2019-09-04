package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This class contains various methods for importing tabular data in a matrix form
 * @author kostaivancevic
 *
 */
public class ImportFiles {
	
	/**
	 * Method for importing external .CSV files 
	 * @param path - file location
	 * @return - Matrix corresponding to the CSV file
	 */
	public static ArrayList<ArrayList<String>> importCSV(String path) {
        ArrayList<ArrayList<String>> table = new ArrayList<>();

        String row = "";
        BufferedReader csvReader;
        
		try {
			csvReader = new BufferedReader(new FileReader(path));
	        while ((row = csvReader.readLine()) != null) {
	        	// row data placeholder
	            ArrayList<String> data_row = new ArrayList<>();
	            
	            // create a row of data
	            for(String row_entry : row.split(",")) {
	            	data_row.add(row_entry);
	            }
	            
	            // append row to table
	            table.add(data_row);
	        }
	        csvReader.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

        return table;
	}

}
