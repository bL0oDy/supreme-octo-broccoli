package de.lindemann.msd;

public class Weapon {
	private String _fireSound;
	
	public Weapon(String fireSound) 
	{
		_fireSound = fireSound;
	}
	
	public String Fire()
	{
		return _fireSound;
	}
}

