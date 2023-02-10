package mainpack;

import java.awt.*;

import javax.swing.*;

public class Enemy {
	
	private String name;
	private int hp;
	private int spd;
	private int at;
	private int df;
	private GridBagConstraints gridBag;
	private static int numEnemies = 0;
	
	public Enemy(String name, int health, int speed, int attack, int defense)
	{
		this.name = name;
		hp = health;
		spd = speed;
		at = attack;
		df = defense;
		numEnemies += 1;
	}
	
	public JPanel getPanel() {
		JPanel product = new JPanel(new GridBagLayout());
		JTextField nameBox = new JTextField(name);
		JTextField healthBox = new JTextField("hp" + hp);
		JTextField attackBox = new JTextField("at" + at);
		GridBagConstraints gridBag = new GridBagConstraints();
		
		gridBag.fill = GridBagConstraints.HORIZONTAL;
		gridBag.gridy = 0;
		gridBag.gridwidth = 2;
		product.add(nameBox,gridBag);
		gridBag.gridwidth = 1;
		gridBag.gridy = 2;
		gridBag.gridx = 0;
		product.add(healthBox,gridBag);
		gridBag.gridx = 1;
		product.add(attackBox,gridBag);
		
		return product;
	}
	public GridBagConstraints getBag() {
		GridBagConstraints product = new GridBagConstraints();
		product.gridx = numEnemies - 1;
		return product;
	}
}
