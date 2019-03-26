/**
 * Class representing colors of game pieces.
 * 
 * @author Kiley
 *
 */
public enum Color {
	
	BLUE(0, 0, 255), CYAN(0, 255, 255), GREEN(0, 255, 0), MAGENTA(255, 0, 255), RED(255, 0, 0), YELLOW(255, 255, 0),;
	
	private int r;
	private int g;
	private int b;
	
	/**
	 * Color constructor.
	 * 
	 * @param r Red value.
	 * @param g Green value.
	 * @param b Blue value.
	 */
	Color(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		
	}
	
	/**
	 * 
	 * @return The color's red component.
	 */
	public int getR() {
		return this.r;
	}

	/**
	 * 
	 * @return The color's green component.
	 */
	public int getG() {
		return this.g;
	}

	/**
	 * 
	 * @return The color's blue component.
	 */
	public int getB() {
		return this.b;
	}
	
	
	
	

}
