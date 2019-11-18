import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class ComplexMatrix extends GenericMatrix<Complex> implements Comparable<ComplexMatrix[][]>
{
	private double a;
	private double b;
	private Complex current [][];
	private int rows;
	private int columns;
	
	
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
	
	public String toString() 
	{
		String matrice = " ";
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				matrice += " " + current[i][j];				
			}
			
			matrice += "\n";
		}
		return matrice;
		
	}
	
	public Complex  plus( Complex idk, Complex idk1)
	{
		return idk.plus(idk1);

	}
	
	
	public  Complex  time( Complex  idk, Complex idk1)
	{
		return idk.time(idk1);
	}
	
	
	public  Complex  zero()
	{
		return new Complex();
	}
	
	
	public  ComplexMatrix  clone()
	{
		try 
		{
			return ( ComplexMatrix )super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			System.out.print( "Sorry, it does not work like that!!!!");
			throw new RuntimeException();
		}
		
	}
	
	public Complex compareTo(ComplexMatrix c)
	{
	 
		//c.getCurrent() < getCurrent();
		ComplexMatrix.sort(getCurrent(), ComplexMatrix.)
		
	}
	
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.println("Enter the number of rows and columns of matrix");
		int i = userInput.nextInt();
		int j = userInput.nextInt();
	
		ComplexMatrix a  = new ComplexMatrix(i,j);
		ComplexMatrix b  = new ComplexMatrix(i,j);
		a.GeneRandomNumber(10);
		b.GeneRandomNumber(5);
		
		GenericMatrix.printResult(a.getCurrent(),b.getCurrent(), a.multiplyMatrix(a.getCurrent(),b.getCurrent()), '*');
		GenericMatrix.printResult(a.getCurrent(),b.getCurrent(), a.addMatrix(a.getCurrent(),b.getCurrent()), '+'); 
		
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
		}
		
		
	}

}


