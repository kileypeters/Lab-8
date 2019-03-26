import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
/**
 * Class representing the board game.
 * 
 * @author Kiley
 *
 */
public class BoardGame {
	
	protected LinkedHashMap<String, Location> playerLocations = new LinkedHashMap<String, Location>();
	protected LinkedHashMap<String, GamePiece> playerPieces = new LinkedHashMap<String, GamePiece>();
	
	// ***Default Constructor

	/**
	 * Adds a player to the board game object. Players are uniquely associated with a game piece. 
	 * These game piecesrepresent the player in the board game. 
	 * Each player has only one game piece, and each game piece can beassociated with only one player. 
	 * As such, when adding a player, a check must be done to ensure that a playeris not already associated with the game piece. 
	 * Players are represented by their names.Players/GamePieces are given a location in the board game (a location inside a mansion). 
	 * MultiplePlayers/GamePieces may be in the same location. Remember that a player is uniquely associated with a singlegame piece, 
	 * so a "player at a location" is essentially the same as a "game piece at a location".
	 * 
	 * @param playerName The name of the player to be added. Players are referenced only by their names.
	 * @param gamePiece The game piece to be associated with the player being added.
	 * @param initialLocation The initial location of the game piece in the board game.
	 * @return false if there already is a player associated with the game piece.
	 */
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation)
	{
		if (!playerPieces.containsKey(playerName) && !playerPieces.containsValue(gamePiece))
		{
			playerLocations.put(playerName, initialLocation);
			playerPieces.put(playerName, gamePiece);
		
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	/**
	 * Given a player's name, find the game piece associated with that player. 
	 * Remember that game pieces are unique,and are assigned to a unique player (i.e. it is a one-to-one relationship).
	 * 
	 * @param playerName The player name for which we want to find an associated game piece.
	 * @return The game piece associated with the player.
	 */
	public GamePiece getPlayerGamePiece(String playerName)
	{
		return playerPieces.get(playerName);
	}
	
	/**
	 * Given a game piece, find the player associated with that game piece. 
	 * Remember that game pieces are unique,and are assigned to a unique player (i.e. it is a one-to-one relationship).
	 * 
	 * @param gamePiece The game piece for which we want to find an associated player.
	 * @return If a player is correlated with the game piece, return that player name.Else, return null.
	 */
	public String getPlayerWithGamePiece(GamePiece gamePiece)
	{
		String player = "";
			for (String pc : playerPieces.keySet()) {
		        if (playerPieces.get(pc) == gamePiece)
		        {
		        	player = pc;
		        	
		        }
		        }
			return player;
	}
	
	/**
	 * Moves a player to a new location in the board game. Remember that a player is uniquely associated 
	 * with a singlegame piece, so "moving the player" is essentially equivalent to "moving the player's game piece".
	 * 
	 * @param playerName The player to be moved.
	 * @param newLocation The new location for the player.
	 */
	public void movePlayer(String playerName, Location newLocation)
	{
		playerLocations.put(playerName, newLocation);
	}
	
	/**
	 * Method to use when two players each want to move at the same time. Movements must be taken individually, 
	 * sothe system must determine which player moves first. Each player is associated with a game piece, 
	 * and gamepieces determine who moves first by the movesFirst() method. That is, the player that move first is the player
	 * with the game piece that has the first priority.You may assume that the arrays are always the appropriate length. 
	 * Index i in the player array is associatedwith index i in the locations array. That is, the player at players[i] wishes to move to the location 
	 * atnewLocations[i].You should leverage the code in the movePlayer() method.
	 * 
	 * @param playerNames The two players to be moved.
	 * @param newLocations The two locations to move the players to.
	 * @return The players, sorted in the order in which the two players move (the first player to move is atindex 0 of the returned array).
	 */
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations)
	{
		String[] playerList = new String[2];
		String playerOne = playerNames[0];
		String playerTwo = playerNames[1];
		
		Location locationOne = newLocations[0];
		Location locationTwo = newLocations[1];
		
		GamePiece x = GamePiece.movesFirst(getPlayerGamePiece(playerOne), getPlayerGamePiece(playerTwo));
		if(x == getPlayerGamePiece(playerOne))
		{
			//getPlayerWithGamePiece(x);
			movePlayer(playerOne, locationOne);
			movePlayer(playerTwo, locationTwo);
			playerList[0] = playerOne;
			playerList[1] = playerTwo;
		}
		else
		{
			movePlayer(playerTwo, locationOne);
			movePlayer(playerOne, locationTwo);
			playerList[0] = playerTwo;
			playerList[1] = playerOne;
		}

		
		return playerList;
	}
	/**
	 * Gets the location of a player. Be careful that you don't confuse this with getPlayerLocations!
	 * 
	 * @param player The player for whom we want to find the location.
	 * @return The location of the player.
	 */
	public Location getPlayersLocation(String player)
	{
		return playerLocations.get(player);
	}
	
	/**
	 * Given a location, find all players at that location.
	 * 
	 * @param loc The location at which we want to find players.
	 * @return The players at the given location.
	 */
	public ArrayList<String> getPlayersAtLocation(Location loc)
	{
		ArrayList<String> thePlayers = new ArrayList<String>();
		
		for (String lc : playerLocations.keySet()) {
	        if (playerLocations.get(lc) == loc)
	        {
	        	thePlayers.add(lc);
	        }
	        }
		
		return thePlayers;
	}
	
	/**
	 * Given a location, find the game pieces associated with all the players at that location.
	 * 
	 * @param loc The location at which we want to find game pieces.
	 * @return The game pieces for which an associated player is at the given location.
	 */
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc)
	{
		//call getPlayersAtLocation
		ArrayList<String> thePlayers = getPlayersAtLocation(loc);
		//create the arraylist of gamepieces
		ArrayList<GamePiece> myPcs = new ArrayList<GamePiece>();
		
		for (int index = 0; index < thePlayers.size(); ++index)
		{
			GamePiece thePc = getPlayerGamePiece(thePlayers.get(index));
			myPcs.add(thePc);
		}
		
		return myPcs;
	
	}
	
	/**
	 * Gets all players recorded in the game.
	 * 
	 * @return The list of players in the board game.
	 */
	public Set<String> getPlayers()
	{
		return playerPieces.keySet();
	}
	
	/**
	 * Gets all locations that the players are at (not all possible locations).Be careful that you don't confuse this with getPlayersLocation!
	 * 
	 * @return The set of locations (i.e. no duplicate elements) at which at least one player is present.Hint: look at the javadocs for the HashSet.
	 */
	public Set<Location> getPlayerLocations()
	{
		Set<Location> theLocations = new HashSet<Location>(playerLocations.values());

		return theLocations;
	}
	
	/**
	 * Gets all game pieces associated with the players (not all possible game pieces).
	 * 
	 * @return The set of game pieces (i.e. no duplicate elements) that have been associated with a player.Hint: look at the javadocs for the HashSet.
	 */
	public Set<GamePiece> getPlayerPieces()
	{
		Set<GamePiece> thePcs = new HashSet<GamePiece>(playerPieces.values());
		
		return thePcs;
	}
}
