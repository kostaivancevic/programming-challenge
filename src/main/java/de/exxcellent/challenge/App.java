package de.exxcellent.challenge;

import java.util.ArrayList;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
    	
    	String fileName = args[1]; // .csv table name
    	
        // import file from .csv table
    	String treeStructure = "/src/main/resources/de/exxcellent/challenge/";
        String path = System.getProperty("user.dir") + treeStructure + fileName;
        ArrayList<ArrayList<String>> table = Utils.importCsv(path);
        
        // pre-process the table
        if(args[0].toString().equals("--football")){
        	String[] desiredColumns = {"Goals", "Goals Allowed"}; // hard-coded desired columns
        	int[] footballColumns = Utils.extractColumnIndexes(table.get(0), desiredColumns);

        	// derive table with relevant information
        	ArrayList<ArrayList<Double>> footballTable = Utils.extractDoubleColumns(table, footballColumns);
        	
        	// compute the team indexes with smallest Goal Difference
        	ArrayList<Integer> team_indexes = Utils.computeSpread(footballTable);
        	
        	// print teams with minimum spread
        	System.out.println("Teams with minimum goal spread are:");
        	for (int i = 0; i < team_indexes.size(); i++) {
				System.out.println(table.get(team_indexes.get(i)).get(0));
			}
        }
        
        if(args[0].contentEquals("--weather")) {
        	String[] desiredColumns = {"MxT", "MnT"}; // hard-coded desired columns
        	int[] weatherColumns = Utils.extractColumnIndexes(table.get(0), desiredColumns);
        	
        	// derive table with relevant information
        	ArrayList<ArrayList<Double>> weatherTable = Utils.extractDoubleColumns(table, weatherColumns);
          	
        	// compute the team indexes with smallest Goal Difference
        	ArrayList<Integer> day_indexes = Utils.computeSpread(weatherTable);
        	
        	// print teams with minimum spread
        	System.out.println("Days with minimum temperature spread are:");
        	for (int i = 0; i < day_indexes.size(); i++) {
				System.out.println(table.get(day_indexes.get(i)).get(0));
			}
        }
    }
}
