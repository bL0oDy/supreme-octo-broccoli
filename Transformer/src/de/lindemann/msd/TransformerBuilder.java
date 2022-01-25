package de.lindemann.msd;

public class TransformerBuilder {
	
	public static void main(String[] args)
	{
		Transformer transformer = new Transformer();
		transformer.SetHead(new Weapon("Swoooosh!"))
				   .SetLeftArm(new Weapon("Howoooaaa!"))
				   .SetRightArm(new Weapon("Woooooosh!"))
				   .SetTorso(new Weapon("Kaboooom!"))
				   .SetLeftLeg(new Weapon("Baaaam!"))
				   .SetRightLeg(new Weapon("Ratazong!"));
		transformer.ReleaseTheBeast();
	}
}
