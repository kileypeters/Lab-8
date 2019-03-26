/**
 * Class representing the game pieces.
 * 
 * @author Kiley
 *
 */
public enum GamePiece {

	BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5), 
	BLUE_RACER(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2), 
	GREEN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 8), 
	MAGENTA_RACER(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 1), 
	RED_RACER(new GamePieceAppearance(Color.RED, Shape.RACECAR), 0), 
	RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 10), 
	YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7),;
	
	private GamePieceAppearance appearance;
	private int priority;
	
	/**
	 * Game piece constructor.
	 * 
	 * @param appearance The GamePieceAppearance.
	 * @param priority Priority of the GamePiece.
	 */
	GamePiece(GamePieceAppearance appearance, int priority)
	{
		this.appearance = appearance;
		this.priority = priority;
	}
	
	/**
	 * Gets the color of the game piece.
	 * 
	 * @return The game piece's color.
	 */
	public Color getColor()
	{
		return appearance.getColor();
	}
	
	/**
	 * Gets the shape of the game piece.
	 * 
	 * @return The game piece's shape.
	 */
	public Shape getShape()
	{
		return appearance.getShape();
	}
	
	/**
	 * Given two game pieces, determines which one takes its turn first.
	 * 
	 * @param a The first game piece.
	 * @param b The second game piece.
	 * @return The game piece with the lowest priority value. That is, the game piece that would take its turn first.
	 */
	public static GamePiece movesFirst(GamePiece a, GamePiece b)
	{
		if (a.priority > b.priority)
		{
			return b;
		}
		
		else
		{
			return a;
		}
	}
	
	/**
	 * @ return A string of the format "%s: a %s %s with priority %d", with replacements in order: 
	 * (1) The name of the enum constant (e.g. BLUE_RACER) 
	 * (2) The name of the game piece's color 
	 * (3) The name of the game piece's shape 
	 * (4) The priority value of the
	 */
	public String toString()
	{
		return String.format("%s: a %s %s with priority %d", name(), getColor(), getShape().name(), this.priority);
		
	}
	
}
