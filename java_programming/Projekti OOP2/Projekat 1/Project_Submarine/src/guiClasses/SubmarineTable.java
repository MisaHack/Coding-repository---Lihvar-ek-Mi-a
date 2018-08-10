package guiClasses;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;


/**
 * Glavna klasa(gui) aplikacije.
 * 
 * @author <a href="mailto:barugdzicnenad@gmail.com"> Barugdžić Nenad </a>
 *
 */

public class SubmarineTable extends JFrame {
	private JTextField tf;
	private JPanel userPanel;
	private JPanel opponentPanel;
	
	public SubmarineTable(){
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setContinuousLayout(true);
		add(splitPane);
		
		
		
		
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
		}
		JFrame frame = new SubmarineTable();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 600);
		frame.setTitle("Submarine");
		frame.setVisible(true);
	}
}
