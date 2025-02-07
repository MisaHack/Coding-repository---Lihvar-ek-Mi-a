package guiPackage;

/**
 * User-friendly graficko okruzenje igre.
 * 
 * <a href="mailto:lihvarcekmisa@yahoo.com"> Lihvarcek Misa </a>
 */

import abstractFigures.Player1_Board;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Dimension;

import javax.swing.JSplitPane;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class Battlefield extends JFrame {

	private JPanel contentPane;

	private List<List<JLabel>> fieldsPlayer;
	private List<List<JLabel>> fieldsOponent;
	
	private JPanel leftPanel;
	private JPanel rightPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Battlefield frame = new Battlefield();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Battlefield() {
		//polja table na koja stavljamo podmornice
		fieldsPlayer = new ArrayList<>();
		
		//polja pomocne table,koja simulira protivnicku tablu
		fieldsOponent = new ArrayList<>();		
		
		//napravimo novu tablu
		Player1_Board p = new Player1_Board();
		
		
		for(int row=0; row < p.getRowCount(); row++){
		   fieldsPlayer.add(new ArrayList<JLabel>());	
		}
		
		for(int row=0; row < p.getRowCount(); row++){
		   fieldsOponent.add(new ArrayList<JLabel>());	
		}
		
		
		
		try{
		   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	
		}
		catch(Exception e){
		}
		
		
		setPreferredSize(new Dimension(1000, 600));
		setMaximumSize(new Dimension(1000, 600));
		setMinimumSize(new Dimension(1000, 600));
		setTitle("Submarine Battle");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Battlefield.class.getResource("/guiPackage/icons/submarine.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 0));
		setContentPane(contentPane);
		
		JPanel osnovniPanel = new JPanel();
		contentPane.add(osnovniPanel, BorderLayout.CENTER);
		osnovniPanel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitMainPanel = new JSplitPane();
		splitMainPanel.setEnabled(false);
		splitMainPanel.setResizeWeight(0.5);
		osnovniPanel.add(splitMainPanel);
		
		leftPanel = new JPanel();
		leftPanel.setMinimumSize(new Dimension(300, 300));
		leftPanel.setMaximumSize(new Dimension(300, 300));
		splitMainPanel.setLeftComponent(leftPanel);
		leftPanel.setLayout(new GridLayout(10, 10, 1, 1));
		
		
		Dimension dimension = new Dimension(30,30);	
		
		initFields(fieldsPlayer, leftPanel, p, dimension);

		
		rightPanel = new JPanel();
		splitMainPanel.setRightComponent(rightPanel);
		rightPanel.setLayout(new GridLayout(10, 10, 1, 1));
		
		initFields(fieldsOponent, rightPanel, p, dimension);
		
		JPanel downPanel = new JPanel();
		downPanel.setPreferredSize(new Dimension(10, 100));
		downPanel.setMinimumSize(new Dimension(10, 100));
		downPanel.setMaximumSize(new Dimension(32767, 100));
		contentPane.add(downPanel, BorderLayout.SOUTH);
		downPanel.setLayout(new BoxLayout(downPanel, BoxLayout.X_AXIS));
		
		JPanel leftScorePanel = new JPanel();
		leftScorePanel.setPreferredSize(new Dimension(100, 10));
		leftScorePanel.setMinimumSize(new Dimension(200, 10));
		leftScorePanel.setMaximumSize(new Dimension(200, 32767));
		contentPane.add(leftScorePanel, BorderLayout.WEST);
		leftScorePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setIcon(new ImageIcon(Battlefield.class.getResource("/guiPackage/icons/NoShot4.png")));
		label.setPreferredSize(new Dimension(100, 30));
		label.setMinimumSize(new Dimension(100, 30));
		label.setMaximumSize(new Dimension(100, 30));
		leftScorePanel.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Battlefield.class.getResource("/guiPackage/icons/NoShot3.png")));
		leftScorePanel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Battlefield.class.getResource("/guiPackage/icons/NoShot3.png")));
		leftScorePanel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Battlefield.class.getResource("/guiPackage/icons/NoShot2.png")));
		leftScorePanel.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Battlefield.class.getResource("/guiPackage/icons/NoShot2.png")));
		leftScorePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Battlefield.class.getResource("/guiPackage/icons/NoShot2.png")));
		leftScorePanel.add(lblNewLabel_2);
		

		
		JPanel rightScorePanel = new JPanel();
		rightScorePanel.setMinimumSize(new Dimension(100, 10));
		rightScorePanel.setMaximumSize(new Dimension(100, 32767));
		rightScorePanel.setPreferredSize(new Dimension(100, 10));
		contentPane.add(rightScorePanel, BorderLayout.EAST);
		rightScorePanel.setLayout(new GridLayout(6, 1, 0, 0));
	}
	
	private void initFields(List<List<JLabel>> fieldList,JPanel panel,Player1_Board p,Dimension dimension){
		for(int row=0; row < p.getRowCount(); row++){
		   for(int column=0; column < p.getColumnCount(); column++){
		  	  JLabel label = new JLabel("");
		  	  label.setHorizontalTextPosition(SwingConstants.CENTER);
		  	  label.setVerticalTextPosition(SwingConstants.CENTER);
			  label.setMaximumSize(dimension);
			  label.setMinimumSize(dimension);
			  label.setPreferredSize(dimension);
		      label.setOpaque(true);
			  label.setBackground(Color.CYAN);				   
				   
				   
			  panel.add(label);
			  fieldList.get(row).add(label); 
		   }  	
		}		
	}

}
