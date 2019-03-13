package Graphics;

import MyMain.*;
import java.io.*;
import java.util.*;


public class readMapFile {
	
	public static int[][] mapNumbers;
	
	public void readFile() throws Exception{
		
		
		String s = new String("Loading Map....");
		MyMain.cG.infoList(s);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/world_"+MyMain.whichFile+".txt"));
			String line = null;
			mapNumbers= new int[30][60];
			int i=-1;
			while ((line=br.readLine()) != null) {
				i++;
				String[] values = line.split(",");
				int[] intValues = new int[values.length];
				
				for (int j=0; j<values.length;j++) {
					try {
						intValues[j]=Integer.parseInt(values[j]);
						mapNumbers[i][j]=intValues[j];
						
					}
					catch(NumberFormatException nfe) {
						continue;
					}
					
				}
				
				
			}
			br.close();
		}
		catch(FileNotFoundException ex){
			controlClass.time.stop();
			String a = new String("world_"+MyMain.whichFile+".txt Not Found");
			MyMain.cG.infoList(a);
		}
		
		
		
	}
	
	
}
