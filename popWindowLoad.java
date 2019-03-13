package Graphics;

import javax.swing.JOptionPane;
import MyMain.*;

public class popWindowLoad {
	
	public static String name;
	
	public popWindowLoad(){
		
		MyMain.whichFile=JOptionPane.showInputDialog(null,"Write the file you want",name,JOptionPane.INFORMATION_MESSAGE);
		
	}

}
