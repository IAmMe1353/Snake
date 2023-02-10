package mainpack;

import java.awt.*;

import javax.swing.*;

public class RpgGui {
	
	// Declare variables
	private JFrame frame;
	private JPanel panel;
	private JPanel field;
	private JTextField topText;
	private GridBagConstraints textBag;
	private GridBagConstraints fieldBag;
	private GridBagConstraints enemyBag;
	private Enemy enemy1;
	
	
	public RpgGui() {
		
		// constructing variables
		frame = new JFrame();
		panel = new JPanel(new GridBagLayout());
		
		topText = new JTextField("Lorem Ipsum");
		
		field = new JPanel(new GridBagLayout());
		
		textBag = new GridBagConstraints();
		fieldBag = new GridBagConstraints();
		enemyBag = new GridBagConstraints();
		 
		
		// config topText gridbagconstraints
		// fills horizontal axis when needed
		textBag.fill = GridBagConstraints.HORIZONTAL;
		// position x = 0
		textBag.gridy = 0;
		
		// config enemy1
		enemy1 = new Enemy("test",10,10,10,10);
		
		
		field.add(enemy1.getPanel(),enemy1.getBag());
		// setting position of field
		fieldBag.gridy = 1;
		
		textBag.gridy = 0;
		// setting panel border
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		// adding components
		panel.add(topText,textBag);
		panel.add(field,fieldBag);
		
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
