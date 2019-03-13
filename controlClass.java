package Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import Airplanes.Flight;
import MyMain.*;
import Airplanes.*;
public class controlClass {
	
	public static Timer time; //dhlwsh
	public static int counter=-1;
	
	
	
	public static int flagOrient;
	public static List<Flight> smallAirportList = new ArrayList<Flight>();
	public static List<Flight> middleAirportList = new ArrayList<Flight>();
	public static List<Flight> bigAirportList = new ArrayList<Flight>();
	
	
	public controlClass() {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				counter++;
				createGraphics.simulatedTimeLabel.setText("Simulated Time: " + String.format("%02d", counter/60) + ":" + String.format("%02d", counter%60)+"            ");
				createGraphics.aircraftsLabel.setText("Total Aircrafts: " + createGraphics.numOfAircrafts+"           ");
				createGraphics.crashesLabel.setText("Crashes: " + createGraphics.numOfCrashes+"         ");
				createGraphics.landingsLabel.setText("Landings: " + createGraphics.numOfLandings);
				checkEnd();
				checkAll();
			}

			
		};
	
		time = new Timer (83, taskPerformer); //1000->60sec, 1000/12=83->60/12=5sec
		time.setRepeats(true);
	}
	
	public void checkAll() {
		int i;
		for(i=0; i<readFlights.smallFlightsList.size(); i++) {
			checkStartTime(readFlights.smallFlightsList,i,"small");
				if(readFlights.smallFlightsList.get(i).active==1) {
					calcDistance(readFlights.smallFlightsList,i,"small");
					checkFuels(readFlights.smallFlightsList,i,"small");
					if(readFlights.smallFlightsList.get(i).active==1) {
						checkHight(readFlights.smallFlightsList,i,"small");
						if(readFlights.smallFlightsList.get(i).active==1) {
							shouldImove(readFlights.smallFlightsList,i,"small");
							checkLandings(readFlights.smallFlightsList,i,"small");
							if(readFlights.smallFlightsList.get(i).move==1) {
								
								readFlights.smallFlightsList.get(i).move=0;
								move(readFlights.smallFlightsList,i,"small");
								eftasatheshLanding(readFlights.smallFlightsList,i,"small");
							}
						}
					}
				}
				
				atyxhma(readFlights.smallFlightsList,i);
			
		}
		for(i=0; i<readFlights.middleFlightsList.size(); i++) {
			
			checkStartTime(readFlights.middleFlightsList,i,"middle");
				if(readFlights.middleFlightsList.get(i).active==1) {
					calcDistance(readFlights.middleFlightsList,i,"middle");
					checkFuels(readFlights.middleFlightsList,i,"middle");
					if(readFlights.middleFlightsList.get(i).active==1) {
						checkHight(readFlights.middleFlightsList,i,"middle");
						if(readFlights.middleFlightsList.get(i).active==1) {
							shouldImove(readFlights.middleFlightsList,i,"middle");
							if(readFlights.middleFlightsList.get(i).move==1 && readFlights.middleFlightsList.get(i).active==1) {
								
								readFlights.middleFlightsList.get(i).move=0;
								move(readFlights.middleFlightsList,i,"middle");
								eftasatheshLanding(readFlights.middleFlightsList,i,"middle");
							}
						}
					}
			}
			
			atyxhma(readFlights.middleFlightsList,i);
			
		}
		for(i=0; i<readFlights.bigFlightsList.size(); i++) {
			checkStartTime(readFlights.bigFlightsList,i,"big");
				if(readFlights.bigFlightsList.get(i).active==1) {
					calcDistance(readFlights.bigFlightsList,i,"big");
					checkFuels(readFlights.bigFlightsList,i,"big");
					if(readFlights.bigFlightsList.get(i).active==1) {
						checkHight(readFlights.bigFlightsList,i,"big");
						if(readFlights.bigFlightsList.get(i).active==1) {
							shouldImove(readFlights.bigFlightsList,i,"big");
							//checkLandings(readFlights.bigFlightsList,i,"big");
							if(readFlights.bigFlightsList.get(i).move==1) {
								
								readFlights.bigFlightsList.get(i).move=0;
								move(readFlights.bigFlightsList,i,"big");
								eftasatheshLanding(readFlights.bigFlightsList,i,"big");
							}
						}
					}
			}
			
			atyxhma(readFlights.bigFlightsList,i);
		}

	}
	public void shouldImove(List<Flight> List,int i,String type){
		if(List.get(i).koutaki==0 && List.get(i).distance>=10) {
			List.get(i).distance=List.get(i).distance-10;
			List.get(i).move=1;
			if(List.get(i).lastkoutaki==1) {
				List.get(i).move=0;
				String s = new String(List.get(i).name + " is has landed successfully!\n" );
				MyMain.cG.infoList(s);
				MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
				List.get(i).active=2;
				createGraphics.numOfLandings++;
				createGraphics.numOfAircrafts--;
			}
		
		}
		if(List.get(i).koutaki!=0 && List.get(i).distance>=20) {
			List.get(i).distance=List.get(i).distance-20;
			List.get(i).move=1;
		
		}
		
	}
	
	public void checkLandings(List<Flight> List,int i,String type) {
		if(List.get(i).stoxos1==List.get(i).thesh1 && List.get(i).stoxos2==List.get(i).thesh2 && List.get(i).lastkoutaki==1) {
			String s = new String(List.get(i).name + " is has landed successfully!\n" );
			MyMain.cG.infoList(s);
			MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
			List.get(i).active=2;
			createGraphics.numOfLandings++;
			createGraphics.numOfAircrafts--;
		}
	}
	
	public void move(List<Flight> List,int i,String type) {	
		
		if(List.get(i).arxh1==List.get(i).thesh1 && List.get(i).arxh2==List.get(i).thesh2) {
			String s = new String(List.get(i).name + " is taking off!\n" );
			MyMain.cG.infoList(s);
			List.get(i).koutaki=1;
			MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
			switch (readAirportsFile.airportsList.get(List.get(i).airTakeOff-1).orientation){
			//panw
			case 1:	
					List.get(i).thesh1--;
					List.get(i).direction=1;
					MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_n.png");
					break;
				
			//deksia e	
			case 2:	List.get(i).thesh2++;
					List.get(i).direction=2;
					MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_e.png");
					break;
			
			//katw 
			case 3:	List.get(i).thesh1++;
			List.get(i).direction=3;
					MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_s.png");
					break;
			
			//aristera w
			case 4:	List.get(i).thesh2--;
					List.get(i).direction=4;
					MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_w.png");
					break;
			
			}
			
		}
		
		else {
			List.get(i).koutaki=2;
			if(List.get(i).thesh1>List.get(i).theshLanding1) {
				MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
				List.get(i).thesh1--;
				List.get(i).direction=1;
				MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_n.png");
				
			}
			
			if(List.get(i).thesh1<List.get(i).theshLanding1) {
				MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
				List.get(i).thesh1++;
				List.get(i).direction=3;
				MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_s.png");
				
				
			}
			if(List.get(i).thesh2>List.get(i).theshLanding2) {
				MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
				List.get(i).thesh2--;
				List.get(i).direction=4;
				MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_w.png");
				
				
			}
			if(List.get(i).thesh2<List.get(i).theshLanding2) {
				MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
				List.get(i).thesh2++;
				List.get(i).direction=2;
				MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_e.png");
				
			}
			else if(List.get(i).thesh1==List.get(i).theshLanding1 && List.get(i).thesh2==List.get(i).theshLanding2) {
				List.get(i).koutaki=0;
				String s = new String(List.get(i).name + " is about to land!\n" );
				MyMain.cG.infoList(s);
				MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
				List.get(i).lastkoutaki=1;
				
				if(List.get(i).thesh1>List.get(i).stoxos1) {
					MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
					List.get(i).thesh1--;
					List.get(i).direction=1;
					MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_n.png");
					
				}
				
				else if(List.get(i).thesh1<List.get(i).stoxos1) {
					MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
					List.get(i).thesh1++;
					List.get(i).direction=3;
					MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_s.png");
					
					
				}
				else if(List.get(i).thesh2>List.get(i).stoxos2) {
					MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
					List.get(i).thesh2--;
					List.get(i).direction=4;
					MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_w.png");
					
					
				}
				else if(List.get(i).thesh2<List.get(i).stoxos2) {
					MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
					List.get(i).thesh2++;
					List.get(i).direction=2;
					MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,type+"_e.png");
					
				}
			}
		}
		
	}
	
	public void checkStartTime(List<Flight> List, int i, String type) {
		
		if(List.size()!=0)	{
			if (List.get(i).startTime*5 == counter) {
				List.get(i).active=1;
				String s = new String(List.get(i).name + " is ready to start\n");
				MyMain.cG.infoList(s);
				createGraphics.numOfAircrafts++;
				//afairw thn pthsh pou einai etoimh na ksekinhsei apo to lista 
				//kai thn prosthetw sthn lista twn energwn pthsewn

				
				int orient = readAirportsFile.airportsList.get(List.get(i).airTakeOff-1).orientation ;
				String orientS = new String();
				switch(orient) {
				case 1: orientS=type+"_n.png";
						List.get(i).direction=1;
						break;
				case 2: orientS=type+"_e.png";
						List.get(i).direction=2;
						break;
				case 3: orientS=type+"_s.png";
						List.get(i).direction=3;
						break;
				case 4: orientS=type+"_w.png";
						List.get(i).direction=4;
						break;
				}
				
				MyMain.cG.AirplanesMove(List.get(i).thesh1,List.get(i).thesh2,orientS);
				
				
			}
		}
	}
		
	
	
	
	public void checkHight(List<Flight> List, int i,String type) {
		if(List.get(i).koutaki!=3 && List.get(i).koutaki!=4) {
			if(List.get(i).hightcurrent<List.get(i).hight) {
				if(type=="small") {
					List.get(i).hightcurrent=List.get(i).hightcurrent + Small.tempoLand/60;
				}
				else if(type=="middle") {
					List.get(i).hightcurrent=List.get(i).hightcurrent + Middle.tempoLand/60;
				}
				else if(type=="big") {
					List.get(i).hightcurrent=List.get(i).hightcurrent + Big.tempoLand/60;
				}
				if(List.get(i).hightcurrent>=List.get(i).hight) {
					List.get(i).hightcurrent=List.get(i).hight;
				}
			}
		}
		else {
			if(List.get(i).hightcurrent<List.get(i).hight) {
				if(type=="small") {
					List.get(i).hightcurrent=List.get(i).hightcurrent - Small.tempoLand/60;
					
				}
				else if(type=="middle") {
					List.get(i).hightcurrent=List.get(i).hightcurrent - Middle.tempoLand/60;
				}
				else if(type=="big") {
					List.get(i).hightcurrent=List.get(i).hightcurrent - Big.tempoLand/60;
				}
			}
			
		}
		if(List.get(i).hightcurrent<=readMapFile.mapNumbers[List.get(i).thesh1][List.get(i).thesh2]) {
			String s = new String(List.get(i).name + " crashed due to hight!\n" );
			MyMain.cG.infoList(s);
			MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
			List.get(i).active=2;
			createGraphics.numOfCrashes++;
			createGraphics.numOfAircrafts--;
		}
	}
	
	public void checkFuels(List<Flight> List, int i,String type) {
		if(type=="small") {
			List.get(i).fuel=List.get(i).fuel-List.get(i).distcurrent*Small.consumption;
		}
		else if(type=="middle") {
			List.get(i).fuel=List.get(i).fuel-List.get(i).distcurrent*Middle.consumption;
		}
		else if(type=="big") {
			List.get(i).fuel=List.get(i).fuel-List.get(i).distcurrent*Big.consumption;
		}
		
		if(List.get(i).fuel<=0) {
			String s = new String(List.get(i).name + " crashed due to fuels!\n" );
			MyMain.cG.infoList(s);
			MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
			List.get(i).active=2;
			createGraphics.numOfCrashes++;
			createGraphics.numOfAircrafts--;
			
		}
		
	}
	
	public void calcDistance(List<Flight> List, int i,String type) {
		
		if(type=="small") {
			if(List.get(i).koutaki!=2 ) {
				List.get(i).distance=List.get(i).distance + Small.speedLand/3600;
				List.get(i).distcurrent=Small.speedLand/3600;
			}
			else if(List.get(i).koutaki==2) {
				List.get(i).distance=List.get(i).distance + List.get(i).speed/3600;
				List.get(i).distcurrent=List.get(i).speed/3600;
			}
		}
		if(type=="middle") {
			if(List.get(i).koutaki!=2 ) {
				List.get(i).distance=List.get(i).distance + Middle.speedLand/3600;
				List.get(i).distcurrent=Middle.speedLand/3600;
			}
			else if(List.get(i).koutaki==2) {
				List.get(i).distance=List.get(i).distance + List.get(i).speed/3600;	
				List.get(i).distcurrent=List.get(i).speed/3600;
			}
		}
		if(type=="big") {
			if(List.get(i).koutaki!=2 ) {
				List.get(i).distance=List.get(i).distance + Big.speedLand/3600;
				List.get(i).distcurrent=Big.speedLand/3600;
			}
			else if(List.get(i).koutaki==2) {
				List.get(i).distance=List.get(i).distance + List.get(i).speed/3600;	
				List.get(i).distcurrent=List.get(i).speed/3600;
			}
		}
	}
	
	public void checkEnd() {
		int k;
		int end=1;
		if(readFlights.smallFlightsList.size()!=0) {
			for(k=0;k<readFlights.smallFlightsList.size();k++) {
				if(readFlights.smallFlightsList.get(k).active!=2) {
					end=0;
				}
			}
		}
		if(readFlights.middleFlightsList.size()!=0) {
			for(k=0;k<readFlights.middleFlightsList.size();k++) {
				if(readFlights.middleFlightsList.get(k).active!=2) {
					end=0;
				}
			}
		}
		if(readFlights.bigFlightsList.size()!=0) {
			for(k=0;k<readFlights.bigFlightsList.size();k++) {
				if(readFlights.bigFlightsList.get(k).active!=2) {
					end=0;
				}
			}
		}
		if(end==1) {
			String s = new String("No more flights!\nEND OF SIMULATION " );
			MyMain.cG.infoList(s);
			//System.exit(0);
			time.stop();
		}
		
	}
	
	public void eftasatheshLanding(List<Flight> List, int i,String type) {
		if(List.get(i).thesh1!=List.get(i).stoxos1 || List.get(i).thesh2!=List.get(i).stoxos2) {
			if(List.get(i).thesh1==List.get(i).theshLanding1+1) {
				List.get(i).koutaki=1;
			}
			
			if(List.get(i).thesh1==List.get(i).theshLanding1-1) {
				List.get(i).koutaki=1;
			}
			if(List.get(i).thesh2==List.get(i).theshLanding2+1) {
				List.get(i).koutaki=1;
			}
			if(List.get(i).thesh2==List.get(i).theshLanding2-1) {
				List.get(i).koutaki=1;
				
			}
		}
	}
		
		public void atyxhma(List<Flight> List, int i) {
			int k=0;
			List<Flight> check = readFlights.smallFlightsList;
			for(k=0;k<check.size();k++) {
				if(check.get(k).ID!=List.get(i).ID && check.get(k).active==1 && List.get(i).active==1) {
					if(Math.abs(List.get(i).hightcurrent - check.get(k).hightcurrent)<=500) {
						//An eimaste sto idio koutaki
						if(List.get(i).thesh1==check.get(k).thesh1 && List.get(i).thesh2==check.get(k).thesh2) {
							//An exoume idia kateythynsh
							if(List.get(i).direction==check.get(k).direction) {
								if(Math.abs(List.get(i).distcurrent - check.get(i).distcurrent)<2) {
									crashedTwo(List,i,check,k);
								}
							}
							//An exoume antitheth kateythynsh
							else if(Math.abs(List.get(i).direction-check.get(k).direction)==2) {
								if(Math.abs(List.get(i).distcurrent-20+check.get(k).distcurrent)<2) {
									crashedTwo(List,i,check,k);
								}
							}
							else {
								if((Math.pow(List.get(i).distcurrent-10,2) + Math.pow(check.get(k).distcurrent-10,2))<=4){
									crashedTwo(List,i,check,k);
								}
							}
						}
					}
				}
			
			}
			check = readFlights.middleFlightsList;
			for(k=0;k<check.size();k++) {
				if(check.get(k).ID!=List.get(i).ID && check.get(k).active==1 && List.get(i).active==1) {
					if(Math.abs(List.get(i).hightcurrent - check.get(k).hightcurrent)<=500) {
						//An eimaste sto idio koutaki
						if(List.get(i).thesh1==check.get(k).thesh1 && List.get(i).thesh2==check.get(k).thesh2) {
							//An exoume idia kateythynsh
							if(List.get(i).direction==check.get(k).direction) {
								if(Math.abs(List.get(i).distcurrent - check.get(i).distcurrent)<2) {
									crashedTwo(List,i,check,k);
								}
							}
							//An exoume antitheth kateythynsh
							else if(Math.abs(List.get(i).direction-check.get(k).direction)==2) {
								if(Math.abs(List.get(i).distcurrent-20+check.get(k).distcurrent)<2) {
									crashedTwo(List,i,check,k);
								}
							}
							else {
								if((Math.pow(List.get(i).distcurrent-10,2) + Math.pow(check.get(k).distcurrent-10,2))<=4){
									crashedTwo(List,i,check,k);
								}
							}
						}
					}
				}
			}
			check = readFlights.bigFlightsList;
			for(k=0;k<check.size();k++) {
				if(check.get(k).ID!=List.get(i).ID && check.get(k).active==1 && List.get(i).active==1) {
					if(Math.abs(List.get(i).hightcurrent - check.get(k).hightcurrent)<=500) {
						//An eimaste sto idio koutaki
						if(List.get(i).thesh1==check.get(k).thesh1 && List.get(i).thesh2==check.get(k).thesh2) {
							//An exoume idia kateythynsh
							if(List.get(i).direction==check.get(k).direction) {
								if(Math.abs(List.get(i).distcurrent - check.get(i).distcurrent)<2) {
									crashedTwo(List,i,check,k);
								}
							}
							//An exoume antitheth kateythynsh
							else if(Math.abs(List.get(i).direction-check.get(k).direction)==2) {
								if(Math.abs(List.get(i).distcurrent-20+check.get(k).distcurrent)<2) {
									crashedTwo(List,i,check,k);
								}
							}
							else {
								if((Math.pow(List.get(i).distcurrent-10,2) + Math.pow(check.get(k).distcurrent-10,2))<=4){
									crashedTwo(List,i,check,k);
								}
							}
						}
					}
				}
			}
		}
		
		public void crashedTwo(List<Flight> List, int i, List<Flight> check, int k) {

				String s = new String(List.get(i).name + " crashed with airplane" +check.get(k).name+"!\n" );
				MyMain.cG.infoList(s);
				MyMain.cG.returnPrevious(List.get(i).thesh1, List.get(i).thesh2);
				List.get(i).active=2;
				createGraphics.numOfCrashes++;
				createGraphics.numOfAircrafts--;
				MyMain.cG.returnPrevious(check.get(k).thesh1, check.get(k).thesh2);
				check.get(k).active=2;
				createGraphics.numOfCrashes++;
				createGraphics.numOfAircrafts--;
			
		}
	}
