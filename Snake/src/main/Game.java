package main;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game implements ActionListener {
	private String field;
	private Tail head, fruit;
	private int xSpeed, ySpeed;
	private static boolean game;
	private JFrame frame;
	private JPanel panel;
	private JButton button1, button2, button3, button4;
	private GridBagConstraints gridBag;
	
	public Game() {
		field = "....................\n....................\n....................\n....................\n....................\n....................\n....................\n....................\n....................\n....................";
		game = true;
		xSpeed = 0;
		ySpeed = 1;
		
		//Making Controller
		frame = new JFrame();
		panel = new JPanel(new GridBagLayout());
		gridBag = new GridBagConstraints();
		button1 = new JButton("^\n");
		button2 = new JButton("<");
		button3 = new JButton(">");
		button4 = new JButton("v");
		
			//add Buttons
		gridBag.gridx = 1;
		gridBag.gridy = 0;
		gridBag.fill = GridBagConstraints.VERTICAL;
		panel.add(button1, gridBag);
		gridBag.gridx = 0;
		gridBag.gridy = 1;
		panel.add(button2,gridBag);
		gridBag.gridx = 2;
		panel.add(button3, gridBag);
		gridBag.gridx = 1;
		gridBag.gridy = 2;
		panel.add(button4, gridBag);
		frame.add(panel);
			//config Panel
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setName("Controller");
		frame.pack();
			//add action listeners
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		
		//create head
		head = new Tail(5,0,null,null);
		head.setEnd(head);
		insert(head);
		
		fruit = new Tail((int)Math.random()*20, (int)Math.random()*10, null); 
		
		insert("0",fruit.getX(),fruit.getY());
		// Game Loop
		while(game){
			//draw snake
			insert(".", head.getEnd().getX(), head.getEnd().getY());
			head.setLocation(head.getX() + xSpeed, head.getY() + ySpeed);
			insert(head);
			
			System.out.print("\n\n\n\n");
			System.out.println(field);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
		}
		System.out.println("Game Over!");
	}
	
	private void insert(String str, int x, int y) {
		int location = y*21 + x -1;
		field = field.substring(0,location) + str + field.substring(location+1, field.length()) ;
	}
	private void insert(Tail tail) {
		insert("#", tail.getX(), tail.getY());
	}
	
	public static void setGame(boolean gameInit) {
		game = gameInit;
	}
	
	
	public static void main(String[] args) {
		new Game();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			if (ySpeed == 0)
			{
				ySpeed = -1;
				xSpeed = 0;
			}
			
		}
		else if (e.getSource() == button2) {
			if (xSpeed == 0)
			{
				xSpeed = -1;
				ySpeed = 0;
			}
		}
		else if (e.getSource() == button3) {
			if (xSpeed == 0)
			{
				xSpeed = 1;
				ySpeed = 0;
			}
		}
		else if (e.getSource() == button4) {
			if (ySpeed == 0)
			{
				ySpeed = 1;
				xSpeed = 0;
			}
		}
		
	}

}
