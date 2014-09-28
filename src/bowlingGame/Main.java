package bowlingGame;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		GameSet game = new GameSet();
		
		Scanner scanner = new Scanner (System.in);
		System.out.print("몇명이서 치실거요?");  
		int playerNumber = scanner.nextInt();
		
		game.setPlayerNumber(playerNumber);
		game.makeScoreBoard();
		game.gameStart();
		
		scanner.close();
	}

}
