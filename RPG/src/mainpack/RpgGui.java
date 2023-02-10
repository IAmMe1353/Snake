package mainpack;

import java.awt.*;

import javax.swing.*;

public class RpgGui {
	
	// Declare variables
	private JFrame frame;
	private JPanel panel;
	private JPanel field;
	private JTextField topText;
	private JTextField enemy1Name;
	private GridBagConstraints textBag;
	private GridBagConstraints fieldBag;
	
	
	public RpgGui() {
		
		//test
		
		// constructing variables
		frame = new JFrame();
		panel = new JPanel(new GridBagLayout());
		field = new JPanel(new GridBagLayout());
		topText = new JTextField("Lorem Ipsum");
		enemy1Name = new JTextField("test");
		textBag = new GridBagConstraints();
		fieldBag = new GridBagConstraints();
		
		
		// config topText gridbagconstraints
		// fills horizontal axis when needed
		textBag.fill = GridBagConstraints.HORIZONTAL;
		// position x = 0
		textBag.gridy = 0;
		
		enemy1Name.setEditable(false);
		fieldBag.gridy = 1;
		field.add(enemy1Name,textBag);
		
		
		// setting panel border
		panel.setBorder(BorderFactory.createEmptyBorder());
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
