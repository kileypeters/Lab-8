import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class BoardGame {
	
	protected LinkedHashMap<String, Location> playerLocations;
	protected LinkedHashMap<String, GamePiece> playPieces;
	
	// ***Default Constructor

	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation)
	{
		if (playPieces.containsKey(playerName) != true)
		{
			playerLocations.put(playerName, initialLocation);
			playPieces.put(playerName, gamePiece);
		
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	public GamePiece getPlayerGamePiece(String playerName)
	{
		return playPieces.get(playerName);
	}
	
	public String getPlayerWithGamePiece(GamePiece gamePiece)
	{
		String player = "";
			for (String pc : playPieces.keySet()) {
		        if (playPieces.get(pc) == gamePiece)
		        {
		        	player = pc;
		        	
		        }
		        }
			return player;
	}
	
	public void movePlayer(String playerName, Location newLocation)
	{
		playerLocations.put(playerName, newLocation);
	}
	
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
	
	public Location getPlayersLocation(String player)
	{
		return playerLocations.get(player);
	}
	
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
	
	public Set<String> getPlayers()
	{
		return playPieces.keySet();
	}
	
	public Set<Location> getPlayerLocations()
	{
		Set<Location> theLocations = new HashSet<Location>(playerLocations.values());

		return theLocations;
	}
	
	public Set<GamePiece> getPlayerPiece()
	{
		Set<GamePiece> thePcs = new HashSet<GamePiece>(playPieces.values());
		
		return thePcs;
	}
}
