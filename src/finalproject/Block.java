/*
 * Class Block
 * Responsible for the block mechanic
 * @author Sean Alexander Porras
 */

package finalproject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Block implements MouseListener{
	ImageIcon sprite;
	
	//GUI related variables
	private JPanel blockPanel;
	private JLabel shield;
	static JPanel southRightPanel;
	
	static boolean isBlocking; 
	
	public Block(){
		this.sprite = new ImageIcon("Images/block.png");
	}

	public static void setPanel(JPanel panel) {
		southRightPanel = panel;
	}
	
	public JPanel getPanel(){
		return southRightPanel;
	}
	
	public void addBlockPanel() {
		JPanel panel = getPanel();
		panel.setLayout(new GridLayout());
		
		blockPanel = new JPanel();
		blockPanel.setLayout(new BorderLayout());
		blockPanel.setBackground(new Color(0xf9d691));
		panel.add(blockPanel);
		
		//creates JLabel object which will hold the sprite image 
		shield = new JLabel();
		shield.setIcon(sprite);
		shield.setHorizontalAlignment(JLabel.CENTER);
		shield.addMouseListener(this);
			
		blockPanel.add(shield);
	}

	//user is blocking when mouse cursor hovers over block JPanel
	@Override
	public void mouseEntered(MouseEvent e) {
		this.isBlocking = true;
		HP.hpLocked();
		SP.spLocked();
	}

	//user is no longer blocking when mouse cursor leaves block JPanel
	@Override
	public void mouseExited(MouseEvent e) {
		this.isBlocking = false;
		HP.hpUnlocked();
		SP.spUnlocked();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}


}
