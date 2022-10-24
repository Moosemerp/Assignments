import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScrollablePanel extends JFrame {
	
	
	ScrollablePanel(String fileInfo)
	{
		JFrame window = new JFrame("File Information");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTextArea textArea = new JTextArea(10,20);		
		JScrollPane scrollpane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textArea.setText(fileInfo);
		textArea.setLineWrap(true);
		textArea.getWrapStyleWord();
		window.add(scrollpane);
		window.setSize(500,500);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
	}

}
