package fretPkg;

import java.io.IOException;
import javax.swing.*;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;


public class Board {
	
	public static void launchMainWindow() throws IOException {
		//initialize panel and frame settings, button grid, etc... ********************************************
		int strings = 6;
		int frets = 24;
		Fretboard usrFret = new Fretboard();
		Chord usrCho = new Chord();
		usrFret.initFrets();
		JFrame frame = new JFrame();
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JSplitPane topSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel topLPan = new JPanel();
		JPanel topRPan = new JPanel();	
		JPanel botPan = new JPanel();
		final int FRAME_WIDTH = 1700;
		final int FRAME_HEIGHT = 500;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("FretMap");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		String s1[] = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
		botPan.setLayout(new GridLayout(strings, frets));
		JButton[][] grid = new JButton[strings][frets];
		for(int i = 5; i >= 0; i--) {
			for(int j = 0; j < 24; j++) {
				grid[i][j] = new JButton("("+i+", "+j+")");
				grid[i][j].setBackground(Color.GRAY);;
				botPan.add(grid[i][j]);
			}
		}
			
		//Dropboxes for tuning selection *******************************************************************		
		JComboBox drop1 = new JComboBox(s1);
		drop1.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e1)
			{		
				usrFret.setString(0, drop1.getSelectedIndex());
				//usrFret.consoleOut();
				for(int j = 0; j < 24; j++) {
					int n = usrFret.getFretNote(0, j);
					String s = usrFret.getNoteName(n-1);
					grid[0][j].setText(s);
				}
				
			}
		});
		
		JComboBox drop2 = new JComboBox(s1);
		drop2.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e1)
			{
				usrFret.setString(1, drop2.getSelectedIndex());
				//usrFret.consoleOut();
				for(int j = 0; j < 24; j++) {
					int n = usrFret.getFretNote(1, j);
					String s = usrFret.getNoteName(n-1);
					grid[1][j].setText(s);
				}
				
			}
		});
		
		JComboBox drop3 = new JComboBox(s1);
		drop3.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e1)
			{
				//usrFret.consoleOut();
				usrFret.setString(2, drop3.getSelectedIndex());
				for(int j = 0; j < 24; j++) {
					int n = usrFret.getFretNote(2, j);
					String s = usrFret.getNoteName(n-1);
					grid[2][j].setText(s);
				}
				
			}
		});
		
		JComboBox drop4 = new JComboBox(s1);
		drop4.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e1)
			{
				usrFret.setString(3, drop4.getSelectedIndex());
				for(int j = 0; j < 24; j++) {
					int n = usrFret.getFretNote(3, j);
					String s = usrFret.getNoteName(n-1);
					grid[3][j].setText(s);
				}
			}
		});
		
		JComboBox drop5 = new JComboBox(s1);
		drop5.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e1)
			{
				usrFret.setString(4, drop5.getSelectedIndex());
				for(int j = 0; j < 24; j++) {
					int n = usrFret.getFretNote(4, j);
					String s = usrFret.getNoteName(n-1);
					grid[4][j].setText(s);
				}
			}
		});
		
		JComboBox drop6 = new JComboBox(s1);
		drop6.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e1)
			{
				usrFret.setString(5, drop6.getSelectedIndex());
				for(int j = 0; j < 24; j++) {
					int n = usrFret.getFretNote(5, j);
					String s = usrFret.getNoteName(n-1);
					grid[5][j].setText(s);
				}
			}
		});
		
		//Dropboxes/Radio Buttons for Chord Selection *********************************************************
		JComboBox choPick = new JComboBox(s1);
		choPick.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e1)
			{	
				usrCho.setRoot(choPick.getSelectedIndex());
				//System.out.println(usrCho.getRoot());		
			}
		});
		

		JRadioButton majCho = new JRadioButton("Major");
		majCho.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e1)
				{
					usrCho.majCho();
					int[] cho = usrCho.getCho();
					usrCho.printChord();
					for(int i = 0; i < 6; i++){
						for(int j = 0; j < 24; j++) {
							if((usrFret.getFretNote(i, j)) == cho[0]) {
								grid[i][j].setBackground(Color.RED);
							}
							else if((usrFret.getFretNote(i, j)) == cho[1]) {
								grid[i][j].setBackground(Color.ORANGE);
							}
							else if((usrFret.getFretNote(i, j)) == cho[2]) {
								grid[i][j].setBackground(Color.YELLOW);
							}
							else {
								grid[i][j].setBackground(Color.GRAY);
							}
						}
					}
				}
		});
		
		JRadioButton maj7Cho = new JRadioButton("Major 7");
		maj7Cho.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e1)
				{
					usrCho.maj7Cho();
					int[] cho = usrCho.getCho();
					System.out.println(cho[3]);
					usrCho.printChord();
					for(int i = 0; i < 6; i++){
						for(int j = 0; j < 24; j++) {
							if((usrFret.getFretNote(i, j)) == cho[0]) {
								grid[i][j].setBackground(Color.RED);
							}
							else if((usrFret.getFretNote(i, j)) == cho[1]) {
								grid[i][j].setBackground(Color.ORANGE);
							}
							else if((usrFret.getFretNote(i, j)) == cho[2]) {
								grid[i][j].setBackground(Color.YELLOW);
							}
							else if((usrFret.getFretNote(i, j)) == cho[3]) {
								grid[i][j].setBackground(Color.GREEN);
							}
							else {
								grid[i][j].setBackground(Color.GRAY);
							}
						}
					}
				}
		});
		
		JRadioButton minCho = new JRadioButton("Min");
		minCho.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e1)
				{
					usrCho.minCho();
					int[] cho = usrCho.getCho();
					usrCho.printChord();
					for(int i = 0; i < 6; i++){
						for(int j = 0; j < 24; j++) {
							if((usrFret.getFretNote(i, j)) == cho[0]) {
								grid[i][j].setBackground(Color.RED);
							}
							else if((usrFret.getFretNote(i, j)) == cho[1]) {
								grid[i][j].setBackground(Color.ORANGE);
							}
							else if((usrFret.getFretNote(i, j)) == cho[2]) {
								grid[i][j].setBackground(Color.YELLOW);
							}
							else {
								grid[i][j].setBackground(Color.GRAY);
							}
						}
					}
				}
		});
		
		JRadioButton min7Cho = new JRadioButton("Minor 7");
		min7Cho.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e1)
				{
					usrCho.min7Cho();
					int[] cho = usrCho.getCho();
					usrCho.printChord();
					for(int i = 0; i < 6; i++){
						for(int j = 0; j < 24; j++) {
							if((usrFret.getFretNote(i, j)) == cho[0]) {
								grid[i][j].setBackground(Color.RED);
							}
							else if((usrFret.getFretNote(i, j)) == cho[1]) {
								grid[i][j].setBackground(Color.ORANGE);
							}
							else if((usrFret.getFretNote(i, j)) == cho[2]) {
								grid[i][j].setBackground(Color.YELLOW);
							}
							else if((usrFret.getFretNote(i, j)) == cho[3]) {
								grid[i][j].setBackground(Color.GREEN);
							}
							else {
								grid[i][j].setBackground(Color.GRAY);
							}
						}
					}
				}
		});
		
		
		//Adding tuning select DBs to top left panel **********************************************************
		topLPan.add(drop1);
		topLPan.add(drop2);
		topLPan.add(drop3);
		topLPan.add(drop4);
		topLPan.add(drop5);
		topLPan.add(drop6);
		
		//adding Chord Selection DBs + RBs to top right panel *************************************************
		topRPan.add(choPick);
		topRPan.add(majCho);
		topRPan.add(minCho);
		topRPan.add(maj7Cho);
		topRPan.add(min7Cho);
		
		//setting main top and bottomm spilt panels ***********************************************************
		splitPane.setTopComponent(topSplitPane);
		splitPane.setBottomComponent(botPan);
		
		//setting left and right top panels *******************************************************************
		topSplitPane.setLeftComponent(topLPan);
		topSplitPane.setRightComponent(topRPan);
		
		//add it all to the frame, set visible*****************************************************************	
		frame.add(splitPane); 
		frame.setVisible(true);
		}

}
