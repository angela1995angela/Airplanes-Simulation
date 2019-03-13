package Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class popWindowAirports extends JFrame {
	
	public static String name;
	
	public popWindowAirports() {
		
		readAirportsFile.printAirports();
		JOptionPane.showMessageDialog(null,readAirportsFile.airportsPrint[1],name,JOptionPane.INFORMATION_MESSAGE);
	
	}

}
