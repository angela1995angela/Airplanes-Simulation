package Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class popWindowFlights extends JFrame {
	
	public static String name;
	
	public popWindowFlights() {
		
		readFlights.printFlights();
		JOptionPane.showMessageDialog(null,readFlights.flightsPrint[1],name,JOptionPane.INFORMATION_MESSAGE);
	}
}