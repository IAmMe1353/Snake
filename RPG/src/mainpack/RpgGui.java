package mainpack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;

public class RpgGui implements ActionListener, KeyListener {
	
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
	private JScrollPane scrollPane;
	private JButton movesButton;
	private JButton bagButton;
	private JButton setButton;
	private int onLine;
	private int turn;
	private ArrayList<Enemy> hand;

	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy monster1;
	
	
	public RpgGui(){
		
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
		scrollPane = new JScrollPane(menuText);
		hand = new ArrayList<Enemy>();
		onLine = 0;
		turn = 0;
		
		// config topText gridbagconstraints
		textBag.fill = GridBagConstraints.HORIZONTAL;
		textBag.gridy = 0;
		textBag.gridwidth = 3;
		topText.setHorizontalAlignment(JTextField.CENTER);
		topText.setEditable(false);

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
		menuBag.fill = GridBagConstraints.BOTH;
		
		// config buttons
		movesButton.addActionListener(this);
		bagButton.addActionListener(this);
		setButton.addActionListener(this);
		movesButton.addKeyListener(this);
        movesButton.setFocusable(true);
		bagButton.addKeyListener(this);
        bagButton.setFocusable(true);
		setButton.addKeyListener(this);
        setButton.setFocusable(true);
		
		// config menu
		menuSubBag.gridx = 0;
		menuSubBag.gridy = 0;
		menu.add(movesButton,menuSubBag);
		menuText.setEditable(false);
		menuSubBag.gridx = 1;
		menu.add(bagButton,menuSubBag);
		menuSubBag.gridx = 2;
		menu.add(setButton,menuSubBag);
		menuSubBag.gridx = 0;
		menuSubBag.gridy = 1;
		menuSubBag.gridwidth = 3;
		menuSubBag.gridheight = 4;
		menuSubBag.ipady = 36;
		menuSubBag.fill = GridBagConstraints.BOTH;
		menu.add(scrollPane,menuSubBag);
		
		
		// config field1
		enemy1 = new Enemy("test", 10, 10, 10, 10, 0);
		field.add(enemy1.getPanel(),enemy1.getBag(0));
		enemy2 = new Enemy("test 2", 10, 10, 10, 10, 0);
		field.add(enemy2.getPanel(),enemy2.getBag(1));
		
		// config field2
		Enemy.numEnemies = 0;
		monster1 = new Enemy("Ice",10,10,10,10, 1);
		field2.add(monster1.getPanel(),monster1.getBag(0));
		hand.add(monster1);
		
		menuText.setText(monster1.getMovesString());
		
		
		// config panel
		panel.setBorder(BorderFactory.createEmptyBorder());
		panel.add(topText,textBag);
		panel.add(field,fieldBag);
		panel.add(field2,fieldBag2);
		panel.add(menu,menuBag);
		
		
		// config frame
		frame.add(panel);
		frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("RPG");
		frame.pack();
		frame.setVisible(true);
		
		highLightText(0);


	}
	private void highLightText(int distance)
	{
		DefaultHighlightPainter painter = new DefaultHighlightPainter(Color.yellow);
		int startIndex;
		int endIndex;
		onLine += distance;
		if (onLine == -1)
			onLine = hand.get(turn).moveSet.size() -1;
		else if (onLine == hand.get(turn).moveSet.size())
			onLine = 0;
			
		// erase
		menuText.getHighlighter().removeAllHighlights();
		// highlight
		try {
			startIndex = menuText.getLineStartOffset(onLine);
			endIndex = menuText.getLineEndOffset(onLine);
			menuText.getHighlighter().addHighlight(startIndex, endIndex, painter);
		}
		catch (BadLocationException e){
			System.out.println("Something broke");
			System.out.println(onLine);
			onLine -= 1;
		}
		
	}
	
	public static void main(String[] args) {
		new RpgGui();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == movesButton)
		{
			 menuText.setText(hand.get(turn).getMovesString());
			 highLightText(0);
		}
		if (e.getSource() == bagButton)
		{
			menuText.setText("goodbye\nhello");
		}
		if (e.getSource() == setButton)
		{
			menuText.setText("ahhhh\nahhh");
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			highLightText(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP){
			highLightText(-1);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

}
