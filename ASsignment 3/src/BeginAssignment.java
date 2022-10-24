import java.io.IOException;

import javax.swing.JOptionPane;

public class BeginAssignment extends GetData {
	
	private String Menu = "Welcome\nPlease select from one of the options:\n1.Copy a file\n2.Write to a file\n3.Display the file attributes\n4.Display the contents of a file\n5.Search the file for expecific words\n6.Close\n";

	

	BeginAssignment()
	{
			try
			{	
				String select = JOptionPane.showInputDialog(Menu);
				int menuChoice  = StringToInteger(select);
				if(menuChoice > 6) throw new ArrayIndexOutOfBoundsException(); 
				BasicFile myFile = new BasicFile(menuChoice);				
			}		
		
	    	catch(ArrayIndexOutOfBoundsException e)
	    	{
	    	GetData.display( "Enter the correct number within the menu.", "Incorrect Choice", 0);
	    	}

			catch (NumberFormatException e)
		{
			
		}
	}
}
