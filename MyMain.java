package MyMain;

import Graphics.*;


public class MyMain {
	
	public static String whichFile = "default";
	public static createGraphics cG = new createGraphics();
	public static int startFlag=0;
	
	
	public static void main(String[] arguments) {
		
		cG.MakeJpanel();
		cG.MakeMenubar();
		cG.infoList("Hello");
		cG.MakeMap();
		cG.MakeNorth();
		
		new controlClass();
		
		
		
	}
	
	
}
