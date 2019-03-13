package Graphics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import Airplanes.*;
import Airports.airports;
import MyMain.MyMain;

public class readFlights {
	
	public static List<Flight> smallFlightsList = new ArrayList<Flight>();
	public static List<Flight> middleFlightsList = new ArrayList<Flight>();
	public static List<Flight> bigFlightsList = new ArrayList<Flight>();
	public static String[] flightsPrint = new String[100]; 
	public static String[] aircraftsPrint = new String[100];
	
	
	public readFlights() throws Exception {
		
		try {
		BufferedReader brPl = new BufferedReader(new FileReader("src/flights_"+MyMain.whichFile+".txt"));
		String line = null;
		int i=-1;
		
		while ((line=brPl.readLine()) != null) {
			
			i++;
			String[] values = line.split(",");
			//akyrh pthsh logw mh egkyrwn orismatwn sto arxeio
			if(values.length!=9) {
				String s = new String("Flights file is invalid in line "+i+"\n");
				MyMain.cG.infoList(s);	
				continue;
			}
			String s = new String(values[5]);
			MyMain.cG.infoList(s);	
			if(Integer.parseInt(values[5])==1) {
				
				Flight flight = new Flight();
				
				flight.airTakeOff = Integer.parseInt(values[2]);
				flight.airLand = Integer.parseInt(values[3]);
				flight.speed = Integer.parseInt(values[6]);
				flight.hight = Integer.parseInt(values[7]);
				flight.fuel = Integer.parseInt(values[8]);
		
				
				check1(flight,values,i);
			}
			else if(Integer.parseInt(values[5])==2) {
				
				Flight flight = new Flight();
				
				flight.airTakeOff = Integer.parseInt(values[2]);
				flight.airLand = Integer.parseInt(values[3]);
				flight.speed = Integer.parseInt(values[6]);
				
				flight.hight = Integer.parseInt(values[7]);
				flight.fuel = Integer.parseInt(values[8]);
				
				check2(flight,values,i);
			}
			else if(Integer.parseInt(values[5])==3) {
				
				Flight flight = new Flight();
				
				flight.airTakeOff = Integer.parseInt(values[2]);
				flight.airLand = Integer.parseInt(values[3]);
				flight.speed = Integer.parseInt(values[6]);
				flight.hight = Integer.parseInt(values[7]);
				flight.fuel = Integer.parseInt(values[8]);
				
				check3(flight,values,i);
			}
			else {
				String l = new String(values[4] + " is invalid\n" );
				MyMain.cG.infoList(l);
			}
			
			
		}
		
		brPl.close();	
		}
		catch (FileNotFoundException ex){
			controlClass.time.stop();
			String l = new String("flights_"+MyMain.whichFile+".txt Not Found");
			MyMain.cG.infoList(l);

		}
		
	}
	
	public void check1(Flight flight,String[] values, int i ) {
		
		
		if(readAirportsFile.airportsList.get(flight.airTakeOff-1).category==2
		|| readAirportsFile.airportsList.get(flight.airLand-1).category==2
		|| flight.speed>Small.maxSpeedFlight
		|| flight.hight>Small.maxHight
		|| flight.fuel>Small.maxFuel
		|| readAirportsFile.airportsList.get(flight.airTakeOff-1).state==0 
		||readAirportsFile.airportsList.get(flight.airLand-1).state==0) {
			
			String s = new String(values[4]+ " is Invalid\n" );
			MyMain.cG.infoList(s);
		}
		else {
			
			String s = new String(values[4] + " is valid\n" );
			MyMain.cG.infoList(s);
			
			flight.ID = Integer.parseInt(values[0]);
			flight.startTime = Integer.parseInt(values[1]);
			flight.name = values[4];
			flight.category = Integer.parseInt(values[5]);
			flight.thesh1=readAirportsFile.airportsList.get(flight.airTakeOff-1).position[0];
			flight.thesh2=readAirportsFile.airportsList.get(flight.airTakeOff-1).position[1];
			flight.stoxos1=readAirportsFile.airportsList.get(flight.airLand-1).position[0];
			flight.stoxos2=readAirportsFile.airportsList.get(flight.airLand-1).position[1];
			
			flight.arxh1=flight.thesh1;
			flight.arxh2=flight.thesh2;
			flight.active=0;
			flight.distance=0;
			flight.koutaki=0;
			flight.distcurrent=0;
			flight.hightcurrent=readMapFile.mapNumbers[flight.thesh1][flight.thesh2];
			flight.move=0;
			flight.lastkoutaki=0;
			if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==1) {
				flight.theshLanding1=flight.stoxos1-1;
				flight.theshLanding2=flight.stoxos2;
			}
			else if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==2) {
				flight.theshLanding1=flight.stoxos1;
				flight.theshLanding2=flight.stoxos2+1;
			}
			else if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==3) {
				flight.theshLanding1=flight.stoxos1+1;
				flight.theshLanding2=flight.stoxos2;
			}
			else if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==4) {
				flight.theshLanding1=flight.stoxos1;
				flight.theshLanding2=flight.stoxos2-1;
			}
			smallFlightsList.add(flight);
		}
		
		
		
		
	}
	public void check2(Flight flight,String[] values,int i) {
		
		if(readAirportsFile.airportsList.get(flight.airTakeOff-1).category==1 
		||readAirportsFile.airportsList.get(flight.airLand-1).category==1
		|| flight.speed>Middle.maxSpeedFlight
		|| flight.hight>Middle.maxHight
		|| flight.fuel>Middle.maxFuel
		|| readAirportsFile.airportsList.get(flight.airTakeOff-1).state==0 
		||readAirportsFile.airportsList.get(flight.airLand-1).state==0) {
			
			String s = new String(values[4] + " is Invalid\n" );
			MyMain.cG.infoList(s);
			
			
		}
		else {
			
			String s = new String(values[4] + " is valid\n");
			MyMain.cG.infoList(s);
			
			flight.ID = Integer.parseInt(values[0]);
			flight.startTime = Integer.parseInt(values[1]);
			flight.name = values[4];
			flight.category = Integer.parseInt(values[5]);
			flight.thesh1=readAirportsFile.airportsList.get(flight.airTakeOff-1).position[0];
			flight.thesh2=readAirportsFile.airportsList.get(flight.airTakeOff-1).position[1];
			flight.stoxos1=readAirportsFile.airportsList.get(flight.airLand-1).position[0];
			flight.stoxos2=readAirportsFile.airportsList.get(flight.airLand-1).position[1];
			flight.arxh1=flight.thesh1;
			flight.arxh2=flight.thesh2;
			flight.active=0;
			flight.distance=0;
			flight.koutaki=0;
			flight.distcurrent=0;
			flight.hightcurrent=readMapFile.mapNumbers[flight.thesh1][flight.thesh2];
			flight.move=0;
			flight.lastkoutaki=0;
			if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==1) {
				flight.theshLanding1=flight.stoxos1-1;
				flight.theshLanding2=flight.stoxos2;
			}
			else if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==2) {
				flight.theshLanding1=flight.stoxos1;
				flight.theshLanding2=flight.stoxos2+1;
			}
			else if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==3) {
				flight.theshLanding1=flight.stoxos1+1;
				flight.theshLanding2=flight.stoxos2;
			}
			else if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==4) {
				flight.theshLanding1=flight.stoxos1;
				flight.theshLanding2=flight.stoxos2-1;
			}
			
			middleFlightsList.add(flight);
		}
		
		
	}
	public void check3(Flight flight,String[] values,int i) {
	
		if(readAirportsFile.airportsList.get(flight.airTakeOff-1).category==1 
		||readAirportsFile.airportsList.get(flight.airLand-1).category==1
		|| flight.speed>Big.maxSpeedFlight
		|| flight.hight>Big.maxHight
		|| flight.fuel>Big.maxFuel
		|| readAirportsFile.airportsList.get(flight.airTakeOff-1).state==0 
		||readAirportsFile.airportsList.get(flight.airLand-1).state==0 ) {
					
			String s = new String(values[4]+ " is Invalid\n" );
			MyMain.cG.infoList(s);
				
			
		}
		else {
			
			String s = new String(values[4] + " is valid\n");
			MyMain.cG.infoList(s);
			
			
			flight.ID = Integer.parseInt(values[0]);
			flight.startTime = Integer.parseInt(values[1]);
			flight.name = values[4];
			flight.category = Integer.parseInt(values[5]);
			flight.thesh1=readAirportsFile.airportsList.get(flight.airTakeOff-1).position[0];
			flight.thesh2=readAirportsFile.airportsList.get(flight.airTakeOff-1).position[1];
			flight.stoxos1=readAirportsFile.airportsList.get(flight.airLand-1).position[0];
			flight.stoxos2=readAirportsFile.airportsList.get(flight.airLand-1).position[1];
			flight.arxh1=flight.thesh1;
			flight.arxh2=flight.thesh2;
			flight.active=0;
			flight.distance=0;
			flight.koutaki=0;
			flight.distcurrent=0;
			flight.hightcurrent=readMapFile.mapNumbers[flight.thesh1][flight.thesh2];
			flight.move=0;
			flight.lastkoutaki=0;
			if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==1) {
				flight.theshLanding1=flight.stoxos1-1;
				flight.theshLanding2=flight.stoxos2;
			}
			else if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==2) {
				flight.theshLanding1=flight.stoxos1;
				flight.theshLanding2=flight.stoxos2+1;
			}
			else if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==3) {
				flight.theshLanding1=flight.stoxos1+1;
				flight.theshLanding2=flight.stoxos2;
			}
			else if(readAirportsFile.airportsList.get(flight.airLand-1).orientation==4) {
				flight.theshLanding1=flight.stoxos1;
				flight.theshLanding2=flight.stoxos2-1;
			}
			
			bigFlightsList.add(flight);
		}
	}
	
	public static void printFlights() {
		int i=0;
		flightsPrint[1]=" ";
		for(i=0;i<smallFlightsList.size();i++) {
			flightsPrint[1]=flightsPrint[1] + "Airport Take Off: "+ smallFlightsList.get(i).airTakeOff+
								" Airport Land: " + smallFlightsList.get(i).airLand +
								" Airplane Category: "+ smallFlightsList.get(i).category +
								" State: " +smallFlightsList.get(i).active + "\n";
		}
		for(i=0;i<middleFlightsList.size();i++) {
			flightsPrint[1]=flightsPrint[1] + "Airport Take Off: "+ middleFlightsList.get(i).airTakeOff+
								" Airport Land: " + middleFlightsList.get(i).airLand +
								" Airplane Category: "+ middleFlightsList.get(i).category +
								" State: " + smallFlightsList.get(i).active + "\n";
		}
		for(i=0;i<bigFlightsList.size();i++) {
			flightsPrint[1]=flightsPrint[1] + "Airport Take Off: "+ bigFlightsList.get(i).airTakeOff+
								" Airport Land: " + bigFlightsList.get(i).airLand +
								" Airplane Category: "+ bigFlightsList.get(i).category +
								" State: " + smallFlightsList.get(i).active+"\n";
		}
	}
	
	public static void printAircrafts() {
		int i=0;
		aircraftsPrint[1]=" ";
		for(i=0;i<smallFlightsList.size();i++) {
			if(smallFlightsList.get(i).active==1) {
				aircraftsPrint[1]=aircraftsPrint[1] + "Airport Take Off: "+ smallFlightsList.get(i).airTakeOff+
									" Airport Land: " + smallFlightsList.get(i).airLand +
									" Speed: "+ smallFlightsList.get(i).speed +
									" Hight: " + smallFlightsList.get(i).hight +
									" Fuel: " +smallFlightsList.get(i).fuel +"\n";
			}
		}
		for(i=0;i<middleFlightsList.size();i++) {
			if(middleFlightsList.get(i).active==1) {
				aircraftsPrint[1]=aircraftsPrint[1] + "Airport Take Off: "+ middleFlightsList.get(i).airTakeOff+
									" Airport Land: " + middleFlightsList.get(i).airLand +
									" Speed: "+ middleFlightsList.get(i).speed +
									" Hight: " + middleFlightsList.get(i).hight+ 
									" Fuel: " +middleFlightsList.get(i).fuel + "\n";
			}
		}
		for(i=0;i<bigFlightsList.size();i++) {
			if(bigFlightsList.get(i).active==1) {
				aircraftsPrint[1]=aircraftsPrint[1] + "Airport Take Off: "+ bigFlightsList.get(i).airTakeOff+
									" Airport Land: " + bigFlightsList.get(i).airLand +
									" Airplane Category: "+ bigFlightsList.get(i).category +
									" Speed: "+ bigFlightsList.get(i).speed +
									" Hight: " + bigFlightsList.get(i).hight+ 
									" Fuel: " +bigFlightsList.get(i).fuel + "\n";
			}
		}
	}

}
