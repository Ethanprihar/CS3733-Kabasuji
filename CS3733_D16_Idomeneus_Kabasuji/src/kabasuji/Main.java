package kabasuji;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import kabasuji.model.*;
import kabasuji.view.SplashWindow;
import kabasuji.view.TopLevelApplication;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		makePieces();
		makeLevelsForTesting();
		Kabasuji kabasuji = new Kabasuji();
		System.out.println("In Kabasuji the levels:");
		for(Level l: kabasuji.getLevels())
		{
			System.out.println(l.isLocked());
		}
		TopLevelApplication frame = new TopLevelApplication(kabasuji);
		// start splash screen
		//new SplashWindow();
		// after splash screen ends, show game
		frame.setVisible(true);
	}
	
	//THIS CODE SEGMENT WILL RESET THE LEVELS FILE AND ADD 15 FRESH LEVELS
	public static void makeLevelsForTesting()
	{
		Builder builder = new Builder();
		builder.setLevels(new ArrayList<Level>());
		for(int i=0; i<15; i++)
		{
			builder.addNewLevel(i%3, 12);
			builder.saveLevel();
			System.out.println(builder.getLevels());
		}
		builder.saveToDisc();
	}
	
	public static void makePieces()
	{
		Piece[] pieces = new Piece[35];
		for(int i=0; i<pieces.length; i++)
		{
			Tile t = new Tile(false, true, 0, 0);
			Tile f = new Tile(false, false, 0, 0);
			Tile[][] tiles = new Tile[6][6];
			switch(i)
			{
				case 0:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, f, f, f, f}};
				case 1:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 2:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, t, f, f},
					 { f, f, f, t, f, f},
					 { f, f, f, t, f, f},
					 { f, f, f, f, f, f}};
				case 3:
					tiles = new Tile[][]
					{{ f, f, f, t, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 4:
					tiles = new Tile[][]
					{{ f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 5:
					tiles = new Tile[][]
					{{ f, f, t, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 6:
					tiles = new Tile[][]
					{{ f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 7:
					tiles = new Tile[][]
					{{ f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f}};
				case 8:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, t, f, f, f, f},
					 { f, t, t, f, f, f},
					 { f, t, t, t, f, f},
					 { f, f, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 9:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, f, t, f, f},
					 { f, t, t, t, f, f},
					 { f, t, t, f, f, f},
					 { f, f, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 10:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 11:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, t, t, t, f, f},
					 { f, t, f, f, f, f},
					 { f, t, f, f, f, f},
					 { f, t, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 12:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, t, f, f, f, f},
					 { f, t, t, t, f, f},
					 { f, t, f, f, f, f},
					 { f, t, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 13:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, t, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 14:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, t, f, f},
					 { f, t, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 15:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, t, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 16:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, t, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 17:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, t, f, f},
					 { f, t, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 18:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, t, f, t, f, f},
					 { f, t, t, t, f, f},
					 { f, t, f, f, f, f},
					 { f, f, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 19:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, t, t, t, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 20:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, t, f, t, f, f},
					 { f, t, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 21:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, f, f, f},
					 { f, t, t, t, f, f},
					 { f, t, t, f, f, f},
					 { f, f, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 22:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, f, f, f},
					 { f, t, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 23:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, f, f, f},
					 { f, t, t, t, f, f},
					 { f, t, f, f, f, f},
					 { f, t, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 24:
					tiles = new Tile[][]
					{{ f, f, f, t, f, f},
					 { f, f, f, t, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 25:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, f, t, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, f, f, f, f}};
				case 26:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, f, t, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 27:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, t, f, f},
					 { f, f, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 28:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, f, t, f, f},
					 { f, t, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 29:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, f, t, f, f},
					 { f, f, t, t, f, f},
					 { f, t, t, f, f, f},
					 { f, f, t, f, f, f},
					 { f, f, f, f, f, f}};
				case 30:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, f, t, f, f},
					 { f, t, t, t, f, f},
					 { f, t, f, f, f, f},
					 { f, t, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 31:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, t, t, t, f, f},
					 { f, t, f, t, f, f},
					 { f, t, f, f, f, f},
					 { f, f, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 32:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, f, t, f, f},
					 { f, f, t, t, f, f},
					 { f, t, t, f, f, f},
					 { f, t, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 33:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, t, f, f},
					 { f, t, t, f, f, f},
					 { f, t, f, f, f, f},
					 { f, t, f, f, f, f},
					 { f, f, f, f, f, f}};
				case 34:
					tiles = new Tile[][]
					{{ f, f, f, f, f, f},
					 { f, f, t, t, f, f},
					 { f, f, t, f, f, f},
					 { f, t, t, f, f, f},
					 { f, t, f, f, f, f},
					 { f, f, f, f, f, f}};
			}
			pieces[i] = new Piece(tiles);
		}
		try
		{
			FileOutputStream saveFile = new FileOutputStream("pieces.data");
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.reset();
			save.writeObject(pieces);
			save.close();
		}
		catch (Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}
}
