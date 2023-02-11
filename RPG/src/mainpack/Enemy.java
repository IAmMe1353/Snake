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
	private JTextField healthBox;
	private JTextField nameBox;
	private JTextField attackBox;
	private JPanel panel;
	private static int numEnemies = 0;
	
	public Enemy(String name, int health, int speed, int attack, int defense)
	{

		this.name = name;
		hp = health;
		spd = speed;
		at = attack;
		df = defense;
		numEnemies += 1;
		System.out.println(numEnemies);
		setPanel();
	}
	
	private void setPanel() {
		panel = new JPanel(new GridBagLayout());
		nameBox = new JTextField(name);
		nameBox.setEditable(false);
		nameBox.setHorizontalAlignment(JTextField.CENTER);
		healthBox = new JTextField(" hp: " + hp);
		healthBox.setEditable(false);
		healthBox.setHorizontalAlignment(JTextField.CENTER);
		attackBox = new JTextField(" at: " + at);
		attackBox.setEditable(false);
		attackBox.setHorizontalAlignment(JTextField.CENTER);
		GridBagConstraints gridBag = new GridBagConstraints();
		
		gridBag.fill = GridBagConstraints.HORIZONTAL;
		gridBag.gridy = 0;
		gridBag.gridwidth = 2;
		panel.add(nameBox,gridBag);
		gridBag.gridwidth = 1;
		gridBag.gridy = 2;
		gridBag.gridx = 0;
		panel.add(healthBox,gridBag);
		gridBag.gridx = 1;
		panel.add(attackBox,gridBag);
	}
	
	public JPanel getPanel()
	{
		return panel;
	}
	public GridBagConstraints getBag(int x) {
		GridBagConstraints product = new GridBagConstraints();
		product.gridx = x;
		return product;
	}
	public void doDamage(int damage)
	{
		if ((hp - damage) <= 0)
			hp = 0;
		else
			hp -= damage;
		healthBox.setText(" hp: " + hp);
	}
}
