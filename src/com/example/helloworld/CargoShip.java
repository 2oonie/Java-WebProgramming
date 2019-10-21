package com.example.helloworld;

public class CargoShip extends SpaceShip
{
	private String name;
	private int x, y;
	private int cargo;
	
	public CargoShip(String Name, int Year) 
	{
		super(Name, Year, "C");
		cargo = (int)(Math.random()*50) + 2;
	}

	public int getCargo() 
	{
		return cargo;
	}

	public void setCargo(int Cargo) 
	{
		cargo = Cargo;
	}
	
	public String toString()
	{
		String s = "CARGOSHIP ERROR"; 
		
		s = "\nName: " + this.getName() + "\n";


		s += "Location: " + " ("+ this.getX() + "," + this.getY() +") " + "\n" +
				"Cargo: " + this.getCargo() + "\n";
		
		s += "\n";
		
		return s;
	}
}
