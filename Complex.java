import java.util.Scanner;

public class Complex implements Cloneable
{
	private double a;
	private double b;
	
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
	
	public String toString() 
	{
		if(b == 0)
		{
			return "" + a;
		}
		
		return "(" + a + "+" + b + "i" + ")";
		
	}
	
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
	
	public Complex clone()
	{
		try 
		{
			return (Complex)super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			System.out.print( "Sorry, it does not work like that!!!!");
			throw new RuntimeException();
		}
		
	}
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.println("Enter the number of rows and columns of matrix");
		int i = userInput.nextInt();
		int j = userInput.nextInt();
		int i1 = userInput.nextInt();
		int j2 = userInput.nextInt();
	
		Complex a  = new Complex(i,j);
		Complex b  = new Complex(i1,j2);
		
		System.out.println(a.time(b).toString());
		System.out.println(a.plus(b).toString());
		System.out.println(a.minus(b).toString());
		System.out.println(a.divide(b).toString());
		System.out.println(a.abs());
	}

}
