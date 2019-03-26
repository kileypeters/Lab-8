import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class GameTests {
	@Test
	public void testColorValues() {
		Color col= null ;
		//red
		col = Color.RED;
		Assert.assertEquals( " Incorrect  rgb  value  in  color  " +col.name() ,  255 , col.getR() ) ;
		Assert.assertEquals( " Incorrect  rgb  value  in  color  " +col.name() ,  0 ,col.getG() ) ;
		Assert.assertEquals( " Incorrect  rgb  value  in  color  " +col.name() ,  0 ,col.getB() ) ;
		///blue
		col=Color.GREEN;
		Assert.assertEquals( " Incorrect  rgb  value  in  color  " +col.name() ,  0 ,col.getR() ) ;
		Assert.assertEquals( " Incorrect  rgb  value  in  color  " +col.name() ,  255 ,col.getG() ) ;
		Assert.assertEquals( " Incorrect  rgb  value  in  color  " +col.name() ,  0 ,col.getB() ) ;
	}
	
	@Test
	public  void testLocation() {
		Assert.assertEquals( " Location enum values  i n c o r r e c t . " ,Location.KITCHEN,Location.valueOf( "KITCHEN" ) ) ;
		Assert.assertEquals( " Location enum values  i n c o r r e c t . " ,Location.CONSERVATORY,Location.valueOf( "CONSERVATORY" ) ) ;
		Assert.assertEquals( " Location enum values  i n c o r r e c t . " ,Location.DINING_ROOM,Location.valueOf( "DINING_ROOM" ) ) ;
	}
	
	@Test
	public void testShapeToString() {
		Assert.assertEquals( "Shape  toString  i n c o r r e c t . " ,"thimble" ,Shape.THIMBLE.toString() ) ;
	}
	
	@Test
	public  void testSet() {
		int [ ]dataRaw= new  int [ ]{1 ,  5 ,  7 ,  4 ,  10 ,  7 ,  8 ,  5};
		List<Integer>dataList=Arrays.stream(dataRaw).boxed().collect(Collectors.toList() ) ;
		Set<Integer>dataSet= new HashSet<Integer>(dataList) ;
		int [ ]expected= new  int [ ]{1 ,  5 ,  7 ,  4 ,  10 ,  8};
		for  ( int index= 0;index<expected.length;index++)
		{
			Assert.assertTrue(dataSet.contains(expected[index] ) ) ;
		}
	}
	
	@Test
	public void BoardGameTest()
	{
		BoardGame newGame = new BoardGame();
		
		Location kitchen = Location.KITCHEN;
		Location library = Location.LIBRARY;
		Location lounge = Location.LOUNGE;
		
		GamePiece blueBoot = GamePiece.BLUE_BOOT;
		String blue = "Blue";
		String red = "Red";
		GamePiece redThimble = GamePiece.RED_THIMBLE;
		
		newGame.addPlayer(blue, blueBoot, kitchen);
		newGame.addPlayer(red, redThimble, kitchen);
		
		Assert.assertEquals(GamePiece.BLUE_BOOT, newGame.getPlayerGamePiece(blue));
		
		Assert.assertEquals("Blue" , newGame.getPlayerWithGamePiece(blueBoot));
		
		Assert.assertEquals(Location.KITCHEN, newGame.getPlayersLocation(blue));
		
		String[] players = new String[] {blue,red};
		Location[] locations = new Location[] {library, library};
		
		newGame.moveTwoPlayers(players, locations);
		Assert.assertEquals(Location.LIBRARY, newGame.getPlayersLocation(red));
		
		ArrayList<String> playersAtLocation = newGame.getPlayersAtLocation(library);
		Assert.assertEquals(playersAtLocation, newGame.getPlayersAtLocation(library));
		
		ArrayList<GamePiece> gamePiecesAtLocation = newGame.getGamePiecesAtLocation(library);
		Assert.assertEquals(gamePiecesAtLocation, newGame.getGamePiecesAtLocation(library));
		
		Set<String> gtPlayers = newGame.getPlayers();
		Assert.assertEquals(gtPlayers, newGame.getPlayers());
		
		Set<Location> pLocations = newGame.getPlayerLocations();
		Assert.assertEquals(pLocations, newGame.getPlayerLocations());
		
		Set<GamePiece> playerPieces = newGame.getPlayerPieces();
		Assert.assertEquals(playerPieces, newGame.getPlayerPieces());
		
		//Check that this has already been added.
		newGame.addPlayer(red, redThimble, kitchen);
		Assert.assertFalse(newGame.addPlayer(red, redThimble, kitchen));
		
		//Test different priority order
		String[] players2 = new String[] {red,blue};
		Location[] locations2 = new Location[] {lounge, lounge};
		
		newGame.moveTwoPlayers(players2, locations2);
		Assert.assertEquals(Location.LOUNGE, newGame.getPlayersLocation(red));
		
	}

	@Test
	public void GamePieceTest()
	{
		GamePiece blueBoot = GamePiece.BLUE_BOOT;
		GamePiece redThimble = GamePiece.RED_THIMBLE;
		
		Assert.assertEquals(Color.BLUE, blueBoot.getColor());
		Assert.assertEquals(Shape.THIMBLE, redThimble.getShape());
	}

	@Test
	public void GamePiecetoStringTest()
	{
		GamePiece blueBoot = GamePiece.BLUE_BOOT;
		
		Assert.assertEquals("BLUE_BOOT: a BLUE BOOT with priority 5", blueBoot.toString());
	}
}
