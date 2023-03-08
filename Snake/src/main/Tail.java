package main;


public class Tail {
	private Tail parent;
	private Tail end;
	private int x;
	private int y;
	

	public Tail(int x, int y, Tail parent, Tail end) {
		this.parent = parent;
		this.x = x;
		this.y = y;
		this.end = end;
	}
	public Tail(int x, int y, Tail parent) {
		this(x,y,parent,null);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Tail getEnd() {
		return end;
	}
	public void setLocation(int x, int y) {
		if (x >= 20 || x <= 0) {
			Game.setGame(false);
		}	
		else
			this.x = x;
		if (y >= 10 || y <= 0) {
			Game.setGame(false);
		}
		else
			this.y = y;
		
	}
	public void setEnd(Tail end) {
		this.end = end;
	}
}
