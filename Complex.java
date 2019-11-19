import java.util.Scanner;

public class Complex implements Cloneable
{
	//variables 
	private double a;
	private double b;
	
	//3 constructors for Complex
	public Complex()
	{
		a = 0;
		b = 0;
	}
	
	public Complex( double a)
	{
		this.a = a;
		b = 0;
	}
	
	public Complex(double a, double b) 
	{
		this.a = a;
		this.b = b;
	}
	
	//Getters and Setters for Complex
	public double getImag() 
	{
		return b;
	}
	
	public void setImag(int B) 
	{
		b = B;
	}
	
	public double getReal() 
	{
		return a;
	}
	
	public void setReal(int A) 
	{
		a = A;
	}
	
	//return a string representation of the form, a +bi
	public String toString() 
	{
		if(b == 0)
		{
			return "" + a;
		}
		
		return "(" + a + "+" + b + "i" + ")";
		
	}
	
	//methods for plus, minus, time, divide, & abs for Complex 
	public Complex plus(Complex idk)
	{
		double real = a + idk.a;
		double imag = b + idk.b;
		return new Complex(real, imag);
	}
	
	public Complex minus(Complex idk) 
	{
		double real = a - idk.a ;
		double imag = b - idk.b;
		return new Complex(real, imag);
	}
	
	public Complex time(Complex idk)
	{
		double real = a * idk.a - b * idk.b;
		double imag = a * idk.b + b * idk.a;
		return new Complex(real, imag);
	}
	
	public Complex divide(Complex idk)
	{
		double some = idk.a * idk.a + idk.b * idk.b;
		double real = (a * idk.a + b * idk.b)/ some;
		double imag = (a * idk.b + b * idk.a)/ some;
		return new Complex(real, imag);
	}
	
	public double abs()
	{
		return Math.sqrt(Math.pow(a,2) + Math.pow(b, 2));
	}
	
	// implements the Cloneable interface
	public Complex clone()
	{
		try 
		{
			return (Complex)super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			System.out.print( "Sorry, cannot be copyed.");
			throw new RuntimeException();
		}
		
	}
	
	//main for task 1
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		//asks user for inputs for complex #s (a and b)
		System.out.println("Enter the a(real #) and b(imag #): ");
		int i = userInput.nextInt();
		int j = userInput.nextInt();
		int i1 = userInput.nextInt();
		int j2 = userInput.nextInt();
		
		//complex #s that were enter 
		Complex a  = new Complex(i,j);
		Complex b  = new Complex(i1,j2);
		
		//displays the result of time, plus, minus, divide, and abs 
		System.out.println(a.time(b).toString());
		System.out.println(a.plus(b).toString());
		System.out.println(a.minus(b).toString());
		System.out.println(a.divide(b).toString());
		System.out.println(a.abs());
	}

}
