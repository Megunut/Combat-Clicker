/*
 * Class GameFrame
 * Creates a window that contains all game components
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements KeyListener{
	ImageIcon icon;
	JPanel north;
	JPanel south;
	JPanel center;
	JPanel east;
	JPanel west;

	//sets up game program window
	public GameFrame(){
		this.setTitle("That Clicker Game...");							
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,750);											
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);		
		this.setResizable(true);
		this.addKeyListener(this);
		this.setLayout(new BorderLayout(0,0));
		
		icon = new ImageIcon("dagger.png");	
		this.setIconImage(icon.getImage());							
	}
	
	public void createGame() {
		this.initializePanels();
		//changed layout setting for panels
		center.setLayout(new GridLayout());
		north.setLayout(new GridLayout());
		south.setLayout(new GridLayout());
		
		//North JPanels
		JPanel scoreCounter = new JPanel();
		JPanel title = new JPanel();
		JPanel winCondition = new JPanel();
		//South JPanels
		JPanel resourceBars = new JPanel();
		JPanel weapons = new JPanel();
		JPanel block = new JPanel();
		
		//sets the location of JPanels to be at the top of the window
		ScoreCounter.setPanel(scoreCounter);
		WinCondition.setPanel(winCondition);
		
		//sets the location of JPanel to be at the center of the window
		Enemy.setPanel(center);
		
		//sets the location of JPanels to be at the bottom of the window
		ResourceBar.setPanel(resourceBars);
		Weapon.setPanel(weapons);
		Block.setPanel(block);
		
		scoreCounter.setBackground(new Color(0xfbf49b));
		title.setBackground(new Color(0xfbf49b));
		winCondition.setBackground(new Color(0xfbf49b));
		
		resourceBars.setBackground(new Color(0xfbf49b));
		weapons.setBackground(new Color(0xfbf49b));
		block.setBackground(new Color(0xfbf49b));
		
		weapons.setLayout(new GridLayout(1,3,10,10));
		resourceBars.setLayout(new GridLayout(2,1,0,10));
		
		//places JPanels at the top of the window
		north.add(scoreCounter);
		north.add(title);
		north.add(winCondition);
		//places JPanels at the bottom of the window
		south.add(resourceBars);
		south.add(weapons);
		south.add(block);
		
		EnemySpawner enemySpawner = new EnemySpawner();
		WeaponManager wpnFactory = new WeaponManager();
		ResourceBar rscBar = new ResourceBar();
		Block blocker = new Block();
		
		rscBar.addResourceBars();
		//starts threads that will allow HP/SP to regen throughout the game
		HP.regenHP();
		SP.regenSP();
			
		blocker.addBlockPanel();
		
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
		
		north.setPreferredSize(new Dimension(100,100));
		south.setPreferredSize(new Dimension(100,170));
		center.setPreferredSize(new Dimension(100,100));
		east.setPreferredSize(new Dimension(100,100));
		west.setPreferredSize(new Dimension(100,100));
		
		this.add(north,BorderLayout.NORTH);
		this.add(south,BorderLayout.SOUTH);
		this.add(center,BorderLayout.CENTER);
		this.add(east,BorderLayout.EAST);
		this.add(west,BorderLayout.WEST);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//closes the program when esc key is pressed
		if (e.getKeyCode() == 27) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	

}
