package mainpack;

import java.util.ArrayList;
import java.util.List;

public class Moves {

	private String name;
	private int damage;
	private boolean scaled;
	private int debuff;
	private int debuffInt;
	private int cost;

	private Moves(String name, int debuff, int debuffInt, int damage, boolean scaled, int cost)
	{
		this.name = name;
		this.damage = damage;
		this.scaled = scaled;
		this.debuff = debuff;
		this.debuffInt = debuffInt;
		this.cost = cost;
	}
	public static List<Moves> getBasicMoves()
	{
		List<Moves> arr = new ArrayList<Moves>();
		arr.add(new Moves("Double Punch", 30, 2, 2, true, 0));
		arr.add(new Moves("flick", 0, 0, 1, true, 0));
		return arr;
	}
	public static List<Moves> getIceMoves()
	{
		List<Moves> arr = new ArrayList<Moves>();
		arr.addAll(getBasicMoves());
		arr.add(new Moves("freeze", 2, 4, 4, false, 2));
		arr.add(new Moves("Frostbite", 1, 1, 3, false, 4));
		arr.add(new Moves("Ice Shield", 30, -2, 0, false, 3));
		return arr;
	}
	//TODO add fire moves, rock moves
	public String toString()
	{
		return "" + cost + "\t" + name;
		//TODO write toString
	}
}
