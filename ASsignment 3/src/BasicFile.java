import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BasicFile {
		
	JFileChooser chooseFile;
	ScrollablePanel panel;
	File file;
	int Selection;
	GetData obtainData;
	
	BasicFile(int Selector) 
	{	

		switch(Selector)
		{
		case 1:
			copyFile();
			break;
		case 2:
			try {
				writeToFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				fileInfo();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			fileViewer();
			break;				
		case 5:
			break;						

		}
	}
	
	public File SelectFile()
	{
		try {
			chooseFile = new JFileChooser(".");
			Selection = chooseFile.showOpenDialog(null);		
			if (Selection != JFileChooser.APPROVE_OPTION) throw new IOException();
			file = chooseFile.getSelectedFile();  
			if (!file.exists()) throw new FileNotFoundException();				
			}
			catch(FileNotFoundException e)
			{
	       		display("File" + file.toString() + " not found", e.toString(), JOptionPane.WARNING_MESSAGE);
	       	}
			catch(IOException e)
	       	{
	    	   display("Approve option was not selected", e.toString(), JOptionPane.ERROR_MESSAGE);
	       	}

			catch (NullPointerException e)
			{
				
			}
		return file;
	}
	
	public void copyFile() 
	{
		File copyFile;
		File file = SelectFile();
		
				String nameSelected = GetData.returnString("Enter the name of the new file being copied: ");
				if(nameSelected != "null" && nameSelected != null && nameSelected != ".txt")
				{
				if(file.getName().endsWith(".txt"))
				copyFile = new File(nameSelected + ".txt");
				else if(file.getName().endsWith(".gif"))
				copyFile = new File(nameSelected + ".gif");
				else 
				copyFile = new File(nameSelected);
				
				try {
					Files.copy(file.toPath(), copyFile.toPath());
				} catch (IOException e) {
					display("Approve option was not selected", e.toString(), JOptionPane.ERROR_MESSAGE);
				}
		display("A copy of " + copyFile.getName() +  " has been saved", "Copying a file", JOptionPane.INFORMATION_MESSAGE);
				}

	}
	
	public void writeToFile() throws IOException
	{
		File file;
		file = SelectFile();
		String[] obtions = {"Append", "Overwrite"};
		String isOverwrite =   (String) JOptionPane.showInputDialog(null,"Select one of the options","Would you like to overwrite the file", JOptionPane.QUESTION_MESSAGE, null ,obtions, obtions[1]);
		switch (isOverwrite)
		{
		case "Overwrite":
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String text = GetData.returnString("Enter what you would like to write to the file.");
			writer.write(text);
			writer.close();
			display(file.getName() + " has been successfully written.","Write to File", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "Append":
			try {
				text = GetData.returnString("Enter what you would like to write to the file.");
			    Files.write(Paths.get(file.getName()), text.getBytes(), StandardOpenOption.APPEND);
			    display(file.getName() + " the text has been successfully appended.","Write to File", JOptionPane.INFORMATION_MESSAGE);
			}catch (IOException e) {
				display("Approve option was not selected", e.toString(), JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		
		
	}
	
	public void fileInfo() throws IOException
	{
		long lines = 0;
		File file = SelectFile();
			BufferedReader reader
			= new BufferedReader(new FileReader(file));
				while((reader.readLine()) != null)
					{lines++;}
		String fileInformation = "Absolute path: " + file.getAbsolutePath() + "\nPath of the file: " + file.getPath() + "\nFile size: " + ((double)(file.length())/1000) + " kilobytes" + "\n" + "Is file a text file? " +  file.getName().endsWith(".txt") + "\nNumber of lines: " + lines ;
		displayFile(fileInformation);
		
	}
	
	public void fileViewer()
	{
		String fileLines;
		File file = SelectFile();
        try {
			BufferedReader reader
			= new BufferedReader(new FileReader(file));
			while((fileLines = reader.readLine()) != null)
				displayFile(fileLines);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        catch (IOException e)
        {
        	e.printStackTrace();
        }
	}
	
	public void displayFile(String displayInfo)
	{
		panel = new ScrollablePanel(displayInfo);
	}
	
	
	 void display(String msg, String s, int t)
	 {
		JOptionPane.showMessageDialog(null, msg, s, t);
	 }
	
	


	
	
	
	
}
