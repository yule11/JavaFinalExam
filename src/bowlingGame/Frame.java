package bowlingGame;

import java.util.Scanner;

public class Frame {

	Score score;
	
	int player;
	int frameNumber;
	
	int leftPins;
	boolean secondStrokeIsDone = false;
	
	boolean strike;
	boolean spare;
	
	Frame(int frameNumber,int player){
	
		this.frameNumber = frameNumber;
		this.player = player;
		score = new Score(this.frameNumber,this.player);
	}
	
	
	void firstStroke(int fallenPins){
		
		if ((fallenPins < 0) || (fallenPins > 10)){
			//다시치게 한다.
		} 
		
		score.recordScore(1,fallenPins);
		leftPins = 10-fallenPins;
		
		if(fallenPins == 10){
			strike = true;
			score.bonusCount = 2;
		}
	} 
	
	void secondStroke(int fallenPins){
		this.secondStrokeIsDone = true;
		
		if((fallenPins<0)||(fallenPins>leftPins)){
			//다시 치게한다.
		}
		
		score.recordScore(2,fallenPins);
		
		if(fallenPins == leftPins){
			spare = true;
			score.bonusCount = 1;
		}
	}
	
	
	/*value가 0부터 10사이 일때만 핀이 쓰러진 것으로 받아들인다. */
	int getStroke(int i)
	{
		int value = -1; 
		while((value < 0) || (value > 10)) { 
			System.out.print("스트로크"+i);
			Scanner scanner = new Scanner (System.in);
			if(scanner.hasNextInt()) {
				value = scanner.nextInt();
			}
		}
		return value;
	}
	
	
	//예비
	void displayScore(){
		System.out.println("총점:"+score.displayTotalScore());
		System.out.println("Strike : "+strike+" / Spare : "+spare);
		System.out.println("bonusCount"+score.bonusCount);
	}
	
	
	void frameIn(){
		System.out.println("player"+player+"님의"+frameNumber+"프레임");
	
		firstStroke(getStroke(1));
		if(leftPins != 0) secondStroke(getStroke(2));
	
		score.frameFinishCheck();
		displayScore();
	}
}
