
public enum GamePiece {

	BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5), 
	BLUE_RACER(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2), 
	GRREN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 8), 
	MAGENTA_RACER(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 1), 
	RED_RACER(new GamePieceAppearance(Color.RED, Shape.RACECAR), 0), 
	RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 10), 
	YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7),;
	
	private GamePieceAppearance appearance;
	private int priority;
	
	GamePiece(GamePieceAppearance appearance, int priority)
	{
		this.appearance = appearance;
		this.priority = priority;
	}
	
	public Color getColor()
	{
		return appearance.getColor();
	}
	
	public Shape getShape()
	{
		return appearance.getShape();
	}
	
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
	
	
}
