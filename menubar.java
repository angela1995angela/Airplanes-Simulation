package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import MyMain.*;

public class menubar implements ActionListener{
	
	JMenuBar menubar = new JMenuBar(); 
	JMenu game = new JMenu("Game");
	JMenuItem start = new JMenuItem("Start");
	JMenuItem stop = new JMenuItem("Stop");
	JMenuItem load = new JMenuItem("Load");
	JMenuItem exit = new JMenuItem("Exit");
	
	
	JMenu simulation = new JMenu("Simulation");
	JMenuItem airports = new JMenuItem("Airports");
	JMenuItem aircrafts = new JMenuItem("Aircrafts");
	JMenuItem flights = new JMenuItem("Flights");
	
	
	public menubar() {
		
		menubar.add(game);
		start.addActionListener(this);
		game.add(start);
		stop.addActionListener(this);
		game.add(stop);
		load.addActionListener(this);
		game.add(load);
		exit.addActionListener(this);
		game.add(exit);
		menubar.add(simulation);
		airports.addActionListener(this);
		simulation.add(airports);
		aircrafts.addActionListener(this);
		simulation.add(aircrafts);
		flights.addActionListener(this);
		simulation.add(flights);
		
	}


	public void actionPerformed(ActionEvent e) {
		

		Object obj = e.getSource();
		if(obj==start) {
			if (MyMain.startFlag==0){
			
			MyMain.startFlag=1;	
			controlClass.time.start();
			try {
				new readFlights();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			else {
				int i=0;
				while(readFlights.smallFlightsList.size()!=0) {
					MyMain.cG.returnPrevious(readFlights.smallFlightsList.get(0).thesh1,
							readFlights.smallFlightsList.get(0).thesh2);
					readFlights.smallFlightsList.remove(i);
				}
				while(readFlights.middleFlightsList.size()!=0) {
					MyMain.cG.returnPrevious(readFlights.middleFlightsList.get(0).thesh1,
							readFlights.middleFlightsList.get(0).thesh2);
					readFlights.middleFlightsList.remove(i);
				}
				while(readFlights.bigFlightsList.size()!=0) {
					MyMain.cG.returnPrevious(readFlights.bigFlightsList.get(0).thesh1,
							readFlights.bigFlightsList.get(0).thesh2);
					readFlights.bigFlightsList.remove(i);
				}
				createGraphics.numOfAircrafts=0;
				createGraphics.numOfCrashes=0;
				createGraphics.numOfLandings=0;
				createGraphics.infoList.setText(null);
				
				MyMain.cG = new createGraphics();
				MyMain.cG.MakeJpanel();
				MyMain.cG.MakeMenubar();
				MyMain.cG.infoList("Hello");
				MyMain.cG.MakeMap();
				MyMain.cG.MakeNorth();
				try {
					new readFlights();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				controlClass.counter=-1;
				controlClass.time.start();
			
			}
		}
		else if(obj==stop) {
			controlClass.time.stop();
			
		}
		else if(obj==load) {
			controlClass.time.stop();
			popWindowLoad.name="Load File";
			popWindowLoad pop = new popWindowLoad();
			int i=0;
			while(readFlights.smallFlightsList.size()!=0) {
				MyMain.cG.returnPrevious(readFlights.smallFlightsList.get(0).thesh1,
						readFlights.smallFlightsList.get(0).thesh2);
				readFlights.smallFlightsList.remove(i);
			}
			while(readFlights.middleFlightsList.size()!=0) {
				MyMain.cG.returnPrevious(readFlights.middleFlightsList.get(0).thesh1,
						readFlights.middleFlightsList.get(0).thesh2);
				readFlights.middleFlightsList.remove(i);
			}
			while(readFlights.bigFlightsList.size()!=0) {
				MyMain.cG.returnPrevious(readFlights.bigFlightsList.get(0).thesh1,
						readFlights.bigFlightsList.get(0).thesh2);
				readFlights.bigFlightsList.remove(i);
			}
			createGraphics.numOfAircrafts=0;
			createGraphics.numOfCrashes=0;
			createGraphics.numOfLandings=0;
			createGraphics.infoList.setText(null);
			MyMain.cG = new createGraphics();
			MyMain.cG.MakeJpanel();
			MyMain.cG.MakeMenubar();
			MyMain.cG.infoList("Hello");
			MyMain.cG.MakeMap();
			MyMain.cG.MakeNorth();
			try {
				new readFlights();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			controlClass.counter=-1;
			controlClass.time.start();
			
		}
		else if(obj==exit) {
			
			System.exit(0);
		}
		else if(obj==airports) {
			
			
			popWindowAirports.name = "Airports";
			popWindowAirports pop = new popWindowAirports();
			
		}
		else if(obj==aircrafts) {
			popWindowAircrafts.name="Aircrafts";
			popWindowAircrafts pop = new popWindowAircrafts();
		}
		else if(obj==flights) {
			popWindowFlights.name="Flights";
			popWindowFlights pop = new popWindowFlights();
		
		}
		
	}
}