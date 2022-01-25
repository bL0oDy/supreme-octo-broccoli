package de.lindemann.msd;

public class Transformer {
	private Weapon _rightArm;
	private Weapon _leftArm;
	private Weapon _head;
	private Weapon _rightLeg;
	private Weapon _leftLeg;
	private Weapon _torso;
	
	public Transformer SetRightArm(Weapon value)
	{
		_rightArm = value;
		return this;
	}
	
	public Transformer SetLeftArm(Weapon value)
	{
		_leftArm = value;
		return this;
	}
	
	public Transformer SetHead(Weapon value)
	{
		_head = value;
		return this;	
	}
	
	public Transformer SetRightLeg(Weapon value)
	{
		_rightLeg = value;
		return this;
	}
	
	public Transformer SetLeftLeg(Weapon value)
	{
		_leftLeg = value;
		return this;
	}
	
	public Transformer SetTorso(Weapon value)
	{
		_torso = value;
		return this;
	}
	
	public void ReleaseTheBeast()
	{
		System.out.println("OH MY GOD!");
		System.out.println("People in the city are screeming! Panic, all over the place!");
		System.out.println("A huge Transfomer appears. It is equipped with a lot of deadly weapons...");
		System.out.println("Suddenly, it start to fire right arm weapon: " + _rightArm.Fire());
		System.out.println("Left: " + _leftArm.Fire());
		System.out.println("Right: " + _rightArm.Fire());
		System.out.println("Left: " + _leftArm.Fire());
		System.out.println("Literally out of nowhere, the the gray building is gone.");
		System.out.println("As it walks by the central park, a comes flash out of the eyes of the monster: " + _head.Fire());
		System.out.println("A man is sitting in a cafe. Focussed on his work, he did not realise the situation.");
		System.out.println("Slowly he looks up and cannot believe what he sees. Simultanously, the monster shoots from both his legs: " + _leftLeg.Fire() + " and " + _rightLeg.Fire());
		System.out.println("...");
		System.out.println("Silence...");
		System.out.println("...");
		System.out.println("As the dust falls. The beast was hit by fighter yet. On its knees, with the power of will, all its torso starts to glow: " + _torso.Fire());
		System.out.println("... and the beast is gone.");
	}
}

