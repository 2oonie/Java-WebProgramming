import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

//This program asks the user to input a byte value and a name of a file which encoded the information of a file to byte. 
public class Encode 
{
	public static void main(String args[])
	{
		System.out.print("Encrypting File");
		
		byte key;
		
		//asks user for a byte value
		System.out.print("\nEnter a byte key (-128 to 127):");
		Scanner userInput = new Scanner(System.in);
		key = userInput.nextByte();
		userInput.nextLine();
		
		String file;
		
		//asks user for a name of a file
		System.out.print("Next, enter the name of file:");
		file = userInput.next();
		userInput.nextLine();
		
		File InputFile = new File(file);
		//checks the file
		FileInputStream FileIn = null;
		FileOutputStream FileOut = null;
		
		//close the scanner
		userInput.close();
		
		//processing the file 
		try
		{
			FileIn = new FileInputStream(InputFile);
			byte FileContent[] = new byte[(int)InputFile.length()];
			FileIn.read(FileContent);
			
			for (int i = 0; i < FileContent.length; i++)
			{
				FileContent[i] = (byte)(FileContent[i] + key);
			}
			
			FileOut = new FileOutputStream(InputFile + ".encoded");
			
			FileOut.write(FileContent);
		}
		
		catch(FileNotFoundException e)
		{
			System.out.print("\nThe file that you have entered was not found: " + e);
		}
	
		catch(IOException ex)
		{
			System.out.print("\nThere's a issue when reading the file " + ex);
		}
		
		finally
		{
			try
			{
				if(FileIn!=null)
					FileIn.close();
				if(FileOut!=null)
					FileOut.close();
			}
			catch (IOException e)
			{
				System.out.print("\nError when closing " + e);
			}
		}
	}
}
