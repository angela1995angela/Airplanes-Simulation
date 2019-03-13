package Airplanes;

public class Flight {
	
	public int ID;
	public int startTime;
	public int airTakeOff;
	public int airLand;
	public String name;
	public int category;
	public double speed;
	public double hight;
	public double fuel;
	
	public int arxh1;
	public int arxh2;  		//h thesh toy aerodromiou apo opou ksekinaei
	
	public int thesh1;		//pou vrisketai to aeroplano kathe stigmh
	public int thesh2;
	
	public int theshLanding1;	//to koutaki pou prepei na paei gia na prosgeiwthei 
	public int theshLanding2;	//me thn katallhlh fora sto aerodromio
	
	public int flagLanding; //0->den exei ftasei sto koutaki prin to aerodromio prosgeiwshs
							//1->einai sto koutaki prin prosgeiwthei
	
	public int stoxos1;
	public int stoxos2;		//h thesh tou aerodromiou pou tha paei
	
	public int move;		//0->den prepei na allaksei koutaki
							//1->prepei na allaksei koutaki
	public int lastkoutaki;//eimai sto koutaki tou aerodromiou prosgeiwshs
	
	public int airport;	//0->oxi , 1-> einai h prohgoumenh to amaksi
	public int color; //to background ths theshs pou vrisketai
	
	public int active; //0-> den exei ksekinhsei
					   //1->exei ksekinhsei
						//2->exei teleiwsei
	public double distance; //posh apostash exei dianysei synolika
	public double distcurrent; //posh apostash exei dianysei se ena sec
	public double hightcurrent;//se poso ypsos exei ftasei
	
	public int koutaki;// 0->prwto/teleutaio koutaki ara 10nm me mikrh taxythta
						//1->deutero/proteleutaio koutaki ara 20 nm me mikrh taxythta
						//2->endiamesa koutaki ara 20nm me megalh taxythta
	
	public int direction;//deixnei pros poia kateythynsh paei to aeroplano
	
						
}
