
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
		
		s = "\nName: " + name + "\n"; 


		s += "Location: " + " ("+ x + "," + y +") " + "\n" +
				"Cargo: " + cargo + "\n";
		
		s += "\n";
		
		return s;
	}
}
