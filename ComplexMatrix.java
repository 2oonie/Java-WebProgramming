import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ComplexMatrix extends GenericMatrix<Complex> implements Comparable<ComplexMatrix> 
{
	//variables 
	private double a;
	private double b;
	private Complex current [][];
	private int rows;
	private int columns;
	
	//3 constructors for ComplexMatrix
	public  ComplexMatrix ()
	{
		a = 0;
		b = 0;
	}
	
	public  ComplexMatrix ( Complex[][] a)
	{
		this.current = a;
		this.rows = a.length;
		this.columns = a[0].length;
	
	}
	
	public  ComplexMatrix (int a, int b) 
	{
		this.rows = a;
		this.columns = b;
	}
	
	//generator to create random number for the matrix
	public void GeneRandomNumber(int gene)
	{
		this.current = new Complex[rows][columns];
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				this.current[i][j] = new Complex(i + gene,j + gene); 
			}
		}
		
	}
	
	//Getters and Setters
	public double getImag() 
	{
		return b;
	}
	
	public void setImag(int B) 
	{
		this.b = B;
	}
	
	public double getReal() 
	{
		return a;
	}
	
	public void setReal(int A) 
	{
		this.a = A;
	}
	
	public Complex[][] getCurrent() 
	{
		return current;
	}
	
	public void setCurrent(Complex[][] Current) 
	{
		this.current = Current;
	}
	
	public double getRows() 
	{
		return rows;
	}
	
	public void setRows(int Rows) 
	{
		rows = Rows;
	}
	
	public double getColumns() 
	{
		return columns;
	}
	
	public void setColumns(int Columns) 
	{
		columns = Columns;
	}
	
	//return a string representation of matrix
	public String toString() 
	{
		String matrix = " ";
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				matrix += " " + current[i][j];				
			}
			
			matrix += "\n";
		}
		return matrix;
		
	}
	
	//methods for plus, time, & zero for ComplexMatrix 
	public Complex plus( Complex idk, Complex idk1)
	{
		return idk.plus(idk1);

	}
	
	public Complex time( Complex  idk, Complex idk1)
	{
		return idk.time(idk1);
	}
	
	public Complex zero()
	{
		return new Complex();
	}
	
	//implements the Cloneable interface
	public  ComplexMatrix  clone()
	{
		try 
		{
			return ( ComplexMatrix )super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			System.out.print( "Sorry, cannot be copyed.");
			throw new RuntimeException();
		}
		
	}
	
	//using ArrayList to compare two objects 
	public int compareTo(ComplexMatrix c)
	{
	 
		return this.rows - c.rows;
		
	}
	
	//main for task 2 and 3
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		//asks user for input of rows and columns
		System.out.println("Enter the number of rows and columns of matrix");
		int i = userInput.nextInt();
		int j = userInput.nextInt();
	
		
		ComplexMatrix a  = new ComplexMatrix(i,j);
		ComplexMatrix b  = new ComplexMatrix(i,j);
		
		//generating random number for a and b
		a.GeneRandomNumber(10);
		b.GeneRandomNumber(5);
		
		//displays the result for matrix being plus and time
		GenericMatrix.printResult(a.getCurrent(),b.getCurrent(), a.timeMatrix(a.getCurrent(),b.getCurrent()), '*');
		GenericMatrix.printResult(a.getCurrent(),b.getCurrent(), a.plusMatrix(a.getCurrent(),b.getCurrent()), '+'); 
		
		
		System.out.println("Enter the number of matrices: ");
		int numOfMatrices = userInput.nextInt();
		ArrayList<ComplexMatrix> complex = new ArrayList<ComplexMatrix>();
		for(int t = 0; t < numOfMatrices; t++)
		{
			ComplexMatrix o  = new ComplexMatrix(i,j);
			o.GeneRandomNumber(i);
			complex.add(o);
			
			System.out.println(o.toString());
			
		}
		
		for(int q = 0; q < numOfMatrices; q++)
		{
			for(int z = 0; z < q -1; z++)
			{
				complex.get(q).compareTo(complex.get(z));
			}
			
			Collections.sort(complex);
			System.out.println("Sorted with compareTo: " + complex);
		}
		
//		Collections.sort(complex);
		
	}

}


