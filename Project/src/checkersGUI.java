import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import java.io.*;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;


public class checkersGUI {

	private JFrame frmCheckers;
	private JTextField selectedpiece;
	private JTextField destinationofpiece;
	private JTextField currentplayer;
	private JTextField tFb8;
	private JTextField tFd8;
	private JTextField tFf8;
	private JTextField tFh8;
	private JTextField tFa7;
	private JTextField tFc7;
	private JTextField tFe7;
	private JTextField tFg7;
	private JTextField tFb6;
	private JTextField tFd6;
	private JTextField tFf6;
	private JTextField tFh6;
	private JTextField tFa5;
	private JTextField tFc5;
	private JTextField tFe5;
	private JTextField tFg5;
	private JTextField tFb4;
	private JTextField tFd4;
	private JTextField tFf4;
	private JTextField tFh4;
	private JTextField tFa3;
	private JTextField tFc3;
	private JTextField tFe3;
	private JTextField tFg3;
	private JTextField tFb2;
	private JTextField tFd2;
	private JTextField tFf2;
	private JTextField tFh2;
	private JTextField tFa1;
	private JTextField tFc1;
	private JTextField tFe1;
	private JTextField tFg1;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel lblA_1;
	private JLabel lblB_1;
	private JLabel lblC_1;
	private JLabel lblD_1;
	private JLabel lblE_1;
	private JLabel lblF_1;
	private JLabel lblG_1;
	private JLabel lblH_1;
	private JButton btnNewGame;
	private JButton btnResign;
	//
	private String[][] board = new String[12][12];
	private int fl1,fl2,omc=0;
	private String[] bor = {"Black","Red"};
	private String sp,sd;
	private char[] atoh = {'a','b','c','d','e','f','g','h'};
	private char[] otoe = {'1','2','3','4','5','6','7','8'};
	private int m,n,mtemp,ntemp;
	private int x,y,xtemp,ytemp;
	private int p,q,pcounter,qcounter;
	private boolean validmove,kpcheck,eatcheck,gameover,validinput;
	private JTextArea notification;
	private String export="",exporttemp="";
	private JPanel panel_1;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	
	
	
	
	
	//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkersGUI window = new checkersGUI();
					window.frmCheckers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public checkersGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCheckers = new JFrame();
		frmCheckers.setBackground(Color.BLACK);
		frmCheckers.setTitle("Checkers");
		frmCheckers.setResizable(false);
		frmCheckers.getContentPane().setBackground(Color.DARK_GRAY);
		frmCheckers.getContentPane().setFont(new Font("Candara", Font.PLAIN, 12));
		frmCheckers.setBounds(100, 100, 437, 350);
		frmCheckers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckers.getContentPane().setLayout(null);
		
		lblB_1 = new JLabel("B");
		lblB_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblB_1.setForeground(Color.WHITE);
		lblB_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblB_1.setBounds(65, 40, 25, 20);
		frmCheckers.getContentPane().add(lblB_1);
		
		lblA_1 = new JLabel("A");
		lblA_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblA_1.setForeground(Color.WHITE);
		lblA_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblA_1.setBounds(40, 40, 25, 20);
		frmCheckers.getContentPane().add(lblA_1);
		
		currentplayer = new JTextField();
		currentplayer.setFont(new Font("Candara", Font.PLAIN, 12));
		currentplayer.setForeground(Color.WHITE);
		currentplayer.setBackground(Color.DARK_GRAY);
		currentplayer.setEditable(false);
		currentplayer.setBounds(110, 292, 60, 20);
		frmCheckers.getContentPane().add(currentplayer);
		currentplayer.setColumns(10);
		
		JLabel lblCurrentPlayer = new JLabel("Current Player: ");
		lblCurrentPlayer.setFont(new Font("Candara", Font.PLAIN, 12));
		lblCurrentPlayer.setForeground(Color.WHITE);
		lblCurrentPlayer.setBounds(20, 295, 85, 14);
		frmCheckers.getContentPane().add(lblCurrentPlayer);
		
		panel_1 = new JPanel();
		panel_1.setToolTipText("Board output");
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(40, 60, 200, 200);
		frmCheckers.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tFb8 = new JTextField();
		tFb8.setBounds(25, 0, 25, 25);
		panel_1.add(tFb8);
		tFb8.setToolTipText("B8");
		tFb8.setBackground(Color.WHITE);
		tFb8.setEditable(false);
		tFb8.setFont(new Font("Consolas", Font.BOLD, 12));
		tFb8.setColumns(10);
		
		tFd8 = new JTextField();
		tFd8.setBounds(75, 0, 25, 25);
		panel_1.add(tFd8);
		tFd8.setToolTipText("D8");
		tFd8.setBackground(Color.WHITE);
		tFd8.setEditable(false);
		tFd8.setFont(new Font("Consolas", Font.BOLD, 12));
		tFd8.setColumns(10);
		
		tFf8 = new JTextField();
		tFf8.setBounds(125, 0, 25, 25);
		panel_1.add(tFf8);
		tFf8.setToolTipText("F8");
		tFf8.setBackground(Color.WHITE);
		tFf8.setEditable(false);
		tFf8.setFont(new Font("Consolas", Font.BOLD, 12));
		tFf8.setColumns(10);
		
		tFh8 = new JTextField();
		tFh8.setBounds(175, 0, 25, 25);
		panel_1.add(tFh8);
		tFh8.setToolTipText("H8");
		tFh8.setBackground(Color.WHITE);
		tFh8.setEditable(false);
		tFh8.setFont(new Font("Consolas", Font.BOLD, 12));
		tFh8.setColumns(10);
		
		tFa7 = new JTextField();
		tFa7.setBounds(0, 25, 25, 25);
		panel_1.add(tFa7);
		tFa7.setToolTipText("A7");
		tFa7.setBackground(Color.WHITE);
		tFa7.setEditable(false);
		tFa7.setFont(new Font("Consolas", Font.BOLD, 12));
		tFa7.setColumns(10);
		
		tFc7 = new JTextField();
		tFc7.setBounds(50, 25, 25, 25);
		panel_1.add(tFc7);
		tFc7.setToolTipText("C7");
		tFc7.setBackground(Color.WHITE);
		tFc7.setEditable(false);
		tFc7.setFont(new Font("Consolas", Font.BOLD, 12));
		tFc7.setColumns(10);
		
		tFe7 = new JTextField();
		tFe7.setBounds(100, 25, 25, 25);
		panel_1.add(tFe7);
		tFe7.setToolTipText("E7");
		tFe7.setBackground(Color.WHITE);
		tFe7.setEditable(false);
		tFe7.setFont(new Font("Consolas", Font.BOLD, 12));
		tFe7.setColumns(10);
		
		tFg7 = new JTextField();
		tFg7.setBounds(150, 25, 25, 25);
		panel_1.add(tFg7);
		tFg7.setToolTipText("G7");
		tFg7.setBackground(Color.WHITE);
		tFg7.setEditable(false);
		tFg7.setFont(new Font("Consolas", Font.BOLD, 12));
		tFg7.setColumns(10);
		
		tFb6 = new JTextField();
		tFb6.setBounds(25, 50, 25, 25);
		panel_1.add(tFb6);
		tFb6.setToolTipText("B6");
		tFb6.setBackground(Color.WHITE);
		tFb6.setEditable(false);
		tFb6.setFont(new Font("Consolas", Font.BOLD, 12));
		tFb6.setColumns(10);
		
		tFd6 = new JTextField();
		tFd6.setBounds(75, 50, 25, 25);
		panel_1.add(tFd6);
		tFd6.setToolTipText("D6");
		tFd6.setBackground(Color.WHITE);
		tFd6.setEditable(false);
		tFd6.setFont(new Font("Consolas", Font.BOLD, 12));
		tFd6.setColumns(10);
		
		tFf6 = new JTextField();
		tFf6.setBounds(125, 50, 25, 25);
		panel_1.add(tFf6);
		tFf6.setToolTipText("F6");
		tFf6.setBackground(Color.WHITE);
		tFf6.setEditable(false);
		tFf6.setFont(new Font("Consolas", Font.BOLD, 12));
		tFf6.setColumns(10);
		
		tFh6 = new JTextField();
		tFh6.setBounds(175, 50, 25, 25);
		panel_1.add(tFh6);
		tFh6.setToolTipText("H6");
		tFh6.setBackground(Color.WHITE);
		tFh6.setEditable(false);
		tFh6.setFont(new Font("Consolas", Font.BOLD, 12));
		tFh6.setColumns(10);
		
		tFa5 = new JTextField();
		tFa5.setBounds(0, 75, 25, 25);
		panel_1.add(tFa5);
		tFa5.setToolTipText("A5");
		tFa5.setBackground(Color.WHITE);
		tFa5.setEditable(false);
		tFa5.setFont(new Font("Consolas", Font.BOLD, 12));
		tFa5.setColumns(10);
		
		tFc5 = new JTextField();
		tFc5.setBounds(50, 75, 25, 25);
		panel_1.add(tFc5);
		tFc5.setToolTipText("C5");
		tFc5.setBackground(Color.WHITE);
		tFc5.setEditable(false);
		tFc5.setFont(new Font("Consolas", Font.BOLD, 12));
		tFc5.setColumns(10);
		
		tFe5 = new JTextField();
		tFe5.setBounds(100, 75, 25, 25);
		panel_1.add(tFe5);
		tFe5.setToolTipText("E5");
		tFe5.setBackground(Color.WHITE);
		tFe5.setEditable(false);
		tFe5.setFont(new Font("Consolas", Font.BOLD, 12));
		tFe5.setColumns(10);
		
		tFg5 = new JTextField();
		tFg5.setBounds(150, 75, 25, 25);
		panel_1.add(tFg5);
		tFg5.setToolTipText("G5");
		tFg5.setBackground(Color.WHITE);
		tFg5.setEditable(false);
		tFg5.setFont(new Font("Consolas", Font.BOLD, 12));
		tFg5.setColumns(10);
		
		tFb4 = new JTextField();
		tFb4.setBounds(25, 100, 25, 25);
		panel_1.add(tFb4);
		tFb4.setToolTipText("B4");
		tFb4.setBackground(Color.WHITE);
		tFb4.setEditable(false);
		tFb4.setFont(new Font("Consolas", Font.BOLD, 12));
		tFb4.setColumns(10);
		
		tFd4 = new JTextField();
		tFd4.setBounds(75, 100, 25, 25);
		panel_1.add(tFd4);
		tFd4.setToolTipText("D4");
		tFd4.setBackground(Color.WHITE);
		tFd4.setEditable(false);
		tFd4.setFont(new Font("Consolas", Font.BOLD, 12));
		tFd4.setColumns(10);
		
		tFf4 = new JTextField();
		tFf4.setBounds(125, 100, 25, 25);
		panel_1.add(tFf4);
		tFf4.setToolTipText("F4");
		tFf4.setBackground(Color.WHITE);
		tFf4.setEditable(false);
		tFf4.setFont(new Font("Consolas", Font.BOLD, 12));
		tFf4.setColumns(10);
		
		tFh4 = new JTextField();
		tFh4.setBounds(175, 100, 25, 25);
		panel_1.add(tFh4);
		tFh4.setToolTipText("H4");
		tFh4.setBackground(Color.WHITE);
		tFh4.setEditable(false);
		tFh4.setFont(new Font("Consolas", Font.BOLD, 12));
		tFh4.setColumns(10);
		
		tFa3 = new JTextField();
		tFa3.setBounds(0, 125, 25, 25);
		panel_1.add(tFa3);
		tFa3.setToolTipText("A3");
		tFa3.setBackground(Color.WHITE);
		tFa3.setEditable(false);
		tFa3.setFont(new Font("Consolas", Font.BOLD, 12));
		tFa3.setColumns(10);
		
		tFc3 = new JTextField();
		tFc3.setBounds(50, 125, 25, 25);
		panel_1.add(tFc3);
		tFc3.setToolTipText("C3");
		tFc3.setBackground(Color.WHITE);
		tFc3.setEditable(false);
		tFc3.setFont(new Font("Consolas", Font.BOLD, 12));
		tFc3.setColumns(10);
		
		tFe3 = new JTextField();
		tFe3.setBounds(100, 125, 25, 25);
		panel_1.add(tFe3);
		tFe3.setToolTipText("E3");
		tFe3.setBackground(Color.WHITE);
		tFe3.setEditable(false);
		tFe3.setFont(new Font("Consolas", Font.BOLD, 12));
		tFe3.setColumns(10);
		
		tFg3 = new JTextField();
		tFg3.setBounds(150, 125, 25, 25);
		panel_1.add(tFg3);
		tFg3.setToolTipText("G3");
		tFg3.setBackground(Color.WHITE);
		tFg3.setEditable(false);
		tFg3.setFont(new Font("Consolas", Font.BOLD, 12));
		tFg3.setColumns(10);
		
		tFb2 = new JTextField();
		tFb2.setBounds(25, 150, 25, 25);
		panel_1.add(tFb2);
		tFb2.setToolTipText("B2");
		tFb2.setBackground(Color.WHITE);
		tFb2.setEditable(false);
		tFb2.setFont(new Font("Consolas", Font.BOLD, 12));
		tFb2.setColumns(10);
		
		tFd2 = new JTextField();
		tFd2.setBounds(75, 150, 25, 25);
		panel_1.add(tFd2);
		tFd2.setToolTipText("D2");
		tFd2.setBackground(Color.WHITE);
		tFd2.setEditable(false);
		tFd2.setFont(new Font("Consolas", Font.BOLD, 12));
		tFd2.setColumns(10);
		
		tFf2 = new JTextField();
		tFf2.setBounds(125, 150, 25, 25);
		panel_1.add(tFf2);
		tFf2.setToolTipText("F2");
		tFf2.setBackground(Color.WHITE);
		tFf2.setEditable(false);
		tFf2.setFont(new Font("Consolas", Font.BOLD, 12));
		tFf2.setColumns(10);
		
		tFh2 = new JTextField();
		tFh2.setBounds(175, 150, 25, 25);
		panel_1.add(tFh2);
		tFh2.setToolTipText("H2");
		tFh2.setBackground(Color.WHITE);
		tFh2.setEditable(false);
		tFh2.setFont(new Font("Consolas", Font.BOLD, 12));
		tFh2.setColumns(10);
		
		tFa1 = new JTextField();
		tFa1.setBounds(0, 175, 25, 25);
		panel_1.add(tFa1);
		tFa1.setToolTipText("A1");
		tFa1.setBackground(Color.WHITE);
		tFa1.setEditable(false);
		tFa1.setFont(new Font("Consolas", Font.BOLD, 12));
		tFa1.setColumns(10);
		
		tFc1 = new JTextField();
		tFc1.setBounds(50, 175, 25, 25);
		panel_1.add(tFc1);
		tFc1.setToolTipText("C1");
		tFc1.setBackground(Color.WHITE);
		tFc1.setEditable(false);
		tFc1.setFont(new Font("Consolas", Font.BOLD, 12));
		tFc1.setColumns(10);
		
		tFe1 = new JTextField();
		tFe1.setBounds(100, 175, 25, 25);
		panel_1.add(tFe1);
		tFe1.setToolTipText("E1");
		tFe1.setBackground(Color.WHITE);
		tFe1.setEditable(false);
		tFe1.setFont(new Font("Consolas", Font.BOLD, 12));
		tFe1.setColumns(10);
		
		tFg1 = new JTextField();
		tFg1.setBounds(150, 175, 25, 25);
		panel_1.add(tFg1);
		tFg1.setToolTipText("G1");
		tFg1.setBackground(Color.WHITE);
		tFg1.setEditable(false);
		tFg1.setFont(new Font("Consolas", Font.BOLD, 12));
		tFg1.setColumns(10);
		
		label_3 = new JLabel("5");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_3.setBounds(20, 135, 20, 25);
		frmCheckers.getContentPane().add(label_3);
		
		label_4 = new JLabel("4");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_4.setBounds(20, 160, 20, 25);
		frmCheckers.getContentPane().add(label_4);
		
		label_5 = new JLabel("3");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_5.setBounds(20, 185, 20, 25);
		frmCheckers.getContentPane().add(label_5);
		
		label_6 = new JLabel("2");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_6.setBounds(20, 210, 20, 25);
		frmCheckers.getContentPane().add(label_6);
		
		label_7 = new JLabel("1");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_7.setBounds(20, 235, 20, 25);
		frmCheckers.getContentPane().add(label_7);
		
		label_8 = new JLabel("1");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_8.setBounds(250, 235, 20, 25);
		frmCheckers.getContentPane().add(label_8);
		
		label_9 = new JLabel("8");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_9.setBounds(250, 60, 20, 25);
		frmCheckers.getContentPane().add(label_9);
		
		label_10 = new JLabel("7");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_10.setBounds(250, 85, 20, 25);
		frmCheckers.getContentPane().add(label_10);
		
		label_11 = new JLabel("6");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_11.setBounds(250, 110, 20, 25);
		frmCheckers.getContentPane().add(label_11);
		
		label_12 = new JLabel("5");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_12.setBounds(250, 135, 20, 25);
		frmCheckers.getContentPane().add(label_12);
		
		label_13 = new JLabel("4");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_13.setBounds(250, 160, 20, 25);
		frmCheckers.getContentPane().add(label_13);
		
		label_14 = new JLabel("3");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_14.setBounds(250, 185, 20, 25);
		frmCheckers.getContentPane().add(label_14);
		
		label_15 = new JLabel("2");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_15.setBounds(250, 210, 20, 25);
		frmCheckers.getContentPane().add(label_15);
		
		lblC_1 = new JLabel("C");
		lblC_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblC_1.setForeground(Color.WHITE);
		lblC_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblC_1.setBounds(90, 40, 25, 20);
		frmCheckers.getContentPane().add(lblC_1);
		
		lblD_1 = new JLabel("D");
		lblD_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblD_1.setForeground(Color.WHITE);
		lblD_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblD_1.setBounds(115, 40, 25, 20);
		frmCheckers.getContentPane().add(lblD_1);
		
		lblE_1 = new JLabel("E");
		lblE_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1.setForeground(Color.WHITE);
		lblE_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblE_1.setBounds(140, 40, 25, 20);
		frmCheckers.getContentPane().add(lblE_1);
		
		lblF_1 = new JLabel("F");
		lblF_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1.setForeground(Color.WHITE);
		lblF_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblF_1.setBounds(165, 40, 25, 20);
		frmCheckers.getContentPane().add(lblF_1);
		
		lblG_1 = new JLabel("G");
		lblG_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblG_1.setForeground(Color.WHITE);
		lblG_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblG_1.setBounds(190, 40, 25, 20);
		frmCheckers.getContentPane().add(lblG_1);
		
		lblH_1 = new JLabel("H");
		lblH_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblH_1.setForeground(Color.WHITE);
		lblH_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblH_1.setBounds(215, 40, 25, 20);
		frmCheckers.getContentPane().add(lblH_1);
		
		JButton exportbutton = new JButton("Export");
		exportbutton.setToolTipText("Export Game History to .txt File");
		exportbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//exporter
				try{
					FileWriter fW = new FileWriter("velasco_rayco.txt");
					BufferedWriter bW = new BufferedWriter(fW);
					bW.write(export);
					bW.close();
				}catch(Exception ex){
					throw new RuntimeException(ex);
				}
				//
				notification.setText("Game History Exported.\nFile: velasco_rayco.txt");
			}
		});
		exportbutton.setForeground(Color.WHITE);
		exportbutton.setFont(new Font("Candara", Font.PLAIN, 12));
		exportbutton.setBackground(Color.BLACK);
		exportbutton.setBounds(301, 277, 120, 23);
		frmCheckers.getContentPane().add(exportbutton);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setToolTipText("Start a New Game");
		btnNewGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//set up board
				
				//this button will setup a new game
				
				omc = 0;
				//
				for(fl1=0;fl1<12;fl1++){ //this part will put the black and white floor on the board
					for(fl2=0;fl2<12;fl2++){
						if((fl1+fl2)%2==1){
							board[fl1][fl2]="   ";
						}
						else{
							board[fl1][fl2]="---";
						}
					}
				}
				//
				board[2][3]=" R ";
				board[2][5]=" R ";
				board[2][7]=" R ";				//this part will "assemble" the pieces into the 2D array board
				board[2][9]=" R ";
				board[3][2]=" R ";
				board[3][4]=" R ";
				board[3][6]=" R ";
				board[3][8]=" R ";
				board[4][3]=" R ";
				board[4][5]=" R ";
				board[4][7]=" R ";
				board[4][9]=" R ";
				board[7][2]=" B ";
				board[7][4]=" B ";
				board[7][6]=" B ";
				board[7][8]=" B ";
				board[8][3]=" B ";
				board[8][5]=" B ";
				board[8][7]=" B ";
				board[8][9]=" B ";
				board[9][2]=" B ";
				board[9][4]=" B ";
				board[9][6]=" B ";
				board[9][8]=" B ";
				//
				tFa1.setText(board[9][2]);
				tFc1.setText(board[9][4]);
				tFe1.setText(board[9][6]);
				tFg1.setText(board[9][8]);
				
				tFb2.setText(board[8][3]);		//this part will print the current situation to the GUI board
				tFd2.setText(board[8][5]);
				tFf2.setText(board[8][7]);
				tFh2.setText(board[8][9]);
				
				tFa3.setText(board[7][2]);
				tFc3.setText(board[7][4]);
				tFe3.setText(board[7][6]);
				tFg3.setText(board[7][8]);
				
				tFb4.setText(board[6][3]);
				tFd4.setText(board[6][5]);
				tFf4.setText(board[6][7]);
				tFh4.setText(board[6][9]);
				
				tFa5.setText(board[5][2]);
				tFc5.setText(board[5][4]);
				tFe5.setText(board[5][6]);
				tFg5.setText(board[5][8]);
				
				tFb6.setText(board[4][3]);
				tFd6.setText(board[4][5]);
				tFf6.setText(board[4][7]);
				tFh6.setText(board[4][9]);
				
				tFa7.setText(board[3][2]);
				tFc7.setText(board[3][4]);
				tFe7.setText(board[3][6]);
				tFg7.setText(board[3][8]);
				
				tFb8.setText(board[2][3]);
				tFd8.setText(board[2][5]);
				tFf8.setText(board[2][7]);
				tFh8.setText(board[2][9]);
				
				currentplayer.setText(bor[omc]);
				notification.setText("New Game started.");
				gameover=false;
				//
				export = "Checkers Game History\n\nSTART\n|" + board[2][2] + "|" + board[2][3] + "|" + board[2][4] + "|" + board[2][5] + "|" + board[2][6] + "|" + board[2][7] + "|" + board[2][8] + "|" + board[2][9] + "|\n" + "|" + board[3][2] + "|" + board[3][3] + "|" + board[3][4] + "|" + board[3][5] + "|" + board[3][6] + "|" + board[3][7] + "|" + board[3][8] + "|" + board[3][9] + "|\n" + "|" + board[4][2] + "|" + board[4][3] + "|" + board[4][4] + "|" + board[4][5] + "|" + board[4][6] + "|" + board[4][7] + "|" + board[4][8] + "|" + board[4][9] + "|\n" + "|" + board[5][2] + "|" + board[5][3] + "|" + board[5][4] + "|" + board[5][5] + "|" + board[5][6] + "|" + board[5][7] + "|" + board[5][8] + "|" + board[5][9] + "|\n" + "|" + board[6][2] + "|" + board[6][3] + "|" + board[6][4] + "|" + board[6][5] + "|" + board[6][6] + "|" + board[6][7] + "|" + board[6][8] + "|" + board[6][9] + "|\n" + "|" + board[7][2] + "|" + board[7][3] + "|" + board[7][4] + "|" + board[7][5] + "|" + board[7][6] + "|" + board[7][7] + "|" + board[7][8] + "|" + board[7][9] + "|\n" + "|" + board[8][2] + "|" + board[8][3] + "|" + board[8][4] + "|" + board[8][5] + "|" + board[8][6] + "|" + board[8][7] + "|" + board[8][8] + "|" + board[8][9] + "|\n" + "|" + board[9][2] + "|" + board[9][3] + "|" + board[9][4] + "|" + board[9][5] + "|" + board[9][6] + "|" + board[9][7] + "|" + board[9][8] + "|" + board[9][9] + "|\n\n";

				
				
			}
		});
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.setFont(new Font("Candara", Font.PLAIN, 12));
		btnNewGame.setBackground(Color.BLACK);
		btnNewGame.setBounds(0, 0, 100, 25);
		frmCheckers.getContentPane().add(btnNewGame);
		
		btnResign = new JButton("Resign");
		btnResign.setToolTipText("Resign current player");
		btnResign.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				if(omc==0){
					notification.setText("Welcome!\r\nClick\r\n\"New Game\"\r\nto start!");
				}
				else{
					notification.setText(bor[omc%2] + " Player Resigns!\n\n" + bor[(omc+1)%2] + " Player Wins!");
					selectedpiece.setText("");
					destinationofpiece.setText("");
					currentplayer.setText("");
					gameover=true;
				}
			}
		});
		btnResign.setForeground(Color.WHITE);
		btnResign.setFont(new Font("Candara", Font.PLAIN, 12));
		btnResign.setBackground(Color.BLACK);
		btnResign.setBounds(331, 0, 100, 25);
		frmCheckers.getContentPane().add(btnResign);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(273, 157, 148, 99);
		frmCheckers.getContentPane().add(panel);
		panel.setLayout(null);
		
		notification = new JTextArea();
		notification.setBounds(6, 6, 136, 87);
		panel.add(notification);
		notification.setToolTipText("Alerts & Notifications");
		notification.setText("Welcome!\r\n\r\nClick\r\n\"New Game\"\r\nto start!");
		notification.setForeground(Color.RED);
		notification.setBackground(Color.DARK_GRAY);
		notification.setFont(new Font("Candara", Font.PLAIN, 12));
		notification.setEditable(false);
		
		JButton movebutton = new JButton("OK");
		movebutton.setBounds(301, 121, 120, 23);
		frmCheckers.getContentPane().add(movebutton);
		movebutton.setToolTipText("Move");
		movebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		movebutton.setFont(new Font("Candara", Font.PLAIN, 12));
		movebutton.setForeground(Color.WHITE);
		movebutton.setBackground(Color.BLACK);
		
		JLabel lblMove = new JLabel("Move to:");
		lblMove.setBounds(301, 93, 50, 14);
		frmCheckers.getContentPane().add(lblMove);
		lblMove.setFont(new Font("Candara", Font.PLAIN, 12));
		lblMove.setForeground(Color.WHITE);
		
		destinationofpiece = new JTextField();
		destinationofpiece.setBounds(361, 90, 60, 20);
		frmCheckers.getContentPane().add(destinationofpiece);
		destinationofpiece.setFont(new Font("Candara", Font.PLAIN, 12));
		destinationofpiece.setBackground(Color.LIGHT_GRAY);
		destinationofpiece.setColumns(10);
		
		selectedpiece = new JTextField();
		selectedpiece.setBounds(361, 60, 60, 20);
		frmCheckers.getContentPane().add(selectedpiece);
		selectedpiece.setFont(new Font("Candara", Font.PLAIN, 12));
		selectedpiece.setBackground(Color.LIGHT_GRAY);
		selectedpiece.setColumns(10);
		
		JLabel lblPiece = new JLabel("Piece in:");
		lblPiece.setBounds(301, 63, 50, 14);
		frmCheckers.getContentPane().add(lblPiece);
		lblPiece.setFont(new Font("Candara", Font.PLAIN, 12));
		lblPiece.setForeground(Color.WHITE);
		
		JLabel lblVer = new JLabel("ver12.58922.22351");
		lblVer.setForeground(Color.LIGHT_GRAY);
		lblVer.setFont(new Font("Arial", Font.PLAIN, 11));
		lblVer.setBounds(331, 308, 100, 14);
		frmCheckers.getContentPane().add(lblVer);
		
		label = new JLabel("8");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label.setBounds(20, 60, 20, 25);
		frmCheckers.getContentPane().add(label);
		
		label_1 = new JLabel("7");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_1.setBounds(20, 85, 20, 25);
		frmCheckers.getContentPane().add(label_1);
		
		label_2 = new JLabel("6");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_2.setBounds(20, 110, 20, 25);
		frmCheckers.getContentPane().add(label_2);
		
		label_16 = new JLabel("A");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_16.setBounds(40, 260, 25, 20);
		frmCheckers.getContentPane().add(label_16);
		
		label_17 = new JLabel("B");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_17.setBounds(65, 260, 25, 20);
		frmCheckers.getContentPane().add(label_17);
		
		label_18 = new JLabel("C");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_18.setBounds(90, 260, 25, 20);
		frmCheckers.getContentPane().add(label_18);
		
		label_19 = new JLabel("D");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_19.setBounds(115, 260, 25, 20);
		frmCheckers.getContentPane().add(label_19);
		
		label_20 = new JLabel("F");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_20.setBounds(165, 260, 25, 20);
		frmCheckers.getContentPane().add(label_20);
		
		label_21 = new JLabel("E");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_21.setBounds(140, 260, 25, 20);
		frmCheckers.getContentPane().add(label_21);
		
		label_22 = new JLabel("G");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_22.setBounds(190, 260, 25, 20);
		frmCheckers.getContentPane().add(label_22);
		
		label_23 = new JLabel("H");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Cambria Math", Font.BOLD, 12));
		label_23.setBounds(215, 260, 25, 20);
		frmCheckers.getContentPane().add(label_23);
		movebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//move button
				//
				kpcheck=false;
				eatcheck=false;
				
				//
				sp = selectedpiece.getText(); //gets the input text
				sd = destinationofpiece.getText();
				//
				if(sp.length()!=2){  //this if-else block is for input error checking
					notification.setText("Invalid Input.\nTry Again.");
					validinput=false;
					validmove=false;
				}
				else if(sd.length()!=2){
					notification.setText("Invalid Move.\nTry Again.");
					validinput=false;
					validmove=false;
					
				}
				else{
					validmove=true;
					validinput=true;
				}
				//
				
				//
				if(validinput==true){
					char[] convertersp = sp.toCharArray(); //this part is for the selected piece
					//
					if (convertersp[0]=='A'){
						convertersp[0]='a';
					}
					else if (convertersp[0]=='B'){
						convertersp[0]='b';
					}
					else if (convertersp[0]=='C'){
						convertersp[0]='c';
					}
					else if (convertersp[0]=='D'){
						convertersp[0]='d';
					}
					else if (convertersp[0]=='E'){
						convertersp[0]='e';
					}
					else if (convertersp[0]=='F'){
						convertersp[0]='f';
					}
					else if (convertersp[0]=='G'){
						convertersp[0]='g';
					}
					else if (convertersp[0]=='H'){
						convertersp[0]='h';
					}
					//
					for(ntemp=0;ntemp<8;ntemp++){ //this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array
						if(atoh[ntemp]==convertersp[0]){
							n=ntemp;
							break;
						}
						else if(ntemp==7){
							validinput=false;
						}
					}
					for(mtemp=0;mtemp<8;mtemp++){ //also this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array (same as above)
						if(otoe[mtemp]==convertersp[1]){
							m=7-mtemp;
							break;
						}
						else if(mtemp==7){
							validinput=false;
						}
					}
					//
					char[] convertersd = sd.toCharArray(); //this part is for the destination of the selected piece
					
					if (convertersd[0]=='A'){
						convertersd[0]='a';
					}
					else if (convertersd[0]=='B'){
						convertersd[0]='b';
					}
					else if (convertersd[0]=='C'){
						convertersd[0]='c';
					}
					else if (convertersd[0]=='D'){
						convertersd[0]='d';
					}
					else if (convertersd[0]=='E'){
						convertersd[0]='e';
					}
					else if (convertersd[0]=='F'){
						convertersd[0]='f';
					}
					else if (convertersd[0]=='G'){
						convertersd[0]='g';
					}
					else if (convertersd[0]=='H'){
						convertersd[0]='h';
					}
					
					for(ytemp=0;ytemp<8;ytemp++){ //this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array
						if(atoh[ytemp]==convertersd[0]){
							y=ytemp;
							break;
						}
						else if(ytemp==7){
							validinput=false;
						}
					}
					for(xtemp=0;xtemp<8;xtemp++){ //also this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array (same as above)
						if(otoe[xtemp]==convertersd[1]){
							x=7-xtemp;
							break;
						}
						else if(xtemp==7){
							validinput=false;
						}
					}
					if(validinput==true){
						m=m+2;
						n=n+2;
						x=x+2;
						y=y+2;
						//
						if(board[m][n]=="   "||board[m][n]=="---"||board[m][n]==""){
							notification.setText("No Piece selected!\nTry Again."); //to check if a piece was selected
							validmove=false;
						}
						//
						if(omc%2==0&&board[m][n]==" R "){
							notification.setText("Wrong piece selected!\nTry Again."); //to check if the player selected the wrong piece
							validmove=false;
						}
						else if(omc%2==1&&board[m][n]==" B "){ //to check if the player selected the enemy's piece
							notification.setText("Wrong piece selected!\nTry Again.");
							validmove=false;
						}
						//
						if(omc%2==0){ //this block of code is for checking of the selected piece is a king
							if(board[m][n]=="BK "){
								kpcheck=true;
							}
							else{
								kpcheck=false;
							}
						}
						else{
							if(board[m][n]=="RK "){
								kpcheck=true;
							}
							else{
								kpcheck=false;
							}
						}
						//
						if(kpcheck==false){ //if normal piece
							if(omc%2==0){//if black //this block of if-else code will check if the selected piece can and will eat
								if(board[m-1][n-1]==" R "||board[m-1][n-1]=="RK "||board[m-1][n+1]==" R "||board[m-1][n+1]=="RK "){
									if(((m-2==x)&&(n-2==y))||((m-2==x)&&(n+2==y))){
										if(board[x][y].equals("   ")==true){
											eatcheck=true;
										}
										else{
											eatcheck=false;
											validmove=false;
										}
									}
									else{
										eatcheck=false;
									}
								}
								
								if(eatcheck==false){ //this if statement will prevent the piece from making an illegal movement (jumping)
									if(((m-1==x)&&(n-1==y))||((m-1==x)&&(n+1==y))){
										
									}
									else{
										validmove=false;
										notification.setText("Invalid Move!\nTry Again.");
									}
								}
								
							}
							else{ //if red
								if(board[m+1][n-1]==" B "||board[m+1][n-1]=="BK "||board[m+1][n+1]==" B "||board[m+1][n+1]=="BK "){
									if(((m+2==x)&&(n+2==y))||((m+2==x)&&(n-2==y))){ 
										if(board[x][y].equals("   ")==true){
											eatcheck=true;
										}
										else{
											eatcheck=false;
											validmove=false;
										}
									}
									else{
										eatcheck=false;
									}
								}
								
								if(eatcheck==false){ //this if statement will prevent the piece from making an illegal movement (jumping)
									if(((m+1==x)&&(n-1==y))||((m+1==x)&&(n+1==y))){
										
									}
									else{
										validmove=false;
										notification.setText("Invalid Move!\nTry Again.");
									}
								}
							}
						}
						else{ //if king piece
							if(omc%2==0){//if black //this block of if-else code will check if the selected piece can and will eat
								if(board[m-1][n-1]==" R "||board[m-1][n-1]=="RK "||board[m-1][n+1]==" R "||board[m-1][n+1]=="RK "||board[m+1][n-1]==" R "||board[m+1][n-1]=="RK "||board[m+1][n+1]==" R "||board[m+1][n+1]=="RK "){
									if(((m-2==x)&&(n-2==y))||((m-2==x)&&(n+2==y))||((m+2==x)&&(n-2==y))||((m+2==x)&&(n+2==y))){
										if(board[x][y].equals("   ")==true){
											eatcheck=true;
										}
										else{
											eatcheck=false;
											validmove=false;
										}
									}
									else{
										eatcheck=false;
									}
								}
								
								if(eatcheck==false){ //this if statement will prevent the piece from making an illegal movement (jumping)
									if(((m+1==x)&&(n-1==y))||((m+1==x)&&(n+1==y))||((m-1==x)&&(n-1==y))||((m-1==x)&&(n+1==y))){
										
									}
									else{
										validmove=false;
										notification.setText("Invalid Move!\nTry Again.");
									}
								}
								
							}
							else{ //if red
								if(board[m+1][n-1]==" B "||board[m+1][n-1]=="BK "||board[m+1][n+1]==" B "||board[m+1][n+1]=="BK "||board[m-1][n-1]==" B "||board[m-1][n-1]=="BK "||board[m-1][n+1]==" B "||board[m-1][n+1]=="BK "){
									if(((m+2==x)&&(n+2==y))||((m+2==x)&&(n-2==y))||((m-2==x)&&(n-2==y))||((m-2==x)&&(n+2==y))){ 
										if(board[x][y].equals("   ")==true){
											eatcheck=true;
										}
										else{
											eatcheck=false;
											validmove=false;
										}
									}
									else{
										eatcheck=false;
									}
									
									if(eatcheck==false){ //this if statement will prevent the piece from making an illegal movement (jumping)
										if(((m+1==x)&&(n-1==y))||((m+1==x)&&(n+1==y))||((m-1==x)&&(n-1==y))||((m-1==x)&&(n+1==y))){
											
										}
										else{
											validmove=false;
											notification.setText("Invalid Move!\nTry Again.");
										}
									}
									
								}
							}
						}
						//
						if(board[x][y].equals(" R ")==true||board[x][y].equals(" B ")==true||board[x][y].equals("RK ")==true||board[x][y].equals("BK ")==true){
							notification.setText("Invalid Move!\nTry Again."); //this will prevent a piece from taking the position of its adjacent piece.
							validmove=false;
						}
					}
					else{
						validmove=false;
					}
				}
				//
				if(gameover==true){
					validmove=false;
				}
				//
				
				
				
				
				
				
				
				
				
				//

				//
				if(validmove==true){
					if(eatcheck==true){
						if(kpcheck==true){
							//king eat
							board[x][y]=board[m][n];
							
							if(omc%2==0){
								if((m-2==x)&&(n-2==y)){ //if black leftward up
									board[m-1][n-1]="   "; //these if, else if and else statements will remove the piece that was eaten from the board
								}
								else if((m+2==x)&&(n-2==y)){ //black leftward down
									board[m+1][n-1]="   ";
								}
								else if((m+2==x)&&(n+2==y)){ //black rightward down
									board[m+1][n+1]="   ";
								}
								else{ //if black rightward up
									board[m-1][n+1]="   ";
								}
							}
							else{
								if((m-2==x)&&(n-2==y)){ //if red leftward up
									board[m-1][n-1]="   "; //these if, else if and else statements will remove the piece that was eaten from the board
								}
								else if((m+2==x)&&(n-2==y)){ //red leftward down
									board[m+1][n-1]="   ";
								}
								else if((m+2==x)&&(n+2==y)){ //red rightward down
									board[m+1][n+1]="   ";
								}
								else{ //if red rightward up
									board[m-1][n+1]="   ";
								}
							}
							
							board[m][n]="   ";
							
							notification.setText("A " + bor[(omc+1)%2] + " Piece\nwas eaten.");
						}
						else{
							//normal eat
							board[x][y]=board[m][n];
							
							if(omc%2==0){
								if((m-2==x)&&(n-2==y)){ //if black leftward
									board[m-1][n-1]="   "; //these if, else if and else statements will remove the piece that was eaten from the board
								}
								else{ //if black rightward
									board[m-1][n+1]="   ";
								}
							}
							else{
								if((m+2==x)&&(n-2==y)){ //if red leftward
									board[m+1][n-1]="   ";
								}
								else{ //if red rightward
									board[m+1][n+1]="   ";								
								}
							}
							
							board[m][n]="   ";
							
							notification.setText("A " + bor[(omc+1)%2] + " Piece\nwas eaten.");
						}
					}
					else{
						if(kpcheck==true){
							//king move
							board[x][y]=board[m][n];
							board[m][n]="   ";
							
							notification.setText("");
						}
						else{
							//normal move
							board[x][y]=board[m][n];
							board[m][n]="   ";
							
							notification.setText("");
						}
					}
					//
					if(omc%2==0){ //this two if statements will promote a piece
						if(x==2){
							board[x][y]="BK ";
							notification.setText(notification.getText() + "\nA " + bor[omc%2] + " piece was\npromoted!");
						}
					}
					else{
						if(x==9){
							board[x][y]="RK ";
							notification.setText(notification.getText() + "\nA " + bor[omc%2] + " piece was\npromoted!");
						}
					}
					
					//
					tFa1.setText(board[9][2]);
					tFc1.setText(board[9][4]);
					tFe1.setText(board[9][6]);
					tFg1.setText(board[9][8]);
					
					tFb2.setText(board[8][3]);		//this part will print the current situation to the GUI board
					tFd2.setText(board[8][5]);
					tFf2.setText(board[8][7]);
					tFh2.setText(board[8][9]);
					
					tFa3.setText(board[7][2]);
					tFc3.setText(board[7][4]);
					tFe3.setText(board[7][6]);
					tFg3.setText(board[7][8]);
					
					tFb4.setText(board[6][3]);
					tFd4.setText(board[6][5]);
					tFf4.setText(board[6][7]);
					tFh4.setText(board[6][9]);
					
					tFa5.setText(board[5][2]);
					tFc5.setText(board[5][4]);
					tFe5.setText(board[5][6]);
					tFg5.setText(board[5][8]);
					
					tFb6.setText(board[4][3]);
					tFd6.setText(board[4][5]);
					tFf6.setText(board[4][7]);
					tFh6.setText(board[4][9]);
					
					tFa7.setText(board[3][2]);
					tFc7.setText(board[3][4]);
					tFe7.setText(board[3][6]);
					tFg7.setText(board[3][8]);
					
					tFb8.setText(board[2][3]);
					tFd8.setText(board[2][5]);
					tFf8.setText(board[2][7]);
					tFh8.setText(board[2][9]);
					//
					
					omc++;
					currentplayer.setText(bor[omc%2]);
					selectedpiece.setText("");
					destinationofpiece.setText("");
					
					//
					pcounter=0; //this part will check if there is a winner by checking if there are no more pieces
					qcounter=0;
					for(p=2;p<10;p++){
						for(q=2;q<10;q++){
							if(board[p][q]==" B "||board[p][q]=="BK "){
								pcounter++;
							}
							else if(board[p][q]==" R "||board[p][q]=="RK "){
								qcounter++;
							}
						}
					}
					if(pcounter==0){
						notification.setText("Red\nPlayer\nWins!!");
						gameover=true;
						currentplayer.setText("");
						export = export + "RED PLAYER WINS!";
					}
					else if(qcounter==0){
						notification.setText("Black\nPlayer\nWins!!");
						gameover=true;
						currentplayer.setText("");
						export = export + "BLACK PLAYER WINS!";
					}
					
					exporttemp = "Turn " + omc + ": " + bor[(omc+1)%2] + "'s Move.\n|" + board[2][2] + "|" + board[2][3] + "|" + board[2][4] + "|" + board[2][5] + "|" + board[2][6] + "|" + board[2][7] + "|" + board[2][8] + "|" + board[2][9] + "|\n" + "|" + board[3][2] + "|" + board[3][3] + "|" + board[3][4] + "|" + board[3][5] + "|" + board[3][6] + "|" + board[3][7] + "|" + board[3][8] + "|" + board[3][9] + "|\n" + "|" + board[4][2] + "|" + board[4][3] + "|" + board[4][4] + "|" + board[4][5] + "|" + board[4][6] + "|" + board[4][7] + "|" + board[4][8] + "|" + board[4][9] + "|\n" + "|" + board[5][2] + "|" + board[5][3] + "|" + board[5][4] + "|" + board[5][5] + "|" + board[5][6] + "|" + board[5][7] + "|" + board[5][8] + "|" + board[5][9] + "|\n" + "|" + board[6][2] + "|" + board[6][3] + "|" + board[6][4] + "|" + board[6][5] + "|" + board[6][6] + "|" + board[6][7] + "|" + board[6][8] + "|" + board[6][9] + "|\n" + "|" + board[7][2] + "|" + board[7][3] + "|" + board[7][4] + "|" + board[7][5] + "|" + board[7][6] + "|" + board[7][7] + "|" + board[7][8] + "|" + board[7][9] + "|\n" + "|" + board[8][2] + "|" + board[8][3] + "|" + board[8][4] + "|" + board[8][5] + "|" + board[8][6] + "|" + board[8][7] + "|" + board[8][8] + "|" + board[8][9] + "|\n" + "|" + board[9][2] + "|" + board[9][3] + "|" + board[9][4] + "|" + board[9][5] + "|" + board[9][6] + "|" + board[9][7] + "|" + board[9][8] + "|" + board[9][9] + "|\n\n";
				
					export = export + exporttemp;
					
				}
				else{
					//
					if(gameover==true){
						notification.setText("Game is already over.\n\nClick 'New Game'\nto play again.");
						selectedpiece.setText("");
						destinationofpiece.setText("");
					}
					else if(validinput==false){
						notification.setText("Invalid Input.\nTry Again.");
						selectedpiece.setText("");
						destinationofpiece.setText("");
					}
					else{
						selectedpiece.setText("");
						destinationofpiece.setText("");
					}
				}
				//
			}
		});
	}
}
