import javax.swing.JOptionPane;

public class GetData {
	
	public static double StringToDouble(String s)
	{
		return Double.parseDouble(s);
	}
	
	public static Integer StringToInteger(String s)
	{
		return Integer.parseInt(s);
	}
	
	public static String returnString(String s)
	{
		return JOptionPane.showInputDialog(s);
	}
	
	public static void display(String msg, String s, int t)
	 {
		JOptionPane.showMessageDialog(null, msg, s, t);
	 }
}
