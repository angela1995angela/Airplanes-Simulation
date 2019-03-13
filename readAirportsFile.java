package Graphics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import Airports.*;
import MyMain.MyMain;

public class readAirportsFile {
	

	//airportsList:ola ta aerodromia pou yparxoun
	public static List<airports> airportsList = new ArrayList<airports>();
	
	public static int[][] airportsToFind = new int[30][60];
	public static String[] airportsPrint = new String[100];
	public int airportsListPos;
	
	/**
	 * reads the airports_default.txt File. Each element in the array airportsToFind is 1 if
	 * there is an airport. Otherwise it is 0. In the airportsList there are all the airports
	 * that exist in this world.
	 * @throws Exception
	 */
	public void readAirFile() throws Exception {
		
		String s = new String("Loading Airports....");
		MyMain.cG.infoList(s);
		try {
		BufferedReader br = new BufferedReader(new FileReader("src/airports_"+MyMain.whichFile+".txt"));
		String line = null;

		for(int i=0;i<30;i++) {
			for(int j=0;j<60;j++) {
				airportsToFind[i][j]=0;
			}
		}
		while(airportsList.size()!=0) {
			airportsList.remove(0);
			
		}
		while ((line=br.readLine()) != null) {
			
			airports airport = new airports();
			String[] values = line.split(",");
			if(values.length!=7) {
				System.out.println("Invalid Airport");
				break;//?????na termatizei!!!!!PWS?
			}
				//ID
				airport.ID = Integer.parseInt(values[0]);
			
				//Position
				airport.position[0]= Integer.parseInt(values[1]);
				airport.position[1]=Integer.parseInt(values[2]);
				
				//apothikeyw se enan pinaka pou yparxoun aerodromia
				airportsToFind[airport.position[0]][airport.position[1]]=1;
		
				//Name
				airport.name = values[3];
			
				//Category
				airport.orientation= Integer.parseInt(values[4]);
			
				//State
				airport.category= Integer.parseInt(values[5]);
			
				//Orientation
				airport.state= Integer.parseInt(values[6]);
			
				//Now I add my new airport in the list
				airportsList.add(airport);			
		}
			
		br.close();	
		}
		catch(FileNotFoundException ex) {
			controlClass.time.stop();
			String a = new String("flights_"+MyMain.whichFile+".txt Not Found");
			MyMain.cG.infoList(a);
		}
	}
	
	
	/**
	 * Prints all the necessary information in the pop-up window :"Airports"
	 */
	
	public static void printAirports() {
		int i=0;
		airportsPrint[1]="";
		for(i=0;i<airportsList.size();i++) {
			airportsPrint[1]=airportsPrint[1] + "ID: "+ airportsList.get(i).ID+
								" Name: " + airportsList.get(i).name +
								" Category: "+ airportsList.get(i).category +
								" State: " + airportsList.get(i).state +
								" Orientation: " + airportsList.get(i).orientation+"\n";
		}
	}

}
