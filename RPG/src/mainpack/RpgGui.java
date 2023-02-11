package mainpack;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class RpgGui {
	
	// Declare variables
	private JFrame frame;
	private JPanel panel;
	private JPanel field;
	private JPanel field2;
	private JPanel menu;
	private GridBagConstraints textBag;
	private GridBagConstraints fieldBag;
	private GridBagConstraints fieldBag2;
	private GridBagConstraints menuBag;
	private GridBagConstraints menuSubBag;
	private JTextField topText;
	private JTextArea menuText;
	private JButton movesButton;
	private JButton bagButton;
	private JButton setButton;

	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy monster1;
	
	
	public RpgGui() {
		
		// constructing variables
		frame = new JFrame();
		panel = new JPanel(new GridBagLayout());
		menu = new JPanel(new GridBagLayout());
		field = new JPanel(new GridBagLayout());
		field2 = new JPanel(new GridBagLayout());
		topText = new JTextField("Lorem Ipsum");
		menuText = new JTextArea();
		menuBag = new GridBagConstraints();
		textBag = new GridBagConstraints();
		fieldBag = new GridBagConstraints();
		fieldBag2 = new GridBagConstraints();
		menuSubBag = new GridBagConstraints();
		movesButton = new JButton("Moves");
		bagButton = new JButton("Bag");
		setButton = new JButton("settings");
		
		// config topText gridbagconstraints
		textBag.fill = GridBagConstraints.HORIZONTAL;
		textBag.gridy = 0;
		textBag.gridwidth = 3;
		topText.setHorizontalAlignment(JTextField.CENTER);

		// config fieldBag gridbagconstraints
		fieldBag.gridy = 1;
		fieldBag.gridheight = 2;
		
		// config fieldBag2 gridbagconstraints
		fieldBag2.gridy = 3;
		fieldBag2.gridheight = 2;
		
		// config menuBag gridbagconstraints
		menuBag.gridx = 1;
		menuBag.gridheight = 4;
		menuBag.gridy = 1;
		menuBag.weighty = 1;
		menuBag.fill = GridBagConstraints.BOTH;
		
		// config menu
		menuSubBag.gridx = 0;
		menuSubBag.gridy = 0;
		menu.add(movesButton,menuSubBag);
		menuSubBag.gridx = 1;
		menu.add(bagButton,menuSubBag);
		menuSubBag.gridx = 2;
		menu.add(setButton,menuSubBag);
		menuSubBag.gridx = 0;
		menuSubBag.gridy = 1;
		menuSubBag.gridwidth = 3;
		menuSubBag.ipady = 40;
		menuSubBag.fill = GridBagConstraints.BOTH;
		menu.add(menuText,menuSubBag);
		
		
		// config enemies
		enemy1 = new Enemy("test", 10, 10, 10, 10);
		field.add(enemy1.getPanel(),enemy1.getBag(0));
		enemy2 = new Enemy("test 2", 10, 10, 10, 10);
		field.add(enemy2.getPanel(),enemy2.getBag(1));
		
		// config field2
		monster1 = new Enemy("mine",10,10,10,10);
		field2.add(monster1.getPanel(),monster1.getBag(0));
		
		
		// config panel
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		panel.add(topText,textBag);
		panel.add(field,fieldBag);
		panel.add(field2,fieldBag2);
		panel.add(menu,menuBag);
		
		// config frame
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("RPG");
		frame.pack();
		frame.setVisible(true);


	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RpgGui();
	}

}
