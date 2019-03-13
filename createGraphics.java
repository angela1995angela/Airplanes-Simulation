package Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.MenuListener;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Thread;
import java.lang.Runnable;
import javax.swing.Timer; //auto gia import

public class createGraphics extends JFrame{
	
	public static Timer time;
	static int counter=0;
	
	//Organization - Design
	//JPanel p contains everything. We will add to this a new JPanel pMap that 
	//will contain a GrLayout which will show the map!
	JPanel p = new JPanel();
	
	JPanel pMap = new JPanel(new GridLayout(30,60));
	int[][] colors = new int[30][60];
	
	
	//North
	JPanel north = new JPanel();
	public static JLabel simulatedTimeLabel= new JLabel();
	public static JLabel aircraftsLabel = new JLabel();
	public static int numOfAircrafts=0;
	public static JLabel crashesLabel= new JLabel();
	public static int numOfCrashes=0;
	public static JLabel landingsLabel= new JLabel();
	public static int numOfLandings=0;

	
	//East
	public static JTextArea infoList = new JTextArea(30,20);
	JScrollPane infoScroll = new JScrollPane(
		infoList,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);

	
	//MAP
	
	readMapFile m = new readMapFile();
	JPanel[][] map= new JPanel[30][60];
	
	//AIRPORTS
	readAirportsFile a = new readAirportsFile();
	
	
	//-----------createGraphics()--------------------------------
	
	public createGraphics(){
		super("MediaLab Flight Simulation");
		
	}
	//************North****************
	public void MakeNorth() {
		north.add(simulatedTimeLabel);
		north.add(aircraftsLabel);
		north.add(crashesLabel);
		north.add(landingsLabel);
		p.add(north, BorderLayout.NORTH);
		add(p);
		setVisible(true);
	}
	//************MenuBar****************
	public void MakeMenubar() {
		menubar menu = new menubar();
		setJMenuBar(menu.menubar);
		
	}
	//************JPanel****************
	public void MakeJpanel() {
		
		setSize(1500,900);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.setLayout(new BorderLayout());
		
	}
	//************EAST****************
	public void infoList(String INFO) {
		
		infoList.setEditable(false);
		infoList.setLineWrap(true);
		infoList.setWrapStyleWord(true);
		infoList.setVisible(true);
		infoList.append(INFO);
		infoList.append("\n");
		p.add(infoScroll, BorderLayout.EAST);
		p.add(pMap);
		add(p);
		setVisible(true);
	}
	
	//************Map****************
	public void MakeMap() {
		p.removeAll();
		try {
			a.readAirFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			m.readFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		int j=0;
		
		for(i=0;i<30;i++) {
			for(j=0;j<60;j++) {
			
				if (m.mapNumbers[i][j]==0) {
					colors[i][j]=0;
					map[i][j]=new JPanel();
					map[i][j].setBackground(new Color(0,0,255));
					map[i][j].setVisible(true);
					pMap.add(map[i][j]);
				}
				else if (m.mapNumbers[i][j]<=200) {
					colors[i][j]=200;
					map[i][j]=new JPanel();
					map[i][j].setBackground(new Color(60,179,113));
					map[i][j].setVisible(true);
					pMap.add(map[i][j]);
				}
				else if (m.mapNumbers[i][j]<=400) {
					colors[i][j]=400;
					map[i][j]=new JPanel();
					map[i][j].setBackground(new Color(46,139,87));
					map[i][j].setVisible(true);
					pMap.add(map[i][j]);
				}
				else if (m.mapNumbers[i][j]<=700) {
					colors[i][j]=700;
					map[i][j]=new JPanel();
					map[i][j].setBackground(new Color(34,139,34));
					map[i][j].setVisible(true);
					pMap.add(map[i][j]);
				}
				else if (m.mapNumbers[i][j]<=1500) {
					colors[i][j]=1500;
					map[i][j]=new JPanel();
					map[i][j].setBackground(new Color(222,184,135));
					map[i][j].setVisible(true);
					pMap.add(map[i][j]);
				}
				else if (m.mapNumbers[i][j]<=3500) {
					colors[i][j]=3500;
					map[i][j]=new JPanel();
					map[i][j].setBackground(new Color(205,133,63));
					map[i][j].setVisible(true);
					pMap.add(map[i][j]);
				}
				else {
					colors[i][j]=4000;
					map[i][j]=new JPanel();
					map[i][j].setBackground(new Color(145,80,20));
					map[i][j].setVisible(true);
					pMap.add(map[i][j]);
				}
				
				if(a.airportsToFind[i][j]==1 ) {
					ImageIcon icon = new ImageIcon("src/airport.png"); 
					JLabel airLabel = new JLabel(); 
					airLabel.setIcon(icon); 
					airLabel.setVisible(true);
					map[i][j].add(airLabel);
					pMap.add(map[i][j]);
					
				}
			else {
				continue;
			}
			
			pMap.setVisible(true);
			p.add(pMap);
			
			add(p);
			setLocationRelativeTo(null);
			
			
			}
		}
		
	}
	
	//************AirplanesMove****************
	public void AirplanesMove(int i, int j, String orient) {//ananewnei thn trexousa thesh tou aeroplanou
		 
		ImageIcon icon = new ImageIcon("src/"+orient); 
		JLabel airLabel = new JLabel(); 
		airLabel.setIcon(icon); 
		airLabel.setVisible(true);
		map[i][j].removeAll();
		map[i][j].add(airLabel);
		map[i][j].repaint();
		
	}
	
	
	//************returnPrevious****************
	public void returnPrevious(int i, int j) {//ananewnei thn prohgoumenh thesh tou aeroplanou
		
		map[i][j].removeAll();
		
		if(colors[i][j]==0) {
			map[i][j].setBackground(new Color(0,0,255));
		}
		else if(colors[i][j]==200) {
			map[i][j].setBackground(new Color(60,179,113));
		}
		else if(colors[i][j]==400) {
			map[i][j].setBackground(new Color(46,139,87));
		}
		else if(colors[i][j]==700) {
			map[i][j].setBackground(new Color(34,139,34));
		}
		else if(colors[i][j]==1500) {
			map[i][j].setBackground(new Color(222,184,135));
		}
		else if(colors[i][j]==3500) {
			map[i][j].setBackground(new Color(205,133,63));
		}
		else if(colors[i][j]==4000) {
			map[i][j].setBackground(new Color(145,80,20));
		}
	
		if(readAirportsFile.airportsToFind[i][j]==1) {
			ImageIcon icon = new ImageIcon("src/airport.png"); 
			JLabel airLabel = new JLabel(); 
			airLabel.setIcon(icon); 
			airLabel.setVisible(true);
			map[i][j].add(airLabel);
			
		}
		map[i][j].repaint();
		
	}
}