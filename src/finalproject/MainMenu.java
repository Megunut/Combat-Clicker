/*
 * Class MainMenu
 * Creates a program window that allows the user to start the game or close the program
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener{
	ImageIcon icon;
	JPanel north;
	JPanel south;
	JPanel center;
	JPanel east;
	JPanel west;
	
	//sets up main menu program window
	public MainMenu(){
		this.setTitle("That Clicker Game...");							
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,750);											
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);		
		this.setResizable(true);
		this.setLayout(new BorderLayout(0,0));
		
		icon = new ImageIcon("dagger.png");	
		this.setIconImage(icon.getImage());							
		
		JPanel menu = new JPanel();	
		this.add(menu);
	}
	
	//creates Main Menu which includes two buttons
	public void createMainMenu() {
		this.initializePanels();
		this.addGameTitle();
		//changed layout setting for center panel
		center.setLayout(new GridLayout(2,1,0,100));
		
		JButton playButton = new JButton("PLAY");
		JButton quitButton = new JButton("QUIT");
		
		playButton.setFont(new Font("Arial",Font.BOLD,25));
		quitButton.setFont(new Font("Arial",Font.BOLD,25));
		
		playButton.setFocusable(false);	
		quitButton.setFocusable(false);
		
		//sets which command it will run when clicked
		playButton.setActionCommand("play");
		quitButton.setActionCommand("quit");
		
		playButton.addActionListener(this);
		quitButton.addActionListener(this);
		
		center.add(playButton);
		center.add(quitButton);
		
		//refreshes window
		this.validate();	
	}
	
	//sets up JPanels
	public void initializePanels() {
		north 	= new JPanel();
		south 	= new JPanel();
		center 	= new JPanel();
		east 	= new JPanel();
		west 	= new JPanel();
		
		north.setBackground(new Color(0xfbf49b));
		south.setBackground(new Color(0xfbf49b));
		center.setBackground(new Color(0xfbf49b));
		east.setBackground(new Color(0xfbf49b));
		west.setBackground(new Color(0xfbf49b));
		
		north.setPreferredSize(new Dimension(100,300));
		south.setPreferredSize(new Dimension(100,170));
		center.setPreferredSize(new Dimension(100,100));
		east.setPreferredSize(new Dimension(500,100));
		west.setPreferredSize(new Dimension(500,100));
		
		this.add(north,BorderLayout.NORTH);
		this.add(south,BorderLayout.SOUTH);
		this.add(center,BorderLayout.CENTER);
		this.add(east,BorderLayout.EAST);
		this.add(west,BorderLayout.WEST);
		
		this.validate();	
	}
	
	public void addGameTitle() {
		JLabel gameTitle = new JLabel();
		ImageIcon gameTitleLogo = new ImageIcon("Images/Game_Title.png");	
		gameTitle.setIcon(gameTitleLogo);
		north.add(gameTitle);
	}

	//tells the buttons what to do when clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		//starts the game
		if ("play".equals(e.getActionCommand())) {
			this.dispose();
			GameFrame gameFrame = new GameFrame();
			gameFrame.createGame();
		//closes the program
		}else if ("quit".equals(e.getActionCommand())){
			System.exit(0);
		}
	}
}
