package Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class popWindowAircrafts extends JFrame {
	
	public static String name;
	
	public popWindowAircrafts() {
		
		readFlights.printAircrafts();
		JOptionPane.showMessageDialog(null,readFlights.aircraftsPrint[1],name,JOptionPane.INFORMATION_MESSAGE);

	}
}
