package de.exxcellent.challenge;

import java.util.ArrayList;

/**
 * Class that contains helper methods. Used in order to:
 * 		* Simplify code readability
 * 		* Reduce code duplication
 * 		* Improve problem generalization
 * 
 * @author kostaivancevic
 *
 */
public class Utils {
	
	
	
	/**
	 * Method for finding the indexes of rows that have minimal spread between column values
	 * @param table - List of shape {N x 2} for spread computation
	 * @return - a list of indexes that correspond to minimal spread rows
	 */
	public static ArrayList<Integer> findMinimumSpread(ArrayList<ArrayList<Double>> table) {
		
		if(table.get(0).size()!= 2) {
			System.out.println("Spread table should be of shape { N x 2 }");
			return null;
		}
		
		ArrayList<Integer> minIndexes = new ArrayList<>();
		double minSpread = Double.MAX_VALUE ;
		
		/* find minimum spread */
		for(int columnCnt = 0; columnCnt < table.size(); columnCnt ++) {
			ArrayList<Double> row = table.get(columnCnt);
			
			if (Math.abs(row.get(0) - row.get(1)) < minSpread) {
				minSpread = Math.abs(row.get(0) - row.get(1));
			}	
		}
		
		/* find entries that match minimum spread */
		for(int columnCnt = 0; columnCnt < table.size(); columnCnt ++) {
			ArrayList<Double> row = table.get(columnCnt);
			
			if (Math.abs(row.get(0) - row.get(1)) == minSpread) {
				minIndexes.add(columnCnt+1);
			}	
		}	

		return minIndexes;
	}

	/**
	 * Method for extracting a set of columns from the data
	 * @param oldTable - starting table for content extraction
	 * @param columnsToExtract - indexes corresponding to the needed collumns
	 * @return
	 */
	public static ArrayList<ArrayList<Double>> extractDoubleColumns(ArrayList<ArrayList<String>> oldTable, int[] columnsToExtract){
		ArrayList<ArrayList<Double>> newTable = new ArrayList<ArrayList<Double>>();
	
		for(int rowCnt = 1;rowCnt < oldTable.size(); rowCnt ++) {
			ArrayList<Double> newRow = new ArrayList<Double>();
			ArrayList<String> oldRow = oldTable.get(rowCnt);
			
			for(int column : columnsToExtract) {
				newRow.add(Double.parseDouble(oldRow.get(column)));
			}
			
			newTable.add(newRow);
			
		}
		return newTable;
	}
	
	/**
	 * Method that extracts column indexes by comparing the names of the:
	 * 		* Needed columns 
	 * 		* Available columns
	 * @param columns - a complete set of data columns
	 * @param desiredColumns - Array of columns that are for extracting
	 * @return - index equivalent to the set of desired columns
	 */
	public static int[] extractColumnIndexes (ArrayList<String> columns, String[] desiredColumns) {
		int[] desiredIndexes = new int[desiredColumns.length];
		
		for(int columnCnt = 0; columnCnt < columns.size(); columnCnt ++) {
			for(int desiredCnt = 0; desiredCnt < desiredColumns.length; desiredCnt ++) {
				if(desiredColumns[desiredCnt].equals(columns.get(columnCnt))) {
					desiredIndexes[desiredCnt] = columnCnt;
				}
			}
			
		}
		return desiredIndexes;
	}
}
