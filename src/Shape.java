/**
 * Class representing the shapes of game pieces.
 * 
 * @author Kiley
 *
 */
public enum Shape {
	BOOT, RACECAR, THIMBLE,;
	
	/**
	 * Gives the name of the value of the enum object, in lowercase.
	 * 
	 * @return The enum object's name (either thimble, boot, racecar) in lowercase.(Look at the documentation for java enums to figure out how to get the enum value's name).
	 */
	public String toString()
	{
		return name().toLowerCase();
	}

}
