import java.util.Scanner;

public abstract class SpaceShip implements CanMove 
{
	private String name;
	private int year;
	private int numRows;
	private int numCols;
	private int x;
	private int y;
	public String[][] grid = new String[numRows][numCols];
	private String type;

	
	public SpaceShip(String Name, int Year, String type) //,int x, int y)
	{
		name = Name;
		year = Year;
		numRows = (int)(Math.random() * 10) + 1;
		numCols = (int)(Math.random() * 10) + 1;
		this.type = type;
		//this.x = x;
		//this.y = y;
	}
	
	public void setName (String Name)
	{
		name = Name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setYear(int Year)
	{
		year = Year;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getX() 
	{
		return numCols;
	}
	
	public int getY() 
	{
		return numRows;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public String toString()
	{
		String s = "SPACESHIP ERROR";
		
		s = "\t\tName:\t\t" + name + "\n"; 

		s += "\t\tYear:\t\t" + year + "\n";
		
		s += "\n";
		
		return s;
	}
	
	public void moveShip()
	{
		Scanner input = new Scanner(System.in);
//		do 
//		{
//		//Ask the user for x and y coordinate
//		System.out.print("Enter X coordinate: ");
//		x = input.nextInt();
//		input.nextLine();
//		System.out.append("Enter Y Coordinate for ship: ");
//		y = input.nextInt();
//		input.nextLine();
//		
//		//Check the coordinate
//		 if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
//         {
//             grid[x][y] =   type;
//         }
//         else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == type)
//             System.out.println("You can't place two or more ships on the same location");
//         else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
//             System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
//		 }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols)); //Asks until valid coordinates is inputted
		 
	}
		

}

