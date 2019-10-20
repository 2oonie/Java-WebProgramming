package com.example.helloworld;

public class PirateShip extends SpaceShip
{
	private String name;
	private int booty;
	private int x, y;

	public PirateShip(String Name, int Year)
	{
		super(Name, Year, "P");
		booty = (int)(Math.random()*50) + 1;
	}

	public int getBooty() 
	{
		return booty;
	}

	public void setBooty(int Booty)
	{
		booty = Booty;
	}
	
	public String toString()
	{
		String s = "PIRATESHIP ERROR"; 
		
		s = "\nName: " + getName() + "\n";


		s += "Location: " + " ( "+ getX() + "," + getY() +" ) " + "\n" +
				"Booty: " + getBooty() + "\n";
		
		s += "\n";
		
		return s;
	}

}
